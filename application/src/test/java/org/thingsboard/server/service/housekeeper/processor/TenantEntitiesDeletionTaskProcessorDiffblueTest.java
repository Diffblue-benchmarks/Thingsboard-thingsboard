package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.housekeeper.TenantEntitiesDeletionHousekeeperTask;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.entity.EntityDaoRegistry;

@ContextConfiguration(classes = {TenantEntitiesDeletionTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TenantEntitiesDeletionTaskProcessorDiffblueTest {
  @MockBean
  private EntityDaoRegistry entityDaoRegistry;

  @MockBean
  private HousekeeperClient housekeeperClient;

  @Autowired
  private TenantEntitiesDeletionTaskProcessor tenantEntitiesDeletionTaskProcessor;

  /**
   * Test
   * {@link TenantEntitiesDeletionTaskProcessor#process(TenantEntitiesDeletionHousekeeperTask)}
   * with {@code TenantEntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Then calls {@link HousekeeperTask#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEntitiesDeletionTaskProcessor#process(TenantEntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(TenantEntitiesDeletionHousekeeperTask) with 'TenantEntitiesDeletionHousekeeperTask'; then calls getTenantId()")
  void testProcessWithTenantEntitiesDeletionHousekeeperTask_thenCallsGetTenantId() throws Exception {
    // Arrange
    Dao<Object> dao = mock(Dao.class);
    when(dao.findIdsByTenantIdAndIdOffset(Mockito.<TenantId>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(entityDaoRegistry.getDao(Mockito.<EntityType>any())).thenReturn(dao);
    TenantEntitiesDeletionHousekeeperTask task = mock(TenantEntitiesDeletionHousekeeperTask.class);
    when(task.getEntityType()).thenReturn(EntityType.TENANT);
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    tenantEntitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(task).getTenantId();
    verify(task).getEntityType();
    verify(dao).findIdsByTenantIdAndIdOffset(isA(TenantId.class), isNull(), eq(128));
    verify(entityDaoRegistry).getDao(eq(EntityType.TENANT));
  }

  /**
   * Test {@link TenantEntitiesDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link TenantEntitiesDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_TENANT_ENTITIES,
        (new TenantEntitiesDeletionTaskProcessor(null)).getTaskType());
  }
}
