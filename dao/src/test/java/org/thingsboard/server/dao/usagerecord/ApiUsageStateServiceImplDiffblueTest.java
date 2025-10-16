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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;
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
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class ApiUsageStateServiceImplDiffblueTest {
  @MockBean private ApiUsageStateDao apiUsageStateDao;

  @Autowired private ApiUsageStateServiceImpl apiUsageStateServiceImpl;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<ApiUsageState> dataValidator;

  @MockBean private TenantProfileDao tenantProfileDao;

  @MockBean private TenantService tenantService;

  @MockBean private TimeseriesService timeseriesService;

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId() {
    // Arrange
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId2() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(apiUsageState);

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
   * Test {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());

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
   * Test {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link ApiUsageStateDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateDao} {@link ApiUsageStateDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenApiUsageStateDaoFindByIdReturnNull() {
    // Arrange
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ApiUsageStateId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new ApiUsageState());

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
   * Test {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>When {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ApiUsageStateDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_whenApiUsageStateIdWithIdIsNull_uuid_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.createDefaultApiUsageState(TenantId, EntityId)"
  })
  public void testCreateDefaultApiUsageState_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesService.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong()))
        .thenReturn(createResult);
    when(dataValidator.validate(
            Mockito.<ApiUsageState>any(), Mockito.<Function<ApiUsageState, TenantId>>any()))
        .thenReturn(new ApiUsageState());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualCreateDefaultApiUsageStateResult =
        apiUsageStateServiceImpl.createDefaultApiUsageState(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tenantId).getId();
    verify(dataValidator).validate(isA(ApiUsageState.class), isA(Function.class));
    verify(timeseriesService).save(isA(TenantId.class), isNull(), isA(List.class), eq(0L));
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualCreateDefaultApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.createDefaultApiUsageState(TenantId, EntityId)"
  })
  public void testCreateDefaultApiUsageState_givenNull_uuid_whenSystem_tenant_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesService.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong()))
        .thenReturn(createResult);
    when(dataValidator.validate(
            Mockito.<ApiUsageState>any(), Mockito.<Function<ApiUsageState, TenantId>>any()))
        .thenReturn(new ApiUsageState());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualCreateDefaultApiUsageStateResult =
        apiUsageStateServiceImpl.createDefaultApiUsageState(tenantId, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantId).getId();
    verify(dataValidator).validate(isA(ApiUsageState.class), isA(Function.class));
    verify(timeseriesService).save(isA(TenantId.class), isNull(), isA(List.class), eq(0L));
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualCreateDefaultApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#createDefaultApiUsageState(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.createDefaultApiUsageState(TenantId, EntityId)"
  })
  public void testCreateDefaultApiUsageState_whenSystem_tenant_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesService.save(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<TsKvEntry>>any(),
            anyLong()))
        .thenReturn(createResult);
    when(dataValidator.validate(
            Mockito.<ApiUsageState>any(), Mockito.<Function<ApiUsageState, TenantId>>any()))
        .thenReturn(new ApiUsageState());

    // Act
    ApiUsageState actualCreateDefaultApiUsageStateResult =
        apiUsageStateServiceImpl.createDefaultApiUsageState(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(dataValidator).validate(isA(ApiUsageState.class), isA(Function.class));
    verify(timeseriesService).save(isA(TenantId.class), isNull(), isA(List.class), eq(0L));
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualCreateDefaultApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#update(ApiUsageState)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateId} {@link ApiUsageStateId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ApiUsageStateId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#update(ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.update(ApiUsageState)"})
  public void testUpdate_givenApiUsageStateIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);

    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ApiUsageState apiUsageState2 = new ApiUsageState(new ApiUsageState());
    apiUsageState2.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState2.setId(apiUsageStateId);

    // Act
    ApiUsageState actualUpdateResult = apiUsageStateServiceImpl.update(apiUsageState2);

    // Assert
    verify(apiUsageStateId).getId();
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualUpdateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#update(ApiUsageState)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#update(ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.update(ApiUsageState)"})
  public void testUpdate_givenApiUsageStateIdWithIdIsNull_uuid() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);

    ApiUsageState apiUsageState2 = new ApiUsageState(new ApiUsageState());
    apiUsageState2.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState2.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));

    // Act
    ApiUsageState actualUpdateResult = apiUsageStateServiceImpl.update(apiUsageState2);

    // Assert
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualUpdateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#update(ApiUsageState)}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#update(ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.update(ApiUsageState)"})
  public void testUpdate_givenTenantIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.save(Mockito.<TenantId>any(), Mockito.<ApiUsageState>any()))
        .thenReturn(apiUsageState);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ApiUsageState apiUsageState2 = new ApiUsageState(new ApiUsageState());
    apiUsageState2.setTenantId(tenantId);
    apiUsageState2.setId(apiUsageStateId);

    // Act
    ApiUsageState actualUpdateResult = apiUsageStateServiceImpl.update(apiUsageState2);

    // Assert
    verify(apiUsageStateId).getId();
    verify(tenantId).getId();
    verify(apiUsageStateDao).save(isA(TenantId.class), isA(ApiUsageState.class));
    assertSame(apiUsageState, actualUpdateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.findTenantApiUsageState(TenantId)"})
  public void testFindTenantApiUsageState_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findTenantApiUsageState(Mockito.<UUID>any())).thenReturn(apiUsageState);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult =
        apiUsageStateServiceImpl.findTenantApiUsageState(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(apiUsageStateDao).findTenantApiUsageState(isA(UUID.class));
    assertSame(apiUsageState, actualFindTenantApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}.
   *
   * <ul>
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.findTenantApiUsageState(TenantId)"})
  public void testFindTenantApiUsageState_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findByTenantId(Mockito.<UUID>any()))
        .thenReturn(apiUsageStateEntity);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateServiceImpl =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult =
        apiUsageStateServiceImpl.findTenantApiUsageState(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateRepository).findByTenantId(isA(UUID.class));
    assertEquals(1L, actualFindTenantApiUsageStateResult.getCreatedTime());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getAlarmExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getDbStorageState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getSmsExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getTbelExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindTenantApiUsageStateResult.getTransportState());
    assertSame(TenantId.SYS_TENANT_ID, actualFindTenantApiUsageStateResult.getTenantId());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findTenantApiUsageState(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateServiceImpl.findTenantApiUsageState(TenantId)"})
  public void testFindTenantApiUsageState_whenSystem_tenant_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findTenantApiUsageState(Mockito.<UUID>any())).thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult =
        apiUsageStateServiceImpl.findTenantApiUsageState(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).findTenantApiUsageState(isA(UUID.class));
    assertSame(apiUsageState, actualFindTenantApiUsageStateResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateByEntityId(EntityId)"
  })
  public void testFindApiUsageStateByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(apiUsageState);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        apiUsageStateServiceImpl.findApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getId();
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateByEntityId(EntityId)"
  })
  public void testFindApiUsageStateByEntityId_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findByEntityIdAndEntityType(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateServiceImpl =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        apiUsageStateServiceImpl.findApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("CUSTOMER"));
    assertEquals(1L, actualFindApiUsageStateByEntityIdResult.getCreatedTime());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getAlarmExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getDbStorageState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getEmailExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getJsExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getReExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getSmsExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getTbelExecState());
    assertEquals(
        ApiUsageStateValue.ENABLED, actualFindApiUsageStateByEntityIdResult.getTransportState());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateByEntityId(EntityId)"
  })
  public void testFindApiUsageStateByEntityId_whenNull_customer_id_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        apiUsageStateServiceImpl.findApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link ApiUsageStateId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  public void testFindApiUsageStateById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);

    ApiUsageStateId id = mock(ApiUsageStateId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult =
        apiUsageStateServiceImpl.findApiUsageStateById(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id, atLeast(1)).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  public void testFindApiUsageStateById_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult =
        apiUsageStateServiceImpl.findApiUsageStateById(
            ModelConstants.SYSTEM_TENANT, new ApiUsageStateId(ModelConstants.NULL_UUID));

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState ApiUsageStateServiceImpl.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  public void testFindApiUsageStateById_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ApiUsageStateEntity> ofResult = Optional.of(apiUsageStateEntity);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateServiceImpl =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
    ApiUsageStateId id = new ApiUsageStateId(ModelConstants.NULL_UUID);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult =
        apiUsageStateServiceImpl.findApiUsageStateById(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(apiUsageStateRepository).findById(isA(UUID.class));
    assertEquals(1L, actualFindApiUsageStateByIdResult.getCreatedTime());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getTransportState());
    assertEquals(id, actualFindApiUsageStateByIdResult.getId());
    assertSame(TenantId.SYS_TENANT_ID, actualFindApiUsageStateByIdResult.getTenantId());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link EntityId} {@link EntityId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ApiUsageStateServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        apiUsageStateServiceImpl.findEntity(tenantId, entityId);

    // Assert
    verify(entityId).getId();
    verify(tenantId).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof ApiUsageState);
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(apiUsageState, getResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ApiUsageStateServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        apiUsageStateServiceImpl.findEntity(tenantId, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tenantId).getId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof ApiUsageState);
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(apiUsageState, getResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ApiUsageStateServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnGetCreatedTimeIsOne() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<ApiUsageStateEntity> ofResult = Optional.of(apiUsageStateEntity);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateServiceImpl =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        apiUsageStateServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateRepository).findById(isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof ApiUsageState);
    assertEquals(1L, ((ApiUsageState) getResult).getCreatedTime());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, ((ApiUsageState) getResult).getTransportState());
    assertSame(TenantId.SYS_TENANT_ID, ((ApiUsageState) getResult).getTenantId());
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ApiUsageStateServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenSystem_tenant_thenReturnPresent() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        apiUsageStateServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof ApiUsageState);
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(apiUsageState, getResult);
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateDao} {@link
   *       ApiUsageStateDao#findApiUsageStateByEntityId(EntityId)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenApiUsageStateDaoFindApiUsageStateByEntityIdReturnNull() {
    // Arrange
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(null);

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} Id is {@link
   *       ApiUsageStateId#ApiUsageStateId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenApiUsageStateIdIsApiUsageStateIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(apiUsageState);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(apiUsageStateDao).removeById(isNull(), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link ApiUsageStateDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(apiUsageStateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(apiUsageStateDao.findApiUsageStateByEntityId(Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());

    // Act
    apiUsageStateServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateDao).removeById(isNull(), isNull());
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(apiUsageStateDao).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link ApiUsageStateServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link ApiUsageStateServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType ApiUsageStateServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateServiceImpl =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());

    // Act and Assert
    assertEquals(EntityType.API_USAGE_STATE, apiUsageStateServiceImpl.getEntityType());
  }
}
