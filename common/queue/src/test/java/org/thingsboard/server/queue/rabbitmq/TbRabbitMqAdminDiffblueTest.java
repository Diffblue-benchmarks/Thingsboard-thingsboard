package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.internal.DelegateSSLSocket;
import com.rabbitmq.client.AddressResolver;
import com.rabbitmq.client.Command;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.SaslConfig;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.ConsumerWorkService;
import com.rabbitmq.client.impl.DefaultCredentialsProvider;
import com.rabbitmq.client.impl.DefaultCredentialsRefreshService;
import com.rabbitmq.client.impl.DefaultExceptionHandler;
import com.rabbitmq.client.impl.ErrorOnWriteListener;
import com.rabbitmq.client.impl.FrameHandlerFactory;
import com.rabbitmq.client.impl.LogTrafficListener;
import com.rabbitmq.client.impl.SocketFrameHandler;
import com.rabbitmq.client.impl.recovery.AutorecoveringChannel;
import com.rabbitmq.client.impl.recovery.AutorecoveringConnection;
import com.rabbitmq.client.impl.recovery.BackoffPolicy;
import com.rabbitmq.client.impl.recovery.DefaultRetryHandler;
import com.rabbitmq.client.impl.recovery.RecordedBinding;
import com.rabbitmq.client.impl.recovery.RecordedConsumer;
import com.rabbitmq.client.impl.recovery.RecordedExchange;
import com.rabbitmq.client.impl.recovery.RecordedQueue;
import com.rabbitmq.client.impl.recovery.RecoveredQueueNameSupplier;
import com.rabbitmq.client.impl.recovery.RecoveryAwareChannelN;
import com.rabbitmq.client.impl.recovery.TopologyRecoveryFilter;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbRabbitMqAdmin.class, TbRabbitMqSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbRabbitMqAdminDiffblueTest {
  @Autowired
  private Map<String, Object> map;

  @MockBean
  private Object object;

  @Autowired
  private TbRabbitMqAdmin tbRabbitMqAdmin;

  @Autowired
  private TbRabbitMqSettings tbRabbitMqSettings;

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   * <p>
   * Method under test:
   * {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map)")
  void testNewTbRabbitMqAdmin() throws IOException, TimeoutException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[]{mock(InetAddress.class)});
      ConnectionParams params = mock(ConnectionParams.class);
      when(params.channelShouldCheckRpcResponseType()).thenReturn(true);
      when(params.getExceptionHandler()).thenReturn(new DefaultExceptionHandler());
      when(params.getSaslConfig()).thenReturn(mock(SaslConfig.class));
      when(params.getTrafficListener()).thenReturn(new LogTrafficListener());
      when(params.getCredentialsProvider()).thenReturn(new DefaultCredentialsProvider("janedoe", "iloveyou"));
      when(params.getCredentialsRefreshService()).thenReturn(
          new DefaultCredentialsRefreshService(new DefaultEventLoop(), mock(Function.class), mock(Function.class)));
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
      when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
      when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream(1));
      ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
      when(connectionFactory.newConnection()).thenReturn(new AMQConnection(params, new SocketFrameHandler(socket)));

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(connectionFactory);

      // Act
      new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>());

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
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   * <p>
   * Method under test:
   * {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map)")
  @Disabled("TODO: Complete this test")
  void testNewTbRabbitMqAdmin2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.thingsboard.server.queue.rabbitmq;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin.class,org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3380 {
    //     @org.springframework.beans.factory.annotation.Autowired java.util.Map<Ljava.lang.String;Ljava.lang.Object;> map;
    //     @org.springframework.boot.test.mock.mockito.MockBean java.lang.Object object;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin tbRabbitMqAdmin;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new TbRabbitMqAdmin(tbRabbitMqSettings, new HashMap<>());

  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   * <ul>
   *   <li>Then calls {@link AMQConnection#createChannel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); then calls createChannel()")
  void testNewTbRabbitMqAdmin_thenCallsCreateChannel() throws IOException, TimeoutException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[]{mock(InetAddress.class)});
      ConnectionParams params = mock(ConnectionParams.class);
      when(params.getRecoveredQueueNameSupplier()).thenReturn(mock(RecoveredQueueNameSupplier.class));
      when(params.getTopologyRecoveryRetryHandler())
          .thenReturn(new DefaultRetryHandler(mock(BiPredicate.class), mock(BiPredicate.class), mock(BiPredicate.class),
              mock(BiPredicate.class), mock(DefaultRetryHandler.RetryOperation.class),
              mock(DefaultRetryHandler.RetryOperation.class), mock(DefaultRetryHandler.RetryOperation.class),
              mock(DefaultRetryHandler.RetryOperation.class), 1, mock(BackoffPolicy.class)));
      when(params.getTopologyRecoveryFilter()).thenReturn(mock(TopologyRecoveryFilter.class));
      when(params.getThreadFactory()).thenReturn(mock(ThreadFactory.class));
      when(params.getConnectionRecoveryTriggeringCondition()).thenReturn(mock(Predicate.class));
      doNothing().when(params).setErrorOnWriteListener(Mockito.<ErrorOnWriteListener>any());
      AutorecoveringConnection connection = new AutorecoveringConnection(params, mock(FrameHandlerFactory.class),
          mock(AddressResolver.class));

      ConnectionParams params2 = mock(ConnectionParams.class);
      when(params2.channelShouldCheckRpcResponseType()).thenReturn(true);
      when(params2.getExceptionHandler()).thenReturn(new DefaultExceptionHandler());
      when(params2.getSaslConfig()).thenReturn(mock(SaslConfig.class));
      when(params2.getTrafficListener()).thenReturn(new LogTrafficListener());
      when(params2.getCredentialsProvider()).thenReturn(new DefaultCredentialsProvider("janedoe", "iloveyou"));
      when(params2.getCredentialsRefreshService()).thenReturn(
          new DefaultCredentialsRefreshService(new DefaultEventLoop(), mock(Function.class), mock(Function.class)));
      when(params2.getErrorOnWriteListener()).thenReturn(mock(ErrorOnWriteListener.class));
      when(params2.getChannelRpcTimeout()).thenReturn(10);
      when(params2.getHandshakeTimeout()).thenReturn(10);
      when(params2.getMaxInboundMessageBodySize()).thenReturn(3);
      when(params2.getRequestedChannelMax()).thenReturn(1);
      when(params2.getRequestedFrameMax()).thenReturn(1);
      when(params2.getRequestedHeartbeat()).thenReturn(1);
      when(params2.getShutdownTimeout()).thenReturn(10);
      when(params2.getWorkPoolTimeout()).thenReturn(10);
      when(params2.getVirtualHost()).thenReturn("localhost");
      when(params2.getClientProperties()).thenReturn(new HashMap<>());
      when(params2.getConsumerWorkServiceExecutor()).thenReturn(new DefaultEventLoop());
      when(params2.getShutdownExecutor()).thenReturn(new DefaultEventLoop());
      when(params2.getHeartbeatExecutor()).thenReturn(new DefaultEventLoop());
      when(params2.getThreadFactory()).thenReturn(mock(ThreadFactory.class));
      DelegateSSLSocket socket = mock(DelegateSSLSocket.class);
      when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
      when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream(1));
      AMQConnection connection2 = new AMQConnection(params2, new SocketFrameHandler(socket));

      AMQConnection amqConnection = mock(AMQConnection.class);
      when(amqConnection.createChannel())
          .thenReturn(new AutorecoveringChannel(connection, new RecoveryAwareChannelN(connection2, 10,
              new ConsumerWorkService(new DefaultEventLoop(), mock(ThreadFactory.class), 10))));
      ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
      when(connectionFactory.newConnection()).thenReturn(amqConnection);

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(connectionFactory);

      // Act
      new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>());

      // Assert
      verify(socket).getInputStream();
      verify(socket).getOutputStream();
      verify(connectionFactory).newConnection();
      verify(amqConnection).createChannel();
      verify(params2).channelShouldCheckRpcResponseType();
      verify(params2, atLeast(1)).getChannelRpcTimeout();
      verify(params2).getClientProperties();
      verify(params, atLeast(1)).getConnectionRecoveryTriggeringCondition();
      verify(params2).getConsumerWorkServiceExecutor();
      verify(params2).getCredentialsProvider();
      verify(params2).getCredentialsRefreshService();
      verify(params2, atLeast(1)).getErrorOnWriteListener();
      verify(params2).getExceptionHandler();
      verify(params2).getHandshakeTimeout();
      verify(params2).getHeartbeatExecutor();
      verify(params2).getMaxInboundMessageBodySize();
      verify(params, atLeast(1)).getRecoveredQueueNameSupplier();
      verify(params2).getRequestedChannelMax();
      verify(params2).getRequestedFrameMax();
      verify(params2).getRequestedHeartbeat();
      verify(params2).getSaslConfig();
      verify(params2).getShutdownExecutor();
      verify(params2).getShutdownTimeout();
      verify(params).getThreadFactory();
      verify(params2).getThreadFactory();
      verify(params, atLeast(1)).getTopologyRecoveryFilter();
      verify(params).getTopologyRecoveryRetryHandler();
      verify(params2, atLeast(1)).getTrafficListener();
      verify(params2).getVirtualHost();
      verify(params2).getWorkPoolTimeout();
      verify(params).setErrorOnWriteListener(isA(ErrorOnWriteListener.class));
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); then throw RuntimeException")
  void testNewTbRabbitMqAdmin_thenThrowRuntimeException() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any())).thenReturn(new InetAddress[]{});

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(new ConnectionFactory());

      // Act and Assert
      assertThrows(RuntimeException.class, () -> new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>()));

      mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
    }
  }

  /**
   * Test {@link TbRabbitMqAdmin#createTopicIfNotExists(String, String)} with
   * {@code topic}, {@code properties}.
   * <p>
   * Method under test:
   * {@link TbRabbitMqAdmin#createTopicIfNotExists(String, String)}
   */
  @Test
  @DisplayName("Test createTopicIfNotExists(String, String) with 'topic', 'properties'")
  @Disabled("TODO: Complete this test")
  void testCreateTopicIfNotExistsWithTopicProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.thingsboard.server.queue.rabbitmq;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3381 {
    //     @org.springframework.beans.factory.annotation.Autowired java.util.Map<Ljava.lang.String;Ljava.lang.Object;> map;
    //     @org.springframework.boot.test.mock.mockito.MockBean java.lang.Object object;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin tbRabbitMqAdmin;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbRabbitMqAdmin.createTopicIfNotExists("Topic", "Properties");
  }

  /**
   * Test {@link TbRabbitMqAdmin#deleteTopic(String)}.
   * <p>
   * Method under test: {@link TbRabbitMqAdmin#deleteTopic(String)}
   */
  @Test
  @DisplayName("Test deleteTopic(String)")
  @Disabled("TODO: Complete this test")
  void testDeleteTopic() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@2027883e testClass = org.thingsboard.server.queue.rabbitmq.DiffblueFakeClass3382, locations = [], classes = [org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@fb220a36], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    tbRabbitMqAdmin.deleteTopic("Topic");
  }

  /**
   * Test {@link TbRabbitMqAdmin#destroy()}.
   * <p>
   * Method under test: {@link TbRabbitMqAdmin#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Disabled("TODO: Complete this test")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@62bca483 testClass = org.thingsboard.server.queue.rabbitmq.DiffblueFakeClass3383, locations = [], classes = [org.thingsboard.server.queue.rabbitmq.TbRabbitMqAdmin], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@60dafba8, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@71045a3c, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@20b72605, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@fb220a36], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    tbRabbitMqAdmin.destroy();
  }

  /**
   * Test {@link TbRabbitMqAdmin#destroy()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqAdmin#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then throw RuntimeException")
  void testDestroy_thenThrowRuntimeException() throws IOException, TimeoutException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConnectionParams params = mock(ConnectionParams.class);
    when(params.getRecoveredQueueNameSupplier()).thenReturn(mock(RecoveredQueueNameSupplier.class));
    when(params.getTopologyRecoveryRetryHandler())
        .thenReturn(new DefaultRetryHandler(mock(BiPredicate.class), mock(BiPredicate.class), mock(BiPredicate.class),
            mock(BiPredicate.class), mock(DefaultRetryHandler.RetryOperation.class),
            mock(DefaultRetryHandler.RetryOperation.class), mock(DefaultRetryHandler.RetryOperation.class),
            mock(DefaultRetryHandler.RetryOperation.class), 1, mock(BackoffPolicy.class)));
    when(params.getTopologyRecoveryFilter()).thenReturn(mock(TopologyRecoveryFilter.class));
    when(params.getThreadFactory()).thenReturn(mock(ThreadFactory.class));
    when(params.getConnectionRecoveryTriggeringCondition()).thenReturn(mock(Predicate.class));
    doNothing().when(params).setErrorOnWriteListener(Mockito.<ErrorOnWriteListener>any());
    AutorecoveringConnection connection = new AutorecoveringConnection(params, mock(FrameHandlerFactory.class),
        mock(AddressResolver.class));

    LogTrafficListener logTrafficListener = mock(LogTrafficListener.class);
    doThrow(new RuntimeException("foo")).when(logTrafficListener).write(Mockito.<Command>any());
    ConnectionParams params2 = mock(ConnectionParams.class);
    when(params2.channelShouldCheckRpcResponseType()).thenReturn(true);
    when(params2.getExceptionHandler()).thenReturn(new DefaultExceptionHandler());
    when(params2.getSaslConfig()).thenReturn(mock(SaslConfig.class));
    when(params2.getTrafficListener()).thenReturn(logTrafficListener);
    when(params2.getCredentialsProvider()).thenReturn(new DefaultCredentialsProvider("janedoe", "iloveyou"));
    when(params2.getCredentialsRefreshService()).thenReturn(
        new DefaultCredentialsRefreshService(new DefaultEventLoop(), mock(Function.class), mock(Function.class)));
    when(params2.getErrorOnWriteListener()).thenReturn(mock(ErrorOnWriteListener.class));
    when(params2.getChannelRpcTimeout()).thenReturn(10);
    when(params2.getHandshakeTimeout()).thenReturn(10);
    when(params2.getMaxInboundMessageBodySize()).thenReturn(3);
    when(params2.getRequestedChannelMax()).thenReturn(1);
    when(params2.getRequestedFrameMax()).thenReturn(1);
    when(params2.getRequestedHeartbeat()).thenReturn(1);
    when(params2.getShutdownTimeout()).thenReturn(10);
    when(params2.getWorkPoolTimeout()).thenReturn(10);
    when(params2.getVirtualHost()).thenReturn("localhost");
    when(params2.getClientProperties()).thenReturn(new HashMap<>());
    when(params2.getConsumerWorkServiceExecutor()).thenReturn(new DefaultEventLoop());
    when(params2.getShutdownExecutor()).thenReturn(new DefaultEventLoop());
    when(params2.getHeartbeatExecutor()).thenReturn(new DefaultEventLoop());
    when(params2.getThreadFactory()).thenReturn(mock(ThreadFactory.class));
    DelegateSSLSocket socket = mock(DelegateSSLSocket.class);
    when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    AMQConnection connection2 = new AMQConnection(params2, new SocketFrameHandler(socket));

    AMQConnection amqConnection = mock(AMQConnection.class);
    when(amqConnection.createChannel())
        .thenReturn(new AutorecoveringChannel(connection, new RecoveryAwareChannelN(connection2, 10,
            new ConsumerWorkService(new DefaultEventLoop(), mock(ThreadFactory.class), 10))));
    ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
    when(connectionFactory.newConnection()).thenReturn(amqConnection);
    TbRabbitMqSettings rabbitMqSettings = mock(TbRabbitMqSettings.class);
    when(rabbitMqSettings.getConnectionFactory()).thenReturn(connectionFactory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>())).destroy());
    verify(socket).getInputStream();
    verify(socket).getOutputStream();
    verify(connectionFactory).newConnection();
    verify(amqConnection).createChannel();
    verify(params2).channelShouldCheckRpcResponseType();
    verify(params2, atLeast(1)).getChannelRpcTimeout();
    verify(params2).getClientProperties();
    verify(params, atLeast(1)).getConnectionRecoveryTriggeringCondition();
    verify(params2).getConsumerWorkServiceExecutor();
    verify(params2).getCredentialsProvider();
    verify(params2).getCredentialsRefreshService();
    verify(params2, atLeast(1)).getErrorOnWriteListener();
    verify(params2).getExceptionHandler();
    verify(params2).getHandshakeTimeout();
    verify(params2).getHeartbeatExecutor();
    verify(params2).getMaxInboundMessageBodySize();
    verify(params, atLeast(1)).getRecoveredQueueNameSupplier();
    verify(params2).getRequestedChannelMax();
    verify(params2).getRequestedFrameMax();
    verify(params2).getRequestedHeartbeat();
    verify(params2).getSaslConfig();
    verify(params2).getShutdownExecutor();
    verify(params2).getShutdownTimeout();
    verify(params).getThreadFactory();
    verify(params2).getThreadFactory();
    verify(params, atLeast(1)).getTopologyRecoveryFilter();
    verify(params).getTopologyRecoveryRetryHandler();
    verify(params2, atLeast(1)).getTrafficListener();
    verify(params2).getVirtualHost();
    verify(params2).getWorkPoolTimeout();
    verify(params).setErrorOnWriteListener(isA(ErrorOnWriteListener.class));
    verify(logTrafficListener).write(isA(Command.class));
    verify(rabbitMqSettings).getConnectionFactory();
  }
}
