package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ListeningExecutor;

class MqttClientDiffblueTest {
  /**
   * Test
   * {@link MqttClient#create(MqttClientConfig, MqttHandler, ListeningExecutor)}.
   * <p>
   * Method under test:
   * {@link MqttClient#create(MqttClientConfig, MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test create(MqttClientConfig, MqttHandler, ListeningExecutor)")
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
