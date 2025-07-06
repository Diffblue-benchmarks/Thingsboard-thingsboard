package org.thingsboard.server.config;

import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ContextConfiguration(classes = {WebConfig.class, ThingsboardErrorResponseHandler.class})
@ExtendWith(SpringExtension.class)
class WebConfigDiffblueTest {
  @Autowired private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @Autowired private WebConfig webConfig;

  /**
   * Test {@link WebConfig#redirect()}.
   *
   * <p>Method under test: {@link WebConfig#redirect()}
   */
  @Test
  @DisplayName("Test redirect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String WebConfig.redirect()"})
  void testRedirect() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(webConfig)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("forward:/index.html"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("/index.html"));
  }

  /**
   * Test {@link WebConfig#redirectSwagger(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code /swagger-ui.html}.
   *   <li>When formLogin.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfig#redirectSwagger(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test redirectSwagger(HttpServletRequest, HttpServletResponse); given '/swagger-ui.html'; when formLogin; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebConfig.redirectSwagger(HttpServletRequest, HttpServletResponse)"})
  void testRedirectSwagger_givenSwaggerUiHtml_whenFormLogin_thenStatusIsOk() throws Exception {
    // Arrange
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(webConfig)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("forward:/index.html"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("/index.html"));
  }

  /**
   * Test {@link WebConfig#redirectSwagger(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /swagger-ui.html}.
   *   <li>Then status {@link StatusResultMatchers#isFound()}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfig#redirectSwagger(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test redirectSwagger(HttpServletRequest, HttpServletResponse); when get(String, Object[]) '/swagger-ui.html'; then status isFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebConfig.redirectSwagger(HttpServletRequest, HttpServletResponse)"})
  void testRedirectSwagger_whenGetSwaggerUiHtml_thenStatusIsFound() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/swagger-ui.html");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(webConfig)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost:80/swagger-ui/"));
  }

  /**
   * Test {@link WebConfig#redirectSwaggerIndex()}.
   *
   * <ul>
   *   <li>Given {@code /swagger-ui/}.
   *   <li>Then view name {@code forward:/index.html}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfig#redirectSwaggerIndex()}
   */
  @Test
  @DisplayName(
      "Test redirectSwaggerIndex(); given '/swagger-ui/'; then view name 'forward:/index.html'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String WebConfig.redirectSwaggerIndex()"})
  void testRedirectSwaggerIndex_givenSwaggerUi_thenViewNameForwardIndexHtml() throws Exception {
    // Arrange
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(webConfig)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("forward:/index.html"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("/index.html"));
  }

  /**
   * Test {@link WebConfig#redirectSwaggerIndex()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /swagger-ui/}.
   *   <li>Then view name {@code forward:/swagger-ui/index.html}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfig#redirectSwaggerIndex()}
   */
  @Test
  @DisplayName(
      "Test redirectSwaggerIndex(); when get(String, Object[]) '/swagger-ui/'; then view name 'forward:/swagger-ui/index.html'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String WebConfig.redirectSwaggerIndex()"})
  void testRedirectSwaggerIndex_whenGetSwaggerUi_thenViewNameForwardSwaggerUiIndexHtml()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/swagger-ui/");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(webConfig)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("forward:/swagger-ui/index.html"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("/swagger-ui/index.html"));
  }
}
