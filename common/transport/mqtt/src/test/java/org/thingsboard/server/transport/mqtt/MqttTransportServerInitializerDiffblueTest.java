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
package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class MqttTransportServerInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}
   */
  @Test
  void testNewMqttTransportServerInitializer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MqttTransportServerInitializer(new MqttTransportContext(), true)).isSharable());
    assertTrue((new MqttTransportServerInitializer(mock(MqttTransportContext.class), true)).isSharable());
  }
}
