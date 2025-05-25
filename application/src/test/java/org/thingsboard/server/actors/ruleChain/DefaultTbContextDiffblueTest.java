package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.rule.RuleNode;

@ContextConfiguration(classes = {DefaultTbContext.class, String.class, RuleNodeCtx.class, TenantId.class,
    RuleNode.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultTbContextDiffblueTest {
  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private DefaultTbContext defaultTbContext;

  @MockBean
  private TbActorRef tbActorRef;

  @MockBean
  private UUID uUID;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbContext#DefaultTbContext(ActorSystemContext, String, RuleNodeCtx)}
   *   <li>{@link DefaultTbContext#getRuleChainName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbContext.<init>(ActorSystemContext, String, RuleNodeCtx)",
      "String DefaultTbContext.getRuleChainName()"})
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox chainActor = new TbActorMailbox(system, settings, selfId, null,
        new StatsActor(new ActorSystemContext()), null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);
    TbActorMailbox selfActor = new TbActorMailbox(system2, settings2, selfId2, null,
        new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertEquals("Rule Chain Name", (new DefaultTbContext(mainCtx, "Rule Chain Name",
        new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode()))).getRuleChainName());
  }

  /**
   * Test {@link DefaultTbContext#alarmActionMsg(Alarm, RuleNodeId, TbMsgType)} with {@code alarm}, {@code ruleNodeId}, {@code actionMsgType}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#alarmActionMsg(Alarm, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test alarmActionMsg(Alarm, RuleNodeId, TbMsgType) with 'alarm', 'ruleNodeId', 'actionMsgType'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.msg.TbMsg DefaultTbContext.alarmActionMsg(Alarm, RuleNodeId, TbMsgType)"})
  void testAlarmActionMsgWithAlarmRuleNodeIdActionMsgType_thenThrowRuntimeException() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(new AlarmId(null));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.alarmActionMsg(alarm,
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), TbMsgType.POST_ATTRIBUTES_REQUEST));
  }
}
