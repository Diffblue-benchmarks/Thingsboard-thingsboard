package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class AbstractTbLwM2MRequestCallbackDiffblueTest {
  /**
   * Test {@link AbstractTbLwM2MRequestCallback#onValidationError(String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbLwM2MRequestCallback#onValidationError(String, String)}
   */
  @Test
  @DisplayName("Test onValidationError(String, String); then calls log(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbLwM2MRequestCallback.onValidationError(String, String)"})
  void testOnValidationError_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback tbLwM2MCancelAllObserveCallback =
        new TbLwM2MCancelAllObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act
    tbLwM2MCancelAllObserveCallback.onValidationError("Params", "Msg");

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: Msg"));
  }

  /**
   * Test {@link AbstractTbLwM2MRequestCallback#onError(String, Exception)}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbLwM2MRequestCallback#onError(String, Exception)}
   */
  @Test
  @DisplayName("Test onError(String, Exception); then calls log(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbLwM2MRequestCallback.onError(String, Exception)"})
  void testOnError_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback tbLwM2MCancelAllObserveCallback =
        new TbLwM2MCancelAllObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act
    tbLwM2MCancelAllObserveCallback.onError("Params", new Exception());

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception"));
  }
}
