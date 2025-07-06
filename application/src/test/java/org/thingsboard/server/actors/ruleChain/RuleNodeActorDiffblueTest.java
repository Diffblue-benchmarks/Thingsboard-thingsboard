package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.ruleChain.RuleNodeActor.ActorCreator;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration(
    classes = {ActorCreator.class, TenantId.class, String.class, RuleNodeActor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleNodeActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

  @MockBean private RuleChainId ruleChainId;

  @Autowired private RuleNodeActor ruleNodeActor;

  @MockBean private RuleNodeId ruleNodeId;

  @MockBean private UUID uUID;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   *
   * <p>Method under test: {@link ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActor ActorCreator.createActor()"})
  void testActorCreatorCreateActor() {
    // Arrange and Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof RuleNodeActor);
    assertEquals("", ((RuleNodeActor) actualCreateActorResult).getRuleChainName());
    assertNull(((RuleNodeActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertEquals(0L, ((RuleNodeActor) actualCreateActorResult).getErrorPersistFrequency());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   *
   * <p>Method under test: {@link ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbActorId ActorCreator.createActorId()"})
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link RuleNodeActor#getErrorPersistFrequency()}.
   *
   * <p>Method under test: {@link RuleNodeActor#getErrorPersistFrequency()}
   */
  @Test
  @DisplayName("Test getErrorPersistFrequency()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RuleNodeActor.getErrorPersistFrequency()"})
  void testGetErrorPersistFrequency() {
    // Arrange
    when(actorSystemContext.getRuleNodeErrorPersistFrequency()).thenReturn(-1L);

    // Act
    long actualErrorPersistFrequency = ruleNodeActor.getErrorPersistFrequency();

    // Assert
    verify(actorSystemContext).getRuleNodeErrorPersistFrequency();
    assertEquals(-1L, actualErrorPersistFrequency);
  }
}
