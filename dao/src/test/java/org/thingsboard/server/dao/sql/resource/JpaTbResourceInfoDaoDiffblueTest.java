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
package org.thingsboard.server.dao.sql.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.TbResourceInfoFilter.TbResourceInfoFilterBuilder;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTbResourceInfoDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTbResourceInfoDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaTbResourceInfoDao jpaTbResourceInfoDao;

  @MockBean private TbResourceInfoRepository tbResourceInfoRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaTbResourceInfoDao#getEntityClass()}
   *   <li>{@link JpaTbResourceInfoDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaTbResourceInfoDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaTbResourceInfoDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaTbResourceInfoDao jpaTbResourceInfoDao = new JpaTbResourceInfoDao();

    // Act
    Class<TbResourceInfoEntity> actualEntityClass = jpaTbResourceInfoDao.getEntityClass();

    // Assert
    assertNull(jpaTbResourceInfoDao.getRepository());
    Class<TbResourceInfoEntity> expectedEntityClass = TbResourceInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@code IMAGE}.
   *   <li>When {@link HashSet#HashSet()} add {@code IMAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_givenImage_whenHashSetAddImage() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        TbResourceInfoFilter.builder().resourceSubTypes(resourceSubTypes);

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findAllTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findAllTenantResourcesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isA(List.class),
            isA(List.class),
            eq(""),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   *   <li>When {@link HashSet#HashSet()} add {@code LWM2M_MODEL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_givenLwm2mModel_whenHashSetAddLwm2mModel() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.LWM2M_MODEL);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findAllTenantResourcesByTenantId(
            builderResult
                .resourceSubTypes(new HashSet<>())
                .resourceTypes(resourceTypes)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findAllTenantResourcesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isA(List.class),
            isNull(),
            eq(""),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findAllTenantResourcesByTenantId(
            resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .findAllTenantResourcesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isA(List.class),
            isNull(),
            eq(""),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter =
        resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findAllTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoRepository)
        .findAllTenantResourcesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isA(List.class),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findAllTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findAllTenantResourcesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isA(List.class),
            isNull(),
            eq(""),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then calls {@link
   *       TbResourceInfoFilter.TbResourceInfoFilterBuilder#resourceSubTypes(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_givenBuilder_thenCallsResourceSubTypes() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder =
        mock(TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        tbResourceInfoFilterBuilder.resourceSubTypes(new HashSet<>());

    TbResourceInfoFilterBuilder resourceTypesResult =
        resourceSubTypesResult.resourceTypes(new HashSet<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    TbResourceInfoFilter filter = resourceTypesResult.tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@code IMAGE}.
   *   <li>When {@link HashSet#HashSet()} add {@code IMAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_givenImage_whenHashSetAddImage() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    HashSet<ResourceSubType> resourceSubTypes = new HashSet<>();
    resourceSubTypes.add(ResourceSubType.IMAGE);

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        TbResourceInfoFilter.builder().resourceSubTypes(resourceSubTypes);

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   *   <li>When {@link HashSet#HashSet()} add {@code LWM2M_MODEL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_givenLwm2mModel_whenHashSetAddLwm2mModel() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.LWM2M_MODEL);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(
            builderResult
                .resourceSubTypes(new HashSet<>())
                .resourceTypes(resourceTypes)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter =
        resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceInfoDao.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_thenCallsGetId() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<String>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        jpaTbResourceInfoDao.findTenantResourcesByTenantId(
            resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .findTenantResourcesByTenantId(
            isA(UUID.class), isA(List.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId,
   * ResourceType, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)"
  })
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult =
        jpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(
            tenantId, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .existsByTenantIdAndResourceTypeAndResourceKey(
            isA(UUID.class), eq("LWM2M_MODEL"), eq("Resource Key"));
    assertTrue(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId,
   * ResourceType, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)"
  })
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_thenReturnFalse() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult =
        jpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(
            tenantId, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .existsByTenantIdAndResourceTypeAndResourceKey(
            isA(UUID.class), eq("LWM2M_MODEL"), eq("Resource Key"));
    assertFalse(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId,
   * ResourceType, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)"
  })
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_whenSystem_tenant() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult =
        jpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(
            ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceInfoRepository)
        .existsByTenantIdAndResourceTypeAndResourceKey(
            isA(UUID.class), eq("LWM2M_MODEL"), eq("Resource Key"));
    assertTrue(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test {@link
   * JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId,
   * ResourceType, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set JpaTbResourceInfoDao.findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId, ResourceType, String)"
  })
  public void testFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefix_thenCallsGetId() {
    // Arrange
    when(tbResourceInfoRepository.findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Set<String> actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult =
        jpaTbResourceInfoDao.findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(
            tenantId, ResourceType.LWM2M_MODEL, "Prefix");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(
            isA(UUID.class), eq("LWM2M_MODEL"), eq("Prefix"));
    assertTrue(actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult.isEmpty());
  }

  /**
   * Test {@link
   * JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId,
   * ResourceType, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set JpaTbResourceInfoDao.findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId, ResourceType, String)"
  })
  public void testFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefix_whenSystem_tenant() {
    // Arrange
    when(tbResourceInfoRepository.findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<String> actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult =
        jpaTbResourceInfoDao.findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(
            ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Prefix");

    // Assert
    verify(tbResourceInfoRepository)
        .findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(
            isA(UUID.class), eq("LWM2M_MODEL"), eq("Prefix"));
    assertTrue(actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceInfoDao.findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)"
  })
  public void testFindByTenantIdAndEtagAndKeyStartingWith_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(tbResourceInfoRepository.findByTenantIdAndEtagAndResourceKeyStartingWith(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TbResourceInfo> actualFindByTenantIdAndEtagAndKeyStartingWithResult =
        jpaTbResourceInfoDao.findByTenantIdAndEtagAndKeyStartingWith(tenantId, "Etag", "Query");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceInfoRepository)
        .findByTenantIdAndEtagAndResourceKeyStartingWith(isA(UUID.class), eq("Etag"), eq("Query"));
    assertTrue(actualFindByTenantIdAndEtagAndKeyStartingWithResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceInfoDao.findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)"
  })
  public void testFindByTenantIdAndEtagAndKeyStartingWith_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(tbResourceInfoRepository.findByTenantIdAndEtagAndResourceKeyStartingWith(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TbResourceInfo> actualFindByTenantIdAndEtagAndKeyStartingWithResult =
        jpaTbResourceInfoDao.findByTenantIdAndEtagAndKeyStartingWith(
            ModelConstants.SYSTEM_TENANT, "Etag", "Query");

    // Assert
    verify(tbResourceInfoRepository)
        .findByTenantIdAndEtagAndResourceKeyStartingWith(isA(UUID.class), eq("Etag"), eq("Query"));
    assertTrue(actualFindByTenantIdAndEtagAndKeyStartingWithResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaTbResourceInfoDao.existsByPublicResourceKey(ResourceType, String)"
  })
  public void testExistsByPublicResourceKey_thenReturnFalse() {
    // Arrange
    when(tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualExistsByPublicResourceKeyResult =
        jpaTbResourceInfoDao.existsByPublicResourceKey(
            ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository)
        .existsByResourceTypeAndPublicResourceKey("LWM2M_MODEL", "Public Resource Key");
    assertFalse(actualExistsByPublicResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaTbResourceInfoDao.existsByPublicResourceKey(ResourceType, String)"
  })
  public void testExistsByPublicResourceKey_thenReturnTrue() {
    // Arrange
    when(tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByPublicResourceKeyResult =
        jpaTbResourceInfoDao.existsByPublicResourceKey(
            ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository)
        .existsByResourceTypeAndPublicResourceKey("LWM2M_MODEL", "Public Resource Key");
    assertTrue(actualExistsByPublicResourceKeyResult);
  }
}
