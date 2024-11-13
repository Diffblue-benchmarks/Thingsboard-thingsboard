package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirmwareUpdateResultDiffblueTest {
  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code UPDATE_SUCCESSFULLY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByCode(int); when one; then return 'UPDATE_SUCCESSFULLY'")
  void testFromUpdateResultFwByCode_whenOne_thenReturnUpdateSuccessfully() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateResult.UPDATE_SUCCESSFULLY, FirmwareUpdateResult.fromUpdateResultFwByCode(1));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByCode(int); when ten; then throw IllegalArgumentException")
  void testFromUpdateResultFwByCode_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateResult.fromUpdateResultFwByCode(10));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}.
   * <ul>
   *   <li>When {@code Initial value}.</li>
   *   <li>Then return {@code INITIAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByType(String); when 'Initial value'; then return 'INITIAL'")
  void testFromUpdateResultFwByType_whenInitialValue_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateResult.INITIAL, FirmwareUpdateResult.fromUpdateResultFwByType("Initial value"));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByType(String); when 'Type'; then throw IllegalArgumentException")
  void testFromUpdateResultFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateResult.fromUpdateResultFwByType("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirmwareUpdateResult#getCode()}
   *   <li>{@link FirmwareUpdateResult#getType()}
   *   <li>{@link FirmwareUpdateResult#isAgain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    FirmwareUpdateResult valueOfResult = FirmwareUpdateResult.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();

    // Assert
    assertEquals("Initial value", actualType);
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isAgain());
  }
}
