package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.springframework.boot.info.BuildProperties;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class SystemInfoControllerDiffblueTest {
  @Mock private BuildProperties buildProperties;

  @InjectMocks private SystemInfoController systemInfoController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link SystemInfoController#init()}.
   *
   * <ul>
   *   <li>Given {@link BuildProperties} {@link BuildProperties#getArtifact()} return {@code
   *       Artifact}.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoController#init()}
   */
  @Test
  @DisplayName("Test init(); given BuildProperties getArtifact() return 'Artifact'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemInfoController.init()"})
  void testInit_givenBuildPropertiesGetArtifactReturnArtifact() {
    // Arrange
    when(buildProperties.getArtifact()).thenReturn("Artifact");
    when(buildProperties.getName()).thenReturn("Name");
    when(buildProperties.getVersion()).thenReturn("1.0.2");

    // Act
    systemInfoController.init();

    // Assert
    verify(buildProperties).getArtifact();
    verify(buildProperties).getName();
    verify(buildProperties).getVersion();
  }

  /**
   * Test {@link SystemInfoController#init()}.
   *
   * <ul>
   *   <li>Given {@link BuildProperties} {@link BuildProperties#getArtifact()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoController#init()}
   */
  @Test
  @DisplayName("Test init(); given BuildProperties getArtifact() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemInfoController.init()"})
  void testInit_givenBuildPropertiesGetArtifactReturnEmptyString() {
    // Arrange
    when(buildProperties.getArtifact()).thenReturn("");
    when(buildProperties.getName()).thenReturn("Name");
    when(buildProperties.getVersion()).thenReturn("1.0.2");

    // Act
    systemInfoController.init();

    // Assert
    verify(buildProperties).getArtifact();
    verify(buildProperties).getName();
    verify(buildProperties).getVersion();
  }

  /**
   * Test {@link SystemInfoController#init()}.
   *
   * <ul>
   *   <li>Given {@link BuildProperties} {@link BuildProperties#getArtifact()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoController#init()}
   */
  @Test
  @DisplayName("Test init(); given BuildProperties getArtifact() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemInfoController.init()"})
  void testInit_givenBuildPropertiesGetArtifactReturnNull() {
    // Arrange
    when(buildProperties.getArtifact()).thenReturn(null);
    when(buildProperties.getName()).thenReturn("Name");
    when(buildProperties.getVersion()).thenReturn("1.0.2");

    // Act
    systemInfoController.init();

    // Assert
    verify(buildProperties).getArtifact();
    verify(buildProperties).getName();
    verify(buildProperties).getVersion();
  }

  /**
   * Test {@link SystemInfoController#getSystemVersionInfo()}.
   *
   * <p>Method under test: {@link SystemInfoController#getSystemVersionInfo()}
   */
  @Test
  @DisplayName("Test getSystemVersionInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode SystemInfoController.getSystemVersionInfo()"
  })
  void testGetSystemVersionInfo() throws Exception {
    // Arrange
    when(buildProperties.getArtifact()).thenReturn("Artifact");
    when(buildProperties.getName()).thenReturn("Name");
    when(buildProperties.getVersion()).thenReturn("1.0.2");

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/system/info");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(systemInfoController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"version\":\"1.0.2\",\"artifact\":\"Artifact\",\"name\":\"Name\",\"type\":\"CE\"}"));
  }

  /**
   * Test {@link SystemInfoController#getSystemParams()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/system/params}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoController#getSystemParams()}
   */
  @Test
  @DisplayName(
      "Test getSystemParams(); when get(String, Object[]) '/api/system/params'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.SystemParams SystemInfoController.getSystemParams()"
  })
  void testGetSystemParams_whenGetApiSystemParams_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/system/params");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(systemInfoController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
