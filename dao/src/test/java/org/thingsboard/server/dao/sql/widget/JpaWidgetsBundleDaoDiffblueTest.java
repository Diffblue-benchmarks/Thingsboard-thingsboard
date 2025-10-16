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
package org.thingsboard.server.dao.sql.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter.WidgetsBundleFilterBuilder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.WidgetsBundleEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaWidgetsBundleDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaWidgetsBundleDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaWidgetsBundleDao jpaWidgetsBundleDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private WidgetsBundleRepository widgetsBundleRepository;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaWidgetsBundleDao#getEntityClass()}
   *   <li>{@link JpaWidgetsBundleDao#getEntityType()}
   *   <li>{@link JpaWidgetsBundleDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaWidgetsBundleDao.getEntityClass()",
    "EntityType JpaWidgetsBundleDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaWidgetsBundleDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaWidgetsBundleDao jpaWidgetsBundleDao = new JpaWidgetsBundleDao();

    // Act
    Class<WidgetsBundleEntity> actualEntityClass = jpaWidgetsBundleDao.getEntityClass();
    EntityType actualEntityType = jpaWidgetsBundleDao.getEntityType();

    // Assert
    assertNull(jpaWidgetsBundleDao.getRepository());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEntityType);
    Class<WidgetsBundleEntity> expectedEntityClass = WidgetsBundleEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findWidgetsBundleByTenantIdAndAlias(UUID, String)}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findWidgetsBundleByTenantIdAndAlias(UUID,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle JpaWidgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(UUID, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindWidgetsBundleByTenantIdAndAliasResult =
        jpaWidgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(tenantId, "Alias");

    // Assert
    verify(widgetsBundleRepository)
        .findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
    assertEquals("Alias", actualFindWidgetsBundleByTenantIdAndAliasResult.getAlias());
    assertEquals("Dr", actualFindWidgetsBundleByTenantIdAndAliasResult.getName());
    assertEquals("Dr", actualFindWidgetsBundleByTenantIdAndAliasResult.getTitle());
    assertEquals("Image", actualFindWidgetsBundleByTenantIdAndAliasResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindWidgetsBundleByTenantIdAndAliasResult.getDescription());
    assertEquals(1, actualFindWidgetsBundleByTenantIdAndAliasResult.getOrder().intValue());
    assertEquals(1L, actualFindWidgetsBundleByTenantIdAndAliasResult.getVersion().longValue());
    assertEquals(1L, actualFindWidgetsBundleByTenantIdAndAliasResult.getCreatedTime());
    assertTrue(actualFindWidgetsBundleByTenantIdAndAliasResult.isScada());
    assertSame(tenantId, actualFindWidgetsBundleByTenantIdAndAliasResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findWidgetsBundleByTenantIdAndAlias(UUID, String)}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findWidgetsBundleByTenantIdAndAlias(UUID,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle JpaWidgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(UUID, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias2() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindWidgetsBundleByTenantIdAndAliasResult =
        jpaWidgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(tenantId, "Alias");

    // Assert
    verify(widgetsBundleRepository)
        .findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
    assertEquals("Alias", actualFindWidgetsBundleByTenantIdAndAliasResult.getAlias());
    assertEquals("Dr", actualFindWidgetsBundleByTenantIdAndAliasResult.getName());
    assertEquals("Dr", actualFindWidgetsBundleByTenantIdAndAliasResult.getTitle());
    assertEquals("Image", actualFindWidgetsBundleByTenantIdAndAliasResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindWidgetsBundleByTenantIdAndAliasResult.getDescription());
    assertEquals(1, actualFindWidgetsBundleByTenantIdAndAliasResult.getOrder().intValue());
    assertEquals(1L, actualFindWidgetsBundleByTenantIdAndAliasResult.getVersion().longValue());
    assertEquals(1L, actualFindWidgetsBundleByTenantIdAndAliasResult.getCreatedTime());
    assertTrue(actualFindWidgetsBundleByTenantIdAndAliasResult.isScada());
    assertSame(tenantId, actualFindWidgetsBundleByTenantIdAndAliasResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findSystemWidgetsBundlesFullSearch(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesResult =
        jpaWidgetsBundleDao.findSystemWidgetsBundles(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findSystemWidgetsBundlesFullSearch(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetsBundlesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetsBundlesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetsBundlesResult.hasNext());
    assertTrue(actualFindSystemWidgetsBundlesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleFilterBuilder#fullSearch(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundles_thenCallsFullSearch() {
    // Arrange
    when(widgetsBundleRepository.findSystemWidgetsBundles(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());
    WidgetsBundleFilter widgetsBundleFilter =
        widgetsBundleFilterBuilder
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesResult =
        jpaWidgetsBundleDao.findSystemWidgetsBundles(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleFilterBuilder).fullSearch(true);
    verify(widgetsBundleRepository)
        .findSystemWidgetsBundles(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetsBundlesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetsBundlesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetsBundlesResult.hasNext());
    assertTrue(actualFindSystemWidgetsBundlesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundles_thenReturnDataSizeIsOne() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(3L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(3);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(3L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findSystemWidgetsBundlesFullSearch(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesResult =
        jpaWidgetsBundleDao.findSystemWidgetsBundles(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findSystemWidgetsBundlesFullSearch(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindSystemWidgetsBundlesResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, actualFindSystemWidgetsBundlesResult.getTotalElements());
    assertEquals(3, getResult.getOrder().intValue());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findSystemWidgetsBundles(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findSystemWidgetsBundles(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findSystemWidgetsBundlesFullSearch(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesResult =
        jpaWidgetsBundleDao.findSystemWidgetsBundles(
            WidgetsBundleFilter.builder()
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository)
        .findSystemWidgetsBundlesFullSearch(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetsBundlesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetsBundlesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetsBundlesResult.hasNext());
    assertTrue(actualFindSystemWidgetsBundlesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID, PageLink)} with {@code
   * tenantId}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(UUID, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithTenantIdPageLink() {
    // Arrange
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID, PageLink)} with {@code
   * tenantId}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(UUID, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithTenantIdPageLink2() {
    // Arrange
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID, PageLink)} with {@code
   * tenantId}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(UUID, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithTenantIdPageLink3() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindTenantWidgetsBundlesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID, PageLink)} with {@code
   * tenantId}, {@code pageLink}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(UUID, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithTenantIdPageLink4() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindTenantWidgetsBundlesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)} with {@code widgetsBundleFilter}, {@code pageLink}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithWidgetsBundleFilterPageLink() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            WidgetsBundleFilter.builder()
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), isNull(), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)} with {@code widgetsBundleFilter}, {@code pageLink}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithWidgetsBundleFilterPageLink2() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)} with {@code widgetsBundleFilter}, {@code pageLink}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithWidgetsBundleFilterPageLink3() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)} with {@code widgetsBundleFilter}, {@code pageLink}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithWidgetsBundleFilterPageLink4() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(3L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(3);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(3L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindTenantWidgetsBundlesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(3, getResult.getOrder().intValue());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)} with {@code widgetsBundleFilter}, {@code pageLink}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdWithWidgetsBundleFilterPageLink5() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIds(
            Mockito.<List<UUID>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());

    WidgetsBundleFilterBuilder scadaFirstResult =
        widgetsBundleFilterBuilder.fullSearch(true).scadaFirst(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter = scadaFirstResult.tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleFilterBuilder).fullSearch(true);
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIds(
            isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            WidgetsBundleFilter.builder()
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), isNull(), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId2() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId3() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleFilterBuilder#fullSearch(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId_thenCallsFullSearch() {
    // Arrange
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIds(
            Mockito.<List<UUID>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetsBundleFilterBuilder widgetsBundleFilterBuilder = mock(WidgetsBundleFilterBuilder.class);
    when(widgetsBundleFilterBuilder.fullSearch(anyBoolean()))
        .thenReturn(WidgetsBundleFilter.builder());

    WidgetsBundleFilterBuilder scadaFirstResult =
        widgetsBundleFilterBuilder.fullSearch(true).scadaFirst(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter = scadaFirstResult.tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleFilterBuilder).fullSearch(true);
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIds(
            isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetsBundlesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetsBundleDao#findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(2L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(2);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(2L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            Mockito.<List<UUID>>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        jpaWidgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findAllTenantWidgetsBundlesByTenantIdsFullSearch(
            isA(List.class), eq("Text Search"), eq(true), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindAllTenantWidgetsBundlesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, actualFindAllTenantWidgetsBundlesByTenantIdResult.getTotalElements());
    assertEquals(2, getResult.getOrder().intValue());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findAllWidgetsBundles(PageLink)"})
  public void testFindAllWidgetsBundles_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetsBundle> actualFindAllWidgetsBundlesResult =
        jpaWidgetsBundleDao.findAllWidgetsBundles(pageLink);

    // Assert
    verify(widgetsBundleRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    assertEquals(0L, actualFindAllWidgetsBundlesResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetsBundlesResult.getTotalPages());
    assertFalse(actualFindAllWidgetsBundlesResult.hasNext());
    assertTrue(actualFindAllWidgetsBundlesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findAllWidgetsBundles(PageLink)"})
  public void testFindAllWidgetsBundles_givenWidgetsBundleEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetsBundle> actualFindAllWidgetsBundlesResult =
        jpaWidgetsBundleDao.findAllWidgetsBundles(pageLink);

    // Assert
    verify(widgetsBundleRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    List<WidgetsBundle> data = actualFindAllWidgetsBundlesResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindAllWidgetsBundlesResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findAllWidgetsBundles(PageLink)"})
  public void testFindAllWidgetsBundles_givenWidgetsBundleEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetsBundle> actualFindAllWidgetsBundlesResult =
        jpaWidgetsBundleDao.findAllWidgetsBundles(pageLink);

    // Assert
    verify(widgetsBundleRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    List<WidgetsBundle> data = actualFindAllWidgetsBundlesResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindAllWidgetsBundlesResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findAllWidgetsBundles(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findAllWidgetsBundles(PageLink)"})
  public void testFindAllWidgetsBundles_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindAllWidgetsBundlesResult =
        jpaWidgetsBundleDao.findAllWidgetsBundles(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository).findAll(isA(Pageable.class));
    assertEquals(0L, actualFindAllWidgetsBundlesResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetsBundlesResult.getTotalPages());
    assertFalse(actualFindAllWidgetsBundlesResult.hasNext());
    assertTrue(actualFindAllWidgetsBundlesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle JpaWidgetsBundleDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenWidgetsBundleEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindByTenantIdAndExternalIdResult =
        jpaWidgetsBundleDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(widgetsBundleRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals("Alias", actualFindByTenantIdAndExternalIdResult.getAlias());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isScada());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle JpaWidgetsBundleDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenWidgetsBundleEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindByTenantIdAndExternalIdResult =
        jpaWidgetsBundleDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(widgetsBundleRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertEquals("Alias", actualFindByTenantIdAndExternalIdResult.getAlias());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isScada());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle JpaWidgetsBundleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenWidgetsBundleEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findFirstByTenantIdAndTitle(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindByTenantIdAndNameResult =
        jpaWidgetsBundleDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(widgetsBundleRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertEquals("Alias", actualFindByTenantIdAndNameResult.getAlias());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndNameResult.getOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndNameResult.isScada());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle JpaWidgetsBundleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenWidgetsBundleEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    when(widgetsBundleRepository.findFirstByTenantIdAndTitle(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetsBundle actualFindByTenantIdAndNameResult =
        jpaWidgetsBundleDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(widgetsBundleRepository).findFirstByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertEquals("Alias", actualFindByTenantIdAndNameResult.getAlias());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndNameResult.getImage());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndNameResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndNameResult.getOrder().intValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndNameResult.isScada());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindByTenantIdResult =
        jpaWidgetsBundleDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenWidgetsBundleEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindByTenantIdResult =
        jpaWidgetsBundleDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenWidgetsBundleEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> content = new ArrayList<>();
    content.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
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
    PageData<WidgetsBundle> actualFindByTenantIdResult =
        jpaWidgetsBundleDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetsBundle> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetsBundle getResult = data.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetsBundleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetsBundleRepository.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetsBundle> actualFindByTenantIdResult =
        jpaWidgetsBundleDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleRepository)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)} with {@code
   * WidgetsBundleId}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundleId JpaWidgetsBundleDao.getExternalIdByInternal(WidgetsBundleId)"
  })
  public void testGetExternalIdByInternalWithWidgetsBundleId() {
    // Arrange
    when(widgetsBundleRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleId internalId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundleId actualExternalIdByInternal =
        jpaWidgetsBundleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(widgetsBundleRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)} with {@code
   * WidgetsBundleId}.
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundleId JpaWidgetsBundleDao.getExternalIdByInternal(WidgetsBundleId)"
  })
  public void testGetExternalIdByInternalWithWidgetsBundleId2() {
    // Arrange
    when(widgetsBundleRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId internalId = mock(WidgetsBundleId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundleId actualExternalIdByInternal =
        jpaWidgetsBundleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(widgetsBundleRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)} with {@code
   * WidgetsBundleId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#getExternalIdByInternal(WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundleId JpaWidgetsBundleDao.getExternalIdByInternal(WidgetsBundleId)"
  })
  public void testGetExternalIdByInternalWithWidgetsBundleId_thenReturnNull() {
    // Arrange
    when(widgetsBundleRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    WidgetsBundleId actualExternalIdByInternal =
        jpaWidgetsBundleDao.getExternalIdByInternal(new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetsBundleRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(widgetsBundleRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetsBundle> actualFindByTenantAndImageLinkResult =
        jpaWidgetsBundleDao.findByTenantAndImageLink(tenantId, "https://example.org/example", 1);

    // Assert
    verify(tenantId).getId();
    verify(widgetsBundleRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Alias is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstAliasIs42() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("42");
    widgetsBundleEntity.setCreatedTime(-1L);
    widgetsBundleEntity.setDescription("org.thingsboard.server.dao.model.sql.WidgetsBundleEntity");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("42");
    widgetsBundleEntity.setOrder(-1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Prof");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(-1L);

    ArrayList<WidgetsBundleEntity> widgetsBundleEntityList = new ArrayList<>();
    widgetsBundleEntityList.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetsBundleEntityList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetsBundle> actualFindByTenantAndImageLinkResult =
        jpaWidgetsBundleDao.findByTenantAndImageLink(tenantId, "https://example.org/example", 1);

    // Assert
    verify(tenantId).getId();
    verify(widgetsBundleRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    WidgetsBundle getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("42", getResult.getAlias());
    assertEquals("42", getResult.getImage());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.WidgetsBundleEntity", getResult.getDescription());
    assertEquals(-1, getResult.getOrder().intValue());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Alias is {@code Alias}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstAliasIsAlias() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> widgetsBundleEntityList = new ArrayList<>();
    widgetsBundleEntityList.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetsBundleEntityList);

    // Act
    List<WidgetsBundle> actualFindByTenantAndImageLinkResult =
        jpaWidgetsBundleDao.findByTenantAndImageLink(
            ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetsBundleRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    WidgetsBundle getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertSame(TenantId.SYS_TENANT_ID, getResult.getTenantId());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByTenantAndImageLink(TenantId, String,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetsBundleRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetsBundle> actualFindByTenantAndImageLinkResult =
        jpaWidgetsBundleDao.findByTenantAndImageLink(
            ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetsBundleRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenWidgetsBundleEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> widgetsBundleEntityList = new ArrayList<>();
    widgetsBundleEntityList.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(widgetsBundleEntityList);

    // Act
    List<WidgetsBundle> actualFindByImageLinkResult =
        jpaWidgetsBundleDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetsBundleRepository).findByImageUrl("https://example.org/example", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    WidgetsBundle getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenWidgetsBundleEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    ArrayList<WidgetsBundleEntity> widgetsBundleEntityList = new ArrayList<>();
    widgetsBundleEntityList.add(widgetsBundleEntity);
    when(widgetsBundleRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(widgetsBundleEntityList);

    // Act
    List<WidgetsBundle> actualFindByImageLinkResult =
        jpaWidgetsBundleDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetsBundleRepository).findByImageUrl("https://example.org/example", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    WidgetsBundle getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Alias", getResult.getAlias());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetsBundleDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetsBundleDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetsBundleDao.findByImageLink(String, int)"})
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(widgetsBundleRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetsBundle> actualFindByImageLinkResult =
        jpaWidgetsBundleDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetsBundleRepository).findByImageUrl("https://example.org/example", 1);
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
