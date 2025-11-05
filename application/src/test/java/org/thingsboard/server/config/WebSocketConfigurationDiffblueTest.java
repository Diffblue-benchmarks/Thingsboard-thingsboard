package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.websocket.server.ServerContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.thingsboard.server.controller.plugin.TbWebSocketHandler;

class WebSocketConfigurationDiffblueTest {
  /**
   * Test {@link WebSocketConfiguration#createWebSocketContainer()}.
   *
   * <p>Method under test: {@link WebSocketConfiguration#createWebSocketContainer()}
   */
  @Test
  @DisplayName("Test createWebSocketContainer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServletServerContainerFactoryBean WebSocketConfiguration.createWebSocketContainer()"
  })
  void testCreateWebSocketContainer() {
    // Arrange and Act
    ServletServerContainerFactoryBean actualCreateWebSocketContainerResult =
        new WebSocketConfiguration(new TextWebSocketHandler()).createWebSocketContainer();

    // Assert
    assertNull(actualCreateWebSocketContainerResult.getObject());
    assertNull(actualCreateWebSocketContainerResult.getAsyncSendTimeout());
    assertNull(actualCreateWebSocketContainerResult.getMaxSessionIdleTimeout());
    assertEquals(
        32768, actualCreateWebSocketContainerResult.getMaxBinaryMessageBufferSize().intValue());
    assertEquals(
        32768, actualCreateWebSocketContainerResult.getMaxTextMessageBufferSize().intValue());
    assertTrue(actualCreateWebSocketContainerResult.isSingleton());
    Class<ServerContainer> expectedObjectType = ServerContainer.class;
    assertEquals(expectedObjectType, actualCreateWebSocketContainerResult.getObjectType());
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   *
   * <p>Method under test: {@link
   * WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"
  })
  void testRegisterWebSocketHandlers() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new WebSocketConfiguration(new TextWebSocketHandler())
                .registerWebSocketHandlers(mock(WebSocketHandlerRegistry.class)));
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"
  })
  void testRegisterWebSocketHandlers_givenRuntimeException() {
    // Arrange
    WebSocketConfiguration webSocketConfiguration =
        new WebSocketConfiguration(new TbWebSocketHandler());

    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), isA(String[].class)))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> webSocketConfiguration.registerWebSocketHandlers(registry));
    verify(registry).addHandler(isA(WebSocketHandler.class), isA(String[].class));
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   *
   * <ul>
   *   <li>Given {@link ServletWebSocketHandlerRegistration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName(
      "Test registerWebSocketHandlers(WebSocketHandlerRegistry); given ServletWebSocketHandlerRegistration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"
  })
  void testRegisterWebSocketHandlers_givenServletWebSocketHandlerRegistration() {
    // Arrange
    WebSocketConfiguration webSocketConfiguration =
        new WebSocketConfiguration(new TbWebSocketHandler());

    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), isA(String[].class)))
        .thenReturn(new ServletWebSocketHandlerRegistration());

    // Act
    webSocketConfiguration.registerWebSocketHandlers(registry);

    // Assert
    verify(registry).addHandler(isA(WebSocketHandler.class), isA(String[].class));
  }
}
