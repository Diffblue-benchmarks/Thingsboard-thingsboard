package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TenantProfileControllerDiffblueTest {
  @InjectMocks
  private TenantProfileController tenantProfileController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TenantProfileController#saveTenantProfile(TenantProfile)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileController#saveTenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test saveTenantProfile(TenantProfile); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantProfile TenantProfileController.saveTenantProfile(TenantProfile)"})
  void testSaveTenantProfile_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/tenantProfile");
    postResult.characterEncoding("https://example.org/example");

    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setCreatedTime(1L);
    tenantProfile.setDefault(true);
    tenantProfile.setDescription("The characteristics of someone or something");
    tenantProfile.setId(null);
    tenantProfile.setIsolatedTbRuleEngine(true);
    tenantProfile.setName("Name");
    tenantProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));
    String content = (new ObjectMapper()).writeValueAsString(tenantProfile);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantProfiles(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"})
  void testGetTenantProfiles() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/tenantProfiles")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   * <p>
   * Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantProfileInfos(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"})
  void testGetTenantProfileInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/tenantProfileInfos")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfilesByIds(UUID[])}.
   * <p>
   * Method under test: {@link TenantProfileController#getTenantProfilesByIds(UUID[])}
   */
  @Test
  @DisplayName("Test getTenantProfilesByIds(UUID[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List TenantProfileController.getTenantProfilesByIds(UUID[])"})
  void testGetTenantProfilesByIds() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/tenantProfiles");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("ids",
        String.valueOf(new UUID[]{UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
