package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
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
import org.thingsboard.server.common.data.housekeeper.EntitiesDeletionHousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.entity.EntityDaoService;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;

@ContextConfiguration(classes = {EntitiesDeletionTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EntitiesDeletionTaskProcessorDiffblueTest {
  @Autowired
  private EntitiesDeletionTaskProcessor entitiesDeletionTaskProcessor;

  @MockBean
  private EntityServiceRegistry entityServiceRegistry;

  @MockBean
  private HousekeeperClient housekeeperClient;

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'ALARM'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenAlarm() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.ALARM);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.ALARM));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'ASSET'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenAsset() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.ASSET);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.ASSET));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'CUSTOMER'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenCustomer() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.CUSTOMER);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.CUSTOMER));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code DASHBOARD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'DASHBOARD'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenDashboard() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.DASHBOARD);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.DASHBOARD));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'DEVICE'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenDevice() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.DEVICE);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.DEVICE));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'ENTITY_VIEW'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenEntityView() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.ENTITY_VIEW);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.ENTITY_VIEW));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'RULE_CHAIN'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenRuleChain() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.RULE_CHAIN);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.RULE_CHAIN));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'RULE_NODE'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenRuleNode() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.RULE_NODE);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.RULE_NODE));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'TENANT_PROFILE'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenTenantProfile() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.TENANT_PROFILE);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.TENANT_PROFILE));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'USER'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenUser() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.USER);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.USER));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'WIDGET_TYPE'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenWidgetType() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.WIDGET_TYPE);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.WIDGET_TYPE));
  }

  /**
   * Test
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   * with {@code EntitiesDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@code WIDGETS_BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesDeletionTaskProcessor#process(EntitiesDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(EntitiesDeletionHousekeeperTask) with 'EntitiesDeletionHousekeeperTask'; given 'WIDGETS_BUNDLE'")
  void testProcessWithEntitiesDeletionHousekeeperTask_givenWidgetsBundle() throws Exception {
    // Arrange
    EntityDaoService entityDaoService = mock(EntityDaoService.class);
    doNothing().when(entityDaoService).deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any())).thenReturn(entityDaoService);

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(UUID.randomUUID());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.WIDGETS_BUNDLE);
    task.setEntities(entities);

    // Act
    entitiesDeletionTaskProcessor.process(task);

    // Assert
    verify(entityDaoService).deleteEntity(isNull(), isA(EntityId.class), eq(true));
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.WIDGETS_BUNDLE));
  }

  /**
   * Test {@link EntitiesDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link EntitiesDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_ENTITIES,
        (new EntitiesDeletionTaskProcessor(mock(EntityServiceRegistry.class))).getTaskType());
  }
}
