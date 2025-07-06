package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMsgConstructorV1DiffblueTest {
  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType =
        actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg2() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleChain.getConfiguration())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getName()).thenReturn("Name");
    when(ruleChain.getCreatedTime()).thenReturn(1L);
    when(ruleChain.getExternalId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);

    RuleChain ruleChain2 = new RuleChain(ruleChain);
    ruleChain2.setName("Name");
    ruleChain2.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain2, true);

    // Assert
    assertEquals("[]", actualConstructRuleChainUpdatedMsgResult.getConfiguration());
    ByteString configurationBytes =
        actualConstructRuleChainUpdatedMsgResult.getConfigurationBytes();
    ByteIterator iteratorResult = configurationBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", configurationBytes.toStringUtf8());
    assertEquals(54, actualConstructRuleChainUpdatedMsgResult.getSerializedSize());
    verify(ruleChain).isRoot();
    verify(ruleChain).getAdditionalInfo();
    verify(ruleChain).getConfiguration();
    verify(ruleChain).getVersion();
    verify(ruleChain).getName();
    verify(ruleChain).getCreatedTime();
    verify(ruleChain).getExternalId();
    verify(ruleChain).getId();
    verify(ruleChain).getFirstRuleNodeId();
    verify(ruleChain).getTenantId();
    verify(ruleChain).getType();
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return Configuration is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); then return Configuration is '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg_thenReturnConfigurationIs100() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleChain.getConfiguration()).thenReturn(DoubleNode.valueOf(10.0d));
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getName()).thenReturn("Name");
    when(ruleChain.getCreatedTime()).thenReturn(1L);
    when(ruleChain.getExternalId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);

    RuleChain ruleChain2 = new RuleChain(ruleChain);
    ruleChain2.setName("Name");
    ruleChain2.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain2, true);

    // Assert
    assertEquals("10.0", actualConstructRuleChainUpdatedMsgResult.getConfiguration());
    ByteString configurationBytes =
        actualConstructRuleChainUpdatedMsgResult.getConfigurationBytes();
    ByteIterator iteratorResult = configurationBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('0', iteratorResult.next().byteValue());
    assertEquals('.', iteratorResult.next().byteValue());
    assertEquals("10.0", configurationBytes.toStringUtf8());
    assertEquals(56, actualConstructRuleChainUpdatedMsgResult.getSerializedSize());
    verify(ruleChain).isRoot();
    verify(ruleChain).getAdditionalInfo();
    verify(ruleChain).getConfiguration();
    verify(ruleChain).getVersion();
    verify(ruleChain).getName();
    verify(ruleChain).getCreatedTime();
    verify(ruleChain).getExternalId();
    verify(ruleChain).getId();
    verify(ruleChain).getFirstRuleNodeId();
    verify(ruleChain).getTenantId();
    verify(ruleChain).getType();
  }

  /**
   * Test {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link
   *       RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); when RuleChain(RuleChain) with ruleChain is RuleChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RuleChainUpdateMsg RuleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)"
  })
  void testConstructRuleChainUpdatedMsg_whenRuleChainWithRuleChainIsRuleChain() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));
    ruleChain.setName("Name");
    ruleChain.setId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult =
        ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType =
        actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
