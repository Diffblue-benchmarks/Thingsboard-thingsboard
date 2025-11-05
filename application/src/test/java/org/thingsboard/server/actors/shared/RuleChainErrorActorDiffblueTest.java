package org.thingsboard.server.actors.shared;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.ruleChain.RuleChainInputMsg;
import org.thingsboard.server.actors.shared.RuleChainErrorActor.ActorCreator;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.service.queue.TbMsgPackCallback;

@ContextConfiguration(classes = {ActorCreator.class, RuleChainErrorActor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleChainErrorActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private RuleChainErrorActor ruleChainErrorActor;

  @MockBean private RuleChainId ruleChainId;

  @MockBean private RuleEngineException ruleEngineException;

  @MockBean private TenantId tenantId;

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
    assertTrue(actualCreateActorResult instanceof RuleChainErrorActor);
    assertNull(((RuleChainErrorActor) actualCreateActorResult).getCtx());
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

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link RuleChainErrorActor#doProcess(TbActorMsg)}.
   *
   * <p>Method under test: {@link RuleChainErrorActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainErrorActor.doProcess(TbActorMsg)"})
  void testDoProcess() {
    // Arrange
    when(ruleEngineException.getMessage()).thenReturn("Not all who wander are lost");
    RuleChainId target = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleChainInputMsg msg = new RuleChainInputMsg(target, tbMsg);

    // Act
    boolean actualDoProcessResult = ruleChainErrorActor.doProcess(msg);

    // Assert
    verify(ruleEngineException).getMessage();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link RuleChainErrorActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineException}.
   *   <li>When {@link TbActorMsg}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainErrorActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test doProcess(TbActorMsg); given RuleEngineException; when TbActorMsg; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainErrorActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenRuleEngineException_whenTbActorMsg_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ruleChainErrorActor.doProcess(mock(TbActorMsg.class)));
  }

  /**
   * Test {@link RuleChainErrorActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsgPackCallback} {@link TbMsgPackCallback#onFailure(RuleEngineException)}
   *       does nothing.
   *   <li>Then calls {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainErrorActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName(
      "Test doProcess(TbActorMsg); when TbMsgPackCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainErrorActor.doProcess(TbActorMsg)"})
  void testDoProcess_whenTbMsgPackCallbackOnFailureDoesNothing_thenCallsOnFailure() {
    // Arrange
    when(ruleEngineException.getMessage()).thenReturn("Not all who wander are lost");

    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();
    RuleChainId target = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainInputMsg msg = new RuleChainInputMsg(target, tbMsg);

    // Act
    boolean actualDoProcessResult = ruleChainErrorActor.doProcess(msg);

    // Assert
    verify(ruleEngineException).getMessage();
    verify(callback).onFailure(isA(RuleEngineException.class));
    assertTrue(actualDoProcessResult);
  }
}
