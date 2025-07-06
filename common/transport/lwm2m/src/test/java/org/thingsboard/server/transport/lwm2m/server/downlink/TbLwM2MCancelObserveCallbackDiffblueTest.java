package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MCancelObserveCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MCancelObserveCallback#TbLwM2MCancelObserveCallback(LwM2MTelemetryLogService,
   * LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * TbLwM2MCancelObserveCallback#TbLwM2MCancelObserveCallback(LwM2MTelemetryLogService,
   * LwM2mClient, String)}
   */
  @Test
  @DisplayName(
      "Test new TbLwM2MCancelObserveCallback(LwM2MTelemetryLogService, LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MCancelObserveCallback.<init>(LwM2MTelemetryLogService, LwM2mClient, String)"
  })
  void testNewTbLwM2MCancelObserveCallback() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act and Assert
    LwM2mClient lwM2mClient =
        new TbLwM2MCancelObserveCallback(
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

  /**
   * Test {@link TbLwM2MCancelObserveCallback#onSuccess(TbLwM2MCancelObserveRequest, Integer)} with
   * {@code TbLwM2MCancelObserveRequest}, {@code Integer}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2MCancelObserveCallback#onSuccess(TbLwM2MCancelObserveRequest, Integer)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(TbLwM2MCancelObserveRequest, Integer) with 'TbLwM2MCancelObserveRequest', 'Integer'; then calls log(LwM2mClient, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbLwM2MCancelObserveCallback.onSuccess(TbLwM2MCancelObserveRequest, Integer)"
  })
  void testOnSuccessWithTbLwM2MCancelObserveRequestInteger_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    new TbLwM2MCancelObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42")
        .onSuccess(mock(TbLwM2MCancelObserveRequest.class), 3);

    // Assert
    verify(logService)
        .log(isA(LwM2mClient.class), eq("[info]: Cancel Observe for [42] successful. Result: [3]"));
  }
}
