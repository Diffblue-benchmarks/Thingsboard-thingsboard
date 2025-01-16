package org.thingsboard.server.actors.shared;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
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
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.shared.RuleChainErrorActor.ActorCreator;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.queue.RuleEngineException;

@ContextConfiguration(classes = {RuleChainErrorActor.class, TenantId.class, RuleChainErrorActor.ActorCreator.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class RuleChainErrorActorDiffblueTest {
  @Autowired
  private RuleChainErrorActor.ActorCreator actorCreator;

  @MockBean
  private RuleChainId ruleChainId;

  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private RuleChainErrorActor ruleChainErrorActor;

  @MockBean
  private RuleEngineException ruleEngineException;

  @MockBean
  private UUID uUID;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   * <p>
   * Method under test: {@link RuleChainErrorActor.ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  void testActorCreatorCreateActor() {
    // Arrange and Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof RuleChainErrorActor);
    assertNull(((RuleChainErrorActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   * <p>
   * Method under test: {@link RuleChainErrorActor.ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link RuleChainErrorActor#doProcess(TbActorMsg)}.
   * <p>
   * Method under test: {@link RuleChainErrorActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  void testDoProcess() {
    // Arrange, Act and Assert
    assertFalse(ruleChainErrorActor.doProcess(mock(TbActorMsg.class)));
  }
}
