package org.thingsboard.server.transport.coap.efento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoMeasurements;
import org.thingsboard.server.transport.coap.CoapTransportContext;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource.EfentoTelemetry;

class CoapEfentoTransportResourceDiffblueTest {
  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link
   * EfentoTelemetry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    assertEquals(efentoTelemetry.hashCode(), efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link
   * EfentoTelemetry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, null);
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, null);

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    assertEquals(efentoTelemetry.hashCode(), efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link
   * EfentoTelemetry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(3L, new JsonArray());
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertNotEquals(efentoTelemetry, efentoTelemetry2);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, null);
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertNotEquals(efentoTelemetry, efentoTelemetry2);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonNull());
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertNotEquals(efentoTelemetry, efentoTelemetry2);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertNotEquals(efentoTelemetry, null);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test EfentoTelemetry equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());

    // Act and Assert
    assertNotEquals(efentoTelemetry, "Different type to EfentoTelemetry");
  }

  /**
   * Test EfentoTelemetry getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EfentoTelemetry#setTs(long)}
   *   <li>{@link EfentoTelemetry#setValues(JsonElement)}
   *   <li>{@link EfentoTelemetry#toString()}
   *   <li>{@link EfentoTelemetry#getTs()}
   *   <li>{@link EfentoTelemetry#getValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long EfentoTelemetry.getTs()",
    "JsonElement EfentoTelemetry.getValues()",
    "void EfentoTelemetry.setTs(long)",
    "void EfentoTelemetry.setValues(JsonElement)",
    "String EfentoTelemetry.toString()"
  })
  void testEfentoTelemetryGettersAndSetters() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray());

    // Act
    efentoTelemetry.setTs(1L);
    JsonArray values = new JsonArray();
    efentoTelemetry.setValues(values);
    String actualToStringResult = efentoTelemetry.toString();
    long actualTs = efentoTelemetry.getTs();

    // Assert
    assertEquals(
        "CoapEfentoTransportResource.EfentoTelemetry(ts=1, values=[])", actualToStringResult);
    assertEquals(1L, actualTs);
    assertSame(values, efentoTelemetry.getValues());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)}.
   *
   * <p>Method under test: {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry new EfentoTelemetry(long, JsonElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EfentoTelemetry.<init>(long, JsonElement)"})
  void testEfentoTelemetryNewEfentoTelemetry() {
    // Arrange
    JsonArray values = new JsonArray();

    // Act
    EfentoTelemetry actualEfentoTelemetry = new EfentoTelemetry(1L, values);

    // Assert
    assertEquals(1L, actualEfentoTelemetry.getTs());
    assertSame(values, actualEfentoTelemetry.getValues());
  }

  /**
   * Test {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Path is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}
   */
  @Test
  @DisplayName(
      "Test new CoapEfentoTransportResource(CoapTransportContext, String); when 'Name'; then return Path is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.<init>(CoapTransportContext, String)"})
  void testNewCoapEfentoTransportResource_whenName_thenReturnPathIsEmptyString() {
    // Arrange and Act
    CoapEfentoTransportResource actualCoapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    // Assert
    assertEquals("", actualCoapEfentoTransportResource.getPath());
    assertEquals("Name", actualCoapEfentoTransportResource.getName());
    assertEquals("Name", actualCoapEfentoTransportResource.getURI());
    assertNull(actualCoapEfentoTransportResource.getExecutor());
    assertNull(actualCoapEfentoTransportResource.getParent());
    assertEquals(0, actualCoapEfentoTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualCoapEfentoTransportResource.getObserverCount());
    assertEquals(Type.CON, actualCoapEfentoTransportResource.getObserveType());
    assertTrue(actualCoapEfentoTransportResource.getChildren().isEmpty());
    assertTrue(actualCoapEfentoTransportResource.isCachable());
    assertTrue(actualCoapEfentoTransportResource.isObservable());
    assertTrue(actualCoapEfentoTransportResource.isVisible());
  }

  /**
   * Test {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext,
   * String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}
   */
  @Test
  @DisplayName(
      "Test new CoapEfentoTransportResource(CoapTransportContext, String); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.<init>(CoapTransportContext, String)"})
  void testNewCoapEfentoTransportResource_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CoapEfentoTransportResource(new CoapTransportContext(), "/"));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriPath {@code Invalid path: [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given OptionSet() addUriPath 'Invalid path: [{}]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenOptionSetAddUriPathInvalidPath() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriPath("Invalid path: [{}]");

    Request request = mock(Request.class);
    when(request.getSourceContext()).thenThrow(new IllegalStateException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(optionSet);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isObserve();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getSourceContext()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given OptionSet(); then calls getSourceContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenOptionSet_thenCallsGetSourceContext() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Request request = mock(Request.class);
    when(request.getSourceContext()).thenThrow(new IllegalStateException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isObserve();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link Request} {@link Request#getOptions()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given Request getOptions() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenRequestGetOptionsThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Request request = mock(Request.class);
    when(request.getOptions()).thenThrow(new IllegalStateException());

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(request);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link CoapExchange#advanced()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); then calls advanced()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_thenCallsAdvanced() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);

    // Act
    coapEfentoTransportResource.processHandleGet(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#getCurrentRequest()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); when Exchange getCurrentRequest() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_whenExchangeGetCurrentRequestThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalStateException());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange)));
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#getRequest()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); when Exchange getRequest() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_whenExchangeGetRequestThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange)));
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#sendResponse(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); when Exchange sendResponse(Response) does nothing; then calls sendResponse(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_whenExchangeSendResponseDoesNothing_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriPath {@code Unexpected uri path size, uri path:
   *       [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); given OptionSet() addUriPath 'Unexpected uri path size, uri path: [{}]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenOptionSetAddUriPathUnexpectedUriPathSizeUriPath() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriPath("Unexpected uri path size, uri path: [{}]");

    Request request = mock(Request.class);
    when(request.getSourceContext()).thenThrow(new IllegalStateException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(optionSet);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isObserve();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getSourceContext()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); given OptionSet(); then calls getSourceContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenOptionSet_thenCallsGetSourceContext() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Request request = mock(Request.class);
    when(request.getSourceContext()).thenThrow(new IllegalStateException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isObserve();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link Request} {@link Request#getOptions()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); given Request getOptions() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenRequestGetOptionsThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Request request = mock(Request.class);
    when(request.getOptions()).thenThrow(new IllegalStateException());

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(request);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange)));
    verify(request).getOptions();
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link CoapExchange#advanced()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); then calls advanced()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_thenCallsAdvanced() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);

    // Act
    coapEfentoTransportResource.processHandlePost(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#getCurrentRequest()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); when Exchange getCurrentRequest() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_whenExchangeGetCurrentRequestThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalStateException());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange)));
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#getRequest()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); when Exchange getRequest() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_whenExchangeGetRequestThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange)));
    verify(exchange).getRequest();
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#sendResponse(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); when Exchange sendResponse(Response) does nothing; then calls sendResponse(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_whenExchangeSendResponseDoesNothing_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange));

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#getChild(String)}.
   *
   * <p>Method under test: {@link CoapEfentoTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource CoapEfentoTransportResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    // Act
    Resource actualChild = coapEfentoTransportResource.getChild("Name");

    // Assert
    assertSame(coapEfentoTransportResource, actualChild);
  }

  /**
   * Test {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}
   */
  @Test
  @DisplayName("Test getEfentoMeasurements(ProtoMeasurements, UUID); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List CoapEfentoTransportResource.getEfentoMeasurements(ProtoMeasurements, UUID)"
  })
  void testGetEfentoMeasurements_givenIllegalStateException() throws UnsupportedEncodingException {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ProtoMeasurements protoMeasurements = mock(ProtoMeasurements.class);
    when(protoMeasurements.getBatteryStatus()).thenThrow(new IllegalStateException());
    when(protoMeasurements.getSerialNum()).thenReturn(byteString);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            coapEfentoTransportResource.getEfentoMeasurements(
                protoMeasurements, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    verify(byteString).toByteArray();
    verify(protoMeasurements).getBatteryStatus();
    verify(protoMeasurements).getSerialNum();
  }

  /**
   * Test {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link ProtoMeasurements#getChannelsList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}
   */
  @Test
  @DisplayName(
      "Test getEfentoMeasurements(ProtoMeasurements, UUID); given 'true'; then calls getChannelsList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List CoapEfentoTransportResource.getEfentoMeasurements(ProtoMeasurements, UUID)"
  })
  void testGetEfentoMeasurements_givenTrue_thenCallsGetChannelsList()
      throws UnsupportedEncodingException {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ProtoMeasurements protoMeasurements = mock(ProtoMeasurements.class);
    when(protoMeasurements.getBatteryStatus()).thenReturn(true);
    when(protoMeasurements.getMeasurementPeriodBase()).thenReturn(1);
    when(protoMeasurements.getMeasurementPeriodFactor()).thenReturn(3);
    when(protoMeasurements.getNextTransmissionAt()).thenReturn(1);
    when(protoMeasurements.getSignal()).thenReturn(1);
    when(protoMeasurements.getChannelsList()).thenReturn(new ArrayList<>());
    when(protoMeasurements.getSerialNum()).thenReturn(byteString);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            coapEfentoTransportResource.getEfentoMeasurements(
                protoMeasurements, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    verify(byteString).toByteArray();
    verify(protoMeasurements).getBatteryStatus();
    verify(protoMeasurements).getChannelsList();
    verify(protoMeasurements).getMeasurementPeriodBase();
    verify(protoMeasurements).getMeasurementPeriodFactor();
    verify(protoMeasurements).getNextTransmissionAt();
    verify(protoMeasurements).getSerialNum();
    verify(protoMeasurements).getSignal();
  }

  /**
   * Test {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}
   */
  @Test
  @DisplayName(
      "Test getEfentoMeasurements(ProtoMeasurements, UUID); when DefaultInstance; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List CoapEfentoTransportResource.getEfentoMeasurements(ProtoMeasurements, UUID)"
  })
  void testGetEfentoMeasurements_whenDefaultInstance_thenThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");
    ProtoMeasurements protoMeasurements = ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            coapEfentoTransportResource.getEfentoMeasurements(
                protoMeasurements, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
