package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.subscription.SubscriptionErrorCode;
import org.thingsboard.server.service.ws.DefaultWebSocketService.WsCmdHandler;
import org.thingsboard.server.service.ws.telemetry.sub.TelemetrySubscriptionUpdate;

@ContextConfiguration(classes = {WsCmdHandler.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultWebSocketServiceDiffblueTest {
  @MockBean
  private BiConsumer<WebSocketSessionRef, WsCmd> biConsumer;

  @InjectMocks
  private DefaultWebSocketService defaultWebSocketService;

  @Autowired
  private WsCmdHandler<WsCmd> wsCmdHandler;

  /**
   * Test {@link DefaultWebSocketService#handleCommands(WebSocketSessionRef, WsCommandsWrapper)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultWebSocketService#handleCommands(WebSocketSessionRef, WsCommandsWrapper)}
   */
  @Test
  @DisplayName("Test handleCommands(WebSocketSessionRef, WsCommandsWrapper); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultWebSocketService.handleCommands(WebSocketSessionRef, WsCommandsWrapper)"})
  void testHandleCommands_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    WsCommandsWrapper commandsWrapper = mock(WsCommandsWrapper.class);
    when(commandsWrapper.getCmds()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultWebSocketService.handleCommands(sessionRef, commandsWrapper));
    verify(commandsWrapper).getCmds();
  }

  /**
   * Test {@link DefaultWebSocketService#sendUpdate(String, int, TelemetrySubscriptionUpdate)} with {@code String}, {@code int}, {@code TelemetrySubscriptionUpdate}.
   * <p>
   * Method under test: {@link DefaultWebSocketService#sendUpdate(String, int, TelemetrySubscriptionUpdate)}
   */
  @Test
  @DisplayName("Test sendUpdate(String, int, TelemetrySubscriptionUpdate) with 'String', 'int', 'TelemetrySubscriptionUpdate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultWebSocketService.sendUpdate(String, int, TelemetrySubscriptionUpdate)"})
  void testSendUpdateWithStringIntTelemetrySubscriptionUpdate() {
    // Arrange
    TelemetrySubscriptionUpdate update = mock(TelemetrySubscriptionUpdate.class);
    when(update.copyWithNewSubscriptionId(anyInt()))
        .thenReturn(new TelemetrySubscriptionUpdate(1, SubscriptionErrorCode.NO_ERROR));

    // Act
    defaultWebSocketService.sendUpdate("42", 1, update);

    // Assert
    verify(update).copyWithNewSubscriptionId(eq(1));
  }

  /**
   * Test {@link DefaultWebSocketService#getAggregation(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultWebSocketService#getAggregation(String)}
   */
  @Test
  @DisplayName("Test getAggregation(String); when empty string; then return 'NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Aggregation DefaultWebSocketService.getAggregation(String)"})
  void testGetAggregation_whenEmptyString_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(Aggregation.NONE, DefaultWebSocketService.getAggregation(""));
  }

  /**
   * Test {@link DefaultWebSocketService#getAggregation(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultWebSocketService#getAggregation(String)}
   */
  @Test
  @DisplayName("Test getAggregation(String); when 'null'; then return 'NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Aggregation DefaultWebSocketService.getAggregation(String)"})
  void testGetAggregation_whenNull_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(Aggregation.NONE, DefaultWebSocketService.getAggregation(null));
  }

  /**
   * Test {@link DefaultWebSocketService#newCmdHandler(BiConsumer)}.
   * <p>
   * Method under test: {@link DefaultWebSocketService#newCmdHandler(BiConsumer)}
   */
  @Test
  @DisplayName("Test newCmdHandler(BiConsumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WsCmdHandler DefaultWebSocketService.newCmdHandler(BiConsumer)"})
  void testNewCmdHandler() {
    // Arrange
    BiConsumer<WebSocketSessionRef, WsCmd> handler = mock(BiConsumer.class);

    // Act
    WsCmdHandler<WsCmd> actualNewCmdHandlerResult = DefaultWebSocketService.newCmdHandler(handler);

    // Assert
    assertSame(handler, actualNewCmdHandlerResult.getHandler());
  }

  /**
   * Test WsCmdHandler getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCmdHandler#WsCmdHandler(BiConsumer)}
   *   <li>{@link WsCmdHandler#getHandler()}
   * </ul>
   */
  @Test
  @DisplayName("Test WsCmdHandler getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsCmdHandler.<init>(BiConsumer)", "BiConsumer WsCmdHandler.getHandler()"})
  void testWsCmdHandlerGettersAndSetters() {
    // Arrange
    BiConsumer<WebSocketSessionRef, WsCmd> handler = mock(BiConsumer.class);

    // Act
    WsCmdHandler<WsCmd> actualWsCmdHandler = new WsCmdHandler<>(handler);

    // Assert
    assertSame(handler, actualWsCmdHandler.getHandler());
  }

  /**
   * Test WsCmdHandler {@link WsCmdHandler#handle(WebSocketSessionRef, WsCmd)}.
   * <p>
   * Method under test: {@link WsCmdHandler#handle(WebSocketSessionRef, WsCmd)}
   */
  @Test
  @DisplayName("Test WsCmdHandler handle(WebSocketSessionRef, WsCmd)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsCmdHandler.handle(WebSocketSessionRef, WsCmd)"})
  void testWsCmdHandlerHandle() {
    // Arrange
    doNothing().when(biConsumer).accept(Mockito.<WebSocketSessionRef>any(), Mockito.<WsCmd>any());
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act
    wsCmdHandler.handle(sessionRef, new AuthCmd(1, "ABC123"));

    // Assert
    verify(biConsumer).accept(isA(WebSocketSessionRef.class), isA(WsCmd.class));
  }
}
