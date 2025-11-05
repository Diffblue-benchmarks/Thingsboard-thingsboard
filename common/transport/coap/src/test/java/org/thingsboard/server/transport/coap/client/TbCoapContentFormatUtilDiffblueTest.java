package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCoapContentFormatUtilDiffblueTest {
  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbCoapContentFormatUtil.getContentFormat(int, int)"})
  void testGetContentFormat_whenFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(42, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when minus one; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbCoapContentFormatUtil.getContentFormat(int, int)"})
  void testGetContentFormat_whenMinusOne_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(-1, 42));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when minus one; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbCoapContentFormatUtil.getContentFormat(int, int)"})
  void testGetContentFormat_whenMinusOne_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(-1, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#getContentFormat(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  @DisplayName("Test getContentFormat(int, int); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbCoapContentFormatUtil.getContentFormat(int, int)"})
  void testGetContentFormat_whenThree_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(3, 3));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#isStrict(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#isStrict(int)}
   */
  @Test
  @DisplayName("Test isStrict(int); when forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCoapContentFormatUtil.isStrict(int)"})
  void testIsStrict_whenFortyTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TbCoapContentFormatUtil.isStrict(42));
  }

  /**
   * Test {@link TbCoapContentFormatUtil#isStrict(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapContentFormatUtil#isStrict(int)}
   */
  @Test
  @DisplayName("Test isStrict(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbCoapContentFormatUtil.isStrict(int)"})
  void testIsStrict_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TbCoapContentFormatUtil.isStrict(1));
  }
}
