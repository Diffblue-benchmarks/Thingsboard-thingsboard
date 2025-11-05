package org.thingsboard.server.actors.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystem;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;

@ContextConfiguration(classes = {DefaultActorService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultActorServiceDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private DefaultActorService defaultActorService;

  @InjectMocks private DefaultActorService defaultActorService2;

  @Mock private TbActorRef tbActorRef;

  @Mock private TbActorSystem tbActorSystem;

  /**
   * Test {@link DefaultActorService#onApplicationEvent(ApplicationReadyEvent)} with {@code
   * ApplicationReadyEvent}.
   *
   * <p>Method under test: {@link DefaultActorService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent) with 'ApplicationReadyEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultActorService.onApplicationEvent(ApplicationReadyEvent)"})
  void testOnApplicationEventWithApplicationReadyEvent() {
    // Arrange
    doNothing().when(tbActorRef).tellWithHighPriority(Mockito.<TbActorMsg>any());
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);
    String[] args = new String[] {"Args"};

    ApplicationReadyEvent applicationReadyEvent =
        new ApplicationReadyEvent(
            application,
            args,
            new AnnotationConfigReactiveWebApplicationContext(),
            Duration.ofSeconds(1L));

    // Act
    defaultActorService2.onApplicationEvent(applicationReadyEvent);

    // Assert
    verify(tbActorRef).tellWithHighPriority(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultActorService#onTbApplicationEvent(PartitionChangeEvent)} with {@code
   * PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbActorRef#tellWithHighPriority(TbActorMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultActorService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls tellWithHighPriority(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultActorService.onTbApplicationEvent(PartitionChangeEvent)"})
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsTellWithHighPriority() {
    // Arrange
    doNothing().when(tbActorRef).tellWithHighPriority(Mockito.<TbActorMsg>any());
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act
    defaultActorService2.onTbApplicationEvent(event);

    // Assert
    verify(tbActorRef).tellWithHighPriority(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)} with {@code
   * PartitionChangeEvent}.
   *
   * <p>Method under test: {@link
   * DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultActorService.filterTbApplicationEvent(PartitionChangeEvent)"})
  void testFilterTbApplicationEventWithPartitionChangeEvent() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertTrue(defaultActorService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)} with {@code
   * PartitionChangeEvent}.
   *
   * <p>Method under test: {@link
   * DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultActorService.filterTbApplicationEvent(PartitionChangeEvent)"})
  void testFilterTbApplicationEventWithPartitionChangeEvent2() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_RULE_ENGINE, new HashMap<>());

    // Act and Assert
    assertTrue(defaultActorService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)} with {@code
   * PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultActorService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultActorService.filterTbApplicationEvent(PartitionChangeEvent)"})
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_TRANSPORT, new HashMap<>());

    // Act and Assert
    assertFalse(defaultActorService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultActorService#stopActorSystem()}.
   *
   * <p>Method under test: {@link DefaultActorService#stopActorSystem()}
   */
  @Test
  @DisplayName("Test stopActorSystem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultActorService.stopActorSystem()"})
  void testStopActorSystem() {
    // Arrange
    doNothing().when(tbActorSystem).stop();

    // Act
    defaultActorService2.stopActorSystem();

    // Assert
    verify(tbActorSystem).stop();
  }
}
