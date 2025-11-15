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
package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TbRateLimitsDiffblueTest {
  /**
   * Method under test: {@link TbRateLimits#TbRateLimits(String)}
   */
  @Test
  void testNewTbRateLimits() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(","));
    assertEquals("42:42", (new TbRateLimits("42:42")).getConfiguration());
    assertThrows(IllegalArgumentException.class, () -> new TbRateLimits(",", true));
  }

  /**
   * Method under test: {@link TbRateLimits#tryConsume()}
   */
  @Test
  void testTryConsume() {
    // Arrange, Act and Assert
    assertTrue((new TbRateLimits("42:42")).tryConsume());
    assertTrue((new TbRateLimits("42:42")).tryConsume(1L));
    assertTrue((new TbRateLimits("42:42")).tryConsume(5L));
    assertFalse((new TbRateLimits("42:42")).tryConsume(Long.MAX_VALUE));
  }
}
