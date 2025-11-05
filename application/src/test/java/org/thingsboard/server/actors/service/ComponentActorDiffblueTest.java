package org.thingsboard.server.actors.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.ruleChain.RuleChainActor;
import org.thingsboard.server.actors.ruleChain.RuleChainActorMessageProcessor;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;

@ContextConfiguration(classes = {RuleChainActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class ComponentActorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private ComponentActor<RuleChainId, RuleChainActorMessageProcessor> componentActor;

  @MockBean private RuleChain ruleChain;

  @MockBean private TenantId tenantId;

  /**
   * Test {@link ComponentActor#onClusterEventMsg(PartitionChangeMsg)}.
   *
   * <p>Method under test: {@link ComponentActor#onClusterEventMsg(PartitionChangeMsg)}
   */
  @Test
  @DisplayName("Test onClusterEventMsg(PartitionChangeMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentActor.onClusterEventMsg(PartitionChangeMsg)"})
  void testOnClusterEventMsg() {
    // Arrange
    when(actorSystemContext.getRuleChainErrorPersistFrequency()).thenReturn(-1L);
    doNothing()
        .when(actorSystemContext)
        .persistError(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<Exception>any());

    // Act
    componentActor.onClusterEventMsg(new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
    verify(actorSystemContext)
        .persistError(isA(TenantId.class), isNull(), eq("onClusterEventMsg"), isA(Exception.class));
  }

  /**
   * Test {@link ComponentActor#onStatsPersistTick(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link StatsActor#StatsActor(ActorSystemContext)} with context is {@link
   *       ActorSystemContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ComponentActor#onStatsPersistTick(EntityId)}
   */
  @Test
  @DisplayName(
      "Test onStatsPersistTick(EntityId); given StatsActor(ActorSystemContext) with context is ActorSystemContext (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentActor.onStatsPersistTick(EntityId)"})
  void testOnStatsPersistTick_givenStatsActorWithContextIsActorSystemContext() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(actorSystemContext.getStatsActor()).thenReturn(tbActorMailbox);

    // Act
    componentActor.onStatsPersistTick(null);

    // Assert
    verify(actorSystemContext).getStatsActor();
  }

  /**
   * Test {@link ComponentActor#onStatsPersistTick(EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getRuleChainErrorPersistFrequency()}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentActor#onStatsPersistTick(EntityId)}
   */
  @Test
  @DisplayName("Test onStatsPersistTick(EntityId); then calls getRuleChainErrorPersistFrequency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentActor.onStatsPersistTick(EntityId)"})
  void testOnStatsPersistTick_thenCallsGetRuleChainErrorPersistFrequency() {
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

    // Act
    componentActor.onStatsPersistTick(null);

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
    verify(actorSystemContext).getStatsActor();
    verify(actorSystemContext)
        .persistError(
            isA(TenantId.class), isNull(), eq("onStatsPersistTick"), isA(Exception.class));
  }

  /**
   * Test {@link ComponentActor#logAndPersist(String, Exception)} with {@code method}, {@code e}.
   *
   * <p>Method under test: {@link ComponentActor#logAndPersist(String, Exception)}
   */
  @Test
  @DisplayName("Test logAndPersist(String, Exception) with 'method', 'e'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentActor.logAndPersist(String, Exception)"})
  void testLogAndPersistWithMethodE() {
    // Arrange
    when(actorSystemContext.getRuleChainErrorPersistFrequency()).thenReturn(Long.MAX_VALUE);

    // Act
    componentActor.logAndPersist("Method", new Exception());

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
  }

  /**
   * Test {@link ComponentActor#logAndPersist(String, Exception)} with {@code method}, {@code e}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#persistError(TenantId, EntityId, String,
   *       Exception)}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentActor#logAndPersist(String, Exception)}
   */
  @Test
  @DisplayName(
      "Test logAndPersist(String, Exception) with 'method', 'e'; then calls persistError(TenantId, EntityId, String, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComponentActor.logAndPersist(String, Exception)"})
  void testLogAndPersistWithMethodE_thenCallsPersistError() {
    // Arrange
    when(actorSystemContext.getRuleChainErrorPersistFrequency()).thenReturn(-1L);
    doNothing()
        .when(actorSystemContext)
        .persistError(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<Exception>any());

    // Act
    componentActor.logAndPersist("Method", new Exception());

    // Assert
    verify(actorSystemContext).getRuleChainErrorPersistFrequency();
    verify(actorSystemContext)
        .persistError(isA(TenantId.class), isNull(), eq("Method"), isA(Exception.class));
  }
}
