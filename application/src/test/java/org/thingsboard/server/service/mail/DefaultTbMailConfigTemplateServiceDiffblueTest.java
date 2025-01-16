package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultTbMailConfigTemplateServiceDiffblueTest {
  /**
   * Test {@link DefaultTbMailConfigTemplateService#findAllMailConfigTemplates()}.
   * <p>
   * Method under test:
   * {@link DefaultTbMailConfigTemplateService#findAllMailConfigTemplates()}
   */
  @Test
  @DisplayName("Test findAllMailConfigTemplates()")
  void testFindAllMailConfigTemplates() {
    // Arrange, Act and Assert
    assertNull((new DefaultTbMailConfigTemplateService()).findAllMailConfigTemplates());
  }
}
