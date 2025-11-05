package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseRuleChainMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainDeleteMsg(RuleChainId); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainDeleteMsg(RuleChainId)"
  })
  void testConstructRuleChainDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    // Act
    RuleChainUpdateMsg actualConstructRuleChainDeleteMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainDeleteMsg(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructRuleChainDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructRuleChainDeleteMsgResult.getConfiguration());
    assertEquals("", actualConstructRuleChainDeleteMsgResult.getEntity());
    assertEquals("", actualConstructRuleChainDeleteMsgResult.getName());
    assertEquals(-7476899250389416711L, actualConstructRuleChainDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructRuleChainDeleteMsgResult.getFirstRuleNodeIdLSB());
    assertEquals(0L, actualConstructRuleChainDeleteMsgResult.getFirstRuleNodeIdMSB());
    assertEquals(2, actualConstructRuleChainDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructRuleChainDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructRuleChainDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructRuleChainDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructRuleChainDeleteMsgResult.getMsgType());
    assertFalse(actualConstructRuleChainDeleteMsgResult.getDebugMode());
    assertFalse(actualConstructRuleChainDeleteMsgResult.getRoot());
    assertFalse(actualConstructRuleChainDeleteMsgResult.hasFirstRuleNodeIdLSB());
    assertFalse(actualConstructRuleChainDeleteMsgResult.hasFirstRuleNodeIdMSB());
    assertTrue(actualConstructRuleChainDeleteMsgResult.findInitializationErrors().isEmpty());
  }
}
