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
package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.monitoring.util.TbStopWatch;

@ExtendWith(MockitoExtension.class)
class WsClientFactoryDiffblueTest {
  @Mock private TbStopWatch tbStopWatch;

  @InjectMocks private WsClientFactory wsClientFactory;

  /**
   * Test {@link WsClientFactory#createClient(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link WsClientFactory#createClient(String)}
   */
  @Test
  @DisplayName("Test createClient(String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.monitoring.client.WsClient WsClientFactory.createClient(String)"
  })
  void testCreateClient_thenThrowIllegalStateException() throws Exception {
    // Arrange
    doThrow(new IllegalStateException()).when(tbStopWatch).start();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> wsClientFactory.createClient("ABC123"));
    verify(tbStopWatch).start();
  }
}
