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
package org.thingsboard.server.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.internal.DelegateSSLSocket;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.SaslConfig;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.DefaultCredentialsRefreshService;
import com.rabbitmq.client.impl.DefaultCredentialsRefreshService.DefaultCredentialsRefreshServiceBuilder;
import com.rabbitmq.client.impl.DefaultExceptionHandler;
import com.rabbitmq.client.impl.ErrorOnWriteListener;
import com.rabbitmq.client.impl.LogTrafficListener;
import com.rabbitmq.client.impl.OAuth2ClientCredentialsGrantCredentialsProvider;
import com.rabbitmq.client.impl.OAuth2ClientCredentialsGrantCredentialsProvider.OAuth2ClientCredentialsGrantCredentialsProviderBuilder;
import com.rabbitmq.client.impl.SocketFrameHandler;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.kafka.TbKafkaAdmin;
import org.thingsboard.server.queue.kafka.TbKafkaSettings;
import org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs;
import org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin;
import org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments;
import org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings;

@ExtendWith(MockitoExtension.class)
class RuleEngineTbQueueAdminFactoryDiffblueTest {
  @InjectMocks private RuleEngineTbQueueAdminFactory ruleEngineTbQueueAdminFactory;

  @Mock private TbKafkaSettings tbKafkaSettings;

  @Mock private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  @Mock private TbRabbitMqQueueArguments tbRabbitMqQueueArguments;

  @Mock private TbRabbitMqSettings tbRabbitMqSettings;

