package org.thingsboard.server.dao.sql.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.sql.DataSource;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.dictionary.KeyDictionaryDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AttributeKvCompositeKey;
import org.thingsboard.server.dao.model.sql.AttributeKvEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;

@ContextConfiguration(classes = {JpaAttributeDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAttributeDaoDiffblueTest {
  @MockBean
  private AttributeKvInsertRepository attributeKvInsertRepository;

  @MockBean
  private AttributeKvRepository attributeKvRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAttributeDao jpaAttributeDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private KeyDictionaryDao keyDictionaryDao;

  @MockBean
  private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean
  private StatsFactory statsFactory;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKey}.
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);
    Optional<AttributeKvEntity> ofResult = Optional.of(attributeKvEntity);
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any())).thenReturn(ofResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    Optional<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId(eq("Attribute Key"));
    AttributeKvEntry getResult = actualFindResult.get();
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKey}.
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, "Attribute Key"));
    verify(keyDictionaryDao).getOrSaveKeyId(eq("Attribute Key"));
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKey}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey_thenCallsGetId() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);
    Optional<AttributeKvEntity> ofResult = Optional.of(attributeKvEntity);
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any())).thenReturn(ofResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT, entityId,
        AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId(eq("Attribute Key"));
    AttributeKvEntry getResult = actualFindResult.get();
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKey}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey_thenReturnNotPresent() {
    // Arrange
    Optional<AttributeKvEntity> emptyResult = Optional.empty();
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any())).thenReturn(emptyResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    Optional<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId(eq("Attribute Key"));
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);
    AttributeKvEntity attributeKvEntity = mock(AttributeKvEntity.class);
    when(attributeKvEntity.toData()).thenThrow(new EmptyResultDataAccessException(3));
    when(attributeKvEntity.getId()).thenReturn(attributeKvCompositeKey);
    doNothing().when(attributeKvEntity).setBooleanValue(Mockito.<Boolean>any());
    doNothing().when(attributeKvEntity).setDoubleValue(Mockito.<Double>any());
    doNothing().when(attributeKvEntity).setId(Mockito.<AttributeKvCompositeKey>any());
    doNothing().when(attributeKvEntity).setJsonValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setLastUpdateTs(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setLongValue(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setStrKey(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setStrValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setVersion(Mockito.<Long>any());
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>()));
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(eq(1));
    verify(attributeKvEntity).getId();
    verify(attributeKvEntity).setBooleanValue(eq(true));
    verify(attributeKvEntity).setDoubleValue(eq(10.0d));
    verify(attributeKvEntity).setId(isA(AttributeKvCompositeKey.class));
    verify(attributeKvEntity).setJsonValue(eq("42"));
    verify(attributeKvEntity).setLastUpdateTs(eq(1L));
    verify(attributeKvEntity).setLongValue(eq(42L));
    verify(attributeKvEntity, atLeast(1)).setStrKey(Mockito.<String>any());
    verify(attributeKvEntity).setStrValue(eq("42"));
    verify(attributeKvEntity).setVersion(eq(1L));
    verify(attributeKvEntity).toData();
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenCallsGetId() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);
    AttributeKvEntity attributeKvEntity = mock(AttributeKvEntity.class);
    when(attributeKvEntity.toData()).thenThrow(new EmptyResultDataAccessException(3));
    when(attributeKvEntity.getId()).thenReturn(attributeKvCompositeKey);
    doNothing().when(attributeKvEntity).setBooleanValue(Mockito.<Boolean>any());
    doNothing().when(attributeKvEntity).setDoubleValue(Mockito.<Double>any());
    doNothing().when(attributeKvEntity).setId(Mockito.<AttributeKvCompositeKey>any());
    doNothing().when(attributeKvEntity).setJsonValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setLastUpdateTs(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setLongValue(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setStrKey(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setStrValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setVersion(Mockito.<Long>any());
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributeKeys));
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getKey(eq(1));
    verify(keyDictionaryDao).getOrSaveKeyId(eq("foo"));
    verify(attributeKvEntity).getId();
    verify(attributeKvEntity).setBooleanValue(eq(true));
    verify(attributeKvEntity).setDoubleValue(eq(10.0d));
    verify(attributeKvEntity).setId(isA(AttributeKvCompositeKey.class));
    verify(attributeKvEntity).setJsonValue(eq("42"));
    verify(attributeKvEntity).setLastUpdateTs(eq(1L));
    verify(attributeKvEntity).setLongValue(eq(42L));
    verify(attributeKvEntity, atLeast(1)).setStrKey(Mockito.<String>any());
    verify(attributeKvEntity).setStrValue(eq("42"));
    verify(attributeKvEntity).setVersion(eq(1L));
    verify(attributeKvEntity).toData();
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Then calls {@link KeyDictionaryDao#getOrSaveKeyId(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenCallsGetOrSaveKeyId() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);
    AttributeKvEntity attributeKvEntity = mock(AttributeKvEntity.class);
    when(attributeKvEntity.toData()).thenThrow(new EmptyResultDataAccessException(3));
    when(attributeKvEntity.getId()).thenReturn(attributeKvCompositeKey);
    doNothing().when(attributeKvEntity).setBooleanValue(Mockito.<Boolean>any());
    doNothing().when(attributeKvEntity).setDoubleValue(Mockito.<Double>any());
    doNothing().when(attributeKvEntity).setId(Mockito.<AttributeKvCompositeKey>any());
    doNothing().when(attributeKvEntity).setJsonValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setLastUpdateTs(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setLongValue(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setStrKey(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setStrValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setVersion(Mockito.<Long>any());
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, attributeKeys));
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(eq(1));
    verify(keyDictionaryDao).getOrSaveKeyId(eq("foo"));
    verify(attributeKvEntity).getId();
    verify(attributeKvEntity).setBooleanValue(eq(true));
    verify(attributeKvEntity).setDoubleValue(eq(10.0d));
    verify(attributeKvEntity).setId(isA(AttributeKvCompositeKey.class));
    verify(attributeKvEntity).setJsonValue(eq("42"));
    verify(attributeKvEntity).setLastUpdateTs(eq(1L));
    verify(attributeKvEntity).setLongValue(eq(42L));
    verify(attributeKvEntity, atLeast(1)).setStrKey(Mockito.<String>any());
    verify(attributeKvEntity).setStrValue(eq("42"));
    verify(attributeKvEntity).setVersion(eq(1L));
    verify(attributeKvEntity).toData();
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenReturnSizeIsOne() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(eq(1));
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertEquals("42", getResult.getStrValue().get());
    assertEquals("42", getResult.getValueAsString());
    assertEquals("42", kv.getValueAsString());
    assertEquals("42", getResult.getValue());
    assertEquals("42", kv.getValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getLastUpdateTs());
  }

  /**
   * Test
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   * with {@code tenantId}, {@code entityId}, {@code attributeScope},
   * {@code attributeKeys}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)}
   */
  @Test
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenReturnSizeIsTwo() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity2);
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<AttributeKvEntry> actualFindResult = jpaAttributeDao.find(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    assertEquals(2, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    AttributeKvEntry getResult2 = actualFindResult.get(1);
    assertTrue(getResult2 instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    KvEntry kv2 = ((BaseAttributeKvEntry) getResult2).getKv();
    assertTrue(kv2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("42", strValue.get());
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("42", kv2.getValueAsString());
    assertEquals("42", getResult2.getValue());
    assertEquals("42", kv2.getValue());
    assertEquals("Key", getResult2.getKey());
    assertEquals("Key", kv2.getKey());
    assertEquals("Str Value", getResult.getStrValue().get());
    assertEquals("Str Value", getResult.getValueAsString());
    assertEquals("Str Value", kv.getValueAsString());
    assertEquals("Str Value", getResult.getValue());
    assertEquals("Str Value", kv.getValue());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(1L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult2.getLastUpdateTs());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertEquals(DataType.STRING, kv2.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv2.getStrValue());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Given {@link AttributeKvCompositeKey#AttributeKvCompositeKey()}
   * AttributeKey is zero.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_givenAttributeKvCompositeKeyAttributeKeyIsZero_thenReturnSizeIsTwo() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity2);
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<AttributeKvEntry> actualFindAllResult = jpaAttributeDao.findAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
    assertEquals(2, actualFindAllResult.size());
    AttributeKvEntry getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    AttributeKvEntry getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    KvEntry kv2 = ((BaseAttributeKvEntry) getResult2).getKv();
    assertTrue(kv2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("42", strValue.get());
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("42", kv2.getValueAsString());
    assertEquals("42", getResult2.getValue());
    assertEquals("42", kv2.getValue());
    assertEquals("Key", getResult2.getKey());
    assertEquals("Key", kv2.getKey());
    assertEquals("Str Value", getResult.getStrValue().get());
    assertEquals("Str Value", getResult.getValueAsString());
    assertEquals("Str Value", kv.getValueAsString());
    assertEquals("Str Value", getResult.getValue());
    assertEquals("Str Value", kv.getValue());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(1L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult2.getLastUpdateTs());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertEquals(DataType.STRING, kv2.getDataType());
    assertTrue(strValue.isPresent());
    assertEquals(strValue, kv2.getStrValue());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) BooleanValue is
   * {@code true}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_givenAttributeKvEntityBooleanValueIsTrue_thenReturnSizeIsOne() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<AttributeKvEntry> actualFindAllResult = jpaAttributeDao.findAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(keyDictionaryDao).getKey(eq(1));
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
    assertEquals(1, actualFindAllResult.size());
    AttributeKvEntry getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertEquals("42", getResult.getStrValue().get());
    assertEquals("42", getResult.getValueAsString());
    assertEquals("42", kv.getValueAsString());
    assertEquals("42", getResult.getValue());
    assertEquals("42", kv.getValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getLastUpdateTs());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryDao}.</li>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_givenKeyDictionaryDao_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AttributeKvEntry> actualFindAllResult = jpaAttributeDao.findAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);
    AttributeKvEntity attributeKvEntity = mock(AttributeKvEntity.class);
    when(attributeKvEntity.toData()).thenThrow(new EmptyResultDataAccessException(3));
    when(attributeKvEntity.getId()).thenReturn(attributeKvCompositeKey);
    doNothing().when(attributeKvEntity).setBooleanValue(Mockito.<Boolean>any());
    doNothing().when(attributeKvEntity).setDoubleValue(Mockito.<Double>any());
    doNothing().when(attributeKvEntity).setId(Mockito.<AttributeKvCompositeKey>any());
    doNothing().when(attributeKvEntity).setJsonValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setLastUpdateTs(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setLongValue(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setStrKey(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setStrValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setVersion(Mockito.<Long>any());
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.findAll(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE));
    verify(entityId).getId();
    verify(keyDictionaryDao).getKey(eq(1));
    verify(attributeKvEntity).getId();
    verify(attributeKvEntity).setBooleanValue(eq(true));
    verify(attributeKvEntity).setDoubleValue(eq(10.0d));
    verify(attributeKvEntity).setId(isA(AttributeKvCompositeKey.class));
    verify(attributeKvEntity).setJsonValue(eq("42"));
    verify(attributeKvEntity).setLastUpdateTs(eq(1L));
    verify(attributeKvEntity).setLongValue(eq(42L));
    verify(attributeKvEntity, atLeast(1)).setStrKey(Mockito.<String>any());
    verify(attributeKvEntity).setStrValue(eq("42"));
    verify(attributeKvEntity).setVersion(eq(1L));
    verify(attributeKvEntity).toData();
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_thenThrowEmptyResultDataAccessException() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);
    AttributeKvEntity attributeKvEntity = mock(AttributeKvEntity.class);
    when(attributeKvEntity.toData()).thenThrow(new EmptyResultDataAccessException(3));
    when(attributeKvEntity.getId()).thenReturn(attributeKvCompositeKey);
    doNothing().when(attributeKvEntity).setBooleanValue(Mockito.<Boolean>any());
    doNothing().when(attributeKvEntity).setDoubleValue(Mockito.<Double>any());
    doNothing().when(attributeKvEntity).setId(Mockito.<AttributeKvCompositeKey>any());
    doNothing().when(attributeKvEntity).setJsonValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setLastUpdateTs(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setLongValue(Mockito.<Long>any());
    doNothing().when(attributeKvEntity).setStrKey(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setStrValue(Mockito.<String>any());
    doNothing().when(attributeKvEntity).setVersion(Mockito.<Long>any());
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    ArrayList<AttributeKvEntity> attributeKvEntityList = new ArrayList<>();
    attributeKvEntityList.add(attributeKvEntity);
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(attributeKvEntityList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class, () -> jpaAttributeDao.findAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE));
    verify(keyDictionaryDao).getKey(eq(1));
    verify(attributeKvEntity).getId();
    verify(attributeKvEntity).setBooleanValue(eq(true));
    verify(attributeKvEntity).setDoubleValue(eq(10.0d));
    verify(attributeKvEntity).setId(isA(AttributeKvCompositeKey.class));
    verify(attributeKvEntity).setJsonValue(eq("42"));
    verify(attributeKvEntity).setLastUpdateTs(eq(1L));
    verify(attributeKvEntity).setLongValue(eq(42L));
    verify(attributeKvEntity, atLeast(1)).setStrKey(Mockito.<String>any());
    verify(attributeKvEntity).setStrValue(eq("42"));
    verify(attributeKvEntity).setVersion(eq(1L));
    verify(attributeKvEntity).toData();
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_givenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertEquals(2, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(1));
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_givenArrayListAddOne_thenReturnSizeIsTwo2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertEquals(2, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(1));
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryDao}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_givenKeyDictionaryDao_whenNull_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(attributeKvRepository.findAllKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, deviceProfileId);

    // Assert
    verify(deviceProfileId).getId();
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByDeviceProfileId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
  }

  /**
   * Test
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}
   */
  @Test
  public void testFindAllKeysByDeviceProfileId_whenNull_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult = jpaAttributeDao
        .findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertEquals(1, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = jpaAttributeDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(2, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryDao}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenKeyDictionaryDao_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = jpaAttributeDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = jpaAttributeDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = jpaAttributeDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_thenThrowEmptyResultDataAccessException() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_whenArrayList_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = jpaAttributeDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(keyDictionaryDao).getKey(eq(2));
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAll_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    List<ListenableFuture<String>> actualRemoveAllResult = jpaAttributeDao.removeAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, keys);

    // Assert
    verify(jpaExecutorService, atLeast(1)).submit(Mockito.<Callable<Object>>any());
    assertEquals(2, actualRemoveAllResult.size());
    ListenableFuture<String> getResult = actualRemoveAllResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
    assertSame(createResult, actualRemoveAllResult.get(1));
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAll_givenJpaExecutorServiceSubmitReturnCreate_thenReturnSizeIsOne() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    List<ListenableFuture<String>> actualRemoveAllResult = jpaAttributeDao.removeAll(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, keys);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertEquals(1, actualRemoveAllResult.size());
    ListenableFuture<String> getResult = actualRemoveAllResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}.</li>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAll_givenJpaExecutorService_whenAlarmId_thenReturnEmpty() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);

    // Act and Assert
    assertTrue(jpaAttributeDao
        .removeAll(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAll_givenJpaExecutorService_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        jpaAttributeDao
            .removeAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE,
                new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithVersions_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    List<ListenableFuture<TbPair<String, Long>>> actualRemoveAllWithVersionsResult = jpaAttributeDao
        .removeAllWithVersions(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE, keys);

    // Assert
    verify(jpaExecutorService, atLeast(1)).submit(Mockito.<Callable<Object>>any());
    assertEquals(2, actualRemoveAllWithVersionsResult.size());
    ListenableFuture<TbPair<String, Long>> getResult = actualRemoveAllWithVersionsResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
    assertSame(createResult, actualRemoveAllWithVersionsResult.get(1));
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}.</li>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithVersions_givenJpaExecutorService_whenAlarmId_thenReturnEmpty() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);

    // Act and Assert
    assertTrue(jpaAttributeDao
        .removeAllWithVersions(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithVersions_givenJpaExecutorService_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        jpaAttributeDao
            .removeAllWithVersions(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE, new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithVersions_thenReturnSizeIsOne() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    List<ListenableFuture<TbPair<String, Long>>> actualRemoveAllWithVersionsResult = jpaAttributeDao
        .removeAllWithVersions(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE, keys);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertEquals(1, actualRemoveAllWithVersionsResult.size());
    ListenableFuture<TbPair<String, Long>> getResult = actualRemoveAllWithVersionsResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_givenNull_uuid_thenCallsGetId() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<Pair<AttributeScope, String>> actualRemoveAllByEntityIdResult = jpaAttributeDao
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
        isA(Object[].class));
    verify(entityId).getId();
    assertTrue(actualRemoveAllByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_thenThrowEmptyResultDataAccessException() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(jdbcTemplate).queryForList(
        eq("DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
        isA(Object[].class));
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_whenNull_customer_id_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class))).thenReturn(new ArrayList<>());

    // Act
    List<Pair<AttributeScope, String>> actualRemoveAllByEntityIdResult = jpaAttributeDao
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate).queryForList(
        eq("DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
        isA(Object[].class));
    assertTrue(actualRemoveAllByEntityIdResult.isEmpty());
  }
}
