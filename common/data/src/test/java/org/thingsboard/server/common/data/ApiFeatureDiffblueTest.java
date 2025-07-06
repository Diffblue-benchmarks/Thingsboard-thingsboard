package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiFeatureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiFeature#getApiStateKey()}
   *   <li>{@link ApiFeature#getLabel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiFeature.getApiStateKey()", "String ApiFeature.getLabel()"})
  void testGettersAndSetters() {
    // Arrange
    ApiFeature valueOfResult = ApiFeature.valueOf("TRANSPORT");

    // Act
    String actualApiStateKey = valueOfResult.getApiStateKey();

    // Assert
    assertEquals("Device API", valueOfResult.getLabel());
    assertEquals("transportApiState", actualApiStateKey);
  }
}
