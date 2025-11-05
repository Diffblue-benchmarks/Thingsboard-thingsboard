package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.transport.coap.adaptors.JsonCoapAdaptor;
import org.thingsboard.server.transport.coap.adaptors.ProtoCoapAdaptor;
import org.thingsboard.server.transport.coap.client.CoapClientContext;
import org.thingsboard.server.transport.coap.efento.adaptor.EfentoCoapAdaptor;

class CoapTransportContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CoapTransportContext#getClientContext()}
   *   <li>{@link CoapTransportContext#getEfentoCoapAdaptor()}
   *   <li>{@link CoapTransportContext#getJsonCoapAdaptor()}
   *   <li>{@link CoapTransportContext#getPagingTransmissionWindow()}
   *   <li>{@link CoapTransportContext#getPiggybackTimeout()}
   *   <li>{@link CoapTransportContext#getProtoCoapAdaptor()}
   *   <li>{@link CoapTransportContext#getPsmActivityTimer()}
   *   <li>{@link CoapTransportContext#getRpcAwaitingAck()}
   *   <li>{@link CoapTransportContext#getSessionReportTimeout()}
   *   <li>{@link CoapTransportContext#getTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CoapClientContext CoapTransportContext.getClientContext()",
    "EfentoCoapAdaptor CoapTransportContext.getEfentoCoapAdaptor()",
    "JsonCoapAdaptor CoapTransportContext.getJsonCoapAdaptor()",
    "long CoapTransportContext.getPagingTransmissionWindow()",
    "Long CoapTransportContext.getPiggybackTimeout()",
    "ProtoCoapAdaptor CoapTransportContext.getProtoCoapAdaptor()",
    "long CoapTransportContext.getPsmActivityTimer()",
    "ConcurrentMap CoapTransportContext.getRpcAwaitingAck()",
    "long CoapTransportContext.getSessionReportTimeout()",
    "Long CoapTransportContext.getTimeout()"
  })
  void testGettersAndSetters() {
    // Arrange
    CoapTransportContext coapTransportContext = new CoapTransportContext();

    // Act
    CoapClientContext actualClientContext = coapTransportContext.getClientContext();
    EfentoCoapAdaptor actualEfentoCoapAdaptor = coapTransportContext.getEfentoCoapAdaptor();
    JsonCoapAdaptor actualJsonCoapAdaptor = coapTransportContext.getJsonCoapAdaptor();
    long actualPagingTransmissionWindow = coapTransportContext.getPagingTransmissionWindow();
    Long actualPiggybackTimeout = coapTransportContext.getPiggybackTimeout();
    ProtoCoapAdaptor actualProtoCoapAdaptor = coapTransportContext.getProtoCoapAdaptor();
    long actualPsmActivityTimer = coapTransportContext.getPsmActivityTimer();
    ConcurrentMap<Integer, ToDeviceRpcRequestMsg> actualRpcAwaitingAck =
        coapTransportContext.getRpcAwaitingAck();
    long actualSessionReportTimeout = coapTransportContext.getSessionReportTimeout();

    // Assert
    assertNull(actualPiggybackTimeout);
    assertNull(coapTransportContext.getTimeout());
    assertNull(actualJsonCoapAdaptor);
    assertNull(actualProtoCoapAdaptor);
    assertNull(actualClientContext);
    assertNull(actualEfentoCoapAdaptor);
    assertEquals(0L, actualPagingTransmissionWindow);
    assertEquals(0L, actualPsmActivityTimer);
    assertEquals(0L, actualSessionReportTimeout);
    assertTrue(actualRpcAwaitingAck.isEmpty());
  }
}
