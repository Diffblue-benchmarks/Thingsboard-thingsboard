package org.thingsboard.server.dao.housekeeper;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.ActionCause;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {CleanUpService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class CleanUpServiceDiffblueTest {
  @Autowired
  private CleanUpService cleanUpService;

  @MockBean
  private HousekeeperClient housekeeperClient;

  @MockBean
  private RelationService relationService;

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * <p>
   * Method under test:
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  public void testHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(relationService).deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    DeleteEntityEvent.DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<?> event = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(null)
        .build();

    // Act
    cleanUpService.handleEntityDeletionEvent(event);

    // Assert
    verify(relationService).deleteEntityRelations(isNull(), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * <ul>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  public void testHandleEntityDeletionEvent_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing().when(relationService).deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    DeleteEntityEvent.DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<?> event = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    cleanUpService.handleEntityDeletionEvent(event);

    // Assert
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(relationService).deleteEntityRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}
   */
  @Test
  public void testCleanUpRelatedData_whenSystem_tenant_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing().when(relationService).deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    cleanUpService.cleanUpRelatedData(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(relationService).deleteEntityRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#removeTenantEntities(TenantId, EntityType[])}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CleanUpService#removeTenantEntities(TenantId, EntityType[])}
   */
  @Test
  public void testRemoveTenantEntities_whenSystem_tenant_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());

    // Act
    cleanUpService.removeTenantEntities(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(housekeeperClient).submitTask(isA(HousekeeperTask.class));
  }
}
