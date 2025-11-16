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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractTbQueueTemplateDiffblueTest {
  /**
   * Test {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}.
   *
   * <ul>
   *   <li>Then return toString is {@code 41584158-4158-4158-4158-415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}
   */
  @Test
  @DisplayName(
      "Test bytesToUuid(byte[]); then return toString is '41584158-4158-4158-4158-415841584158'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.UUID AbstractTbQueueTemplate.bytesToUuid(byte[])"})
  void testBytesToUuid_thenReturnToStringIs41584158415841584158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "41584158-4158-4158-4158-415841584158",
        AbstractTbQueueTemplate.bytesToUuid("AXAXAXAXAXAXAXAX".getBytes("UTF-8")).toString());
  }

  /**
   * Test {@link AbstractTbQueueTemplate#stringToBytes(String)}.
   *
   * <p>Method under test: {@link AbstractTbQueueTemplate#stringToBytes(String)}
   */
  @Test
  @DisplayName("Test stringToBytes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractTbQueueTemplate.stringToBytes(String)"})
  void testStringToBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "String".getBytes("UTF-8"), new AbstractTbQueueTemplate().stringToBytes("String"));
  }

  /**
   * Test {@link AbstractTbQueueTemplate#bytesToString(byte[])}.
   *
   * <p>Method under test: {@link AbstractTbQueueTemplate#bytesToString(byte[])}
   */
  @Test
  @DisplayName("Test bytesToString(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTbQueueTemplate.bytesToString(byte[])"})
  void testBytesToString() throws UnsupportedEncodingException {
    // Arrange and Act
    String actualBytesToStringResult =
        new AbstractTbQueueTemplate().bytesToString("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("AXAXAXAX", actualBytesToStringResult);
  }

  /**
   * Test {@link AbstractTbQueueTemplate#longToBytes(long)}.
   *
   * <p>Method under test: {@link AbstractTbQueueTemplate#longToBytes(long)}
   */
  @Test
  @DisplayName("Test longToBytes(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractTbQueueTemplate.longToBytes(long)"})
  void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 1}, AbstractTbQueueTemplate.longToBytes(1L));
  }

  /**
   * Test {@link AbstractTbQueueTemplate#bytesToLong(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueTemplate#bytesToLong(byte[])}
   */
  @Test
  @DisplayName(
      "Test bytesToLong(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '4708585257725083992'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractTbQueueTemplate.bytesToLong(byte[])"})
  void testBytesToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        4708585257725083992L, AbstractTbQueueTemplate.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }
}
