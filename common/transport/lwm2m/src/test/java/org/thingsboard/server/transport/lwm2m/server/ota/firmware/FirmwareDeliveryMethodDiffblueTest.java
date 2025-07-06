package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FirmwareDeliveryMethodDiffblueTest {
  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Pull only}.
   *   <li>Then return {@code PULL}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareDeliveryMethod#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Pull only'; then return 'PULL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FirmwareDeliveryMethod FirmwareDeliveryMethod.fromStateFwByType(String)"})
  void testFromStateFwByType_whenPullOnly_thenReturnPull() {
    // Arrange, Act and Assert
    assertEquals(
        FirmwareDeliveryMethod.PULL, FirmwareDeliveryMethod.fromStateFwByType("Pull only"));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareDeliveryMethod#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FirmwareDeliveryMethod FirmwareDeliveryMethod.fromStateFwByType(String)"})
  void testFromStateFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByType("Type"));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code PUSH}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when one; then return 'PUSH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FirmwareDeliveryMethod FirmwareDeliveryMethod.fromStateFwByCode(int)"})
  void testFromStateFwByCode_whenOne_thenReturnPush() {
    // Arrange, Act and Assert
    assertEquals(FirmwareDeliveryMethod.PUSH, FirmwareDeliveryMethod.fromStateFwByCode(1));
  }

  /**
   * Test {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareDeliveryMethod#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when three; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FirmwareDeliveryMethod FirmwareDeliveryMethod.fromStateFwByCode(int)"})
  void testFromStateFwByCode_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareDeliveryMethod.fromStateFwByCode(3));
  }
}
