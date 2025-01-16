package org.thingsboard.server.queue.common;

import static org.mockito.Mockito.mock;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.MessagesStats;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueHandler;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusProducerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

class DefaultTbQueueResponseTemplateDiffblueTest {
  /**
   * Test
   * {@link DefaultTbQueueResponseTemplate#DefaultTbQueueResponseTemplate(TbQueueConsumer, TbQueueProducer, TbQueueHandler, long, long, int, ExecutorService, MessagesStats)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueResponseTemplate#DefaultTbQueueResponseTemplate(TbQueueConsumer, TbQueueProducer, TbQueueHandler, long, long, int, ExecutorService, MessagesStats)}
   */
  @Test
  @DisplayName("Test new DefaultTbQueueResponseTemplate(TbQueueConsumer, TbQueueProducer, TbQueueHandler, long, long, int, ExecutorService, MessagesStats)")
  @Disabled("TODO: Complete this test")
  void testNewDefaultTbQueueResponseTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusProducerTemplate<>(admin2,
        new TbServiceBusSettings(), "Default Topic");

    TbQueueHandler<TbQueueMsg, TbQueueMsg> handler = mock(TbQueueHandler.class);
    DefaultEventLoop executor = new DefaultEventLoop();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);

    // Act
    new DefaultTbQueueResponseTemplate<>(requestTemplate, responseTemplate, handler, 42L, 1L, 3, executor,
        new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
                "The characteristics of someone or something", Meter.Type.COUNTER)), "Name")));

  }

  /**
   * Test {@link DefaultTbQueueResponseTemplate#init(TbQueueHandler)}.
   * <p>
   * Method under test:
   * {@link DefaultTbQueueResponseTemplate#init(TbQueueHandler)}
   */
  @Test
  @DisplayName("Test init(TbQueueHandler)")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusProducerTemplate<>(admin2,
        new TbServiceBusSettings(), "Default Topic");

    TbQueueHandler<TbQueueMsg, TbQueueMsg> handler = mock(TbQueueHandler.class);
    DefaultEventLoop executor = new DefaultEventLoop();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    DefaultTbQueueResponseTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueResponseTemplate = new DefaultTbQueueResponseTemplate<>(
        requestTemplate, responseTemplate, handler, 42L, 1L, 3, executor, new DefaultMessagesStats(totalCounter,
            successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(mock(Meter.Id.class)), "Name")));

    // Act
    defaultTbQueueResponseTemplate.init(mock(TbQueueHandler.class));
  }

  /**
   * Test {@link DefaultTbQueueResponseTemplate#stop()}.
   * <p>
   * Method under test: {@link DefaultTbQueueResponseTemplate#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  @Disabled("TODO: Complete this test")
  void testStop() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: sasKeyName cannot be empty
    //       at com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider.<init>(SharedAccessSignatureTokenProvider.java:40)
    //       at com.microsoft.azure.servicebus.primitives.Util.getClientSettingsFromConnectionStringBuilder(Util.java:382)
    //       at com.microsoft.azure.servicebus.management.ManagementClient.<init>(ManagementClient.java:31)
    //       at org.thingsboard.server.queue.azure.servicebus.TbServiceBusAdmin.<init>(TbServiceBusAdmin.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbServiceBusSettings serviceBusSettings = new TbServiceBusSettings();
    TbServiceBusAdmin admin = new TbServiceBusAdmin(serviceBusSettings, new HashMap<>());

    TbServiceBusConsumerTemplate<TbQueueMsg> requestTemplate = new TbServiceBusConsumerTemplate<>(admin,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    TbServiceBusSettings serviceBusSettings2 = new TbServiceBusSettings();
    TbServiceBusAdmin admin2 = new TbServiceBusAdmin(serviceBusSettings2, new HashMap<>());

    TbServiceBusProducerTemplate<TbQueueMsg> responseTemplate = new TbServiceBusProducerTemplate<>(admin2,
        new TbServiceBusSettings(), "Default Topic");

    TbQueueHandler<TbQueueMsg, TbQueueMsg> handler = mock(TbQueueHandler.class);
    DefaultEventLoop executor = new DefaultEventLoop();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    DefaultTbQueueResponseTemplate<TbQueueMsg, TbQueueMsg> defaultTbQueueResponseTemplate = new DefaultTbQueueResponseTemplate<>(
        requestTemplate, responseTemplate, handler, 42L, 1L, 3, executor, new DefaultMessagesStats(totalCounter,
            successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(mock(Meter.Id.class)), "Name")));

    // Act
    defaultTbQueueResponseTemplate.stop();
  }
}
