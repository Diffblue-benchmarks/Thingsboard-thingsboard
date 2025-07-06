package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class OAuth2ControllerDiffblueTest {
  @InjectMocks private OAuth2Controller oAuth2Controller;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link OAuth2Controller#findTenantOAuth2ClientInfos(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link OAuth2Controller#findTenantOAuth2ClientInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test findTenantOAuth2ClientInfos(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData OAuth2Controller.findTenantOAuth2ClientInfos(int, int, String, String, String)"
  })
  void testFindTenantOAuth2ClientInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/oauth2/client/infos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link OAuth2Controller#findTenantOAuth2ClientInfosByIds(UUID[])}.
   *
   * <p>Method under test: {@link OAuth2Controller#findTenantOAuth2ClientInfosByIds(UUID[])}
   */
  @Test
  @DisplayName("Test findTenantOAuth2ClientInfosByIds(UUID[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List OAuth2Controller.findTenantOAuth2ClientInfosByIds(UUID[])"})
  void testFindTenantOAuth2ClientInfosByIds() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/oauth2/client/infos");
    MockHttpServletRequestBuilder requestBuilder =
        getResult.param(
            "clientIds",
            String.valueOf(new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link OAuth2Controller#getOAuth2ClientById(UUID)}.
   *
   * <p>Method under test: {@link OAuth2Controller#getOAuth2ClientById(UUID)}
   */
  @Test
  @DisplayName("Test getOAuth2ClientById(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.oauth2.OAuth2Client OAuth2Controller.getOAuth2ClientById(UUID)"
  })
  void testGetOAuth2ClientById() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/oauth2/client/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link OAuth2Controller#deleteOauth2Client(UUID)}.
   *
   * <p>Method under test: {@link OAuth2Controller#deleteOauth2Client(UUID)}
   */
  @Test
  @DisplayName("Test deleteOauth2Client(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2Controller.deleteOauth2Client(UUID)"})
  void testDeleteOauth2Client() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/oauth2/client/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
