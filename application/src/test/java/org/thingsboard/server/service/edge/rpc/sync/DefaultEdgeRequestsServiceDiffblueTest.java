package org.thingsboard.server.service.edge.rpc.sync;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.common.util.AbstractListeningExecutor;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsRequestMsg;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataRequestMsg;
import org.thingsboard.server.gen.edge.v1.UserCredentialsRequestMsg;
import org.thingsboard.server.gen.edge.v1.WidgetBundleTypesRequestMsg;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;

@ExtendWith(MockitoExtension.class)
class DefaultEdgeRequestsServiceDiffblueTest {
  @Mock
  private DbCallbackExecutorService dbCallbackExecutorService;

  @InjectMocks
  private DefaultEdgeRequestsService defaultEdgeRequestsService;

  /**
   * Test {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeRequestsService#processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)}
   */
  @Test
  @DisplayName("Test processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg); when Edge(); then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEdgeRequestsService.processRuleChainMetadataRequestMsg(TenantId, Edge, RuleChainMetadataRequestMsg)"})
  void testProcessRuleChainMetadataRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessRuleChainMetadataRequestMsgResult = defaultEdgeRequestsService
        .processRuleChainMetadataRequestMsg(tenantId, edge, RuleChainMetadataRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessRuleChainMetadataRequestMsgResult.get());
    assertTrue(actualProcessRuleChainMetadataRequestMsgResult.isDone());
  }

  /**
   * Test {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeRequestsService#processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg); when Edge(); then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEdgeRequestsService.processDeviceCredentialsRequestMsg(TenantId, Edge, DeviceCredentialsRequestMsg)"})
  void testProcessDeviceCredentialsRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessDeviceCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processDeviceCredentialsRequestMsg(tenantId, edge, DeviceCredentialsRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceCredentialsRequestMsgResult.get());
    assertTrue(actualProcessDeviceCredentialsRequestMsgResult.isDone());
  }

  /**
   * Test {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeRequestsService#processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)}
   */
  @Test
  @DisplayName("Test processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg); when Edge(); then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEdgeRequestsService.processUserCredentialsRequestMsg(TenantId, Edge, UserCredentialsRequestMsg)"})
  void testProcessUserCredentialsRequestMsg_whenEdge_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessUserCredentialsRequestMsgResult = defaultEdgeRequestsService
        .processUserCredentialsRequestMsg(tenantId, edge, UserCredentialsRequestMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessUserCredentialsRequestMsgResult.get());
    assertTrue(actualProcessUserCredentialsRequestMsgResult.isDone());
  }

  /**
   * Test {@link DefaultEdgeRequestsService#processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)}.
   * <p>
   * Method under test: {@link DefaultEdgeRequestsService#processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)}
   */
  @Test
  @DisplayName("Test processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEdgeRequestsService.processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)"})
  void testProcessWidgetBundleTypesRequestMsg() {
    // Arrange
    doThrow(new RuntimeException("[{}] processWidgetBundleTypesRequestMsg [{}][{}]")).when(dbCallbackExecutorService)
        .execute(Mockito.<Runnable>any());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    defaultEdgeRequestsService.processWidgetBundleTypesRequestMsg(tenantId, edge,
        WidgetBundleTypesRequestMsg.getDefaultInstance());

    // Assert
    verify(dbCallbackExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link DefaultEdgeRequestsService#processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)}.
   * <ul>
   *   <li>Then calls {@link AbstractListeningExecutor#execute(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeRequestsService#processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)}
   */
  @Test
  @DisplayName("Test processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg); then calls execute(Runnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEdgeRequestsService.processWidgetBundleTypesRequestMsg(TenantId, Edge, WidgetBundleTypesRequestMsg)"})
  void testProcessWidgetBundleTypesRequestMsg_thenCallsExecute() {
    // Arrange
    doNothing().when(dbCallbackExecutorService).execute(Mockito.<Runnable>any());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    defaultEdgeRequestsService.processWidgetBundleTypesRequestMsg(tenantId, edge,
        WidgetBundleTypesRequestMsg.getDefaultInstance());

    // Assert
    verify(dbCallbackExecutorService).execute(isA(Runnable.class));
  }
}
