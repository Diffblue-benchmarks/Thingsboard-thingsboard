package org.thingsboard.server.service.edge;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.edge.EdgeSynchronizationManager;
import org.thingsboard.server.dao.eventsourcing.ActionEntityEvent;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.eventsourcing.RelationActionEvent;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {EdgeEventSourcingListener.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EdgeEventSourcingListenerDiffblueTest {
  @Autowired
  private EdgeEventSourcingListener edgeEventSourcingListener;

  @MockBean
  private EdgeSynchronizationManager edgeSynchronizationManager;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)} with
   * {@code ActionEntityEvent}.
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'")
  void testHandleEventWithActionEntityEvent() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(null);
    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);
    when(event.getBody()).thenReturn("Not all who wander are lost");
    when(event.getActionType()).thenReturn(ActionType.ADDED);
    when(event.getEdgeId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
    verify(event).getActionType();
    verify(event).getBody();
    verify(event).getEdgeId();
    verify(event, atLeast(1)).getEntityId();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)} with
   * {@code ActionEntityEvent}.
   * <ul>
   *   <li>Then calls
   * {@link TbClusterService#sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'; then calls sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)")
  void testHandleEventWithActionEntityEvent_thenCallsSendNotificationMsgToEdge() {
    // Arrange
    doNothing().when(tbClusterService)
        .sendNotificationMsgToEdge(Mockito.<TenantId>any(), Mockito.<EdgeId>any(), Mockito.<EntityId>any(),
            Mockito.<String>any(), Mockito.<EdgeEventType>any(), Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());
    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);
    when(event.getBody()).thenReturn("Not all who wander are lost");
    when(event.getActionType()).thenReturn(ActionType.ADDED);
    when(event.getEdgeId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(tbClusterService).sendNotificationMsgToEdge(isA(TenantId.class), isNull(), isA(EntityId.class),
        eq("Not all who wander are lost"), isNull(), eq(EdgeEventActionType.ADDED), isNull());
    verify(edgeSynchronizationManager).getEdgeId();
    verify(event).getActionType();
    verify(event).getBody();
    verify(event).getEdgeId();
    verify(event, atLeast(1)).getEntityId();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with
   * {@code DeleteEntityEvent}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; given TenantService tenantExists(TenantId) return 'false'")
  void testHandleEventWithDeleteEntityEvent_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    DeleteEntityEvent<?> event = mock(DeleteEntityEvent.class);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event).getEntityId();
    verify(event).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with
   * {@code RelationActionEvent}.
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  void testHandleEventWithRelationActionEvent() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(null);

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act
    edgeEventSourcingListener
        .handleEvent(new RelationActionEvent(new TenantId(UUID.randomUUID()), relation, ActionType.ADDED));

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with
   * {@code RelationActionEvent}.
   * <ul>
   *   <li>Then calls {@link RelationActionEvent#getRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; then calls getRelation()")
  void testHandleEventWithRelationActionEvent_thenCallsGetRelation() {
    // Arrange
    RelationActionEvent event = mock(RelationActionEvent.class);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(event.getRelation()).thenReturn(null);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event).getRelation();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with
   * {@code RelationActionEvent}.
   * <ul>
   *   <li>Then calls
   * {@link TbClusterService#sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; then calls sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)")
  void testHandleEventWithRelationActionEvent_thenCallsSendNotificationMsgToEdge() {
    // Arrange
    doNothing().when(tbClusterService)
        .sendNotificationMsgToEdge(Mockito.<TenantId>any(), Mockito.<EdgeId>any(), Mockito.<EntityId>any(),
            Mockito.<String>any(), Mockito.<EdgeEventType>any(), Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act
    edgeEventSourcingListener
        .handleEvent(new RelationActionEvent(new TenantId(UUID.randomUUID()), relation, ActionType.ADDED));

    // Assert
    verify(tbClusterService).sendNotificationMsgToEdge(isA(TenantId.class), isNull(), isNull(), eq(
        "{\"from\":null,\"to\":null,\"type\":null,\"typeGroup\":\"COMMON\",\"version\":null,\"additionalInfo\":null}"),
        eq(EdgeEventType.RELATION), eq(EdgeEventActionType.ADDED), isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }
}
