package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.actors.TbStringActorId;
import org.thingsboard.server.actors.stats.StatsActor.ActorCreator;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {ActorCreator.class, String.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class StatsActorDiffblueTest {
  @Autowired private ActorCreator actorCreator;

  @MockBean private ActorSystemContext actorSystemContext;

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
    assertTrue(actualCreateActorResult instanceof StatsActor);
    assertNull(((StatsActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
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
    EntityType actualEntityType = actualCreateActorIdResult.getEntityType();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbStringActorId);
    assertEquals("", actualCreateActorIdResult.toString());
    assertNull(actualCreateActorIdResult.getEntityType());
    assertNull(actualEntityType);
  }

  /**
   * Test {@link StatsActor#StatsActor(ActorSystemContext)}.
   *
   * <p>Method under test: {@link StatsActor#StatsActor(ActorSystemContext)}
   */
  @Test
  @DisplayName("Test new StatsActor(ActorSystemContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatsActor.<init>(ActorSystemContext)"})
  void testNewStatsActor() {
    // Arrange and Act
    StatsActor actualStatsActor = new StatsActor(new ActorSystemContext());

    // Assert
    assertNull(actualStatsActor.getCtx());
    assertNull(actualStatsActor.getActorRef());
  }
}
