package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class WidgetsBundleControllerDiffblueTest {
  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks
  private WidgetsBundleController widgetsBundleController;

  /**
   * Test {@link WidgetsBundleController#saveWidgetsBundle(WidgetsBundle)}.
   * <p>
   * Method under test: {@link WidgetsBundleController#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test saveWidgetsBundle(WidgetsBundle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleController.saveWidgetsBundle(WidgetsBundle)"})
  void testSaveWidgetsBundle() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/widgetsBundle");
    postResult.characterEncoding("https://example.org/example");

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setAlias("Alias");
    widgetsBundle.setCreatedTime(1L);
    widgetsBundle.setDescription("The characteristics of someone or something");
    widgetsBundle.setExternalId(new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetsBundle.setId(new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetsBundle.setImage("Image");
    widgetsBundle.setOrder(1);
    widgetsBundle.setScada(true);
    widgetsBundle.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetsBundle.setTitle("Dr");
    widgetsBundle.setVersion(1L);
    String content = (new ObjectMapper()).writeValueAsString(widgetsBundle);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetsBundleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link WidgetsBundleController#updateWidgetsBundleWidgetTypes(String, List)}.
   * <p>
   * Method under test: {@link WidgetsBundleController#updateWidgetsBundleWidgetTypes(String, List)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetTypes(String, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleController.updateWidgetsBundleWidgetTypes(String, List)"})
  void testUpdateWidgetsBundleWidgetTypes() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
        .post("/api/widgetsBundle/{widgetsBundleId}/widgetTypes", "42");
    postResult.characterEncoding("https://example.org/example");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    String content = (new ObjectMapper()).writeValueAsString(stringList);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetsBundleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link WidgetsBundleController#updateWidgetsBundleWidgetFqns(String, List)}.
   * <p>
   * Method under test: {@link WidgetsBundleController#updateWidgetsBundleWidgetFqns(String, List)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetFqns(String, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleController.updateWidgetsBundleWidgetFqns(String, List)"})
  void testUpdateWidgetsBundleWidgetFqns() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
        .post("/api/widgetsBundle/{widgetsBundleId}/widgetTypeFqns", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder = contentTypeResult
        .content(objectMapper.writeValueAsString(new ArrayList<>()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetsBundleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link WidgetsBundleController#getWidgetsBundles(int, int, String, String, String, Boolean, Boolean, Boolean)} with {@code int}, {@code int}, {@code String}, {@code String}, {@code String}, {@code Boolean}, {@code Boolean}, {@code Boolean}.
   * <p>
   * Method under test: {@link WidgetsBundleController#getWidgetsBundles(int, int, String, String, String, Boolean, Boolean, Boolean)}
   */
  @Test
  @DisplayName("Test getWidgetsBundles(int, int, String, String, String, Boolean, Boolean, Boolean) with 'int', 'int', 'String', 'String', 'String', 'Boolean', 'Boolean', 'Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData WidgetsBundleController.getWidgetsBundles(int, int, String, String, String, Boolean, Boolean, Boolean)"})
  void testGetWidgetsBundlesWithIntIntStringStringStringBooleanBooleanBoolean() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/widgetsBundles")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetsBundleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
