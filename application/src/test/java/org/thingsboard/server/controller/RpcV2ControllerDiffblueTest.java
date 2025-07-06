package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class RpcV2ControllerDiffblueTest {
  @InjectMocks private RpcV2Controller rpcV2Controller;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName(
      "Test handleOneWayDeviceRPCRequest(String, String); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleOneWayDeviceRPCRequest(String, String)"
  })
  void testHandleOneWayDeviceRPCRequest_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/rpc/oneway/{deviceId}", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName(
      "Test handleOneWayDeviceRPCRequest(String, String); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleOneWayDeviceRPCRequest(String, String)"
  })
  void testHandleOneWayDeviceRPCRequest_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new ResponseStatusException(HttpStatus.OK))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/rpc/oneway/{deviceId}", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleOneWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleOneWayDeviceRPCRequest(String, String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleOneWayDeviceRPCRequest(String, String)"
  })
  void testHandleOneWayDeviceRPCRequest_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/rpc/oneway/{deviceId}", "42")
            .contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName(
      "Test handleTwoWayDeviceRPCRequest(String, String); given 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleTwoWayDeviceRPCRequest(String, String)"
  })
  void testHandleTwoWayDeviceRPCRequest_givenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/rpc/twoway/{deviceId}", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName(
      "Test handleTwoWayDeviceRPCRequest(String, String); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleTwoWayDeviceRPCRequest(String, String)"
  })
  void testHandleTwoWayDeviceRPCRequest_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    doThrow(new ResponseStatusException(HttpStatus.OK))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/rpc/twoway/{deviceId}", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#handleTwoWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleTwoWayDeviceRPCRequest(String, String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.handleTwoWayDeviceRPCRequest(String, String)"
  })
  void testHandleTwoWayDeviceRPCRequest_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/rpc/twoway/{deviceId}", "42")
            .contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpc(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpc(String)}
   */
  @Test
  @DisplayName("Test getPersistedRpc(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rpc.Rpc RpcV2Controller.getPersistedRpc(String)"
  })
  void testGetPersistedRpc_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/rpc/persistent/{rpcId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String,
   * String, String)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code 42}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int,
   * RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); given array of Object with '42'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)"
  })
  void testGetPersistedRpcByDevice_givenArrayOfObjectWith42_whenEmptyString() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/rpc/persistent/device/{deviceId}", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String,
   * String, String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int,
   * RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)"
  })
  void testGetPersistedRpcByDevice_thenStatusFourHundred() throws Exception {
    // Arrange
    doThrow(new ResponseStatusException(HttpStatus.OK))
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/rpc/persistent/device/{deviceId}", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int,
   * RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); when 'https://example.org/example'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)"
  })
  void testGetPersistedRpcByDevice_whenHttpsExampleOrgExample_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/rpc/persistent/device/{deviceId}", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int,
   * RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); when param(String, String[]) 'page' is valueOf one; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)"
  })
  void testGetPersistedRpcByDevice_whenParamPageIsValueOfOne_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/rpc/persistent/device/{deviceId}", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int, RpcStatus, String,
   * String, String)}.
   *
   * <ul>
   *   <li>When valueOf {@code QUEUED}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#getPersistedRpcByDevice(String, int, int,
   * RpcStatus, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String); when valueOf 'QUEUED'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV2Controller.getPersistedRpcByDevice(String, int, int, RpcStatus, String, String, String)"
  })
  void testGetPersistedRpcByDevice_whenValueOfQueued_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/rpc/persistent/device/{deviceId}", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("pageSize", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult2.param("rpcStatus", String.valueOf(RpcStatus.QUEUED));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link RpcV2Controller#deleteRpc(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV2Controller#deleteRpc(String)}
   */
  @Test
  @DisplayName("Test deleteRpc(String); when '42'; then status isOk()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RpcV2Controller.deleteRpc(String)"})
  void testDeleteRpc_when42_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/rpc/persistent/{rpcId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV2Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
