package org.thingsboard.server.transport.coap.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class CoapDeviceAuthCallbackDiffblueTest {
  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(
        new CoapExchange(new Exchange(request, "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(new CoapExchange(exchange),
        mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse3() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse4() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse5() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  void testOnSuccessWithValidateDeviceCredentialsResponse6() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'A'; then calls sendResponse(Exchange, Response)")
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenA_thenCallsSendResponse() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(false);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   * with {@code ValidateDeviceCredentialsResponse}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'true'; then calls accept(Object, Object)")
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenTrue_thenCallsAccept() {
    // Arrange
    BiConsumer<ValidateDeviceCredentialsResponse, DeviceProfile> onSuccess = mock(BiConsumer.class);
    doNothing().when(onSuccess).accept(Mockito.<ValidateDeviceCredentialsResponse>any(), Mockito.<DeviceProfile>any());
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        onSuccess);
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(true);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert that nothing has changed
    verify(onSuccess).accept(isA(ValidateDeviceCredentialsResponse.class), isA(DeviceProfile.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  void testOnError() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Failed to process request");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  void testOnError2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Failed to process request");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} ETag is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) ETag is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeETagIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is empty string")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsEmptyString() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  void testOnError_givenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapDeviceAuthCallback coapDeviceAuthCallback = new CoapDeviceAuthCallback(new CoapExchange(exchange),
        mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
