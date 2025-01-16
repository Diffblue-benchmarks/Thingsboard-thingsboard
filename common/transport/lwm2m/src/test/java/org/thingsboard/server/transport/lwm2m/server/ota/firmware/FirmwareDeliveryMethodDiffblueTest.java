package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirmwareDeliveryMethodDiffblueTest {
  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PUSH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when one; then return 'PUSH'")
  void testFromStateFwByCode_whenOne_thenReturnPush() {
    // Arrange, Act and Assert
    assertEquals(FirmwareDeliveryMethod.PUSH, FirmwareDeliveryMethod.fromStateFwByCode(1));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when three; then throw IllegalArgumentException")
  void testFromStateFwByCode_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByCode(3));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByType(String)}.
   * <ul>
   *   <li>When {@code Pull only}.</li>
   *   <li>Then return {@code PULL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Pull only'; then return 'PULL'")
  void testFromStateFwByType_whenPullOnly_thenReturnPull() {
    // Arrange, Act and Assert
    assertEquals(FirmwareDeliveryMethod.PULL, FirmwareDeliveryMethod.fromStateFwByType("Pull only"));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareDeliveryMethod#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Type'; then throw IllegalArgumentException")
  void testFromStateFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByType("Type"));
  }
}
