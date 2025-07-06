package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultTbMailConfigTemplateServiceDiffblueTest {
  /**
   * Test {@link DefaultTbMailConfigTemplateService#findAllMailConfigTemplates()}.
   *
   * <p>Method under test: {@link DefaultTbMailConfigTemplateService#findAllMailConfigTemplates()}
   */
  @Test
  @DisplayName("Test findAllMailConfigTemplates()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode DefaultTbMailConfigTemplateService.findAllMailConfigTemplates()"
  })
  void testFindAllMailConfigTemplates() {
    // Arrange, Act and Assert
    assertNull(new DefaultTbMailConfigTemplateService().findAllMailConfigTemplates());
  }
}
