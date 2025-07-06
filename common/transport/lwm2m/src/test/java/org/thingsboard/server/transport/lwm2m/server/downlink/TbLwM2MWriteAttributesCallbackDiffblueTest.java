package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MWriteAttributesCallbackDiffblueTest {
  /**
   * Test {@link
   * TbLwM2MWriteAttributesCallback#TbLwM2MWriteAttributesCallback(LwM2MTelemetryLogService,
   * LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * TbLwM2MWriteAttributesCallback#TbLwM2MWriteAttributesCallback(LwM2MTelemetryLogService,
   * LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test new TbLwM2MWriteAttributesCallback(LwM2MTelemetryLogService, LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MWriteAttributesCallback.<init>(LwM2MTelemetryLogService, LwM2mClient, String)"
  })
  void testNewTbLwM2MWriteAttributesCallback() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    LwM2mClient lwM2mClient =
        new TbLwM2MWriteAttributesCallback(
                logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42")
            .client;
    assertNull(lwM2mClient.getClientSupportContentFormats());
    assertNull(lwM2mClient.getDefaultContentFormat());
    assertNull(lwM2mClient.getDeviceId());
    assertNull(lwM2mClient.getEdrxCycle());
    assertEquals("https://config.us-east-2.amazonaws.com", lwM2mClient.getEndpoint());
    assertNull(lwM2mClient.getLastSentRpcId());
    assertEquals(0L, lwM2mClient.getLastUplinkTime());
    assertEquals("42", lwM2mClient.getNodeId());
    assertNull(lwM2mClient.getPagingTransmissionWindow());
    assertNull(lwM2mClient.getPowerMode());
    assertNull(lwM2mClient.getProfileId());
    assertNull(lwM2mClient.getPsmActivityTimer());
    assertNull(lwM2mClient.getRegistration());
    assertTrue(lwM2mClient.getResources().isEmpty());
    AtomicInteger retryAttempts = lwM2mClient.getRetryAttempts();
    assertEquals(0, retryAttempts.get());
    assertEquals(0, retryAttempts.getAndDecrement());
    assertEquals(-1, retryAttempts.getAndIncrement());
    assertNull(lwM2mClient.getSession());
    assertTrue(lwM2mClient.getSharedAttributes().isEmpty());
    assertNull(lwM2mClient.getSleepTask());
    assertEquals(LwM2MClientState.CREATED, lwM2mClient.getState());
    assertNull(lwM2mClient.getSupportedClientObjects());
    assertNull(lwM2mClient.getTenantId());
    assertFalse(lwM2mClient.isAsleep());
  }
}
