package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class OAuth2ConfigTemplateControllerDiffblueTest {
  @InjectMocks
  private OAuth2ConfigTemplateController oAuth2ConfigTemplateController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link OAuth2ConfigTemplateController#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateController#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateController.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"})
  void testSaveClientRegistrationTemplate_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/oauth2/config/template");
    postResult.characterEncoding("https://example.org/example");

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");
    oAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplate.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientRegistrationTemplate.setComment("Comment");
    oAuth2ClientRegistrationTemplate.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplate.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplate.setId(null);
    oAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    oAuth2ClientRegistrationTemplate.setMapperConfig(mapperConfig);
    oAuth2ClientRegistrationTemplate.setProviderId("42");
    oAuth2ClientRegistrationTemplate.setScope(new ArrayList<>());
    oAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(oAuth2ClientRegistrationTemplate);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2ConfigTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link OAuth2ConfigTemplateController#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateController#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @DisplayName("Test saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate); then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateController.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"})
  void testSaveClientRegistrationTemplate_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    oAuth2ClientRegistrationTemplate.setAccessTokenUri("ABC123");
    oAuth2ClientRegistrationTemplate.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplate.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientRegistrationTemplate.setComment("Comment");
    oAuth2ClientRegistrationTemplate.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplate.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplate.setId(null);
    oAuth2ClientRegistrationTemplate.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplate.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplate.setLoginButtonLabel("Login Button Label");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    oAuth2ClientRegistrationTemplate.setMapperConfig(mapperConfig);
    oAuth2ClientRegistrationTemplate.setProviderId("42");
    oAuth2ClientRegistrationTemplate.setScope(new ArrayList<>());
    oAuth2ClientRegistrationTemplate.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplate.setUserNameAttributeName("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(oAuth2ClientRegistrationTemplate);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/oauth2/config/template")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2ConfigTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link OAuth2ConfigTemplateController#deleteClientRegistrationTemplate(String)}.
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateController#deleteClientRegistrationTemplate(String)}
   */
  @Test
  @DisplayName("Test deleteClientRegistrationTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2ConfigTemplateController.deleteClientRegistrationTemplate(String)"})
  void testDeleteClientRegistrationTemplate() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/api/oauth2/config/template/{clientRegistrationTemplateId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2ConfigTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link OAuth2ConfigTemplateController#getClientRegistrationTemplates()}.
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateController#getClientRegistrationTemplates()}
   */
  @Test
  @DisplayName("Test getClientRegistrationTemplates()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List OAuth2ConfigTemplateController.getClientRegistrationTemplates()"})
  void testGetClientRegistrationTemplates() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/oauth2/config/template");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(oAuth2ConfigTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
