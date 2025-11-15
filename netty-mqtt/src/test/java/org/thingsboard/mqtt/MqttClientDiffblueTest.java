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
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ListeningExecutor;

class MqttClientDiffblueTest {
  /**
   * Test {@link MqttClient#create(MqttClientConfig, MqttHandler, ListeningExecutor)}.
   * <p>
   * Method under test: {@link MqttClient#create(MqttClientConfig, MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test create(MqttClientConfig, MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttClient MqttClient.create(MqttClientConfig, MqttHandler, ListeningExecutor)"})
  void testCreate() {
    // Arrange
    MqttClientConfig config = new MqttClientConfig();
    MqttHandler defaultHandler = mock(MqttHandler.class);
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);

    // Act
    MqttClient actualCreateResult = MqttClient.create(config, defaultHandler, handlerExecutor);

    // Assert
    assertTrue(actualCreateResult instanceof MqttClientImpl);
    assertNull(actualCreateResult.getEventLoop());
    assertNull(((MqttClientImpl) actualCreateResult).getCallback());
    assertFalse(actualCreateResult.isConnected());
    assertFalse(((MqttClientImpl) actualCreateResult).isReconnect());
    assertTrue(((MqttClientImpl) actualCreateResult).getPendingPublishes().isEmpty());
    assertTrue(((MqttClientImpl) actualCreateResult).getPendingServerUnsubscribes().isEmpty());
    assertTrue(((MqttClientImpl) actualCreateResult).getPendingSubscriptions().isEmpty());
    assertTrue(((MqttClientImpl) actualCreateResult).getQos2PendingIncomingPublishes().isEmpty());
    assertTrue(((MqttClientImpl) actualCreateResult).getPendingSubscribeTopics().isEmpty());
    assertTrue(((MqttClientImpl) actualCreateResult).getServerSubscriptions().isEmpty());
    assertSame(config, actualCreateResult.getClientConfig());
    assertSame(handlerExecutor, actualCreateResult.getHandlerExecutor());
    assertSame(defaultHandler, ((MqttClientImpl) actualCreateResult).getDefaultHandler());
  }
}
