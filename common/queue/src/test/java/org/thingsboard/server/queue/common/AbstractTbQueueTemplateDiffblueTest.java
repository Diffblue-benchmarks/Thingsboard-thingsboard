package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractTbQueueTemplateDiffblueTest {
  /**
   * Test {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}.
   * <ul>
   *   <li>Then return toString is
   * {@code 41584158-4158-4158-4158-415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#bytesToUuid(byte[])}
   */
  @Test
  @DisplayName("Test bytesToUuid(byte[]); then return toString is '41584158-4158-4158-4158-415841584158'")
  void testBytesToUuid_thenReturnToStringIs41584158415841584158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("41584158-4158-4158-4158-415841584158",
        AbstractTbQueueTemplate.bytesToUuid("AXAXAXAXAXAXAXAX".getBytes("UTF-8")).toString());
  }

  /**
   * Test {@link AbstractTbQueueTemplate#longToBytes(long)}.
   * <p>
   * Method under test: {@link AbstractTbQueueTemplate#longToBytes(long)}
   */
  @Test
  @DisplayName("Test longToBytes(long)")
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
  void testBytesToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, AbstractTbQueueTemplate.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test new {@link AbstractTbQueueTemplate} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractTbQueueTemplate}
   */
  @Test
  @DisplayName("Test new AbstractTbQueueTemplate (default constructor)")
  void testNewAbstractTbQueueTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new AbstractTbQueueTemplate();
  }
}
