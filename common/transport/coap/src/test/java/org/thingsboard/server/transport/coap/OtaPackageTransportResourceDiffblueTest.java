package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
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
import org.thingsboard.server.common.data.ota.OtaPackageType;

class OtaPackageTransportResourceDiffblueTest {
  /**
   * Test {@link OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext,
   * OtaPackageType)}.
   *
   * <ul>
   *   <li>Then return Path is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageTransportResource(CoapTransportContext, OtaPackageType); then return Path is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void OtaPackageTransportResource.<init>(CoapTransportContext, OtaPackageType)"
  })
  void testNewOtaPackageTransportResource_thenReturnPathIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    OtaPackageTransportResource actualOtaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Assert
    assertEquals("", actualOtaPackageTransportResource.getPath());
    assertEquals("fw", actualOtaPackageTransportResource.getName());
    assertEquals("fw", actualOtaPackageTransportResource.getURI());
    assertNull(actualOtaPackageTransportResource.getExecutor());
    assertNull(actualOtaPackageTransportResource.getObserveType());
    assertNull(actualOtaPackageTransportResource.getParent());
    assertNull(actualOtaPackageTransportResource.transportService);
    assertEquals(0, actualOtaPackageTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualOtaPackageTransportResource.getObserverCount());
    assertTrue(actualOtaPackageTransportResource.getChildren().isEmpty());
    assertTrue(actualOtaPackageTransportResource.isCachable());
    assertTrue(actualOtaPackageTransportResource.isObservable());
    assertTrue(actualOtaPackageTransportResource.isVisible());
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenAxaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    exchange2.setLocationQuery("");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenEmptyString() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is one.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); given one; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenOne_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is one.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); given one; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenOne_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne2() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    exchange2.setLocationQuery("");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenPath() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenPath2() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    exchange2.setLocationQuery("");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@code Query}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); given 'Query'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_givenQuery() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");

    // Act
    otaPackageTransportResource.processHandlePost(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandlePost(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtaPackageTransportResource.processHandlePost(CoapExchange)"})
  void testProcessHandlePost_whenCoapExchangeWithExchangeIsExchange() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    otaPackageTransportResource.processHandlePost(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link OtaPackageTransportResource#getChild(String)}.
   *
   * <p>Method under test: {@link OtaPackageTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.californium.core.server.resources.Resource OtaPackageTransportResource.getChild(String)"
  })
  void testGetChild() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Act and Assert
    assertSame(otaPackageTransportResource, otaPackageTransportResource.getChild("Name"));
  }
}
