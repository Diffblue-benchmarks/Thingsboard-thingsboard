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
package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rabbitmq.client.AddressResolver;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.ConsumerWorkService;
import com.rabbitmq.client.impl.FrameHandlerFactory;
import com.rabbitmq.client.impl.LogTrafficListener;
import com.rabbitmq.client.impl.recovery.AutorecoveringChannel;
import com.rabbitmq.client.impl.recovery.AutorecoveringConnection;
import com.rabbitmq.client.impl.recovery.RecoveryAwareChannelN;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class TbRabbitMqAdminDiffblueTest {
  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   *
   * <ul>
   *   <li>Given {@link ConnectionFactory} {@link ConnectionFactory#newConnection()} throw {@link
   *       TimeoutException#TimeoutException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); given ConnectionFactory newConnection() throw TimeoutException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqAdmin.<init>(TbRabbitMqSettings, Map)"})
  void testNewTbRabbitMqAdmin_givenConnectionFactoryNewConnectionThrowTimeoutException()
      throws IOException, TimeoutException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByAddress(Mockito.<byte[]>any()))
          .thenReturn(mock(InetAddress.class));
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
      when(connectionFactory.newConnection()).thenThrow(new TimeoutException());

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(connectionFactory);

      // Act and Assert
      assertThrows(
          RuntimeException.class, () -> new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>()));
      verify(connectionFactory).newConnection();
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getAllByName(String)} return empty array of
   *       {@link InetAddress}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); given InetAddress getAllByName(String) return empty array of InetAddress")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqAdmin.<init>(TbRabbitMqSettings, Map)"})
  void testNewTbRabbitMqAdmin_givenInetAddressGetAllByNameReturnEmptyArrayOfInetAddress()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByAddress(Mockito.<byte[]>any()))
          .thenReturn(mock(InetAddress.class));
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {});

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(new ConnectionFactory());

      // Act and Assert
      assertThrows(
          RuntimeException.class, () -> new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>()));
      mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getAllByName(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); given InetAddress getAllByName(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqAdmin.<init>(TbRabbitMqSettings, Map)"})
  void testNewTbRabbitMqAdmin_givenInetAddressGetAllByNameThrowRuntimeException()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenThrow(new RuntimeException());

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(new ConnectionFactory());

      // Act and Assert
      assertThrows(
          RuntimeException.class, () -> new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>()));
      mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link AMQConnection#createChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); then calls createChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRabbitMqAdmin.<init>(TbRabbitMqSettings, Map)"})
  void testNewTbRabbitMqAdmin_thenCallsCreateChannel() throws IOException, TimeoutException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByAddress(Mockito.<byte[]>any()))
          .thenReturn(mock(InetAddress.class));
      mockInetAddress
          .when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[] {mock(InetAddress.class)});

      AMQConnection connection = mock(AMQConnection.class);
      when(connection.willCheckRpcResponseType()).thenReturn(true);
      when(connection.getTrafficListener()).thenReturn(new LogTrafficListener());
      when(connection.getChannelRpcTimeout()).thenReturn(10);
      ConsumerWorkService workService =
          new ConsumerWorkService(new DefaultEventLoop(), mock(ThreadFactory.class), 10);

      RecoveryAwareChannelN delegate = new RecoveryAwareChannelN(connection, 10, workService);
      AutorecoveringConnection connection2 =
          new AutorecoveringConnection(
              new ConnectionParams(), mock(FrameHandlerFactory.class), mock(AddressResolver.class));

      AutorecoveringChannel autorecoveringChannel =
          new AutorecoveringChannel(connection2, delegate);

      AMQConnection amqConnection = mock(AMQConnection.class);
      when(amqConnection.createChannel()).thenReturn(autorecoveringChannel);

      ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
      when(connectionFactory.newConnection()).thenReturn(amqConnection);

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(connectionFactory);

      // Act
      new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>());

      // Assert
      verify(connectionFactory).newConnection();
      verify(amqConnection).createChannel();
      verify(connection, atLeast(1)).getChannelRpcTimeout();
      verify(connection).getTrafficListener();
      verify(connection).willCheckRpcResponseType();
    }
  }
}
