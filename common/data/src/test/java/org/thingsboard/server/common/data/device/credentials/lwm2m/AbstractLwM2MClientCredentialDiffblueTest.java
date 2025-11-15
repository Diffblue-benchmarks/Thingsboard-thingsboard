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
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AbstractLwM2MClientCredentialDiffblueTest {
  /**
   * Method under test: {@link AbstractLwM2MClientCredential#getEndpoint()}
   */
  @Test
  void testGetEndpoint() {
    // Arrange, Act and Assert
    assertNull((new NoSecClientCredential()).getEndpoint());
  }

  /**
   * Method under test: {@link AbstractLwM2MClientCredential#setEndpoint(String)}
   */
  @Test
  void testSetEndpoint() {
    // Arrange
    NoSecClientCredential noSecClientCredential = new NoSecClientCredential();

    // Act
    noSecClientCredential.setEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    assertEquals("https://config.us-east-2.amazonaws.com", noSecClientCredential.getEndpoint());
  }
}
