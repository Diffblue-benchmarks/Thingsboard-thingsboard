package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.RuleNodeId;

@ContextConfiguration(classes = {TbMsgProfilerInfo.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TbMsgProfilerInfoDiffblueTest {
  @Autowired
  private TbMsgProfilerInfo tbMsgProfilerInfo;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProfilerInfo#onEnd(RuleNodeId)}
   */
  @Test
  @DisplayName("Test onEnd(RuleNodeId); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbMsgProfilerInfo.onEnd(RuleNodeId)"})
  void testOnEnd_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, tbMsgProfilerInfo.onEnd(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TbMsgProfilerInfo#onTimeout()}.
   * <p>
   * Method under test: {@link TbMsgProfilerInfo#onTimeout()}
   */
  @Test
  @DisplayName("Test onTimeout()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map.Entry TbMsgProfilerInfo.onTimeout()"})
  void testOnTimeout() {
    // Arrange, Act and Assert
    assertNull((new TbMsgProfilerInfo(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).onTimeout());
  }
}
