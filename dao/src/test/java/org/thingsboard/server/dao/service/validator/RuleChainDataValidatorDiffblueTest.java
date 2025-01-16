package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class RuleChainDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private RuleChainDataValidator ruleChainDataValidator;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link RuleChainDataValidator#validateCreate(TenantId, RuleChain)} with
   * {@code TenantId}, {@code RuleChain}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateCreate(TenantId, RuleChain)}
   */
  @Test
  public void testValidateCreateWithTenantIdRuleChain_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    ruleChainDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new RuleChain());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getType()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChain.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(ruleChain).getName();
    verify(ruleChain).getType();
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain2() {
    // Arrange
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(new RuleChain());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(ruleChain).getId();
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain).isRoot();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain3() {
    // Arrange
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain4() {
    // Arrange
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any()))
        .thenReturn(new RuleChain(new RuleChainId(ModelConstants.NULL_UUID)));
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(ruleChain).getId();
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain5() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(ruleChain);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain2 = mock(RuleChain.class);
    when(ruleChain2.getId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChain2.isRoot()).thenReturn(true);
    when(ruleChain2.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain2.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain2));
    verify(ruleChain).getId();
    verify(ruleChain2).getName();
    verify(ruleChain2, atLeast(1)).getTenantId();
    verify(ruleChain2, atLeast(1)).getType();
    verify(ruleChain2).isRoot();
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain6() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain7() {
    // Arrange
    when(ruleChainService.getEdgeTemplateRootRuleChain(Mockito.<TenantId>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.EDGE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(ruleChainService).getEdgeTemplateRootRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain8() {
    // Arrange
    when(ruleChainService.getEdgeTemplateRootRuleChain(Mockito.<TenantId>any()))
        .thenReturn(new RuleChain(new RuleChainId(ModelConstants.NULL_UUID)));
    new DataValidationException("An error occurred");
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.EDGE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert
    verify(ruleChain).getId();
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(ruleChainService).getEdgeTemplateRootRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain9() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChainService.getEdgeTemplateRootRuleChain(Mockito.<TenantId>any())).thenReturn(ruleChain);
    new DataValidationException("An error occurred");
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain2 = mock(RuleChain.class);
    when(ruleChain2.getId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChain2.isRoot()).thenReturn(true);
    when(ruleChain2.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain2.getType()).thenReturn(RuleChainType.EDGE);
    when(ruleChain2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain2));
    verify(ruleChain).getId();
    verify(ruleChain2).getName();
    verify(ruleChain2, atLeast(1)).getTenantId();
    verify(ruleChain2, atLeast(1)).getType();
    verify(ruleChain2, atLeast(1)).isRoot();
    verify(ruleChainService).getEdgeTemplateRootRuleChain(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain_givenFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(false);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert that nothing has changed
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link RuleChain#setType(RuleChainType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain_givenNull_thenCallsSetType() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(null);
    doNothing().when(ruleChain).setType(Mockito.<RuleChainType>any());
    when(ruleChain.getName()).thenReturn("Name");

    // Act
    ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain);

    // Assert that nothing has changed
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain, atLeast(1)).getType();
    verify(ruleChain, atLeast(1)).isRoot();
    verify(ruleChain).setType(eq(RuleChainType.CORE));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code Rule chain name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain_givenRuleChainName() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setName("Rule chain name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
  }

  /**
   * Test {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   * with {@code TenantId}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateDataImpl(TenantId, RuleChain)}
   */
  @Test
  public void testValidateDataImplWithTenantIdRuleChain_givenSystem_tenant() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);
    when(ruleChain.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> ruleChainDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, ruleChain));
    verify(ruleChain).getName();
    verify(ruleChain, atLeast(1)).getTenantId();
    verify(ruleChain).getType();
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(ruleNode.getConfiguration()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData2() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getConfiguration()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("org.thingsboard.rule.engine.api.RuleNode");
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
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
    assertEquals("Cannot invoke \"Object.getClass()\" because \"obj\" is null", getResult.getLocalizedMessage());
    assertEquals("Cannot invoke \"Object.getClass()\" because \"obj\" is null", getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_givenArrayListAddRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode(new RuleNode()));
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_givenArrayListAddRuleNode_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    ruleNodeList.add(new RuleNode());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)}
   * with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
    verify(ruleChainMetaData).getConnections();
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) FromIndex is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_givenNodeConnectionInfoFromIndexIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Validation error: ");

    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    nodeConnectionInfoList.add(nodeConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Then first return {@link ClassNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_thenFirstReturnClassNotFoundException() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNode.isSingletonMode()).thenReturn(true);
    when(ruleNode.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getConfiguration()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Then return first LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_thenReturnFirstLocalizedMessageIsNull() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

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
   * <ul>
   *   <li>When {@link RuleChainMetaData} (default constructor) Nodes is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaData_whenRuleChainMetaDataNodesIsArrayList_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }

  /**
   * Test
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaDataFieldsAndConnections() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData));
    verify(ruleChainMetaData).getConnections();
  }

  /**
   * Test
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaDataFieldsAndConnections2() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(-1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Validation error: ");

    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    nodeConnectionInfoList.addAll(new ArrayList<>());
    nodeConnectionInfoList.add(nodeConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);

    // Act
    RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
  }

  /**
   * Test
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaDataFieldsAndConnections_givenArrayList() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());

    // Act
    RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData);

    // Assert that nothing has changed
    verify(ruleChainMetaData).getConnections();
  }

  /**
   * Test
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) FromIndex is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainDataValidator#validateMetaDataFieldsAndConnections(RuleChainMetaData)}
   */
  @Test
  public void testValidateMetaDataFieldsAndConnections_givenNodeConnectionInfoFromIndexIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Validation error: ");

    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    nodeConnectionInfoList.add(nodeConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> RuleChainDataValidator.validateMetaDataFieldsAndConnections(ruleChainMetaData));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  public void testValidateRuleNode() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("org.thingsboard.rule.engine.api.RuleNode");

    // Act
    Throwable actualValidateRuleNodeResult = RuleChainDataValidator.validateRuleNode(ruleNode);

    // Assert
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    assertEquals("Cannot invoke \"Object.getClass()\" because \"obj\" is null",
        actualValidateRuleNodeResult.getLocalizedMessage());
    assertEquals("Cannot invoke \"Object.getClass()\" because \"obj\" is null",
        actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then return {@link ClassNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  public void testValidateRuleNode_givenType_thenReturnClassNotFoundException() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("Type");

    // Act
    Throwable actualValidateRuleNodeResult = RuleChainDataValidator.validateRuleNode(ruleNode);

    // Assert
    verify(ruleNode).getAdditionalInfo();
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    assertTrue(actualValidateRuleNodeResult instanceof ClassNotFoundException);
    assertEquals("Type", actualValidateRuleNodeResult.getLocalizedMessage());
    assertEquals("Type", actualValidateRuleNodeResult.getMessage());
    assertNull(((ClassNotFoundException) actualValidateRuleNodeResult).getException());
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode(RuleNode)} with ruleNode is
   * {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  public void testValidateRuleNode_whenRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange and Act
    Throwable actualValidateRuleNodeResult = RuleChainDataValidator.validateRuleNode(new RuleNode(new RuleNode()));

    // Assert
    assertNull(actualValidateRuleNodeResult.getLocalizedMessage());
    assertNull(actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateRuleNode(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateRuleNode(RuleNode)}
   */
  @Test
  public void testValidateRuleNode_whenRuleNode_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    Throwable actualValidateRuleNodeResult = RuleChainDataValidator.validateRuleNode(new RuleNode());

    // Assert
    assertNull(actualValidateRuleNodeResult.getLocalizedMessage());
    assertNull(actualValidateRuleNodeResult.getMessage());
    assertNull(actualValidateRuleNodeResult.getCause());
    assertEquals(0, actualValidateRuleNodeResult.getSuppressed().length);
  }
}
