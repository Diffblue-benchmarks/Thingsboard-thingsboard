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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TransportPayloadType;

class JsonTransportPayloadConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsonTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link JsonTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration = new JsonTransportPayloadConfiguration();
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration2 = new JsonTransportPayloadConfiguration();

    // Act and Assert
    assertEquals(jsonTransportPayloadConfiguration, jsonTransportPayloadConfiguration2);
    int expectedHashCodeResult = jsonTransportPayloadConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, jsonTransportPayloadConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsonTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link JsonTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration = new JsonTransportPayloadConfiguration();

    // Act and Assert
    assertEquals(jsonTransportPayloadConfiguration, jsonTransportPayloadConfiguration);
    int expectedHashCodeResult = jsonTransportPayloadConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, jsonTransportPayloadConfiguration.hashCode());
  }

  /**
   * Method under test: {@link JsonTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonTransportPayloadConfiguration(), 1);
  }

  /**
   * Method under test: {@link JsonTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonTransportPayloadConfiguration(), null);
  }

  /**
   * Method under test: {@link JsonTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonTransportPayloadConfiguration(), "Different type to JsonTransportPayloadConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link JsonTransportPayloadConfiguration}
   *   <li>{@link JsonTransportPayloadConfiguration#toString()}
   *   <li>{@link JsonTransportPayloadConfiguration#getTransportPayloadType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JsonTransportPayloadConfiguration actualJsonTransportPayloadConfiguration = new JsonTransportPayloadConfiguration();
    String actualToStringResult = actualJsonTransportPayloadConfiguration.toString();

    // Assert
    assertEquals("JsonTransportPayloadConfiguration()", actualToStringResult);
    assertEquals(TransportPayloadType.JSON, actualJsonTransportPayloadConfiguration.getTransportPayloadType());
  }
}
