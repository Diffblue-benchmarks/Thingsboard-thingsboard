package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.cache.TbCacheValueWrapper;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;

@ContextConfiguration(classes = {BaseRelationService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class BaseRelationServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseRelationService baseRelationService;

  @MockBean
  private EntityService entityService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private JpaRelationQueryExecutorService jpaRelationQueryExecutorService;

  @MockBean
  private RelationDao relationDao;

  @MockBean
  private TbTransactionalCache<RelationCacheKey, RelationCacheValue> tbTransactionalCache;

  /**
   * Test {@link BaseRelationService#handleEvictEvent(EntityRelationEvent)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then calls {@link EntityRelationEvent#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#handleEvictEvent(EntityRelationEvent)}
   */
  @Test
  public void testHandleEvictEvent_givenType_thenCallsGetFrom() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelationEvent event = mock(EntityRelationEvent.class);
    when(event.getType()).thenReturn("Type");
    when(event.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(event.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(event.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    baseRelationService.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(event, atLeast(1)).getFrom();
    verify(event, atLeast(1)).getTo();
    verify(event, atLeast(1)).getType();
    verify(event, atLeast(1)).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#handleEvictEvent(EntityRelationEvent)}.
   * <ul>
   *   <li>When from {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#handleEvictEvent(EntityRelationEvent)}
   */
  @Test
  public void testHandleEvictEvent_whenFromEntityRelation_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.handleEvictEvent(EntityRelationEvent.from(new EntityRelation()));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Boolean> createResult = SettableFuture.create();
    when(relationDao.checkRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualCheckRelationAsyncResult = baseRelationService.checkRelationAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao).checkRelationAsync(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
    assertTrue(actualCheckRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualCheckRelationAsyncResult);
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelationAsync_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.checkRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException("Executing checkRelationAsync [{}][{}][{}][{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(relationDao).checkRelationAsync(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelationAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelationAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, null,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.checkRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link RelationDao}
   * {@link RelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenRelationDaoCheckRelationReturnFalse_thenReturnFalse() {
    // Arrange
    when(relationDao.checkRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(false);

    // Act
    boolean actualCheckRelationResult = baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao).checkRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
    assertFalse(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link RelationDao}
   * {@link RelationDao#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_givenRelationDaoCheckRelationReturnTrue_thenReturnTrue() {
    // Arrange
    when(relationDao.checkRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(true);

    // Act
    boolean actualCheckRelationResult = baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao).checkRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.checkRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException("Executing checkRelation [{}][{}][{}][{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(relationDao).checkRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testCheckRelation_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        null, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.checkRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testGetRelation_thenReturnEntityRelation() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(entityRelation);

    // Act
    EntityRelation actualRelation = baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
    assertSame(entityRelation, actualRelation);
  }

  /**
   * Test
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testGetRelation_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("Executing EntityRelation [{}][{}][{}][{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testGetRelation_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testGetRelation_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        null, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.getRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelation [{}]")));
    assertThrows(DataValidationException.class, () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing saveRelation [{}]")));
    assertThrows(DataValidationException.class, () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "")));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@code COMMON}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code COMMON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenCommon_whenEntityRelationGetTypeGroupReturnCommon() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(relation).getFrom();
    verify(entityRelation).getTo();
    verify(relation).getTo();
    verify(entityRelation).getType();
    verify(relation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relation).getTypeGroup();
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)}
   * with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link EntityRelation#getTo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenEntityRelationGetTypeReturnType_thenCallsGetTo() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation(
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelation [{}]"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenNull_whenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then return {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_thenReturnEntityRelation() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    EntityRelation actualSaveRelationResult = baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(entityRelation, actualSaveRelationResult);
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelation_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doThrow(new RuntimeException("Executing saveRelation [{}]")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelation [{}]")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelations [{}]"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations2() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing saveRelations [{}]"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations3() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, ""));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations4() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenArrayListAddEntityRelation_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Executing saveRelations [{}]"));

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code COMMON}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetTypeGroupReturnCommon_thenCallsEvict() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Executing saveRelations [{}]"));

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code COMMON}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetTypeGroupReturnCommon_thenCallsEvict2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation entityRelation2 = mock(EntityRelation.class);
    when(entityRelation2.getType()).thenReturn("Type");
    when(entityRelation2.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation2.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation2.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation2);

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation2).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation2).getTo();
    verify(entityRelation).getType();
    verify(entityRelation2).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation2).getTypeGroup();
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code null}.</li>
   *   <li>Then calls {@link EntityRelation#getTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelationGetTypeGroupReturnNull_thenCallsGetTo() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(null);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelation_whenArrayListAddEntityRelation() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenEntityRelation_whenArrayListAddEntityRelation2() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());
    relations.add(new EntityRelation());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   * <ul>
   *   <li>Then calls {@link RelationDao#saveRelations(TenantId, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  public void testSaveRelations_thenCallsSaveRelations() {
    // Arrange
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
        "Executing saveRelations [{}]"));

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelationAsync [{}]")));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing saveRelationAsync [{}]")));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "")));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@code COMMON}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code COMMON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_givenCommon_whenEntityRelationGetTypeGroupReturnCommon() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)}
   * with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_givenNull_whenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then calls
   * {@link RelationDao#saveRelationAsync(TenantId, EntityRelation)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testSaveRelationAsync_thenCallsSaveRelationAsync() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);

    // Act
    baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation(
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelationAsync [{}]"));

    // Assert
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    EntityRelation actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(new EntityRelation());
    doThrow(new RuntimeException("Executing deleteRelation [{}][{}][{}][{}]")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup3() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getFrom()).thenThrow(new DataValidationException("An error occurred"));
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(entityRelation);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(entityRelation).getFrom();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getTo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetTo() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenReturnNull() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(null);

    // Act
    EntityRelation actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
    assertNull(actualDeleteRelationResult);
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenNull() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        null, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    boolean actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation2() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing DeleteRelation [{}]")));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation3() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing DeleteRelation [{}]")));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation4() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "")));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation5() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code COMMON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenCommon() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    boolean actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(relation).getFrom();
    verify(entityRelation).getTo();
    verify(relation).getTo();
    verify(entityRelation).getType();
    verify(relation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getType()} return
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenEntityRelationGetTypeReturnType() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    boolean actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_givenRelationDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_thenReturnFalse() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(null);

    // Act
    boolean actualDeleteRelationResult = baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]"));

    // Assert
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertFalse(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationWithTenantIdRelation_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doThrow(new RuntimeException("Executing DeleteRelation [{}]")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Executing DeleteRelation [{}]")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(createResult);

    // Act
    baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException("Executing deleteRelationAsync [{}][{}][{}][{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityId.class), isA(EntityId.class),
        eq("Relation Type"), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenNull() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, null,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing deleteRelationAsync [{}]")));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing deleteRelationAsync [{}]")));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT,
            new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "")));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation2() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code COMMON}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_givenCommon() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_givenNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Given {@link RelationDao}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_givenRelationDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   * with {@code tenantId}, {@code relation}.
   * <ul>
   *   <li>Then calls
   * {@link RelationDao#deleteRelationAsync(TenantId, EntityRelation)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelationAsyncWithTenantIdRelation_thenCallsDeleteRelationAsync() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);

    // Act
    baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation(
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Executing deleteRelationAsync [{}]"));

    // Assert
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityCommonRelations_givenArrayListAddEntityRelation_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityCommonRelations_givenArrayListAddEntityRelation_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<RelationCacheKey>>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityCommonRelations_givenTbTransactionalCache() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityCommonRelations_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityCommonRelations_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert that nothing has changed
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup2() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup3() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup4() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Assert that nothing has changed
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup5() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService
        .deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup_thenCallsGetFrom2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<RelationTypeGroup>any())).thenReturn(entityRelationList2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<RelationCacheKey>>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   * with {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link EntityRelation#EntityRelation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityId_givenArrayListAddEntityRelation() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   * with {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityId_givenTbTransactionalCache() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   * with {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   * with {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsGetFrom2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<RelationCacheKey>>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   * with {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFrom_thenReturnEmpty() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByFromResult = baseRelationService.findByFrom(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
    assertTrue(actualFindByFromResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFrom_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService.findByFrom(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFrom_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFrom(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFrom(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAsync_thenReturnGetEmpty() throws InterruptedException, ExecutionException {
    // Arrange
    TbCacheValueWrapper<RelationCacheValue> tbCacheValueWrapper = mock(TbCacheValueWrapper.class);
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    when(tbCacheValueWrapper.get()).thenReturn(buildResult);
    when(tbTransactionalCache.get(Mockito.<RelationCacheKey>any())).thenReturn(tbCacheValueWrapper);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByFromAsyncResult = baseRelationService
        .findByFromAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbCacheValueWrapper, atLeast(1)).get();
    verify(tbTransactionalCache).get(isA(RelationCacheKey.class));
    assertTrue(actualFindByFromAsyncResult.get().isEmpty());
    assertTrue(actualFindByFromAsyncResult.isDone());
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAsync_thenThrowRuntimeException() {
    // Arrange
    TbCacheValueWrapper<RelationCacheValue> tbCacheValueWrapper = mock(TbCacheValueWrapper.class);
    when(tbCacheValueWrapper.get()).thenThrow(new RuntimeException("Executing findByFrom [{}][{}]"));
    when(tbTransactionalCache.get(Mockito.<RelationCacheKey>any())).thenReturn(tbCacheValueWrapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService.findByFromAsync(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON));
    verify(tbCacheValueWrapper).get();
    verify(tbTransactionalCache).get(isA(RelationCacheKey.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFromAsync(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindInfoByFrom_givenJpaExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    baseRelationService.findInfoByFrom(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindInfoByFrom_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findInfoByFrom(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.findInfoByFrom(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAndType_thenReturnEmpty() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByFromAndTypeResult = baseRelationService.findByFromAndType(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
    assertTrue(actualFindByFromAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAndType_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService.findByFromAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAndTypeAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByFromAndTypeAsyncResult = baseRelationService
        .findByFromAndTypeAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByFromAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByFromAndTypeAsyncResult);
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAndTypeAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFromAndTypeAsync(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByFromAndTypeAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService
        .findByFromAndTypeAsync(ModelConstants.SYSTEM_TENANT, null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFromAndTypeAsync(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByFromAndTypeAsync(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByTo_thenReturnEmpty() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByToResult = baseRelationService.findByTo(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
    assertTrue(actualFindByToResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByTo_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService.findByTo(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByTo_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByTo(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByTo(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByToAsyncResult = baseRelationService
        .findByToAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByToAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByToAsyncResult);
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByToAsync(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.findByToAsync(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindInfoByTo_givenJpaExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    baseRelationService.findInfoByTo(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  public void testFindInfoByTo_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findInfoByTo(ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findInfoByTo(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndType_thenReturnEmpty() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByToAndTypeResult = baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
    assertTrue(actualFindByToAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndType_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("Executing findByToAndType [{}][{}][{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndType_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndType(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndType_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.findByToAndType(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndTypeAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByToAndTypeAsyncResult = baseRelationService.findByToAndTypeAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByToAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByToAndTypeAsyncResult);
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndTypeAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByToAndTypeAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testFindByToAndTypeAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService
        .findByToAndTypeAsync(ModelConstants.SYSTEM_TENANT, null, "Relation Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.findByToAndTypeAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService
        .findByToAndTypeAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Relation Type", null));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindByQuery_givenAlarmIdGetIdReturnNull_uuid_thenCallsGetEntityType() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, -1, true);

    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    when(query.getFilters()).thenReturn(new ArrayList<>());
    when(query.getParameters()).thenReturn(relationsSearchParameters);
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(query).getFilters();
    verify(query).getParameters();
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link RelationEntityTypeFilter#RelationEntityTypeFilter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindByQuery_givenArrayListAddRelationEntityTypeFilter() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    ArrayList<RelationEntityTypeFilter> relationEntityTypeFilterList = new ArrayList<>();
    relationEntityTypeFilterList.add(new RelationEntityTypeFilter());
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    when(query.getFilters()).thenReturn(relationEntityTypeFilterList);
    when(query.getParameters()).thenReturn(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
    verify(query).getFilters();
    verify(query).getParameters();
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>When {@link EntityRelationsQuery} (default constructor) Filters is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindByQuery_whenEntityRelationsQueryFiltersIsArrayList_thenCallsSubmit() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindInfoByQuery_givenAlarmIdGetIdReturnNull_uuid_thenCallsGetEntityType() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters relationsSearchParameters = new RelationsSearchParameters(entityId,
        EntitySearchDirection.FROM, -1, true);

    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    when(query.getFilters()).thenReturn(new ArrayList<>());
    when(query.getParameters()).thenReturn(relationsSearchParameters);
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(query).getFilters();
    verify(query, atLeast(1)).getParameters();
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link RelationEntityTypeFilter#RelationEntityTypeFilter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindInfoByQuery_givenArrayListAddRelationEntityTypeFilter() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    ArrayList<RelationEntityTypeFilter> relationEntityTypeFilterList = new ArrayList<>();
    relationEntityTypeFilterList.add(new RelationEntityTypeFilter());
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    when(query.getFilters()).thenReturn(relationEntityTypeFilterList);
    when(query.getParameters()).thenReturn(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
    verify(query).getFilters();
    verify(query, atLeast(1)).getParameters();
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   * <ul>
   *   <li>When {@link EntityRelationsQuery} (default constructor) Filters is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  public void testFindInfoByQuery_whenEntityRelationsQueryFiltersIsArrayList_thenCallsSubmit() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  public void testRemoveRelations() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    baseRelationService.removeRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).getAndPutInTransaction(Mockito.<RelationCacheKey>any(),
        Mockito.<Supplier<Object>>any(), Mockito.<Function<RelationCacheValue, Object>>any(),
        Mockito.<Function<Object, RelationCacheValue>>any(), eq(false));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  public void testRemoveRelations_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelationCacheKey>any(), Mockito.<Supplier<Object>>any(),
        Mockito.<Function<RelationCacheValue, Object>>any(), Mockito.<Function<Object, RelationCacheValue>>any(),
        anyBoolean())).thenThrow(new RuntimeException("removeRelations {}"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseRelationService.removeRelations(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelationCacheKey.class), isA(Supplier.class),
        isA(Function.class), isA(Function.class), eq(false));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  public void testRemoveRelations_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.removeRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test
   * {@link BaseRelationService#findRuleNodeToRuleChainRelations(TenantId, RuleChainType, int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findRuleNodeToRuleChainRelations(TenantId, RuleChainType, int)}
   */
  @Test
  public void testFindRuleNodeToRuleChainRelations_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.findRuleNodeToRuleChainRelations(Mockito.<RuleChainType>any(), anyInt()))
        .thenThrow(new RuntimeException(
            "Executing findRuleNodeToRuleChainRelations, tenantId [{}], ruleChainType {} and limit {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRelationService
        .findRuleNodeToRuleChainRelations(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, 1));
    verify(relationDao).findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), eq(1));
  }

  /**
   * Test
   * {@link BaseRelationService#findRuleNodeToRuleChainRelations(TenantId, RuleChainType, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#findRuleNodeToRuleChainRelations(TenantId, RuleChainType, int)}
   */
  @Test
  public void testFindRuleNodeToRuleChainRelations_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(relationDao.findRuleNodeToRuleChainRelations(Mockito.<RuleChainType>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindRuleNodeToRuleChainRelationsResult = baseRelationService
        .findRuleNodeToRuleChainRelations(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, 1);

    // Assert
    verify(relationDao).findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), eq(1));
    assertTrue(actualFindRuleNodeToRuleChainRelationsResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId)} with {@code entity}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityId)}
   */
  @Test
  public void testValidateWithEntity_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate((EntityId) null));
  }

  /**
   * Test
   * {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testValidateWithFromToTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test
   * {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)}
   * with {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)}
   */
  @Test
  public void testValidateWithFromToTypeTypeGroup_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRelationService.validate(null, BaseEntityService.NULL_CUSTOMER_ID, "Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class,
        () -> baseRelationService.validate(BaseEntityService.NULL_CUSTOMER_ID, null, "Type", RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID, null, RelationTypeGroup.COMMON));
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID, "Type", null));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_givenEmptyString() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getFrom()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_givenNull_whenEntityRelationGetFromReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(null);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTo()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_givenNull_whenEntityRelationGetToReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(null);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_givenNull_whenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>When {@link EntityRelation} {@link EntityRelation#getType()} return
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_givenType_whenEntityRelationGetTypeReturnType() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act
    baseRelationService.validate(relation);

    // Assert
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_whenEntityRelation_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate(new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityRelation)} with
   * {@code relation}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationService#validate(EntityRelation)}
   */
  @Test
  public void testValidateWithRelation_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRelationService.validate((EntityRelation) null));
  }
}
