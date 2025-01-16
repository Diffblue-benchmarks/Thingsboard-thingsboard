package org.thingsboard.server.service.entitiy;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.dao.eventsourcing.ActionEntityEvent;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {EntityStateSourcingListener.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EntityStateSourcingListenerDiffblueTest {
  @Autowired
  private EntityStateSourcingListener entityStateSourcingListener;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(ActionEntityEvent)} with
   * {@code ActionEntityEvent}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'; given 'ADDED'")
  void testHandleEventWithActionEntityEvent_givenAdded() {
    // Arrange
    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);
    when(event.getActionType()).thenReturn(ActionType.ADDED);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event, atLeast(1)).getActionType();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(ActionEntityEvent)} with
   * {@code ActionEntityEvent}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(ActionEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(ActionEntityEvent) with 'ActionEntityEvent'; given AlarmId(UUID) with id is randomUUID")
  void testHandleEventWithActionEntityEvent_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    ActionEntityEvent<?> event = mock(ActionEntityEvent.class);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getActionType()).thenReturn(ActionType.CREDENTIALS_UPDATED);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event, atLeast(1)).getActionType();
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)} with
   * {@code DeleteEntityEvent}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return
   * {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; given AlarmId getEntityType() return 'CUSTOMER'")
  void testHandleEventWithDeleteEntityEvent_givenAlarmIdGetEntityTypeReturnCustomer() {
    // Arrange
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    DeleteEntityEvent<?> event = mock(DeleteEntityEvent.class);
    when(event.getEntityId()).thenReturn(alarmId);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.DELETED));
    verify(alarmId).getEntityType();
    verify(event).getEntityId();
    verify(event).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)} with
   * {@code DeleteEntityEvent}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; given AlarmId(UUID) with id is randomUUID")
  void testHandleEventWithDeleteEntityEvent_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    DeleteEntityEvent<?> event = mock(DeleteEntityEvent.class);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(event).getEntityId();
    verify(event).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)} with
   * {@code DeleteEntityEvent}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)}
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
    entityStateSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event).getEntityId();
    verify(event).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)} with
   * {@code DeleteEntityEvent}.
   * <ul>
   *   <li>When {@link DeleteEntityEvent} {@link DeleteEntityEvent#getEntityId()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(DeleteEntityEvent) with 'DeleteEntityEvent'; when DeleteEntityEvent getEntityId() return 'null'")
  void testHandleEventWithDeleteEntityEvent_whenDeleteEntityEventGetEntityIdReturnNull() {
    // Arrange
    DeleteEntityEvent<?> event = mock(DeleteEntityEvent.class);
    when(event.getEntityId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)} with
   * {@code SaveEntityEvent}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given AlarmId(UUID) with id is randomUUID")
  void testHandleEventWithSaveEntityEvent_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    SaveEntityEvent<?> event = mock(SaveEntityEvent.class);
    when(event.getCreated()).thenReturn(true);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(event, atLeast(1)).getCreated();
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)} with
   * {@code SaveEntityEvent}.
   * <ul>
   *   <li>Given {@link EntityId} {@link EntityId#getEntityType()} return
   * {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given EntityId getEntityType() return 'ASSET'")
  void testHandleEventWithSaveEntityEvent_givenEntityIdGetEntityTypeReturnAsset() {
    // Arrange
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    SaveEntityEvent<?> event = mock(SaveEntityEvent.class);
    when(event.getCreated()).thenReturn(true);
    when(event.getEntityId()).thenReturn(entityId);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.CREATED));
    verify(entityId).getEntityType();
    verify(event, atLeast(1)).getCreated();
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)} with
   * {@code SaveEntityEvent}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; given 'false'")
  void testHandleEventWithSaveEntityEvent_givenFalse() {
    // Arrange
    SaveEntityEvent<?> event = mock(SaveEntityEvent.class);
    when(event.getCreated()).thenReturn(false);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(event, atLeast(1)).getCreated();
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)} with
   * {@code SaveEntityEvent}.
   * <ul>
   *   <li>When {@link SaveEntityEvent} {@link SaveEntityEvent#getCreated()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; when SaveEntityEvent getCreated() return 'null'")
  void testHandleEventWithSaveEntityEvent_whenSaveEntityEventGetCreatedReturnNull() {
    // Arrange
    SaveEntityEvent<?> event = mock(SaveEntityEvent.class);
    when(event.getCreated()).thenReturn(null);
    when(event.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert
    verify(event).getCreated();
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)} with
   * {@code SaveEntityEvent}.
   * <ul>
   *   <li>When {@link SaveEntityEvent} {@link SaveEntityEvent#getEntityId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityStateSourcingListener#handleEvent(SaveEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEvent(SaveEntityEvent) with 'SaveEntityEvent'; when SaveEntityEvent getEntityId() return 'null'")
  void testHandleEventWithSaveEntityEvent_whenSaveEntityEventGetEntityIdReturnNull() {
    // Arrange
    SaveEntityEvent<?> event = mock(SaveEntityEvent.class);
    when(event.getEntityId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    entityStateSourcingListener.handleEvent(event);

    // Assert that nothing has changed
    verify(event).getEntityId();
    verify(event).getTenantId();
  }
}
