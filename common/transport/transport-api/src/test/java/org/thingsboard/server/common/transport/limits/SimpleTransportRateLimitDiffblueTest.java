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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleTransportRateLimitDiffblueTest {
  /**
   * Test {@link SimpleTransportRateLimit#SimpleTransportRateLimit(String)}.
   * <ul>
   *   <li>When {@code 42:42}.</li>
   *   <li>Then return Configuration is {@code 42:42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTransportRateLimit#SimpleTransportRateLimit(String)}
   */
  @Test
  @DisplayName("Test new SimpleTransportRateLimit(String); when '42:42'; then return Configuration is '42:42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SimpleTransportRateLimit.<init>(String)"})
  void testNewSimpleTransportRateLimit_when4242_thenReturnConfigurationIs4242() {
    // Arrange, Act and Assert
    assertEquals("42:42", (new SimpleTransportRateLimit("42:42")).getConfiguration());
  }

  /**
   * Test {@link SimpleTransportRateLimit#tryConsume(long)} with {@code long}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTransportRateLimit#tryConsume(long)}
   */
  @Test
  @DisplayName("Test tryConsume(long) with 'long'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SimpleTransportRateLimit.tryConsume(long)"})
  void testTryConsumeWithLong_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SimpleTransportRateLimit(null, "Configuration")).tryConsume(0L));
  }
}
