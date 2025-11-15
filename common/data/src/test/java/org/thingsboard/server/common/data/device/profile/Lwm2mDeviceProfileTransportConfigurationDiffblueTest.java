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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.lwm2m.OtherConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MBootstrapServerCredential;

class Lwm2mDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrap(new ArrayList<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(new OtherConfiguration());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrapServerUpdateEnable(true);

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(mock(TelemetryMappingConfiguration.class));

    // Act and Assert
    assertNotEquals(lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceProfileTransportConfiguration(),
        "Different type to Lwm2mDeviceProfileTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link Lwm2mDeviceProfileTransportConfiguration}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#setBootstrap(List)}
   *   <li>
   * {@link Lwm2mDeviceProfileTransportConfiguration#setBootstrapServerUpdateEnable(boolean)}
   *   <li>
   * {@link Lwm2mDeviceProfileTransportConfiguration#setClientLwM2mSettings(OtherConfiguration)}
   *   <li>
   * {@link Lwm2mDeviceProfileTransportConfiguration#setObserveAttr(TelemetryMappingConfiguration)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getBootstrap()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getClientLwM2mSettings()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getObserveAttr()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getType()}
   *   <li>
   * {@link Lwm2mDeviceProfileTransportConfiguration#isBootstrapServerUpdateEnable()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Lwm2mDeviceProfileTransportConfiguration actualLwm2mDeviceProfileTransportConfiguration = new Lwm2mDeviceProfileTransportConfiguration();
    ArrayList<LwM2MBootstrapServerCredential> bootstrap = new ArrayList<>();
    actualLwm2mDeviceProfileTransportConfiguration.setBootstrap(bootstrap);
    actualLwm2mDeviceProfileTransportConfiguration.setBootstrapServerUpdateEnable(true);
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    actualLwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration();
    actualLwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    String actualToStringResult = actualLwm2mDeviceProfileTransportConfiguration.toString();
    List<LwM2MBootstrapServerCredential> actualBootstrap = actualLwm2mDeviceProfileTransportConfiguration
        .getBootstrap();
    OtherConfiguration actualClientLwM2mSettings = actualLwm2mDeviceProfileTransportConfiguration
        .getClientLwM2mSettings();
    TelemetryMappingConfiguration actualObserveAttr = actualLwm2mDeviceProfileTransportConfiguration.getObserveAttr();
    DeviceTransportType actualType = actualLwm2mDeviceProfileTransportConfiguration.getType();
    boolean actualIsBootstrapServerUpdateEnableResult = actualLwm2mDeviceProfileTransportConfiguration
        .isBootstrapServerUpdateEnable();

    // Assert that nothing has changed
    assertEquals("Lwm2mDeviceProfileTransportConfiguration(observeAttr=TelemetryMappingConfiguration(keyName=null,"
        + " observe=null, attribute=null, telemetry=null, attributeLwm2m=null), bootstrapServerUpdateEnable=true,"
        + " bootstrap=[], clientLwM2mSettings=OtherConfiguration(fwUpdateStrategy=null, swUpdateStrategy=null,"
        + " clientOnlyObserveAfterConnect=null, powerMode=null, psmActivityTimer=null, edrxCycle=null,"
        + " pagingTransmissionWindow=null, fwUpdateResource=null, swUpdateResource=null, defaultObjectIDVer=null"
        + "))", actualToStringResult);
    assertEquals(DeviceTransportType.LWM2M, actualType);
    assertTrue(actualBootstrap.isEmpty());
    assertTrue(actualIsBootstrapServerUpdateEnableResult);
    assertSame(bootstrap, actualBootstrap);
    assertSame(clientLwM2mSettings, actualClientLwM2mSettings);
    assertSame(observeAttr, actualObserveAttr);
  }
}
