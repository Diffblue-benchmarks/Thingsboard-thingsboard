package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.websocket.server.ServerContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.thingsboard.server.controller.plugin.TbWebSocketHandler;

@ExtendWith(MockitoExtension.class)
class WebSocketConfigurationDiffblueTest {
  @InjectMocks
  private WebSocketConfiguration webSocketConfiguration;

  /**
   * Test {@link WebSocketConfiguration#createWebSocketContainer()}.
   * <p>
   * Method under test: {@link WebSocketConfiguration#createWebSocketContainer()}
   */
  @Test
  @DisplayName("Test createWebSocketContainer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServletServerContainerFactoryBean WebSocketConfiguration.createWebSocketContainer()"})
  void testCreateWebSocketContainer() {
    // Arrange and Act
    ServletServerContainerFactoryBean actualCreateWebSocketContainerResult = webSocketConfiguration
        .createWebSocketContainer();

    // Assert
    assertNull(actualCreateWebSocketContainerResult.getObject());
    assertNull(actualCreateWebSocketContainerResult.getAsyncSendTimeout());
    assertNull(actualCreateWebSocketContainerResult.getMaxSessionIdleTimeout());
    assertEquals(32768, actualCreateWebSocketContainerResult.getMaxBinaryMessageBufferSize().intValue());
    assertEquals(32768, actualCreateWebSocketContainerResult.getMaxTextMessageBufferSize().intValue());
    assertTrue(actualCreateWebSocketContainerResult.isSingleton());
    Class<ServerContainer> expectedObjectType = ServerContainer.class;
    assertEquals(expectedObjectType, actualCreateWebSocketContainerResult.getObjectType());
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@link ThingsboardSecurityConfiguration#WS_ENTRY_POINT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry); given RuntimeException(String) with WS_ENTRY_POINT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"})
  void testRegisterWebSocketHandlers_givenRuntimeExceptionWithWs_entry_point() {
    // Arrange
    WebSocketConfiguration webSocketConfiguration = new WebSocketConfiguration(new TbWebSocketHandler());
    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), isA(String[].class)))
        .thenThrow(new RuntimeException(ThingsboardSecurityConfiguration.WS_ENTRY_POINT));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> webSocketConfiguration.registerWebSocketHandlers(registry));
    verify(registry).addHandler(isA(WebSocketHandler.class), isA(String[].class));
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   * <ul>
   *   <li>Given {@link ServletWebSocketHandlerRegistration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry); given ServletWebSocketHandlerRegistration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"})
  void testRegisterWebSocketHandlers_givenServletWebSocketHandlerRegistration() {
    // Arrange
    WebSocketConfiguration webSocketConfiguration = new WebSocketConfiguration(new TbWebSocketHandler());
    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), isA(String[].class)))
        .thenReturn(new ServletWebSocketHandlerRegistration());

    // Act
    webSocketConfiguration.registerWebSocketHandlers(registry);

    // Assert
    verify(registry).addHandler(isA(WebSocketHandler.class), isA(String[].class));
  }

  /**
   * Test {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   * <ul>
   *   <li>Given {@link WebSocketConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketConfiguration#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry); given WebSocketConfiguration")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebSocketConfiguration.registerWebSocketHandlers(WebSocketHandlerRegistry)"})
  void testRegisterWebSocketHandlers_givenWebSocketConfiguration() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> webSocketConfiguration.registerWebSocketHandlers(mock(WebSocketHandlerRegistry.class)));
  }
}
