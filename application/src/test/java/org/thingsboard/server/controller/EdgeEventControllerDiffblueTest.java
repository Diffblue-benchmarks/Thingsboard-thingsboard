package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EdgeEventControllerDiffblueTest {
  @InjectMocks
  private EdgeEventController edgeEventController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test getEdgeEvents(String, int, int, String, String, String, Long, Long); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData EdgeEventController.getEdgeEvents(String, int, int, String, String, String, Long, Long)"})
  void testGetEdgeEvents_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/edge/{edgeId}/events", "42")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeEventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long, Long)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test getEdgeEvents(String, int, int, String, String, String, Long, Long); when param(String, String[]) 'page' is valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData EdgeEventController.getEdgeEvents(String, int, int, String, String, String, Long, Long)"})
  void testGetEdgeEvents_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/edge/{edgeId}/events", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeEventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
