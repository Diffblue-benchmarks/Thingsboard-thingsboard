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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultCoapClientContextDiffblueTest {
  @InjectMocks
  private DefaultCoapClientContext defaultCoapClientContext;

  /**
   * Test {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  @DisplayName("Test getNotificationCounterByToken(String); when 'ABC123'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.atomic.AtomicInteger DefaultCoapClientContext.getNotificationCounterByToken(String)"})
  void testGetNotificationCounterByToken_whenAbc123_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultCoapClientContext.getNotificationCounterByToken("ABC123"));
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test awake(TbCoapClientState) with 'client'; when TbCoapClientState(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_whenTbCoapClientStateWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultCoapClientContext.awake(new TbCoapClientState(null)));
  }
}
