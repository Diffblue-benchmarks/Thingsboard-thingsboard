package org.thingsboard.server.actors.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;

@ContextConfiguration(classes = {DefaultActorService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultActorServiceDiffblueTest {
  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private DefaultActorService defaultActorService;

  /**
   * Test {@link DefaultActorService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then calls {@link PartitionChangeEvent#getServiceType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultActorService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls getServiceType()")
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsGetServiceType() {
    // Arrange
    PartitionChangeEvent event = mock(PartitionChangeEvent.class);
    when(event.getServiceType()).thenReturn(ServiceType.TB_CORE);

    // Act
    defaultActorService.onTbApplicationEvent(event);

    // Assert
    verify(event).getServiceType();
  }

  /**
   * Test
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <p>
   * Method under test:
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  void testFilterTbApplicationEventWithPartitionChangeEvent() {
    // Arrange, Act and Assert
    assertTrue(defaultActorService
        .filterTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
    assertTrue(defaultActorService
        .filterTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_RULE_ENGINE, new HashMap<>())));
  }

  /**
   * Test
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then calls {@link PartitionChangeEvent#getServiceType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls getServiceType()")
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenCallsGetServiceType() {
    // Arrange
    PartitionChangeEvent event = mock(PartitionChangeEvent.class);
    when(event.getServiceType()).thenReturn(ServiceType.TB_CORE);

    // Act
    boolean actualFilterTbApplicationEventResult = defaultActorService.filterTbApplicationEvent(event);

    // Assert
    verify(event, atLeast(1)).getServiceType();
    assertTrue(actualFilterTbApplicationEventResult);
  }

  /**
   * Test
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'false'")
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultActorService
        .filterTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_TRANSPORT, new HashMap<>())));
  }

  /**
   * Test {@link DefaultActorService#stopActorSystem()}.
   * <ul>
   *   <li>Then calls {@link PartitionChangeEvent#getServiceType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultActorService#stopActorSystem()}
   */
  @Test
  @DisplayName("Test stopActorSystem(); then calls getServiceType()")
  void testStopActorSystem_thenCallsGetServiceType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PartitionChangeEvent partitionChangeEvent = mock(PartitionChangeEvent.class);
    when(partitionChangeEvent.getSequenceNumber()).thenReturn(10);
    when(partitionChangeEvent.getServiceType()).thenReturn(ServiceType.TB_CORE);

    DefaultActorService defaultActorService = new DefaultActorService();
    defaultActorService.onApplicationEvent(partitionChangeEvent);

    // Act
    defaultActorService.stopActorSystem();

    // Assert that nothing has changed
    verify(partitionChangeEvent, atLeast(1)).getServiceType();
    verify(partitionChangeEvent, atLeast(1)).getSequenceNumber();
  }
}
