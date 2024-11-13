package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.dao.rule.RuleChainService;

@ContextConfiguration(classes = {RuleChainsEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RuleChainsEdgeEventFetcherDiffblueTest {
  @MockBean
  private RuleChainService ruleChainService;

  @Autowired
  private RuleChainsEdgeEventFetcher ruleChainsEdgeEventFetcher;

  /**
   * Test
   * {@link RuleChainsEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainsEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink); when Edge(); then return EMPTY_PAGE_DATA")
  void testFetchEntities_whenEdge_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainService.findRuleChainsByTenantIdAndEdgeId(Mockito.<TenantId>any(), Mockito.<EdgeId>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<RuleChain> actualFetchEntitiesResult = ruleChainsEdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(ruleChainService).findRuleChainsByTenantIdAndEdgeId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   * with {@code TenantId}, {@code Edge}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, RuleChain) with 'TenantId', 'Edge', 'RuleChain'")
  void testConstructEdgeEventWithTenantIdEdgeRuleChain() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = ruleChainsEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new RuleChain());

    // Assert
    JsonNode body = actualConstructEdgeEventResult.getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   * with {@code TenantId}, {@code Edge}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, RuleChain) with 'TenantId', 'Edge', 'RuleChain'; given 'null'; then calls getId()")
  void testConstructEdgeEventWithTenantIdEdgeRuleChain_givenNull_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    when(edge.getRootRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));

    // Act
    EdgeEvent actualConstructEdgeEventResult = ruleChainsEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new RuleChain());

    // Assert
    verify(edge).getId();
    verify(edge).getRootRuleChainId();
    JsonNode body = actualConstructEdgeEventResult.getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   * with {@code TenantId}, {@code Edge}, {@code RuleChain}.
   * <ul>
   *   <li>Then return EntityId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, RuleChain) with 'TenantId', 'Edge', 'RuleChain'; then return EntityId is randomUUID")
  void testConstructEdgeEventWithTenantIdEdgeRuleChain_thenReturnEntityIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    when(edge.getRootRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    UUID id = UUID.randomUUID();

    // Act
    EdgeEvent actualConstructEdgeEventResult = ruleChainsEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new RuleChain(new RuleChainId(id)));

    // Assert
    verify(edge).getId();
    verify(edge).getRootRuleChainId();
    JsonNode body = actualConstructEdgeEventResult.getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   * with {@code TenantId}, {@code Edge}, {@code RuleChain}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, RuleChain)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, RuleChain) with 'TenantId', 'Edge', 'RuleChain'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeRuleChain_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act and Assert
    JsonNode body = ruleChainsEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new RuleChain()).getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }
}
