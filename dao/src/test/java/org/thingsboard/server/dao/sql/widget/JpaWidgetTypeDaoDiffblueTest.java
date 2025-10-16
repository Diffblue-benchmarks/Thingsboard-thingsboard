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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.DeprecatedFilter;
import org.thingsboard.server.common.data.widget.WidgetType;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter.WidgetTypeFilterBuilder;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.common.data.widget.WidgetsBundleWidget;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity;
import org.thingsboard.server.dao.model.sql.WidgetTypeEntity;
import org.thingsboard.server.dao.model.sql.WidgetTypeIdFqnEntity;
import org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity;
import org.thingsboard.server.dao.model.sql.WidgetsBundleWidgetCompositeKey;
import org.thingsboard.server.dao.model.sql.WidgetsBundleWidgetEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaWidgetTypeDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaWidgetTypeDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaWidgetTypeDao jpaWidgetTypeDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private WidgetTypeInfoRepository widgetTypeInfoRepository;

  @MockBean private WidgetTypeRepository widgetTypeRepository;

  @MockBean private WidgetsBundleWidgetRepository widgetsBundleWidgetRepository;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaWidgetTypeDao#getEntityClass()}
   *   <li>{@link JpaWidgetTypeDao#getEntityType()}
   *   <li>{@link JpaWidgetTypeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaWidgetTypeDao.getEntityClass()",
    "EntityType JpaWidgetTypeDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaWidgetTypeDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaWidgetTypeDao jpaWidgetTypeDao = new JpaWidgetTypeDao();

    // Act
    Class<WidgetTypeDetailsEntity> actualEntityClass = jpaWidgetTypeDao.getEntityClass();
    EntityType actualEntityType = jpaWidgetTypeDao.getEntityType();

    // Assert
    assertNull(jpaWidgetTypeDao.getRepository());
    assertEquals(EntityType.WIDGET_TYPE, actualEntityType);
    Class<WidgetTypeDetailsEntity> expectedEntityClass = WidgetTypeDetailsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType JpaWidgetTypeDao.findWidgetTypeById(TenantId, UUID)"})
  public void testFindWidgetTypeById_thenDescriptorReturnObjectNode() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(UUID.randomUUID());
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeById(Mockito.<UUID>any())).thenReturn(widgetTypeEntity);
    UUID widgetTypeId = ModelConstants.NULL_UUID;

    // Act
    WidgetType actualFindWidgetTypeByIdResult =
        jpaWidgetTypeDao.findWidgetTypeById(ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypeById(isA(UUID.class));
    assertTrue(actualFindWidgetTypeByIdResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindWidgetTypeByIdResult.getFqn());
    assertEquals("Name", actualFindWidgetTypeByIdResult.getName());
    assertEquals(1L, actualFindWidgetTypeByIdResult.getVersion().longValue());
    assertEquals(1L, actualFindWidgetTypeByIdResult.getCreatedTime());
    assertTrue(actualFindWidgetTypeByIdResult.isDeprecated());
    assertTrue(actualFindWidgetTypeByIdResult.isScada());
    assertSame(widgetTypeId, actualFindWidgetTypeByIdResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType JpaWidgetTypeDao.findWidgetTypeById(TenantId, UUID)"})
  public void testFindWidgetTypeById_thenReturnTenantIdIsSys_tenant_id() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeById(Mockito.<UUID>any())).thenReturn(widgetTypeEntity);

    // Act
    WidgetType actualFindWidgetTypeByIdResult =
        jpaWidgetTypeDao.findWidgetTypeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypeById(isA(UUID.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindWidgetTypeByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaWidgetTypeDao.existsByTenantIdAndId(TenantId, UUID)"})
  public void testExistsByTenantIdAndId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndIdResult =
        jpaWidgetTypeDao.existsByTenantIdAndId(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaWidgetTypeDao.existsByTenantIdAndId(TenantId, UUID)"})
  public void testExistsByTenantIdAndId_thenReturnFalse() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndIdResult =
        jpaWidgetTypeDao.existsByTenantIdAndId(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaWidgetTypeDao.existsByTenantIdAndId(TenantId, UUID)"})
  public void testExistsByTenantIdAndId_whenSystem_tenant_thenReturnTrue() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndIdResult =
        jpaWidgetTypeDao.existsByTenantIdAndId(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindSystemWidgetTypesResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then calls {@link
   *       WidgetTypeFilter.WidgetTypeFilterBuilder#deprecatedFilter(DeprecatedFilter)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes_givenBuilder_thenCallsDeprecatedFilter() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder tenantIdResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(
            WidgetTypeFilter.builder()
                .deprecatedFilter(DeprecatedFilter.ALL)
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .widgetTypes(widgetTypes)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first Fqn is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes_thenReturnDataFirstFqnIs42() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(0L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setFqn("42");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("42");
    widgetTypeInfoEntity.setName("42");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity.setTenantId(tenantId);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(0L);
    widgetTypeInfoEntity.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder tenantIdResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindSystemWidgetTypesResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findSystemWidgetTypes(WidgetTypeFilter, PageLink)"})
  public void testFindSystemWidgetTypes_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult =
        jpaWidgetTypeDao.findSystemWidgetTypes(
            tenantIdResult.widgetTypes(new ArrayList<>()).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findSystemWidgetTypes(
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId2() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindAllTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then calls {@link
   *       WidgetTypeFilter.WidgetTypeFilterBuilder#deprecatedFilter(DeprecatedFilter)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId_givenBuilder_thenCallsDeprecatedFilter() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder scadaFirstResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult = scadaFirstResult.tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(
            WidgetTypeFilter.builder()
                .deprecatedFilter(DeprecatedFilter.ALL)
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .widgetTypes(widgetTypes)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first Fqn is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId_thenReturnDataFirstFqnIs42() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(0L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setFqn("42");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("42");
    widgetTypeInfoEntity.setName("42");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity.setTenantId(tenantId);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(0L);
    widgetTypeInfoEntity.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder scadaFirstResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult = scadaFirstResult.tenantId(tenantId2);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindAllTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findAllTenantWidgetTypesByTenantId(
            tenantIdResult.widgetTypes(new ArrayList<>()).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findAllTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId2() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then calls {@link
   *       WidgetTypeFilter.WidgetTypeFilterBuilder#deprecatedFilter(DeprecatedFilter)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId_givenBuilder_thenCallsDeprecatedFilter() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder scadaFirstResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult = scadaFirstResult.tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(
            WidgetTypeFilter.builder()
                .deprecatedFilter(DeprecatedFilter.ALL)
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .widgetTypes(widgetTypes)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first Fqn is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId_thenReturnDataFirstFqnIs42() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(0L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setFqn("42");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("42");
    widgetTypeInfoEntity.setName("42");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity.setTenantId(tenantId);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(0L);
    widgetTypeInfoEntity.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());

    WidgetTypeFilterBuilder scadaFirstResult =
        widgetTypeFilterBuilder
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult = scadaFirstResult.tenantId(tenantId2);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(DeprecatedFilter.ALL);
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            anyBoolean(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult =
        jpaWidgetTypeDao.findTenantWidgetTypesByTenantId(
            tenantIdResult.widgetTypes(new ArrayList<>()).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findTenantWidgetTypesByTenantId(
            isA(UUID.class),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            eq(true),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesByWidgetsBundleId_givenWidgetTypeEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    ArrayList<WidgetTypeEntity> widgetTypeEntityList = new ArrayList<>();
    widgetTypeEntityList.add(widgetTypeEntity);
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(
            ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesByWidgetsBundleIdResult.size());
    WidgetType getResult = actualFindWidgetTypesByWidgetsBundleIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Name", getResult.getName());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesByWidgetsBundleId_givenWidgetTypeEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(UUID.randomUUID());
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    ArrayList<WidgetTypeEntity> widgetTypeEntityList = new ArrayList<>();
    widgetTypeEntityList.add(widgetTypeEntity);
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(
            ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesByWidgetsBundleIdResult.size());
    WidgetType getResult = actualFindWidgetTypesByWidgetsBundleIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Name", getResult.getName());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesByWidgetsBundleId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesDetailsByWidgetsBundleId() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesDetailsByWidgetsBundleId2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetTypesDetailsByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    ArrayList<String> widgetTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId2() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(UUID.randomUUID());
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    ArrayList<String> widgetTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenEmptyString() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("");
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq(""),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq(""),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<String> widgetTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code null}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenOne_whenNull_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<String> widgetTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true, null, widgetTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq("Text Search"),
            eq(true),
            eq(true),
            eq(false),
            eq(true),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean,
   * DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   * boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_whenFirst_page() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            true,
            DeprecatedFilter.ALL,
            new ArrayList<>(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            eq(""),
            eq(true),
            eq(false),
            eq(false),
            eq(true),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetFqnsByWidgetsBundleId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetFqnsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetFqnsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetFqnsByWidgetsBundleId() {
    // Arrange
    when(widgetTypeRepository.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetFqnsByWidgetsBundleId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetFqnsByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType JpaWidgetTypeDao.findByTenantIdAndFqn(UUID, String)"})
  public void testFindByTenantIdAndFqn_givenWidgetTypeEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeByTenantIdAndFqn(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetType actualFindByTenantIdAndFqnResult =
        jpaWidgetTypeDao.findByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(widgetTypeRepository).findWidgetTypeByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertTrue(actualFindByTenantIdAndFqnResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindByTenantIdAndFqnResult.getFqn());
    assertEquals("Name", actualFindByTenantIdAndFqnResult.getName());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndFqnResult.isScada());
    assertSame(tenantId, actualFindByTenantIdAndFqnResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor) TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType JpaWidgetTypeDao.findByTenantIdAndFqn(UUID, String)"})
  public void testFindByTenantIdAndFqn_givenWidgetTypeEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(UUID.randomUUID());
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeByTenantIdAndFqn(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetType actualFindByTenantIdAndFqnResult =
        jpaWidgetTypeDao.findByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(widgetTypeRepository).findWidgetTypeByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertTrue(actualFindByTenantIdAndFqnResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindByTenantIdAndFqnResult.getFqn());
    assertEquals("Name", actualFindByTenantIdAndFqnResult.getName());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndFqnResult.isScada());
    assertSame(tenantId, actualFindByTenantIdAndFqnResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails JpaWidgetTypeDao.findDetailsByTenantIdAndFqn(UUID, String)"
  })
  public void testFindDetailsByTenantIdAndFqn_givenWidgetTypeDetailsEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindDetailsByTenantIdAndFqnResult =
        jpaWidgetTypeDao.findDetailsByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindDetailsByTenantIdAndFqnResult.getFqn());
    assertEquals("Image", actualFindDetailsByTenantIdAndFqnResult.getImage());
    assertEquals("Name", actualFindDetailsByTenantIdAndFqnResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDetailsByTenantIdAndFqnResult.getDescription());
    assertEquals(1, actualFindDetailsByTenantIdAndFqnResult.getTags().length);
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getCreatedTime());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isScada());
    assertSame(tenantId, actualFindDetailsByTenantIdAndFqnResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails JpaWidgetTypeDao.findDetailsByTenantIdAndFqn(UUID, String)"
  })
  public void testFindDetailsByTenantIdAndFqn_givenWidgetTypeDetailsEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindDetailsByTenantIdAndFqnResult =
        jpaWidgetTypeDao.findDetailsByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindDetailsByTenantIdAndFqnResult.getFqn());
    assertEquals("Image", actualFindDetailsByTenantIdAndFqnResult.getImage());
    assertEquals("Name", actualFindDetailsByTenantIdAndFqnResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindDetailsByTenantIdAndFqnResult.getDescription());
    assertEquals(1, actualFindDetailsByTenantIdAndFqnResult.getTags().length);
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getCreatedTime());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isScada());
    assertSame(tenantId, actualFindDetailsByTenantIdAndFqnResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)"
  })
  public void testFindWidgetTypesInfosByTenantIdAndResourceId() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);
    UUID tbResourceId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            ModelConstants.NULL_UUID, tbResourceId);

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(tbResourceId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)"
  })
  public void testFindWidgetTypesInfosByTenantIdAndResourceId2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);
    UUID tbResourceId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            ModelConstants.NULL_UUID, tbResourceId);

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(tbResourceId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)"
  })
  public void testFindWidgetTypesInfosByTenantIdAndResourceId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult =
        jpaWidgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(UUID, List)"})
  public void testFindWidgetTypeIdsByTenantIdAndFqns_given42_whenArrayListAdd42() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("42");
    widgetFqns.add("foo");

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult =
        jpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, widgetFqns);

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(UUID, List)"})
  public void testFindWidgetTypeIdsByTenantIdAndFqns_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("foo");

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult =
        jpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, widgetFqns);

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(UUID, List)"})
  public void testFindWidgetTypeIdsByTenantIdAndFqns_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<WidgetTypeIdFqnEntity> widgetTypeIdFqnEntityList = new ArrayList<>();
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdFqnEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult =
        jpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(tenantId, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindWidgetTypeIdsByTenantIdAndFqnsResult.size());
    WidgetTypeId getResult = actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(0);
    assertEquals(EntityType.WIDGET_TYPE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(tenantId, getResult.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(UUID, List)"})
  public void testFindWidgetTypeIdsByTenantIdAndFqns_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<WidgetTypeIdFqnEntity> widgetTypeIdFqnEntityList = new ArrayList<>();
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdFqnEntityList);

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult =
        jpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindWidgetTypeIdsByTenantIdAndFqnsResult.size());
    WidgetTypeId expectedGetResult = actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(0);
    assertEquals(expectedGetResult, actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(UUID, List)"})
  public void testFindWidgetTypeIdsByTenantIdAndFqns_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult =
        jpaWidgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository)
        .findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails JpaWidgetTypeDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenWidgetTypeDetailsEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindByTenantIdAndExternalIdResult =
        jpaWidgetTypeDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindByTenantIdAndExternalIdResult.getFqn());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getTags().length);
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isScada());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails JpaWidgetTypeDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenWidgetTypeDetailsEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindByTenantIdAndExternalIdResult =
        jpaWidgetTypeDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualFindByTenantIdAndExternalIdResult.getFqn());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals(
        "The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getTags().length);
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isScada());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(
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
    PageData<WidgetTypeDetails> actualFindByTenantIdResult =
        jpaWidgetTypeDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository)
        .findTenantWidgetTypeDetailsByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenWidgetTypeDetailsEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> content = new ArrayList<>();
    content.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(
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
    PageData<WidgetTypeDetails> actualFindByTenantIdResult =
        jpaWidgetTypeDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository)
        .findTenantWidgetTypeDetailsByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetTypeDetails> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeDetails getResult = data.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenWidgetTypeDetailsEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> content = new ArrayList<>();
    content.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(
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
    PageData<WidgetTypeDetails> actualFindByTenantIdResult =
        jpaWidgetTypeDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository)
        .findTenantWidgetTypeDetailsByTenantId(
            isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<WidgetTypeDetails> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeDetails getResult = data.get(0);
    assertTrue(getResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeDetails> actualFindByTenantIdResult =
        jpaWidgetTypeDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository)
        .findTenantWidgetTypeDetailsByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
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
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult =
        jpaWidgetTypeDao.findIdsByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<WidgetTypeId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindIdsByTenantIdResult.getTotalElements());
    WidgetTypeId getResult = data.get(0);
    assertEquals(EntityType.WIDGET_TYPE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(tenantId, getResult.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult =
        jpaWidgetTypeDao.findIdsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<WidgetTypeId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    WidgetTypeId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult =
        jpaWidgetTypeDao.findIdsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findIdsByTenantId(UUID, PageLink)"})
  public void testFindIdsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult =
        jpaWidgetTypeDao.findIdsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)} with {@code WidgetTypeId}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeId JpaWidgetTypeDao.getExternalIdByInternal(WidgetTypeId)"})
  public void testGetExternalIdByInternalWithWidgetTypeId() {
    // Arrange
    when(widgetTypeRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    WidgetTypeId internalId = new WidgetTypeId(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeId actualExternalIdByInternal = jpaWidgetTypeDao.getExternalIdByInternal(internalId);

    // Assert
    verify(widgetTypeRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)} with {@code WidgetTypeId}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeId JpaWidgetTypeDao.getExternalIdByInternal(WidgetTypeId)"})
  public void testGetExternalIdByInternalWithWidgetTypeId2() {
    // Arrange
    when(widgetTypeRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeId internalId = mock(WidgetTypeId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeId actualExternalIdByInternal = jpaWidgetTypeDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(widgetTypeRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)} with {@code WidgetTypeId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeId JpaWidgetTypeDao.getExternalIdByInternal(WidgetTypeId)"})
  public void testGetExternalIdByInternalWithWidgetTypeId_thenReturnNull() {
    // Arrange
    when(widgetTypeRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    WidgetTypeId actualExternalIdByInternal =
        jpaWidgetTypeDao.getExternalIdByInternal(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetsBundleWidgetsByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetsBundleWidgetRepository.findAllByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetsBundleWidget> actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetsBundleWidgetRepository).findAllByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)"})
  public void testFindWidgetsBundleWidgetsByWidgetsBundleId_thenReturnSizeIsOne() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetsBundleWidgetEntity> widgetsBundleWidgetEntityList = new ArrayList<>();
    widgetsBundleWidgetEntityList.add(widgetsBundleWidgetEntity);
    when(widgetsBundleWidgetRepository.findAllByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetsBundleWidget> actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult =
        jpaWidgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetsBundleWidgetRepository).findAllByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult.size());
    WidgetsBundleWidget getResult = actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult.get(0);
    assertEquals(1, getResult.getWidgetTypeOrder());
    WidgetsBundleId widgetsBundleId2 = getResult.getWidgetsBundleId();
    assertEquals(EntityType.WIDGETS_BUNDLE, widgetsBundleId2.getEntityType());
    WidgetTypeId widgetTypeId = getResult.getWidgetTypeId();
    assertEquals(EntityType.WIDGET_TYPE, widgetTypeId.getEntityType());
    assertTrue(widgetTypeId.isNullUid());
    assertTrue(widgetsBundleId2.isNullUid());
    assertSame(widgetsBundleId, widgetTypeId.getId());
    assertSame(widgetsBundleId, widgetsBundleId2.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId} {@link WidgetTypeId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaWidgetTypeDao.saveWidgetsBundleWidget(WidgetsBundleWidget)"})
  public void testSaveWidgetsBundleWidget_givenWidgetTypeIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);
    when(widgetsBundleWidgetRepository.save(Mockito.<WidgetsBundleWidgetEntity>any()))
        .thenReturn(widgetsBundleWidgetEntity);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();
    widgetsBundleWidget.setWidgetTypeId(widgetTypeId);
    widgetsBundleWidget.setWidgetsBundleId(widgetsBundleId);

    // Act
    jpaWidgetTypeDao.saveWidgetsBundleWidget(widgetsBundleWidget);

    // Assert
    verify(widgetsBundleWidgetRepository).save(isA(WidgetsBundleWidgetEntity.class));
    verify(widgetTypeId).getId();
    verify(widgetsBundleId).getId();
  }

  /**
   * Test {@link JpaWidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaWidgetTypeDao.saveWidgetsBundleWidget(WidgetsBundleWidget)"})
  public void testSaveWidgetsBundleWidget_givenWidgetTypeIdWithIdIsNull_uuid() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);
    when(widgetsBundleWidgetRepository.save(Mockito.<WidgetsBundleWidgetEntity>any()))
        .thenReturn(widgetsBundleWidgetEntity);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();
    widgetsBundleWidget.setWidgetTypeId(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetsBundleWidget.setWidgetsBundleId(widgetsBundleId);

    // Act
    jpaWidgetTypeDao.saveWidgetsBundleWidget(widgetsBundleWidget);

    // Assert
    verify(widgetsBundleWidgetRepository).save(isA(WidgetsBundleWidgetEntity.class));
    verify(widgetsBundleId).getId();
  }

  /**
   * Test {@link JpaWidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaWidgetTypeDao.removeWidgetTypeFromWidgetsBundle(UUID, UUID)"})
  public void testRemoveWidgetTypeFromWidgetsBundle() {
    // Arrange
    doNothing()
        .when(widgetsBundleWidgetRepository)
        .deleteById(Mockito.<WidgetsBundleWidgetCompositeKey>any());

    // Act
    jpaWidgetTypeDao.removeWidgetTypeFromWidgetsBundle(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetsBundleWidgetRepository).deleteById(isA(WidgetsBundleWidgetCompositeKey.class));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findAllWidgetTypesIds(PageLink)"})
  public void testFindAllWidgetTypesIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult =
        jpaWidgetTypeDao.findAllWidgetTypesIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    List<WidgetTypeId> data = actualFindAllWidgetTypesIdsResult.getData();
    assertEquals(1, data.size());
    WidgetTypeId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(EntityType.WIDGET_TYPE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findAllWidgetTypesIds(PageLink)"})
  public void testFindAllWidgetTypesIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult =
        jpaWidgetTypeDao.findAllWidgetTypesIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    List<WidgetTypeId> data = actualFindAllWidgetTypesIdsResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    WidgetTypeId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findAllWidgetTypesIds(PageLink)"})
  public void testFindAllWidgetTypesIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult =
        jpaWidgetTypeDao.findAllWidgetTypesIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetTypesIdsResult.getTotalPages());
    assertFalse(actualFindAllWidgetTypesIdsResult.hasNext());
    assertTrue(actualFindAllWidgetTypesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaWidgetTypeDao.findAllWidgetTypesIds(PageLink)"})
  public void testFindAllWidgetTypesIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult =
        jpaWidgetTypeDao.findAllWidgetTypesIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetTypesIdsResult.getTotalPages());
    assertFalse(actualFindAllWidgetTypesIdsResult.hasNext());
    assertTrue(actualFindAllWidgetTypesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult =
        jpaWidgetTypeDao.findByTenantAndImageLink(tenantId, "https://example.org/example", 1);

    // Assert
    verify(tenantId).getId();
    verify(widgetTypeInfoRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Fqn is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstFqnIs42() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(-1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setFqn("42");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("42");
    widgetTypeInfoEntity.setName("42");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity.setTenantId(tenantId);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(-1L);
    widgetTypeInfoEntity.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult =
        jpaWidgetTypeDao.findByTenantAndImageLink(tenantId2, "https://example.org/example", 1);

    // Assert
    verify(tenantId2).getId();
    verify(widgetTypeInfoRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals(
        "org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>Then return first Fqn is {@code Fqn}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_thenReturnFirstFqnIsFqn() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult =
        jpaWidgetTypeDao.findByTenantAndImageLink(
            ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertSame(TenantId.SYS_TENANT_ID, getResult.getTenantId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByTenantAndImageLink(TenantId, String, int)"})
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(
            Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult =
        jpaWidgetTypeDao.findByTenantAndImageLink(
            ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository)
        .findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeInfoEntity} (default constructor) TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenWidgetTypeInfoEntityTenantIdIsNull_uuid() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult =
        jpaWidgetTypeDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository).findByImageUrl("https://example.org/example", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeInfoEntity} (default constructor) TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByImageLink(String, int)"})
  public void testFindByImageLink_givenWidgetTypeInfoEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[] {"Tags"});
    widgetTypeInfoEntity.setTenantId(UUID.randomUUID());
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult =
        jpaWidgetTypeDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository).findByImageUrl("https://example.org/example", 1);
    assertEquals(1, actualFindByImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1, getResult.getTags().length);
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaWidgetTypeDao.findByImageLink(String, int)"})
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult =
        jpaWidgetTypeDao.findByImageLink("https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository).findByImageUrl("https://example.org/example", 1);
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }
}
