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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultTbQueueMsgHeadersDiffblueTest {
  /**
   * Test {@link DefaultTbQueueMsgHeaders#put(String, byte[])}.
   * <p>
   * Method under test: {@link DefaultTbQueueMsgHeaders#put(String, byte[])}
   */
  @Test
  @DisplayName("Test put(String, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DefaultTbQueueMsgHeaders.put(String, byte[])"})
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
   * Test {@link DefaultTbQueueMsgHeaders#get(String)}.
   * <p>
   * Method under test: {@link DefaultTbQueueMsgHeaders#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DefaultTbQueueMsgHeaders.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbQueueMsgHeaders()).get("Key"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultTbQueueMsgHeaders}
   *   <li>{@link DefaultTbQueueMsgHeaders#getData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueMsgHeaders.<init>()", "Map DefaultTbQueueMsgHeaders.getData()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new DefaultTbQueueMsgHeaders()).getData().isEmpty());
  }
}
