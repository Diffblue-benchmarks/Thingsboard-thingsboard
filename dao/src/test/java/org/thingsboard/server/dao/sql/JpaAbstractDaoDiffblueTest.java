package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmEntity;
import org.thingsboard.server.dao.sql.alarm.AlarmRepository;
import org.thingsboard.server.dao.sql.alarm.EntityAlarmRepository;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAbstractDaoDiffblueTest {
  @MockBean
  private AlarmQueryRepository alarmQueryRepository;

  @MockBean
  private AlarmRepository alarmRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityAlarmRepository entityAlarmRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAbstractDao<AlarmEntity, Alarm> jpaAbstractDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId},
   * {@code domain}.
   * <ul>
   *   <li>When {@link Alarm}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  public void testSaveWithTenantIdDomain_whenAlarm_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaAbstractDao.save(ModelConstants.SYSTEM_TENANT, mock(Alarm.class)));
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   * <ul>
   *   <li>When {@link Alarm}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  public void testSaveAndFlush_whenAlarm_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaAbstractDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, mock(Alarm.class)));
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#findById(Object)}
   * return empty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  public void testFindById_givenAlarmRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<AlarmEntity> emptyResult = Optional.empty();
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    Alarm actualFindByIdResult = jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  public void testFindById_thenOriginatorReturnTenantId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindByIdResult = jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindByIdResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    TenantId tenantId = actualFindByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  public void testFindById_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.findById(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException("Get entity by key {}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).findById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}
   */
  @Test
  public void testFindByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindByIdAsyncResult = jpaAbstractDao.findByIdAsync(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByIdAsyncResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#existsById(Object)}
   * return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByIdResult = jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertFalse(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#existsById(Object)}
   * return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult = jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  public void testExistsById_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException("Exists by key {}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).existsById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}
   */
  @Test
  public void testExistsByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualExistsByIdAsyncResult = jpaAbstractDao.existsByIdAsync(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualExistsByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExistsByIdAsyncResult);
  }

  /**
   * Test {@link JpaAbstractDao#removeById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link JpaRepository#flush()} does
   * nothing.</li>
   *   <li>Then calls {@link JpaRepository#flush()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#removeById(TenantId, UUID)}
   */
  @Test
  public void testRemoveById_givenAlarmRepositoryFlushDoesNothing_thenCallsFlush() {
    // Arrange
    doNothing().when(alarmRepository).flush();
    doNothing().when(alarmRepository).deleteById(Mockito.<UUID>any());

    // Act
    jpaAbstractDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(alarmRepository).flush();
    verify(alarmRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeById(TenantId, UUID)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#removeById(TenantId, UUID)}
   */
  @Test
  public void testRemoveById_thenThrowEntityVersionMismatchException() {
    // Arrange
    doThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable())).when(alarmRepository)
        .deleteById(Mockito.<UUID>any());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> jpaAbstractDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#deleteById(Object)}
   * does nothing.</li>
   *   <li>Then calls {@link CrudRepository#deleteById(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_givenAlarmRepositoryDeleteByIdDoesNothing_thenCallsDeleteById() {
    // Arrange
    doNothing().when(alarmRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(alarmRepository).flush();

    ArrayList<UUID> ids = new ArrayList<>();
    ids.add(ModelConstants.NULL_UUID);

    // Act
    jpaAbstractDao.removeAllByIds(ids);

    // Assert that nothing has changed
    verify(alarmRepository).flush();
    verify(alarmRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#deleteById(Object)}
   * does nothing.</li>
   *   <li>Then calls {@link CrudRepository#deleteById(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_givenAlarmRepositoryDeleteByIdDoesNothing_thenCallsDeleteById2() {
    // Arrange
    doNothing().when(alarmRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(alarmRepository).flush();

    ArrayList<UUID> ids = new ArrayList<>();
    ids.add(ModelConstants.NULL_UUID);
    ids.add(ModelConstants.NULL_UUID);

    // Act
    jpaAbstractDao.removeAllByIds(ids);

    // Assert that nothing has changed
    verify(alarmRepository).flush();
    verify(alarmRepository, atLeast(1)).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link JpaRepository#flush()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_whenArrayList_thenCallsFlush() {
    // Arrange
    doNothing().when(alarmRepository).flush();

    // Act
    jpaAbstractDao.removeAllByIds(new ArrayList<>());

    // Assert that nothing has changed
    verify(alarmRepository).flush();
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link ListCrudRepository#findAll()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  public void testFind_givenAlarmRepositoryFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(alarmRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Alarm> actualFindResult = jpaAbstractDao.find(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(alarmRepository).findAll();
    assertTrue(actualFindResult.isEmpty());
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   * <ul>
   *   <li>Then first Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  public void testFind_thenFirstOriginatorReturnTenantId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findAll()).thenReturn(alarmEntityList);

    // Act
    List<Alarm> actualFindResult = jpaAbstractDao.find(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(alarmRepository).findAll();
    assertEquals(1, actualFindResult.size());
    Alarm getResult = actualFindResult.get(0);
    EntityId originator = getResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  public void testFind_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jpaAbstractDao.find(ModelConstants.SYSTEM_TENANT));
    verify(alarmRepository).findAll();
  }

  /**
   * Test
   * {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  public void testFindIdsByTenantIdAndIdOffset_whenSystem_tenant_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult = jpaAbstractDao
        .findIdsByTenantIdAndIdOffset(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID, 1);

    // Assert
    verify(jdbcTemplate).queryForList(eq("SELECT id FROM alarm WHERE tenant_id = ?  AND id > ?  ORDER BY id LIMIT ?"),
        isA(Class.class), isA(Object[].class));
    assertTrue(actualFindIdsByTenantIdAndIdOffsetResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  public void testFindIdsByTenantIdAndIdOffset_whenSystem_tenant_thenReturnEmpty2() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<Object>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult = jpaAbstractDao
        .findIdsByTenantIdAndIdOffset(ModelConstants.SYSTEM_TENANT, null, 1);

    // Assert
    verify(jdbcTemplate).queryForList(eq("SELECT id FROM alarm WHERE tenant_id = ?  ORDER BY id LIMIT ?"),
        isA(Class.class), isA(Object[].class));
    assertTrue(actualFindIdsByTenantIdAndIdOffsetResult.isEmpty());
  }

  /**
   * Test {@link JpaAbstractDao#getTenantIdColumn()}.
   * <p>
   * Method under test: {@link JpaAbstractDao#getTenantIdColumn()}
   */
  @Test
  public void testGetTenantIdColumn() {
    // Arrange, Act and Assert
    assertEquals("tenant_id", jpaAbstractDao.getTenantIdColumn());
  }

  /**
   * Test {@link JpaAbstractDao#getEntityManager()}.
   * <p>
   * Method under test: {@link JpaAbstractDao#getEntityManager()}
   */
  @Test
  public void testGetEntityManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new JpaAlarmDao()).getEntityManager());
  }

  /**
   * Test {@link JpaAbstractDao#getJdbcTemplate()}.
   * <p>
   * Method under test: {@link JpaAbstractDao#getJdbcTemplate()}
   */
  @Test
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertSame(jpaAbstractDao.jdbcTemplate, jpaAbstractDao.getJdbcTemplate());
  }
}
