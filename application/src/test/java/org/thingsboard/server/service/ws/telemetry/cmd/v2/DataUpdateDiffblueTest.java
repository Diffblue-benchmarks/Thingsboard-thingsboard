package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataUpdateDiffblueTest {
  /**
   * Test {@link DataUpdate#getData()}.
   * <p>
   * Method under test: {@link DataUpdate#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.page.PageData DataUpdate.getData()"})
  void testGetData() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataUpdate(1, -1, "An error occurred")).getData());
  }

  /**
   * Test {@link DataUpdate#getUpdate()}.
   * <p>
   * Method under test: {@link DataUpdate#getUpdate()}
   */
  @Test
  @DisplayName("Test getUpdate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List DataUpdate.getUpdate()"})
  void testGetUpdate() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataUpdate(1, -1, "An error occurred")).getUpdate());
  }
}