  /**
   * Test {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code partitions} is {@code 42}.
   *   <li>Then return {@link TbKafkaAdmin}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}
   */
  @Test
  @DisplayName(
      "Test createKafkaAdmin(); given HashMap() 'partitions' is '42'; then return TbKafkaAdmin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueAdmin RuleEngineTbQueueAdminFactory.createKafkaAdmin()"})
  void testCreateKafkaAdmin_givenHashMapPartitionsIs42_thenReturnTbKafkaAdmin() {
    // Arrange
    when(tbKafkaSettings.getReplicationFactor()).thenReturn((short) 1);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("partitions", "42");
    when(tbKafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(stringStringMap);

    // Act
    TbQueueAdmin actualCreateKafkaAdminResult = ruleEngineTbQueueAdminFactory.createKafkaAdmin();

    // Assert
    verify(tbKafkaSettings).getReplicationFactor();
    verify(tbKafkaTopicConfigs).getRuleEngineConfigs();
    assertTrue(actualCreateKafkaAdminResult instanceof TbKafkaAdmin);
  }

  /**
   * Test {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}.
   *
   * <ul>
   *   <li>Then return {@link TbKafkaAdmin}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}
   */
  @Test
  @DisplayName("Test createKafkaAdmin(); then return TbKafkaAdmin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueAdmin RuleEngineTbQueueAdminFactory.createKafkaAdmin()"})
  void testCreateKafkaAdmin_thenReturnTbKafkaAdmin() {
    // Arrange
    when(tbKafkaSettings.getReplicationFactor()).thenReturn((short) 1);
    when(tbKafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());

    // Act
    TbQueueAdmin actualCreateKafkaAdminResult = ruleEngineTbQueueAdminFactory.createKafkaAdmin();

    // Assert
    verify(tbKafkaSettings).getReplicationFactor();
    verify(tbKafkaTopicConfigs).getRuleEngineConfigs();
    assertTrue(actualCreateKafkaAdminResult instanceof TbKafkaAdmin);
  }

  /**
   * Test {@link RuleEngineTbQueueAdminFactory#createRabbitMqAdmin()}.
   *
   * <ul>
   *   <li>Then return {@link TbRabbitMqAdmin}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineTbQueueAdminFactory#createRabbitMqAdmin()}
   */
  @Test
  @DisplayName("Test createRabbitMqAdmin(); then return TbRabbitMqAdmin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueAdmin RuleEngineTbQueueAdminFactory.createRabbitMqAdmin()"})
  void testCreateRabbitMqAdmin_thenReturnTbRabbitMqAdmin() throws IOException, TimeoutException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});
      when(tbRabbitMqQueueArguments.getRuleEngineArgs()).thenReturn(new HashMap<>());

      ConnectionParams params = mock(ConnectionParams.class);
      when(params.channelShouldCheckRpcResponseType()).thenReturn(true);
      when(params.getExceptionHandler()).thenReturn(new DefaultExceptionHandler());
      when(params.getSaslConfig()).thenReturn(mock(SaslConfig.class));
      when(params.getTrafficListener()).thenReturn(new LogTrafficListener());
      when(params.getCredentialsProvider())
          .thenReturn(
              new OAuth2ClientCredentialsGrantCredentialsProviderBuilder()
                  .clientId("42")
                  .clientSecret("Client Secret")
                  .connectionConfigurator(mock(Consumer.class))
                  .grantType("Grant Type")
                  .tokenEndpointUri("https://config.us-east-2.amazonaws.com")
                  .build());

      DefaultCredentialsRefreshServiceBuilder refreshDelayStrategyResult =
          new DefaultCredentialsRefreshServiceBuilder()
              .approachingExpirationStrategy(mock(Function.class))
              .refreshDelayStrategy(mock(Function.class));
      when(params.getCredentialsRefreshService())
          .thenReturn(
              refreshDelayStrategyResult.scheduler(new ScheduledThreadPoolExecutor(3)).build());
      when(params.getErrorOnWriteListener()).thenReturn(mock(ErrorOnWriteListener.class));
      when(params.getChannelRpcTimeout()).thenReturn(10);
      when(params.getHandshakeTimeout()).thenReturn(10);
      when(params.getMaxInboundMessageBodySize()).thenReturn(3);
      when(params.getRequestedChannelMax()).thenReturn(1);
      when(params.getRequestedFrameMax()).thenReturn(1);
      when(params.getRequestedHeartbeat()).thenReturn(1);
      when(params.getShutdownTimeout()).thenReturn(10);
      when(params.getWorkPoolTimeout()).thenReturn(10);
      when(params.getVirtualHost()).thenReturn("localhost");
      when(params.getClientProperties()).thenReturn(new HashMap<>());
      when(params.getConsumerWorkServiceExecutor()).thenReturn(new DefaultEventLoop());
      when(params.getShutdownExecutor()).thenReturn(new DefaultEventLoop());
      when(params.getHeartbeatExecutor()).thenReturn(new DefaultEventLoop());
      when(params.getThreadFactory()).thenReturn(mock(ThreadFactory.class));

      DelegateSSLSocket socket = mock(DelegateSSLSocket.class);
      when(socket.getInputStream())
          .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
      when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
      SocketFrameHandler frameHandler = new SocketFrameHandler(socket);

      AMQConnection amqConnection = new AMQConnection(params, frameHandler);

      ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
      when(connectionFactory.newConnection()).thenReturn(amqConnection);
      when(tbRabbitMqSettings.getConnectionFactory()).thenReturn(connectionFactory);

      // Act
      TbQueueAdmin actualCreateRabbitMqAdminResult =
          ruleEngineTbQueueAdminFactory.createRabbitMqAdmin();

      // Assert
      verify(socket).getInputStream();
      verify(socket).getOutputStream();
      verify(connectionFactory).newConnection();
      verify(params).channelShouldCheckRpcResponseType();
      verify(params, atLeast(1)).getChannelRpcTimeout();
      verify(params).getClientProperties();
      verify(params).getConsumerWorkServiceExecutor();
      verify(params).getCredentialsProvider();
      verify(params).getCredentialsRefreshService();
      verify(params, atLeast(1)).getErrorOnWriteListener();
      verify(params).getExceptionHandler();
      verify(params).getHandshakeTimeout();
      verify(params).getHeartbeatExecutor();
      verify(params).getMaxInboundMessageBodySize();
      verify(params).getRequestedChannelMax();
      verify(params).getRequestedFrameMax();
      verify(params).getRequestedHeartbeat();
      verify(params).getSaslConfig();
      verify(params).getShutdownExecutor();
      verify(params).getShutdownTimeout();
      verify(params).getThreadFactory();
      verify(params, atLeast(1)).getTrafficListener();
      verify(params).getVirtualHost();
      verify(params).getWorkPoolTimeout();
      verify(tbRabbitMqQueueArguments).getRuleEngineArgs();
      verify(tbRabbitMqSettings).getConnectionFactory();
      assertTrue(actualCreateRabbitMqAdminResult instanceof TbRabbitMqAdmin);
    }
  }
}
