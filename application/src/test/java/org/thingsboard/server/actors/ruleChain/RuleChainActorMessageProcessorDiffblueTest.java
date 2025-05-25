package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;

class RuleChainActorMessageProcessorDiffblueTest {
  /**
   * Test {@link RuleChainActorMessageProcessor#getComponentName()}.
   * <p>
   * Method under test: {@link RuleChainActorMessageProcessor#getComponentName()}
   */
  @Test
  @DisplayName("Test getComponentName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RuleChainActorMessageProcessor.getComponentName()"})
  void testGetComponentName() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = new ActorSystemContext();
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act and Assert
    assertNull((new RuleChainActorMessageProcessor(tenantId, ruleChain, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null)))
        .getComponentName());
  }
}
