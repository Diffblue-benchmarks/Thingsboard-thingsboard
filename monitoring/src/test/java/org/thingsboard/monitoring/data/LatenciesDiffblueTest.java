package org.thingsboard.monitoring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LatenciesDiffblueTest {
  /**
   * Test {@link Latencies#request(String)}.
   * <p>
   * Method under test: {@link Latencies#request(String)}
   */
  @Test
  @DisplayName("Test request(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Latencies.request(String)"})
  void testRequest() {
    // Arrange, Act and Assert
    assertEquals("KeyRequest", Latencies.request("Key"));
  }

  /**
   * Test {@link Latencies#wsUpdate(String)}.
   * <p>
   * Method under test: {@link Latencies#wsUpdate(String)}
   */
  @Test
  @DisplayName("Test wsUpdate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Latencies.wsUpdate(String)"})
  void testWsUpdate() {
    // Arrange, Act and Assert
    assertEquals("KeyWsUpdate", Latencies.wsUpdate("Key"));
  }
}
