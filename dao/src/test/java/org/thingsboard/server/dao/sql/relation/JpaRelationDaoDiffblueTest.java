package org.thingsboard.server.dao.sql.relation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RelationCompositeKey;
import org.thingsboard.server.dao.model.sql.RelationEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRelationDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaRelationDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRelationDao jpaRelationDao;

  @MockBean
  private RelationInsertRepository relationInsertRepository;

  @MockBean
  private RelationRepository relationRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code typeGroup}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFromTypeGroup_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT, from,
        RelationTypeGroup.COMMON);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"),
        eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code typeGroup}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFromTypeGroup_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroup(isA(UUID.class), eq("CUSTOMER"),
        eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code typeGroup}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFromTypeGroup_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT,
        ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"),
        eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with
   * {@code tenantId}, {@code from}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFrom_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT, from);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroupIn(isA(UUID.class), eq("TENANT"),
        isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with
   * {@code tenantId}, {@code from}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFrom_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroupIn(isA(UUID.class), eq("CUSTOMER"),
        isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with
   * {@code tenantId}, {@code from}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByFromWithTenantIdFrom_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult = jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT,
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeGroupIn(isA(UUID.class), eq("TENANT"),
        isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromAndType_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult = jpaRelationDao
        .findAllByFromAndType(ModelConstants.SYSTEM_TENANT, from, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class),
        eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromAndType_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult = jpaRelationDao.findAllByFromAndType(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class),
        eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByFromAndType_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult = jpaRelationDao.findAllByFromAndType(
        ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class),
        eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code to}, {@code typeGroup}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToWithTenantIdToTypeGroup_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT, resultTo,
        RelationTypeGroup.COMMON);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code to}, {@code typeGroup}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToWithTenantIdToTypeGroup_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("CUSTOMER"),
        eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code to}, {@code typeGroup}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToWithTenantIdToTypeGroup_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT,
        ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with
   * {@code tenantId}, {@code to}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByToWithTenantIdTo_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT, resultTo);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroupIn(isA(UUID.class), eq("TENANT"),
        isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with
   * {@code tenantId}, {@code to}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByToWithTenantIdTo_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroupIn(isA(UUID.class), eq("CUSTOMER"),
        isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with
   * {@code tenantId}, {@code to}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  public void testFindAllByToWithTenantIdTo_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult = jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT,
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeGroupIn(isA(UUID.class), eq("TENANT"),
        isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToAndType_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult = jpaRelationDao
        .findAllByToAndType(ModelConstants.SYSTEM_TENANT, resultTo, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"),
        eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToAndType_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult = jpaRelationDao.findAllByToAndType(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class),
        eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindAllByToAndType_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult = jpaRelationDao.findAllByToAndType(
        ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"),
        eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualCheckRelationAsyncResult = jpaRelationDao.checkRelationAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualCheckRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualCheckRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT, from,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenNull_uuid_thenCallsGetEntityType2() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT, from,
        ModelConstants.SYSTEM_TENANT, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenNull_uuid_thenCallsGetEntityType3() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT, from, resultTo,
        "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link RelationRepository}
   * {@link CrudRepository#existsById(Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenRelationRepositoryExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(false);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    assertFalse(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_whenNull_customer_id_thenReturnTrue() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_whenNull_customer_id_thenReturnTrue2() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    // Act
    boolean actualCheckRelationResult = jpaRelationDao.checkRelation(ModelConstants.SYSTEM_TENANT,
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link RelationRepository} {@link CrudRepository#findById(Object)}
   * return empty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testGetRelation_givenRelationRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<RelationEntity> emptyResult = Optional.empty();
    when(relationRepository.findById(Mockito.<RelationCompositeKey>any())).thenReturn(emptyResult);

    // Act
    EntityRelation actualRelation = jpaRelationDao.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).findById(isA(RelationCompositeKey.class));
    assertNull(actualRelation);
  }

  /**
   * Test {@link JpaRelationDao#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_thenThrowEmptyResultDataAccessException() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getAdditionalInfo()).thenThrow(new EmptyResultDataAccessException(3));
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getAdditionalInfo();
    verify(relation, atLeast(1)).getFrom();
    verify(relation, atLeast(1)).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relation).setTypeGroup(eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations2() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations3() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenThrow(new EmptyResultDataAccessException(3));
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityIdGetIdReturnNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(entityId);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getFrom()} return
   * {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetFromReturnNull_customer_id() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getFrom()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetFromReturnSystem_tenant() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTo()} return
   * {@link EntityId}.</li>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetToReturnEntityId_thenCallsGetEntityType() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(entityId);
    when(entityRelation.getTo()).thenReturn(entityId2);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId2).getEntityType();
    verify(entityId).getId();
    verify(entityId2).getId();
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTo()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetToReturnSystem_tenant() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(entityId);
    when(entityRelation.getTo()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()} TypeGroup is
   * {@code COMMON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationTypeGroupIsCommon() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        relations);

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualSaveRelationsResult = jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT,
        new ArrayList<>());

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualSaveRelationAsyncResult = jpaRelationDao
        .saveRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualSaveRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup() throws DataAccessException {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(jdbcTemplate.query(Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenReturn(entityRelation);

    // Act
    EntityRelation actualDeleteRelationResult = jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).query(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(ResultSetExtractor.class), isA(Object[].class));
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetEntityType()
      throws DataAccessException {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(jdbcTemplate.query(Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenReturn(entityRelation);
    EntityId from = mock(EntityId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    EntityRelation actualDeleteRelationResult = jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, from,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).query(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(ResultSetExtractor.class), isA(Object[].class));
    verify(from).getEntityType();
    verify(from).getId();
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetEntityType2()
      throws DataAccessException {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(jdbcTemplate.query(Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenReturn(entityRelation);
    EntityId from = mock(EntityId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);
    EntityId resultTo = mock(EntityId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    EntityRelation actualDeleteRelationResult = jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, from,
        resultTo, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).query(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(ResultSetExtractor.class), isA(Object[].class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)} with
   * {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then calls {@link EntityRelation#getTypeGroup()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenType_thenCallsGetTypeGroup() throws DataAccessException {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(jdbcTemplate.query(Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenReturn(entityRelation);
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    doNothing().when(relation).setFrom(Mockito.<EntityId>any());
    doNothing().when(relation).setTo(Mockito.<EntityId>any());
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(mock(AlarmId.class));
    relation.setFrom(mock(AlarmId.class));

    // Act
    EntityRelation actualDeleteRelationResult = jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(jdbcTemplate).query(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(ResultSetExtractor.class), isA(Object[].class));
    verify(relation, atLeast(1)).getFrom();
    verify(relation, atLeast(1)).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relation).setFrom(isA(EntityId.class));
    verify(relation).setTo(isA(EntityId.class));
    verify(relation).setTypeGroup(eq(RelationTypeGroup.COMMON));
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)} with
   * {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_thenCallsGetEntityType() throws DataAccessException {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(jdbcTemplate.query(Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenReturn(entityRelation);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(resultTo);
    relation.setFrom(from);

    // Act
    EntityRelation actualDeleteRelationResult = jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(jdbcTemplate).query(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(ResultSetExtractor.class), isA(Object[].class));
    verify(resultTo).getEntityType();
    verify(from).getEntityType();
    verify(resultTo).getId();
    verify(from).getId();
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)} with
   * {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_thenThrowEmptyResultDataAccessException() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenThrow(new EmptyResultDataAccessException(3));
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    doNothing().when(relation).setFrom(Mockito.<EntityId>any());
    doNothing().when(relation).setTo(Mockito.<EntityId>any());
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(mock(AlarmId.class));
    relation.setFrom(mock(AlarmId.class));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation, atLeast(1)).getFrom();
    verify(relation, atLeast(1)).getTo();
    verify(relation).getType();
    verify(relation).setFrom(isA(EntityId.class));
    verify(relation).setTo(isA(EntityId.class));
    verify(relation).setTypeGroup(eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup3() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT, from, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup4() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT, from, ModelConstants.SYSTEM_TENANT, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup5() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao
        .deleteRelationAsync(ModelConstants.SYSTEM_TENANT, from, resultTo, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenThrow(new EmptyResultDataAccessException(3));
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    doNothing().when(relation).setFrom(Mockito.<EntityId>any());
    doNothing().when(relation).setTo(Mockito.<EntityId>any());
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(mock(AlarmId.class));
    relation.setFrom(mock(AlarmId.class));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation, atLeast(1)).getFrom();
    verify(relation, atLeast(1)).getTo();
    verify(relation).getType();
    verify(relation).setFrom(isA(EntityId.class));
    verify(relation).setTo(isA(EntityId.class));
    verify(relation).setTypeGroup(eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then calls {@link EntityRelation#getTypeGroup()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_givenType_thenCallsGetTypeGroup() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    doNothing().when(relation).setFrom(Mockito.<EntityId>any());
    doNothing().when(relation).setTo(Mockito.<EntityId>any());
    doNothing().when(relation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(mock(AlarmId.class));
    relation.setFrom(mock(AlarmId.class));

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao
        .deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(relation, atLeast(1)).getFrom();
    verify(relation, atLeast(1)).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relation).setFrom(isA(EntityId.class));
    verify(relation).setTo(isA(EntityId.class));
    verify(relation).setTypeGroup(eq(RelationTypeGroup.COMMON));
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_thenCallsGetEntityType() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);
    relation.setTo(resultTo);
    relation.setFrom(from);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult = jpaRelationDao
        .deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(resultTo).getEntityType();
    verify(from).getEntityType();
    verify(resultTo).getId();
    verify(from).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao.deleteOutboundRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup2() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());
    EntityId entity = mock(EntityId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao
        .deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, entity, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao
        .deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntity_thenCallsGetEntityType() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());
    EntityId entity = mock(EntityId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao
        .deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, entity);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntity_whenNull_customer_id() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao
        .deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteOutboundRelationsWithTenantIdEntity_whenSystem_tenant_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult = jpaRelationDao
        .deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao.deleteInboundRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup2() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());
    EntityId entity = mock(EntityId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao
        .deleteInboundRelations(ModelConstants.SYSTEM_TENANT, entity, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao
        .deleteInboundRelations(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>Then calls {@link EntityId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntity_thenCallsGetEntityType() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());
    EntityId entity = mock(EntityId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao
        .deleteInboundRelations(ModelConstants.SYSTEM_TENANT, entity);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntity_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao
        .deleteInboundRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with
   * {@code tenantId}, {@code entity}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteInboundRelationsWithTenantIdEntity_whenSystem_tenant_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult = jpaRelationDao
        .deleteInboundRelations(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(jdbcTemplate).queryForList(eq(
        "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
        isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}
   */
  @Test
  public void testFindRuleNodeToRuleChainRelations_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findRuleNodeToRuleChainRelations(Mockito.<RuleChainType>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindRuleNodeToRuleChainRelationsResult = jpaRelationDao
        .findRuleNodeToRuleChainRelations(RuleChainType.CORE, 1);

    // Assert
    verify(relationRepository).findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), isA(Pageable.class));
    assertTrue(actualFindRuleNodeToRuleChainRelationsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}
   */
  @Test
  public void testFindRuleNodeToRuleChainRelations_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findRuleNodeToRuleChainRelations(Mockito.<RuleChainType>any(), Mockito.<Pageable>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaRelationDao.findRuleNodeToRuleChainRelations(RuleChainType.CORE, 1));
    verify(relationRepository).findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), isA(Pageable.class));
  }
}
