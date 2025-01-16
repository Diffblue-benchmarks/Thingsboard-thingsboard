package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.sync.ie.RuleChainExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class RuleChainExportServiceDiffblueTest {
  /**
   * Test
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   * with {@code EntitiesExportCtx}, {@code RuleChain},
   * {@code RuleChainExportData}.
   * <p>
   * Method under test:
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData) with 'EntitiesExportCtx', 'RuleChain', 'RuleChainExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxRuleChainRuleChainExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    RuleChainExportService ruleChainExportService = new RuleChainExportService(ruleChainService);
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = new User();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    RuleChain ruleChain = new RuleChain();
    RuleChainExportData exportData = new RuleChainExportData();

    // Act
    ruleChainExportService.setRelatedEntities(ctx, ruleChain, exportData);

    // Assert
    verify(request).getEntityTypes();
    verify(ruleChainService).loadRuleChainMetaData(isNull(), isNull());
    assertSame(ruleChainMetaData, exportData.getMetaData());
  }

  /**
   * Test
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   * with {@code EntitiesExportCtx}, {@code RuleChain},
   * {@code RuleChainExportData}.
   * <p>
   * Method under test:
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData) with 'EntitiesExportCtx', 'RuleChain', 'RuleChainExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxRuleChainRuleChainExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    RuleChainExportService ruleChainExportService = new RuleChainExportService(ruleChainService);
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleChain ruleChain = new RuleChain();
    RuleChainExportData exportData = new RuleChainExportData();

    // Act
    ruleChainExportService.setRelatedEntities(ctx, ruleChain, exportData);

    // Assert
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isNull());
    verify(ctx).getTenantId();
    assertSame(ruleChainMetaData, exportData.getMetaData());
  }

  /**
   * Test
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   * with {@code EntitiesExportCtx}, {@code RuleChain},
   * {@code RuleChainExportData}.
   * <p>
   * Method under test:
   * {@link RuleChainExportService#setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, RuleChain, RuleChainExportData) with 'EntitiesExportCtx', 'RuleChain', 'RuleChainExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxRuleChainRuleChainExportData3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    RuleChainExportService ruleChainExportService = new RuleChainExportService(ruleChainService);
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getExternalId(Mockito.<RuleNodeId>any())).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    RuleChainExportData exportData = new RuleChainExportData();

    // Act
    ruleChainExportService.setRelatedEntities(ctx, ruleChain, exportData);

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).getId();
    verify(ruleChain).setFirstRuleNodeId(isA(RuleNodeId.class));
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
    verify(ctx).getExternalId(isA(RuleNodeId.class));
    verify(ctx).getTenantId();
    assertSame(ruleChainMetaData, exportData.getMetaData());
  }

  /**
   * Test {@link RuleChainExportService#newExportData()}.
   * <p>
   * Method under test: {@link RuleChainExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RuleChainExportData actualNewExportDataResult = (new RuleChainExportService(new BaseRuleChainService()))
        .newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getMetaData());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link RuleChainExportService#newExportData()}.
   * <p>
   * Method under test: {@link RuleChainExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RuleChainExportData actualNewExportDataResult = (new RuleChainExportService(mock(BaseRuleChainService.class)))
        .newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getMetaData());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link RuleChainExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link RuleChainExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new RuleChainExportService(new BaseRuleChainService()))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link RuleChainExportService#getSupportedEntityTypes()}.
   * <ul>
   *   <li>Given
   * {@link RuleChainExportService#RuleChainExportService(RuleChainService)} with
   * {@link RuleChainService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes(); given RuleChainExportService(RuleChainService) with RuleChainService")
  void testGetSupportedEntityTypes_givenRuleChainExportServiceWithRuleChainService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new RuleChainExportService(mock(RuleChainService.class)))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.RULE_CHAIN));
  }
}
