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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AzureIotHubUtilDiffblueTest {
  /**
   * Test {@link AzureIotHubUtil#buildUsername(String, String)}.
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildUsername(String, String)}
   */
  @Test
  @DisplayName("Test buildUsername(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildUsername(String, String)"})
  void testBuildUsername() {
    // Arrange, Act and Assert
    assertEquals("localhost/42/?api-version=2018-06-30", AzureIotHubUtil.buildUsername("localhost", "42"));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when empty string; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildSasToken(String, String)"})
  void testBuildSasToken_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", ""));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   * <ul>
   *   <li>When {@code Sas Key}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when 'Sas Key'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildSasToken(String, String)"})
  void testBuildSasToken_whenSasKey_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", "Sas Key"));
  }
}
