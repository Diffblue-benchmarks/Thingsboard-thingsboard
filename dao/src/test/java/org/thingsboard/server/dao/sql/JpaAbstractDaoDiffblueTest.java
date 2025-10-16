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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmEntity;
import org.thingsboard.server.dao.sql.alarm.AlarmRepository;
import org.thingsboard.server.dao.sql.alarm.EntityAlarmRepository;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAbstractDaoDiffblueTest {
  @MockBean private AlarmQueryRepository alarmQueryRepository;

  @MockBean private AlarmRepository alarmRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityAlarmRepository entityAlarmRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAbstractDao<AlarmEntity, Alarm> jpaAbstractDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Given {@link JpaAlarmDao} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_givenJpaAlarmDao_thenCallsGetId() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenThrow(new IllegalArgumentException());

    Alarm alarm = new Alarm();
    alarm.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setOriginator(originator);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm));
    verify(originator).getId();
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>When {@link AlarmData}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_whenAlarmData_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.save(new TenantId(ModelConstants.NULL_UUID), mock(AlarmData.class)));
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId}.
   *   <li>Then calls {@link AlarmData#setOriginator(EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_givenAlarmId_thenCallsSetOriginator() {
    // Arrange
    AlarmData alarmData = mock(AlarmData.class);
    doNothing().when(alarmData).setOriginator(Mockito.<EntityId>any());
    alarmData.setOriginator(mock(AlarmId.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarmData));
    verify(alarmData).setOriginator(isA(EntityId.class));
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Given {@link JpaAlarmDao} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_givenJpaAlarmDao_thenCallsGetId() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenThrow(new IllegalArgumentException());

    Alarm alarm = new Alarm();
    alarm.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setOriginator(originator);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm));
    verify(originator).getId();
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#findById(Object)} return empty.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.findById(TenantId, UUID)"})
  public void testFindById_givenAlarmRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<AlarmEntity> emptyResult = Optional.empty();
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    Alarm actualFindByIdResult =
        jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.findById(TenantId, UUID)"})
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
    Alarm actualFindByIdResult =
        jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
   *
   * <ul>
   *   <li>Then return TenantId is Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.findById(TenantId, UUID)"})
  public void testFindById_thenReturnTenantIdIsOriginator() {
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
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
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
    Alarm actualFindByIdResult =
        jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindByIdResult.getOriginator();
    assertSame(originator, actualFindByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAbstractDao#findById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.findById(TenantId, UUID)"})
  public void testFindById_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.findById(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).findById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAbstractDao.findByIdAsync(TenantId, UUID)"})
  public void testFindByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindByIdAsyncResult =
        jpaAbstractDao.findByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByIdAsyncResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#existsById(Object)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByIdResult =
        jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertFalse(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#existsById(Object)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult =
        jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).existsById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAbstractDao.existsByIdAsync(TenantId, UUID)"})
  public void testExistsByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualExistsByIdAsyncResult =
        jpaAbstractDao.existsByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualExistsByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExistsByIdAsyncResult);
  }

  /**
   * Test {@link JpaAbstractDao#removeById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#flush()} does nothing.
   *   <li>Then calls {@link AlarmRepository#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeById(TenantId, UUID)"})
  public void testRemoveById_givenAlarmRepositoryFlushDoesNothing_thenCallsFlush() {
    // Arrange
    doNothing().when(alarmRepository).flush();
    doNothing().when(alarmRepository).deleteById(Mockito.<UUID>any());

    // Act
    jpaAbstractDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).flush();
    verify(alarmRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeById(TenantId, UUID)"})
  public void testRemoveById_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(alarmRepository).deleteById(Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID));
    verify(alarmRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#deleteById(Object)} does nothing.
   *   <li>Then calls {@link AlarmRepository#deleteById(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_givenAlarmRepositoryDeleteByIdDoesNothing_thenCallsDeleteById() {
    // Arrange
    doNothing().when(alarmRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(alarmRepository).flush();

    ArrayList<UUID> ids = new ArrayList<>();
    ids.add(ModelConstants.NULL_UUID);
    ids.add(ModelConstants.NULL_UUID);

    // Act
    jpaAbstractDao.removeAllByIds(ids);

    // Assert
    verify(alarmRepository).flush();
    verify(alarmRepository, atLeast(1)).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(alarmRepository).flush();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jpaAbstractDao.removeAllByIds(new ArrayList<>()));
    verify(alarmRepository).flush();
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link AlarmRepository#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_whenArrayList_thenCallsFlush() {
    // Arrange
    doNothing().when(alarmRepository).flush();

    // Act
    jpaAbstractDao.removeAllByIds(new ArrayList<>());

    // Assert
    verify(alarmRepository).flush();
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.find(TenantId)"})
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
   *
   * <ul>
   *   <li>Then first Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.find(TenantId)"})
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
   *
   * <ul>
   *   <li>Then return first TenantId is first Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.find(TenantId)"})
  public void testFind_thenReturnFirstTenantIdIsFirstOriginator() {
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
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
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
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.find(TenantId)"})
  public void testFind_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.findAll()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jpaAbstractDao.find(ModelConstants.SYSTEM_TENANT));
    verify(alarmRepository).findAll();
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaAbstractDao.findIdsByTenantIdAndIdOffset(
                ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID, 1));
    verify(jdbcTemplate)
        .queryForList(
            eq("SELECT id FROM alarm WHERE tenant_id = ?  AND id > ?  ORDER BY id LIMIT ?"),
            isA(Class.class),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset_givenJdbcTemplate() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAbstractDao.findIdsByTenantIdAndIdOffset(tenantId, null, 1));
    verify(tenantId).getId();
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult =
        jpaAbstractDao.findIdsByTenantIdAndIdOffset(tenantId, ModelConstants.NULL_UUID, 1);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq("SELECT id FROM alarm WHERE tenant_id = ?  AND id > ?  ORDER BY id LIMIT ?"),
            isA(Class.class),
            isA(Object[].class));
    verify(tenantId).getId();
    assertTrue(actualFindIdsByTenantIdAndIdOffsetResult.isEmpty());
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult =
        jpaAbstractDao.findIdsByTenantIdAndIdOffset(tenantId, null, 1);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq("SELECT id FROM alarm WHERE tenant_id = ?  ORDER BY id LIMIT ?"),
            isA(Class.class),
            isA(Object[].class));
    verify(tenantId).getId();
    assertTrue(actualFindIdsByTenantIdAndIdOffsetResult.isEmpty());
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset_whenSystem_tenant_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult =
        jpaAbstractDao.findIdsByTenantIdAndIdOffset(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID, 1);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq("SELECT id FROM alarm WHERE tenant_id = ?  AND id > ?  ORDER BY id LIMIT ?"),
            isA(Class.class),
            isA(Object[].class));
    assertTrue(actualFindIdsByTenantIdAndIdOffsetResult.isEmpty());
  }

  /**
   * Test {@link JpaAbstractDao#getTenantIdColumn()}.
   *
   * <p>Method under test: {@link JpaAbstractDao#getTenantIdColumn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JpaAbstractDao.getTenantIdColumn()"})
  public void testGetTenantIdColumn() {
    // Arrange, Act and Assert
    assertEquals("tenant_id", jpaAbstractDao.getTenantIdColumn());
  }

  /**
   * Test {@link JpaAbstractDao#getEntityManager()}.
   *
   * <p>Method under test: {@link JpaAbstractDao#getEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"jakarta.persistence.EntityManager JpaAbstractDao.getEntityManager()"})
  public void testGetEntityManager() {
    // Arrange, Act and Assert
    assertNull(new JpaAlarmDao().getEntityManager());
  }

  /**
   * Test {@link JpaAbstractDao#getJdbcTemplate()}.
   *
   * <p>Method under test: {@link JpaAbstractDao#getJdbcTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcTemplate JpaAbstractDao.getJdbcTemplate()"})
  public void testGetJdbcTemplate() {
    // Arrange and Act
    JdbcTemplate actualJdbcTemplate = jpaAbstractDao.getJdbcTemplate();

    // Assert
    assertSame(jpaAbstractDao.jdbcTemplate, actualJdbcTemplate);
  }
}
