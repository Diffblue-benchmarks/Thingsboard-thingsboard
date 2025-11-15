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
package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DefaultTbQueueMsgHeadersDiffblueTest {
  /**
   * Method under test: {@link DefaultTbQueueMsgHeaders#put(String, byte[])}
   */
  @Test
  void testPut() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsgHeaders defaultTbQueueMsgHeaders = new DefaultTbQueueMsgHeaders();
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(defaultTbQueueMsgHeaders.put("Key", value));
    Map<String, byte[]> data = defaultTbQueueMsgHeaders.getData();
    assertEquals(1, data.size());
    assertSame(value, data.get("Key"));
  }

  /**
   * Method under test: {@link DefaultTbQueueMsgHeaders#get(String)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbQueueMsgHeaders()).get("Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultTbQueueMsgHeaders}
   *   <li>{@link DefaultTbQueueMsgHeaders#getData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DefaultTbQueueMsgHeaders()).getData().isEmpty());
  }
}
