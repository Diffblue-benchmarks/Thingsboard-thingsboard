package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class OAuth2ConfigTemplateControllerDiffblueTest {
  @InjectMocks private OAuth2ConfigTemplateController oAuth2ConfigTemplateController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link OAuth2ConfigTemplateController#deleteClientRegistrationTemplate(String)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateController#deleteClientRegistrationTemplate(String)}
   */
  @Test
  @DisplayName("Test deleteClientRegistrationTemplate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ConfigTemplateController.deleteClientRegistrationTemplate(String)"
  })
  void testDeleteClientRegistrationTemplate() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/oauth2/config/template/{clientRegistrationTemplateId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2ConfigTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
