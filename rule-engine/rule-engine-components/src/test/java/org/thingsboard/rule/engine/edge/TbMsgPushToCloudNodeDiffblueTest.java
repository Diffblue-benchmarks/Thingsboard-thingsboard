package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgPushToCloudNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToCloudNode}
   *   <li>{@link TbMsgPushToCloudNode#getAlarmEventType()}
   *   <li>{@link TbMsgPushToCloudNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToCloudNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgPushToCloudNode.<init>()", "Object TbMsgPushToCloudNode.getAlarmEventType()",
      "Class TbMsgPushToCloudNode.getConfigClazz()", "java.lang.String TbMsgPushToCloudNode.getIgnoredMessageSource()",
      "void TbMsgPushToCloudNode.processMsg(org.thingsboard.rule.engine.api.TbContext, org.thingsboard.server.common.msg.TbMsg)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToCloudNode actualTbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    Object actualAlarmEventType = actualTbMsgPushToCloudNode.getAlarmEventType();
    Class<TbMsgPushToCloudNodeConfiguration> actualConfigClazz = actualTbMsgPushToCloudNode.getConfigClazz();

    // Assert
    assertNull(actualAlarmEventType);
    assertNull(actualTbMsgPushToCloudNode.getIgnoredMessageSource());
    Class<TbMsgPushToCloudNodeConfiguration> expectedConfigClazz = TbMsgPushToCloudNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
