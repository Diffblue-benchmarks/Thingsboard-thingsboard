package org.thingsboard.server.service.queue;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.gen.transport.TransportProtos;

@ContextConfiguration(classes = {TbCoreConsumerStats.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbCoreConsumerStatsDiffblueTest {
  @MockBean
  private StatsFactory statsFactory;

  @Autowired
  private TbCoreConsumerStats tbCoreConsumerStats;

  /**
   * Test {@link TbCoreConsumerStats#TbCoreConsumerStats(StatsFactory)}.
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#TbCoreConsumerStats(StatsFactory)}
   */
  @Test
  @DisplayName("Test new TbCoreConsumerStats(StatsFactory)")
  void testNewTbCoreConsumerStats() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    new TbCoreConsumerStats(statsFactory);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(DeviceActivityProto)} with
   * {@code DeviceActivityProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.DeviceActivityProto)}
   */
  @Test
  @DisplayName("Test log(DeviceActivityProto) with 'DeviceActivityProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithDeviceActivityProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.DeviceActivityProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(DeviceConnectProto)} with
   * {@code DeviceConnectProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.DeviceConnectProto)}
   */
  @Test
  @DisplayName("Test log(DeviceConnectProto) with 'DeviceConnectProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithDeviceConnectProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.DeviceConnectProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(DeviceDisconnectProto)} with
   * {@code DeviceDisconnectProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.DeviceDisconnectProto)}
   */
  @Test
  @DisplayName("Test log(DeviceDisconnectProto) with 'DeviceDisconnectProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithDeviceDisconnectProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.DeviceDisconnectProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(DeviceInactivityProto)} with
   * {@code DeviceInactivityProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.DeviceInactivityProto)}
   */
  @Test
  @DisplayName("Test log(DeviceInactivityProto) with 'DeviceInactivityProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithDeviceInactivityProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.DeviceInactivityProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(DeviceStateServiceMsgProto)} with
   * {@code DeviceStateServiceMsgProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.DeviceStateServiceMsgProto)}
   */
  @Test
  @DisplayName("Test log(DeviceStateServiceMsgProto) with 'DeviceStateServiceMsgProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithDeviceStateServiceMsgProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.DeviceStateServiceMsgProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(SubscriptionMgrMsgProto)} with
   * {@code SubscriptionMgrMsgProto}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.SubscriptionMgrMsgProto)}
   */
  @Test
  @DisplayName("Test log(SubscriptionMgrMsgProto) with 'SubscriptionMgrMsgProto'; then calls createStatsCounter(String, String, String[])")
  void testLogWithSubscriptionMgrMsgProto_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.SubscriptionMgrMsgProto.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(ToCoreNotificationMsg)} with
   * {@code ToCoreNotificationMsg}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.ToCoreNotificationMsg)}
   */
  @Test
  @DisplayName("Test log(ToCoreNotificationMsg) with 'ToCoreNotificationMsg'; then calls createStatsCounter(String, String, String[])")
  void testLogWithToCoreNotificationMsg_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.ToCoreNotificationMsg.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#log(TransportToDeviceActorMsg)} with
   * {@code TransportToDeviceActorMsg}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreConsumerStats#log(TransportProtos.TransportToDeviceActorMsg)}
   */
  @Test
  @DisplayName("Test log(TransportToDeviceActorMsg) with 'TransportToDeviceActorMsg'; then calls createStatsCounter(String, String, String[])")
  void testLogWithTransportToDeviceActorMsg_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbCoreConsumerStats tbCoreConsumerStats = new TbCoreConsumerStats(statsFactory);

    // Act
    tbCoreConsumerStats.log(TransportProtos.TransportToDeviceActorMsg.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoreConsumerStats#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  void testPrintStats_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    (new TbCoreConsumerStats(statsFactory)).printStats();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoreConsumerStats#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given AtomicInteger(int) with zero; then calls createStatsCounter(String, String, String[])")
  void testPrintStats_givenAtomicIntegerWithZero_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    (new TbCoreConsumerStats(statsFactory)).printStats();

    // Assert that nothing has changed
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link TbCoreConsumerStats#reset()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoreConsumerStats#reset()}
   */
  @Test
  @DisplayName("Test reset(); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  void testReset_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    (new TbCoreConsumerStats(statsFactory)).reset();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }
}
