package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.ruleChain.RuleChainActor.ActorCreator;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;

@ContextConfiguration(classes = {ActorCreator.class, RuleChainActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleChainActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @MockBean private RuleChain ruleChain;

  @Autowired private RuleChainActor ruleChainActor;

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
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getId()).thenReturn(ruleChainId);

    // Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    verify(ruleChain).getId();
    assertTrue(actualCreateActorResult instanceof RuleChainActor);
    assertNull(((RuleChainActor) actualCreateActorResult).getRuleChainName());
    assertNull(((RuleChainActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertEquals(0L, ((RuleChainActor) actualCreateActorResult).getErrorPersistFrequency());
    assertSame(ruleChainId, ((RuleChainActor) actualCreateActorResult).getRuleChainId());
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
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getId()).thenReturn(ruleChainId);

    // Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();
    EntityType actualEntityType = actualCreateActorIdResult.getEntityType();

    // Assert
    verify(ruleChain).getId();
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertEquals(EntityType.RULE_CHAIN, actualCreateActorIdResult.getEntityType());
    assertEquals(EntityType.RULE_CHAIN, actualEntityType);
    assertSame(ruleChainId, ((TbEntityActorId) actualCreateActorIdResult).getEntityId());
  }

  /**
   * Test {@link RuleChainActor#doProcess(TbActorMsg)}.
   *
   * <p>Method under test: {@link RuleChainActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainActor.doProcess(TbActorMsg)"})
  void testDoProcess() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(actorSystemContext.getStatsActor()).thenReturn(tbActorMailbox);

    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.STATS_PERSIST_TICK_MSG);

    // Act
    boolean actualDoProcessResult = ruleChainActor.doProcess(msg);

    // Assert
    verify(actorSystemContext).getStatsActor();
    verify(msg).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link RuleChainActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); given ActorSystemContext; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainActor.doProcess(TbActorMsg)"})
  void testDoProcess_givenActorSystemContext_thenReturnFalse() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.APP_INIT_MSG);

    // Act
    boolean actualDoProcessResult = ruleChainActor.doProcess(msg);

    // Assert
    verify(msg).getMsgType();
    assertFalse(actualDoProcessResult);
  }

  /**
   * Test {@link RuleChainActor#doProcess(TbActorMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getRuleChainErrorPersistFrequency()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg); then calls getRuleChainErrorPersistFrequency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainActor.doProcess(TbActorMsg)"})
  void testDoProcess_thenCallsGetRuleChainErrorPersistFrequency() {
    // Arrange
    when(actorSystemContext.getRuleChainErrorPersistFrequency()).thenReturn(-1L);
    when(actorSystemContext.getStatsActor()).thenReturn(null);
    doNothing()
        .when(actorSystemContext)
        .persistError(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<Exception>any());

    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.STATS_PERSIST_TICK_MSG);

    // Act
    boolean actualDoProcessResult = ruleChainActor.doProcess(msg);

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
    verify(actorSystemContext).getStatsActor();
    verify(actorSystemContext)
        .persistError(
            isA(TenantId.class), isNull(), eq("onStatsPersistTick"), isA(Exception.class));
    verify(msg).getMsgType();
    assertTrue(actualDoProcessResult);
  }

  /**
   * Test {@link RuleChainActor#getRuleChainId()}.
   *
   * <p>Method under test: {@link RuleChainActor#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId RuleChainActor.getRuleChainId()"})
  void testGetRuleChainId() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getId()).thenReturn(ruleChainId);

    // Act
    RuleChainId actualRuleChainId = ruleChainActor.getRuleChainId();

    // Assert
    verify(ruleChain).getId();
    assertSame(ruleChainId, actualRuleChainId);
  }

  /**
   * Test {@link RuleChainActor#getRuleChainName()}.
   *
   * <p>Method under test: {@link RuleChainActor#getRuleChainName()}
   */
  @Test
  @DisplayName("Test getRuleChainName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleChainActor.getRuleChainName()"})
  void testGetRuleChainName() {
    // Arrange
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    String actualRuleChainName = ruleChainActor.getRuleChainName();

    // Assert
    verify(ruleChain).getName();
    assertEquals("Name", actualRuleChainName);
  }

  /**
   * Test {@link RuleChainActor#getErrorPersistFrequency()}.
   *
   * <p>Method under test: {@link RuleChainActor#getErrorPersistFrequency()}
   */
  @Test
  @DisplayName("Test getErrorPersistFrequency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RuleChainActor.getErrorPersistFrequency()"})
  void testGetErrorPersistFrequency() {
    // Arrange
    when(actorSystemContext.getRuleChainErrorPersistFrequency()).thenReturn(-1L);

    // Act
    long actualErrorPersistFrequency = ruleChainActor.getErrorPersistFrequency();

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
    assertEquals(-1L, actualErrorPersistFrequency);
  }
}
