package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseRuleChainMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}.
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}
   */
  @Test
  @DisplayName("Test constructRuleChainDeleteMsg(RuleChainId); then return IdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainDeleteMsg(RuleChainId)"})
  void testConstructRuleChainDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    // Act
    RuleChainUpdateMsg actualConstructRuleChainDeleteMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainDeleteMsg(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(-7476899250389416711L, actualConstructRuleChainDeleteMsgResult.getIdLSB());
    assertEquals(23, actualConstructRuleChainDeleteMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructRuleChainDeleteMsgResult.getIdMSB());
    UnknownFieldSet unknownFields = actualConstructRuleChainDeleteMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType = actualConstructRuleChainDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}
   */
  @Test
  @DisplayName("Test constructRuleChainDeleteMsg(RuleChainId); when RuleChainId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainDeleteMsg(RuleChainId)"})
  void testConstructRuleChainDeleteMsg_whenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    // Act
    RuleChainUpdateMsg actualConstructRuleChainDeleteMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainDeleteMsg(new RuleChainId(UUID.randomUUID()));

    // Assert
    UnknownFieldSet unknownFields = actualConstructRuleChainDeleteMsgResult.getUnknownFields();
    RuleChainUpdateMsg defaultInstanceForType = actualConstructRuleChainDeleteMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChainMetadataUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)"})
  void testConstructRuleChainMetadataUpdatedMsg() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    assertEquals(1,
        actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType().getFile().getServices().size());
  }

  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChainMetadataUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)"})
  void testConstructRuleChainMetadataUpdatedMsg2() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_3);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    UnknownFieldSet unknownFields = actualConstructRuleChainMetadataUpdatedMsgResult.getUnknownFields();
    RuleChainMetadataUpdateMsg defaultInstanceForType = actualConstructRuleChainMetadataUpdatedMsgResult
        .getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <ul>
   *   <li>Then return ConnectionsList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion); then return ConnectionsList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChainMetadataUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)"})
  void testConstructRuleChainMetadataUpdatedMsg_thenReturnConnectionsListSizeIsOne() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    nodeConnectionInfoList.add(nodeConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId())
        .thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    List<NodeConnectionInfoProto> connectionsList = actualConstructRuleChainMetadataUpdatedMsgResult
        .getConnectionsList();
    assertEquals(1, connectionsList.size());
    NodeConnectionInfoProto getResult = connectionsList.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals("Type", getResult.getType());
    Descriptor descriptorForType = actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType();
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(1, actualConstructRuleChainMetadataUpdatedMsgResult.getConnectionsCount());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(3, getResult.getAllFields().size());
    assertEquals(35, actualConstructRuleChainMetadataUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size());
    assertEquals(58, file.getMessageTypes().size());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(ruleNodeList, descriptorForType.toProto().getReservedNameList());
  }

  /**
   * Test {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_6_2}.</li>
   *   <li>Then return Entity is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion); when 'V_3_6_2'; then return Entity is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChainMetadataUpdateMsg BaseRuleChainMsgConstructor.constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)"})
  void testConstructRuleChainMetadataUpdatedMsg_whenV362_thenReturnEntityIsAString() {
    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new RuleChainMetaData(), EdgeVersion.V_3_6_2);

    // Assert
    assertEquals(
        "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":null,\"connections\":null,\"ruleChainC"
            + "onnections\":null}",
        actualConstructRuleChainMetadataUpdatedMsgResult.getEntity());
    assertEquals(0, actualConstructRuleChainMetadataUpdatedMsgResult.getFirstNodeIndex());
    assertEquals(0L, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainIdLSB());
    assertEquals(0L, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainIdMSB());
    assertEquals(1, actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size());
    assertEquals(119, actualConstructRuleChainMetadataUpdatedMsgResult.getSerializedSize());
  }
}
