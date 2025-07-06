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
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EntityQueryControllerDiffblueTest {
  @InjectMocks private EntityQueryController entityQueryController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EntityQueryController#countEntitiesByQuery(EntityCountQuery)}.
   *
   * <p>Method under test: {@link EntityQueryController#countEntitiesByQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test countEntitiesByQuery(EntityCountQuery)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityQueryController.countEntitiesByQuery(EntityCountQuery)"})
  void testCountEntitiesByQuery() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/count")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityCountQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#countEntitiesByQuery(EntityCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link EntityQueryController#countEntitiesByQuery(EntityCountQuery)}
   */
  @Test
  @DisplayName("Test countEntitiesByQuery(EntityCountQuery); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityQueryController.countEntitiesByQuery(EntityCountQuery)"})
  void testCountEntitiesByQuery_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/count");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityCountQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findEntityDataByQuery(EntityDataQuery)}.
   *
   * <p>Method under test: {@link EntityQueryController#findEntityDataByQuery(EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(EntityDataQuery)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityQueryController.findEntityDataByQuery(EntityDataQuery)"
  })
  void testFindEntityDataByQuery() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/find")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findEntityDataByQuery(EntityDataQuery)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link EntityQueryController#findEntityDataByQuery(EntityDataQuery)}
   */
  @Test
  @DisplayName("Test findEntityDataByQuery(EntityDataQuery); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityQueryController.findEntityDataByQuery(EntityDataQuery)"
  })
  void testFindEntityDataByQuery_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/find");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findAlarmDataByQuery(AlarmDataQuery)}.
   *
   * <p>Method under test: {@link EntityQueryController#findAlarmDataByQuery(AlarmDataQuery)}
   */
  @Test
  @DisplayName("Test findAlarmDataByQuery(AlarmDataQuery)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityQueryController.findAlarmDataByQuery(AlarmDataQuery)"
  })
  void testFindAlarmDataByQuery() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/alarmsQuery/find")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new AlarmDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findAlarmDataByQuery(AlarmDataQuery)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link EntityQueryController#findAlarmDataByQuery(AlarmDataQuery)}
   */
  @Test
  @DisplayName("Test findAlarmDataByQuery(AlarmDataQuery); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityQueryController.findAlarmDataByQuery(AlarmDataQuery)"
  })
  void testFindAlarmDataByQuery_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/alarmsQuery/find");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new AlarmDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#countAlarmsByQuery(AlarmCountQuery)}.
   *
   * <p>Method under test: {@link EntityQueryController#countAlarmsByQuery(AlarmCountQuery)}
   */
  @Test
  @DisplayName("Test countAlarmsByQuery(AlarmCountQuery)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityQueryController.countAlarmsByQuery(AlarmCountQuery)"})
  void testCountAlarmsByQuery() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/alarmsQuery/count")
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new AlarmCountQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#countAlarmsByQuery(AlarmCountQuery)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link EntityQueryController#countAlarmsByQuery(AlarmCountQuery)}
   */
  @Test
  @DisplayName("Test countAlarmsByQuery(AlarmCountQuery); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityQueryController.countAlarmsByQuery(AlarmCountQuery)"})
  void testCountAlarmsByQuery_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/alarmsQuery/count");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new AlarmCountQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery,
   * boolean, boolean, String)}.
   *
   * <p>Method under test: {@link
   * EntityQueryController#findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean, boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntityQueryController.findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean, boolean, String)"
  })
  void testFindEntityTimeseriesAndAttributesKeysByQuery() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/find/keys");
    MockHttpServletRequestBuilder paramResult =
        postResult.param("attributes", String.valueOf(true));
    MockHttpServletRequestBuilder contentTypeResult =
        paramResult
            .param("timeseries", String.valueOf(true))
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link EntityQueryController#findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityQueryController#findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean, boolean, String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntityQueryController.findEntityTimeseriesAndAttributesKeysByQuery(EntityDataQuery, boolean, boolean, String)"
  })
  void testFindEntityTimeseriesAndAttributesKeysByQuery_whenHttpsExampleOrgExample()
      throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.post("/api/entitiesQuery/find/keys")
            .param("attributes", "https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        paramResult
            .param("timeseries", String.valueOf(true))
            .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(objectMapper.writeValueAsString(new EntityDataQuery()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityQueryController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
