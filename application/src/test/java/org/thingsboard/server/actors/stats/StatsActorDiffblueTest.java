package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbStringActorId;
import org.thingsboard.server.actors.stats.StatsActor.ActorCreator;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.event.EventService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;

@ContextConfiguration(classes = {ActorCreator.class, String.class, StatsActor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class StatsActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private StatsActor statsActor;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor() {
    // Arrange and Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof StatsActor);
    assertNull(((StatsActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   *
   * <p>Method under test: {@link ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActorId ActorCreator.createActorId()"})
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();
    EntityType actualEntityType = actualCreateActorIdResult.getEntityType();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbStringActorId);
    assertEquals("", actualCreateActorIdResult.toString());
    assertNull(actualCreateActorIdResult.getEntityType());
    assertNull(actualEntityType);
  }

  /**
   * Test {@link StatsActor#StatsActor(ActorSystemContext)}.
   *
   * <p>Method under test: {@link StatsActor#StatsActor(ActorSystemContext)}
   */
  @Test
  @DisplayName("Test new StatsActor(ActorSystemContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsActor.<init>(ActorSystemContext)"})
  void testNewStatsActor() {
    // Arrange and Act
    StatsActor actualStatsActor = new StatsActor(new ActorSystemContext());

    // Assert
    assertNull(actualStatsActor.getCtx());
    assertNull(actualStatsActor.getActorRef());
  }

  /**
   * Test {@link StatsActor#doProcess(TbActorMsg)}.
   *
   * <p>Method under test: {@link StatsActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsActor.doProcess(TbActorMsg)"})
  void testDoProcess() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    StatsPersistMsg msg = new StatsPersistMsg(0L, 0L, tenantId, null);

    // Act and Assert
    assertTrue(statsActor.doProcess(msg));
  }

  /**
   * Test {@link StatsActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@code PARTITION_CHANGE_MSG}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StatsActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); given 'PARTITION_CHANGE_MSG'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenPartitionChangeMsg_thenReturnFalse() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.PARTITION_CHANGE_MSG);

    // Act
    boolean actualDoProcessResult = statsActor.doProcess(msg);

    // Assert
    verify(msg).getMsgType();
    assertFalse(actualDoProcessResult);
  }

  /**
   * Test {@link StatsActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getEventService()}.
   * </ul>
   *
   * <p>Method under test: {@link StatsActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); then calls getEventService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatsActor.doProcess(TbActorMsg)"})
  void testDoProcess_thenCallsGetEventService() {
    // Arrange
    EventService eventService = mock(EventService.class);
    SettableFuture<Void> delegate = SettableFuture.create();
    ForwardingApiFuture<Void> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(eventService.saveAsync(Mockito.<Event>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));
    when(actorSystemContext.getServiceInfoProvider())
        .thenReturn(new DefaultTbServiceInfoProvider());
    when(actorSystemContext.getEventService()).thenReturn(eventService);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualDoProcessResult =
        statsActor.doProcess(new StatsPersistMsg(1L, 0L, tenantId, entityId));

    // Assert
    verify(actorSystemContext).getEventService();
    verify(actorSystemContext).getServiceInfoProvider();
    verify(eventService).saveAsync(isA(Event.class));
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link StatsActor#onStatsPersistMsg(StatsPersistMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getEventService()}.
   * </ul>
   *
   * <p>Method under test: {@link StatsActor#onStatsPersistMsg(StatsPersistMsg)}
   */
  @Test
  @DisplayName("Test onStatsPersistMsg(StatsPersistMsg); then calls getEventService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsActor.onStatsPersistMsg(StatsPersistMsg)"})
  void testOnStatsPersistMsg_thenCallsGetEventService() {
    // Arrange
    BaseEventService baseEventService = mock(BaseEventService.class);
    SettableFuture<Void> delegate = SettableFuture.create();
    ForwardingApiFuture<Void> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(baseEventService.saveAsync(Mockito.<Event>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));
    when(actorSystemContext.getServiceInfoProvider())
        .thenReturn(new DefaultTbServiceInfoProvider());
    when(actorSystemContext.getEventService()).thenReturn(baseEventService);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    statsActor.onStatsPersistMsg(new StatsPersistMsg(1L, -1L, tenantId, entityId));

    // Assert
    verify(actorSystemContext).getEventService();
    verify(actorSystemContext).getServiceInfoProvider();
    verify(baseEventService).saveAsync(isA(Event.class));
  }
}
