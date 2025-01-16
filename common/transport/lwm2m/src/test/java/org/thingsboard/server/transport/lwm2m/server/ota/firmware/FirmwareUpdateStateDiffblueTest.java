package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirmwareUpdateStateDiffblueTest {
  /**
   * Test {@link FirmwareUpdateState#fromStateFwByCode(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateState#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when four; then throw IllegalArgumentException")
  void testFromStateFwByCode_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateState.fromStateFwByCode(4));
  }

  /**
   * Test {@link FirmwareUpdateState#fromStateFwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DOWNLOADING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateState#fromStateFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStateFwByCode(int); when one; then return 'DOWNLOADING'")
  void testFromStateFwByCode_whenOne_thenReturnDownloading() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateState.DOWNLOADING, FirmwareUpdateState.fromStateFwByCode(1));
  }

  /**
   * Test {@link FirmwareUpdateState#fromStateFwByType(String)}.
   * <ul>
   *   <li>When {@code Idle}.</li>
   *   <li>Then return {@code IDLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateState#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Idle'; then return 'IDLE'")
  void testFromStateFwByType_whenIdle_thenReturnIdle() {
    // Arrange, Act and Assert
    assertEquals(FirmwareUpdateState.IDLE, FirmwareUpdateState.fromStateFwByType("Idle"));
  }

  /**
   * Test {@link FirmwareUpdateState#fromStateFwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirmwareUpdateState#fromStateFwByType(String)}
   */
  @Test
  @DisplayName("Test fromStateFwByType(String); when 'Type'; then throw IllegalArgumentException")
  void testFromStateFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FirmwareUpdateState.fromStateFwByType("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirmwareUpdateState#getCode()}
   *   <li>{@link FirmwareUpdateState#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    FirmwareUpdateState valueOfResult = FirmwareUpdateState.valueOf("IDLE");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("Idle", valueOfResult.getType());
    assertEquals(0, actualCode);
  }
}
