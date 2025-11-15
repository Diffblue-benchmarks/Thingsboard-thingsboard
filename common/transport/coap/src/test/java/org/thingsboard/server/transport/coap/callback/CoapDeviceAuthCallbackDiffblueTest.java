/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class CoapDeviceAuthCallbackDiffblueTest {
  /**
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess2() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess3() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess4() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess5() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess6() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess7() {
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
   * Method under test:
   * {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testOnSuccess8() {
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
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError() {
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

  /**
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError2() {
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
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError3() {
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
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError4() {
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
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError5() throws UnsupportedEncodingException {
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
   * Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  void testOnError6() {
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
}
