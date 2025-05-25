package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MFirmwareUpdateStrategyDiffblueTest {
  /**
   * Test {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByType(String)}.
   * <ul>
   *   <li>When {@code ObjectId 5, Binary}.</li>
   *   <li>Then return {@code OBJ_5_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStrategyFwByType(String); when 'ObjectId 5, Binary'; then return 'OBJ_5_BINARY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MFirmwareUpdateStrategy LwM2MFirmwareUpdateStrategy.fromStrategyFwByType(String)"})
  void testFromStrategyFwByType_whenObjectId5Binary_thenReturnObj5Binary() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY,
        LwM2MFirmwareUpdateStrategy.fromStrategyFwByType("ObjectId 5, Binary"));
  }

  /**
   * Test {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStrategyFwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MFirmwareUpdateStrategy LwM2MFirmwareUpdateStrategy.fromStrategyFwByType(String)"})
  void testFromStrategyFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MFirmwareUpdateStrategy.fromStrategyFwByType("Type"));
  }

  /**
   * Test {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code OBJ_5_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategyFwByCode(int); when one; then return 'OBJ_5_BINARY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MFirmwareUpdateStrategy LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(int)"})
  void testFromStrategyFwByCode_whenOne_thenReturnObj5Binary() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY, LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(1));
  }

  /**
   * Test {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code OBJ_19_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategyFwByCode(int); when three; then return 'OBJ_19_BINARY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MFirmwareUpdateStrategy LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(int)"})
  void testFromStrategyFwByCode_whenThree_thenReturnObj19Binary() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_19_BINARY, LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(3));
  }

  /**
   * Test {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MFirmwareUpdateStrategy#fromStrategyFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategyFwByCode(int); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MFirmwareUpdateStrategy LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(int)"})
  void testFromStrategyFwByCode_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LwM2MFirmwareUpdateStrategy.fromStrategyFwByCode(0));
  }
}
