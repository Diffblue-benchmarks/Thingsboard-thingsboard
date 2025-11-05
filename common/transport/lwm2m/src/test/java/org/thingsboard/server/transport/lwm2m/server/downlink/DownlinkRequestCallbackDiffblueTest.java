package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class DownlinkRequestCallbackDiffblueTest {
  /**
   * Test {@link DownlinkRequestCallback#onSent(Object)}.
   *
   * <p>Method under test: {@link DownlinkRequestCallback#onSent(Object)}
   */
  @Test
  @DisplayName("Test onSent(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DownlinkRequestCallback.onSent(Object)"})
  void testOnSent() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    TbLwM2MCancelAllObserveCallback tbLwM2MCancelAllObserveCallback =
        new TbLwM2MCancelAllObserveCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act and Assert
    assertTrue(tbLwM2MCancelAllObserveCallback.onSent(mock(TbLwM2MCancelAllRequest.class)));
  }
}
