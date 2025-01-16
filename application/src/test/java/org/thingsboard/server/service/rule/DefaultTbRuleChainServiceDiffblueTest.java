package org.thingsboard.server.service.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.rule.engine.api.NodeConfiguration;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainUpdateResult;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.service.component.AnnotationComponentDiscoveryService;
import org.thingsboard.server.service.component.ComponentDiscoveryService;
import org.thingsboard.server.service.component.RuleNodeClassInfo;
import org.thingsboard.server.service.install.InstallScripts;

class DefaultTbRuleChainServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(TenantId, RuleChainId); given ArrayList() add 'null'; then return Empty")
  void testGetRuleChainOutputLabels_givenArrayListAddNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(null);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Set<String> actualRuleChainOutputLabels = defaultTbRuleChainService.getRuleChainOutputLabels(tenantId,
        new RuleChainId(UUID.randomUUID()));

    // Assert
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
    assertTrue(actualRuleChainOutputLabels.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#getName()} return
   * {@code Name}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(TenantId, RuleChainId); given RuleNode getName() return 'Name'; then return size is one")
  void testGetRuleChainOutputLabels_givenRuleNodeGetNameReturnName_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getName()).thenReturn("Name");
    when(ruleNode.getType()).thenReturn("org.thingsboard.rule.engine.flow.TbRuleChainOutputNode");

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Set<String> actualRuleChainOutputLabels = defaultTbRuleChainService.getRuleChainOutputLabels(tenantId,
        new RuleChainId(UUID.randomUUID()));

    // Assert
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
    assertEquals(1, actualRuleChainOutputLabels.size());
    assertTrue(actualRuleChainOutputLabels.contains("Name"));
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#getType()} return
   * {@code Type}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(TenantId, RuleChainId); given RuleNode getType() return 'Type'; then return Empty")
  void testGetRuleChainOutputLabels_givenRuleNodeGetTypeReturnType_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getType()).thenReturn("Type");

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Set<String> actualRuleChainOutputLabels = defaultTbRuleChainService.getRuleChainOutputLabels(tenantId,
        new RuleChainId(UUID.randomUUID()));

    // Assert
    verify(ruleNode).getType();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
    assertTrue(actualRuleChainOutputLabels.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(TenantId, RuleChainId); then return Empty")
  void testGetRuleChainOutputLabels_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Set<String> actualRuleChainOutputLabels = defaultTbRuleChainService.getRuleChainOutputLabels(tenantId,
        new RuleChainId(UUID.randomUUID()));

    // Assert
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
    assertTrue(actualRuleChainOutputLabels.isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#getRuleChainOutputLabels(TenantId, RuleChainId)}
   */
  @Test
  @DisplayName("Test getRuleChainOutputLabels(TenantId, RuleChainId); then throw RuntimeException")
  void testGetRuleChainOutputLabels_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getName()).thenThrow(new RuntimeException("org.thingsboard.rule.engine.flow.TbRuleChainOutputNode"));
    when(ruleNode.getType()).thenReturn("org.thingsboard.rule.engine.flow.TbRuleChainOutputNode");

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(nodes);
    BaseRuleChainService ruleChainService = mock(BaseRuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbRuleChainService.getRuleChainOutputLabels(tenantId, new RuleChainId(UUID.randomUUID())));
    verify(ruleNode).getName();
    verify(ruleNode).getType();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isA(RuleChainId.class));
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   * with {@code tenantId}, {@code ruleChainId}, {@code result}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   */
  @Test
  @DisplayName("Test updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult) with 'tenantId', 'ruleChainId', 'result'")
  void testUpdateRelatedRuleChainsWithTenantIdRuleChainIdResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());

    // Act and Assert
    assertTrue(defaultTbRuleChainService.updateRelatedRuleChains(tenantId, ruleChainId, RuleChainUpdateResult.failed())
        .isEmpty());
  }

  /**
   * Test
   * {@link DefaultTbRuleChainService#setRootRuleChain(TenantId, RuleChain, User)}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#setRootRuleChain(TenantId, RuleChain, User)}
   */
  @Test
  @DisplayName("Test setRootRuleChain(TenantId, RuleChain, User); then return RuleChain()")
  void testSetRootRuleChain_thenReturnRuleChain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.setRootRuleChain(Mockito.<TenantId>any(), Mockito.<RuleChainId>any())).thenReturn(false);
    when(ruleChainService.getRootTenantRuleChain(Mockito.<TenantId>any())).thenReturn(mock(RuleChain.class));
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(null));

    // Act
    RuleChain actualSetRootRuleChainResult = defaultTbRuleChainService.setRootRuleChain(tenantId, ruleChain,
        new User());

    // Assert
    verify(ruleChainService).getRootTenantRuleChain(isA(TenantId.class));
    verify(ruleChainService).setRootRuleChain(isA(TenantId.class), isA(RuleChainId.class));
    assertSame(ruleChain, actualSetRootRuleChainResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode)")
  void testUpdateRuleNodeConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, installScripts, new AnnotationComponentDiscoveryService());
    RuleNode node = new RuleNode();

    // Act
    RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService.updateRuleNodeConfiguration(node);

    // Assert
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode)")
  void testUpdateRuleNodeConfiguration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), null);
    RuleNode node = new RuleNode();

    // Act
    RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService.updateRuleNodeConfiguration(node);

    // Assert
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode)")
  void testUpdateRuleNodeConfiguration3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    org.thingsboard.rule.engine.api.RuleNode annotation = mock(org.thingsboard.rule.engine.api.RuleNode.class);
    Class<NodeConfiguration> forNameResult = NodeConfiguration.class;
    Mockito.<Class<? extends NodeConfiguration>>when(annotation.configClazz()).thenReturn(forNameResult);
    when(annotation.version()).thenReturn(1);
    Class<Object> clazz = Object.class;
    Optional<RuleNodeClassInfo> ofResult = Optional.of(new RuleNodeClassInfo(clazz, annotation));
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = new org.thingsboard.server.common.data.rule.RuleNode();

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(annotation).configClazz();
    verify(annotation, atLeast(1)).version();
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode)")
  void testUpdateRuleNodeConfiguration4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    org.thingsboard.rule.engine.api.RuleNode annotation = mock(org.thingsboard.rule.engine.api.RuleNode.class);
    Mockito.<Class<? extends NodeConfiguration>>when(annotation.configClazz())
        .thenThrow(
            new RuntimeException("Going to upgrade rule node with id: {} type: {} fromVersion: {} toVersion: {}"));
    when(annotation.version()).thenReturn(1);
    Class<Object> clazz = Object.class;
    Optional<RuleNodeClassInfo> ofResult = Optional.of(new RuleNodeClassInfo(clazz, annotation));
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = new org.thingsboard.server.common.data.rule.RuleNode();

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(annotation).configClazz();
    verify(annotation, atLeast(1)).version();
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode)")
  void testUpdateRuleNodeConfiguration5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = mock(RuleNodeClassInfo.class);
    when(ruleNodeClassInfo.getCurrentVersion()).thenReturn(0);
    when(ruleNodeClassInfo.isVersioned()).thenReturn(true);
    Optional<RuleNodeClassInfo> ofResult = Optional.of(ruleNodeClassInfo);
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    RuleNode node = new RuleNode();

    // Act
    RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService.updateRuleNodeConfiguration(node);

    // Assert
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    verify(ruleNodeClassInfo).getCurrentVersion();
    verify(ruleNodeClassInfo).isVersioned();
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@link RuleNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode); given one; then return RuleNode")
  void testUpdateRuleNodeConfiguration_givenOne_thenReturnRuleNode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = mock(RuleNodeClassInfo.class);
    when(ruleNodeClassInfo.getCurrentVersion()).thenReturn(1);
    when(ruleNodeClassInfo.isVersioned()).thenReturn(true);
    Optional<RuleNodeClassInfo> ofResult = Optional.of(ruleNodeClassInfo);
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    RuleNode node = mock(RuleNode.class);
    when(node.getConfigurationVersion()).thenReturn(1);
    when(node.getType()).thenReturn("Type");
    when(node.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(node.getId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    // Act
    RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService.updateRuleNodeConfiguration(node);

    // Assert
    verify(node).getConfigurationVersion();
    verify(node).getId();
    verify(node).getRuleChainId();
    verify(node).getType();
    verify(componentDiscoveryService).getRuleNodeInfo(eq("Type"));
    verify(ruleNodeClassInfo).getCurrentVersion();
    verify(ruleNodeClassInfo).isVersioned();
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <ul>
   *   <li>Given {@link org.thingsboard.rule.engine.api.RuleNode}
   * {@link org.thingsboard.rule.engine.api.RuleNode#version()} return zero.</li>
   *   <li>Then calls
   * {@link org.thingsboard.rule.engine.api.RuleNode#version()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode); given RuleNode version() return zero; then calls version()")
  void testUpdateRuleNodeConfiguration_givenRuleNodeVersionReturnZero_thenCallsVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    org.thingsboard.rule.engine.api.RuleNode annotation = mock(org.thingsboard.rule.engine.api.RuleNode.class);
    when(annotation.version()).thenReturn(0);
    Class<Object> clazz = Object.class;
    Optional<RuleNodeClassInfo> ofResult = Optional.of(new RuleNodeClassInfo(clazz, annotation));
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = new org.thingsboard.server.common.data.rule.RuleNode();

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(annotation).version();
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <ul>
   *   <li>Then calls {@link RuleNodeClassInfo#getAnnotation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode); then calls getAnnotation()")
  void testUpdateRuleNodeConfiguration_thenCallsGetAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = mock(RuleNodeClassInfo.class);
    when(ruleNodeClassInfo.getAnnotation()).thenThrow(new RuntimeException("foo"));
    when(ruleNodeClassInfo.getCurrentVersion()).thenReturn(1);
    when(ruleNodeClassInfo.isVersioned()).thenReturn(true);
    Optional<RuleNodeClassInfo> ofResult = Optional.of(ruleNodeClassInfo);
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = new org.thingsboard.server.common.data.rule.RuleNode();

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    verify(ruleNodeClassInfo).getAnnotation();
    verify(ruleNodeClassInfo, atLeast(1)).getCurrentVersion();
    verify(ruleNodeClassInfo).isVersioned();
    assertEquals(0, node.getConfigurationVersion());
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <ul>
   *   <li>Then calls
   * {@link org.thingsboard.server.common.data.rule.RuleNode#getConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode); then calls getConfiguration()")
  void testUpdateRuleNodeConfiguration_thenCallsGetConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = mock(RuleNodeClassInfo.class);
    when(ruleNodeClassInfo.getAnnotation()).thenThrow(new RuntimeException("foo"));
    when(ruleNodeClassInfo.getCurrentVersion()).thenReturn(3);
    when(ruleNodeClassInfo.isVersioned()).thenReturn(true);
    Optional<RuleNodeClassInfo> ofResult = Optional.of(ruleNodeClassInfo);
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = mock(
        org.thingsboard.server.common.data.rule.RuleNode.class);
    when(node.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(node.getConfigurationVersion()).thenReturn(1);
    when(node.getType()).thenReturn("Type");
    when(node.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(node.getId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(node).getConfiguration();
    verify(node, atLeast(1)).getConfigurationVersion();
    verify(node).getId();
    verify(node).getRuleChainId();
    verify(node).getType();
    verify(componentDiscoveryService).getRuleNodeInfo(eq("Type"));
    verify(ruleNodeClassInfo).getAnnotation();
    verify(ruleNodeClassInfo, atLeast(1)).getCurrentVersion();
    verify(ruleNodeClassInfo).isVersioned();
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(RuleNode)}.
   * <ul>
   *   <li>Then return
   * {@link org.thingsboard.server.common.data.rule.RuleNode#RuleNode(RuleNode)}
   * with ruleNode is
   * {@link org.thingsboard.server.common.data.rule.RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleChainService#updateRuleNodeConfiguration(org.thingsboard.server.common.data.rule.RuleNode)}
   */
  @Test
  @DisplayName("Test updateRuleNodeConfiguration(RuleNode); then return RuleNode(RuleNode) with ruleNode is RuleNode()")
  void testUpdateRuleNodeConfiguration_thenReturnRuleNodeWithRuleNodeIsRuleNode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = mock(RuleNodeClassInfo.class);
    when(ruleNodeClassInfo.getAnnotation()).thenThrow(new RuntimeException("foo"));
    when(ruleNodeClassInfo.getCurrentVersion()).thenReturn(1);
    when(ruleNodeClassInfo.isVersioned()).thenReturn(true);
    Optional<RuleNodeClassInfo> ofResult = Optional.of(ruleNodeClassInfo);
    ComponentDiscoveryService componentDiscoveryService = mock(ComponentDiscoveryService.class);
    when(componentDiscoveryService.getRuleNodeInfo(Mockito.<String>any())).thenReturn(ofResult);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultTbRuleChainService defaultTbRuleChainService = new DefaultTbRuleChainService(ruleChainService,
        relationService, new InstallScripts(), componentDiscoveryService);
    org.thingsboard.server.common.data.rule.RuleNode node = new org.thingsboard.server.common.data.rule.RuleNode(
        new org.thingsboard.server.common.data.rule.RuleNode());

    // Act
    org.thingsboard.server.common.data.rule.RuleNode actualUpdateRuleNodeConfigurationResult = defaultTbRuleChainService
        .updateRuleNodeConfiguration(node);

    // Assert
    verify(componentDiscoveryService).getRuleNodeInfo(isNull());
    verify(ruleNodeClassInfo).getAnnotation();
    verify(ruleNodeClassInfo, atLeast(1)).getCurrentVersion();
    verify(ruleNodeClassInfo).isVersioned();
    assertSame(node, actualUpdateRuleNodeConfigurationResult);
  }
}
