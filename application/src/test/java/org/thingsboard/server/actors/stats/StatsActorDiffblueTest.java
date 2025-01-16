package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;

@ContextConfiguration(classes = {StatsActor.class, StatsActor.ActorCreator.class, String.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class StatsActorDiffblueTest {
  @Autowired
  private StatsActor.ActorCreator actorCreator;

  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private StatsActor statsActor;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   * <p>
   * Method under test: {@link StatsActor.ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
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
   * <p>
   * Method under test: {@link StatsActor.ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbStringActorId);
    assertEquals("", actualCreateActorIdResult.toString());
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link StatsActor#StatsActor(ActorSystemContext)}.
   * <p>
   * Method under test: {@link StatsActor#StatsActor(ActorSystemContext)}
   */
  @Test
  @DisplayName("Test new StatsActor(ActorSystemContext)")
  void testNewStatsActor() {
    // Arrange and Act
    StatsActor actualStatsActor = new StatsActor(new ActorSystemContext());

    // Assert
    assertNull(actualStatsActor.getCtx());
    assertNull(actualStatsActor.getActorRef());
  }

  /**
   * Test {@link StatsActor#doProcess(TbActorMsg)}.
   * <p>
   * Method under test: {@link StatsActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  void testDoProcess() {
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
   * Test {@link StatsActor#onStatsPersistMsg(StatsPersistMsg)}.
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getEventService()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatsActor#onStatsPersistMsg(StatsPersistMsg)}
   */
  @Test
  @DisplayName("Test onStatsPersistMsg(StatsPersistMsg); then calls getEventService()")
  void testOnStatsPersistMsg_thenCallsGetEventService() {
    // Arrange
    BaseEventService baseEventService = mock(BaseEventService.class);
    SettableFuture<Void> delegate = SettableFuture.create();
    when(baseEventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(new DefaultTbServiceInfoProvider());
    when(actorSystemContext.getEventService()).thenReturn(baseEventService);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    statsActor.onStatsPersistMsg(new StatsPersistMsg(1L, -1L, tenantId, new AlarmId(UUID.randomUUID())));

    // Assert
    verify(actorSystemContext).getEventService();
    verify(actorSystemContext).getServiceInfoProvider();
    verify(baseEventService).saveAsync(isA(Event.class));
  }
}
