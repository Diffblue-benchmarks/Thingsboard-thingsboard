package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg.Builder;

class RuleChainMetadataConstructorV362DiffblueTest {
  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, new RuleChainMetaData());

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":null,\"connections\":null,\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData2() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(tenantId, builder, null);

    // Assert
    verify(builder).setEntity(null);
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData3() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":null,\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData4() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setRuleChainId(
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":{\"entityType\":\"RULE_CHAIN\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"version\":null,\"firstNodeIndex\":null,\"nodes\":null,\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData5() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(new RuleNode());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":[{\"id\":null,\"createdTime\":0,\"ruleChainId\":null,\"type\":null,\"name\":null,\"debugMode\":false,\"singletonMode\":false,\"queueName\":null,\"configurationVersion\":0,\"externalId\":null,\"additionalInfo\":null,\"configuration\":null}],\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData6() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(new RuleNode(new RuleNode()));

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":[{\"id\":null,\"createdTime\":0,\"ruleChainId\":null,\"type\":null,\"name\":null,\"debugMode\":false,\"singletonMode\":false,\"queueName\":null,\"configurationVersion\":0,\"externalId\":null,\"additionalInfo\":null,\"configuration\":null}],\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData7() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":[{\"id\":null,\"createdTime\":0,\"ruleChainId\":null,\"type\":null,\"name\":null,\"debugMode\":false,\"singletonMode\":false,\"queueName\":null,\"configurationVersion\":0,\"externalId\":null,\"additionalInfo\":null,\"configuration\":null}],\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData8() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {});

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":[{\"id\":null,\"createdTime\":0,\"ruleChainId\":null,\"type\":null,\"name\":null,\"debugMode\":false,\"singletonMode\":false,\"queueName\":null,\"configurationVersion\":0,\"externalId\":null,\"additionalInfo\":null,\"configuration\":null}],\"connections\":[{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }

  /**
   * Test {@link RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * Builder, RuleChainMetaData)} with {@code tenantId}, {@code builder}, {@code ruleChainMetaData}.
   *
   * <p>Method under test: {@link
   * RuleChainMetadataConstructorV362#constructRuleChainMetadataUpdatedMsg(TenantId,
   * RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)}
   */
  @Test
  @DisplayName(
      "Test constructRuleChainMetadataUpdatedMsg(TenantId, Builder, RuleChainMetaData) with 'tenantId', 'builder', 'ruleChainMetaData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(TenantId, RuleChainMetadataUpdateMsg.Builder, RuleChainMetaData)"
  })
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdBuilderRuleChainMetaData9() {
    // Arrange
    RuleChainMetadataConstructorV362 ruleChainMetadataConstructorV362 =
        new RuleChainMetadataConstructorV362();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Builder builder = mock(Builder.class);
    when(builder.setEntity(Mockito.<String>any())).thenReturn(mock(Builder.class));

    RuleNode ruleNode = new RuleNode();
    ruleNode.setConfigurationBytes(new byte[] {});

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(2, 2, "42");
    ruleChainMetaData.setNodes(nodes);
    ruleChainMetaData.addConnectionInfo(1, 1, "Type");

    // Act
    ruleChainMetadataConstructorV362.constructRuleChainMetadataUpdatedMsg(
        tenantId, builder, ruleChainMetaData);

    // Assert
    verify(builder)
        .setEntity(
            "{\"ruleChainId\":null,\"version\":null,\"firstNodeIndex\":null,\"nodes\":[{\"id\":null,\"createdTime\":0,\"ruleChainId\":null,\"type\":null,\"name\":null,\"debugMode\":false,\"singletonMode\":false,\"queueName\":null,\"configurationVersion\":0,\"externalId\":null,\"additionalInfo\":null,\"configuration\":null}],\"connections\":[{\"fromIndex\":2,\"toIndex\":2,\"type\":\"42\"},{\"fromIndex\":1,\"toIndex\":1,\"type\":\"Type\"}],\"ruleChainConnections\":null}");
  }
}
