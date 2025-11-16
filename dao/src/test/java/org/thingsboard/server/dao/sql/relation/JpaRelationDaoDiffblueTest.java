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
package org.thingsboard.server.dao.sql.relation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
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
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RelationCompositeKey;
import org.thingsboard.server.dao.model.sql.RelationEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRelationDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRelationDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaRelationDao jpaRelationDao;

  @MockBean private RelationInsertRepository relationInsertRepository;

  @MockBean private RelationRepository relationRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code from}, {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByFromWithTenantIdFromTypeGroup() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByFrom(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("COMMON"));
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code from}, {@code typeGroup}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByFromWithTenantIdFromTypeGroup_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT, from, RelationTypeGroup.COMMON);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code from}, {@code typeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByFromWithTenantIdFromTypeGroup_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code from}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByFromWithTenantIdFromTypeGroup_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("COMMON"));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with {@code tenantId}, {@code
   * from}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId)"})
  public void testFindAllByFromWithTenantIdFrom_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT, from);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("TENANT"), isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with {@code tenantId}, {@code
   * from}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId)"})
  public void testFindAllByFromWithTenantIdFrom_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("TENANT"), isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with {@code tenantId}, {@code
   * from}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId)"})
  public void testFindAllByFromWithTenantIdFrom_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByFrom(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("CUSTOMER"), isA(List.class));
  }

  /**
   * Test {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)} with {@code tenantId}, {@code
   * from}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFrom(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByFrom(TenantId, EntityId)"})
  public void testFindAllByFromWithTenantIdFrom_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromResult =
        jpaRelationDao.findAllByFrom(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("CUSTOMER"), isA(List.class));
    assertTrue(actualFindAllByFromResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByFromAndType_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult =
        jpaRelationDao.findAllByFromAndType(
            ModelConstants.SYSTEM_TENANT, from, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(from).getEntityType();
    verify(from).getId();
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByFromAndType_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult =
        jpaRelationDao.findAllByFromAndType(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByFromAndType_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByFromAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
  }

  /**
   * Test {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByFromAndType_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByFromAndTypeResult =
        jpaRelationDao.findAllByFromAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByFromIdAndFromTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByFromAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code to}, {@code typeGroup}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByToWithTenantIdToTypeGroup_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(
            ModelConstants.SYSTEM_TENANT, resultTo, RelationTypeGroup.COMMON);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code to}, {@code typeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByToWithTenantIdToTypeGroup_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("TENANT"), eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code to}, {@code typeGroup}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByToWithTenantIdToTypeGroup_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByTo(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("CUSTOMER"), eq("COMMON"));
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)} with {@code
   * tenantId}, {@code to}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindAllByToWithTenantIdToTypeGroup_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroup(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroup(isA(UUID.class), eq("CUSTOMER"), eq("COMMON"));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with {@code tenantId}, {@code to}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId)"})
  public void testFindAllByToWithTenantIdTo_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT, resultTo);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("TENANT"), isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with {@code tenantId}, {@code to}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId)"})
  public void testFindAllByToWithTenantIdTo_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("TENANT"), isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with {@code tenantId}, {@code to}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId)"})
  public void testFindAllByToWithTenantIdTo_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByTo(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("CUSTOMER"), isA(List.class));
  }

  /**
   * Test {@link JpaRelationDao#findAllByTo(TenantId, EntityId)} with {@code tenantId}, {@code to}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByTo(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findAllByTo(TenantId, EntityId)"})
  public void testFindAllByToWithTenantIdTo_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeGroupIn(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToResult =
        jpaRelationDao.findAllByTo(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeGroupIn(
            isA(UUID.class), eq("CUSTOMER"), isA(List.class));
    assertTrue(actualFindAllByToResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByToAndType_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult =
        jpaRelationDao.findAllByToAndType(
            ModelConstants.SYSTEM_TENANT, resultTo, "Relation Type", RelationTypeGroup.COMMON);

    // Assert
    verify(resultTo).getEntityType();
    verify(resultTo).getId();
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByToAndType_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult =
        jpaRelationDao.findAllByToAndType(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("TENANT"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByToAndType_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.findAllByToAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
  }

  /**
   * Test {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.findAllByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindAllByToAndType_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindAllByToAndTypeResult =
        jpaRelationDao.findAllByToAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository)
        .findAllByToIdAndToTypeAndRelationTypeAndRelationTypeGroup(
            isA(UUID.class), eq("CUSTOMER"), eq("Relation Type"), eq("COMMON"));
    assertTrue(actualFindAllByToAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualCheckRelationAsyncResult =
        jpaRelationDao.checkRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualCheckRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualCheckRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            from,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenNull_uuid_thenCallsGetEntityType2() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            from,
            ModelConstants.SYSTEM_TENANT,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
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
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            from,
            resultTo,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationRepository} {@link RelationRepository#existsById(Object)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationRepositoryExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(false);

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            from,
            resultTo,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
    assertFalse(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_whenNull_customer_id_thenReturnTrue() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    // Act
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaRelationDao.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_whenNull_customer_id_thenReturnTrue2() {
    // Arrange
    when(relationRepository.existsById(Mockito.<RelationCompositeKey>any())).thenReturn(true);

    // Act
    boolean actualCheckRelationResult =
        jpaRelationDao.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationRepository).existsById(isA(RelationCompositeKey.class));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(relationRepository.findById(Mockito.<RelationCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.getRelation(
                ModelConstants.SYSTEM_TENANT,
                from,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository).findById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(from).getId();
  }

  /**
   * Test {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_givenNull_uuid_thenCallsGetEntityType2() {
    // Arrange
    when(relationRepository.findById(Mockito.<RelationCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.getRelation(
                ModelConstants.SYSTEM_TENANT,
                from,
                resultTo,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository).findById(isA(RelationCompositeKey.class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
  }

  /**
   * Test {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findById(Mockito.<RelationCompositeKey>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationRepository).findById(isA(RelationCompositeKey.class));
  }

  /**
   * Test {@link JpaRelationDao#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation JpaRelationDao.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<RelationEntity>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relationInsertRepository).saveOrUpdate(isA(RelationEntity.class));
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.saveRelations(TenantId, List)"})
  public void testSaveRelations() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.saveRelations(TenantId, List)"})
  public void testSaveRelations2() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityRelation> relations = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult =
        jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation#EntityRelation()} TypeGroup is {@code COMMON}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenEntityRelationTypeGroupIsCommon_thenReturnEmpty() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any()))
        .thenReturn(new ArrayList<>());

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    List<EntityRelation> actualSaveRelationsResult =
        jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link JpaRelationDao} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenJpaRelationDao_thenCallsGetId() {
    // Arrange
    JpaRelationDao jpaRelationDao = new JpaRelationDao();

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenThrow(new EmptyResultDataAccessException(3));

    EntityRelation entityRelation = new EntityRelation(mock(EntityId.class), resultTo, "Type");
    entityRelation.setTypeGroup(RelationTypeGroup.DASHBOARD);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(resultTo).getId();
  }

  /**
   * Test {@link JpaRelationDao#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.saveRelations(TenantId, List)"})
  public void testSaveRelations_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(relationInsertRepository.saveOrUpdate(Mockito.<List<RelationEntity>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualSaveRelationsResult =
        jpaRelationDao.saveRelations(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(relationInsertRepository).saveOrUpdate(isA(List.class));
    assertTrue(actualSaveRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaRelationDao.saveRelationAsync(TenantId, EntityRelation)"})
  public void testSaveRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualSaveRelationAsyncResult =
        jpaRelationDao.saveRelationAsync(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualSaveRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetEntityType()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                from,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
    verify(from).getEntityType();
    verify(from).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetEntityType2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                from,
                ModelConstants.SYSTEM_TENANT,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
    verify(from).getEntityType();
    verify(from).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetEntityType3()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(resultTo.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                from,
                resultTo,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
    verify(from).getEntityType();
    verify(resultTo).getEntityType();
    verify(from).getId();
    verify(resultTo).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)} with {@code tenantId},
   * {@code relation}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation JpaRelationDao.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_thenThrowEmptyResultDataAccessException()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.query(
            Mockito.<String>any(), Mockito.<ResultSetExtractor<Object>>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

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

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(jdbcTemplate)
        .query(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND to_id = ? AND to_type = ? AND relation_type = ? AND relation_type_group = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(ResultSetExtractor.class),
            isA(Object[].class));
    verify(resultTo).getEntityType();
    verify(from).getEntityType();
    verify(resultTo).getId();
    verify(from).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup3() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            from,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup4() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    AlarmId from = mock(AlarmId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(from.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            from,
            ModelConstants.SYSTEM_TENANT,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(from).getEntityType();
    verify(from).getId();
    assertTrue(actualDeleteRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualDeleteRelationAsyncResult);
  }

  /**
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
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
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            from,
            resultTo,
            "Relation Type",
            RelationTypeGroup.COMMON);

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
   * Test {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaRelationDao.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_thenReturnSettableFuture() {
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
    ListenableFuture<EntityRelation> actualDeleteRelationAsyncResult =
        jpaRelationDao.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

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
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId)"})
  public void testDeleteOutboundRelationsWithTenantIdEntity() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteOutboundRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteOutboundRelations(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entity = mock(AlarmId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteOutboundRelations(
                ModelConstants.SYSTEM_TENANT, entity, RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult =
        jpaRelationDao.deleteOutboundRelations(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteOutboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult =
        jpaRelationDao.deleteOutboundRelations(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId)"})
  public void testDeleteOutboundRelationsWithTenantIdEntity_thenCallsGetEntityType()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entity = mock(AlarmId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.deleteOutboundRelations(ModelConstants.SYSTEM_TENANT, entity));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId)"})
  public void testDeleteOutboundRelationsWithTenantIdEntity_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult =
        jpaRelationDao.deleteOutboundRelations(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteOutboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteOutboundRelations(TenantId, EntityId)"})
  public void testDeleteOutboundRelationsWithTenantIdEntity_thenReturnEmpty2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteOutboundRelationsResult =
        jpaRelationDao.deleteOutboundRelations(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE from_id = ? AND from_type = ? RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteOutboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteInboundRelations(TenantId, EntityId)"})
  public void testDeleteInboundRelationsWithTenantIdEntity() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteInboundRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteInboundRelations(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entity = mock(AlarmId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () ->
            jpaRelationDao.deleteInboundRelations(
                ModelConstants.SYSTEM_TENANT, entity, RelationTypeGroup.COMMON));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult =
        jpaRelationDao.deleteInboundRelations(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)} with
   * {@code tenantId}, {@code entity}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRelationDao.deleteInboundRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteInboundRelationsWithTenantIdEntityRelationTypeGroup_thenReturnEmpty2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult =
        jpaRelationDao.deleteInboundRelations(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, RelationTypeGroup.COMMON);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteInboundRelations(TenantId, EntityId)"})
  public void testDeleteInboundRelationsWithTenantIdEntity_thenCallsGetEntityType()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new EmptyResultDataAccessException(3));

    AlarmId entity = mock(AlarmId.class);
    when(entity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entity.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.deleteInboundRelations(ModelConstants.SYSTEM_TENANT, entity));
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    verify(entity).getEntityType();
    verify(entity).getId();
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteInboundRelations(TenantId, EntityId)"})
  public void testDeleteInboundRelationsWithTenantIdEntity_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult =
        jpaRelationDao.deleteInboundRelations(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)} with {@code tenantId},
   * {@code entity}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#deleteInboundRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.deleteInboundRelations(TenantId, EntityId)"})
  public void testDeleteInboundRelationsWithTenantIdEntity_thenReturnEmpty2()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.queryForList(Mockito.<String>any(), isA(Object[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualDeleteInboundRelationsResult =
        jpaRelationDao.deleteInboundRelations(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(jdbcTemplate)
        .queryForList(
            eq(
                "DELETE FROM relation WHERE to_id = ? AND to_type = ? AND relation_type_group IN (?, ?, ?, ?, ?, ?)RETURNING from_id, from_type, to_id, to_type, relation_type, relation_type_group, nextval('relation_version_seq') as version"),
            isA(Object[].class));
    assertTrue(actualDeleteInboundRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findRuleNodeToRuleChainRelations(RuleChainType, int)"})
  public void testFindRuleNodeToRuleChainRelations_thenReturnEmpty() {
    // Arrange
    when(relationRepository.findRuleNodeToRuleChainRelations(
            Mockito.<RuleChainType>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindRuleNodeToRuleChainRelationsResult =
        jpaRelationDao.findRuleNodeToRuleChainRelations(RuleChainType.CORE, 1);

    // Assert
    verify(relationRepository)
        .findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), isA(Pageable.class));
    assertTrue(actualFindRuleNodeToRuleChainRelationsResult.isEmpty());
  }

  /**
   * Test {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType, int)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRelationDao#findRuleNodeToRuleChainRelations(RuleChainType,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRelationDao.findRuleNodeToRuleChainRelations(RuleChainType, int)"})
  public void testFindRuleNodeToRuleChainRelations_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(relationRepository.findRuleNodeToRuleChainRelations(
            Mockito.<RuleChainType>any(), Mockito.<Pageable>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> jpaRelationDao.findRuleNodeToRuleChainRelations(RuleChainType.CORE, 1));
    verify(relationRepository)
        .findRuleNodeToRuleChainRelations(eq(RuleChainType.CORE), isA(Pageable.class));
  }
}
