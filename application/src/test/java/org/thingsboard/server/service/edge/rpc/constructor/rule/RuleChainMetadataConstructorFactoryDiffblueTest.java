package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMetadataConstructorFactoryDiffblueTest {
  /**
   * Test {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_3_0}.
   *   <li>Then return {@link RuleChainMetadataConstructorV330}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeVersion(EdgeVersion); when 'V_3_3_0'; then return RuleChainMetadataConstructorV330")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetadataConstructor RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion)"
  })
  void testGetByEdgeVersion_whenV330_thenReturnRuleChainMetadataConstructorV330() {
    // Arrange, Act and Assert
    assertTrue(
        RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion.V_3_3_0)
            instanceof RuleChainMetadataConstructorV330);
  }

  /**
   * Test {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_3_3}.
   *   <li>Then return {@link RuleChainMetadataConstructorV340}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeVersion(EdgeVersion); when 'V_3_3_3'; then return RuleChainMetadataConstructorV340")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetadataConstructor RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion)"
  })
  void testGetByEdgeVersion_whenV333_thenReturnRuleChainMetadataConstructorV340() {
    // Arrange, Act and Assert
    assertTrue(
        RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion.V_3_3_3)
            instanceof RuleChainMetadataConstructorV340);
  }

  /**
   * Test {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@code V_3_6_2}.
   *   <li>Then return {@link RuleChainMetadataConstructorV362}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test getByEdgeVersion(EdgeVersion); when 'V_3_6_2'; then return RuleChainMetadataConstructorV362")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainMetadataConstructor RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion)"
  })
  void testGetByEdgeVersion_whenV362_thenReturnRuleChainMetadataConstructorV362() {
    // Arrange and Act
    RuleChainMetadataConstructor actualByEdgeVersion =
        RuleChainMetadataConstructorFactory.getByEdgeVersion(EdgeVersion.V_3_6_2);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult =
        actualByEdgeVersion.constructRuleChainMetadataUpdatedMsg(
            tenantId,
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new RuleChainMetaData(),
            EdgeVersion.V_3_3_0);

    // Assert
    assertTrue(actualByEdgeVersion instanceof RuleChainMetadataConstructorV362);
    assertEquals(
        "", actualConstructRuleChainMetadataUpdatedMsgResult.getInitializationErrorString());
    assertEquals(
        "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":null,\"connections\":null,\"ruleChainC"
            + "onnections\":null}",
        actualConstructRuleChainMetadataUpdatedMsgResult.getEntity());
    assertEquals(0, actualConstructRuleChainMetadataUpdatedMsgResult.getConnectionsCount());
    assertEquals(0, actualConstructRuleChainMetadataUpdatedMsgResult.getFirstNodeIndex());
    assertEquals(0, actualConstructRuleChainMetadataUpdatedMsgResult.getMsgTypeValue());
    assertEquals(0, actualConstructRuleChainMetadataUpdatedMsgResult.getNodesCount());
    assertEquals(
        0, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainConnectionsCount());
    assertEquals(0L, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainIdLSB());
    assertEquals(0L, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainIdMSB());
    assertEquals(1, actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size());
    assertEquals(119, actualConstructRuleChainMetadataUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructRuleChainMetadataUpdatedMsgResult.getMsgType());
    assertTrue(
        actualConstructRuleChainMetadataUpdatedMsgResult.findInitializationErrors().isEmpty());
    List<NodeConnectionInfoProto> connectionsList =
        actualConstructRuleChainMetadataUpdatedMsgResult.getConnectionsList();
    assertTrue(connectionsList.isEmpty());
    assertTrue(actualConstructRuleChainMetadataUpdatedMsgResult.isInitialized());
    assertSame(
        connectionsList,
        actualConstructRuleChainMetadataUpdatedMsgResult.getConnectionsOrBuilderList());
    assertSame(connectionsList, actualConstructRuleChainMetadataUpdatedMsgResult.getNodesList());
    assertSame(
        connectionsList, actualConstructRuleChainMetadataUpdatedMsgResult.getNodesOrBuilderList());
    assertSame(
        connectionsList,
        actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainConnectionsList());
    assertSame(
        connectionsList,
        actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainConnectionsOrBuilderList());
  }
}
