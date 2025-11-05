package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;

class RuleNodeCtxDiffblueTest {
  /**
   * Test {@link RuleNodeCtx#equals(Object)}, and {@link RuleNodeCtx#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeCtx#equals(Object)}
   *   <li>{@link RuleNodeCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, null, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx2 = new RuleNodeCtx(tenantId2, null, null, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeCtx, ruleNodeCtx2);
    assertEquals(ruleNodeCtx.hashCode(), ruleNodeCtx2.hashCode());
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}, and {@link RuleNodeCtx#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeCtx#equals(Object)}
   *   <li>{@link RuleNodeCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, null, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx2 = new RuleNodeCtx(tenantId2, null, null, null);

    // Act and Assert
    assertEquals(ruleNodeCtx, ruleNodeCtx2);
    assertEquals(ruleNodeCtx.hashCode(), ruleNodeCtx2.hashCode());
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}, and {@link RuleNodeCtx#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeCtx#equals(Object)}
   *   <li>{@link RuleNodeCtx#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeCtx, ruleNodeCtx);
    int expectedHashCodeResult = ruleNodeCtx.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeCtx.hashCode());
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system3 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings3 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId3 = mock(TbActorId.class);

    TbActorMailbox chainActor2 =
        new TbActorMailbox(
            system3, settings3, selfId3, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system4 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId4 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system4, settings4, selfId4, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(
        ruleNodeCtx, new RuleNodeCtx(tenantId2, chainActor2, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system3 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings3 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId3 = mock(TbActorId.class);

    TbActorMailbox chainActor2 =
        new TbActorMailbox(
            system3, settings3, selfId3, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system4 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId4 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system4, settings4, selfId4, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(
        ruleNodeCtx, new RuleNodeCtx(tenantId2, chainActor2, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(null, chainActor, selfActor, new RuleNode());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system3 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings3 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId3 = mock(TbActorId.class);

    TbActorMailbox chainActor2 =
        new TbActorMailbox(
            system3, settings3, selfId3, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system4 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId4 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system4, settings4, selfId4, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(
        ruleNodeCtx, new RuleNodeCtx(tenantId, chainActor2, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, selfActor, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system3 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings3 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId3 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system3, settings3, selfId3, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(
        ruleNodeCtx, new RuleNodeCtx(tenantId2, chainActor, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(null, chainActor, selfActor, new RuleNode());
    DefaultTbActorSystem system3 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings3 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId3 = mock(TbActorId.class);

    TbActorMailbox chainActor2 =
        new TbActorMailbox(
            system3, settings3, selfId3, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system4 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId4 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system4, settings4, selfId4, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(ruleNodeCtx, new RuleNodeCtx(null, chainActor2, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, selfActor, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor2 =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(ruleNodeCtx, new RuleNodeCtx(tenantId2, null, selfActor2, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, null, new RuleNode());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(ruleNodeCtx, new RuleNodeCtx(tenantId2, null, selfActor, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, null, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeCtx, new RuleNodeCtx(tenantId2, null, null, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNode self = new RuleNode(id);

    RuleNodeCtx ruleNodeCtx = new RuleNodeCtx(tenantId, null, null, self);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeCtx, new RuleNodeCtx(tenantId2, null, null, new RuleNode()));
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode()), null);
  }

  /**
   * Test {@link RuleNodeCtx#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeCtx#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleNodeCtx.equals(Object)", "int RuleNodeCtx.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertNotEquals(
        new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode()),
        "Different type to RuleNodeCtx");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeCtx#RuleNodeCtx(TenantId, TbActorRef, TbActorRef, RuleNode)}
   *   <li>{@link RuleNodeCtx#setSelf(RuleNode)}
   *   <li>{@link RuleNodeCtx#toString()}
   *   <li>{@link RuleNodeCtx#getChainActor()}
   *   <li>{@link RuleNodeCtx#getSelf()}
   *   <li>{@link RuleNodeCtx#getSelfActor()}
   *   <li>{@link RuleNodeCtx#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeCtx.<init>(TenantId, TbActorRef, TbActorRef, RuleNode)",
    "TbActorRef RuleNodeCtx.getChainActor()",
    "RuleNode RuleNodeCtx.getSelf()",
    "TbActorRef RuleNodeCtx.getSelfActor()",
    "TenantId RuleNodeCtx.getTenantId()",
    "void RuleNodeCtx.setSelf(RuleNode)",
    "java.lang.String RuleNodeCtx.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act
    RuleNodeCtx actualRuleNodeCtx =
        new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());
    RuleNode self = new RuleNode();
    actualRuleNodeCtx.setSelf(self);
    actualRuleNodeCtx.toString();
    TbActorRef actualChainActor = actualRuleNodeCtx.getChainActor();
    RuleNode actualSelf = actualRuleNodeCtx.getSelf();
    TbActorRef actualSelfActor = actualRuleNodeCtx.getSelfActor();

    // Assert
    assertSame(chainActor, actualChainActor);
    assertSame(selfActor, actualSelfActor);
    assertSame(tenantId, actualRuleNodeCtx.getTenantId());
    assertSame(self, actualSelf);
  }
}
