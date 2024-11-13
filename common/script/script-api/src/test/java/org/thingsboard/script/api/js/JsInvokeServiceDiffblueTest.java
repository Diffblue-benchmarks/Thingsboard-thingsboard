package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

class JsInvokeServiceDiffblueTest {
  /**
   * Test {@link JsInvokeService#getLanguage()}.
   * <p>
   * Method under test: {@link JsInvokeService#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  void testGetLanguage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(mock(TbApiUsageReportClient.class));

    // Act and Assert
    assertEquals(ScriptLanguage.JS,
        (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getLanguage());
  }
}
