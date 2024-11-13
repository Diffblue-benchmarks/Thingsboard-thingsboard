package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.RuleNodeId;

@ContextConfiguration(classes = {TbMsgProfilerInfo.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbMsgProfilerInfoDiffblueTest {
  @Autowired
  private TbMsgProfilerInfo tbMsgProfilerInfo;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}
   */
  @Test
  @DisplayName("Test onEnd(RuleNodeId); when RuleNodeId(UUID) with id is randomUUID; then return zero")
  void testOnEnd_whenRuleNodeIdWithIdIsRandomUUID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, tbMsgProfilerInfo.onEnd(new RuleNodeId(UUID.randomUUID())));
  }

  /**
   * Test {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}.
   * <ul>
   *   <li>When {@link RuleNodeId}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}
   */
  @Test
  @DisplayName("Test onEnd(RuleNodeId); when RuleNodeId; then return zero")
  void testOnEnd_whenRuleNodeId_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, tbMsgProfilerInfo.onEnd(mock(RuleNodeId.class)));
  }

  /**
   * Test {@link TbMsgProfilerInfo#onTimeout()}.
   * <p>
   * Method under test: {@link TbMsgProfilerInfo#onTimeout()}
   */
  @Test
  @DisplayName("Test onTimeout()")
  void testOnTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbMsgProfilerInfo(UUID.randomUUID())).onTimeout());
  }
}
