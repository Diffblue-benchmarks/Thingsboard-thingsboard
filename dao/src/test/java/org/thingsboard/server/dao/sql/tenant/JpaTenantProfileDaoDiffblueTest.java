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
package org.thingsboard.server.dao.sql.tenant;

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
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantProfileEntity;

@RunWith(MockitoJUnitRunner.class)
public class JpaTenantProfileDaoDiffblueTest {
  @InjectMocks private JpaTenantProfileDao jpaTenantProfileDao;

  @Mock private TenantProfileRepository tenantProfileRepository;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaTenantProfileDao#getEntityClass()}
   *   <li>{@link JpaTenantProfileDao#getEntityType()}
   *   <li>{@link JpaTenantProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaTenantProfileDao.getEntityClass()",
    "EntityType JpaTenantProfileDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaTenantProfileDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantProfileDao jpaTenantProfileDao = new JpaTenantProfileDao();

    // Act
    Class<TenantProfileEntity> actualEntityClass = jpaTenantProfileDao.getEntityClass();
    EntityType actualEntityType = jpaTenantProfileDao.getEntityType();

    // Assert
    assertNull(jpaTenantProfileDao.getRepository());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityType);
    Class<TenantProfileEntity> expectedEntityClass = TenantProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo JpaTenantProfileDao.findTenantProfileInfoById(TenantId, UUID)"})
  public void testFindTenantProfileInfoById() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");
    when(tenantProfileRepository.findTenantProfileInfoById(Mockito.<UUID>any()))
        .thenReturn(entityInfo);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult =
        jpaTenantProfileDao.findTenantProfileInfoById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantProfileRepository).findTenantProfileInfoById(isA(UUID.class));
    assertSame(entityInfo, actualFindTenantProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantProfileDao.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<TenantProfile> actualFindTenantProfilesResult =
        jpaTenantProfileDao.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfiles(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfilesResult.getTotalElements());
    assertEquals(1, actualFindTenantProfilesResult.getTotalPages());
    assertFalse(actualFindTenantProfilesResult.hasNext());
    assertTrue(actualFindTenantProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantProfileDao.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_thenReturnDataSizeIsOne() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TenantProfileEntity> content = new ArrayList<>();
    content.add(tenantProfileEntity);
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<TenantProfile> actualFindTenantProfilesResult =
        jpaTenantProfileDao.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfiles(eq("Text Search"), isA(Pageable.class));
    List<TenantProfile> data = actualFindTenantProfilesResult.getData();
    assertEquals(1, data.size());
    TenantProfile getResult = data.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindTenantProfilesResult.getTotalElements());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantProfileDao.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfiles(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult =
        jpaTenantProfileDao.findTenantProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileRepository).findTenantProfiles(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfilesResult.getTotalElements());
    assertEquals(1, actualFindTenantProfilesResult.getTotalPages());
    assertFalse(actualFindTenantProfilesResult.hasNext());
    assertTrue(actualFindTenantProfilesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantProfileDao.findTenantProfileInfos(TenantId, PageLink)"})
  public void testFindTenantProfileInfos_givenOne_thenCallsGetPage() {
    // Arrange
    when(tenantProfileRepository.findTenantProfileInfos(
            Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        jpaTenantProfileDao.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantProfileRepository).findTenantProfileInfos(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantProfileInfosResult.getTotalPages());
    assertFalse(actualFindTenantProfileInfosResult.hasNext());
    assertTrue(actualFindTenantProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantProfileDao.findTenantProfileInfos(TenantId, PageLink)"})
  public void testFindTenantProfileInfos_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantProfileRepository.findTenantProfileInfos(
            Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        jpaTenantProfileDao.findTenantProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileRepository).findTenantProfileInfos(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantProfileInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantProfileInfosResult.getTotalPages());
    assertFalse(actualFindTenantProfileInfosResult.hasNext());
    assertTrue(actualFindTenantProfileInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile JpaTenantProfileDao.findDefaultTenantProfile(TenantId)"})
  public void testFindDefaultTenantProfile_thenReturnName() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);
    when(tenantProfileRepository.findByDefaultTrue()).thenReturn(tenantProfileEntity);

    // Act
    TenantProfile actualFindDefaultTenantProfileResult =
        jpaTenantProfileDao.findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findByDefaultTrue();
    assertEquals("Name", actualFindDefaultTenantProfileResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDefaultTenantProfileResult.getDescription());
    assertNull(actualFindDefaultTenantProfileResult.getProfileDataBytes());
    assertEquals(1L, actualFindDefaultTenantProfileResult.getCreatedTime());
    assertTrue(actualFindDefaultTenantProfileResult.isDefault());
    assertTrue(actualFindDefaultTenantProfileResult.isIsolatedTbRuleEngine());
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo JpaTenantProfileDao.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");
    when(tenantProfileRepository.findDefaultTenantProfileInfo()).thenReturn(entityInfo);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult =
        jpaTenantProfileDao.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findDefaultTenantProfileInfo();
    assertSame(entityInfo, actualFindDefaultTenantProfileInfoResult);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantProfileDao.findTenantProfilesByIds(TenantId, UUID[])"})
  public void testFindTenantProfilesByIds_thenReturnEmpty() {
    // Arrange
    when(tenantProfileRepository.findByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult =
        jpaTenantProfileDao.findTenantProfilesByIds(
            ModelConstants.SYSTEM_TENANT, new UUID[] {ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileRepository).findByIdIn(isA(List.class));
    assertTrue(actualFindTenantProfilesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantProfileDao#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantProfileDao.findTenantProfilesByIds(TenantId, UUID[])"})
  public void testFindTenantProfilesByIds_thenReturnSizeIsOne() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TenantProfileEntity> tenantProfileEntityList = new ArrayList<>();
    tenantProfileEntityList.add(tenantProfileEntity);
    when(tenantProfileRepository.findByIdIn(Mockito.<List<UUID>>any()))
        .thenReturn(tenantProfileEntityList);

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult =
        jpaTenantProfileDao.findTenantProfilesByIds(
            ModelConstants.SYSTEM_TENANT, new UUID[] {ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileRepository).findByIdIn(isA(List.class));
    assertEquals(1, actualFindTenantProfilesByIdsResult.size());
    TenantProfile getResult = actualFindTenantProfilesByIdsResult.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertNull(getResult.getProfileDataBytes());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isIsolatedTbRuleEngine());
  }
}
