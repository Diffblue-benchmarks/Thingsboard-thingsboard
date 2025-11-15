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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class AzureIotHubUtilDiffblueTest {
  /**
   * Method under test: {@link AzureIotHubUtil#buildUsername(String, String)}
   */
  @Test
  void testBuildUsername() {
    // Arrange, Act and Assert
    assertEquals("localhost/42/?api-version=2018-06-30", AzureIotHubUtil.buildUsername("localhost", "42"));
  }

  /**
   * Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  void testBuildSasToken() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", "Sas Key"));
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", ""));
  }
}
