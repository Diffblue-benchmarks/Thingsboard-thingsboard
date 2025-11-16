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
package org.thingsboard.server.dao.sql.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaApiUsageStateDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaApiUsageStateDaoDiffblueTest {
  @MockBean private ApiUsageStateRepository apiUsageStateRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaApiUsageStateDao jpaApiUsageStateDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaApiUsageStateDao#getEntityClass()}
   *   <li>{@link JpaApiUsageStateDao#getEntityType()}
   *   <li>{@link JpaApiUsageStateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaApiUsageStateDao.getEntityClass()",
    "EntityType JpaApiUsageStateDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaApiUsageStateDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaApiUsageStateDao jpaApiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));

    // Act
    Class<ApiUsageStateEntity> actualEntityClass = jpaApiUsageStateDao.getEntityClass();
    EntityType actualEntityType = jpaApiUsageStateDao.getEntityType();
    jpaApiUsageStateDao.getRepository();

    // Assert
    assertEquals(EntityType.API_USAGE_STATE, actualEntityType);
    Class<ApiUsageStateEntity> expectedEntityClass = ApiUsageStateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaApiUsageStateDao#findTenantApiUsageState(UUID)}.
   *
   * <ul>
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#findTenantApiUsageState(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState JpaApiUsageStateDao.findTenantApiUsageState(UUID)"})
  public void testFindTenantApiUsageState_thenReturnEntityIdIsNull() {
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
    when(apiUsageStateRepository.findByTenantId(Mockito.<UUID>any()))
        .thenReturn(apiUsageStateEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult =
        jpaApiUsageStateDao.findTenantApiUsageState(tenantId);

    // Assert
    verify(apiUsageStateRepository).findByTenantId(isA(UUID.class));
    assertNull(actualFindTenantApiUsageStateResult.getEntityId());
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
    assertTrue(actualFindTenantApiUsageStateResult.isAlarmCreationEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isDbStorageEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isEmailSendEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isJsExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isReExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isSmsSendEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isTbelExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isTransportEnabled());
    assertSame(tenantId, actualFindTenantApiUsageStateResult.getUuidId());
  }

  /**
   * Test {@link JpaApiUsageStateDao#findTenantApiUsageState(UUID)}.
   *
   * <ul>
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#findTenantApiUsageState(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState JpaApiUsageStateDao.findTenantApiUsageState(UUID)"})
  public void testFindTenantApiUsageState_thenReturnEntityIdIsNull2() {
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
    apiUsageStateEntity.setTenantId(UUID.randomUUID());
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByTenantId(Mockito.<UUID>any()))
        .thenReturn(apiUsageStateEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult =
        jpaApiUsageStateDao.findTenantApiUsageState(tenantId);

    // Assert
    verify(apiUsageStateRepository).findByTenantId(isA(UUID.class));
    assertNull(actualFindTenantApiUsageStateResult.getEntityId());
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
    assertTrue(actualFindTenantApiUsageStateResult.isAlarmCreationEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isDbStorageEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isEmailSendEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isJsExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isReExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isSmsSendEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isTbelExecEnabled());
    assertTrue(actualFindTenantApiUsageStateResult.isTransportEnabled());
    assertSame(tenantId, actualFindTenantApiUsageStateResult.getUuidId());
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState JpaApiUsageStateDao.findApiUsageStateByEntityId(EntityId)"})
  public void testFindApiUsageStateByEntityId() {
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
    when(apiUsageStateRepository.findByEntityIdAndEntityType(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        jpaApiUsageStateDao.findApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("CUSTOMER"));
    TenantId tenantId = actualFindApiUsageStateByEntityIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState JpaApiUsageStateDao.findApiUsageStateByEntityId(EntityId)"})
  public void testFindApiUsageStateByEntityId2() {
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
    when(apiUsageStateRepository.findByEntityIdAndEntityType(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        jpaApiUsageStateDao.findApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
    TenantId tenantId = actualFindApiUsageStateByEntityIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState JpaApiUsageStateDao.findApiUsageStateByEntityId(EntityId)"})
  public void testFindApiUsageStateByEntityId_thenReturnNotTenantIdNullUid() {
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
    UUID tenantId = UUID.randomUUID();
    apiUsageStateEntity.setTenantId(tenantId);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByEntityIdAndEntityType(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult =
        jpaApiUsageStateDao.findApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
    TenantId tenantId2 = actualFindApiUsageStateByEntityIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaApiUsageStateDao.deleteApiUsageStateByTenantId(TenantId)"})
  public void testDeleteApiUsageStateByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteApiUsageStateByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(apiUsageStateRepository).deleteApiUsageStateByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaApiUsageStateDao.deleteApiUsageStateByTenantId(TenantId)"})
  public void testDeleteApiUsageStateByTenantId_whenSystem_tenant() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteApiUsageStateByTenantId(Mockito.<UUID>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateRepository).deleteApiUsageStateByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaApiUsageStateDao.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    doNothing()
        .when(apiUsageStateRepository)
        .deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaApiUsageStateDao.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId_whenNull_customer_id() {
    // Arrange
    doNothing()
        .when(apiUsageStateRepository)
        .deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("CUSTOMER"));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaApiUsageStateDao.deleteApiUsageStateByEntityId(EntityId)"})
  public void testDeleteApiUsageStateByEntityId_whenSystem_tenant() {
    // Arrange
    doNothing()
        .when(apiUsageStateRepository)
        .deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
  }
}
