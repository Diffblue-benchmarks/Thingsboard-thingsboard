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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantEntity;
import org.thingsboard.server.dao.model.sql.TenantInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTenantDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTenantDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaTenantDao jpaTenantDao;

  @MockBean private TenantRepository tenantRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaTenantDao#getEntityClass()}
   *   <li>{@link JpaTenantDao#getEntityType()}
   *   <li>{@link JpaTenantDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaTenantDao.getEntityClass()",
    "EntityType JpaTenantDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaTenantDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantDao jpaTenantDao = new JpaTenantDao();

    // Act
    Class<TenantEntity> actualEntityClass = jpaTenantDao.getEntityClass();
    EntityType actualEntityType = jpaTenantDao.getEntityType();

    // Assert
    assertNull(jpaTenantDao.getRepository());
    assertEquals(EntityType.TENANT, actualEntityType);
    Class<TenantEntity> expectedEntityClass = TenantEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo JpaTenantDao.findTenantInfoById(TenantId, UUID)"})
  public void testFindTenantInfoById_thenAdditionalInfoReturnNullNode() {
    // Arrange
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any()))
        .thenReturn(new TenantInfoEntity());

    // Act
    TenantInfo actualFindTenantInfoByIdResult =
        jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindTenantInfoByIdResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    TenantId id = actualFindTenantInfoByIdResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertFalse(id.isSysTenantId());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo JpaTenantDao.findTenantInfoById(TenantId, UUID)"})
  public void testFindTenantInfoById_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any()))
        .thenReturn(new TenantInfoEntity(tenantEntity, "foo.txt"));

    // Act
    TenantInfo actualFindTenantInfoByIdResult =
        jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    assertTrue(actualFindTenantInfoByIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualFindTenantInfoByIdResult.getZip());
    assertEquals("42 Main St", actualFindTenantInfoByIdResult.getAddress());
    assertEquals("42 Main St", actualFindTenantInfoByIdResult.getAddress2());
    assertEquals("6625550144", actualFindTenantInfoByIdResult.getPhone());
    assertEquals("Dr", actualFindTenantInfoByIdResult.getName());
    assertEquals("Dr", actualFindTenantInfoByIdResult.getTitle());
    assertEquals("GB", actualFindTenantInfoByIdResult.getCountry());
    assertEquals("MD", actualFindTenantInfoByIdResult.getState());
    assertEquals("Oxford", actualFindTenantInfoByIdResult.getCity());
    assertEquals("foo.txt", actualFindTenantInfoByIdResult.getTenantProfileName());
    assertEquals("jane.doe@example.org", actualFindTenantInfoByIdResult.getEmail());
    assertEquals("us-east-2", actualFindTenantInfoByIdResult.getRegion());
    assertEquals(1L, actualFindTenantInfoByIdResult.getVersion().longValue());
    assertEquals(1L, actualFindTenantInfoByIdResult.getCreatedTime());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualFindTenantInfoByIdResult.getId());
    assertSame(tenantId, actualFindTenantInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo JpaTenantDao.findTenantInfoById(TenantId, UUID)"})
  public void testFindTenantInfoById_thenReturnNull() {
    // Arrange
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    TenantInfo actualFindTenantInfoByIdResult =
        jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    assertNull(actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@link TenantInfo#TenantInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo JpaTenantDao.findTenantInfoById(TenantId, UUID)"})
  public void testFindTenantInfoById_thenReturnTenantInfo() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = mock(TenantInfoEntity.class);
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantInfoEntity.toData()).thenReturn(tenantInfo);
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(tenantInfoEntity);

    // Act
    TenantInfo actualFindTenantInfoByIdResult =
        jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantInfoEntity).toData();
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    assertSame(tenantInfo, actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenants(TenantId, PageLink)"})
  public void testFindTenants() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    ArrayList<TenantEntity> content = new ArrayList<>();
    content.add(tenantEntity);
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Tenant> actualFindTenantsResult =
        jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsNextPage(eq("Text Search"), isA(Pageable.class));
    List<Tenant> data = actualFindTenantsResult.getData();
    assertEquals(1, data.size());
    Tenant getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getUuidId().toString());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, getResult.getId());
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenants(TenantId, PageLink)"})
  public void testFindTenants_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<Tenant> actualFindTenantsResult =
        jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantsResult.getTotalElements());
    assertEquals(1, actualFindTenantsResult.getTotalPages());
    assertFalse(actualFindTenantsResult.hasNext());
    assertTrue(actualFindTenantsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first Id NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenants(TenantId, PageLink)"})
  public void testFindTenants_thenReturnNotDataFirstIdNullUid() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    ArrayList<TenantEntity> content = new ArrayList<>();
    content.add(tenantEntity);
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Tenant> actualFindTenantsResult =
        jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsNextPage(eq("Text Search"), isA(Pageable.class));
    List<Tenant> data = actualFindTenantsResult.getData();
    assertEquals(1, data.size());
    Tenant getResult = data.get(0);
    TenantId id2 = getResult.getId();
    assertFalse(id2.isNullUid());
    assertFalse(id2.isSysTenantId());
    assertSame(id, getResult.getUuidId());
    assertSame(id, id2.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenants(TenantId, PageLink)"})
  public void testFindTenants_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Tenant> actualFindTenantsResult =
        jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsNextPage(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantsResult.getTotalElements());
    assertEquals(1, actualFindTenantsResult.getTotalPages());
    assertFalse(actualFindTenantsResult.hasNext());
    assertTrue(actualFindTenantsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertEquals(1L, actualFindTenantInfosResult.getTotalElements());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_thenDataFirstAdditionalInfoReturnNullNode() {
    // Arrange
    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(new TenantInfoEntity());
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    List<TenantInfo> data = actualFindTenantInfosResult.getData();
    assertEquals(1, data.size());
    TenantInfo getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    TenantId id = getResult.getId();
    assertNull(id.getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertFalse(id.isSysTenantId());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_thenDataFirstAdditionalInfoReturnObjectNode() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");

    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(tenantInfoEntity);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    List<TenantInfo> data = actualFindTenantInfosResult.getData();
    assertEquals(1, data.size());
    TenantInfo getResult = data.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    assertEquals("foo.txt", getResult.getTenantProfileName());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("us-east-2", getResult.getRegion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, getResult.getId());
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link TenantInfo#TenantInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_thenReturnDataFirstIsTenantInfo() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = mock(TenantInfoEntity.class);
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantInfoEntity.toData()).thenReturn(tenantInfo);

    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(tenantInfoEntity);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantInfoEntity).toData();
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    List<TenantInfo> data = actualFindTenantInfosResult.getData();
    assertEquals(1, data.size());
    assertSame(tenantInfo, data.get(0));
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantInfos(TenantId, PageLink)"})
  public void testFindTenantInfos_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        jpaTenantDao.findTenantInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantInfosNextPage(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(1, data.size());
    TenantId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindTenantsIdsResult.getTotalElements());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(2, data.size());
    TenantId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(2L, actualFindTenantsIdsResult.getTotalElements());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
    assertSame(getResult, data.get(1));
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add randomUUID.
   *   <li>Then return not Data first NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_givenArrayListAddRandomUUID_thenReturnNotDataFirstNullUid() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    UUID randomUUIDResult = UUID.randomUUID();
    content.add(randomUUIDResult);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindTenantsIdsResult.getTotalElements());
    TenantId getResult = data.get(0);
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(randomUUIDResult, getResult.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    assertEquals(0L, actualFindTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindTenantsIdsResult.getTotalPages());
    assertFalse(actualFindTenantsIdsResult.hasNext());
    assertTrue(actualFindTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaTenantDao.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantId> actualFindTenantsIdsResult =
        jpaTenantDao.findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    assertEquals(0L, actualFindTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindTenantsIdsResult.getTotalPages());
    assertFalse(actualFindTenantsIdsResult.hasNext());
    assertTrue(actualFindTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        jpaTenantDao.findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        jpaTenantDao.findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return not first NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnNotFirstNullUid() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    UUID randomUUIDResult = UUID.randomUUID();
    uuidList.add(randomUUIDResult);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        jpaTenantDao.findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(randomUUIDResult, getResult.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        jpaTenantDao.findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    uuidList.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        jpaTenantDao.findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(2, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
    assertSame(getResult, actualFindTenantIdsByTenantProfileIdResult.get(1));
  }
}
