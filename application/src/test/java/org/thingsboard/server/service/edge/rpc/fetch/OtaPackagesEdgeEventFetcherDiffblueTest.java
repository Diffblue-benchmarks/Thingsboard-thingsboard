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
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.ota.OtaPackageService;

@ContextConfiguration(classes = {OtaPackagesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OtaPackagesEdgeEventFetcherDiffblueTest {
  @MockBean
  private OtaPackageService otaPackageService;

  @Autowired
  private OtaPackagesEdgeEventFetcher otaPackagesEdgeEventFetcher;

  /**
   * Test
   * {@link OtaPackagesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link OtaPackagesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageService.findTenantOtaPackagesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<OtaPackageInfo> actualFetchEntitiesResult = otaPackagesEdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(otaPackageService).findTenantOtaPackagesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   * with {@code TenantId}, {@code Edge}, {@code OtaPackageInfo}.
   * <p>
   * Method under test:
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, OtaPackageInfo) with 'TenantId', 'Edge', 'OtaPackageInfo'")
  void testConstructEdgeEventWithTenantIdEdgeOtaPackageInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act and Assert
    assertSame(tenantId,
        otaPackagesEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new OtaPackageInfo()).getTenantId());
  }

  /**
   * Test
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   * with {@code TenantId}, {@code Edge}, {@code OtaPackageInfo}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, OtaPackageInfo) with 'TenantId', 'Edge', 'OtaPackageInfo'; given 'null'; then calls getId()")
  void testConstructEdgeEventWithTenantIdEdgeOtaPackageInfo_givenNull_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = otaPackagesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new OtaPackageInfo());

    // Assert
    verify(edge).getId();
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   * with {@code TenantId}, {@code Edge}, {@code OtaPackageInfo}.
   * <ul>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackagesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, OtaPackageInfo) with 'TenantId', 'Edge', 'OtaPackageInfo'; then return Body is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeOtaPackageInfo_thenReturnBodyIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = otaPackagesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new OtaPackageInfo());

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
    assertEquals(EdgeEventType.OTA_PACKAGE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
