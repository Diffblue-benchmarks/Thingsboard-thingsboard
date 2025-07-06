package org.thingsboard.server.common.data.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.msg.TbMsgType;

class ActionTypeDiffblueTest {
  /**
   * Test {@link ActionType#getRuleEngineMsgType()}.
   *
   * <p>Method under test: {@link ActionType#getRuleEngineMsgType()}
   */
  @Test
  @DisplayName("Test getRuleEngineMsgType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ActionType.getRuleEngineMsgType()"})
  void testGetRuleEngineMsgType() {
    // Arrange and Act
    Optional<TbMsgType> actualRuleEngineMsgType = ActionType.ADDED.getRuleEngineMsgType();

    // Assert
    assertEquals(TbMsgType.ENTITY_CREATED, actualRuleEngineMsgType.get());
    assertTrue(actualRuleEngineMsgType.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActionType#isAlarmAction()}
   *   <li>{@link ActionType#isRead()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActionType.isAlarmAction()", "boolean ActionType.isRead()"})
  void testGettersAndSetters() {
    // Arrange
    ActionType valueOfResult = ActionType.valueOf("ADDED");

    // Act
    boolean actualIsAlarmActionResult = valueOfResult.isAlarmAction();

    // Assert
    assertFalse(actualIsAlarmActionResult);
    assertFalse(valueOfResult.isRead());
  }
}
