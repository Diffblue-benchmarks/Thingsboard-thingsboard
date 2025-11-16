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
package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrivacyProtocolDiffblueTest {
  /**
   * Test {@link PrivacyProtocol#forName(String)}.
   *
   * <ul>
   *   <li>When {@code AES_128}.
   *   <li>Then return {@link Optional#get()} is {@code AES_128}.
   * </ul>
   *
   * <p>Method under test: {@link PrivacyProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'AES_128'; then return get() is 'AES_128'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PrivacyProtocol.forName(String)"})
  void testForName_whenAes128_thenReturnGetIsAes128() {
    // Arrange and Act
    Optional<PrivacyProtocol> actualForNameResult = PrivacyProtocol.forName("AES_128");

    // Assert
    assertEquals(PrivacyProtocol.AES_128, actualForNameResult.get());
    assertTrue(actualForNameResult.isPresent());
  }

  /**
   * Test {@link PrivacyProtocol#forName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link PrivacyProtocol#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PrivacyProtocol.forName(String)"})
  void testForName_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<PrivacyProtocol> actualForNameResult = PrivacyProtocol.forName("Name");

    // Assert
    assertFalse(actualForNameResult.isPresent());
  }
}
