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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.CoapDeviceType;
import org.thingsboard.server.common.data.TransportPayloadType;

class DefaultCoapDeviceTypeConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  void testGetTransportPayloadTypeConfiguration() {
    // Arrange and Act
    TransportPayloadTypeConfiguration actualTransportPayloadTypeConfiguration = (new DefaultCoapDeviceTypeConfiguration())
        .getTransportPayloadTypeConfiguration();
    TransportPayloadType actualTransportPayloadType = actualTransportPayloadTypeConfiguration.getTransportPayloadType();

    // Assert
    assertTrue(actualTransportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadTypeConfiguration.getTransportPayloadType());
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Method under test:
   * {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  void testGetTransportPayloadTypeConfiguration2() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    // Act
    TransportPayloadTypeConfiguration actualTransportPayloadTypeConfiguration = defaultCoapDeviceTypeConfiguration
        .getTransportPayloadTypeConfiguration();
    TransportPayloadType actualTransportPayloadType = actualTransportPayloadTypeConfiguration.getTransportPayloadType();

    // Assert
    assertTrue(actualTransportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadTypeConfiguration.getTransportPayloadType());
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Method under test:
   * {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  void testGetTransportPayloadTypeConfiguration3() {
    // Arrange
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = mock(TransportPayloadTypeConfiguration.class);
    when(transportPayloadTypeConfiguration.getTransportPayloadType()).thenReturn(TransportPayloadType.JSON);

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(transportPayloadTypeConfiguration);

    // Act
    TransportPayloadType actualTransportPayloadType = defaultCoapDeviceTypeConfiguration
        .getTransportPayloadTypeConfiguration()
        .getTransportPayloadType();

    // Assert
    verify(transportPayloadTypeConfiguration).getTransportPayloadType();
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2.setTransportPayloadTypeConfiguration(new JsonTransportPayloadConfiguration());

    // Act and Assert
    assertEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
    int expectedHashCodeResult = defaultCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultCoapDeviceTypeConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration);
    int expectedHashCodeResult = defaultCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultCoapDeviceTypeConfiguration.hashCode());
  }

  /**
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
  }

  /**
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
  }

  /**
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, null);
  }

  /**
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, "Different type to DefaultCoapDeviceTypeConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultCoapDeviceTypeConfiguration}
   *   <li>
   * {@link DefaultCoapDeviceTypeConfiguration#setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#toString()}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#getCoapDeviceType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultCoapDeviceTypeConfiguration actualDefaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    actualDefaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));
    actualDefaultCoapDeviceTypeConfiguration.toString();

    // Assert that nothing has changed
    assertEquals(CoapDeviceType.DEFAULT, actualDefaultCoapDeviceTypeConfiguration.getCoapDeviceType());
  }
}
