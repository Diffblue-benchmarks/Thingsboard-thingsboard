package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMsgConstructorV2DiffblueTest {
  /**
   * Test {@link RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV2#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV2.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg() {
    // Arrange
    RuleChainMsgConstructorV2 ruleChainMsgConstructorV2 = new RuleChainMsgConstructorV2();

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV2.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    assertEquals("", actualConstructRuleChainUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructRuleChainUpdatedMsgResult.getConfiguration());
    assertEquals("", actualConstructRuleChainUpdatedMsgResult.getName());
    assertEquals(
        "{\"id\":{\"entityType\":\"RULE_CHAIN\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId"
            + "\":null,\"name\":null,\"type\":null,\"firstRuleNodeId\":null,\"root\":true,\"debugMode\":false,\"externalId\":null"
            + ",\"version\":null,\"configuration\":null,\"additionalInfo\":null}",
        actualConstructRuleChainUpdatedMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructRuleChainUpdatedMsgResult.getIdLSB());
    assertEquals(0, actualConstructRuleChainUpdatedMsgResult.getMsgTypeValue());
    assertEquals(0L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdLSB());
    assertEquals(0L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdMSB());
    assertEquals(287, actualConstructRuleChainUpdatedMsgResult.getSerializedSize());
    assertEquals(3, actualConstructRuleChainUpdatedMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructRuleChainUpdatedMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructRuleChainUpdatedMsgResult.getMsgType());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.getDebugMode());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.getRoot());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdLSB());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdMSB());
    assertTrue(actualConstructRuleChainUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructRuleChainUpdatedMsgResult.isInitialized());
  }
}
