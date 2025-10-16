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

import static org.junit.Assert.assertArrayEquals;
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
import java.io.UnsupportedEncodingException;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTbResourceDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTbResourceDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaTbResourceDao jpaTbResourceDao;

  @MockBean private TbResourceRepository tbResourceRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaTbResourceDao#getEntityClass()}
   *   <li>{@link JpaTbResourceDao#getEntityType()}
   *   <li>{@link JpaTbResourceDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaTbResourceDao.getEntityClass()",
    "EntityType JpaTbResourceDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaTbResourceDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaTbResourceDao jpaTbResourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    // Act
    Class<TbResourceEntity> actualEntityClass = jpaTbResourceDao.getEntityClass();
    EntityType actualEntityType = jpaTbResourceDao.getEntityType();
    jpaTbResourceDao.getRepository();

    // Assert
    assertEquals(EntityType.TB_RESOURCE, actualEntityType);
    Class<TbResourceEntity> expectedEntityClass = TbResourceEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findAllByTenantId(TenantId, PageLink)"})
  public void testFindAllByTenantId_givenNull_uuid_whenFirst_page_thenCallsGetId() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult =
        jpaTbResourceDao.findAllByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllByTenantIdResult.hasNext());
    assertTrue(actualFindAllByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findAllByTenantId(TenantId, PageLink)"})
  public void testFindAllByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult =
        jpaTbResourceDao.findAllByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllByTenantIdResult.hasNext());
    assertTrue(actualFindAllByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findAllByTenantId(TenantId, PageLink)"})
  public void testFindAllByTenantId_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult =
        jpaTbResourceDao.findAllByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllByTenantIdResult.hasNext());
    assertTrue(actualFindAllByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, String[], String)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code objectIds}, {@code searchText}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText() {
    // Arrange
    when(tbResourceRepository.findResourcesByIds(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            ModelConstants.SYSTEM_TENANT,
            ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE,
            new String[] {"Object Ids"},
            "Search Text");

    // Assert
    verify(tbResourceRepository)
        .findResourcesByIds(
            isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isA(String[].class));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, String[], String)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code objectIds}, {@code searchText}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText2() {
    // Arrange
    when(tbResourceRepository.findResourcesByIds(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String[]>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId,
            ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE,
            new String[] {"Object Ids"},
            "Search Text");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository)
        .findResourcesByIds(
            isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isA(String[].class));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, String[], String)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code objectIds}, {@code searchText}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText3() {
    // Arrange
    when(tbResourceRepository.findResources(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId, ResourceType.LWM2M_MODEL, ResourceSubType.IMAGE, null, "Search Text");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository)
        .findResources(
            isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"), eq("Search Text"));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, String[], String)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code objectIds}, {@code searchText}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText4() {
    // Arrange
    when(tbResourceRepository.findResources(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId, ResourceType.LWM2M_MODEL, null, null, "Search Text");

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository)
        .findResources(
            isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isNull(), eq("Search Text"));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, String[], String)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code objectIds}, {@code searchText}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText5() {
    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.findResources(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        new JpaTbResourceDao(resourceRepository)
            .findResourcesByTenantIdAndResourceType(
                ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, null, null, "Search Text");

    // Assert
    verify(resourceRepository)
        .findResources(
            isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isNull(), eq("Search Text"));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, PageLink)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            ModelConstants.SYSTEM_TENANT,
            ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository)
        .findResourcesPage(
            isA(UUID.class),
            isA(UUID.class),
            eq("LWM2M_MODEL"),
            eq("IMAGE"),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, PageLink)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink2() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId,
            ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository)
        .findResourcesPage(
            isA(UUID.class),
            isA(UUID.class),
            eq("LWM2M_MODEL"),
            eq("IMAGE"),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, PageLink)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink3() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId, ResourceType.LWM2M_MODEL, ResourceSubType.IMAGE, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository)
        .findResourcesPage(
            isA(UUID.class),
            isA(UUID.class),
            eq("LWM2M_MODEL"),
            eq("IMAGE"),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType,
   * ResourceSubType, PageLink)} with {@code tenantId}, {@code resourceType}, {@code
   * resourceSubType}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId,
   * ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaTbResourceDao.findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)"
  })
  public void
      testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink4() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult =
        jpaTbResourceDao.findResourcesByTenantIdAndResourceType(
            tenantId, ResourceType.LWM2M_MODEL, null, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository)
        .findResourcesPage(
            isA(UUID.class),
            isA(UUID.class),
            eq("LWM2M_MODEL"),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JpaTbResourceDao.getResourceData(TenantId, TbResourceId)"})
  public void testGetResourceData_givenNull_uuid_thenCallsGetId()
      throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getDataById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    byte[] actualResourceData =
        jpaTbResourceDao.getResourceData(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JpaTbResourceDao.getResourceData(TenantId, TbResourceId)"})
  public void testGetResourceData_whenTbResourceIdWithIdIsNull_uuid()
      throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getDataById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourceData =
        jpaTbResourceDao.getResourceData(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JpaTbResourceDao.getResourcePreview(TenantId, TbResourceId)"})
  public void testGetResourcePreview_givenNull_uuid_thenCallsGetId()
      throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getPreviewById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    byte[] actualResourcePreview =
        jpaTbResourceDao.getResourcePreview(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourcePreview);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JpaTbResourceDao.getResourcePreview(TenantId, TbResourceId)"})
  public void testGetResourcePreview_whenTbResourceIdWithIdIsNull_uuid()
      throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getPreviewById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourcePreview =
        jpaTbResourceDao.getResourcePreview(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourcePreview);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JpaTbResourceDao.getResourceSize(TenantId, TbResourceId)"})
  public void testGetResourceSize_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(tbResourceRepository.getDataSizeById(Mockito.<UUID>any())).thenReturn(1L);

    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    long actualResourceSize =
        jpaTbResourceDao.getResourceSize(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getDataSizeById(isA(UUID.class));
    assertEquals(1L, actualResourceSize);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JpaTbResourceDao.getResourceSize(TenantId, TbResourceId)"})
  public void testGetResourceSize_whenTbResourceIdWithIdIsNull_uuid_thenReturnOne() {
    // Arrange
    when(tbResourceRepository.getDataSizeById(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    long actualResourceSize =
        jpaTbResourceDao.getResourceSize(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getDataSizeById(isA(UUID.class));
    assertEquals(1L, actualResourceSize);
  }

  /**
   * Test {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaTbResourceDao.sumDataSizeByTenantId(TenantId)"})
  public void testSumDataSizeByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(tbResourceRepository.sumDataSizeByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualSumDataSizeByTenantIdResult = jpaTbResourceDao.sumDataSizeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(tbResourceRepository).sumDataSizeByTenantId(isA(UUID.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaTbResourceDao.sumDataSizeByTenantId(TenantId)"})
  public void testSumDataSizeByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(tbResourceRepository.sumDataSizeByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualSumDataSizeByTenantIdResult =
        jpaTbResourceDao.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceRepository).sumDataSizeByTenantId(isA(UUID.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResource> actualFindByTenantIdResult =
        jpaTbResourceDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When randomUUID.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_whenRandomUUID_thenCallsGetPage() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResource> actualFindByTenantIdResult =
        jpaTbResourceDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindByTenantIdResult =
        jpaTbResourceDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult =
        jpaTbResourceDao.findIdsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<TbResourceId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindIdsByTenantIdResult.getTotalElements());
    TbResourceId getResult = data.get(0);
    assertEquals(EntityType.TB_RESOURCE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(tenantId, getResult.getId());
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult =
        jpaTbResourceDao.findIdsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<TbResourceId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    TbResourceId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult =
        jpaTbResourceDao.findIdsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTbResourceDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult =
        jpaTbResourceDao.findIdsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with {@code TbResourceId}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceId JpaTbResourceDao.getExternalIdByInternal(TbResourceId)"})
  public void testGetExternalIdByInternalWithTbResourceId() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    TbResourceId internalId = new TbResourceId(ModelConstants.NULL_UUID);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with {@code TbResourceId}.
   *
   * <p>Method under test: {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceId JpaTbResourceDao.getExternalIdByInternal(TbResourceId)"})
  public void testGetExternalIdByInternalWithTbResourceId2() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    TbResourceId internalId = mock(TbResourceId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with {@code TbResourceId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceId JpaTbResourceDao.getExternalIdByInternal(TbResourceId)"})
  public void testGetExternalIdByInternalWithTbResourceId_thenReturnNull() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    TbResourceId internalId = mock(TbResourceId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
