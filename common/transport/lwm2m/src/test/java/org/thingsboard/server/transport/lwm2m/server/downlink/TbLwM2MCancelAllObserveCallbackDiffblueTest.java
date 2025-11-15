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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MCancelAllObserveCallbackDiffblueTest {
  /**
   * Method under test:
   * {@link TbLwM2MCancelAllObserveCallback#onSuccess(TbLwM2MCancelAllRequest, Integer)}
   */
  @Test
  void testOnSuccess() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    (new TbLwM2MCancelAllObserveCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")))
        .onSuccess(mock(TbLwM2MCancelAllRequest.class), 3);

    // Assert
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: Cancel of all observations was successful. Result: [3]"));
  }
}
