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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.tools.TbRateLimits;

class SimpleTransportRateLimitDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleTransportRateLimit#SimpleTransportRateLimit(String)}
   */
  @Test
  void testNewSimpleTransportRateLimit() {
    // Arrange, Act and Assert
    assertEquals("42:42", (new SimpleTransportRateLimit("42:42")).getConfiguration());
  }

  /**
   * Method under test: {@link SimpleTransportRateLimit#tryConsume()}
   */
  @Test
  void testTryConsume() {
    // Arrange
    TbRateLimits rateLimit = mock(TbRateLimits.class);
    when(rateLimit.tryConsume()).thenReturn(true);

    // Act
    boolean actualTryConsumeResult = (new SimpleTransportRateLimit(rateLimit, "Configuration")).tryConsume();

    // Assert
    verify(rateLimit).tryConsume();
    assertTrue(actualTryConsumeResult);
  }

  /**
   * Method under test: {@link SimpleTransportRateLimit#tryConsume()}
   */
  @Test
  void testTryConsume2() {
    // Arrange
    TbRateLimits rateLimit = mock(TbRateLimits.class);
    when(rateLimit.tryConsume()).thenReturn(false);

    // Act
    boolean actualTryConsumeResult = (new SimpleTransportRateLimit(rateLimit, "Configuration")).tryConsume();

    // Assert
    verify(rateLimit).tryConsume();
    assertFalse(actualTryConsumeResult);
  }

  /**
   * Method under test: {@link SimpleTransportRateLimit#tryConsume(long)}
   */
  @Test
  void testTryConsume3() {
    // Arrange, Act and Assert
    assertTrue((new SimpleTransportRateLimit(null, "Configuration")).tryConsume(0L));
  }
}
