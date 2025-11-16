/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.housekeeper;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
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
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent.DeleteEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;

@ContextConfiguration(classes = {CleanUpService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class CleanUpServiceDiffblueTest {
  @Autowired private CleanUpService cleanUpService;

  @MockBean private HousekeeperClient housekeeperClient;

  @MockBean private RelationService relationService;

  /**
   * Test {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   *
   * <p>Method under test: {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  public void testHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  public void testHandleEntityDeletionEvent2() {
    // Arrange
    doNothing()
        .when(relationService)
        .deleteEntityRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  public void testHandleEntityDeletionEvent_thenCallsDeleteInboundRelations() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.handleEntityDeletionEvent(DeleteEntityEvent)"})
  public void testHandleEntityDeletionEvent_thenCallsSubmitTask() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.cleanUpRelatedData(TenantId, EntityId)"})
  public void testCleanUpRelatedData_thenCallsDeleteInboundRelations() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.cleanUpRelatedData(TenantId, EntityId)"})
  public void testCleanUpRelatedData_thenCallsSubmitTask() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanUpService.removeTenantEntities(TenantId, EntityType[])"})
  public void testRemoveTenantEntities_thenCallsSubmitTask() {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());

    // Act
    cleanUpService.removeTenantEntities(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(housekeeperClient).submitTask(isA(HousekeeperTask.class));
  }
}
