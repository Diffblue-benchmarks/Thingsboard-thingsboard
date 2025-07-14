package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
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
class AlarmControllerDiffblueTest {
  @InjectMocks private AlarmController alarmController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AlarmController#getAlarmTypes(int, int, String, String)}.
   *
   * <p>Method under test: {@link AlarmController#getAlarmTypes(int, int, String, String)}
   */
  @Test
  @DisplayName("Test getAlarmTypes(int, int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmTypes(int, int, String, String)"
  })
  void testGetAlarmTypes() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/alarm/types").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
