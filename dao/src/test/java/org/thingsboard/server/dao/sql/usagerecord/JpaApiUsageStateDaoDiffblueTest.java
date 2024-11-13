package org.thingsboard.server.dao.sql.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaApiUsageStateDaoDiffblueTest {
  @MockBean
  private ApiUsageStateRepository apiUsageStateRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaApiUsageStateDao jpaApiUsageStateDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaApiUsageStateDao#getEntityClass()}
   *   <li>{@link JpaApiUsageStateDao#getEntityType()}
   *   <li>{@link JpaApiUsageStateDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaApiUsageStateDao jpaApiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));

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
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaApiUsageStateDao#findTenantApiUsageState(UUID)}
   */
  @Test
  public void testFindTenantApiUsageState_thenReturnApiUsageState() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = mock(ApiUsageStateEntity.class);
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateEntity.toData()).thenReturn(apiUsageState);
    doNothing().when(apiUsageStateEntity).setCreatedTime(anyLong());
    doNothing().when(apiUsageStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(apiUsageStateEntity).setJsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(apiUsageStateEntity);

    // Act
    ApiUsageState actualFindTenantApiUsageStateResult = jpaApiUsageStateDao
        .findTenantApiUsageState(ModelConstants.NULL_UUID);

    // Assert
    verify(apiUsageStateEntity).setCreatedTime(eq(1L));
    verify(apiUsageStateEntity).setId(isA(UUID.class));
    verify(apiUsageStateEntity).setUuid(isA(UUID.class));
    verify(apiUsageStateEntity).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEntityId(isA(UUID.class));
    verify(apiUsageStateEntity).setEntityType(eq("Entity Type"));
    verify(apiUsageStateEntity).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTenantId(isA(UUID.class));
    verify(apiUsageStateEntity).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).toData();
    verify(apiUsageStateRepository).findByTenantId(isA(UUID.class));
    assertSame(apiUsageState, actualFindTenantApiUsageStateResult);
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testFindApiUsageStateByEntityId_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = mock(ApiUsageStateEntity.class);
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateEntity.toData()).thenReturn(apiUsageState);
    doNothing().when(apiUsageStateEntity).setCreatedTime(anyLong());
    doNothing().when(apiUsageStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(apiUsageStateEntity).setJsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult = jpaApiUsageStateDao.findApiUsageStateByEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(apiUsageStateEntity).setCreatedTime(eq(1L));
    verify(apiUsageStateEntity).setId(isA(UUID.class));
    verify(apiUsageStateEntity).setUuid(isA(UUID.class));
    verify(apiUsageStateEntity).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEntityId(isA(UUID.class));
    verify(apiUsageStateEntity).setEntityType(eq("Entity Type"));
    verify(apiUsageStateEntity).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTenantId(isA(UUID.class));
    verify(apiUsageStateEntity).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).toData();
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testFindApiUsageStateByEntityId_whenNull_customer_id_thenReturnApiUsageState() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = mock(ApiUsageStateEntity.class);
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateEntity.toData()).thenReturn(apiUsageState);
    doNothing().when(apiUsageStateEntity).setCreatedTime(anyLong());
    doNothing().when(apiUsageStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(apiUsageStateEntity).setJsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult = jpaApiUsageStateDao
        .findApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(apiUsageStateEntity).setCreatedTime(eq(1L));
    verify(apiUsageStateEntity).setId(isA(UUID.class));
    verify(apiUsageStateEntity).setUuid(isA(UUID.class));
    verify(apiUsageStateEntity).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEntityId(isA(UUID.class));
    verify(apiUsageStateEntity).setEntityType(eq("Entity Type"));
    verify(apiUsageStateEntity).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTenantId(isA(UUID.class));
    verify(apiUsageStateEntity).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).toData();
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("CUSTOMER"));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#findApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testFindApiUsageStateByEntityId_whenSystem_tenant_thenReturnApiUsageState() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = mock(ApiUsageStateEntity.class);
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateEntity.toData()).thenReturn(apiUsageState);
    doNothing().when(apiUsageStateEntity).setCreatedTime(anyLong());
    doNothing().when(apiUsageStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(apiUsageStateEntity).setJsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(apiUsageStateRepository.findByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(apiUsageStateEntity);

    // Act
    ApiUsageState actualFindApiUsageStateByEntityIdResult = jpaApiUsageStateDao
        .findApiUsageStateByEntityId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(apiUsageStateEntity).setCreatedTime(eq(1L));
    verify(apiUsageStateEntity).setId(isA(UUID.class));
    verify(apiUsageStateEntity).setUuid(isA(UUID.class));
    verify(apiUsageStateEntity).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEntityId(isA(UUID.class));
    verify(apiUsageStateEntity).setEntityType(eq("Entity Type"));
    verify(apiUsageStateEntity).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTenantId(isA(UUID.class));
    verify(apiUsageStateEntity).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).toData();
    verify(apiUsageStateRepository).findByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
    assertSame(apiUsageState, actualFindApiUsageStateByEntityIdResult);
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link ApiUsageStateRepository#deleteApiUsageStateByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#deleteApiUsageStateByTenantId(TenantId)}
   */
  @Test
  public void testDeleteApiUsageStateByTenantId_thenCallsDeleteApiUsageStateByTenantId() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteApiUsageStateByTenantId(Mockito.<UUID>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(apiUsageStateRepository).deleteApiUsageStateByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(entityId);

    // Assert that nothing has changed
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId_whenNull_customer_id() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("CUSTOMER"));
  }

  /**
   * Test {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaApiUsageStateDao#deleteApiUsageStateByEntityId(EntityId)}
   */
  @Test
  public void testDeleteApiUsageStateByEntityId_whenSystem_tenant() {
    // Arrange
    doNothing().when(apiUsageStateRepository).deleteByEntityIdAndEntityType(Mockito.<UUID>any(), Mockito.<String>any());

    // Act
    jpaApiUsageStateDao.deleteApiUsageStateByEntityId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(apiUsageStateRepository).deleteByEntityIdAndEntityType(isA(UUID.class), eq("TENANT"));
  }
}
