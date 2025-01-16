package org.thingsboard.server.transport.lwm2m.server.ota.software;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SoftwareUpdateStateDiffblueTest {
  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when five; then throw IllegalArgumentException")
  void testFromUpdateStateSwByCode_whenFive_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByCode(5));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DOWNLOAD_STARTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when one; then return 'DOWNLOAD_STARTED'")
  void testFromUpdateStateSwByCode_whenOne_thenReturnDownloadStarted() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateState.DOWNLOAD_STARTED, SoftwareUpdateState.fromUpdateStateSwByCode(1));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   * <ul>
   *   <li>When {@code Initial}.</li>
   *   <li>Then return {@code INITIAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByType(String); when 'Initial'; then return 'INITIAL'")
  void testFromUpdateStateSwByType_whenInitial_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateState.INITIAL, SoftwareUpdateState.fromUpdateStateSwByType("Initial"));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByType(String); when 'Type'; then throw IllegalArgumentException")
  void testFromUpdateStateSwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByType("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SoftwareUpdateState#getCode()}
   *   <li>{@link SoftwareUpdateState#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SoftwareUpdateState valueOfResult = SoftwareUpdateState.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("Initial", valueOfResult.getType());
    assertEquals(0, actualCode);
  }
}
