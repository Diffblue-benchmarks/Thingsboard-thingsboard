package org.thingsboard.server.transport.lwm2m.server.ota.software;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SoftwareUpdateStateDiffblueTest {
  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Initial}.
   *   <li>Then return {@code INITIAL}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByType(String); when 'Initial'; then return 'INITIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByType(String)"})
  void testFromUpdateStateSwByType_whenInitial_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(
        SoftwareUpdateState.INITIAL, SoftwareUpdateState.fromUpdateStateSwByType("Initial"));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName(
      "Test fromUpdateStateSwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByType(String)"})
  void testFromUpdateStateSwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByType("Type"));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when five; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByCode(int)"})
  void testFromUpdateStateSwByCode_whenFive_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByCode(5));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code DOWNLOAD_STARTED}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when one; then return 'DOWNLOAD_STARTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByCode(int)"})
  void testFromUpdateStateSwByCode_whenOne_thenReturnDownloadStarted() {
    // Arrange, Act and Assert
    assertEquals(
        SoftwareUpdateState.DOWNLOAD_STARTED, SoftwareUpdateState.fromUpdateStateSwByCode(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SoftwareUpdateState#getCode()}
   *   <li>{@link SoftwareUpdateState#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SoftwareUpdateState.getCode()", "String SoftwareUpdateState.getType()"})
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
