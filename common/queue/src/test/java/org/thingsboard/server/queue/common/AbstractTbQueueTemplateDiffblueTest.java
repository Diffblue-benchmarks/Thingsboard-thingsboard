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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class AbstractTbQueueTemplateDiffblueTest {
  /**
   * Method under test: {@link AbstractTbQueueTemplate#uuidToBytes(UUID)}
   */
  @Test
  void testUuidToBytes() {
    // Arrange
    AbstractTbQueueTemplate abstractTbQueueTemplate = new AbstractTbQueueTemplate();

    // Act and Assert
    assertEquals(Short.SIZE, abstractTbQueueTemplate.uuidToBytes(UUID.randomUUID()).length);
  }

  /**
   * Method under test: {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}
   */
  @Test
  void testBytesToUuid() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("41584158-4158-4158-4158-415841584158",
        AbstractTbQueueTemplate.bytesToUuid("AXAXAXAXAXAXAXAX".getBytes("UTF-8")).toString());
  }

  /**
   * Method under test: {@link AbstractTbQueueTemplate#stringToBytes(String)}
   */
  @Test
  void testStringToBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStringToBytesResult = (new AbstractTbQueueTemplate()).stringToBytes("String");

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualStringToBytesResult);
  }

  /**
   * Method under test: {@link AbstractTbQueueTemplate#bytesToString(byte[])}
   */
  @Test
  void testBytesToString() throws UnsupportedEncodingException {
    // Arrange
    AbstractTbQueueTemplate abstractTbQueueTemplate = new AbstractTbQueueTemplate();

    // Act and Assert
    assertEquals("AXAXAXAX", abstractTbQueueTemplate.bytesToString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link AbstractTbQueueTemplate#longToBytes(long)}
   */
  @Test
  void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, AbstractTbQueueTemplate.longToBytes(1L));
  }

  /**
   * Method under test: {@link AbstractTbQueueTemplate#bytesToLong(byte[])}
   */
  @Test
  void testBytesToLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, AbstractTbQueueTemplate.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }
}
