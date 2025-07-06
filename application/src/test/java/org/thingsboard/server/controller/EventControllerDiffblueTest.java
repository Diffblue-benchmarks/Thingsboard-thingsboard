package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EventControllerDiffblueTest {
  @InjectMocks private EventController eventController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EventController#getEvents(String, String, String, String, int, int, String, String,
   * String, Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code eventType}, {@code
   * strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code
   * sortOrder}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, String, int,
   * int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, String, int, int, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'eventType', 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, String, int, int, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdEventTypeStrTenantIdPageSizePageTextSearchSortPropertySortOrderStartTimeEndTime()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/events/{entityType}/{entityId}/{eventType}", "Entity Type", "42", "Event Type");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("tenantId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, String, int, int, String, String,
   * String, Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code eventType}, {@code
   * strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code
   * sortOrder}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, String, int,
   * int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, String, int, int, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'eventType', 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, String, int, int, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdEventTypeStrTenantIdPageSizePageTextSearchSortPropertySortOrderStartTimeEndTime2()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/events/{entityType}/{entityId}/{eventType}",
                "Entity Type",
                "42",
                "Event Type")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("tenantId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, String, int, int, String, String,
   * String, Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code eventType}, {@code
   * strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code
   * sortOrder}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, String, int,
   * int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, String, int, int, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'eventType', 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, String, int, int, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdEventTypeStrTenantIdPageSizePageTextSearchSortPropertySortOrderStartTimeEndTime3()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/events/{entityType}/{entityId}/{eventType}", "Entity Type", "42", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("tenantId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, int, int, EventFilter, String,
   * String, String, Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code
   * strTenantId}, {@code pageSize}, {@code page}, {@code eventFilter}, {@code textSearch}, {@code
   * sortProperty}, {@code sortOrder}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, int, int,
   * EventFilter, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, int, int, EventFilter, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'strTenantId', 'pageSize', 'page', 'eventFilter', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, int, int, EventFilter, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdStrTenantIdPageSizePageEventFilterTextSearchSortPropertySortOrderStartTimeEndTime()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/events/{entityType}/{entityId}", "Entity Type", "42");
    MockHttpServletRequestBuilder paramResult = postResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder contentTypeResult =
        paramResult
            .param("pageSize", String.valueOf(1))
            .param("tenantId", "foo")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new ErrorEventFilter()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, int, int, EventFilter, String,
   * String, String, Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code
   * strTenantId}, {@code pageSize}, {@code page}, {@code eventFilter}, {@code textSearch}, {@code
   * sortProperty}, {@code sortOrder}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, int, int,
   * EventFilter, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, int, int, EventFilter, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'strTenantId', 'pageSize', 'page', 'eventFilter', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, int, int, EventFilter, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdStrTenantIdPageSizePageEventFilterTextSearchSortPropertySortOrderStartTimeEndTime2()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.post("/api/events/{entityType}/{entityId}", "Entity Type", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        paramResult
            .param("pageSize", String.valueOf(1))
            .param("tenantId", "foo")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new ErrorEventFilter()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, int, int, String, String, String,
   * Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code strTenantId}, {@code
   * pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code sortOrder}, {@code
   * startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, int, int,
   * String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, int, int, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, int, int, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdStrTenantIdPageSizePageTextSearchSortPropertySortOrderStartTimeEndTime()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/events/{entityType}/{entityId}", "Entity Type", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("tenantId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#getEvents(String, String, String, int, int, String, String, String,
   * Long, Long)} with {@code strEntityType}, {@code strEntityId}, {@code strTenantId}, {@code
   * pageSize}, {@code page}, {@code textSearch}, {@code sortProperty}, {@code sortOrder}, {@code
   * startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link EventController#getEvents(String, String, String, int, int,
   * String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEvents(String, String, String, int, int, String, String, String, Long, Long) with 'strEntityType', 'strEntityId', 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder', 'startTime', 'endTime'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EventController.getEvents(String, String, String, int, int, String, String, String, Long, Long)"
  })
  void
      testGetEventsWithStrEntityTypeStrEntityIdStrTenantIdPageSizePageTextSearchSortPropertySortOrderStartTimeEndTime2()
          throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/events/{entityType}/{entityId}", "Entity Type", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("tenantId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#clearEvents(String, String, Long, Long, EventFilter)}.
   *
   * <p>Method under test: {@link EventController#clearEvents(String, String, Long, Long,
   * EventFilter)}
   */
  @Test
  @DisplayName("Test clearEvents(String, String, Long, Long, EventFilter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EventController.clearEvents(String, String, Long, Long, EventFilter)"})
  void testClearEvents() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post(
                "/api/events/{entityType}/{entityId}/clear", "Entity Type", "42")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new ErrorEventFilter()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EventController#clearEvents(String, String, Long, Long, EventFilter)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link EventController#clearEvents(String, String, Long, Long,
   * EventFilter)}
   */
  @Test
  @DisplayName(
      "Test clearEvents(String, String, Long, Long, EventFilter); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EventController.clearEvents(String, String, Long, Long, EventFilter)"})
  void testClearEvents_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post(
            "/api/events/{entityType}/{entityId}/clear", "Entity Type", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new ErrorEventFilter()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(eventController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
