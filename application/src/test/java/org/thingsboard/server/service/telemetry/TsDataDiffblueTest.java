package org.thingsboard.server.service.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TsDataDiffblueTest {
  /**
   * Test {@link TsData#TsData(long, Object)}.
   * <p>
   * Method under test: {@link TsData#TsData(long, Object)}
   */
  @Test
  @DisplayName("Test new TsData(long, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsData.<init>(long, Object)"})
  void testNewTsData() {
    // Arrange and Act
    TsData actualTsData = new TsData(1L, "Value");

    // Assert
    assertEquals("Value", actualTsData.getValue());
    assertEquals(1L, actualTsData.getTs());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsData#getTs()}
   *   <li>{@link TsData#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TsData.getTs()", "Object TsData.getValue()"})
  void testGettersAndSetters() {
    // Arrange
    TsData tsData = new TsData(1L, "Value");

    // Act
    long actualTs = tsData.getTs();

    // Assert
    assertEquals("Value", tsData.getValue());
    assertEquals(1L, actualTs);
  }

  /**
   * Test {@link TsData#compareTo(TsData)} with {@code TsData}.
   * <ul>
   *   <li>When {@link TsData#TsData(long, Object)} with ts is one and {@code Value}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsData#compareTo(TsData)}
   */
  @Test
  @DisplayName("Test compareTo(TsData) with 'TsData'; when TsData(long, Object) with ts is one and 'Value'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TsData.compareTo(TsData)"})
  void testCompareToWithTsData_whenTsDataWithTsIsOneAndValue_thenReturnZero() {
    // Arrange
    TsData tsData = new TsData(1L, "Value");

    // Act and Assert
    assertEquals(0, tsData.compareTo(new TsData(1L, "Value")));
  }
}
