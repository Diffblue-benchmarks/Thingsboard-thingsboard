package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.edge.EdgeSynchronizationManager;
import org.thingsboard.server.dao.eventsourcing.ActionCause;
import org.thingsboard.server.dao.eventsourcing.ActionEntityEvent;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent.DeleteEntityEventBuilder;
import org.thingsboard.server.dao.eventsourcing.RelationActionEvent;
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent;
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent.SaveEntityEventBuilder;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {EdgeEventSourcingListener.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EdgeEventSourcingListenerDiffblueTest {
  @Autowired private EdgeEventSourcingListener edgeEventSourcingListener;

  @MockBean private EdgeSynchronizationManager edgeSynchronizationManager;

  @MockBean private TbClusterService tbClusterService;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)} with {@code
   * ActionEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(ActionEntityEvent)"})
  void testHandleEventWithActionEntityEvent() throws JsonProcessingException {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    when(event.getBody()).thenReturn(jsonMapper.writeValueAsString(new Edge()));
    when(event.getActionType()).thenReturn(ActionType.ADDED);
    when(event.getEdgeId()).thenReturn(null);
    when(event.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(event.getEntityId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            eq(
                "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"customerId\":null,\"rootRuleChainId\":null,\"name\":null,\"type\":null,\"label\":null,\"routingKey\":null,\"secret\":null,\"version\":null,\"additionalInfo\":null}"),
            isNull(),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
    verify(event).getActionType();
    verify(event).getBody();
    verify(event).getEdgeId();
    verify(event, atLeast(1)).getEntityId();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)} with {@code
   * ActionEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(ActionEntityEvent)"})
  void testHandleEventWithActionEntityEvent2() throws JsonProcessingException {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    when(event.getBody()).thenReturn(jsonMapper.writeValueAsString(new Edge()));
    when(event.getActionType()).thenReturn(ActionType.ADDED);
    when(event.getEdgeId()).thenReturn(null);
    when(event.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(event.getEntityId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            eq(
                "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"customerId\":null,\"rootRuleChainId\":null,\"name\":null,\"type\":null,\"label\":null,\"routingKey\":null,\"secret\":null,\"version\":null,\"additionalInfo\":null}"),
            isNull(),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
    verify(event).getActionType();
    verify(event).getBody();
    verify(event).getEdgeId();
    verify(event, atLeast(1)).getEntityId();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)} with {@code
   * ActionEntityEvent}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(ActionEntityEvent)"})
  void testHandleEventWithActionEntityEvent_thenThrowRuntimeException() {
    // Arrange
    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);
    when(event.getTenantId()).thenThrow(new RuntimeException());
    when(event.getEntityId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeEventSourcingListener.handleEvent(event));
    verify(event, atLeast(1)).getEntityId();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenThrow(new RuntimeException());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    DeleteEntityEventBuilder<?> entityIdResult =
        causeResult.entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent2() {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    DeleteEntityEventBuilder<?> entityIdResult =
        causeResult.entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.DELETED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent3() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    DeleteEntityEventBuilder<?> entityIdResult =
        causeResult.entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent4() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    // Act
    edgeEventSourcingListener.handleEvent(
        causeResult
            .entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(tenantId)
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.DELETED),
            isNull());
    verify(tenantId).isSysTenantId();
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    // Act
    edgeEventSourcingListener.handleEvent(
        causeResult
            .entityId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(tenantId)
            .build());

    // Assert
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then calls {@link EdgeId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; given 'TENANT'; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent_givenTenant_thenCallsGetEntityType() {
    // Arrange
    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> entityIdResult =
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entityId(entityId);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    // Act
    edgeEventSourcingListener.handleEvent(entityIdResult.tenantId(tenantId).build());

    // Assert
    verify(entityId).getEntityType();
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbClusterService#sendNotificationMsgToEdge(TenantId, EdgeId, EntityId,
   *       String, EdgeEventType, EdgeEventActionType, EdgeId)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; then calls sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent_thenCallsSendNotificationMsgToEdge() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    DeleteEntityEventBuilder<?> entityIdResult =
        causeResult.entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.DELETED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)} with {@code
   * DeleteEntityEvent}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(DeleteEntityEvent)"})
  void testHandleEventWithDeleteEntityEvent_thenThrowRuntimeException() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenThrow(new RuntimeException());

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    DeleteEntityEventBuilder<?> causeResult =
        builderResult.body("Not all who wander are lost").cause(ActionCause.TENANT_DELETION);

    DeleteEntityEventBuilder<?> entityIdResult =
        causeResult.entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            edgeEventSourcingListener.handleEvent(
                entityIdResult
                    .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .build()));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RelationActionEvent event = new RelationActionEvent(tenantId, null, ActionType.ADDED);

    // Act and Assert
    assertDoesNotThrow(() -> edgeEventSourcingListener.handleEvent(event));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent2() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenThrow(new RuntimeException());

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationActionEvent event = new RelationActionEvent(tenantId, relation, ActionType.ADDED);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent3() {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationActionEvent event = new RelationActionEvent(tenantId, relation, ActionType.ADDED);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isNull(),
            eq(
                "{\"from\":null,\"to\":null,\"type\":null,\"typeGroup\":\"COMMON\",\"version\":null,\"additionalInfo\":null}"),
            eq(EdgeEventType.RELATION),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent4() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(null);

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationActionEvent event = new RelationActionEvent(tenantId, relation, ActionType.ADDED);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent5() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getTypeGroup()).thenThrow(new RuntimeException());

    RelationActionEvent event = mock(RelationActionEvent.class);
    when(event.getRelation()).thenReturn(entityRelation);
    when(event.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeEventSourcingListener.handleEvent(event));
    verify(entityRelation).getTypeGroup();
    verify(event).getRelation();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; given EntityRelation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_givenEntityRelation() {
    // Arrange
    RelationActionEvent event = mock(RelationActionEvent.class);
    when(event.getRelation()).thenReturn(new EntityRelation());
    when(event.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeEventSourcingListener.handleEvent(event));
    verify(event).getRelation();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()} TypeGroup is {@code COMMON}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; given EntityRelation() TypeGroup is 'COMMON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_givenEntityRelationTypeGroupIsCommon() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    RelationActionEvent event = mock(RelationActionEvent.class);
    when(event.getRelation()).thenReturn(entityRelation);
    when(event.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeEventSourcingListener.handleEvent(event));
    verify(event).getRelation();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_givenNull() {
    // Arrange
    RelationActionEvent event = mock(RelationActionEvent.class);
    when(event.getRelation()).thenReturn(null);
    when(event.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeEventSourcingListener.handleEvent(event));
    verify(event).getRelation();
    verify(event, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; then calls getFrom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_thenCallsGetFrom() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new RuntimeException());
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationActionEvent event = new RelationActionEvent(tenantId, relation, ActionType.ADDED);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(relation).getFrom();
    verify(relation).getTypeGroup();
    verify(relation).setTypeGroup(RelationTypeGroup.COMMON);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbClusterService#sendNotificationMsgToEdge(TenantId, EdgeId, EntityId,
   *       String, EdgeEventType, EdgeEventActionType, EdgeId)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; then calls sendNotificationMsgToEdge(TenantId, EdgeId, EntityId, String, EdgeEventType, EdgeEventActionType, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_thenCallsSendNotificationMsgToEdge() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationActionEvent event = new RelationActionEvent(tenantId, relation, ActionType.ADDED);

    // Act
    edgeEventSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isNull(),
            eq(
                "{\"from\":null,\"to\":null,\"type\":null,\"typeGroup\":\"COMMON\",\"version\":null,\"additionalInfo\":null}"),
            eq(EdgeEventType.RELATION),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)} with {@code
   * RelationActionEvent}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(RelationActionEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(RelationActionEvent) with 'RelationActionEvent'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(RelationActionEvent)"})
  void testHandleEventWithRelationActionEvent_thenDoesNotThrow() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RelationActionEvent event =
        new RelationActionEvent(tenantId, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertDoesNotThrow(() -> edgeEventSourcingListener.handleEvent(event));
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenThrow(new RuntimeException());

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(null);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent2() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(null);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent3() {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(null);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.ADDED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent4() {
    // Arrange
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(null);

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(null);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent5() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(false).entityId(null);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.UPDATED),
            isNull());
    verify(edgeSynchronizationManager).getEdgeId();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   *   <li>When {@link EdgeId} {@link EdgeId#getEntityType()} return {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'ALARM'; when EdgeId getEntityType() return 'ALARM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenAlarm_whenEdgeIdGetEntityTypeReturnAlarm() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.UPDATED),
            isNull());
    verify(entityId).getEntityType();
    verify(edgeSynchronizationManager).getEdgeId();
    verify(saveEntityEventBuilder).created(true);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'CUSTOMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenCustomer() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.UPDATED),
            isNull());
    verify(entityId).getEntityType();
    verify(edgeSynchronizationManager).getEdgeId();
    verify(saveEntityEventBuilder).created(true);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EdgeId} {@link EdgeId#getEntityType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'null'; when EdgeId getEntityType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenNull_whenEdgeIdGetEntityTypeReturnNull() {
    // Arrange
    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(null);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(entityId).getEntityType();
    verify(saveEntityEventBuilder).created(true);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'RULE_CHAIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenRuleChain() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.UPDATED),
            isNull());
    verify(entityId).getEntityType();
    verify(edgeSynchronizationManager).getEdgeId();
    verify(saveEntityEventBuilder).created(true);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenRuntimeException() {
    // Arrange
    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException());

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(entityId).getEntityType();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenTenant() {
    // Arrange
    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<?> entityIdResult = builderResult.created(true).entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(entityId).getEntityType();
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenTenant2() {
    // Arrange
    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(entityId).getEntityType();
    verify(saveEntityEventBuilder).created(true);
  }

  /**
   * Test {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)} with {@code
   * SaveEntityEvent}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   *   <li>When {@link EdgeId} {@link EdgeId#getEntityType()} return {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'USER'; when EdgeId getEntityType() return 'USER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeEventSourcingListener.handleEvent(SaveEntityEvent)"})
  void testHandleEventWithSaveEntityEvent_givenUser_whenEdgeIdGetEntityTypeReturnUser() {
    // Arrange
    doNothing()
        .when(tbClusterService)
        .sendNotificationMsgToEdge(
            Mockito.<TenantId>any(),
            Mockito.<EdgeId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<EdgeEventType>any(),
            Mockito.<EdgeEventActionType>any(),
            Mockito.<EdgeId>any());
    when(edgeSynchronizationManager.getEdgeId()).thenReturn(new ThreadLocal<>());

    SaveEntityEventBuilder<?> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<?> builderResult = SaveEntityEvent.builder();
    Mockito.<SaveEntityEventBuilder<?>>when(saveEntityEventBuilder.created(Mockito.<Boolean>any()))
        .thenReturn(builderResult);

    SaveEntityEventBuilder<?> createdResult = saveEntityEventBuilder.created(true);

    EdgeId entityId = mock(EdgeId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);

    SaveEntityEventBuilder<?> entityIdResult = createdResult.entityId(entityId);

    // Act
    edgeEventSourcingListener.handleEvent(
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build());

    // Assert
    verify(tbClusterService)
        .sendNotificationMsgToEdge(
            isA(TenantId.class),
            isNull(),
            isA(EntityId.class),
            isNull(),
            isNull(),
            eq(EdgeEventActionType.UPDATED),
            isNull());
    verify(entityId).getEntityType();
    verify(edgeSynchronizationManager).getEdgeId();
    verify(saveEntityEventBuilder).created(true);
  }
}
