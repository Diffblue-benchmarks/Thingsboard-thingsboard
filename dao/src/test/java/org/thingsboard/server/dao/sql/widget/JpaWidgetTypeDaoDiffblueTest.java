package org.thingsboard.server.dao.sql.widget;

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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaWidgetTypeDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaWidgetTypeDao jpaWidgetTypeDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private WidgetTypeInfoRepository widgetTypeInfoRepository;

  @MockBean
  private WidgetTypeRepository widgetTypeRepository;

  @MockBean
  private WidgetsBundleWidgetRepository widgetsBundleWidgetRepository;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaWidgetTypeDao#getEntityClass()}
   *   <li>{@link JpaWidgetTypeDao#getEntityType()}
   *   <li>{@link JpaWidgetTypeDao#getRepository()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeById(TenantId, UUID)}
   */
  @Test
  public void testFindWidgetTypeById_thenReturnNotTenantIdNullUid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    UUID tenantId = UUID.randomUUID();
    widgetTypeEntity.setTenantId(tenantId);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeById(Mockito.<UUID>any())).thenReturn(widgetTypeEntity);

    // Act
    WidgetType actualFindWidgetTypeByIdResult = jpaWidgetTypeDao.findWidgetTypeById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypeById(isA(UUID.class));
    TenantId tenantId2 = actualFindWidgetTypeByIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  public void testExistsByTenantIdAndId_thenReturnFalse() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndIdResult = jpaWidgetTypeDao.existsByTenantIdAndId(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  public void testExistsByTenantIdAndId_thenReturnTrue() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndIdResult = jpaWidgetTypeDao.existsByTenantIdAndId(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), isNull(), eq(true), eq(false), eq(false),
        eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes2() {
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
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), isNull(), eq(true), eq(false), eq(false),
        eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindSystemWidgetTypesResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId id = getResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(uuidId, id.getId());
    assertArrayEquals(new String[]{"Tags"}, getResult.getTags());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes_givenBuilder_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), isNull(), eq(true), eq(true), eq(false),
        eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(widgetTypes).build();

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), isNull(), eq(true), eq(true), eq(false),
        eq(false), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), eq("Text Search"), eq(true), eq(true),
        eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindSystemWidgetTypesResult.getTotalElements());
    assertEquals(1, actualFindSystemWidgetTypesResult.getTotalPages());
    assertFalse(actualFindSystemWidgetTypesResult.hasNext());
    assertTrue(actualFindSystemWidgetTypesResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findSystemWidgetTypes(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindSystemWidgetTypes_thenReturnDataFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(false);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(false);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findSystemWidgetTypes(Mockito.<UUID>any(), Mockito.<String>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesResult = jpaWidgetTypeDao
        .findSystemWidgetTypes(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(false));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(false));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findSystemWidgetTypes(isA(UUID.class), eq("Text Search"), eq(true), eq(true),
        eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindSystemWidgetTypesResult.getData();
    assertEquals(1, data.size());
    assertSame(widgetTypeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantId() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class), isNull(),
        eq(true), eq(false), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
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
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class), isNull(),
        eq(true), eq(false), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindAllTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId id = getResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(uuidId, id.getId());
    assertArrayEquals(new String[]{"Tags"}, getResult.getTags());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(widgetTypes).build();

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class), isNull(),
        eq(true), eq(true), eq(false), eq(false), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), eq(true), eq(true), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantId_thenReturnDataFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(false);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(false);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(false));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(false));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), eq(true), eq(true), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindAllTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(widgetTypeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findAllTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantWidgetTypesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findAllTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(),
        anyBoolean(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findAllTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findAllTenantWidgetTypesByTenantId(isA(UUID.class), isA(UUID.class), isNull(),
        eq(true), eq(true), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantId() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), isNull(), eq(true), eq(false),
        eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
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
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = WidgetTypeFilter.builder()
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), isNull(), eq(true), eq(false),
        eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeInfo getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals("Widget Type", getResult.getWidgetType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId id = getResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(uuidId, id.getId());
    assertArrayEquals(new String[]{"Tags"}, getResult.getTags());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(widgetTypes).build();

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), isNull(), eq(true), eq(true),
        eq(false), eq(false), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), eq("Text Search"), eq(true),
        eq(true), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantId_thenReturnDataFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(false);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(false);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(false));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(false));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), eq("Text Search"), eq(true),
        eq(true), eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindTenantWidgetTypesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(widgetTypeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter, PageLink)}
   */
  @Test
  public void testFindTenantWidgetTypesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findTenantWidgetTypesByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), anyBoolean(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    WidgetTypeFilter.WidgetTypeFilterBuilder widgetTypeFilterBuilder = mock(
        WidgetTypeFilter.WidgetTypeFilterBuilder.class);
    when(widgetTypeFilterBuilder.deprecatedFilter(Mockito.<DeprecatedFilter>any()))
        .thenReturn(WidgetTypeFilter.builder());
    WidgetTypeFilter.WidgetTypeFilterBuilder tenantIdResult = widgetTypeFilterBuilder
        .deprecatedFilter(DeprecatedFilter.ALL)
        .fullSearch(true)
        .scadaFirst(true)
        .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdResult = jpaWidgetTypeDao
        .findTenantWidgetTypesByTenantId(widgetTypeFilter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeFilterBuilder).deprecatedFilter(eq(DeprecatedFilter.ALL));
    verify(widgetTypeInfoRepository).findTenantWidgetTypesByTenantId(isA(UUID.class), isNull(), eq(true), eq(true),
        eq(false), eq(true), isA(List.class), eq(true), isA(Pageable.class));
    assertEquals(0L, actualFindTenantWidgetTypesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantWidgetTypesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantWidgetTypesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantWidgetTypesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesByWidgetsBundleId() throws IOException {
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
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any())).thenReturn(widgetTypeEntityList);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesByWidgetsBundleId(ModelConstants.NULL_UUID, widgetsBundleId);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesByWidgetsBundleIdResult.size());
    WidgetType getResult = actualFindWidgetTypesByWidgetsBundleIdResult.get(0);
    JsonNode descriptor = getResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId id = getResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(widgetsBundleId, getResult.getUuidId());
    assertSame(widgetsBundleId, id.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return not first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesByWidgetsBundleId_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    UUID tenantId = UUID.randomUUID();
    widgetTypeEntity.setTenantId(tenantId);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    ArrayList<WidgetTypeEntity> widgetTypeEntityList = new ArrayList<>();
    widgetTypeEntityList.add(widgetTypeEntity);
    when(widgetTypeRepository.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any())).thenReturn(widgetTypeEntityList);

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesByWidgetsBundleIdResult.size());
    TenantId tenantId2 = actualFindWidgetTypesByWidgetsBundleIdResult.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesDetailsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesDetailsByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesDetailsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return first is {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesDetailsByWidgetsBundleId_thenReturnFirstIsWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesDetailsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.size());
    assertSame(widgetTypeDetails, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesDetailsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesDetailsByWidgetsBundleId_thenReturnSizeIsTwo() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(-1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("42");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("42");
    widgetTypeDetailsEntity2.setName("42");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeDetailsEntity2.setTenantId(tenantId);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(-1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity2);
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesDetailsByWidgetsBundleId(Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesDetailsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class));
    assertEquals(2, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(widgetTypeDetails, actualFindWidgetTypesDetailsByWidgetsBundleIdResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
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
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, widgetsBundleId, true, DeprecatedFilter.ALL,
            new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq(""), eq(true), eq(false),
        eq(false), eq(true), isA(List.class), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData();
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId id = getResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    assertSame(widgetsBundleId, getResult.getUuidId());
    assertSame(widgetsBundleId, id.getId());
    assertArrayEquals(new String[]{"Tags"}, getResult.getTags());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenEmptyString() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("");
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true,
            DeprecatedFilter.ALL, widgetTypes, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq(""), eq(true), eq(false),
        eq(false), eq(false), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true,
            DeprecatedFilter.ALL, widgetTypes, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq(""), eq(true), eq(false),
        eq(false), eq(false), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<String> widgetTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true,
            DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq("Text Search"), eq(true),
        eq(false), eq(false), eq(true), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenReturnDataFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(-1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("");
    widgetTypeInfoEntity.setFqn("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setName("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(-1L);
    widgetTypeInfoEntity.setWidgetType("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");

    ArrayList<WidgetTypeInfoEntity> content = new ArrayList<>();
    content.add(widgetTypeInfoEntity);
    PageImpl<WidgetTypeInfoEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    ArrayList<String> widgetTypes = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true,
            DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeInfoEntity).setCreatedTime(eq(-1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(-1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(true));
    verify(widgetTypeInfoEntity).setFqn(eq("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity"));
    verify(widgetTypeInfoEntity).setName(eq("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity"));
    verify(widgetTypeInfoEntity).setScada(eq(true));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq(""));
    verify(widgetTypeInfoEntity).setImage(eq("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq("Text Search"), eq(true),
        eq(false), eq(false), eq(true), isA(List.class), isA(Pageable.class));
    List<WidgetTypeInfo> data = actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData();
    assertEquals(1, data.size());
    assertSame(widgetTypeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true,
            DeprecatedFilter.ALL, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq(""), eq(true), eq(false),
        eq(false), eq(true), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID, boolean, DeprecatedFilter, List, PageLink)}
   */
  @Test
  public void testFindWidgetTypesInfosByWidgetsBundleId_whenNull_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeInfoRepository.findWidgetTypesInfosByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<List<String>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, true, null,
            new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeInfoRepository).findWidgetTypesInfosByWidgetsBundleId(isA(UUID.class), eq(""), eq(true), eq(true),
        eq(false), eq(true), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalElements());
    assertEquals(1, actualFindWidgetTypesInfosByWidgetsBundleIdResult.getTotalPages());
    assertFalse(actualFindWidgetTypesInfosByWidgetsBundleIdResult.hasNext());
    assertTrue(actualFindWidgetTypesInfosByWidgetsBundleIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetFqnsByWidgetsBundleId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetFqnsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetFqnsByWidgetsBundleId() {
    // Arrange
    when(widgetTypeRepository.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetFqnsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetFqnsByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndFqn_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
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
    when(widgetTypeRepository.findWidgetTypeByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetType actualFindByTenantIdAndFqnResult = jpaWidgetTypeDao.findByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(widgetTypeRepository).findWidgetTypeByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    JsonNode descriptor = actualFindByTenantIdAndFqnResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindByTenantIdAndFqnResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Fqn", actualFindByTenantIdAndFqnResult.getFqn());
    assertEquals("Name", actualFindByTenantIdAndFqnResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndFqnResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    WidgetTypeId id = actualFindByTenantIdAndFqnResult.getId();
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(id.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(actualFindByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndFqnResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindByTenantIdAndFqnResult.getUuidId());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantIdAndFqn(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndFqn_thenReturnNotTenantIdNullUid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    UUID tenantId = UUID.randomUUID();
    widgetTypeEntity.setTenantId(tenantId);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    when(widgetTypeRepository.findWidgetTypeByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeEntity);

    // Act
    WidgetType actualFindByTenantIdAndFqnResult = jpaWidgetTypeDao.findByTenantIdAndFqn(ModelConstants.NULL_UUID,
        "Fqn");

    // Assert
    verify(widgetTypeRepository).findWidgetTypeByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    TenantId tenantId2 = actualFindByTenantIdAndFqnResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}
   */
  @Test
  public void testFindDetailsByTenantIdAndFqn_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindDetailsByTenantIdAndFqnResult = jpaWidgetTypeDao.findDetailsByTenantIdAndFqn(tenantId,
        "Fqn");

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    JsonNode descriptor = actualFindDetailsByTenantIdAndFqnResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindDetailsByTenantIdAndFqnResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Fqn", actualFindDetailsByTenantIdAndFqnResult.getFqn());
    assertEquals("Image", actualFindDetailsByTenantIdAndFqnResult.getImage());
    assertEquals("Name", actualFindDetailsByTenantIdAndFqnResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("The characteristics of someone or something",
        actualFindDetailsByTenantIdAndFqnResult.getDescription());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getVersion().longValue());
    assertEquals(1L, actualFindDetailsByTenantIdAndFqnResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    WidgetTypeId externalId = actualFindDetailsByTenantIdAndFqnResult.getExternalId();
    assertEquals(EntityType.WIDGET_TYPE, externalId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(tenantId2.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isDeprecated());
    assertTrue(actualFindDetailsByTenantIdAndFqnResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindDetailsByTenantIdAndFqnResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindDetailsByTenantIdAndFqnResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertArrayEquals(new String[]{"Tags"}, actualFindDetailsByTenantIdAndFqnResult.getTags());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findDetailsByTenantIdAndFqn(UUID, String)}
   */
  @Test
  public void testFindDetailsByTenantIdAndFqn_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetailsEntity);

    // Act
    WidgetTypeDetails actualFindDetailsByTenantIdAndFqnResult = jpaWidgetTypeDao
        .findDetailsByTenantIdAndFqn(ModelConstants.NULL_UUID, "Fqn");

    // Assert
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetTypeDetails, actualFindDetailsByTenantIdAndFqnResult);
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}
   */
  @Test
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByTenantIdAndResourceId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesInfosByTenantIdAndResourceId2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByTenantIdAndResourceId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.size());
    assertSame(widgetTypeDetails, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesInfosByTenantIdAndResourceId_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByTenantIdAndResourceId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetTypesInfosByTenantIdAndResourceId_thenReturnSizeIsTwo() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(-1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("42");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("42");
    widgetTypeDetailsEntity2.setName("42");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeDetailsEntity2.setTenantId(tenantId);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(-1L);

    ArrayList<WidgetTypeDetailsEntity> widgetTypeDetailsEntityList = new ArrayList<>();
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity2);
    widgetTypeDetailsEntityList.add(widgetTypeDetailsEntity);
    when(widgetTypeRepository.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntityList);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesInfosByTenantIdAndResourceIdResult = jpaWidgetTypeDao
        .findWidgetTypesInfosByTenantIdAndResourceId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
    assertEquals(2, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.size());
    WidgetTypeDetails getResult = actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(widgetTypeDetails, actualFindWidgetTypesInfosByTenantIdAndResourceIdResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  public void testFindWidgetTypeIdsByTenantIdAndFqns_given42_whenArrayListAdd42() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("42");
    widgetFqns.add("foo");

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult = jpaWidgetTypeDao
        .findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, widgetFqns);

    // Assert
    verify(widgetTypeRepository).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  public void testFindWidgetTypeIdsByTenantIdAndFqns_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("foo");

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult = jpaWidgetTypeDao
        .findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, widgetFqns);

    // Assert
    verify(widgetTypeRepository).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  public void testFindWidgetTypeIdsByTenantIdAndFqns_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<WidgetTypeIdFqnEntity> widgetTypeIdFqnEntityList = new ArrayList<>();
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdFqnEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult = jpaWidgetTypeDao
        .findWidgetTypeIdsByTenantIdAndFqns(tenantId, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindWidgetTypeIdsByTenantIdAndFqnsResult.size());
    WidgetTypeId getResult = actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(0);
    assertEquals(EntityType.WIDGET_TYPE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(tenantId, getResult.getId());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  public void testFindWidgetTypeIdsByTenantIdAndFqns_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<WidgetTypeIdFqnEntity> widgetTypeIdFqnEntityList = new ArrayList<>();
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    widgetTypeIdFqnEntityList.add(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdFqnEntityList);

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult = jpaWidgetTypeDao
        .findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertEquals(2, actualFindWidgetTypeIdsByTenantIdAndFqnsResult.size());
    assertEquals(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(0),
        actualFindWidgetTypeIdsByTenantIdAndFqnsResult.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetTypeIdsByTenantIdAndFqns(UUID, List)}
   */
  @Test
  public void testFindWidgetTypeIdsByTenantIdAndFqns_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(widgetTypeRepository.findWidgetTypeIdsByTenantIdAndFqns(Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeId> actualFindWidgetTypeIdsByTenantIdAndFqnsResult = jpaWidgetTypeDao
        .findWidgetTypeIdsByTenantIdAndFqns(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(widgetTypeRepository).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    assertTrue(actualFindWidgetTypeIdsByTenantIdAndFqnsResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    WidgetTypeDetails actualFindByTenantIdAndExternalIdResult = jpaWidgetTypeDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    JsonNode descriptor = actualFindByTenantIdAndExternalIdResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Fqn", actualFindByTenantIdAndExternalIdResult.getFqn());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("The characteristics of someone or something",
        actualFindByTenantIdAndExternalIdResult.getDescription());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    WidgetTypeId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.WIDGET_TYPE, externalId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(tenantId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDeprecated());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, externalId2.getId());
    assertArrayEquals(new String[]{"Tags"}, actualFindByTenantIdAndExternalIdResult.getTags());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    when(widgetTypeRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntity);

    // Act
    WidgetTypeDetails actualFindByTenantIdAndExternalIdResult = jpaWidgetTypeDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetTypeRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("Fqn"));
    verify(widgetTypeDetailsEntity).setName(eq("Name"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("Image"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    assertSame(widgetTypeDetails, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeDetails> actualFindByTenantIdResult = jpaWidgetTypeDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findTenantWidgetTypeDetailsByTenantId(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenDataFirstDescriptorIteratorNextReturnBooleanNode() throws IOException {
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
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    ArrayList<WidgetTypeDetailsEntity> content = new ArrayList<>();
    content.add(widgetTypeDetailsEntity);
    PageImpl<WidgetTypeDetailsEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<WidgetTypeDetails> actualFindByTenantIdResult = jpaWidgetTypeDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findTenantWidgetTypeDetailsByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<WidgetTypeDetails> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    WidgetTypeDetails getResult = data.get(0);
    JsonNode descriptor = getResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Fqn", getResult.getFqn());
    assertEquals("Image", getResult.getImage());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("The characteristics of someone or something", getResult.getDescription());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    WidgetTypeId externalId = getResult.getExternalId();
    assertEquals(EntityType.WIDGET_TYPE, externalId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(tenantId2.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(getResult.isDeprecated());
    assertTrue(getResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertArrayEquals(new String[]{"Tags"}, getResult.getTags());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is
   * {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = mock(WidgetTypeDetailsEntity.class);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDetailsEntity.toData()).thenReturn(widgetTypeDetails);
    doNothing().when(widgetTypeDetailsEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeDetailsEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeDetailsEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeDetailsEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(widgetTypeDetailsEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(widgetTypeDetailsEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeDetailsEntity).setTags(Mockito.<String[]>any());
    widgetTypeDetailsEntity.setCreatedTime(-1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("42");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("42");
    widgetTypeDetailsEntity.setName("42");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(-1L);

    ArrayList<WidgetTypeDetailsEntity> content = new ArrayList<>();
    content.add(widgetTypeDetailsEntity);
    PageImpl<WidgetTypeDetailsEntity> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeDetails> actualFindByTenantIdResult = jpaWidgetTypeDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeDetailsEntity).setCreatedTime(eq(-1L));
    verify(widgetTypeDetailsEntity).setId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setUuid(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setVersion(eq(-1L));
    verify(widgetTypeDetailsEntity).setDeprecated(eq(true));
    verify(widgetTypeDetailsEntity).setFqn(eq("42"));
    verify(widgetTypeDetailsEntity).setName(eq("42"));
    verify(widgetTypeDetailsEntity).setScada(eq(true));
    verify(widgetTypeDetailsEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setDescription(eq("org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity"));
    verify(widgetTypeDetailsEntity).setDescriptor(isA(JsonNode.class));
    verify(widgetTypeDetailsEntity).setExternalId(isA(UUID.class));
    verify(widgetTypeDetailsEntity).setImage(eq("42"));
    verify(widgetTypeDetailsEntity).setTags(isA(String[].class));
    verify(widgetTypeDetailsEntity).toData();
    verify(widgetTypeRepository).findTenantWidgetTypeDetailsByTenantId(isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<WidgetTypeDetails> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(widgetTypeDetails, data.get(0));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findTenantWidgetTypeDetailsByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeDetails> actualFindByTenantIdResult = jpaWidgetTypeDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findTenantWidgetTypeDetailsByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult = jpaWidgetTypeDao.findIdsByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult = jpaWidgetTypeDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<WidgetTypeId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult = jpaWidgetTypeDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeId> actualFindIdsByTenantIdResult = jpaWidgetTypeDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)} with
   * {@code WidgetTypeId}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)}
   */
  @Test
  public void testGetExternalIdByInternalWithWidgetTypeId() {
    // Arrange
    when(widgetTypeRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    WidgetTypeId internalId = new WidgetTypeId(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeId actualExternalIdByInternal = jpaWidgetTypeDao.getExternalIdByInternal(internalId);

    // Assert
    verify(widgetTypeRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)} with
   * {@code WidgetTypeId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#getExternalIdByInternal(WidgetTypeId)}
   */
  @Test
  public void testGetExternalIdByInternalWithWidgetTypeId_thenReturnNull() {
    // Arrange
    when(widgetTypeRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    WidgetTypeId actualExternalIdByInternal = jpaWidgetTypeDao
        .getExternalIdByInternal(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
  public void testFindWidgetsBundleWidgetsByWidgetsBundleId_thenReturnEmpty() {
    // Arrange
    when(widgetsBundleWidgetRepository.findAllByWidgetsBundleId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<WidgetsBundleWidget> actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetsBundleWidgetsByWidgetsBundleId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetsBundleWidgetRepository).findAllByWidgetsBundleId(isA(UUID.class));
    assertTrue(actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findWidgetsBundleWidgetsByWidgetsBundleId(UUID, UUID)}
   */
  @Test
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
    List<WidgetsBundleWidget> actualFindWidgetsBundleWidgetsByWidgetsBundleIdResult = jpaWidgetTypeDao
        .findWidgetsBundleWidgetsByWidgetsBundleId(ModelConstants.NULL_UUID, widgetsBundleId);

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
   * <ul>
   *   <li>Then calls {@link CrudRepository#save(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#saveWidgetsBundleWidget(WidgetsBundleWidget)}
   */
  @Test
  public void testSaveWidgetsBundleWidget_thenCallsSave() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);
    when(widgetsBundleWidgetRepository.save(Mockito.<WidgetsBundleWidgetEntity>any()))
        .thenReturn(widgetsBundleWidgetEntity);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget(widgetsBundleId,
        new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidget.setWidgetsBundleId(new WidgetsBundleId(UUID.randomUUID()));

    // Act
    jpaWidgetTypeDao.saveWidgetsBundleWidget(widgetsBundleWidget);

    // Assert
    verify(widgetsBundleWidgetRepository).save(isA(WidgetsBundleWidgetEntity.class));
  }

  /**
   * Test {@link JpaWidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#removeWidgetTypeFromWidgetsBundle(UUID, UUID)}
   */
  @Test
  public void testRemoveWidgetTypeFromWidgetsBundle() {
    // Arrange
    doNothing().when(widgetsBundleWidgetRepository).deleteById(Mockito.<WidgetsBundleWidgetCompositeKey>any());

    // Act
    jpaWidgetTypeDao.removeWidgetTypeFromWidgetsBundle(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(widgetsBundleWidgetRepository).deleteById(isA(WidgetsBundleWidgetCompositeKey.class));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  public void testFindAllWidgetTypesIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult = jpaWidgetTypeDao
        .findAllWidgetTypesIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  public void testFindAllWidgetTypesIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult = jpaWidgetTypeDao
        .findAllWidgetTypesIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    List<WidgetTypeId> data = actualFindAllWidgetTypesIdsResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  public void testFindAllWidgetTypesIds_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult = jpaWidgetTypeDao.findAllWidgetTypesIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetTypesIdsResult.getTotalPages());
    assertFalse(actualFindAllWidgetTypesIdsResult.hasNext());
    assertTrue(actualFindAllWidgetTypesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findAllWidgetTypesIds(PageLink)}
   */
  @Test
  public void testFindAllWidgetTypesIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(widgetTypeRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<WidgetTypeId> actualFindAllWidgetTypesIdsResult = jpaWidgetTypeDao
        .findAllWidgetTypesIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllWidgetTypesIdsResult.getTotalElements());
    assertEquals(1, actualFindAllWidgetTypesIdsResult.getTotalPages());
    assertFalse(actualFindAllWidgetTypesIdsResult.hasNext());
    assertTrue(actualFindAllWidgetTypesIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_thenReturnFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult = jpaWidgetTypeDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(true));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(true));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByTenantAndImageLinkResult.size());
    assertSame(widgetTypeInfo, actualFindByTenantAndImageLinkResult.get(0));
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_thenReturnSizeIsTwo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(-1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity2.setFqn("42");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("42");
    widgetTypeInfoEntity2.setName("42");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity2.setTenantId(tenantId);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(-1L);
    widgetTypeInfoEntity2.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity2);
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult = jpaWidgetTypeDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(true));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(true));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertEquals(2, actualFindByTenantAndImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByTenantAndImageLinkResult.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(widgetTypeInfo, actualFindByTenantAndImageLinkResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaWidgetTypeDao#findByTenantAndImageLink(TenantId, String, int)}
   */
  @Test
  public void testFindByTenantAndImageLink_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeInfoRepository.findByTenantAndImageUrl(Mockito.<UUID>any(), Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeInfo> actualFindByTenantAndImageLinkResult = jpaWidgetTypeDao
        .findByTenantAndImageLink(ModelConstants.SYSTEM_TENANT, "https://example.org/example", 1);

    // Assert
    verify(widgetTypeInfoRepository).findByTenantAndImageUrl(isA(UUID.class), eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByTenantAndImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink() {
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
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt())).thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult = jpaWidgetTypeDao.findByImageLink("https://example.org/example",
        1);

    // Assert
    verify(widgetTypeInfoRepository).findByImageUrl(eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByImageLinkResult.get(0);
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
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnEmpty() {
    // Arrange
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult = jpaWidgetTypeDao.findByImageLink("https://example.org/example",
        1);

    // Assert
    verify(widgetTypeInfoRepository).findByImageUrl(eq("https://example.org/example"), eq(1));
    assertTrue(actualFindByImageLinkResult.isEmpty());
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return first is {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnFirstIsWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt())).thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult = jpaWidgetTypeDao.findByImageLink("https://example.org/example",
        1);

    // Assert
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(true));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(true));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findByImageUrl(eq("https://example.org/example"), eq(1));
    assertEquals(1, actualFindByImageLinkResult.size());
    assertSame(widgetTypeInfo, actualFindByImageLinkResult.get(0));
  }

  /**
   * Test {@link JpaWidgetTypeDao#findByImageLink(String, int)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#findByImageLink(String, int)}
   */
  @Test
  public void testFindByImageLink_thenReturnSizeIsTwo() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = mock(WidgetTypeInfoEntity.class);
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    when(widgetTypeInfoEntity.toData()).thenReturn(widgetTypeInfo);
    doNothing().when(widgetTypeInfoEntity).setCreatedTime(anyLong());
    doNothing().when(widgetTypeInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(widgetTypeInfoEntity).setDeprecated(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setFqn(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setName(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setScada(anyBoolean());
    doNothing().when(widgetTypeInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(widgetTypeInfoEntity).setDescription(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setImage(Mockito.<String>any());
    doNothing().when(widgetTypeInfoEntity).setTags(Mockito.<String[]>any());
    doNothing().when(widgetTypeInfoEntity).setWidgetType(Mockito.<String>any());
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(-1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity");
    widgetTypeInfoEntity2.setFqn("42");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("42");
    widgetTypeInfoEntity2.setName("42");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity2.setTenantId(tenantId);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(-1L);
    widgetTypeInfoEntity2.setWidgetType("42");

    ArrayList<WidgetTypeInfoEntity> widgetTypeInfoEntityList = new ArrayList<>();
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity2);
    widgetTypeInfoEntityList.add(widgetTypeInfoEntity);
    when(widgetTypeInfoRepository.findByImageUrl(Mockito.<String>any(), anyInt())).thenReturn(widgetTypeInfoEntityList);

    // Act
    List<WidgetTypeInfo> actualFindByImageLinkResult = jpaWidgetTypeDao.findByImageLink("https://example.org/example",
        1);

    // Assert
    verify(widgetTypeInfoEntity).setCreatedTime(eq(1L));
    verify(widgetTypeInfoEntity).setId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setUuid(isA(UUID.class));
    verify(widgetTypeInfoEntity).setVersion(eq(1L));
    verify(widgetTypeInfoEntity).setDeprecated(eq(true));
    verify(widgetTypeInfoEntity).setFqn(eq("Fqn"));
    verify(widgetTypeInfoEntity).setName(eq("Name"));
    verify(widgetTypeInfoEntity).setScada(eq(true));
    verify(widgetTypeInfoEntity).setTenantId(isA(UUID.class));
    verify(widgetTypeInfoEntity).setDescription(eq("The characteristics of someone or something"));
    verify(widgetTypeInfoEntity).setImage(eq("Image"));
    verify(widgetTypeInfoEntity).setTags(isA(String[].class));
    verify(widgetTypeInfoEntity).setWidgetType(eq("Widget Type"));
    verify(widgetTypeInfoEntity).toData();
    verify(widgetTypeInfoRepository).findByImageUrl(eq("https://example.org/example"), eq(1));
    assertEquals(2, actualFindByImageLinkResult.size());
    WidgetTypeInfo getResult = actualFindByImageLinkResult.get(0);
    assertEquals("42", getResult.getFqn());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getImage());
    assertEquals("42", getResult.getWidgetType());
    assertEquals("org.thingsboard.server.dao.model.sql.WidgetTypeInfoEntity", getResult.getDescription());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(widgetTypeInfo, actualFindByImageLinkResult.get(1));
    assertSame(tenantId, tenantId2.getId());
  }
}
