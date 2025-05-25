package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractTbQueueTemplateDiffblueTest {
  /**
   * Test {@link AbstractTbQueueTemplate#uuidToBytes(UUID)}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code x} and {@code O}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#uuidToBytes(UUID)}
   */
  @Test
  @DisplayName("Test uuidToBytes(UUID); then return array of byte with 'x' and 'O'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractTbQueueTemplate.uuidToBytes(UUID)"})
  void testUuidToBytes_thenReturnArrayOfByteWithXAndO() {
    // Arrange
    AbstractTbQueueTemplate abstractTbQueueTemplate = new AbstractTbQueueTemplate();

    // Act and Assert
    assertArrayEquals(new byte[]{'x', 'O', '9', 'L', 'B', -74, 'C', 'Z', -104, '<', -73, -66, -1, '\'', -124, -7},
        abstractTbQueueTemplate.uuidToBytes(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}.
   * <ul>
   *   <li>Then return toString is {@code 41584158-4158-4158-4158-415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}
   */
  @Test
  @DisplayName("Test bytesToUuid(byte[]); then return toString is '41584158-4158-4158-4158-415841584158'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractTbQueueTemplate.bytesToUuid(byte[])"})
  void testBytesToUuid_thenReturnToStringIs41584158415841584158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("41584158-4158-4158-4158-415841584158",
        AbstractTbQueueTemplate.bytesToUuid("AXAXAXAXAXAXAXAX".getBytes("UTF-8")).toString());
  }

  /**
   * Test {@link AbstractTbQueueTemplate#stringToBytes(String)}.
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#stringToBytes(String)}
   */
  @Test
  @DisplayName("Test stringToBytes(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractTbQueueTemplate.stringToBytes(String)"})
  void testStringToBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStringToBytesResult = (new AbstractTbQueueTemplate()).stringToBytes("String");

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualStringToBytesResult);
  }

  /**
   * Test {@link AbstractTbQueueTemplate#bytesToString(byte[])}.
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#bytesToString(byte[])}
   */
  @Test
  @DisplayName("Test bytesToString(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTbQueueTemplate.bytesToString(byte[])"})
  void testBytesToString() throws UnsupportedEncodingException {
    // Arrange
    AbstractTbQueueTemplate abstractTbQueueTemplate = new AbstractTbQueueTemplate();

    // Act and Assert
    assertEquals("AXAXAXAX", abstractTbQueueTemplate.bytesToString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AbstractTbQueueTemplate#longToBytes(long)}.
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#longToBytes(long)}
   */
  @Test
  @DisplayName("Test longToBytes(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractTbQueueTemplate.longToBytes(long)"})
  void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, AbstractTbQueueTemplate.longToBytes(1L));
  }

  /**
   * Test {@link AbstractTbQueueTemplate#bytesToLong(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#bytesToLong(byte[])}
   */
  @Test
  @DisplayName("Test bytesToLong(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '4708585257725083992'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AbstractTbQueueTemplate.bytesToLong(byte[])"})
  void testBytesToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, AbstractTbQueueTemplate.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }
}
