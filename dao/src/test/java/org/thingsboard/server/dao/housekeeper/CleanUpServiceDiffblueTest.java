package org.thingsboard.server.dao.housekeeper;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.ActionCause;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent.DeleteEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;

@ContextConfiguration(classes = {CleanUpService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CleanUpServiceDiffblueTest {
  @Autowired private CleanUpService cleanUpService;

  @MockBean private HousekeeperClient housekeeperClient;

  @MockBean private RelationService relationService;

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   *
   * <p>Method under test: {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEntityDeletionEvent(DeleteEntityEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  void testHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    // Act
    cleanUpService.handleEntityDeletionEvent(
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entityId(entityId)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());

    // Assert
    verify(entityId, atLeast(1)).getEntityType();
    verify(entityId, atLeast(1)).getId();
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(relationService).deleteEntityRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   *
   * <p>Method under test: {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName("Test handleEntityDeletionEvent(DeleteEntityEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  void testHandleEntityDeletionEvent2() {
    // Arrange
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    // Act
    cleanUpService.handleEntityDeletionEvent(
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entityId(entityId)
            .tenantId(null)
            .build());

    // Assert
    verify(entityId, atLeast(1)).getEntityType();
    verify(entityId, atLeast(1)).getId();
    verify(relationService).deleteEntityRelations(isNull(), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEntityDeletionEvent(DeleteEntityEvent); then calls deleteInboundRelations(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  void testHandleEntityDeletionEvent_thenCallsDeleteInboundRelations() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    Optional<HousekeeperClient> housekeeperClient = Optional.empty();

    CleanUpService cleanUpService = new CleanUpService(housekeeperClient, relationService);

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    // Act
    cleanUpService.handleEntityDeletionEvent(
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());

    // Assert
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.
   * </ul>
   *
   * <p>Method under test: {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEntityDeletionEvent(DeleteEntityEvent); then calls submitTask(HousekeeperTask)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  void testHandleEntityDeletionEvent_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    DeleteEntityEventBuilder<?> builderResult = DeleteEntityEvent.builder();

    // Act
    cleanUpService.handleEntityDeletionEvent(
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());

    // Assert
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(relationService).deleteEntityRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test cleanUpRelatedData(TenantId, EntityId); then calls deleteInboundRelations(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.cleanUpRelatedData(TenantId, EntityId)"})
  void testCleanUpRelatedData_thenCallsDeleteInboundRelations() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    Optional<HousekeeperClient> housekeeperClient = Optional.empty();

    CleanUpService cleanUpService = new CleanUpService(housekeeperClient, relationService);

    // Act
    cleanUpService.cleanUpRelatedData(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.
   * </ul>
   *
   * <p>Method under test: {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test cleanUpRelatedData(TenantId, EntityId); then calls submitTask(HousekeeperTask)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.cleanUpRelatedData(TenantId, EntityId)"})
  void testCleanUpRelatedData_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    cleanUpService.cleanUpRelatedData(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(relationService).deleteEntityRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link CleanUpService#removeTenantEntities(TenantId, EntityType[])}.
   *
   * <ul>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.
   * </ul>
   *
   * <p>Method under test: {@link CleanUpService#removeTenantEntities(TenantId, EntityType[])}
   */
  @Test
  @DisplayName(
      "Test removeTenantEntities(TenantId, EntityType[]); then calls submitTask(HousekeeperTask)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.removeTenantEntities(TenantId, EntityType[])"})
  void testRemoveTenantEntities_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());

    // Act
    cleanUpService.removeTenantEntities(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(housekeeperClient).submitTask(isA(HousekeeperTask.class));
  }
}
