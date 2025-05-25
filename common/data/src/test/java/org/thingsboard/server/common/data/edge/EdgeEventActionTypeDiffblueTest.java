package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.audit.ActionType;

class EdgeEventActionTypeDiffblueTest {
  /**
   * Test {@link EdgeEventActionType#getActionType()}.
   * <p>
   * Method under test: {@link EdgeEventActionType#getActionType()}
   */
  @Test
  @DisplayName("Test getActionType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ActionType EdgeEventActionType.getActionType()"})
  void testGetActionType() {
    // Arrange, Act and Assert
    assertEquals(ActionType.ADDED, EdgeEventActionType.valueOf("ADDED").getActionType());
  }
}
