package org.thingsboard.server.dao.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.TenantProfileDao;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;

@ContextConfiguration(classes = {ApiUsageStateServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class ApiUsageStateServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApiUsageStateDao apiUsageStateDao;

  @Autowired
  private ApiUsageStateServiceImpl apiUsageStateServiceImpl;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<ApiUsageState> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TenantProfileDao tenantProfileDao;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private TimeseriesService timeseriesService;

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId() {
    // Arrange
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId2() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(apiUsageState);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId, atLeast(1)).getId();
    verify(apiUsageStateDao).removeById(isNull(), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(new ApiUsageState());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId, atLeast(1)).getId();
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ApiUsageStateDao} {@link Dao#findById(TenantId, UUID)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenApiUsageStateDaoFindByIdReturnNull() {
    // Arrange
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID),
        true);

    // Assert that nothing has changed
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} Id is
   * {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenApiUsageStateIdIsApiUsageStateIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(apiUsageState);
    ApiUsageStateId id = mock(ApiUsageStateId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(id, atLeast(1)).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(apiUsageStateDao).removeById(isNull(), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new ApiUsageState());
    ApiUsageStateId id = mock(ApiUsageStateId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(id, atLeast(1)).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>When {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_whenApiUsageStateIdWithIdIsNull_uuid_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID),
        true);

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}
   */
  @Test
  public void testCreateDefaultApiUsageState_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any())).thenReturn(apiUsageState);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any(),
        anyLong())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<ApiUsageState>any(), Mockito.<Function<ApiUsageState, TenantId>>any()))
        .thenReturn(new ApiUsageState());

    // Act
    ApiUsageState actualCreateDefaultApiUsageStateResult = apiUsageStateServiceImpl
        .createDefaultApiUsageState(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(dataValidator).validate(isA(ApiUsageState.class), isA(Function.class));
    verify(timeseriesService).save(isA(TenantId.class), isNull(), isA(List.class), eq(0L));
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualCreateDefaultApiUsageStateResult);
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}
   */
  @Test
  public void testCreateDefaultApiUsageState_thenReturnApiUsageState2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any())).thenReturn(apiUsageState);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any(),
        anyLong())).thenReturn(createResult);
    when(dataValidator.validate(Mockito.<ApiUsageState>any(), Mockito.<Function<ApiUsageState, TenantId>>any()))
        .thenReturn(new ApiUsageState());

    // Act
    ApiUsageState actualCreateDefaultApiUsageStateResult = apiUsageStateServiceImpl
        .createDefaultApiUsageState(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dataValidator).validate(isA(ApiUsageState.class), isA(Function.class));
    verify(timeseriesService).save(isA(TenantId.class), isNull(), isA(List.class), eq(0L));
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualCreateDefaultApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#update(ApiUsageState)}.
   * <ul>
   *   <li>Given {@link ApiUsageStateId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateServiceImpl#update(ApiUsageState)}
   */
  @Test
  public void testUpdate_givenApiUsageStateIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any())).thenReturn(apiUsageState);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ApiUsageState apiUsageState2 = mock(ApiUsageState.class);
    when(apiUsageState2.getId()).thenReturn(apiUsageStateId);
    when(apiUsageState2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageState actualUpdateResult = apiUsageStateServiceImpl.update(apiUsageState2);

    // Assert
    verify(apiUsageState2, atLeast(1)).getTenantId();
    verify(apiUsageState2).getId();
    verify(apiUsageStateId).getId();
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualUpdateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#update(ApiUsageState)}.
   * <ul>
   *   <li>Given {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateServiceImpl#update(ApiUsageState)}
   */
  @Test
  public void testUpdate_givenApiUsageStateIdWithIdIsNull_uuid_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any())).thenReturn(apiUsageState);
    ApiUsageState apiUsageState2 = mock(ApiUsageState.class);
    when(apiUsageState2.getId()).thenReturn(new ApiUsageStateId(ModelConstants.NULL_UUID));
    when(apiUsageState2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageState actualUpdateResult = apiUsageStateServiceImpl.update(apiUsageState2);

    // Assert
    verify(apiUsageState2, atLeast(1)).getTenantId();
    verify(apiUsageState2).getId();
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualUpdateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}
   */
  @Test
  public void testFindTenantApiUsageState_whenSystem_tenant_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findTenantApiUsageState(Mockito.<UUID>any())).thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult = apiUsageStateServiceImpl
        .findTenantApiUsageState(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).findTenantApiUsageState(isA(UUID.class));
    assertSame(apiUsageState, actualFindTenantApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testFindApiUsageStateByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(apiUsageState);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult = apiUsageStateServiceImpl
        .findApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getId();
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testFindApiUsageStateByEntityId_whenNull_customer_id_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult = apiUsageStateServiceImpl
        .findApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}
   */
  @Test
  public void testFindApiUsageStateById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(apiUsageState);
    ApiUsageStateId id = mock(ApiUsageStateId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult = apiUsageStateServiceImpl
        .findApiUsageStateById(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id, atLeast(1)).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test
   * {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}
   */
  @Test
  public void testFindApiUsageStateById_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult = apiUsageStateServiceImpl
        .findApiUsageStateById(ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID));

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(apiUsageState);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = apiUsageStateServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(apiUsageState, actualFindEntityResult.get());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(apiUsageState);

    // Act
    Optional<HasId<?>> actualFindEntityResult = apiUsageStateServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(apiUsageState, actualFindEntityResult.get());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link ApiUsageStateDao}
   * {@link ApiUsageStateDao#findApiUsageStateByEntityId(EntityId)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenApiUsageStateDaoFindApiUsageStateByEntityIdReturnNull() {
    // Arrange
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} Id is
   * {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenApiUsageStateIdIsApiUsageStateIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(apiUsageState);

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).removeById(isNull(), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link ApiUsageStateServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    // Act and Assert
    assertEquals(EntityType.API_USAGE_STATE, (new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService, tsService, new ApiUsageDataValidator())).getEntityType());
  }
}
