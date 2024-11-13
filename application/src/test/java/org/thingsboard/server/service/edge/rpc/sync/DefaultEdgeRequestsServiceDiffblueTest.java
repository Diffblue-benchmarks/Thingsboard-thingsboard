package org.thingsboard.server.service.edge.rpc.sync;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsRequestMsg;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataRequestMsg;
import org.thingsboard.server.gen.edge.v1.UserCredentialsRequestMsg;

class DefaultEdgeRequestsServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link Edge#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}
   */
  @Test
  @DisplayName("Test processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg); given 'Name'; then calls getName()")
  void testProcessRuleChainMetadataRequestMsg_givenName_thenCallsGetName()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualProcessRuleChainMetadataRequestMsgResult = defaultEdgeRequestsService
        .processRuleChainMetadataRequestMsg(tenantId, edge, RuleChainMetadataRequestMsg.getDefaultInstance());

    // Assert
    verify(edge).getName();
    assertNull(actualProcessRuleChainMetadataRequestMsgResult.get());
    assertTrue(actualProcessRuleChainMetadataRequestMsgResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}
   */
  @Test
  @DisplayName("Test processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg); when Edge(); then return get() is 'null'")
  void testProcessRuleChainMetadataRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessRuleChainMetadataRequestMsgResult = defaultEdgeRequestsService
        .processRuleChainMetadataRequestMsg(tenantId, edge, RuleChainMetadataRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessRuleChainMetadataRequestMsgResult.get());
    assertTrue(actualProcessRuleChainMetadataRequestMsgResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link Edge#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg); given 'Name'; then calls getName()")
  void testProcessDeviceCredentialsRequestMsg_givenName_thenCallsGetName()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualProcessDeviceCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processDeviceCredentialsRequestMsg(tenantId, edge, DeviceCredentialsRequestMsg.getDefaultInstance());

    // Assert
    verify(edge).getName();
    assertNull(actualProcessDeviceCredentialsRequestMsgResult.get());
    assertTrue(actualProcessDeviceCredentialsRequestMsgResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg); when Edge(); then return get() is 'null'")
  void testProcessDeviceCredentialsRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessDeviceCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processDeviceCredentialsRequestMsg(tenantId, edge, DeviceCredentialsRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceCredentialsRequestMsgResult.get());
    assertTrue(actualProcessDeviceCredentialsRequestMsgResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link Edge#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg); given 'Name'; then calls getName()")
  void testProcessUserCredentialsRequestMsg_givenName_thenCallsGetName()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualProcessUserCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processUserCredentialsRequestMsg(tenantId, edge, UserCredentialsRequestMsg.getDefaultInstance());

    // Assert
    verify(edge).getName();
    assertNull(actualProcessUserCredentialsRequestMsgResult.get());
    assertTrue(actualProcessUserCredentialsRequestMsgResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg); when Edge(); then return get() is 'null'")
  void testProcessUserCredentialsRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeRequestsService defaultEdgeRequestsService = new DefaultEdgeRequestsService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessUserCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processUserCredentialsRequestMsg(tenantId, edge, UserCredentialsRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessUserCredentialsRequestMsgResult.get());
    assertTrue(actualProcessUserCredentialsRequestMsgResult.isDone());
  }
}
