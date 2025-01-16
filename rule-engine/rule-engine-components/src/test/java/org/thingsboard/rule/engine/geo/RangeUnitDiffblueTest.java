package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RangeUnitDiffblueTest {
  /**
   * Test {@link RangeUnit#fromKm(double)}.
   * <p>
   * Method under test: {@link RangeUnit#fromKm(double)}
   */
  @Test
  @DisplayName("Test fromKm(double)")
  void testFromKm() {
    // Arrange, Act and Assert
    assertEquals(10000.0d, RangeUnit.METER.fromKm(10.0d));
  }
}
