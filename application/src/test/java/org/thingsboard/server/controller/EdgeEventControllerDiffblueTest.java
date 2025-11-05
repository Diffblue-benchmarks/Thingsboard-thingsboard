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
class EdgeEventControllerDiffblueTest {
  @InjectMocks private EdgeEventController edgeEventController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When {@link EdgeEventController#EDGE_ID}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventController#getEdgeEvents(String, int, int, String,
   * String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEvents(String, int, int, String, String, String, Long, Long); when EDGE_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeEventController.getEdgeEvents(String, int, int, String, String, String, Long, Long)"
  })
  void testGetEdgeEvents_whenEdge_id() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/events", "42")
            .param("page", EdgeEventController.EDGE_ID)
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeEventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link EdgeEventController#getEdgeEvents(String, int, int, String, String, String, Long,
   * Long)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventController#getEdgeEvents(String, int, int, String,
   * String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEvents(String, int, int, String, String, String, Long, Long); when param(String, String[]) 'page' is valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EdgeEventController.getEdgeEvents(String, int, int, String, String, String, Long, Long)"
  })
  void testGetEdgeEvents_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/events", "42")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(edgeEventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
