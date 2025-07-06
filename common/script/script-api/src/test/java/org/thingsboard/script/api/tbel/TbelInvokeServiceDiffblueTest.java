package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.script.ScriptLanguage;

@ContextConfiguration(classes = {DefaultTbelInvokeService.class})
@ExtendWith(SpringExtension.class)
class TbelInvokeServiceDiffblueTest {
  @Autowired private TbelInvokeService tbelInvokeService;

  /**
   * Test {@link TbelInvokeService#getLanguage()}.
   *
   * <p>Method under test: {@link TbelInvokeService#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScriptLanguage TbelInvokeService.getLanguage()"})
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertEquals(ScriptLanguage.TBEL, tbelInvokeService.getLanguage());
  }
}
