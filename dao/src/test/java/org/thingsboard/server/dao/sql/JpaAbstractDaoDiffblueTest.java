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
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.BaseEntity;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmEntity;
import org.thingsboard.server.dao.sql.alarm.AlarmRepository;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;

@RunWith(MockitoJUnitRunner.class)
public class JpaAbstractDaoDiffblueTest {
  @Mock private AlarmRepository alarmRepository;

  @Mock private EntityManager entityManager;

  @Mock private JdbcTemplate jdbcTemplate;

  @InjectMocks private JpaAlarmDao jpaAlarmDao;

  @Mock private JpaExecutorService jpaExecutorService;

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doThrow(new IllegalArgumentException()).when(entityManager).persist(Mockito.<Object>any());

    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm));
    verify(entityManager).persist(isA(Object.class));
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_givenAlarmIdGetIdThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenThrow(new IllegalArgumentException());

    Alarm alarm = new Alarm();
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
   *   <li>Given {@link AlarmId}.
   *   <li>Then calls {@link AlarmData#setOriginator(EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_givenAlarmId_thenCallsSetOriginator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmData alarmData = mock(AlarmData.class);
    doNothing().when(alarmData).setOriginator(Mockito.<EntityId>any());
    alarmData.setOriginator(mock(AlarmId.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarmData));
    verify(alarmData).setOriginator(isA(EntityId.class));
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_thenOriginatorReturnCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    Alarm actualSaveResult = jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).persist(isA(Object.class));
    EntityId originator = actualSaveResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_thenOriginatorReturnTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveResult = jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    EntityId originator2 = actualSaveResult.getOriginator();
    assertTrue(originator2 instanceof TenantId);
    assertEquals(EntityType.TENANT, originator2.getEntityType());
    assertFalse(originator2.isNullUid());
    assertFalse(((TenantId) originator2).isSysTenantId());
    assertSame(randomUUIDResult, originator2.getId());
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Then return Originator is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_thenReturnOriginatorIsSys_tenant_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveResult = jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    assertSame(TenantId.SYS_TENANT_ID, actualSaveResult.getOriginator());
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_thenThrowEntityVersionMismatchException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doThrow(new OptimisticLockException()).when(entityManager).persist(Mockito.<Object>any());

    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm));
    verify(entityManager).persist(isA(Object.class));
  }

  /**
   * Test {@link JpaAbstractDao#save(TenantId, Object)} with {@code tenantId}, {@code domain}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()} CustomerId is {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_whenAlarmCustomerIdIsNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   *   <li>When {@link Alarm#Alarm()} Originator is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#save(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.save(TenantId, Object)"})
  public void testSaveWithTenantIdDomain_whenAlarmOriginatorIsSystem_tenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    Alarm alarm = new Alarm();
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    Alarm actualSaveResult = jpaAlarmDao.save(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).persist(isA(Object.class));
    assertSame(TenantId.SYS_TENANT_ID, actualSaveResult.getOriginator());
  }

  /**
   * Test {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} AckTs is one.
   *   <li>When {@code false}.
   *   <li>Then calls {@link EntityManager#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseEntity JpaAbstractDao.doSave(BaseEntity, boolean, boolean)"})
  public void testDoSave_givenAlarmEntityAckTsIsOne_whenFalse_thenCallsFlush() {
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
    when(entityManager.merge(Mockito.<AlarmEntity>any())).thenReturn(alarmEntity);
    doNothing().when(entityManager).flush();

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaAlarmDao.doSave(alarmEntity2, false, true);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).merge(isA(AlarmEntity.class));
  }

  /**
   * Test {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} AckTs is one.
   *   <li>When {@code false}.
   *   <li>Then calls {@link EntityManager#merge(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseEntity JpaAbstractDao.doSave(BaseEntity, boolean, boolean)"})
  public void testDoSave_givenAlarmEntityAckTsIsOne_whenFalse_thenCallsMerge() {
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
    when(entityManager.merge(Mockito.<AlarmEntity>any())).thenReturn(alarmEntity);

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaAlarmDao.doSave(alarmEntity2, false, false);

    // Assert
    verify(entityManager).merge(isA(AlarmEntity.class));
  }

  /**
   * Test {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link EntityManager} {@link EntityManager#persist(Object)} does nothing.
   *   <li>When {@code true}.
   *   <li>Then calls {@link EntityManager#persist(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseEntity JpaAbstractDao.doSave(BaseEntity, boolean, boolean)"})
  public void testDoSave_givenEntityManagerPersistDoesNothing_whenTrue_thenCallsPersist() {
    // Arrange
    doNothing().when(entityManager).flush();
    doNothing().when(entityManager).persist(Mockito.<Object>any());

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

    // Act
    jpaAlarmDao.doSave(alarmEntity, true, true);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).persist(isA(Object.class));
  }

  /**
   * Test {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#doSave(BaseEntity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseEntity JpaAbstractDao.doSave(BaseEntity, boolean, boolean)"})
  public void testDoSave_thenThrowIllegalArgumentException() {
    // Arrange
    when(entityManager.merge(Mockito.<AlarmEntity>any())).thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jpaAlarmDao.doSave(alarmEntity, false, true));
    verify(entityManager).merge(isA(AlarmEntity.class));
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush() {
    // Arrange
    doNothing().when(entityManager).flush();
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveAndFlushResult = jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    EntityId originator2 = actualSaveAndFlushResult.getOriginator();
    assertTrue(originator2 instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator2.getId().toString());
    assertSame(TenantId.SYS_TENANT_ID, actualSaveAndFlushResult.getTenantId());
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush2() {
    // Arrange
    doNothing().when(entityManager).flush();
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveAndFlushResult = jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    EntityId originator2 = actualSaveAndFlushResult.getOriginator();
    assertTrue(originator2 instanceof TenantId);
    CustomerId customerId = actualSaveAndFlushResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertSame(id, originator2.getId());
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} return randomUUID.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_givenAlarmIdGetIdReturnRandomUUID_thenReturnCustomerIdIsNull() {
    // Arrange
    doNothing().when(entityManager).flush();
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveAndFlushResult = jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    EntityId originator2 = actualSaveAndFlushResult.getOriginator();
    assertTrue(originator2 instanceof TenantId);
    assertNull(actualSaveAndFlushResult.getCustomerId());
    assertNull(actualSaveAndFlushResult.getTenantId());
    assertFalse(originator2.isNullUid());
    assertFalse(((TenantId) originator2).isSysTenantId());
    assertSame(randomUUIDResult, originator2.getId());
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_givenAlarmIdGetIdThrowIllegalArgumentException() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenThrow(new IllegalArgumentException());

    Alarm alarm = new Alarm();
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setOriginator(originator);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm));
    verify(originator).getId();
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_givenAlarmIdGetIdThrowIllegalArgumentException2() {
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
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    AlarmData alarmData = mock(AlarmData.class);
    doNothing().when(alarmData).setOriginator(Mockito.<EntityId>any());
    alarmData.setOriginator(mock(AlarmId.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarmData));
    verify(alarmData).setOriginator(isA(EntityId.class));
  }

  /**
   * Test {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#saveAndFlush(TenantId, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JpaAbstractDao.saveAndFlush(TenantId, Object)"})
  public void testSaveAndFlush_thenReturnOriginatorIsSys_tenant_id() {
    // Arrange
    doNothing().when(entityManager).flush();
    doNothing().when(entityManager).persist(Mockito.<Object>any());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originator.getEntityType()).thenReturn(EntityType.TENANT);

    Alarm alarm = new Alarm();
    alarm.setOriginator(originator);

    // Act
    Alarm actualSaveAndFlushResult = jpaAlarmDao.saveAndFlush(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(entityManager).flush();
    verify(entityManager).persist(isA(Object.class));
    verify(originator).getEntityType();
    verify(originator).getId();
    assertSame(TenantId.SYS_TENANT_ID, actualSaveAndFlushResult.getOriginator());
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
        jpaAlarmDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
        jpaAlarmDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
        jpaAlarmDao.findById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindByIdResult.getOriginator();
    assertSame(originator, actualFindByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
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
        jpaAlarmDao.findByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
        jpaAlarmDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
        jpaAlarmDao.existsById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertTrue(actualExistsByIdResult);
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
        jpaAlarmDao.existsByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
    jpaAlarmDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).flush();
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
    jpaAlarmDao.removeAllByIds(ids);

    // Assert
    verify(alarmRepository).flush();
    verify(alarmRepository, atLeast(1)).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#removeAllByIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#flush()} does nothing.
   *   <li>Then calls {@link AlarmRepository#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAbstractDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_givenAlarmRepositoryFlushDoesNothing_thenCallsFlush() {
    // Arrange
    doNothing().when(alarmRepository).flush();

    // Act
    jpaAlarmDao.removeAllByIds(new ArrayList<>());

    // Assert
    verify(alarmRepository).flush();
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
        IllegalArgumentException.class, () -> jpaAlarmDao.removeAllByIds(new ArrayList<>()));
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
    List<Alarm> actualFindResult = jpaAlarmDao.find(ModelConstants.SYSTEM_TENANT);

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
    List<Alarm> actualFindResult = jpaAlarmDao.find(ModelConstants.SYSTEM_TENANT);

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
    List<Alarm> actualFindResult = jpaAlarmDao.find(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(alarmRepository).findAll();
    assertEquals(1, actualFindResult.size());
    Alarm getResult = actualFindResult.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAbstractDao#findIdsByTenantIdAndIdOffset(TenantId, UUID, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAbstractDao.findIdsByTenantIdAndIdOffset(TenantId, UUID, int)"})
  public void testFindIdsByTenantIdAndIdOffset_thenThrowIllegalArgumentException() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaAlarmDao.findIdsByTenantIdAndIdOffset(tenantId, null, 1));
    verify(tenantId).getId();
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
        jpaAlarmDao.findIdsByTenantIdAndIdOffset(
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
  public void testFindIdsByTenantIdAndIdOffset_whenSystem_tenant_thenReturnEmpty2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(
            Mockito.<String>any(), Mockito.<Class<UUID>>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<UUID> actualFindIdsByTenantIdAndIdOffsetResult =
        jpaAlarmDao.findIdsByTenantIdAndIdOffset(ModelConstants.SYSTEM_TENANT, null, 1);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq("SELECT id FROM alarm WHERE tenant_id = ?  ORDER BY id LIMIT ?"),
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
    assertEquals("tenant_id", new JpaAlarmDao().getTenantIdColumn());
  }

  /**
   * Test {@link JpaAbstractDao#getEntityManager()}.
   *
   * <p>Method under test: {@link JpaAbstractDao#getEntityManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityManager JpaAbstractDao.getEntityManager()"})
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
    // Arrange, Act and Assert
    assertNull(new JpaAlarmDao().getJdbcTemplate());
  }
}
