package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MsgTypeDiffblueTest {
  /**
   * Test {@link MsgType#isIgnoreOnStart()}.
   * <p>
   * Method under test: {@link MsgType#isIgnoreOnStart()}
   */
  @Test
  @DisplayName("Test isIgnoreOnStart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MsgType.isIgnoreOnStart()"})
  void testIsIgnoreOnStart() {
    // Arrange, Act and Assert
    assertTrue(MsgType.valueOf("PARTITION_CHANGE_MSG").isIgnoreOnStart());
  }
}
