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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
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
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAttributeDaoDiffblueTest {
  @MockBean private AttributeKvInsertRepository attributeKvInsertRepository;

  @MockBean private AttributeKvRepository attributeKvRepository;

  @MockBean private DataSource dataSource;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAttributeDao jpaAttributeDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private KeyDictionaryDao keyDictionaryDao;

  @MockBean private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean private StatsFactory statsFactory;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKey}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAttributeDao.find(TenantId, EntityId, AttributeScope, String)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.find(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                "Attribute Key"));
    verify(keyDictionaryDao).getOrSaveKeyId("Attribute Key");
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKey}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAttributeDao.find(TenantId, EntityId, AttributeScope, String)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey2() {
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
    attributeKvEntity.setStrValue("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity.setVersion(1L);
    Optional<AttributeKvEntity> ofResult = Optional.of(attributeKvEntity);
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any()))
        .thenReturn(ofResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Attribute Key");
    AttributeKvEntry getResult = actualFindResult.get();
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertEquals(
        "org.thingsboard.server.dao.model.sql.AttributeKvEntity", getResult.getStrValue().get());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.AttributeKvEntity", getResult.getValueAsString());
    assertEquals("org.thingsboard.server.dao.model.sql.AttributeKvEntity", kv.getValueAsString());
    assertEquals("org.thingsboard.server.dao.model.sql.AttributeKvEntity", getResult.getValue());
    assertEquals("org.thingsboard.server.dao.model.sql.AttributeKvEntity", kv.getValue());
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKey}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} StrValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAttributeDao.find(TenantId, EntityId, AttributeScope, String)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey_thenReturnGetStrValueIs42() {
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
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any()))
        .thenReturn(ofResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Attribute Key");
    AttributeKvEntry getResult = actualFindResult.get();
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) getResult).getKv();
    assertTrue(kv instanceof StringDataEntry);
    assertEquals("42", getResult.getStrValue().get());
    assertEquals("42", getResult.getValueAsString());
    assertEquals("42", kv.getValueAsString());
    assertEquals("42", getResult.getValue());
    assertEquals("42", kv.getValue());
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKey}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAttributeDao.find(TenantId, EntityId, AttributeScope, String)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey_thenReturnNotPresent() {
    // Arrange
    Optional<AttributeKvEntity> emptyResult = Optional.empty();
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any()))
        .thenReturn(emptyResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Attribute Key");
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKey}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAttributeDao.find(TenantId, EntityId, AttributeScope, String)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKey_whenNull_customer_id() {
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
    when(attributeKvRepository.findById(Mockito.<AttributeKvCompositeKey>any()))
        .thenReturn(ofResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    Optional<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            "Attribute Key");

    // Assert
    verify(attributeKvRepository).findById(isA(AttributeKvCompositeKey.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Attribute Key");
    AttributeKvEntry getResult = actualFindResult.get();
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys() {
    // Arrange
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.find(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                new ArrayList<>()));
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys2() {
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
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.find(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                new ArrayList<>()));
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(1);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys3() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.find(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                attributeKeys));
    verify(keyDictionaryDao).getOrSaveKeyId("foo");
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys4() {
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
    attributeKvEntity.setStrKey("");
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

    // Act
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getKey(1);
    verify(keyDictionaryDao).getOrSaveKeyId("foo");
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_given42() {
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
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(1);
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId(Mockito.<String>any());
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenCallsGetId() {
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
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getKey(1);
    verify(keyDictionaryDao).getOrSaveKeyId("foo");
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllById(Mockito.<Iterable<AttributeKvCompositeKey>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
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
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(1);
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
  public void testFindWithTenantIdEntityIdAttributeScopeAttributeKeys_thenReturnSizeIsOne2() {
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
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao).getKey(1);
    verify(keyDictionaryDao).getOrSaveKeyId("foo");
    assertEquals(1, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code attributeScope}, {@code attributeKeys}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.find(TenantId, EntityId, AttributeScope, Collection)"})
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
    List<AttributeKvEntry> actualFindResult =
        jpaAttributeDao.find(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllById(isA(Iterable.class));
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    assertEquals(2, actualFindResult.size());
    AttributeKvEntry getResult = actualFindResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    AttributeKvEntry getResult2 = actualFindResult.get(1);
    assertTrue(getResult2 instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult2).getKv() instanceof StringDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("42", getResult2.getValue());
    assertEquals("Key", getResult2.getKey());
    assertEquals("Str Value", getResult.getValueAsString());
    assertEquals("Str Value", getResult.getValue());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(1L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult2.getLastUpdateTs());
    assertEquals(DataType.STRING, getResult2.getDataType());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll() {
    // Arrange
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE));
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll2() {
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
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE));
    verify(keyDictionaryDao).getKey(1);
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvCompositeKey#AttributeKvCompositeKey()} AttributeKey is minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll_givenAttributeKvCompositeKeyAttributeKeyIsMinusOne() {
    // Arrange
    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(-1);
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
    List<AttributeKvEntry> actualFindAllResult =
        jpaAttributeDao.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(keyDictionaryDao).getKey(-1);
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
   *
   * <ul>
   *   <li>Given {@link AttributeKvCompositeKey#AttributeKvCompositeKey()} AttributeKey is zero.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
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
    List<AttributeKvEntry> actualFindAllResult =
        jpaAttributeDao.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
    assertEquals(2, actualFindAllResult.size());
    AttributeKvEntry getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof BaseAttributeKvEntry);
    AttributeKvEntry getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof BaseAttributeKvEntry);
    assertTrue(((BaseAttributeKvEntry) getResult2).getKv() instanceof StringDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    assertEquals("42", getResult2.getValue());
    assertEquals("Key", getResult2.getKey());
    assertEquals("Str Value", getResult.getValueAsString());
    assertEquals("Str Value", getResult.getValue());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getLastUpdateTs());
    assertEquals(1L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult2.getLastUpdateTs());
    assertEquals(DataType.STRING, getResult2.getDataType());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>Given {@link KeyDictionaryDao} {@link KeyDictionaryDao#getKey(Integer)} return {@code
   *       Key}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll_givenKeyDictionaryDaoGetKeyReturnKey_thenReturnSizeIsOne() {
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
    List<AttributeKvEntry> actualFindAllResult =
        jpaAttributeDao.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(keyDictionaryDao).getKey(1);
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
   *
   * <ul>
   *   <li>Given {@link KeyDictionaryDao}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll_givenKeyDictionaryDao_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllByEntityIdAndAttributeType(Mockito.<UUID>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AttributeKvEntry> actualFindAllResult =
        jpaAttributeDao.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAll(TenantId, EntityId, AttributeScope)"})
  public void testFindAll_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
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
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAll(
                ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE));
    verify(entityId).getId();
    verify(keyDictionaryDao).getKey(1);
    verify(attributeKvRepository).findAllByEntityIdAndAttributeType(isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId() {
    // Arrange
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null));
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null));
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId3() {
    // Arrange
    when(attributeKvRepository.findAllKeysByDeviceProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID)));
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId4() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_givenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertEquals(2, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_givenArrayListAddOne_thenReturnSizeIsTwo2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByDeviceProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertEquals(2, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_givenNull_uuid() {
    // Arrange
    when(attributeKvRepository.findAllKeysByDeviceProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAllKeysByDeviceProfileId(
                ModelConstants.SYSTEM_TENANT, deviceProfileId));
    verify(deviceProfileId).getId();
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty2() {
    // Arrange
    when(attributeKvRepository.findAllKeysByDeviceProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByTenantId(Mockito.<UUID>any())).thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByTenantId(isA(UUID.class));
    assertEquals(1, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByDeviceProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        jpaAttributeDao.findAllKeysByDeviceProfileId(
            ModelConstants.SYSTEM_TENANT, new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByDeviceProfileId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindAllKeysByDeviceProfileIdResult.size());
    assertEquals("Key", actualFindAllKeysByDeviceProfileIdResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds() {
    // Arrange
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAllKeysByEntityIds(
                ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.findAllKeysByEntityIds(
                ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenArrayListAddOne_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(keyDictionaryDao, atLeast(1)).getKey(Mockito.<Integer>any());
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(2, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(1));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link KeyDictionaryDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenKeyDictionaryDao_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero and {@link
   *       BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenZero_whenArrayListAddZeroAndNull_customer_id() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(0, BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds));
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_whenArrayListAddNull_customer_id_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_whenArrayListAddNull_customer_id_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    when(attributeKvRepository.findAllKeysByEntityIds(Mockito.<List<UUID>>any()))
        .thenReturn(integerList);
    when(keyDictionaryDao.getKey(Mockito.<Integer>any())).thenReturn("Key");

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        jpaAttributeDao.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(keyDictionaryDao).getKey(2);
    verify(attributeKvRepository).findAllKeysByEntityIds(isA(List.class));
    assertEquals(1, actualFindAllKeysByEntityIdsResult.size());
    assertEquals("Key", actualFindAllKeysByEntityIdsResult.get(0));
  }

  /**
   * Test {@link JpaAttributeDao#save(TenantId, EntityId, AttributeScope, AttributeKvEntry)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#save(TenantId, EntityId, AttributeScope,
   * AttributeKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAttributeDao.save(TenantId, EntityId, AttributeScope, AttributeKvEntry)"
  })
  public void testSave_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    BaseAttributeKvEntry attribute = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.save(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                attribute));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAll(TenantId, EntityId, AttributeScope, List)"})
  public void testRemoveAll_givenJpaExecutorServiceSubmitReturnCreate_thenReturnSizeIsOne() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("Keys");

    // Act
    List<ListenableFuture<String>> actualRemoveAllResult =
        jpaAttributeDao.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            keys);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertEquals(1, actualRemoveAllResult.size());
    ListenableFuture<String> getResult = actualRemoveAllResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
  }

  /**
   * Test {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope, List)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAll(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAll(TenantId, EntityId, AttributeScope, List)"})
  public void testRemoveAll_givenJpaExecutorService_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        jpaAttributeDao
            .removeAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.removeAllWithVersions(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithVersions_givenJpaExecutorService_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        jpaAttributeDao
            .removeAllWithVersions(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AttributeScope.CLIENT_SCOPE,
                new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId, AttributeScope, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllWithVersions(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaAttributeDao.removeAllWithVersions(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithVersions_thenReturnSizeIsOne() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("Keys");

    // Act
    List<ListenableFuture<TbPair<String, Long>>> actualRemoveAllWithVersionsResult =
        jpaAttributeDao.removeAllWithVersions(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            keys);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertEquals(1, actualRemoveAllWithVersionsResult.size());
    ListenableFuture<TbPair<String, Long>> getResult = actualRemoveAllWithVersionsResult.get(0);
    assertTrue(getResult instanceof SettableFuture);
    assertSame(createResult, getResult);
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaAttributeDao.removeAllByEntityId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId2() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(0));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.removeAllByEntityId(null, entityId));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
            isA(Object[].class));
    verify(entityId).getId();
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId_thenCallsGetId() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaAttributeDao.removeAllByEntityId(ModelConstants.SYSTEM_TENANT, entityId));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
            isA(Object[].class));
    verify(entityId).getId();
  }

  /**
   * Test {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAttributeDao#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAttributeDao.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<Pair<AttributeScope, String>> actualRemoveAllByEntityIdResult =
        jpaAttributeDao.removeAllByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM attribute_kv WHERE entity_id = ? RETURNING attribute_type, attribute_key"),
            isA(Object[].class));
    assertTrue(actualRemoveAllByEntityIdResult.isEmpty());
  }
}
