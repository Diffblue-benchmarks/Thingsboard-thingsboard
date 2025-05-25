package org.thingsboard.server.transport.coap.efento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
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
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray(3));
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, new JsonArray(3));

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, null);
    EfentoTelemetry efentoTelemetry2 = new EfentoTelemetry(1L, null);

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EfentoTelemetry#equals(Object)}
   *   <li>{@link EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray(3));

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(3L, new JsonArray(3));

    // Act and Assert
    assertNotEquals(efentoTelemetry, new EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, null);

    // Act and Assert
    assertNotEquals(efentoTelemetry, new EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonNull());

    // Act and Assert
    assertNotEquals(efentoTelemetry, new EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoTelemetry(1L, new JsonArray(3)), null);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EfentoTelemetry.equals(Object)", "int EfentoTelemetry.hashCode()"})
  void testEfentoTelemetryEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoTelemetry(1L, new JsonArray(3)), "Different type to EfentoTelemetry");
  }

  /**
   * Test EfentoTelemetry getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EfentoTelemetry.getTs()", "JsonElement EfentoTelemetry.getValues()",
      "void EfentoTelemetry.setTs(long)", "void EfentoTelemetry.setValues(JsonElement)",
      "String EfentoTelemetry.toString()"})
  void testEfentoTelemetryGettersAndSetters() {
    // Arrange
    EfentoTelemetry efentoTelemetry = new EfentoTelemetry(1L, new JsonArray(3));

    // Act
    efentoTelemetry.setTs(1L);
    JsonArray values = new JsonArray(3);
    efentoTelemetry.setValues(values);
    String actualToStringResult = efentoTelemetry.toString();
    long actualTs = efentoTelemetry.getTs();

    // Assert
    assertEquals("CoapEfentoTransportResource.EfentoTelemetry(ts=1, values=[])", actualToStringResult);
    assertEquals(1L, actualTs);
    assertSame(values, efentoTelemetry.getValues());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)}.
   * <p>
   * Method under test: {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry new EfentoTelemetry(long, JsonElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EfentoTelemetry.<init>(long, JsonElement)"})
  void testEfentoTelemetryNewEfentoTelemetry() {
    // Arrange
    JsonArray values = new JsonArray(3);

    // Act
    EfentoTelemetry actualEfentoTelemetry = new EfentoTelemetry(1L, values);

    // Assert
    assertEquals(1L, actualEfentoTelemetry.getTs());
    assertSame(values, actualEfentoTelemetry.getValues());
  }

  /**
   * Test {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return Path is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}
   */
  @Test
  @DisplayName("Test new CoapEfentoTransportResource(CoapTransportContext, String); when 'Name'; then return Path is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.<init>(CoapTransportContext, String)"})
  void testNewCoapEfentoTransportResource_whenName_thenReturnPathIsEmptyString() {
    // Arrange and Act
    CoapEfentoTransportResource actualCoapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");

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
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet2() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenA() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenEmptyString() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(2L);

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_whenCoapExchangeWithExchangeIsExchange() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>Given {@link Request} {@link Message#getOptions()} return {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given Request getOptions() return OptionSet(); then calls getOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenRequestGetOptionsReturnOptionSet_thenCallsGetOptions() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Request request = mock(Request.class);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    // Act
    coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange));

    // Assert
    verify(request).getOptions();
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>Then calls {@link CoapExchange#advanced()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); then calls advanced()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_thenCallsAdvanced() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    when(exchange.advanced())
        .thenReturn(new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class)));

    // Act
    coapEfentoTransportResource.processHandlePost(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(eq(ResponseCode.BAD_REQUEST));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); then calls getOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_thenCallsGetOptions() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriPath("Unexpected uri path size, uri path: [{}]");
    Request request = mock(Request.class);
    when(request.getOptions()).thenReturn(optionSet);
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    // Act
    coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange));

    // Assert
    verify(request).getOptions();
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>When {@link Exchange} {@link Exchange#getRequest()} return newDelete.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); when Exchange getRequest() return newDelete")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_whenExchangeGetRequestReturnNewDelete() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
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
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.californium.core.server.resources.Resource CoapEfentoTransportResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");

    // Act and Assert
    assertSame(coapEfentoTransportResource, coapEfentoTransportResource.getChild("Name"));
  }

  /**
   * Test {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}
   */
  @Test
  @DisplayName("Test getEfentoMeasurements(ProtoMeasurements, UUID); when DefaultInstance; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List CoapEfentoTransportResource.getEfentoMeasurements(ProtoMeasurements, UUID)"})
  void testGetEfentoMeasurements_whenDefaultInstance_thenThrowIllegalStateException() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    ProtoMeasurements protoMeasurements = ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> coapEfentoTransportResource.getEfentoMeasurements(protoMeasurements,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
