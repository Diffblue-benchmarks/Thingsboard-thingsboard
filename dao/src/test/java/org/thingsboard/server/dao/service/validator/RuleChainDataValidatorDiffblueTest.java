/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {RuleChainDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleChainDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @Autowired private RuleChainDataValidator ruleChainDataValidator;

  @MockBean private RuleChainService ruleChainService;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link RuleChainDataValidator#validateCreate(TenantId, RuleChain)} with {@code TenantId},
   * {@code RuleChain}.
   *
   * <ul>
   *   <li>Then calls {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateCreate(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateCreate(TenantId, RuleChain)"})
  public void testValidateCreateWithTenantIdRuleChain_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    ruleChainDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new RuleChain());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(tenantId);
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(tenantId).isNullUid();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(ruleChain);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setRoot(true);
    ruleChain2.setTenantId(tenantId);
    ruleChain2.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain2));
    verify(tenantId).isNullUid();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);
    ruleChain.setTenantId(tenantId);
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(tenantId).isNullUid();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_givenSystem_tenant() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#isNullUid()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_givenTenantIdIsNullUidReturnTrue() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(true);

    RuleChain ruleChain = new RuleChain(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setTenantId(null);
    ruleChain.setRoot(false);
    ruleChain.setTenantId(tenantId);
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(tenantId).isNullUid();
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_givenTenantService() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_givenTenantService_whenRuleChain() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new RuleChain()));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(ruleChain);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setRoot(true);
    ruleChain2.setTenantId(tenantId);
    ruleChain2.setName("Rule chain name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain2));
    verify(tenantId).isNullUid();
    verify(ruleChain).getId();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Then not {@link RuleChain#RuleChain()} Default.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_thenNotRuleChainDefault() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(tenantId);
    ruleChain.setName("Rule chain name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(tenantId).isNullUid();
    verify(tenantService).tenantExists(isA(TenantId.class));
    assertEquals(RuleChainType.CORE, ruleChain.getType());
    assertFalse(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)} with {@code
   * TenantId}, {@code RuleChain}.
   *
   * <ul>
   *   <li>Then {@link RuleChain#RuleChain()} Default.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainDataValidator.validateDataImpl(TenantId, RuleChain)"})
  public void testValidateDataImplWithTenantIdRuleChain_thenRuleChainDefault() {
    // Arrange
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);
    ruleChain.setTenantId(tenantId);
    ruleChain.setName("Rule chain name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(tenantId).isNullUid();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
    assertEquals(RuleChainType.CORE, ruleChain.getType());
    assertTrue(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(new ArrayNode(nf));
    when(ruleNode.getConfiguration())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleNode.getExternalId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    RuleNode ruleNode2 = new RuleNode(ruleNode);

    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(ruleNode2);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
    verify(ruleNode).getName();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getType();
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertTrue(getResult instanceof ClassNotFoundException);
    assertEquals("Type", getResult.getLocalizedMessage());
    assertEquals("Type", getResult.getMessage());
    assertNull(((ClassNotFoundException) getResult).getException());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData2() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Validation error: ");

    NodeConnectionInfo nodeConnectionInfo3 = new NodeConnectionInfo();
    nodeConnectionInfo3.setFromIndex(-1);
    nodeConnectionInfo3.setToIndex(1);
    nodeConnectionInfo3.setType("Can't create the relation to yourself.");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo3);
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode(RuleNode)} with ruleNode
   *       is {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode(new RuleNode()));

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNode_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    ruleNodeList.add(new RuleNode());

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(2, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(1);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
    verify(ruleChainMetaData).getConnections();
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) FromIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenNodeConnectionInfoFromIndexIsMinusOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Validation error: ");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) FromIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenNodeConnectionInfoFromIndexIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) ToIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenNodeConnectionInfoToIndexIsMinusOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(-1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(1);
    nodeConnectionInfo2.setType("Validation error: ");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} Name is {@code &gt;}.
   *   <li>Then return first LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenRuleNodeNameIsGt_thenReturnFirstLocalizedMessageIsNull() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setName("&gt;");

    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode(new RuleNode(new RuleNode())));

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Then first return {@link ClassNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_thenFirstReturnClassNotFoundException() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getConfiguration())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleNode.getExternalId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    RuleNode ruleNode2 = new RuleNode(ruleNode);

    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(ruleNode2);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
    verify(ruleNode).getName();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getType();
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertTrue(getResult instanceof ClassNotFoundException);
    assertEquals("Type", getResult.getLocalizedMessage());
    assertEquals("Type", getResult.getMessage());
    assertNull(((ClassNotFoundException) getResult).getException());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>When {@link RuleChainMetaData} (default constructor) Nodes is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_whenRuleChainMetaDataNodesIsArrayList_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult =
        RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   *
   * <p>Method under test: {@link
   * RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainDataValidator.validateMetaDataFieldsAndConnections(RuleChainMetaData)"
  })
  public void testValidateMetaDataFieldsAndConnections() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.addConnectionInfo(1, 2, "Type");
    ruleChainMetaData.addConnectionInfo(2, 1, "Validation error: ");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) FromIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainDataValidator.validateMetaDataFieldsAndConnections(RuleChainMetaData)"
  })
  public void testValidateMetaDataFieldsAndConnections_givenNodeConnectionInfoFromIndexIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainMetaData#getConnections()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainDataValidator.validateMetaDataFieldsAndConnections(RuleChainMetaData)"
  })
  public void testValidateMetaDataFieldsAndConnections_thenCallsGetConnections() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData));
    verify(ruleChainMetaData).getConnections();
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RuleChainDataValidator.validateRuleNode(RuleNode)"})
  public void testValidateRuleNode() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getConfiguration())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleNode.getExternalId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    Throwable actualValidateRuleNodeResult =
        RuleChainDataValidator.validateRuleNode(new RuleNode(ruleNode));

    // Assert
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
    verify(ruleNode).getName();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getType();
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    assertTrue(actualValidateRuleNodeResult instanceof ClassNotFoundException);
    assertEquals("Type", actualValidateRuleNodeResult.getLocalizedMessage());
    assertEquals("Type", actualValidateRuleNodeResult.getMessage());
    assertNull(((ClassNotFoundException) actualValidateRuleNodeResult).getException());
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RuleChainDataValidator.validateRuleNode(RuleNode)"})
  public void testValidateRuleNode_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(new ArrayNode(nf));
    when(ruleNode.getConfiguration())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");
    when(ruleNode.getCreatedTime()).thenReturn(1L);
    when(ruleNode.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleNode.getExternalId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    Throwable actualValidateRuleNodeResult =
        RuleChainDataValidator.validateRuleNode(new RuleNode(ruleNode));

    // Assert
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getConfiguration();
    verify(ruleNode).getCreatedTime();
    verify(ruleNode).getExternalId();
    verify(ruleNode).getId();
    verify(ruleNode).getName();
    verify(ruleNode).getRuleChainId();
    verify(ruleNode).getType();
    verify(ruleNode).isDebugMode();
    verify(ruleNode).isSingletonMode();
    assertTrue(actualValidateRuleNodeResult instanceof ClassNotFoundException);
    assertEquals("Type", actualValidateRuleNodeResult.getLocalizedMessage());
    assertEquals("Type", actualValidateRuleNodeResult.getMessage());
    assertNull(((ClassNotFoundException) actualValidateRuleNodeResult).getException());
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RuleChainDataValidator.validateRuleNode(RuleNode)"})
  public void testValidateRuleNode_whenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange and Act
    Throwable actualValidateRuleNodeResult =
        RuleChainDataValidator.validateRuleNode(new RuleNode(new RuleNode()));

    // Assert
    assertNull(actualValidateRuleNodeResult.getLocalizedMessage());
    assertNull(actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link
   *       RuleNode#RuleNode(RuleNode)}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RuleChainDataValidator.validateRuleNode(RuleNode)"})
  public void testValidateRuleNode_whenRuleNodeWithRuleNodeIsRuleNode2() {
    // Arrange and Act
    Throwable actualValidateRuleNodeResult =
        RuleChainDataValidator.validateRuleNode(new RuleNode(new RuleNode(new RuleNode())));

    // Assert
    assertNull(actualValidateRuleNodeResult.getLocalizedMessage());
    assertNull(actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   *
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Throwable RuleChainDataValidator.validateRuleNode(RuleNode)"})
  public void testValidateRuleNode_whenRuleNode_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    Throwable actualValidateRuleNodeResult =
        RuleChainDataValidator.validateRuleNode(new RuleNode());

    // Assert
    assertNull(actualValidateRuleNodeResult.getLocalizedMessage());
    assertNull(actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }
}
