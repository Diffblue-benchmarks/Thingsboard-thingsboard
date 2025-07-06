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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class MobileAppControllerDiffblueTest {
  @InjectMocks private MobileAppController mobileAppController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link MobileAppController#saveMobileApp(MobileApp, UUID[])}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppController#saveMobileApp(MobileApp, UUID[])}
   */
  @Test
  @DisplayName(
      "Test saveMobileApp(MobileApp, UUID[]); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileApp MobileAppController.saveMobileApp(MobileApp, UUID[])"})
  void testSaveMobileApp_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/mobileApp");
    postResult.characterEncoding("https://example.org/example");

    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("App Secret");
    mobileApp.setCreatedTime(1L);
    mobileApp.setId(null);
    mobileApp.setOauth2Enabled(true);
    mobileApp.setPkgName("Pkg Name");
    mobileApp.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = new ObjectMapper().writeValueAsString(mobileApp);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link MobileAppController#updateOauth2Clients(UUID, UUID[])}.
   *
   * <p>Method under test: {@link MobileAppController#updateOauth2Clients(UUID, UUID[])}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(UUID, UUID[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppController.updateOauth2Clients(UUID, UUID[])"})
  void testUpdateOauth2Clients() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.put(
                "/api/mobileApp/{id}/oauth2Clients", "Uri Variables", "Uri Variables")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(
                new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link MobileAppController#getTenantMobileAppInfos(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link MobileAppController#getTenantMobileAppInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getTenantMobileAppInfos(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData MobileAppController.getTenantMobileAppInfos(int, int, String, String, String)"
  })
  void testGetTenantMobileAppInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/mobileApp/infos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link MobileAppController#getMobileAppInfoById(UUID)}.
   *
   * <p>Method under test: {@link MobileAppController#getMobileAppInfoById(UUID)}
   */
  @Test
  @DisplayName("Test getMobileAppInfoById(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MobileAppInfo MobileAppController.getMobileAppInfoById(UUID)"})
  void testGetMobileAppInfoById() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/mobileApp/info/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link MobileAppController#deleteMobileApp(UUID)}.
   *
   * <p>Method under test: {@link MobileAppController#deleteMobileApp(UUID)}
   */
  @Test
  @DisplayName("Test deleteMobileApp(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppController.deleteMobileApp(UUID)"})
  void testDeleteMobileApp() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/mobileApp/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
