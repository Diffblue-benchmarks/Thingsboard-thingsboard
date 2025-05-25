package org.thingsboard.server.service.update;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultUpdateServiceDiffblueTest {
  /**
   * Test {@link DefaultUpdateService#checkUpdates()}.
   * <p>
   * Method under test: {@link DefaultUpdateService#checkUpdates()}
   */
  @Test
  @DisplayName("Test checkUpdates()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.UpdateMessage DefaultUpdateService.checkUpdates()"})
  void testCheckUpdates() {
    // Arrange, Act and Assert
    assertNull((new DefaultUpdateService()).checkUpdates());
  }
}
