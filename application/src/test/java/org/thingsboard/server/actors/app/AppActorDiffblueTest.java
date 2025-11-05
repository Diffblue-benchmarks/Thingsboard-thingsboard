package org.thingsboard.server.actors.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorCtx;
import org.thingsboard.server.actors.TbActorException;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.app.AppActor.ActorCreator;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;

@ContextConfiguration(classes = {ActorCreator.class, AppActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class AppActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private AppActor appActor;

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
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    EntityId entityId = ((TbEntityActorId) actualCreateActorIdResult).getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, actualCreateActorIdResult.getEntityType());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <ul>
   *   <li>Given {@link ActorCreator#ActorCreator(ActorSystemContext)} with context is {@link
   *       ActorSystemContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName(
      "Test ActorCreator createActor(); given ActorCreator(ActorSystemContext) with context is ActorSystemContext (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor_givenActorCreatorWithContextIsActorSystemContext() {
    // Arrange and Act
    TbActor actualCreateActorResult = new ActorCreator(new ActorSystemContext()).createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof AppActor);
    assertNull(((AppActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test {@link AppActor#init(TbActorCtx)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#schedulePeriodicMsgWithDelay(TbActorRef, TbActorMsg,
   *       long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link AppActor#init(TbActorCtx)}
   */
  @Test
  @DisplayName(
      "Test init(TbActorCtx); then calls schedulePeriodicMsgWithDelay(TbActorRef, TbActorMsg, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppActor.init(TbActorCtx)"})
  void testInit_thenCallsSchedulePeriodicMsgWithDelay() throws TbActorException {
    // Arrange
    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider =
        mock(DefaultTbServiceInfoProvider.class);
    when(defaultTbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    when(actorSystemContext.getSessionReportTimeout()).thenReturn(1L);
    doNothing()
        .when(actorSystemContext)
        .schedulePeriodicMsgWithDelay(
            Mockito.<TbActorRef>any(), Mockito.<TbActorMsg>any(), anyLong(), anyLong());
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(defaultTbServiceInfoProvider);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    appActor.init(ctx);

    // Assert
    verify(actorSystemContext).getServiceInfoProvider();
    verify(actorSystemContext, atLeast(1)).getSessionReportTimeout();
    verify(actorSystemContext)
        .schedulePeriodicMsgWithDelay(isA(TbActorRef.class), isA(TbActorMsg.class), eq(1L), eq(1L));
    verify(defaultTbServiceInfoProvider).isService(ServiceType.TB_CORE);
    assertSame(ctx, appActor.getActorRef());
    assertSame(ctx, appActor.getCtx());
  }

  /**
   * Test {@link AppActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link
   *       ActorSystemContext#isTenantComponentsInitEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AppActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test doProcess(TbActorMsg); given ActorSystemContext isTenantComponentsInitEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenActorSystemContextIsTenantComponentsInitEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isTenantComponentsInitEnabled()).thenReturn(false);

    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.APP_INIT_MSG);

    // Act
    boolean actualDoProcessResult = appActor.doProcess(msg);

    // Assert
    verify(actorSystemContext).isTenantComponentsInitEnabled();
    verify(msg, atLeast(1)).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link AppActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link
   *       ActorSystemContext#isTenantComponentsInitEnabled()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test doProcess(TbActorMsg); given ActorSystemContext isTenantComponentsInitEnabled() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenActorSystemContextIsTenantComponentsInitEnabledReturnTrue() {
    // Arrange
    when(actorSystemContext.isTenantComponentsInitEnabled()).thenReturn(true);

    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.APP_INIT_MSG);

    // Act
    boolean actualDoProcessResult = appActor.doProcess(msg);

    // Assert
    verify(actorSystemContext).isTenantComponentsInitEnabled();
    verify(msg, atLeast(1)).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link AppActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@code COMPONENT_LIFE_CYCLE_MSG}.
   * </ul>
   *
   * <p>Method under test: {@link AppActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); given 'COMPONENT_LIFE_CYCLE_MSG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenComponentLifeCycleMsg() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.COMPONENT_LIFE_CYCLE_MSG);

    // Act
    boolean actualDoProcessResult = appActor.doProcess(msg);

    // Assert
    verify(msg, atLeast(1)).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link AppActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@code PARTITION_CHANGE_MSG}.
   * </ul>
   *
   * <p>Method under test: {@link AppActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); given 'PARTITION_CHANGE_MSG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenPartitionChangeMsg() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.PARTITION_CHANGE_MSG);

    // Act
    boolean actualDoProcessResult = appActor.doProcess(msg);

    // Assert
    verify(msg, atLeast(1)).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link AppActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <p>Method under test: {@link AppActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName("Test onProcessFailure(TbActorMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy AppActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertFalse(appActor.onProcessFailure(msg, new Throwable()).isStop());
  }
}
