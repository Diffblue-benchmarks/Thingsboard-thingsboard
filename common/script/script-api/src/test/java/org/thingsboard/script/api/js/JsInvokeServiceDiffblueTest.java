package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

@ExtendWith(MockitoExtension.class)
class JsInvokeServiceDiffblueTest {
  @Mock
  private TbApiUsageReportClient tbApiUsageReportClient;

  /**
   * Test {@link JsInvokeService#getLanguage()}.
   * <p>
   * Method under test: {@link JsInvokeService#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScriptLanguage JsInvokeService.getLanguage()"})
  void testGetLanguage() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient = Optional.of(tbApiUsageReportClient);

    // Act and Assert
    assertEquals(ScriptLanguage.JS,
        (new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient)).getLanguage());
  }
}
