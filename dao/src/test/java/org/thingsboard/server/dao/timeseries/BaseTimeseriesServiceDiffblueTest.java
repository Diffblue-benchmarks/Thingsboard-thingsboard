package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvLatestRemovingResult;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseTimeseriesService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class BaseTimeseriesServiceDiffblueTest {
  @Autowired
  private BaseTimeseriesService baseTimeseriesService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private TimeseriesDao timeseriesDao;

  @MockBean
  private TimeseriesLatestDao timeseriesLatestDao;

  /**
   * Test
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)}
   * with {@code Key} and startTs is one and endTs is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllByQueries_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult = baseTimeseriesService
        .findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)}
   * with {@code Key} and startTs is one and endTs is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllByQueries_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne2() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult = baseTimeseriesService
        .findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllByQueries_thenThrowIncorrectParameterException() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>()));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAllByQueries_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult = baseTimeseriesService
        .findAllByQueries(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAll_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAll_givenNull_uuid_thenCallsGetEntityType2() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then calls
   * {@link TimeseriesDao#findAllAsync(TenantId, EntityId, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  public void testFindAll_whenNull_customer_id_thenCallsFindAllAsync() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<List<ReadTsKvQuery>>any())).thenReturn(createResult);

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)}
   * with {@code tenantId}, {@code entityId}, {@code key}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestWithTenantIdEntityIdKey_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Optional<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findLatestOpt(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Optional<TsKvEntry>> actualFindLatestResult = baseTimeseriesService
        .findLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(timeseriesLatestDao).findLatestOpt(isA(TenantId.class), isA(EntityId.class), eq("Key"));
    assertTrue(actualFindLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code keys}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#findLatest(TenantId, EntityId, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testFindLatestWithTenantIdEntityIdKeys_thenCallsFindLatest() {
    // Arrange
    SettableFuture<TsKvEntry> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    baseTimeseriesService.findLatest(ModelConstants.SYSTEM_TENANT, entityId, keys);

    // Assert
    verify(entityId).getId();
    verify(timeseriesLatestDao).findLatest(isA(TenantId.class), isA(EntityId.class), eq("foo"));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code keys}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testFindLatestWithTenantIdEntityIdKeys_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindLatestResult = baseTimeseriesService
        .findLatest(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>());

    // Assert
    verify(entityId).getId();
    assertTrue(actualFindLatestResult.get().isEmpty());
    assertTrue(actualFindLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code keys}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testFindLatestWithTenantIdEntityIdKeys_whenNull_customer_id_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvEntry>> actualFindLatestResult = baseTimeseriesService
        .findLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualFindLatestResult.get().isEmpty());
    assertTrue(actualFindLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}
   */
  @Test
  public void testFindAllLatest_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindAllLatestResult = baseTimeseriesService
        .findAllLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
    assertTrue(actualFindAllLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllLatestResult);
  }

  /**
   * Test
   * {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = baseTimeseriesService
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByDeviceProfileId(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null));
    verify(timeseriesLatestDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseTimeseriesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseTimeseriesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = baseTimeseriesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#cleanup(long)}.
   * <ul>
   *   <li>Given {@link TimeseriesDao} {@link TimeseriesDao#cleanup(long)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTimeseriesService#cleanup(long)}
   */
  @Test
  public void testCleanup_givenTimeseriesDaoCleanupDoesNothing() {
    // Arrange
    doNothing().when(timeseriesDao).cleanup(anyLong());

    // Act
    baseTimeseriesService.cleanup(1L);

    // Assert that nothing has changed
    verify(timeseriesDao).cleanup(eq(1L));
  }

  /**
   * Test {@link BaseTimeseriesService#cleanup(long)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTimeseriesService#cleanup(long)}
   */
  @Test
  public void testCleanup_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred")).when(timeseriesDao).cleanup(anyLong());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.cleanup(1L));
    verify(timeseriesDao).cleanup(eq(1L));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_thenCallsSave() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    SettableFuture<Long> createResult3 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult3);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L);

    // Assert
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   * <ul>
   *   <li>Then return {@link Future#get()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSaveResult = baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>(), 1L);

    // Assert
    assertEquals(0, actualSaveResult.get().intValue());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_thenThrowIncorrectParameterException() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L));
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   * <ul>
   *   <li>When {@link EntityId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_whenEntityId()
      throws InterruptedException, ExecutionException {
    // Arrange
    EntityId entityId = mock(EntityId.class);

    // Act
    ListenableFuture<Integer> actualSaveResult = baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT, entityId,
        new ArrayList<>(), 1L);

    // Assert
    assertEquals(0, actualSaveResult.get().intValue());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntry}.
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntry() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))));
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(0L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntry}.
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntry2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        entityId, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntry}.
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntry_givenEntityView() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        entityId, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntry}.
   * <ul>
   *   <li>Given {@link TimeseriesDao}
   * {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)} return
   * create.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntry_givenTimeseriesDaoSaveReturnCreate() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    SettableFuture<Long> createResult3 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult3);

    // Act
    baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Assert
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(0L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with
   * {@code tenantId}, {@code entityId}, {@code tsKvEntry}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdTsKvEntry_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Integer> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(listenableFutureTask);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult);
    SettableFuture<Long> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult2);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"))));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(0L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   * <ul>
   *   <li>Given {@link TimeseriesDao}
   * {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)} return
   * create.</li>
   *   <li>Then calls
   * {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithoutLatest_givenTimeseriesDaoSaveReturnCreate_thenCallsSave() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(
        timeseriesDao.savePartition(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new BasicTsKvEntry(2L, new JsonDataEntry("Key", "42")));

    // Act
    baseTimeseriesService.saveWithoutLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        tsKvEntries, 1L);

    // Assert
    verify(timeseriesDao).save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao).savePartition(isA(TenantId.class), isA(EntityId.class), eq(2L), eq("Key"));
  }

  /**
   * Test
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   * <ul>
   *   <li>Given {@link TimeseriesDao}.</li>
   *   <li>Then return {@link Future#get()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithoutLatest_givenTimeseriesDao_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSaveWithoutLatestResult = baseTimeseriesService
        .saveWithoutLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>(), 1L);

    // Assert
    assertEquals(0, actualSaveWithoutLatestResult.get().intValue());
    assertTrue(actualSaveWithoutLatestResult.isDone());
  }

  /**
   * Test
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   * <ul>
   *   <li>When {@link EntityId}.</li>
   *   <li>Then return {@link Future#get()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}
   */
  @Test
  public void testSaveWithoutLatest_whenEntityId_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange
    EntityId entityId = mock(EntityId.class);

    // Act
    ListenableFuture<Integer> actualSaveWithoutLatestResult = baseTimeseriesService
        .saveWithoutLatest(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>(), 1L);

    // Assert
    assertEquals(0, actualSaveWithoutLatestResult.get().intValue());
    assertTrue(actualSaveWithoutLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao}.</li>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  public void testSaveLatest_givenTimeseriesLatestDao_whenAlarmId_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);

    // Act
    ListenableFuture<List<Long>> actualSaveLatestResult = baseTimeseriesService.saveLatest(ModelConstants.SYSTEM_TENANT,
        entityId, new ArrayList<>());

    // Assert
    assertTrue(actualSaveLatestResult.get().isEmpty());
    assertTrue(actualSaveLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  public void testSaveLatest_givenTimeseriesLatestDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<Long>> actualSaveLatestResult = baseTimeseriesService.saveLatest(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualSaveLatestResult.get().isEmpty());
    assertTrue(actualSaveLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  public void testSaveLatest_thenCallsSaveLatest() {
    // Arrange
    SettableFuture<Long> createResult = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    baseTimeseriesService.saveLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries);

    // Assert
    verify(timeseriesLatestDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    when(timeseriesLatestDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<DeleteTsKvQuery>any())).thenThrow(new IncorrectParameterException("An error occurred"));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
    verify(timeseriesDao).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("", 3L, 3L));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove3() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery}
   * {@link BaseDeleteTsKvQuery#getDeleteLatest()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenBaseDeleteTsKvQueryGetDeleteLatestReturnFalse() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest()).thenReturn(false);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act
    baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries);

    // Assert
    verify(entityId).getId();
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery}
   * {@link BaseDeleteTsKvQuery#getDeleteLatest()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenBaseDeleteTsKvQueryGetDeleteLatestReturnTrue() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    SettableFuture<TsKvLatestRemovingResult> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<DeleteTsKvQuery>any())).thenReturn(createResult2);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest()).thenReturn(true);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act
    baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries);

    // Assert
    verify(entityId).getId();
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long)}
   * with key is {@code null} and startTs is three and endTs is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenBaseDeleteTsKvQueryWithKeyIsNullAndStartTsIsThreeAndEndTsIsThree() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery(null, 3L, 3L));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenNull_whenArrayListAddNull_thenThrowIncorrectParameterException() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link TimeseriesDao}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenTimeseriesDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveResult = baseTimeseriesService
        .remove(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>());

    // Assert
    verify(entityId).getId();
    assertTrue(actualRemoveResult.get().isEmpty());
    assertTrue(actualRemoveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Given {@link TimeseriesDao}.</li>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_givenTimeseriesDao_whenNull_customer_id_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveResult = baseTimeseriesService
        .remove(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualRemoveResult.get().isEmpty());
    assertTrue(actualRemoveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_thenCallsRemoveLatest() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    SettableFuture<TsKvLatestRemovingResult> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<DeleteTsKvQuery>any())).thenReturn(createResult2);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));

    // Act
    baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries);

    // Assert
    verify(entityId).getId();
    verify(timeseriesDao).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  public void testRemove_thenCallsRemoveLatest2() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    SettableFuture<TsKvLatestRemovingResult> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<DeleteTsKvQuery>any())).thenReturn(createResult2);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));

    // Act
    baseTimeseriesService.remove(ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries);

    // Assert
    verify(entityId).getId();
    verify(timeseriesDao, atLeast(1)).remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao, atLeast(1)).removeLatest(isA(TenantId.class), isA(EntityId.class),
        isA(DeleteTsKvQuery.class));
  }

  /**
   * Test
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testRemoveLatest_givenTimeseriesLatestDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveLatestResult = baseTimeseriesService
        .removeLatest(ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>());

    // Assert
    verify(entityId).getId();
    assertTrue(actualRemoveLatestResult.get().isEmpty());
    assertTrue(actualRemoveLatestResult.isDone());
  }

  /**
   * Test
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testRemoveLatest_thenCallsRemoveLatest() {
    // Arrange
    SettableFuture<TsKvLatestRemovingResult> createResult = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<DeleteTsKvQuery>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    baseTimeseriesService.removeLatest(ModelConstants.SYSTEM_TENANT, entityId, keys);

    // Assert
    verify(entityId).getId();
    verify(timeseriesLatestDao).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}
   */
  @Test
  public void testRemoveLatest_whenNull_customer_id_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveLatestResult = baseTimeseriesService
        .removeLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualRemoveLatestResult.get().isEmpty());
    assertTrue(actualRemoveLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link TimeseriesLatestDao#findAllLatest(TenantId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllLatest_thenCallsFindAllLatest() {
    // Arrange
    SettableFuture<List<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(createResult);

    // Act
    baseTimeseriesService.removeAllLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllLatest_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> baseTimeseriesService.removeAllLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
  }
}
