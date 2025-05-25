package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgPushToEdgeNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToEdgeNode}
   *   <li>{@link TbMsgPushToEdgeNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToEdgeNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.<init>()", "Class TbMsgPushToEdgeNode.getConfigClazz()",
      "java.lang.String TbMsgPushToEdgeNode.getIgnoredMessageSource()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToEdgeNode actualTbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    Class<TbMsgPushToEdgeNodeConfiguration> actualConfigClazz = actualTbMsgPushToEdgeNode.getConfigClazz();

    // Assert
    assertEquals("edge", actualTbMsgPushToEdgeNode.getIgnoredMessageSource());
    Class<TbMsgPushToEdgeNodeConfiguration> expectedConfigClazz = TbMsgPushToEdgeNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
