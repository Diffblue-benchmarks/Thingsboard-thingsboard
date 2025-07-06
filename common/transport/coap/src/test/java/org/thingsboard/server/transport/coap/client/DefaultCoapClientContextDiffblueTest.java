package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.device.data.PowerMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultCoapClientContextDiffblueTest {
  @InjectMocks private DefaultCoapClientContext defaultCoapClientContext;

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation() {
    // Arrange
    TbCoapClientState clientState = new TbCoapClientState(null);
    CoapExchange exchange =
        new CoapExchange(
            new Exchange(
                Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class)));
    clientState.setAttrs(new TbCoapObservationState(exchange, "ABC123"));
    clientState.setRpc(null);
    clientState.setSession(null);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(
            clientState,
            "ABC123",
            new CoapExchange(
                new Exchange(
                    Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    TbCoapObservationState attrs = clientState.getAttrs();
    assertEquals("ABC123", attrs.getToken());
    assertNull(attrs.getObserveRelation());
    assertEquals(0, attrs.getObserveCounter().get());
    assertFalse(actualRegisterAttributeObservationResult);
    assertSame(exchange, attrs.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation2() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenThrow(new IllegalArgumentException("ABC123"));

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation3() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenThrow(new IllegalArgumentException("foo"));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapObservationState} {@link TbCoapObservationState#getToken()} return
   *       {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); given TbCoapObservationState getToken() return 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_givenTbCoapObservationStateGetTokenReturnAbc123() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(
            clientState,
            "ABC123",
            new CoapExchange(
                new Exchange(
                    Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    verify(attrs).getToken();
    assertFalse(actualRegisterAttributeObservationResult);
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getCurrentRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalArgumentException("foo"));
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(exchange).getCurrentRequest();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation() {
    // Arrange
    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    CoapExchange exchange =
        new CoapExchange(
            new Exchange(
                Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class)));
    clientState.setRpc(new TbCoapObservationState(exchange, "ABC123"));
    clientState.setSession(null);

    // Act
    boolean actualRegisterRpcObservationResult =
        defaultCoapClientContext.registerRpcObservation(
            clientState,
            "ABC123",
            new CoapExchange(
                new Exchange(
                    Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    TbCoapObservationState rpc = clientState.getRpc();
    assertEquals("ABC123", rpc.getToken());
    assertNull(rpc.getObserveRelation());
    assertEquals(0, rpc.getObserveCounter().get());
    assertFalse(actualRegisterRpcObservationResult);
    assertSame(exchange, rpc.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation2() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenThrow(new IllegalArgumentException("ABC123"));

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation3() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenThrow(new IllegalArgumentException("foo"));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapObservationState} {@link TbCoapObservationState#getToken()} return
   *       {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); given TbCoapObservationState getToken() return 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_givenTbCoapObservationStateGetTokenReturnAbc123() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);

    // Act
    boolean actualRegisterRpcObservationResult =
        defaultCoapClientContext.registerRpcObservation(
            clientState,
            "ABC123",
            new CoapExchange(
                new Exchange(
                    Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    verify(rpc).getToken();
    assertFalse(actualRegisterRpcObservationResult);
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); then calls getCurrentRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalArgumentException("foo"));
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState,
                "ABC123",
                new CoapExchange(
                    new Exchange(
                        Request.newDelete(),
                        "Peers Identity",
                        Origin.LOCAL,
                        mock(Executor.class)))));
    verify(exchange).getCurrentRequest();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}.
   *
   * <ul>
   *   <li>When {@code ABC123}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  @DisplayName("Test getNotificationCounterByToken(String); when 'ABC123'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.concurrent.atomic.AtomicInteger DefaultCoapClientContext.getNotificationCounterByToken(String)"
  })
  void testGetNotificationCounterByToken_whenAbc123_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultCoapClientContext.getNotificationCounterByToken("ABC123"));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCoapClientState#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getDeviceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation_thenCallsGetDeviceId() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getSession()).thenReturn(null);
    when(state.getDeviceId()).thenReturn(null);
    doNothing().when(state).lock();
    doNothing().when(state).unlock();

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state,
        "ABC123",
        new CoapExchange(
            new Exchange(
                Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    verify(state).getDeviceId();
    verify(state).getSession();
    verify(state).lock();
    verify(state).unlock();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCoapClientState#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); then calls getDeviceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_thenCallsGetDeviceId() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getSession()).thenReturn(null);
    when(state.getDeviceId()).thenReturn(null);
    doNothing().when(state).lock();
    doNothing().when(state).unlock();

    // Act
    defaultCoapClientContext.deregisterRpcObservation(
        state,
        "ABC123",
        new CoapExchange(
            new Exchange(
                Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));

    // Assert
    verify(state).getDeviceId();
    verify(state).getSession();
    verify(state).lock();
    verify(state).unlock();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>Given {@code PSM}.
   *   <li>When {@link TbCoapClientState} {@link TbCoapClientState#getPowerMode()} return {@code
   *       PSM}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; given 'PSM'; when TbCoapClientState getPowerMode() return 'PSM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_givenPsm_whenTbCoapClientStateGetPowerModeReturnPsm() {
    // Arrange
    TbCoapClientState client = mock(TbCoapClientState.class);
    doThrow(new IllegalArgumentException("[{}] Switch sleeping from: {} to: {}"))
        .when(client)
        .lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; when TbCoapClientState(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_whenTbCoapClientStateWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultCoapClientContext.awake(new TbCoapClientState(null)));
  }
}
