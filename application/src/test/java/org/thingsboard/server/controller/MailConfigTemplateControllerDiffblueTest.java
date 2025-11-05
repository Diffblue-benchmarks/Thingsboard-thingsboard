package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.service.mail.TbMailConfigTemplateService;

class MailConfigTemplateControllerDiffblueTest {
  /**
   * Test {@link MailConfigTemplateController#getClientRegistrationTemplates()}.
   *
   * <p>Method under test: {@link MailConfigTemplateController#getClientRegistrationTemplates()}
   */
  @Test
  @DisplayName("Test getClientRegistrationTemplates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode MailConfigTemplateController.getClientRegistrationTemplates()"
  })
  void testGetClientRegistrationTemplates() throws IOException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new MailConfigTemplateController(mock(TbMailConfigTemplateService.class))
                .getClientRegistrationTemplates());
  }
}
