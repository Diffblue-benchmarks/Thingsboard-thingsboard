package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceApiControllerDiffblueTest {
  /**
   * Test {@link DeviceApiController#getName()}.
   *
   * <p>Method under test: {@link DeviceApiController#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DeviceApiController.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("HTTP", new DeviceApiController().getName());
  }
}
