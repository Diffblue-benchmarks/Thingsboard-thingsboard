package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbCoapContentFormatUtilDiffblueTest {
  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when forty-two; then return forty-two")
  void testGetContentFormat_whenFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(42, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when minus one; then return forty-two")
  void testGetContentFormat_whenMinusOne_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(-1, 42));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when minus one; then return three")
  void testGetContentFormat_whenMinusOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(-1, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when three; then return three")
  void testGetContentFormat_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(3, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#isStrict(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#isStrict(int)}
   */
  @Test
  @DisplayName("Test isStrict(int); when forty-two; then return 'true'")
  void testIsStrict_whenFortyTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TbCoapContentFormatUtil.isStrict(42));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#isStrict(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapContentFormatUtil#isStrict(int)}
   */
  @Test
  @DisplayName("Test isStrict(int); when one; then return 'false'")
  void testIsStrict_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TbCoapContentFormatUtil.isStrict(1));
  }
}
