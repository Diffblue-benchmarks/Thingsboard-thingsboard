package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

@ContextConfiguration(classes = {DefaultTbelInvokeService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbelInvokeServiceDiffblueTest {
  @MockBean
  private TbApiUsageReportClient tbApiUsageReportClient;

  @MockBean
  private TbApiUsageStateClient tbApiUsageStateClient;

  @Autowired
  private TbelInvokeService tbelInvokeService;

  /**
   * Test {@link TbelInvokeService#getLanguage()}.
   * <p>
   * Method under test: {@link TbelInvokeService#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertEquals(ScriptLanguage.TBEL, tbelInvokeService.getLanguage());
  }
}
