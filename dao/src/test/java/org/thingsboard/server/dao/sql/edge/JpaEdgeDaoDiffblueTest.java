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
package org.thingsboard.server.dao.sql.edge;

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
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EdgeEntity;
import org.thingsboard.server.dao.model.sql.EdgeInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaEdgeDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaEdgeDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EdgeRepository edgeRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaEdgeDao jpaEdgeDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaEdgeDao#getEntityClass()}
   *   <li>{@link JpaEdgeDao#getEntityType()}
   *   <li>{@link JpaEdgeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaEdgeDao.getEntityClass()",
    "EntityType JpaEdgeDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaEdgeDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaEdgeDao jpaEdgeDao = new JpaEdgeDao();

    // Act
    Class<EdgeEntity> actualEntityClass = jpaEdgeDao.getEntityClass();
    EntityType actualEntityType = jpaEdgeDao.getEntityType();

    // Assert
    assertNull(jpaEdgeDao.getRepository());
    assertEquals(EntityType.EDGE, actualEntityType);
    Class<EdgeEntity> expectedEntityClass = EdgeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()} CustomerId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo JpaEdgeDao.findEdgeInfoById(TenantId, UUID)"})
  public void testFindEdgeInfoById_givenEdgeInfoEntityCustomerIdIsNull_uuid() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(edgeInfoEntity);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertTrue(actualFindEdgeInfoByIdResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualFindEdgeInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity} {@link EdgeInfoEntity#toData()} return {@link
   *       EdgeInfo#EdgeInfo()}.
   *   <li>Then return {@link EdgeInfo#EdgeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo JpaEdgeDao.findEdgeInfoById(TenantId, UUID)"})
  public void testFindEdgeInfoById_givenEdgeInfoEntityToDataReturnEdgeInfo_thenReturnEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(edgeInfoEntity);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertSame(edgeInfo, actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo JpaEdgeDao.findEdgeInfoById(TenantId, UUID)"})
  public void testFindEdgeInfoById_thenReturnCustomerIdIsNull() {
    // Arrange
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(new EdgeInfoEntity());

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertTrue(actualFindEdgeInfoByIdResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualFindEdgeInfoByIdResult.getCustomerId());
    assertNull(actualFindEdgeInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo JpaEdgeDao.findEdgeInfoById(TenantId, UUID)"})
  public void testFindEdgeInfoById_thenReturnNull() {
    // Arrange
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertNull(actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo JpaEdgeDao.findEdgeInfoById(TenantId, UUID)"})
  public void testFindEdgeInfoById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(edgeInfoEntity);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindEdgeInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantId(UUID, PageLink)"})
  public void testFindEdgesByTenantId_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        jpaEdgeDao.findEdgesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantId(UUID, PageLink)"})
  public void testFindEdgesByTenantId_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        jpaEdgeDao.findEdgesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantId(UUID, PageLink)"})
  public void testFindEdgesByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        jpaEdgeDao.findEdgesByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantId(UUID, PageLink)"})
  public void testFindEdgesByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        jpaEdgeDao.findEdgesByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaEdgeDao.findEdgesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindEdgesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaEdgeDao.findEdgesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindEdgesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaEdgeDao.findEdgesByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindEdgesByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)"})
  public void testFindEdgesByTenantIdAndCustomerId_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)"})
  public void testFindEdgesByTenantIdAndCustomerId_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)"})
  public void testFindEdgesByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)"})
  public void testFindEdgesByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        jpaEdgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEdgeDao.findEdgeByTenantIdAndName(UUID, String)"})
  public void testFindEdgeByTenantIdAndName_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindEdgeByTenantIdAndNameResult =
        jpaEdgeDao.findEdgeByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(edgeRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Edge getResult = actualFindEdgeByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindEdgeByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEdgeDao.findEdgeByTenantIdAndName(UUID, String)"})
  public void testFindEdgeByTenantIdAndName_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindEdgeByTenantIdAndNameResult =
        jpaEdgeDao.findEdgeByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(edgeRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Edge getResult = actualFindEdgeByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindEdgeByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgesByTenantIdAndType_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgesByTenantIdAndType_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgesByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgesByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId2() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnDataFirstCustomerIdIsNull() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findTenantEdgeTypesAsync(UUID)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findTenantEdgeTypesAsync(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaEdgeDao.findTenantEdgeTypesAsync(UUID)"})
  public void testFindTenantEdgeTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantEdgeTypesAsyncResult =
        jpaEdgeDao.findTenantEdgeTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantEdgeTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantEdgeTypesAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()} CustomerId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_givenEdgeInfoEntityCustomerIdIsNull_uuid() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_thenReturnDataFirstCustomerIdIsNull() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindEdgeInfosByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        jpaEdgeDao.findEdgeInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId = data.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeInfoEntity#EdgeInfoEntity()} CustomerId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenEdgeInfoEntityCustomerIdIsNull_uuid() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    edgeInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_thenReturnDataFirstCustomerIdIsNull() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository)
        .findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgeInfosByTenantId(UUID, PageLink)"})
  public void testFindEdgeInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        jpaEdgeDao.findEdgeInfosByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findByRoutingKey(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findByRoutingKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEdgeDao.findByRoutingKey(UUID, String)"})
  public void testFindByRoutingKey_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByRoutingKey(Mockito.<String>any())).thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindByRoutingKeyResult =
        jpaEdgeDao.findByRoutingKey(tenantId, "Routing Key");

    // Assert
    verify(edgeRepository).findByRoutingKey("Routing Key");
    Edge getResult = actualFindByRoutingKeyResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindByRoutingKeyResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findByRoutingKey(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findByRoutingKey(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaEdgeDao.findByRoutingKey(UUID, String)"})
  public void testFindByRoutingKey_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByRoutingKey(Mockito.<String>any())).thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindByRoutingKeyResult =
        jpaEdgeDao.findByRoutingKey(tenantId, "Routing Key");

    // Assert
    verify(edgeRepository).findByRoutingKey("Routing Key");
    Edge getResult = actualFindByRoutingKeyResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindByRoutingKeyResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(4L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setName(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setSecret(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(4L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID entityId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getRoutingKey());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getSecret());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getType());
    assertEquals(1L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(entityId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(4L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setName(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setSecret(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(4L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID entityId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getRoutingKey());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getSecret());
    assertEquals(
        "Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getType());
    assertEquals(1L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(entityId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgesByTenantIdAndEntityId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID,
   * EntityType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgeIdsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgeIdsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID,
   * EntityType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(edgeRepository.findIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID entityId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository)
        .findIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"), isA(Pageable.class));
    List<EdgeId> data = actualFindEdgeIdsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    EdgeId getResult = data.get(0);
    assertEquals(EntityType.EDGE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(entityId, getResult.getId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID,
   * EntityType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            EntityType.TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository)
        .findIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgeIdsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgeIdsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantProfileId(UUID, PageLink)"})
  public void testFindEdgesByTenantProfileId_givenEdgeEntityTenantIdIsNull_uuid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setName("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setSecret("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantProfileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        jpaEdgeDao.findEdgesByTenantProfileId(tenantProfileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantProfileIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getLabel());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getRoutingKey());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getSecret());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertSame(tenantProfileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantProfileId(UUID, PageLink)"})
  public void testFindEdgesByTenantProfileId_givenEdgeEntityTenantIdIsRandomUUID() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setName("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setSecret("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setTenantId(UUID.randomUUID());
    edgeEntity.setType("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantProfileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        jpaEdgeDao.findEdgesByTenantProfileId(tenantProfileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantProfileIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getLabel());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getRoutingKey());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getSecret());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertSame(tenantProfileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantProfileId(UUID, PageLink)"})
  public void testFindEdgesByTenantProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        jpaEdgeDao.findEdgesByTenantProfileId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantProfileIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantProfileIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaEdgeDao.findEdgesByTenantProfileId(UUID, PageLink)"})
  public void testFindEdgesByTenantProfileId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        jpaEdgeDao.findEdgesByTenantProfileId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantProfileIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantProfileIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantProfileIdResult.getData().isEmpty());
  }
}
