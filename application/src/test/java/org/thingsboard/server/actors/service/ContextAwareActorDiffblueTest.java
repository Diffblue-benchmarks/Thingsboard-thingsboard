package org.thingsboard.server.actors.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.thingsboard.server.actors.TbActorException;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;

@ContextConfiguration(classes = {StatsActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class ContextAwareActorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private ContextAwareActor contextAwareActor;

  /**
   * Test {@link ContextAwareActor#process(TbActorMsg)}.
   *
   * <p>Method under test: {@link ContextAwareActor#process(TbActorMsg)}
   */
  @Test
  @DisplayName("Test process(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextAwareActor.process(TbActorMsg)"})
  void testProcess() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.PARTITION_CHANGE_MSG);

    // Act
    boolean actualProcessResult = contextAwareActor.process(msg);

    // Assert
    verify(msg).getMsgType();
    assertFalse(actualProcessResult);
  }

  /**
   * Test {@link ContextAwareActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <ul>
   *   <li>Then return not Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName("Test onProcessFailure(TbActorMsg, Throwable); then return not Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure_thenReturnNotStop() throws TbActorException {
    // Arrange
    StatsActor statsActor = new StatsActor(new ActorSystemContext());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(3, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(3, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    statsActor.init(ctx);
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertFalse(statsActor.onProcessFailure(msg, new Throwable()).isStop());
  }

  /**
   * Test {@link ContextAwareActor#onProcessFailure(TbActorMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link OutOfMemoryError#OutOfMemoryError()}.
   *   <li>Then return Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#onProcessFailure(TbActorMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test onProcessFailure(TbActorMsg, Throwable); when OutOfMemoryError(); then return Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.onProcessFailure(TbActorMsg, Throwable)"
  })
  void testOnProcessFailure_whenOutOfMemoryError_thenReturnStop() throws TbActorException {
    // Arrange
    StatsActor statsActor = new StatsActor(new ActorSystemContext());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(3, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(3, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox ctx =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    statsActor.init(ctx);
    TbActorMsg msg = mock(TbActorMsg.class);

    // Act and Assert
    assertTrue(statsActor.onProcessFailure(msg, new OutOfMemoryError()).isStop());
  }

  /**
   * Test {@link ContextAwareActor#doProcessFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Error#Error()}.
   *   <li>Then return Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#doProcessFailure(Throwable)}
   */
  @Test
  @DisplayName("Test doProcessFailure(Throwable); when Error(); then return Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.doProcessFailure(Throwable)"
  })
  void testDoProcessFailure_whenError_thenReturnStop() {
    // Arrange, Act and Assert
    assertTrue(contextAwareActor.doProcessFailure(new Error()).isStop());
  }

  /**
   * Test {@link ContextAwareActor#doProcessFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return not Stop.
   * </ul>
   *
   * <p>Method under test: {@link ContextAwareActor#doProcessFailure(Throwable)}
   */
  @Test
  @DisplayName("Test doProcessFailure(Throwable); when Throwable(); then return not Stop")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.actors.ProcessFailureStrategy ContextAwareActor.doProcessFailure(Throwable)"
  })
  void testDoProcessFailure_whenThrowable_thenReturnNotStop() {
    // Arrange, Act and Assert
    assertFalse(contextAwareActor.doProcessFailure(new Throwable()).isStop());
  }
}
