package org.thingsboard.server.transport.coap.efento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PulseCounterTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PulseCounterType#getMajorResolution()}
   *   <li>{@link PulseCounterType#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PulseCounterType.getMajorResolution()",
    "java.lang.String PulseCounterType.getPrefix()"
  })
  void testGettersAndSetters() {
    // Arrange
    PulseCounterType valueOfResult = PulseCounterType.valueOf("WATER_CNT_ACC");

    // Act
    int actualMajorResolution = valueOfResult.getMajorResolution();

    // Assert
    assertEquals("water_cnt_acc_", valueOfResult.getPrefix());
    assertEquals(100, actualMajorResolution);
  }
}
