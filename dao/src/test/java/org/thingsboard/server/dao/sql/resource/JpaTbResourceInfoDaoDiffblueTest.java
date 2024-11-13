package org.thingsboard.server.dao.sql.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTbResourceInfoDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaTbResourceInfoDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTbResourceInfoDao jpaTbResourceInfoDao;

  @MockBean
  private TbResourceInfoRepository tbResourceInfoRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTbResourceInfoDao#getEntityClass()}
   *   <li>{@link JpaTbResourceInfoDao#getRepository()}
   * </ul>
   */
  @Test
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
   * Test
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<String>>any(), Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findAllTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository).findAllTenantResourcesByTenantId(isA(UUID.class), isA(UUID.class), isA(List.class),
        isNull(), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code LWM2M_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_givenLwm2mModel_whenHashSetAddLwm2mModel() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<String>>any(), Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.LWM2M_MODEL);
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(resourceTypes)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findAllTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(tbResourceInfoRepository).findAllTenantResourcesByTenantId(isA(UUID.class), isA(UUID.class), isA(List.class),
        isNull(), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<String>>any(), Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findAllTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoRepository).findAllTenantResourcesByTenantId(isA(UUID.class), isA(UUID.class), isA(List.class),
        isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(false);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceInfoEntity> content = new ArrayList<>();
    content.add(tbResourceInfoEntity);
    PageImpl<TbResourceInfoEntity> pageImpl = new PageImpl<>(content);
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<String>>any(), Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findAllTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(false));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findAllTenantResourcesByTenantId(isA(UUID.class), isA(UUID.class), isA(List.class),
        isNull(), eq("Text Search"), isA(Pageable.class));
    List<TbResourceInfo> data = actualFindAllTenantResourcesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertSame(tbResourceInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindAllTenantResourcesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceInfoRepository.findAllTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<String>>any(), Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findAllTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(tbResourceInfoRepository).findAllTenantResourcesByTenantId(isA(UUID.class), isA(UUID.class), isA(List.class),
        isNull(), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindAllTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<List<String>>any(),
        Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = builderResult
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoRepository).findTenantResourcesByTenantId(isA(UUID.class), isA(List.class), isNull(), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code LWM2M_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_givenLwm2mModel_whenHashSetAddLwm2mModel() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<List<String>>any(),
        Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());

    HashSet<ResourceType> resourceTypes = new HashSet<>();
    resourceTypes.add(ResourceType.LWM2M_MODEL);
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(resourceTypes)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(tbResourceInfoRepository).findTenantResourcesByTenantId(isA(UUID.class), isA(List.class), isNull(), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<List<String>>any(),
        Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoRepository).findTenantResourcesByTenantId(isA(UUID.class), isA(List.class), isNull(),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(false);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceInfoEntity> content = new ArrayList<>();
    content.add(tbResourceInfoEntity);
    PageImpl<TbResourceInfoEntity> pageImpl = new PageImpl<>(content);
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<List<String>>any(),
        Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findTenantResourcesByTenantId(filter, pageLink);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(false));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findTenantResourcesByTenantId(isA(UUID.class), isA(List.class), isNull(),
        eq("Text Search"), isA(Pageable.class));
    List<TbResourceInfo> data = actualFindTenantResourcesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertSame(tbResourceInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  public void testFindTenantResourcesByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceInfoRepository.findTenantResourcesByTenantId(Mockito.<UUID>any(), Mockito.<List<String>>any(),
        Mockito.<List<String>>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TbResourceInfoFilter.TbResourceInfoFilterBuilder tbResourceInfoFilterBuilder = mock(
        TbResourceInfoFilter.TbResourceInfoFilterBuilder.class);
    when(tbResourceInfoFilterBuilder.resourceSubTypes(Mockito.<Set<ResourceSubType>>any()))
        .thenReturn(TbResourceInfoFilter.builder());
    TbResourceInfoFilter.TbResourceInfoFilterBuilder resourceSubTypesResult = tbResourceInfoFilterBuilder
        .resourceSubTypes(new HashSet<>());
    TbResourceInfoFilter filter = resourceSubTypesResult.resourceTypes(new HashSet<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult = jpaTbResourceInfoDao
        .findTenantResourcesByTenantId(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoFilterBuilder).resourceSubTypes(isA(Set.class));
    verify(tbResourceInfoRepository).findTenantResourcesByTenantId(isA(UUID.class), isA(List.class), isNull(), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindTenantResourcesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindTenantResourcesByTenantIdResult.getTotalPages());
    assertFalse(actualFindTenantResourcesByTenantIdResult.hasNext());
    assertTrue(actualFindTenantResourcesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindByTenantIdAndKey_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(tbResourceInfoRepository.findByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(tbResourceInfoEntity);

    // Act
    TbResourceInfo actualFindByTenantIdAndKeyResult = jpaTbResourceInfoDao
        .findByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(true));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertSame(tbResourceInfo, actualFindByTenantIdAndKeyResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_thenReturnFalse() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult = jpaTbResourceInfoDao
        .existsByTenantIdAndResourceTypeAndResourceKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            "Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertFalse(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_thenReturnTrue() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult = jpaTbResourceInfoDao
        .existsByTenantIdAndResourceTypeAndResourceKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            "Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertTrue(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefix_thenReturnEmpty() {
    // Arrange
    when(tbResourceInfoRepository.findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    Set<String> actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult = jpaTbResourceInfoDao
        .findKeysByTenantIdAndResourceTypeAndResourceKeyPrefix(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            "Prefix");

    // Assert
    verify(tbResourceInfoRepository).findKeysByTenantIdAndResourceTypeAndResourceKeyStartingWith(isA(UUID.class),
        eq("LWM2M_MODEL"), eq("Prefix"));
    assertTrue(actualFindKeysByTenantIdAndResourceTypeAndResourceKeyPrefixResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}
   */
  @Test
  public void testFindByTenantIdAndEtagAndKeyStartingWith_thenReturnSizeIsOne() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceInfoEntity> tbResourceInfoEntityList = new ArrayList<>();
    tbResourceInfoEntityList.add(tbResourceInfoEntity);
    when(tbResourceInfoRepository.findByTenantIdAndEtagAndResourceKeyStartingWith(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(tbResourceInfoEntityList);

    // Act
    List<TbResourceInfo> actualFindByTenantIdAndEtagAndKeyStartingWithResult = jpaTbResourceInfoDao
        .findByTenantIdAndEtagAndKeyStartingWith(ModelConstants.SYSTEM_TENANT, "Etag", "Query");

    // Assert
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(true));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findByTenantIdAndEtagAndResourceKeyStartingWith(isA(UUID.class), eq("Etag"),
        eq("Query"));
    assertEquals(1, actualFindByTenantIdAndEtagAndKeyStartingWithResult.size());
    assertSame(tbResourceInfo, actualFindByTenantIdAndEtagAndKeyStartingWithResult.get(0));
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findByTenantIdAndEtagAndKeyStartingWith(TenantId, String, String)}
   */
  @Test
  public void testFindByTenantIdAndEtagAndKeyStartingWith_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(tbResourceInfoRepository.findByTenantIdAndEtagAndResourceKeyStartingWith(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<TbResourceInfo> actualFindByTenantIdAndEtagAndKeyStartingWithResult = jpaTbResourceInfoDao
        .findByTenantIdAndEtagAndKeyStartingWith(ModelConstants.SYSTEM_TENANT, "Etag", "Query");

    // Assert
    verify(tbResourceInfoRepository).findByTenantIdAndEtagAndResourceKeyStartingWith(isA(UUID.class), eq("Etag"),
        eq("Query"));
    assertTrue(actualFindByTenantIdAndEtagAndKeyStartingWithResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findSystemOrTenantImageByEtag(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findSystemOrTenantImageByEtag(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindSystemOrTenantImageByEtag_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(tbResourceInfoRepository.findSystemOrTenantImageByEtag(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfoEntity);

    // Act
    TbResourceInfo actualFindSystemOrTenantImageByEtagResult = jpaTbResourceInfoDao
        .findSystemOrTenantImageByEtag(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Etag");

    // Assert
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(true));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findSystemOrTenantImageByEtag(isA(UUID.class), eq("LWM2M_MODEL"), eq("Etag"));
    assertSame(tbResourceInfo, actualFindSystemOrTenantImageByEtagResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}
   */
  @Test
  public void testExistsByPublicResourceKey_thenReturnFalse() {
    // Arrange
    when(
        tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualExistsByPublicResourceKeyResult = jpaTbResourceInfoDao
        .existsByPublicResourceKey(ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByResourceTypeAndPublicResourceKey(eq("LWM2M_MODEL"),
        eq("Public Resource Key"));
    assertFalse(actualExistsByPublicResourceKeyResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}
   */
  @Test
  public void testExistsByPublicResourceKey_thenReturnTrue() {
    // Arrange
    when(
        tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByPublicResourceKeyResult = jpaTbResourceInfoDao
        .existsByPublicResourceKey(ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByResourceTypeAndPublicResourceKey(eq("LWM2M_MODEL"),
        eq("Public Resource Key"));
    assertTrue(actualExistsByPublicResourceKeyResult);
  }

  /**
   * Test
   * {@link JpaTbResourceInfoDao#findPublicResourceByKey(ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceInfoDao#findPublicResourceByKey(ResourceType, String)}
   */
  @Test
  public void testFindPublicResourceByKey_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = mock(TbResourceInfoEntity.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoEntity.toData()).thenReturn(tbResourceInfo);
    doNothing().when(tbResourceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceInfoEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceInfoEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceInfoEntity).setTitle(Mockito.<String>any());
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(tbResourceInfoRepository.findByResourceTypeAndPublicResourceKeyAndIsPublicTrue(Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfoEntity);

    // Act
    TbResourceInfo actualFindPublicResourceByKeyResult = jpaTbResourceInfoDao
        .findPublicResourceByKey(ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoEntity).setCreatedTime(eq(1L));
    verify(tbResourceInfoEntity).setId(isA(UUID.class));
    verify(tbResourceInfoEntity).setUuid(isA(UUID.class));
    verify(tbResourceInfoEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceInfoEntity).setEtag(eq("Etag"));
    verify(tbResourceInfoEntity).setExternalId(isA(UUID.class));
    verify(tbResourceInfoEntity).setFileName(eq("foo.txt"));
    verify(tbResourceInfoEntity).setIsPublic(eq(true));
    verify(tbResourceInfoEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceInfoEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceInfoEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceInfoEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceInfoEntity).setSearchText(eq("Search Text"));
    verify(tbResourceInfoEntity).setTenantId(isA(UUID.class));
    verify(tbResourceInfoEntity).setTitle(eq("Dr"));
    verify(tbResourceInfoEntity).toData();
    verify(tbResourceInfoRepository).findByResourceTypeAndPublicResourceKeyAndIsPublicTrue(eq("LWM2M_MODEL"),
        eq("Public Resource Key"));
    assertSame(tbResourceInfo, actualFindPublicResourceByKeyResult);
  }
}
