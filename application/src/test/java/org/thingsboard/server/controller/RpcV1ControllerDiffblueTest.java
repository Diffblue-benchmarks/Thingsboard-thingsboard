package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class RpcV1ControllerDiffblueTest {
  @InjectMocks private RpcV1Controller rpcV1Controller;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RpcV1Controller#handleOneWayDeviceRPCRequest(String, String)}.
   *
   * <p>Method under test: {@link RpcV1Controller#handleOneWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleOneWayDeviceRPCRequest(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV1Controller.handleOneWayDeviceRPCRequest(String, String)"
  })
  void testHandleOneWayDeviceRPCRequest() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/plugins/rpc/oneway/{deviceId}", "42")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV1Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RpcV1Controller#handleOneWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Given {@code Encoding}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV1Controller#handleOneWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleOneWayDeviceRPCRequest(String, String); given 'Encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV1Controller.handleOneWayDeviceRPCRequest(String, String)"
  })
  void testHandleOneWayDeviceRPCRequest_givenEncoding() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/plugins/rpc/oneway/{deviceId}", "42");
    postResult.characterEncoding("Encoding");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV1Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RpcV1Controller#handleTwoWayDeviceRPCRequest(String, String)}.
   *
   * <p>Method under test: {@link RpcV1Controller#handleTwoWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleTwoWayDeviceRPCRequest(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV1Controller.handleTwoWayDeviceRPCRequest(String, String)"
  })
  void testHandleTwoWayDeviceRPCRequest() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/plugins/rpc/twoway/{deviceId}", "42")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV1Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link RpcV1Controller#handleTwoWayDeviceRPCRequest(String, String)}.
   *
   * <ul>
   *   <li>Given {@code Encoding}.
   * </ul>
   *
   * <p>Method under test: {@link RpcV1Controller#handleTwoWayDeviceRPCRequest(String, String)}
   */
  @Test
  @DisplayName("Test handleTwoWayDeviceRPCRequest(String, String); given 'Encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult RpcV1Controller.handleTwoWayDeviceRPCRequest(String, String)"
  })
  void testHandleTwoWayDeviceRPCRequest_givenEncoding() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/plugins/rpc/twoway/{deviceId}", "42");
    postResult.characterEncoding("Encoding");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(rpcV1Controller)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
