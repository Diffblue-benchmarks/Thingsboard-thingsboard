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
   * Test {@link AlarmController#getAlarms(String, String, String, String, String, int, int, String,
   * String, String, Long, Long, Boolean)}.
   *
   * <p>Method under test: {@link AlarmController#getAlarms(String, String, String, String, String,
   * int, int, String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAlarms() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/alarm/{entityType}/{entityId}", "Entity Type", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/alarms").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AlarmController#getAlarmsV2(String, String, String[], String[], String[], String,
   * int, int, String, String, String, Long, Long)}.
   *
   * <p>Method under test: {@link AlarmController#getAlarmsV2(String, String, String[], String[],
   * String[], String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAlarmsV2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/v2/alarm/{entityType}/{entityId}", "Entity Type", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/v2/alarms").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AlarmController#getHighestAlarmSeverity(String, String, String, String, String)}.
   *
   * <p>Method under test: {@link AlarmController#getHighestAlarmSeverity(String, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getHighestAlarmSeverity(String, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmSeverity AlarmController.getHighestAlarmSeverity(String, String, String, String, String)"
  })
  void testGetHighestAlarmSeverity() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/alarm/highestSeverity/{entityType}/{entityId}", "Entity Type", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

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
