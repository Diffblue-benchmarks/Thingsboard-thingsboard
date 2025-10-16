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
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetProfileInfo;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetProfileEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAssetProfileDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAssetProfileDaoDiffblueTest {
  @MockBean private AssetProfileRepository assetProfileRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAssetProfileDao jpaAssetProfileDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAssetProfileDao#getEntityClass()}
   *   <li>{@link JpaAssetProfileDao#getEntityType()}
   *   <li>{@link JpaAssetProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAssetProfileDao.getEntityClass()",
    "EntityType JpaAssetProfileDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAssetProfileDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetProfileDao jpaAssetProfileDao = new JpaAssetProfileDao();

    // Act
    Class<AssetProfileEntity> actualEntityClass = jpaAssetProfileDao.getEntityClass();
    EntityType actualEntityType = jpaAssetProfileDao.getEntityType();

    // Assert
    assertNull(jpaAssetProfileDao.getRepository());
    assertEquals(EntityType.ASSET_PROFILE, actualEntityType);
    Class<AssetProfileEntity> expectedEntityClass = AssetProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfoById(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfileInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileInfo JpaAssetProfileDao.findAssetProfileInfoById(TenantId, UUID)"
  })
  public void testFindAssetProfileInfoById() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    when(assetProfileRepository.findAssetProfileInfoById(Mockito.<UUID>any()))
        .thenReturn(assetProfileInfo);

    // Act
    AssetProfileInfo actualFindAssetProfileInfoByIdResult =
        jpaAssetProfileDao.findAssetProfileInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(assetProfileRepository).findAssetProfileInfoById(isA(UUID.class));
    assertSame(assetProfileInfo, actualFindAssetProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfiles(TenantId, PageLink)"})
  public void testFindAssetProfiles_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        jpaAssetProfileDao.findAssetProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfilesResult.getTotalElements());
    assertEquals(1, actualFindAssetProfilesResult.getTotalPages());
    assertFalse(actualFindAssetProfilesResult.hasNext());
    assertTrue(actualFindAssetProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfiles(TenantId, PageLink)"})
  public void testFindAssetProfiles_givenOne_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
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
    PageData<AssetProfile> actualFindAssetProfilesResult =
        jpaAssetProfileDao.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfilesResult.getTotalElements());
    assertEquals(1, actualFindAssetProfilesResult.getTotalPages());
    assertFalse(actualFindAssetProfilesResult.hasNext());
    assertTrue(actualFindAssetProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first DefaultQueueName is {@code Default Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfiles(TenantId, PageLink)"})
  public void testFindAssetProfiles_thenReturnDataFirstDefaultQueueNameIsDefaultQueueName() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.randomUUID());
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        jpaAssetProfileDao.findAssetProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetProfile> data = actualFindAssetProfilesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAssetProfilesResult.getTotalElements());
    assertTrue(getResult.isDefault());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfiles(TenantId, PageLink)"})
  public void testFindAssetProfiles_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        jpaAssetProfileDao.findAssetProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetProfile> data = actualFindAssetProfilesResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfiles(TenantId, PageLink)"})
  public void testFindAssetProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        jpaAssetProfileDao.findAssetProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfilesResult.getTotalElements());
    assertEquals(1, actualFindAssetProfilesResult.getTotalPages());
    assertFalse(actualFindAssetProfilesResult.hasNext());
    assertTrue(actualFindAssetProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfileInfos(TenantId, PageLink)"})
  public void testFindAssetProfileInfos_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(assetProfileRepository.findAssetProfileInfos(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        jpaAssetProfileDao.findAssetProfileInfos(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(assetProfileRepository)
        .findAssetProfileInfos(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindAssetProfileInfosResult.getTotalPages());
    assertFalse(actualFindAssetProfileInfosResult.hasNext());
    assertTrue(actualFindAssetProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfileInfos(TenantId, PageLink)"})
  public void testFindAssetProfileInfos_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(assetProfileRepository.findAssetProfileInfos(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        jpaAssetProfileDao.findAssetProfileInfos(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfileInfos(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindAssetProfileInfosResult.getTotalPages());
    assertFalse(actualFindAssetProfileInfosResult.hasNext());
    assertTrue(actualFindAssetProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAssetProfileInfos(TenantId, PageLink)"})
  public void testFindAssetProfileInfos_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfileInfos(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        jpaAssetProfileDao.findAssetProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository)
        .findAssetProfileInfos(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindAssetProfileInfosResult.getTotalPages());
    assertFalse(actualFindAssetProfileInfosResult.hasNext());
    assertTrue(actualFindAssetProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findDefaultAssetProfile(TenantId)"})
  public void testFindDefaultAssetProfile_givenNull_uuid_thenCallsGetId() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetProfile actualFindDefaultAssetProfileResult =
        jpaAssetProfileDao.findDefaultAssetProfile(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    RuleChainId expectedDefaultRuleChainId =
        actualFindDefaultAssetProfileResult.getDefaultEdgeRuleChainId();
    assertEquals(
        expectedDefaultRuleChainId, actualFindDefaultAssetProfileResult.getDefaultRuleChainId());
    AssetProfileId expectedId = actualFindDefaultAssetProfileResult.getExternalId();
    assertEquals(expectedId, actualFindDefaultAssetProfileResult.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findDefaultAssetProfile(TenantId)"})
  public void testFindDefaultAssetProfile_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindDefaultAssetProfileResult =
        jpaAssetProfileDao.findDefaultAssetProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindDefaultAssetProfileResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    RuleChainId expectedDefaultRuleChainId =
        actualFindDefaultAssetProfileResult.getDefaultEdgeRuleChainId();
    assertEquals(
        expectedDefaultRuleChainId, actualFindDefaultAssetProfileResult.getDefaultRuleChainId());
    AssetProfileId expectedId = actualFindDefaultAssetProfileResult.getExternalId();
    assertEquals(expectedId, actualFindDefaultAssetProfileResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultAssetProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findDefaultAssetProfile(TenantId)"})
  public void testFindDefaultAssetProfile_whenSystem_tenant_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindDefaultAssetProfileResult =
        jpaAssetProfileDao.findDefaultAssetProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindDefaultAssetProfileResult.getTenantId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileInfo JpaAssetProfileDao.findDefaultAssetProfileInfo(TenantId)"})
  public void testFindDefaultAssetProfileInfo_givenNull_uuid_thenCallsGetId() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    when(assetProfileRepository.findDefaultAssetProfileInfo(Mockito.<UUID>any()))
        .thenReturn(assetProfileInfo);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetProfileInfo actualFindDefaultAssetProfileInfoResult =
        jpaAssetProfileDao.findDefaultAssetProfileInfo(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(assetProfileRepository).findDefaultAssetProfileInfo(isA(UUID.class));
    assertSame(assetProfileInfo, actualFindDefaultAssetProfileInfoResult);
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultAssetProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileInfo JpaAssetProfileDao.findDefaultAssetProfileInfo(TenantId)"})
  public void testFindDefaultAssetProfileInfo_whenSystem_tenant() {
    // Arrange
    AssetProfileInfo assetProfileInfo = new AssetProfileInfo(new AssetProfile());
    when(assetProfileRepository.findDefaultAssetProfileInfo(Mockito.<UUID>any()))
        .thenReturn(assetProfileInfo);

    // Act
    AssetProfileInfo actualFindDefaultAssetProfileInfoResult =
        jpaAssetProfileDao.findDefaultAssetProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileRepository).findDefaultAssetProfileInfo(isA(UUID.class));
    assertSame(assetProfileInfo, actualFindDefaultAssetProfileInfoResult);
  }

  /**
   * Test {@link JpaAssetProfileDao#findByName(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByName(TenantId, String)"})
  public void testFindByName_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetProfile actualFindByNameResult = jpaAssetProfileDao.findByName(tenantId, "foo.txt");

    // Assert
    verify(tenantId).getId();
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    RuleChainId expectedDefaultRuleChainId = actualFindByNameResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, actualFindByNameResult.getDefaultRuleChainId());
    AssetProfileId expectedId = actualFindByNameResult.getExternalId();
    assertEquals(expectedId, actualFindByNameResult.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByName(TenantId, String)"})
  public void testFindByName_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindByNameResult =
        jpaAssetProfileDao.findByName(ModelConstants.SYSTEM_TENANT, "foo.txt");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    TenantId tenantId2 = actualFindByNameResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    RuleChainId expectedDefaultRuleChainId = actualFindByNameResult.getDefaultEdgeRuleChainId();
    assertEquals(expectedDefaultRuleChainId, actualFindByNameResult.getDefaultRuleChainId());
    AssetProfileId expectedId = actualFindByNameResult.getExternalId();
    assertEquals(expectedId, actualFindByNameResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByName(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByName(TenantId, String)"})
  public void testFindByName_whenSystem_tenant_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);

    // Act
    AssetProfile actualFindByNameResult =
        jpaAssetProfileDao.findByName(ModelConstants.SYSTEM_TENANT, "foo.txt");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("foo.txt"));
    assertSame(TenantId.SYS_TENANT_ID, actualFindByNameResult.getTenantId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult =
        jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<AssetProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllWithImagesResult.getTotalElements());
    assertTrue(getResult.isDefault());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult =
        jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_thenReturnDataSizeIsTwo() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    AssetProfileEntity assetProfileEntity2 = new AssetProfileEntity();
    assetProfileEntity2.setCreatedTime(0L);
    assetProfileEntity2.setDefault(false);
    assetProfileEntity2.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDefaultQueueName(
        "org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setDescription("Description");
    assetProfileEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setImage("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setName("org.thingsboard.server.dao.model.sql.AssetProfileEntity");
    assetProfileEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity2.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity2.setVersion(0L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity2);
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult =
        jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(2, actualFindAllWithImagesResult.getData().size());
    assertEquals(2L, actualFindAllWithImagesResult.getTotalElements());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetProfileEntity.setTenantId(tenantId);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult =
        jpaAssetProfileDao.findAllWithImages(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    List<AssetProfile> data = actualFindAllWithImagesResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindAllWithImagesResult.getTotalElements());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isDefault());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findAllWithImages(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findAllWithImages(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findAllWithImages(PageLink)"})
  public void testFindAllWithImages_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAllByImageNotNull(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindAllWithImagesResult =
        jpaAssetProfileDao.findAllWithImages(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository).findAllByImageNotNull(isA(Pageable.class));
    assertEquals(0L, actualFindAllWithImagesResult.getTotalElements());
    assertEquals(1, actualFindAllWithImagesResult.getTotalPages());
    assertFalse(actualFindAllWithImagesResult.hasNext());
    assertTrue(actualFindAllWithImagesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileRepository#findActiveTenantAssetProfileNames(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAssetProfileDao.findTenantAssetProfileNames(UUID, boolean)"})
  public void testFindTenantAssetProfileNames_thenCallsFindActiveTenantAssetProfileNames() {
    // Arrange
    when(assetProfileRepository.findActiveTenantAssetProfileNames(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantAssetProfileNamesResult =
        jpaAssetProfileDao.findTenantAssetProfileNames(ModelConstants.NULL_UUID, true);

    // Assert
    verify(assetProfileRepository).findActiveTenantAssetProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantAssetProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileRepository#findAllTenantAssetProfileNames(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findTenantAssetProfileNames(UUID, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAssetProfileDao.findTenantAssetProfileNames(UUID, boolean)"})
  public void testFindTenantAssetProfileNames_thenCallsFindAllTenantAssetProfileNames() {
    // Arrange
    when(assetProfileRepository.findAllTenantAssetProfileNames(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindTenantAssetProfileNamesResult =
        jpaAssetProfileDao.findTenantAssetProfileNames(ModelConstants.NULL_UUID, false);

    // Assert
    verify(assetProfileRepository).findAllTenantAssetProfileNames(isA(UUID.class));
    assertTrue(actualFindTenantAssetProfileNamesResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenAssetProfileEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndExternalIdResult =
        jpaAssetProfileDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(assetProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenAssetProfileEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.randomUUID());
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndExternalIdResult =
        jpaAssetProfileDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(assetProfileRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindByTenantIdAndExternalIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenAssetProfileEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndNameResult =
        jpaAssetProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenAssetProfileEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.randomUUID());
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindByTenantIdAndNameResult =
        jpaAssetProfileDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetProfileRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertEquals("Default Queue Name", actualFindByTenantIdAndNameResult.getDefaultQueueName());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndNameResult.isDefault());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
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
    PageData<AssetProfile> actualFindByTenantIdResult =
        jpaAssetProfileDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When randomUUID.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_whenRandomUUID_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult =
        jpaAssetProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);

    ArrayList<AssetProfileEntity> content = new ArrayList<>();
    content.add(assetProfileEntity);
    when(assetProfileRepository.findAssetProfiles(
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
    PageData<AssetProfile> actualFindByTenantIdResult =
        jpaAssetProfileDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetProfile> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    AssetProfile getResult = data.get(0);
    assertEquals("Default Queue Name", getResult.getDefaultQueueName());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertTrue(getResult.isDefault());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAssetProfileDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetProfileRepository.findAssetProfiles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetProfile> actualFindByTenantIdResult =
        jpaAssetProfileDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileRepository)
        .findAssetProfiles(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with {@code
   * AssetProfileId}.
   *
   * <p>Method under test: {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileId JpaAssetProfileDao.getExternalIdByInternal(AssetProfileId)"})
  public void testGetExternalIdByInternalWithAssetProfileId() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    AssetProfileId internalId = new AssetProfileId(ModelConstants.NULL_UUID);

    // Act
    AssetProfileId actualExternalIdByInternal =
        jpaAssetProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with {@code
   * AssetProfileId}.
   *
   * <p>Method under test: {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileId JpaAssetProfileDao.getExternalIdByInternal(AssetProfileId)"})
  public void testGetExternalIdByInternalWithAssetProfileId2() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    AssetProfileId internalId = mock(AssetProfileId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetProfileId actualExternalIdByInternal =
        jpaAssetProfileDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)} with {@code
   * AssetProfileId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#getExternalIdByInternal(AssetProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileId JpaAssetProfileDao.getExternalIdByInternal(AssetProfileId)"})
  public void testGetExternalIdByInternalWithAssetProfileId_thenReturnNull() {
    // Arrange
    when(assetProfileRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetProfileId actualExternalIdByInternal =
        jpaAssetProfileDao.getExternalIdByInternal(new AssetProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetProfileRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId_givenAssetProfileEntityTenantIdIsNull_uuid() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindDefaultEntityByTenantIdResult =
        jpaAssetProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileEntity#AssetProfileEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile JpaAssetProfileDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId_givenAssetProfileEntityTenantIdIsRandomUUID() {
    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(UUID.randomUUID());
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    when(assetProfileRepository.findByDefaultTrueAndTenantId(Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AssetProfile actualFindDefaultEntityByTenantIdResult =
        jpaAssetProfileDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(assetProfileRepository).findByDefaultTrueAndTenantId(isA(UUID.class));
    assertEquals(
        "Default Queue Name", actualFindDefaultEntityByTenantIdResult.getDefaultQueueName());
    assertEquals("Image", actualFindDefaultEntityByTenantIdResult.getImage());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDefaultEntityByTenantIdResult.getDescription());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAssetProfileDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(assetProfileRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<AssetProfileInfo> actualFindByTenantAndImageLinkResult =
        jpaAssetProfileDao.findByTenantAndImageLink(tenantId, "Image Link", 1);

    // Assert
    verify(tenantId).getId();
    verify(assetProfileRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAssetProfileDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(assetProfileRepository.findByTenantAndImageLink(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AssetProfileInfo> actualFindByTenantAndImageLinkResult =
        jpaAssetProfileDao.findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "Image Link", 1);

    // Assert
    verify(assetProfileRepository)
        .findByTenantAndImageLink(isA(UUID.class), eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaAssetProfileDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAssetProfileDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAssetProfileDao.findByImageLink(String, int)"})
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(assetProfileRepository.findByImageLink(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AssetProfileInfo> actualFindByImageLinkResult =
        jpaAssetProfileDao.findByImageLink("Image Link", 1);

    // Assert
    verify(assetProfileRepository).findByImageLink(eq("Image Link"), isA(Pageable.class));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
