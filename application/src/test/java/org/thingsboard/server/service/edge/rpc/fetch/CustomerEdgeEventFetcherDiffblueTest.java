package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
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
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CustomerEdgeEventFetcherDiffblueTest {
  @Autowired private CustomerEdgeEventFetcher customerEdgeEventFetcher;

  @InjectMocks private CustomerEdgeEventFetcher customerEdgeEventFetcher2;

  @InjectMocks private CustomerId customerId;

  @MockBean private UUID uUID;

  /**
   * Test {@link CustomerEdgeEventFetcher#getPageLink(int)}.
   *
   * <p>Method under test: {@link CustomerEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink CustomerEdgeEventFetcher.getPageLink(int)"})
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull(customerEdgeEventFetcher2.getPageLink(3));
  }

  /**
   * Test {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEdgeEventFetcher}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test fetchEdgeEvents(TenantId, Edge, PageLink); given CustomerEdgeEventFetcher; then return Data size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData CustomerEdgeEventFetcher.fetchEdgeEvents(TenantId, Edge, PageLink)"})
  void testFetchEdgeEvents_givenCustomerEdgeEventFetcher_thenReturnDataSizeIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult =
        customerEdgeEventFetcher.fetchEdgeEvents(tenantId, edge, new PageLink(3));

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

  /**
   * Test {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test fetchEdgeEvents(TenantId, Edge, PageLink); then return Data first EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData CustomerEdgeEventFetcher.fetchEdgeEvents(TenantId, Edge, PageLink)"})
  void testFetchEdgeEvents_thenReturnDataFirstEntityIdIsNull() {
    // Arrange
    CustomerEdgeEventFetcher customerEdgeEventFetcher = new CustomerEdgeEventFetcher(null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult =
        customerEdgeEventFetcher.fetchEdgeEvents(tenantId, edge, new PageLink(3));

    // Assert
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    assertNull(getResult.getBody());
    assertNull(getResult.getUid());
    assertNull(getResult.getEntityId());
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
