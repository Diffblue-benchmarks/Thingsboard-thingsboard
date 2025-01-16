package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;

@ContextConfiguration(classes = {CustomerEdgeEventFetcher.class, CustomerId.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CustomerEdgeEventFetcherDiffblueTest {
  @Autowired
  private CustomerEdgeEventFetcher customerEdgeEventFetcher;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link CustomerEdgeEventFetcher#getPageLink(int)}.
   * <p>
   * Method under test: {@link CustomerEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  void testGetPageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerEdgeEventFetcher(new CustomerId(UUID.randomUUID()))).getPageLink(3));
  }

  /**
   * Test
   * {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#TenantId(UUID)} with
   * id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); then return Data first TenantId is TenantId(UUID) with id is randomUUID")
  void testFetchEdgeEvents_thenReturnDataFirstTenantIdIsTenantIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    TenantId tenantId2 = new TenantId(UUID.randomUUID());
    when(edge.getTenantId()).thenReturn(tenantId2);

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = customerEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(edge).getId();
    verify(edge).getTenantId();
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(1, data.size());
    assertSame(tenantId2, data.get(0).getTenantId());
  }

  /**
   * Test
   * {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return Data first Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); when Edge(); then return Data first Body is 'null'")
  void testFetchEdgeEvents_whenEdge_thenReturnDataFirstBodyIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = customerEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    assertNull(getResult.getBody());
    assertNull(getResult.getUid());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getEdgeId());
    assertNull(getResult.getTenantId());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(0L, getResult.getSeqId());
    assertEquals(1, actualFetchEdgeEventsResult.getTotalPages());
    assertEquals(1L, actualFetchEdgeEventsResult.getTotalElements());
    assertEquals(EdgeEventActionType.ADDED, getResult.getAction());
    assertEquals(EdgeEventType.CUSTOMER, getResult.getType());
    assertFalse(actualFetchEdgeEventsResult.hasNext());
  }
}
