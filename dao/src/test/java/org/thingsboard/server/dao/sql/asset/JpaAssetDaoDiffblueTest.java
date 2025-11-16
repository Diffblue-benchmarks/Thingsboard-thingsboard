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
package org.thingsboard.server.dao.sql.asset;

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
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetEntity;
import org.thingsboard.server.dao.model.sql.AssetInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAssetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAssetDaoDiffblueTest {
  @MockBean private AssetProfileRepository assetProfileRepository;

  @MockBean private AssetRepository assetRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAssetDao jpaAssetDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAssetDao#getEntityClass()}
   *   <li>{@link JpaAssetDao#getEntityType()}
   *   <li>{@link JpaAssetDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAssetDao.getEntityClass()",
    "EntityType JpaAssetDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAssetDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetDao jpaAssetDao = new JpaAssetDao();

    // Act
    Class<AssetEntity> actualEntityClass = jpaAssetDao.getEntityClass();
    EntityType actualEntityType = jpaAssetDao.getEntityType();

    // Assert
    assertNull(jpaAssetDao.getRepository());
    assertEquals(EntityType.ASSET, actualEntityType);
    Class<AssetEntity> expectedEntityClass = AssetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return AssetProfileName is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnAssetProfileNameIsFooTxt() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertTrue(actualFindAssetInfoByIdResult.getAdditionalInfo() instanceof NullNode);
    assertEquals("foo.txt", actualFindAssetInfoByIdResult.getAssetProfileName());
    assertNull(actualFindAssetInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return AssetProfileName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnAssetProfileNameIsNull() {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(new AssetInfoEntity());

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertTrue(actualFindAssetInfoByIdResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualFindAssetInfoByIdResult.getAssetProfileName());
    assertNull(actualFindAssetInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnNull() {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertNull(actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindAssetInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantId(UUID, PageLink)"})
  public void testFindAssetsByTenantId_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        jpaAssetDao.findAssetsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantId(UUID, PageLink)"})
  public void testFindAssetsByTenantId_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        jpaAssetDao.findAssetsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantId(UUID, PageLink)"})
  public void testFindAssetsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(
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
    PageData<Asset> actualFindAssetsByTenantIdResult =
        jpaAssetDao.findAssetsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantId(UUID, PageLink)"})
  public void testFindAssetsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        jpaAssetDao.findAssetsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_givenAssetInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_thenDataFirstAdditionalInfoReturnNullNode() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
    assertEquals(1L, actualFindAssetInfosByTenantIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first CustomerId EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_thenReturnDataFirstCustomerIdEntityTypeIsCustomer() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    when(assetInfoEntity.toData()).thenReturn(new AssetInfo());

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity2.setTenantId(tenantId);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId2 = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(tenantId2, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(2, data.size());
    AssetInfo getResult = data.get(0);
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(customerId.isNullUid());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, customerId.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_thenReturnTotalElementsIsTwo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(UUID.randomUUID());

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetInfosByTenantId(UUID, PageLink)"})
  public void testFindAssetInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        jpaAssetDao.findAssetInfosByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAssetDao.findAssetsByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindAssetsByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAssetDao.findAssetsByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindAssetsByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAssetDao.findAssetsByTenantIdAndIdsAsync(UUID, List)"})
  public void testFindAssetsByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerId_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerId_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerId(
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
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    when(assetInfoEntity.toData()).thenReturn(new AssetInfo());

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity2.setTenantId(tenantId);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(2, data.size());
    AssetInfo getResult = data.get(0);
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(customerId2.isNullUid());
    assertSame(tenantId, tenantId2.getId());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId_givenArrayListAddNull() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsTwo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(UUID.randomUUID());

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID,
   * UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAssetDao.findAssetsByTenantIdAndName(UUID, String)"})
  public void testFindAssetsByTenantIdAndName_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Asset> actualFindAssetsByTenantIdAndNameResult =
        jpaAssetDao.findAssetsByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Asset getResult = actualFindAssetsByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindAssetsByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaAssetDao.findAssetsByTenantIdAndName(UUID, String)"})
  public void testFindAssetsByTenantIdAndName_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Asset> actualFindAssetsByTenantIdAndNameResult =
        jpaAssetDao.findAssetsByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Asset getResult = actualFindAssetsByTenantIdAndNameResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindAssetsByTenantIdAndNameResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindAssetsByTenantIdAndType_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindAssetsByTenantIdAndType_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindAssetsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndType(
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
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndType(UUID, String, PageLink)"})
  public void testFindAssetsByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_givenArrayListAddNull() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_givenAssetInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_givenAssetInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(UUID.randomUUID());

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_thenDataFirstAdditionalInfoReturnNullNode() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndType(UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndType(
            ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantIdAndType(
            isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getCustomerId());
    assertNull(getResult.getTenantId());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    when(assetInfoEntity.toData()).thenReturn(new AssetInfo());

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity2.setTenantId(tenantId);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID assetProfileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, assetProfileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(2, data.size());
    AssetInfo getResult = data.get(0);
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(customerId.isNullUid());
    assertSame(tenantId, tenantId2.getId());
    assertSame(assetProfileId, customerId.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId_givenArrayListAddNull() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsTwo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(UUID.randomUUID());

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndType() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndType_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID customerId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertSame(customerId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerIdAndType(
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
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertTrue(data.get(0).getAdditionalInfo() instanceof NullNode);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID,
   * UUID, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(
        0L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(
        1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId2() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        0L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(
        1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId3() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AssetInfo> data =
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof NullNode);
    assertNull(getResult.getTenantId());
    assertEquals(
        1L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId4() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AssetInfo> data =
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId5() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(ModelConstants.NULL_UUID);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AssetInfo> data =
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(
        2L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId6() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setTenantId(UUID.randomUUID());

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity2);
    content.add(assetInfoEntity);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AssetInfo> data =
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(
        2L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertSame(assetInfo, data.get(1));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID,
   * UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)"
  })
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId_givenArrayListAddNull() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        jpaAssetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class),
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertEquals(
        1L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findTenantAssetTypesAsync(UUID)}.
   *
   * <p>Method under test: {@link JpaAssetDao#findTenantAssetTypesAsync(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAssetDao.findTenantAssetTypesAsync(UUID)"})
  public void testFindTenantAssetTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantAssetTypesAsyncResult =
        jpaAssetDao.findTenantAssetTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantAssetTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantAssetTypesAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaAssetDao.countAssetsByAssetProfileId(TenantId, UUID)"})
  public void testCountAssetsByAssetProfileId() {
    // Arrange
    when(assetRepository.countByAssetProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountAssetsByAssetProfileIdResult =
        jpaAssetDao.countAssetsByAssetProfileId(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).countByAssetProfileId(isA(UUID.class));
    assertEquals(1L, actualCountAssetsByAssetProfileIdResult.longValue());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndProfileId_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID profileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult =
        jpaAssetDao.findAssetsByTenantIdAndProfileId(ModelConstants.NULL_UUID, profileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertSame(profileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndProfileId_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID profileId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult =
        jpaAssetDao.findAssetsByTenantIdAndProfileId(ModelConstants.NULL_UUID, profileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertSame(profileId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndProfileId(
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
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult =
        jpaAssetDao.findAssetsByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndProfileId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult =
        jpaAssetDao.findAssetsByTenantIdAndProfileId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndProfileId(
            isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndEdgeId_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(3L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setName("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(3L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getLabel());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
    assertEquals(1L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndEdgeId_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(3L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setName("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(3L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getLabel());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
    assertEquals(1L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeId(
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
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)"})
  public void testFindAssetsByTenantIdAndEdgeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndEdgeIdAndType_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(4L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setName(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(4L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, edgeId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getType());
    assertEquals(1L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndEdgeIdAndType_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(4L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setName(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(4L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID edgeId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, edgeId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getLabel());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getName());
    assertEquals(
        "Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getType());
    assertEquals(1L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertSame(edgeId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndEdgeIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeIdAndType(
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
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID,
   * String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)"
  })
  public void testFindAssetsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository)
        .findByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getAllAssetTypes(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#getAllAssetTypes(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.getAllAssetTypes(PageLink)"})
  public void testGetAllAssetTypes_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(assetRepository.getAllAssetTypes(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbPair<UUID, String>> actualAllAssetTypes = jpaAssetDao.getAllAssetTypes(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(assetRepository).getAllAssetTypes(isA(Pageable.class));
    assertEquals(0L, actualAllAssetTypes.getTotalElements());
    assertEquals(1, actualAllAssetTypes.getTotalPages());
    assertFalse(actualAllAssetTypes.hasNext());
    assertTrue(actualAllAssetTypes.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getAllAssetTypes(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#getAllAssetTypes(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.getAllAssetTypes(PageLink)"})
  public void testGetAllAssetTypes_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.getAllAssetTypes(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, String>> actualAllAssetTypes =
        jpaAssetDao.getAllAssetTypes(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).getAllAssetTypes(isA(Pageable.class));
    assertEquals(0L, actualAllAssetTypes.getTotalElements());
    assertEquals(1, actualAllAssetTypes.getTotalPages());
    assertFalse(actualAllAssetTypes.hasNext());
    assertTrue(actualAllAssetTypes.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaAssetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(assetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaAssetDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(assetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaAssetDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaAssetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(assetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaAssetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset JpaAssetDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndExternalIdResult =
        jpaAssetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(assetRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset JpaAssetDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndExternalIdResult =
        jpaAssetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(assetRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset JpaAssetDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenAssetEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndNameResult = jpaAssetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset JpaAssetDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenAssetEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndNameResult = jpaAssetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenAssetEntityTenantIdIsNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenAssetEntityTenantIdIsRandomUUID_thenReturnDataSizeIsOne() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.randomUUID());
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(
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
    PageData<Asset> actualFindByTenantIdResult =
        jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindByTenantIdResult =
        jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with {@code AssetId}.
   *
   * <p>Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetId JpaAssetDao.getExternalIdByInternal(AssetId)"})
  public void testGetExternalIdByInternalWithAssetId() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    AssetId internalId = mock(AssetId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetId actualExternalIdByInternal = jpaAssetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.ASSET, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with {@code AssetId}.
   *
   * <ul>
   *   <li>Then return {@link AssetId#AssetId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetId JpaAssetDao.getExternalIdByInternal(AssetId)"})
  public void testGetExternalIdByInternalWithAssetId_thenReturnAssetIdWithIdIsNull_uuid() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    AssetId internalId = new AssetId(ModelConstants.NULL_UUID);

    // Act
    AssetId actualExternalIdByInternal = jpaAssetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with {@code AssetId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetId JpaAssetDao.getExternalIdByInternal(AssetId)"})
  public void testGetExternalIdByInternalWithAssetId_thenReturnNull() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetId actualExternalIdByInternal =
        jpaAssetDao.getExternalIdByInternal(new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
