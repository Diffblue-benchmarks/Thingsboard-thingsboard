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
package org.thingsboard.server.dao.sql.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EntityViewEntity;
import org.thingsboard.server.dao.model.sql.EntityViewInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaEntityViewDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaEntityViewDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private EntityViewRepository entityViewRepository;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaEntityViewDao jpaEntityViewDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaEntityViewDao#getEntityClass()}
   *   <li>{@link JpaEntityViewDao#getEntityType()}
   *   <li>{@link JpaEntityViewDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaEntityViewDao.getEntityClass()",
    "EntityType JpaEntityViewDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaEntityViewDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaEntityViewDao jpaEntityViewDao = new JpaEntityViewDao();

    // Act
    Class<EntityViewEntity> actualEntityClass = jpaEntityViewDao.getEntityClass();
    EntityType actualEntityType = jpaEntityViewDao.getEntityType();

    // Assert
    assertNull(jpaEntityViewDao.getRepository());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityType);
    Class<EntityViewEntity> expectedEntityClass = EntityViewEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo JpaEntityViewDao.findEntityViewInfoById(TenantId, UUID)"})
  public void testFindEntityViewInfoById_thenAdditionalInfoReturnNullNode() {
    // Arrange
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any()))
        .thenReturn(new EntityViewInfoEntity());

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        jpaEntityViewDao.findEntityViewInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertTrue(actualFindEntityViewInfoByIdResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualFindEntityViewInfoByIdResult.getVersion());
    assertNull(actualFindEntityViewInfoByIdResult.getName());
    assertNull(actualFindEntityViewInfoByIdResult.getType());
    assertNull(actualFindEntityViewInfoByIdResult.getCustomerTitle());
    assertNull(actualFindEntityViewInfoByIdResult.getUuidId());
    assertNull(actualFindEntityViewInfoByIdResult.getCustomerId());
    assertNull(actualFindEntityViewInfoByIdResult.getEntityId());
    assertNull(actualFindEntityViewInfoByIdResult.getExternalId());
    assertNull(actualFindEntityViewInfoByIdResult.getKeys());
    assertEquals(0L, actualFindEntityViewInfoByIdResult.getCreatedTime());
    assertEquals(0L, actualFindEntityViewInfoByIdResult.getEndTimeMs());
    assertEquals(0L, actualFindEntityViewInfoByIdResult.getStartTimeMs());
    assertFalse(actualFindEntityViewInfoByIdResult.isCustomerIsPublic());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo JpaEntityViewDao.findEntityViewInfoById(TenantId, UUID)"})
  public void testFindEntityViewInfoById_thenReturnNull() {
    // Arrange
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        jpaEntityViewDao.findEntityViewInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertNull(actualFindEntityViewInfoByIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo JpaEntityViewDao.findEntityViewInfoById(TenantId, UUID)"})
  public void testFindEntityViewInfoById_thenReturnTenantIdIsNull() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any()))
        .thenReturn(entityViewInfoEntity);
    UUID entityViewId = ModelConstants.NULL_UUID;

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        jpaEntityViewDao.findEntityViewInfoById(ModelConstants.SYSTEM_TENANT, entityViewId);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertNull(actualFindEntityViewInfoByIdResult.getTenantId());
    CustomerId customerId = actualFindEntityViewInfoByIdResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertSame(entityViewId, customerId.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewInfo JpaEntityViewDao.findEntityViewInfoById(TenantId, UUID)"})
  public void testFindEntityViewInfoById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any()))
        .thenReturn(entityViewInfoEntity);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult =
        jpaEntityViewDao.findEntityViewInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindEntityViewInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewsByTenantId(UUID, PageLink)"})
  public void testFindEntityViewsByTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult =
        jpaEntityViewDao.findEntityViewsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewsByTenantId(UUID, PageLink)"})
  public void testFindEntityViewsByTenantId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult =
        jpaEntityViewDao.findEntityViewsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewsByTenantId(UUID, PageLink)"})
  public void testFindEntityViewsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult =
        jpaEntityViewDao.findEntityViewsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewsByTenantId(UUID, PageLink)"})
  public void testFindEntityViewsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult =
        jpaEntityViewDao.findEntityViewsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewInfoEntity#EntityViewInfoEntity()} CustomerId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_givenEntityViewInfoEntityCustomerIdIsNull_uuid() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_thenReturnDataFirstCustomerIdIsNull() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EntityViewInfo#EntityViewInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_thenReturnDataFirstIsEntityViewInfo() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findEntityViewInfosByTenantId(UUID, PageLink)"})
  public void testFindEntityViewInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findEntityViewInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndType2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnDataFirstCustomerIdIsNull() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EntityViewInfo#EntityViewInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnDataFirstIsEntityViewInfo() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEntityViewDao.findEntityViewByTenantIdAndName(UUID, String)"})
  public void testFindEntityViewByTenantIdAndName() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    Optional<EntityView> actualFindEntityViewByTenantIdAndNameResult =
        jpaEntityViewDao.findEntityViewByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    EntityView getResult = actualFindEntityViewByTenantIdAndNameResult.get();
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEntityViewDao.findEntityViewByTenantIdAndName(UUID, String)"})
  public void testFindEntityViewByTenantIdAndName2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    Optional<EntityView> actualFindEntityViewByTenantIdAndNameResult =
        jpaEntityViewDao.findEntityViewByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    EntityView getResult = actualFindEntityViewByTenantIdAndNameResult.get();
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId3() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId4() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID,
   * UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(
        0L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(
        0L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data =
        actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(
        1L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType5() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data =
        actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType6() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    entityViewInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data =
        actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType7() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEntityViewDao.findEntityViewInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository)
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data =
        actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(UUID, UUID)"})
  public void testFindEntityViewsByTenantIdAndEntityId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> entityViewEntityList = new ArrayList<>();
    entityViewEntityList.add(entityViewEntity);
    when(entityViewRepository.findAllByTenantIdAndEntityId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntityList);

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindEntityViewsByTenantIdAndEntityIdResult.size());
    EntityView getResult = actualFindEntityViewsByTenantIdAndEntityIdResult.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(UUID, UUID)"})
  public void testFindEntityViewsByTenantIdAndEntityId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> entityViewEntityList = new ArrayList<>();
    entityViewEntityList.add(entityViewEntity);
    when(entityViewRepository.findAllByTenantIdAndEntityId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntityList);

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindEntityViewsByTenantIdAndEntityIdResult.size());
    EntityView getResult = actualFindEntityViewsByTenantIdAndEntityIdResult.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(UUID, UUID)"})
  public void testFindEntityViewsByTenantIdAndEntityId_thenReturnEmpty() {
    // Arrange
    when(entityViewRepository.findAllByTenantIdAndEntityId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindEntityViewsByTenantIdAndEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaEntityViewDao.existsByTenantIdAndEntityId(UUID, UUID)"})
  public void testExistsByTenantIdAndEntityId_thenReturnFalse() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult =
        jpaEntityViewDao.existsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaEntityViewDao.existsByTenantIdAndEntityId(UUID, UUID)"})
  public void testExistsByTenantIdAndEntityId_thenReturnTrue() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult =
        jpaEntityViewDao.existsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findTenantEntityViewTypesAsync(UUID)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findTenantEntityViewTypesAsync(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaEntityViewDao.findTenantEntityViewTypesAsync(UUID)"})
  public void testFindTenantEntityViewTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantEntityViewTypesAsyncResult =
        jpaEntityViewDao.findTenantEntityViewTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantEntityViewTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantEntityViewTypesAsyncResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(3L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(3L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setName(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(3L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(3L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(3L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(3L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setName(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(3L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType(
        "Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(3L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(4L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(4L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setName(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(4L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(4L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(4L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(4L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setName(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(4L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType(
        "Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(4L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult =
        jpaEntityViewDao.findEntityViewsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView JpaEntityViewDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndExternalIdResult =
        jpaEntityViewDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    EntityId entityId = actualFindByTenantIdAndExternalIdResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualFindByTenantIdAndExternalIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView JpaEntityViewDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndExternalIdResult =
        jpaEntityViewDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    EntityId entityId2 = actualFindByTenantIdAndExternalIdResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindByTenantIdResult =
        jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindByTenantIdResult =
        jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntityView> actualFindByTenantIdResult =
        jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEntityViewDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindByTenantIdResult =
        jpaEntityViewDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)} with {@code EntityViewId}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewId JpaEntityViewDao.getExternalIdByInternal(EntityViewId)"})
  public void testGetExternalIdByInternalWithEntityViewId() {
    // Arrange
    when(entityViewRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    EntityViewId internalId = new EntityViewId(ModelConstants.NULL_UUID);

    // Act
    EntityViewId actualExternalIdByInternal = jpaEntityViewDao.getExternalIdByInternal(internalId);

    // Assert
    verify(entityViewRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)} with {@code EntityViewId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewId JpaEntityViewDao.getExternalIdByInternal(EntityViewId)"})
  public void testGetExternalIdByInternalWithEntityViewId_thenReturnNull() {
    // Arrange
    when(entityViewRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EntityViewId actualExternalIdByInternal =
        jpaEntityViewDao.getExternalIdByInternal(new EntityViewId(ModelConstants.NULL_UUID));

    // Assert
    verify(entityViewRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView JpaEntityViewDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndNameResult =
        jpaEntityViewDao.findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    EntityId entityId = actualFindByTenantIdAndNameResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualFindByTenantIdAndNameResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView JpaEntityViewDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndNameResult =
        jpaEntityViewDao.findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    EntityId entityId2 = actualFindByTenantIdAndNameResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }
}
