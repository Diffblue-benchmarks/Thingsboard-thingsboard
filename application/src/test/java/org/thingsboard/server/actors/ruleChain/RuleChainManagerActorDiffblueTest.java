package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.actors.tenant.TenantActor;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;

@ContextConfiguration(classes = {TenantActor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleChainManagerActorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Autowired private RuleChainManagerActor ruleChainManagerActor;

  @MockBean private TenantId tenantId;

  /**
   * Test {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}.
   *
   * <p>Method under test: {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}
   */
  @Test
  @DisplayName("Test visit(RuleChain, TbActorRef)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainManagerActor.visit(RuleChain, TbActorRef)"})
  void testVisit() {
    // Arrange
    RuleChain entity = mock(RuleChain.class);
    when(entity.getType()).thenReturn(RuleChainType.CORE);
    when(entity.isRoot()).thenReturn(true);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox actorRef =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    ruleChainManagerActor.visit(entity, actorRef);

    // Assert
    verify(entity).getType();
    verify(entity).isRoot();
    assertTrue(ruleChainManagerActor instanceof TenantActor);
    assertSame(actorRef, ruleChainManagerActor.getRootChainActor());
    assertSame(entity, ruleChainManagerActor.getRootChain());
  }

  /**
   * Test {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}.
   *
   * <ul>
   *   <li>Given {@code EDGE}.
   *   <li>When {@link RuleChain} {@link RuleChain#getType()} return {@code EDGE}.
   *   <li>Then calls {@link RuleChain#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test visit(RuleChain, TbActorRef); given 'EDGE'; when RuleChain getType() return 'EDGE'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainManagerActor.visit(RuleChain, TbActorRef)"})
  void testVisit_givenEdge_whenRuleChainGetTypeReturnEdge_thenCallsGetType() {
    // Arrange
    RuleChain entity = mock(RuleChain.class);
    when(entity.getType()).thenReturn(RuleChainType.EDGE);
    when(entity.isRoot()).thenReturn(true);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox actorRef =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    ruleChainManagerActor.visit(entity, actorRef);

    // Assert that nothing has changed
    verify(entity).getType();
    verify(entity).isRoot();
    assertTrue(ruleChainManagerActor instanceof TenantActor);
  }

  /**
   * Test {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link RuleChainManagerActor} {@link TenantActor}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test visit(RuleChain, TbActorRef); when 'null'; then RuleChainManagerActor TenantActor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainManagerActor.visit(RuleChain, TbActorRef)"})
  void testVisit_whenNull_thenRuleChainManagerActorTenantActor() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox actorRef =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    ruleChainManagerActor.visit(null, actorRef);

    // Assert that nothing has changed
    assertTrue(ruleChainManagerActor instanceof TenantActor);
  }

  /**
   * Test {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.
   *   <li>Then {@link RuleChainManagerActor} {@link TenantActor}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainManagerActor#visit(RuleChain, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test visit(RuleChain, TbActorRef); when RuleChain(); then RuleChainManagerActor TenantActor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainManagerActor.visit(RuleChain, TbActorRef)"})
  void testVisit_whenRuleChain_thenRuleChainManagerActorTenantActor() {
    // Arrange
    RuleChain entity = new RuleChain();
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox actorRef =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(actorSystemContext), null);

    // Act
    ruleChainManagerActor.visit(entity, actorRef);

    // Assert that nothing has changed
    assertTrue(ruleChainManagerActor instanceof TenantActor);
  }

  /**
   * Test {@link RuleChainManagerActor#getEntityActorRef(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainManagerActor#getEntityActorRef(EntityId)}
   */
  @Test
  @DisplayName("Test getEntityActorRef(EntityId); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActorRef RuleChainManagerActor.getEntityActorRef(EntityId)"})
  void testGetEntityActorRef_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        ruleChainManagerActor.getEntityActorRef(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link RuleChainManagerActor#getRootChain()}.
   *
   * <p>Method under test: {@link RuleChainManagerActor#getRootChain()}
   */
  @Test
  @DisplayName("Test getRootChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain RuleChainManagerActor.getRootChain()"})
  void testGetRootChain() {
    // Arrange, Act and Assert
    assertNull(ruleChainManagerActor.getRootChain());
  }

  /**
   * Test {@link RuleChainManagerActor#getRootChainActor()}.
   *
   * <p>Method under test: {@link RuleChainManagerActor#getRootChainActor()}
   */
  @Test
  @DisplayName("Test getRootChainActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbActorRef RuleChainManagerActor.getRootChainActor()"})
  void testGetRootChainActor() {
    // Arrange, Act and Assert
    assertNull(ruleChainManagerActor.getRootChainActor());
  }
}
