package org.thingsboard.server.service.ws.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TelemetryFeatureDiffblueTest {
  /**
   * Test {@link TelemetryFeature#forName(String)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES}.</li>
   *   <li>Then return {@code ATTRIBUTES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryFeature#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'ATTRIBUTES'; then return 'ATTRIBUTES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryFeature TelemetryFeature.forName(String)"})
  void testForName_whenAttributes_thenReturnAttributes() {
    // Arrange, Act and Assert
    assertEquals(TelemetryFeature.ATTRIBUTES, TelemetryFeature.forName("ATTRIBUTES"));
  }
}
