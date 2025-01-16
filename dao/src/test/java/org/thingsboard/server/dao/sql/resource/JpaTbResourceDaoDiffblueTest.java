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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTbResourceDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaTbResourceDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTbResourceDao jpaTbResourceDao;

  @MockBean
  private TbResourceRepository tbResourceRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTbResourceDao#getEntityClass()}
   *   <li>{@link JpaTbResourceDao#getEntityType()}
   *   <li>{@link JpaTbResourceDao#getRepository()}
   * </ul>
   */
  @Test
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
   * Test
   * {@link JpaTbResourceDao#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}
   */
  @Test
  public void testFindResourceByTenantIdAndKey_thenReturnTbResource() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);
    when(tbResourceRepository.findByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(tbResourceEntity);

    // Act
    TbResource actualFindResourceByTenantIdAndKeyResult = jpaTbResourceDao
        .findResourceByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceEntity).setCreatedTime(eq(1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("Etag"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("foo.txt"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceEntity).setSearchText(eq("Search Text"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Dr"));
    verify(tbResourceEntity).toData();
    verify(tbResourceRepository).findByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertSame(tbResource, actualFindResourceByTenantIdAndKeyResult);
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult = jpaTbResourceDao
        .findAllByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllByTenantIdResult.hasNext());
    assertTrue(actualFindAllByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(-1L);
    tbResourceEntity.setData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("42");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("org.thingsboard.server.dao.model.sql.TbResourceEntity");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setPublicResourceKey("42");
    tbResourceEntity.setResourceKey("42");
    tbResourceEntity.setResourceSubType("42");
    tbResourceEntity.setResourceType("42");
    tbResourceEntity.setSearchText("42");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Prof");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceEntity> content = new ArrayList<>();
    content.add(tbResourceEntity);
    PageImpl<TbResourceEntity> pageImpl = new PageImpl<>(content);
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult = jpaTbResourceDao
        .findAllByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceEntity).setCreatedTime(eq(-1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("42"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("org.thingsboard.server.dao.model.sql.TbResourceEntity"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceSubType(eq("42"));
    verify(tbResourceEntity).setResourceType(eq("42"));
    verify(tbResourceEntity).setSearchText(eq("42"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Prof"));
    verify(tbResourceEntity).toData();
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    List<TbResource> data = actualFindAllByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindAllByTenantIdResult.getTotalElements());
    assertSame(tbResource, data.get(0));
  }

  /**
   * Test {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findAllByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAllByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindAllByTenantIdResult = jpaTbResourceDao
        .findAllByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAllByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAllByTenantIdResult.getTotalPages());
    assertFalse(actualFindAllByTenantIdResult.hasNext());
    assertTrue(actualFindAllByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code objectIds}, {@code searchText}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText() {
    // Arrange
    when(tbResourceRepository.findResourcesByIds(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String[]>any())).thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, new String[]{"Object Ids"}, "Search Text");

    // Assert
    verify(tbResourceRepository).findResourcesByIds(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"),
        isA(String[].class));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code objectIds}, {@code searchText}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText2() {
    // Arrange
    when(tbResourceRepository.findResources(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, null, "Search Text");

    // Assert
    verify(tbResourceRepository).findResources(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"),
        eq("Search Text"));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code objectIds}, {@code searchText}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText3() {
    // Arrange
    when(tbResourceRepository.findResources(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, null, null,
            "Search Text");

    // Assert
    verify(tbResourceRepository).findResources(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isNull(),
        eq("Search Text"));
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code objectIds}, {@code searchText}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, String[], String)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypeObjectIdsSearchText4() {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceEntity> tbResourceEntityList = new ArrayList<>();
    tbResourceEntityList.add(tbResourceEntity);
    when(tbResourceRepository.findResources(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(tbResourceEntityList);

    // Act
    List<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, null, "Search Text");

    // Assert
    verify(tbResourceEntity).setCreatedTime(eq(1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("Etag"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("foo.txt"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceEntity).setSearchText(eq("Search Text"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Dr"));
    verify(tbResourceEntity).toData();
    verify(tbResourceRepository).findResources(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"),
        eq("Search Text"));
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.size());
    assertSame(tbResource, actualFindResourcesByTenantIdAndResourceTypeResult.get(0));
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code pageLink}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findResourcesPage(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code pageLink}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink2() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, null,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findResourcesPage(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), isNull(),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code pageLink}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink3() {
    // Arrange
    when(tbResourceRepository.findResourcesPage(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository).findResourcesPage(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertEquals(1, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalPages());
    assertFalse(actualFindResourcesByTenantIdAndResourceTypeResult.hasNext());
    assertTrue(actualFindResourcesByTenantIdAndResourceTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   * with {@code tenantId}, {@code resourceType}, {@code resourceSubType},
   * {@code pageLink}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findResourcesByTenantIdAndResourceType(TenantId, ResourceType, ResourceSubType, PageLink)}
   */
  @Test
  public void testFindResourcesByTenantIdAndResourceTypeWithTenantIdResourceTypeResourceSubTypePageLink4() {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(-1L);
    tbResourceEntity.setData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("42");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("org.thingsboard.server.dao.model.sql.TbResourceEntity");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setPublicResourceKey("42");
    tbResourceEntity.setResourceKey("42");
    tbResourceEntity.setResourceSubType("42");
    tbResourceEntity.setResourceType("42");
    tbResourceEntity.setSearchText("42");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Prof");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceEntity> content = new ArrayList<>();
    content.add(tbResourceEntity);
    PageImpl<TbResourceEntity> pageImpl = new PageImpl<>(content);
    when(tbResourceRepository.findResourcesPage(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindResourcesByTenantIdAndResourceTypeResult = jpaTbResourceDao
        .findResourcesByTenantIdAndResourceType(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            ResourceSubType.IMAGE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceEntity).setCreatedTime(eq(-1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("42"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("org.thingsboard.server.dao.model.sql.TbResourceEntity"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceSubType(eq("42"));
    verify(tbResourceEntity).setResourceType(eq("42"));
    verify(tbResourceEntity).setSearchText(eq("42"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Prof"));
    verify(tbResourceEntity).toData();
    verify(tbResourceRepository).findResourcesPage(isA(UUID.class), isA(UUID.class), eq("LWM2M_MODEL"), eq("IMAGE"),
        eq("Text Search"), isA(Pageable.class));
    List<TbResource> data = actualFindResourcesByTenantIdAndResourceTypeResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindResourcesByTenantIdAndResourceTypeResult.getTotalElements());
    assertSame(tbResource, data.get(0));
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceData_givenNull_uuid_thenCallsGetId() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getDataById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    byte[] actualResourceData = jpaTbResourceDao.getResourceData(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}.
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceData_whenTbResourceIdWithIdIsNull_uuid() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getDataById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourceData = jpaTbResourceDao.getResourceData(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourcePreview_givenNull_uuid_thenCallsGetId() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getPreviewById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    byte[] actualResourcePreview = jpaTbResourceDao.getResourcePreview(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourcePreview);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}.
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourcePreview(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourcePreview_whenTbResourceIdWithIdIsNull_uuid() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceRepository.getPreviewById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourcePreview = jpaTbResourceDao.getResourcePreview(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourcePreview);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceSize_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(tbResourceRepository.getDataSizeById(Mockito.<UUID>any())).thenReturn(1L);
    TbResourceId resourceId = mock(TbResourceId.class);
    when(resourceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    long actualResourceSize = jpaTbResourceDao.getResourceSize(ModelConstants.SYSTEM_TENANT, resourceId);

    // Assert
    verify(resourceId).getId();
    verify(tbResourceRepository).getDataSizeById(isA(UUID.class));
    assertEquals(1L, actualResourceSize);
  }

  /**
   * Test {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}.
   * <ul>
   *   <li>When {@link TbResourceId#TbResourceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getResourceSize(TenantId, TbResourceId)}
   */
  @Test
  public void testGetResourceSize_whenTbResourceIdWithIdIsNull_uuid_thenReturnOne() {
    // Arrange
    when(tbResourceRepository.getDataSizeById(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    long actualResourceSize = jpaTbResourceDao.getResourceSize(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getDataSizeById(isA(UUID.class));
    assertEquals(1L, actualResourceSize);
  }

  /**
   * Test {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  public void testSumDataSizeByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(tbResourceRepository.sumDataSizeByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualSumDataSizeByTenantIdResult = jpaTbResourceDao.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceRepository).sumDataSizeByTenantId(isA(UUID.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnTbResource() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);
    when(tbResourceRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(tbResourceEntity);

    // Act
    TbResource actualFindByTenantIdAndExternalIdResult = jpaTbResourceDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(tbResourceRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(tbResourceEntity).setCreatedTime(eq(1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("Etag"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("foo.txt"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceEntity).setSearchText(eq("Search Text"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Dr"));
    verify(tbResourceEntity).toData();
    assertSame(tbResource, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenNull_uuidToStringIs138140001dd211b28080808080808080() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<TbResource> actualFindByTenantIdResult = jpaTbResourceDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenNull_uuidToStringIs138140001dd211b280808080808080802() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindByTenantIdResult = jpaTbResourceDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    TbResource tbResource = new TbResource();
    when(tbResourceEntity.toData()).thenReturn(tbResource);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(-1L);
    tbResourceEntity.setData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("42");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("org.thingsboard.server.dao.model.sql.TbResourceEntity");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    tbResourceEntity.setPublicResourceKey("42");
    tbResourceEntity.setResourceKey("42");
    tbResourceEntity.setResourceSubType("42");
    tbResourceEntity.setResourceType("42");
    tbResourceEntity.setSearchText("42");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Prof");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<TbResourceEntity> content = new ArrayList<>();
    content.add(tbResourceEntity);
    PageImpl<TbResourceEntity> pageImpl = new PageImpl<>(content);
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResource> actualFindByTenantIdResult = jpaTbResourceDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceEntity).setCreatedTime(eq(-1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("42"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("org.thingsboard.server.dao.model.sql.TbResourceEntity"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceKey(eq("42"));
    verify(tbResourceEntity).setResourceSubType(eq("42"));
    verify(tbResourceEntity).setResourceType(eq("42"));
    verify(tbResourceEntity).setSearchText(eq("42"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Prof"));
    verify(tbResourceEntity).toData();
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    List<TbResource> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tbResource, data.get(0));
  }

  /**
   * Test {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenRandomUUID_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResource> actualFindByTenantIdResult = jpaTbResourceDao.findByTenantId(UUID.randomUUID(),
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findAllByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult = jpaTbResourceDao.findIdsByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult = jpaTbResourceDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<TbResourceId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult = jpaTbResourceDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tbResourceRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbResourceId> actualFindIdsByTenantIdResult = jpaTbResourceDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with
   * {@code TbResourceId}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithTbResourceId() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    TbResourceId internalId = new TbResourceId(ModelConstants.NULL_UUID);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with
   * {@code TbResourceId}.
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithTbResourceId2() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    TbResourceId internalId = mock(TbResourceId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)} with
   * {@code TbResourceId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTbResourceDao#getExternalIdByInternal(TbResourceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithTbResourceId_thenReturnNull() {
    // Arrange
    when(tbResourceRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    // Act
    TbResourceId actualExternalIdByInternal = jpaTbResourceDao
        .getExternalIdByInternal(new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
