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
package org.thingsboard.server.dao.sql.customer;

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
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.CustomerEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaCustomerDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaCustomerDaoDiffblueTest {
  @MockBean private CustomerRepository customerRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaCustomerDao jpaCustomerDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaCustomerDao#getEntityClass()}
   *   <li>{@link JpaCustomerDao#getEntityType()}
   *   <li>{@link JpaCustomerDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaCustomerDao.getEntityClass()",
    "EntityType JpaCustomerDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaCustomerDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaCustomerDao jpaCustomerDao = new JpaCustomerDao();

    // Act
    Class<CustomerEntity> actualEntityClass = jpaCustomerDao.getEntityClass();
    EntityType actualEntityType = jpaCustomerDao.getEntityType();

    // Assert
    assertNull(jpaCustomerDao.getRepository());
    assertEquals(EntityType.CUSTOMER, actualEntityType);
    Class<CustomerEntity> expectedEntityClass = CustomerEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersByTenantId(UUID, PageLink)"})
  public void testFindCustomersByTenantId_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindCustomersByTenantIdResult =
        jpaCustomerDao.findCustomersByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindCustomersByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersByTenantId(UUID, PageLink)"})
  public void testFindCustomersByTenantId_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindCustomersByTenantIdResult =
        jpaCustomerDao.findCustomersByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindCustomersByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersByTenantId(UUID, PageLink)"})
  public void testFindCustomersByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindCustomersByTenantIdResult =
        jpaCustomerDao.findCustomersByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindCustomersByTenantIdResult.getTotalPages());
    assertFalse(actualFindCustomersByTenantIdResult.hasNext());
    assertTrue(actualFindCustomersByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersByTenantId(UUID, PageLink)"})
  public void testFindCustomersByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult =
        jpaCustomerDao.findCustomersByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindCustomersByTenantIdResult.getTotalPages());
    assertFalse(actualFindCustomersByTenantIdResult.hasNext());
    assertTrue(actualFindCustomersByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaCustomerDao.findCustomerByTenantIdAndTitle(UUID, String)"})
  public void testFindCustomerByTenantIdAndTitle_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult =
        jpaCustomerDao.findCustomerByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    Customer getResult = actualFindCustomerByTenantIdAndTitleResult.get();
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaCustomerDao.findCustomerByTenantIdAndTitle(UUID, String)"})
  public void testFindCustomerByTenantIdAndTitle_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult =
        jpaCustomerDao.findCustomerByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    Customer getResult = actualFindCustomerByTenantIdAndTitleResult.get();
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaCustomerDao.findPublicCustomerByTenantId(UUID)"})
  public void testFindPublicCustomerByTenantId_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findPublicCustomerByTenantId(Mockito.<UUID>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindPublicCustomerByTenantIdResult =
        jpaCustomerDao.findPublicCustomerByTenantId(tenantId);

    // Assert
    verify(customerRepository).findPublicCustomerByTenantId(isA(UUID.class));
    Customer getResult = actualFindPublicCustomerByTenantIdResult.get();
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindPublicCustomerByTenantIdResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaCustomerDao.findPublicCustomerByTenantId(UUID)"})
  public void testFindPublicCustomerByTenantId_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findPublicCustomerByTenantId(Mockito.<UUID>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindPublicCustomerByTenantIdResult =
        jpaCustomerDao.findPublicCustomerByTenantId(tenantId);

    // Assert
    verify(customerRepository).findPublicCustomerByTenantId(isA(UUID.class));
    Customer getResult = actualFindPublicCustomerByTenantIdResult.get();
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(actualFindPublicCustomerByTenantIdResult.isPresent());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaCustomerDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(customerRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaCustomerDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(customerRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaCustomerDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaCustomerDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(customerRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaCustomerDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer JpaCustomerDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(customerEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndExternalIdResult =
        jpaCustomerDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(customerRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualFindByTenantIdAndExternalIdResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndExternalIdResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndExternalIdResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndExternalIdResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndExternalIdResult.getCity());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndExternalIdResult.getEmail());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer JpaCustomerDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(customerEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndExternalIdResult =
        jpaCustomerDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(customerRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindByTenantIdAndExternalIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualFindByTenantIdAndExternalIdResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndExternalIdResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndExternalIdResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndExternalIdResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndExternalIdResult.getCity());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndExternalIdResult.getEmail());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer JpaCustomerDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndNameResult =
        jpaCustomerDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualFindByTenantIdAndNameResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndNameResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndNameResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndNameResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndNameResult.getCity());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndNameResult.getEmail());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer JpaCustomerDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndNameResult =
        jpaCustomerDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    assertTrue(actualFindByTenantIdAndNameResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualFindByTenantIdAndNameResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndNameResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndNameResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndNameResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndNameResult.getCity());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndNameResult.getEmail());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindByTenantIdResult =
        jpaCustomerDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindByTenantIdResult =
        jpaCustomerDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(
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
    PageData<Customer> actualFindByTenantIdResult =
        jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindByTenantIdResult =
        jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)} with {@code CustomerId}.
   *
   * <p>Method under test: {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerId JpaCustomerDao.getExternalIdByInternal(CustomerId)"})
  public void testGetExternalIdByInternalWithCustomerId() {
    // Arrange
    when(customerRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    CustomerId internalId = mock(CustomerId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    CustomerId actualExternalIdByInternal = jpaCustomerDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(customerRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)} with {@code CustomerId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerId JpaCustomerDao.getExternalIdByInternal(CustomerId)"})
  public void testGetExternalIdByInternalWithCustomerId_thenReturnNull() {
    // Arrange
    when(customerRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    CustomerId actualExternalIdByInternal =
        jpaCustomerDao.getExternalIdByInternal(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)} with {@code CustomerId}.
   *
   * <ul>
   *   <li>Then return {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerId JpaCustomerDao.getExternalIdByInternal(CustomerId)"})
  public void testGetExternalIdByInternalWithCustomerId_thenReturnNull_customer_id() {
    // Arrange
    when(customerRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    CustomerId internalId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    CustomerId actualExternalIdByInternal = jpaCustomerDao.getExternalIdByInternal(internalId);

    // Assert
    verify(customerRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersWithTheSameTitle(PageLink)"})
  public void testFindCustomersWithTheSameTitle_givenCustomerEntityTenantIdIsNull_uuid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult =
        jpaCustomerDao.findCustomersWithTheSameTitle(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    List<Customer> data = actualFindCustomersWithTheSameTitleResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link CustomerEntity#CustomerEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersWithTheSameTitle(PageLink)"})
  public void testFindCustomersWithTheSameTitle_givenCustomerEntityTenantIdIsRandomUUID() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(UUID.randomUUID());
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult =
        jpaCustomerDao.findCustomersWithTheSameTitle(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    List<Customer> data = actualFindCustomersWithTheSameTitleResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersWithTheSameTitle(PageLink)"})
  public void testFindCustomersWithTheSameTitle_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult =
        jpaCustomerDao.findCustomersWithTheSameTitle(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    assertEquals(0L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
    assertEquals(1, actualFindCustomersWithTheSameTitleResult.getTotalPages());
    assertFalse(actualFindCustomersWithTheSameTitleResult.hasNext());
    assertTrue(actualFindCustomersWithTheSameTitleResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaCustomerDao.findCustomersWithTheSameTitle(PageLink)"})
  public void testFindCustomersWithTheSameTitle_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult =
        jpaCustomerDao.findCustomersWithTheSameTitle(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    assertEquals(0L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
    assertEquals(1, actualFindCustomersWithTheSameTitleResult.getTotalPages());
    assertFalse(actualFindCustomersWithTheSameTitleResult.hasNext());
    assertTrue(actualFindCustomersWithTheSameTitleResult.getData().isEmpty());
  }
}
