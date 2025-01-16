package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmData;

class DataUpdateDiffblueTest {
  /**
   * Test {@link DataUpdate#getData()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataUpdate#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return 'null'")
  void testGetData_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmDataUpdate(1, -1, "An error occurred")).getData());
  }

  /**
   * Test {@link DataUpdate#getUpdate()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataUpdate#getUpdate()}
   */
  @Test
  @DisplayName("Test getUpdate(); then return Empty")
  void testGetUpdate_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<AlarmData> data = mock(PageData.class);

    // Act and Assert
    assertTrue((new AlarmDataUpdate(1, data, new ArrayList<>(), 1L, 1L)).getUpdate().isEmpty());
  }

  /**
   * Test {@link DataUpdate#getUpdate()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataUpdate#getUpdate()}
   */
  @Test
  @DisplayName("Test getUpdate(); then return 'null'")
  void testGetUpdate_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AlarmDataUpdate(1, -1, "An error occurred")).getUpdate());
  }
}
