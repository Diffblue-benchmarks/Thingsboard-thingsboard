package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.common.data.domain.DomainInfo;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.domain.DomainService;

@ContextConfiguration(classes = {OAuth2EdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OAuth2EdgeEventFetcherDiffblueTest {
  @MockBean
  private DomainService domainService;

  @Autowired
  private OAuth2EdgeEventFetcher oAuth2EdgeEventFetcher;

  /**
   * Test {@link OAuth2EdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link OAuth2EdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<DomainInfo> emptyPageDataResult = PageData.emptyPageData();
    when(domainService.findDomainInfosByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<DomainInfo> actualFetchEntitiesResult = oAuth2EdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(domainService).findDomainInfosByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link OAuth2EdgeEventFetcher#constructEdgeEvent(TenantId, Edge, DomainInfo)}
   * with {@code TenantId}, {@code Edge}, {@code DomainInfo}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeEventFetcher#constructEdgeEvent(TenantId, Edge, DomainInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, DomainInfo) with 'TenantId', 'Edge', 'DomainInfo'; given 'null'; then calls getId()")
  void testConstructEdgeEventWithTenantIdEdgeDomainInfo_givenNull_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = oAuth2EdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new DomainInfo());

    // Assert
    verify(edge).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DOMAIN, actualConstructEdgeEventResult.getType());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link OAuth2EdgeEventFetcher#constructEdgeEvent(TenantId, Edge, DomainInfo)}
   * with {@code TenantId}, {@code Edge}, {@code DomainInfo}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeEventFetcher#constructEdgeEvent(TenantId, Edge, DomainInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, DomainInfo) with 'TenantId', 'Edge', 'DomainInfo'; when Edge(); then return Body is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeDomainInfo_whenEdge_thenReturnBodyIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = oAuth2EdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new DomainInfo());

    // Assert
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DOMAIN, actualConstructEdgeEventResult.getType());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
