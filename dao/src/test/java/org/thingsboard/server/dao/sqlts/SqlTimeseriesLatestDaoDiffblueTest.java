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
package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.dictionary.KeyDictionaryDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestCompositeKey;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueWrapper;
import org.thingsboard.server.dao.sqlts.latest.TsKvLatestRepository;

@RunWith(MockitoJUnitRunner.class)
public class SqlTimeseriesLatestDaoDiffblueTest {
  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private KeyDictionaryDao keyDictionaryDao;

  @InjectMocks private SqlTimeseriesLatestDao sqlTimeseriesLatestDao;

  @Mock private TbSqlBlockingQueueWrapper<TsKvLatestEntity, Long> tbSqlBlockingQueueWrapper;

  @Mock private TsKvLatestRepository tsKvLatestRepository;

  /**
   * Test {@link SqlTimeseriesLatestDao#destroy()}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueWrapper} {@link TbSqlBlockingQueueWrapper#destroy()} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlTimeseriesLatestDao.destroy()"})
  public void testDestroy_givenTbSqlBlockingQueueWrapperDestroyDoesNothing() {
    // Arrange
    doNothing().when(tbSqlBlockingQueueWrapper).destroy();

    // Act
    sqlTimeseriesLatestDao.destroy();

    // Assert
    verify(tbSqlBlockingQueueWrapper).destroy();
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#destroy()}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlTimeseriesLatestDao.destroy()"})
  public void testDestroy_thenThrowEmptyResultDataAccessException() {
    // Arrange
    doThrow(new EmptyResultDataAccessException(3)).when(tbSqlBlockingQueueWrapper).destroy();

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> sqlTimeseriesLatestDao.destroy());
    verify(tbSqlBlockingQueueWrapper).destroy();
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.saveLatest(TenantId, EntityId, TsKvEntry)"
  })
  public void testSaveLatest() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.saveLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.saveLatest(TenantId, EntityId, TsKvEntry)"
  })
  public void testSaveLatest2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.saveLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link EntityId} {@link EntityId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.saveLatest(TenantId, EntityId, TsKvEntry)"
  })
  public void testSaveLatest_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any())).thenReturn(createResult);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    ListenableFuture<Long> actualSaveLatestResult =
        sqlTimeseriesLatestDao.saveLatest(ModelConstants.SYSTEM_TENANT, entityId, tsKvEntry);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
    assertTrue(actualSaveLatestResult instanceof SettableFuture);
    assertSame(createResult, actualSaveLatestResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.saveLatest(TenantId, EntityId, TsKvEntry)"
  })
  public void testSaveLatest_thenReturnSettableFuture() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any())).thenReturn(createResult);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    ListenableFuture<Long> actualSaveLatestResult =
        sqlTimeseriesLatestDao.saveLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry);

    // Assert
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
    assertTrue(actualSaveLatestResult instanceof SettableFuture);
    assertSame(createResult, actualSaveLatestResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then calls {@link JpaExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.removeLatest(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemoveLatest_givenJpaExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    sqlTimeseriesLatestDao.removeLatest(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.removeLatest(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemoveLatest_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act
    sqlTimeseriesLatestDao.removeLatest(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.removeLatest(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemoveLatest_thenThrowEmptyResultDataAccessException() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new EmptyResultDataAccessException(3))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.removeLatest(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseDeleteTsKvQuery("Key", 1L, 1L)));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findLatestOpt(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findLatestOpt(TenantId, EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.findLatestOpt(TenantId, EntityId, String)"
  })
  public void testFindLatestOpt_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Optional<TsKvEntry>> actualFindLatestOptResult =
        sqlTimeseriesLatestDao.findLatestOpt(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindLatestOptResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestOptResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findLatest(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findLatest(TenantId, EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.findLatest(TenantId, EntityId, String)"
  })
  public void testFindLatest_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<TsKvEntry> actualFindLatestResult =
        sqlTimeseriesLatestDao.findLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllLatest(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture SqlTimeseriesLatestDao.findAllLatest(TenantId, EntityId)"})
  public void testFindAllLatest_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindAllLatestResult =
        sqlTimeseriesLatestDao.findAllLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAllLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllLatestResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId() {
    // Arrange
    when(tsKvLatestRepository.getKeysByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(tsKvLatestRepository).getKeysByTenantId(isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId2() {
    // Arrange
    when(tsKvLatestRepository.getKeysByTenantId(Mockito.<UUID>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, null));
    verify(tsKvLatestRepository).getKeysByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId3() {
    // Arrange
    when(tsKvLatestRepository.getKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tsKvLatestRepository).getKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId4() {
    // Arrange
    when(tsKvLatestRepository.getKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID)));
    verify(tsKvLatestRepository).getKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link SqlTimeseriesLatestDao} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_givenSqlTimeseriesLatestDao() {
    // Arrange
    SqlTimeseriesLatestDao sqlTimeseriesLatestDao = new SqlTimeseriesLatestDao();

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenCallsGetId() {
    // Arrange
    when(tsKvLatestRepository.getKeysByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(tenantId, null);

    // Assert
    verify(tenantId).getId();
    verify(tsKvLatestRepository).getKeysByTenantId(isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfileId} {@link DeviceProfileId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_whenDeviceProfileIdGetIdReturnNull_uuid() {
    // Arrange
    when(tsKvLatestRepository.getKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, deviceProfileId);

    // Assert
    verify(deviceProfileId).getId();
    verify(tsKvLatestRepository).getKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfileId#DeviceProfileId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_whenDeviceProfileIdWithIdIsRandomUUID() {
    // Arrange
    when(tsKvLatestRepository.getKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        sqlTimeseriesLatestDao.findAllKeysByDeviceProfileId(
            tenantId, new DeviceProfileId(UUID.randomUUID()));

    // Assert
    verify(tenantId).getId();
    verify(tsKvLatestRepository).getKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    // Arrange
    when(tsKvLatestRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        sqlTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(tsKvLatestRepository).findAllKeysByEntityIds(isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    // Arrange
    when(tsKvLatestRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        sqlTimeseriesLatestDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(tsKvLatestRepository).findAllKeysByEntityIds(isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(tsKvLatestRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.findAllKeysByEntityIds(
                ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(tsKvLatestRepository).findAllKeysByEntityIds(isA(List.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlTimeseriesLatestDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(tsKvLatestRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        sqlTimeseriesLatestDao.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(tsKvLatestRepository).findAllKeysByEntityIds(isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.doFindLatestSync(EntityId, String)"})
  public void testDoFindLatestSync() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> sqlTimeseriesLatestDao.doFindLatestSync(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.doFindLatestSync(EntityId, String)"})
  public void testDoFindLatestSync2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvLatestRepository.findById(Mockito.<TsKvLatestCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> sqlTimeseriesLatestDao.doFindLatestSync(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
    verify(tsKvLatestRepository).findById(isA(TsKvLatestCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.doFindLatestSync(EntityId, String)"})
  public void testDoFindLatestSync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvLatestRepository.findById(Mockito.<TsKvLatestCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> sqlTimeseriesLatestDao.doFindLatestSync(entityId, "Key"));
    verify(tsKvLatestRepository).findById(isA(TsKvLatestCompositeKey.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link TsKvLatestRepository} {@link TsKvLatestRepository#findById(Object)} return
   *       empty.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.doFindLatestSync(EntityId, String)"})
  public void testDoFindLatestSync_givenTsKvLatestRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    Optional<TsKvLatestEntity> emptyResult = Optional.empty();
    when(tsKvLatestRepository.findById(Mockito.<TsKvLatestCompositeKey>any()))
        .thenReturn(emptyResult);

    // Act
    TsKvEntry actualDoFindLatestSyncResult =
        sqlTimeseriesLatestDao.doFindLatestSync(BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(tsKvLatestRepository).findById(isA(TsKvLatestCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    assertNull(actualDoFindLatestSyncResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}.
   *
   * <ul>
   *   <li>Then return {@link AggTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#doFindLatestSync(EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.doFindLatestSync(EntityId, String)"})
  public void testDoFindLatestSync_thenReturnAggTsKvEntry() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);
    Optional<TsKvLatestEntity> ofResult = Optional.of(tsKvLatestEntity);
    when(tsKvLatestRepository.findById(Mockito.<TsKvLatestCompositeKey>any())).thenReturn(ofResult);

    // Act
    TsKvEntry actualDoFindLatestSyncResult =
        sqlTimeseriesLatestDao.doFindLatestSync(BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(tsKvLatestRepository).findById(isA(TsKvLatestCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    assertTrue(actualDoFindLatestSyncResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) actualDoFindLatestSyncResult).getKv() instanceof StringDataEntry);
    assertEquals("42", actualDoFindLatestSyncResult.getValueAsString());
    assertEquals("42", actualDoFindLatestSyncResult.getValue());
    assertEquals("Key", actualDoFindLatestSyncResult.getKey());
    assertNull(actualDoFindLatestSyncResult.getVersion());
    assertEquals(1, actualDoFindLatestSyncResult.getDataPoints());
    assertEquals(1L, actualDoFindLatestSyncResult.getTs());
    assertEquals(DataType.STRING, actualDoFindLatestSyncResult.getDataType());
    Optional<Boolean> booleanValue = actualDoFindLatestSyncResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, actualDoFindLatestSyncResult.getDoubleValue());
    assertSame(booleanValue, actualDoFindLatestSyncResult.getJsonValue());
    assertSame(booleanValue, actualDoFindLatestSyncResult.getLongValue());
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testGetRemoveLatestFuture_givenJpaExecutorServiceSubmitReturnCreate() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    sqlTimeseriesLatestDao.getRemoveLatestFuture(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testGetRemoveLatestFuture_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act
    sqlTimeseriesLatestDao.getRemoveLatestFuture(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getRemoveLatestFuture(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getRemoveLatestFuture(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testGetRemoveLatestFuture_thenThrowEmptyResultDataAccessException() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new EmptyResultDataAccessException(3))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.getRemoveLatestFuture(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseDeleteTsKvQuery("Key", 1L, 1L)));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getFindAllLatestFuture(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getFindAllLatestFuture(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture SqlTimeseriesLatestDao.getFindAllLatestFuture(EntityId)"})
  public void testGetFindAllLatestFuture_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindAllLatestFuture =
        sqlTimeseriesLatestDao.getFindAllLatestFuture(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAllLatestFuture instanceof SettableFuture);
    assertSame(createResult, actualFindAllLatestFuture);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getSaveLatestFuture(EntityId, TsKvEntry)"
  })
  public void testGetSaveLatestFuture() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.getSaveLatestFuture(
                BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}.
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getSaveLatestFuture(EntityId, TsKvEntry)"
  })
  public void testGetSaveLatestFuture2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            sqlTimeseriesLatestDao.getSaveLatestFuture(
                BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getSaveLatestFuture(EntityId, TsKvEntry)"
  })
  public void testGetSaveLatestFuture_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any())).thenReturn(createResult);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    ListenableFuture<Long> actualSaveLatestFuture =
        sqlTimeseriesLatestDao.getSaveLatestFuture(entityId, tsKvEntry);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
    assertTrue(actualSaveLatestFuture instanceof SettableFuture);
    assertSame(createResult, actualSaveLatestFuture);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#getSaveLatestFuture(EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture SqlTimeseriesLatestDao.getSaveLatestFuture(EntityId, TsKvEntry)"
  })
  public void testGetSaveLatestFuture_thenReturnSettableFuture() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(tbSqlBlockingQueueWrapper.add(Mockito.<TsKvLatestEntity>any())).thenReturn(createResult);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    ListenableFuture<Long> actualSaveLatestFuture =
        sqlTimeseriesLatestDao.getSaveLatestFuture(BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry);

    // Assert
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tbSqlBlockingQueueWrapper).add(isA(TsKvLatestEntity.class));
    assertTrue(actualSaveLatestFuture instanceof SettableFuture);
    assertSame(createResult, actualSaveLatestFuture);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}.
   *
   * <ul>
   *   <li>Then return {@link BasicTsKvEntry#BasicTsKvEntry(long, KvEntry)} with ts is one and kv is
   *       {@link JsonDataEntry#JsonDataEntry(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.wrapNullTsKvEntry(String, TsKvEntry)"})
  public void testWrapNullTsKvEntry_thenReturnBasicTsKvEntryWithTsIsOneAndKvIsJsonDataEntry() {
    // Arrange
    SqlTimeseriesLatestDao sqlTimeseriesLatestDao = new SqlTimeseriesLatestDao();
    BasicTsKvEntry latest = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    TsKvEntry actualWrapNullTsKvEntryResult =
        sqlTimeseriesLatestDao.wrapNullTsKvEntry("Key", latest);

    // Assert
    assertSame(latest, actualWrapNullTsKvEntryResult);
  }

  /**
   * Test {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link BasicTsKvEntry}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTimeseriesLatestDao#wrapNullTsKvEntry(String, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TsKvEntry SqlTimeseriesLatestDao.wrapNullTsKvEntry(String, TsKvEntry)"})
  public void testWrapNullTsKvEntry_whenNull_thenReturnBasicTsKvEntry() {
    // Arrange and Act
    TsKvEntry actualWrapNullTsKvEntryResult =
        new SqlTimeseriesLatestDao().wrapNullTsKvEntry("Key", null);

    // Assert
    assertTrue(actualWrapNullTsKvEntryResult instanceof BasicTsKvEntry);
    assertTrue(((BasicTsKvEntry) actualWrapNullTsKvEntryResult).getKv() instanceof StringDataEntry);
    assertNull(actualWrapNullTsKvEntryResult.getValue());
    assertNull(actualWrapNullTsKvEntryResult.getValueAsString());
    assertEquals(DataType.STRING, actualWrapNullTsKvEntryResult.getDataType());
  }
}
