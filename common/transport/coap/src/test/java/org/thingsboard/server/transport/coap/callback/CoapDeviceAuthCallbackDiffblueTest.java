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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class CoapDeviceAuthCallbackDiffblueTest {
  /**
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(new CoapExchange(exchange), mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse2() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse3() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse4() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse5() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse6() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse7() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenA() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenA2() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

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
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenNull() {
    // Arrange
    Request request = Request.newDelete();
    request.setLocalAddress(InetSocketAddress.createUnresolved("foo", 1), true);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(new CoapExchange(exchange), mock(BiConsumer.class));

    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(true);
    when(msg.getDeviceProfile()).thenReturn(null);

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)} with {@code
   * ValidateDeviceCredentialsResponse}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapDeviceAuthCallback#onSuccess(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(ValidateDeviceCredentialsResponse) with 'ValidateDeviceCredentialsResponse'; given 'true'; then calls accept(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onSuccess(ValidateDeviceCredentialsResponse)"})
  void testOnSuccessWithValidateDeviceCredentialsResponse_givenTrue_thenCallsAccept() {
    // Arrange
    BiConsumer<ValidateDeviceCredentialsResponse, DeviceProfile> onSuccess = mock(BiConsumer.class);
    doNothing()
        .when(onSuccess)
        .accept(Mockito.<ValidateDeviceCredentialsResponse>any(), Mockito.<DeviceProfile>any());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(new CoapExchange(exchange), onSuccess);

    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.hasDeviceInfo()).thenReturn(true);
    when(msg.getDeviceProfile()).thenReturn(new DeviceProfile());

    // Act
    coapDeviceAuthCallback.onSuccess(msg);

    // Assert
    verify(onSuccess)
        .accept(isA(ValidateDeviceCredentialsResponse.class), isA(DeviceProfile.class));
    verify(msg).getDeviceProfile();
    verify(msg).hasDeviceInfo();
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(ResponseCode)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange respond(ResponseCode) does nothing; then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeRespondDoesNothing_thenCallsRespond() {
    // Arrange
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(exchange).respond(ResponseCode.INTERNAL_SERVER_ERROR);
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given Exchange sendResponse(Response) does nothing; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenExchangeSendResponseDoesNothing_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Request} {@link Request#getOptions()} return {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given Request getOptions() return OptionSet(); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenRequestGetOptionsReturnOptionSet_thenCallsGetOptions() {
    // Arrange
    Request request = mock(Request.class);
    when(request.isMulticast()).thenReturn(true);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(new CoapExchange(exchange), mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isMulticast();
    verify(request).isObserve();
  }
}
