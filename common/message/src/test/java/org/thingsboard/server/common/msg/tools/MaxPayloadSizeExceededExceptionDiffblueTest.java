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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MaxPayloadSizeExceededExceptionDiffblueTest {
  /**
   * Test {@link MaxPayloadSizeExceededException#MaxPayloadSizeExceededException(long)}.
   * <p>
   * Method under test: {@link MaxPayloadSizeExceededException#MaxPayloadSizeExceededException(long)}
   */
  @Test
  @DisplayName("Test new MaxPayloadSizeExceededException(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MaxPayloadSizeExceededException.<init>(long)"})
  void testNewMaxPayloadSizeExceededException() {
    // Arrange and Act
    MaxPayloadSizeExceededException actualMaxPayloadSizeExceededException = new MaxPayloadSizeExceededException(1L);

    // Assert
    assertEquals("Payload size exceeds the limit of 1 bytes",
        actualMaxPayloadSizeExceededException.getLocalizedMessage());
    assertEquals("Payload size exceeds the limit of 1 bytes", actualMaxPayloadSizeExceededException.getMessage());
    assertNull(actualMaxPayloadSizeExceededException.getCause());
    assertEquals(0, actualMaxPayloadSizeExceededException.getSuppressed().length);
    assertEquals(1L, actualMaxPayloadSizeExceededException.getLimit());
  }

  /**
   * Test {@link MaxPayloadSizeExceededException#getLimit()}.
   * <p>
   * Method under test: {@link MaxPayloadSizeExceededException#getLimit()}
   */
  @Test
  @DisplayName("Test getLimit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MaxPayloadSizeExceededException.getLimit()"})
  void testGetLimit() {
    // Arrange, Act and Assert
    assertEquals(1L, (new MaxPayloadSizeExceededException(1L)).getLimit());
  }
}
