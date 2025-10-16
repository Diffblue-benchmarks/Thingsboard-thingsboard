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
package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MDiscoverCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MDiscoverCallback#TbLwM2MDiscoverCallback(LwM2MTelemetryLogService,
   * LwM2mClient, String)}.
   *
   * <p>Method under test: {@link
   * TbLwM2MDiscoverCallback#TbLwM2MDiscoverCallback(LwM2MTelemetryLogService, LwM2mClient, String)}
   */
  @Test
  @DisplayName("Test new TbLwM2MDiscoverCallback(LwM2MTelemetryLogService, LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MDiscoverCallback.<init>(LwM2MTelemetryLogService, LwM2mClient, String)"
  })
  void testNewTbLwM2MDiscoverCallback() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act
    TbLwM2MDiscoverCallback actualTbLwM2MDiscoverCallback =
        new TbLwM2MDiscoverCallback(
            logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");

    // Assert
    LwM2mClient lwM2mClient = actualTbLwM2MDiscoverCallback.client;
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
