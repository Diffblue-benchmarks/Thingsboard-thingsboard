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
package org.thingsboard.server.dao.sql.user;

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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaUserDao jpaUserDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private UserRepository userRepository;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaUserDao#getEntityClass()}
   *   <li>{@link JpaUserDao#getEntityType()}
   *   <li>{@link JpaUserDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaUserDao.getEntityClass()",
    "EntityType JpaUserDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaUserDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaUserDao jpaUserDao = new JpaUserDao();

    // Act
    Class<UserEntity> actualEntityClass = jpaUserDao.getEntityClass();
    EntityType actualEntityType = jpaUserDao.getEntityType();

    // Assert
    assertNull(jpaUserDao.getRepository());
    assertEquals(EntityType.USER, actualEntityType);
    Class<UserEntity> expectedEntityClass = UserEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaUserDao#findByEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link UserEntity#UserEntity()} TenantId is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return not TenantAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User JpaUserDao.findByEmail(TenantId, String)"})
  public void testFindByEmail_givenUserEntityTenantIdIsNull_uuid_thenReturnNotTenantAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(userEntity);

    // Act
    User actualFindByEmailResult =
        jpaUserDao.findByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userRepository).findByEmail("jane.doe@example.org");
    assertFalse(actualFindByEmailResult.isTenantAdmin());
    assertTrue(actualFindByEmailResult.isSystemAdmin());
    assertSame(TenantId.SYS_TENANT_ID, actualFindByEmailResult.getTenantId());
  }

  /**
   * Test {@link JpaUserDao#findByEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link UserEntity#UserEntity()} TenantId is randomUUID.
   *   <li>Then return not SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User JpaUserDao.findByEmail(TenantId, String)"})
  public void testFindByEmail_givenUserEntityTenantIdIsRandomUUID_thenReturnNotSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(userEntity);

    // Act
    User actualFindByEmailResult =
        jpaUserDao.findByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userRepository).findByEmail("jane.doe@example.org");
    assertFalse(actualFindByEmailResult.isSystemAdmin());
    TenantId tenantId2 = actualFindByEmailResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindByEmailResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User JpaUserDao.findByTenantIdAndEmail(TenantId, String)"})
  public void testFindByTenantIdAndEmail_thenAdditionalInfoIteratorNextReturnBooleanNode() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByTenantIdAndEmail(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(userEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    User actualFindByTenantIdAndEmailResult =
        jpaUserDao.findByTenantIdAndEmail(tenantId, "jane.doe@example.org");

    // Assert
    verify(tenantId).getId();
    verify(userRepository).findByTenantIdAndEmail(isA(UUID.class), eq("jane.doe@example.org"));
    JsonNode additionalInfo = actualFindByTenantIdAndEmailResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return not SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User JpaUserDao.findByTenantIdAndEmail(TenantId, String)"})
  public void testFindByTenantIdAndEmail_thenReturnNotSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByTenantIdAndEmail(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(userEntity);

    // Act
    User actualFindByTenantIdAndEmailResult =
        jpaUserDao.findByTenantIdAndEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userRepository).findByTenantIdAndEmail(isA(UUID.class), eq("jane.doe@example.org"));
    assertFalse(actualFindByTenantIdAndEmailResult.isSystemAdmin());
    TenantId tenantId2 = actualFindByTenantIdAndEmailResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindByTenantIdAndEmailResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return not TenantAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User JpaUserDao.findByTenantIdAndEmail(TenantId, String)"})
  public void testFindByTenantIdAndEmail_whenSystem_tenant_thenReturnNotTenantAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByTenantIdAndEmail(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(userEntity);

    // Act
    User actualFindByTenantIdAndEmailResult =
        jpaUserDao.findByTenantIdAndEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userRepository).findByTenantIdAndEmail(isA(UUID.class), eq("jane.doe@example.org"));
    JsonNode additionalInfo = actualFindByTenantIdAndEmailResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(actualFindByTenantIdAndEmailResult.isTenantAdmin());
    assertTrue(actualFindByTenantIdAndEmailResult.isSystemAdmin());
    assertSame(TenantId.SYS_TENANT_ID, actualFindByTenantIdAndEmailResult.getTenantId());
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<User> actualFindByTenantIdResult =
        jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<User> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByTenantId(
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
    PageData<User> actualFindByTenantIdResult =
        jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<User> actualFindByTenantIdResult =
        jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<User> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByTenantIdResult =
        jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findTenantAdmins(UUID, PageLink)"})
  public void testFindTenantAdmins() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindTenantAdminsResult =
        jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.TENANT_ADMIN),
            isA(Pageable.class));
    List<User> data = actualFindTenantAdminsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findTenantAdmins(UUID, PageLink)"})
  public void testFindTenantAdmins_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindTenantAdminsResult =
        jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.TENANT_ADMIN),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantAdminsResult.getTotalElements());
    assertEquals(1, actualFindTenantAdminsResult.getTotalPages());
    assertFalse(actualFindTenantAdminsResult.hasNext());
    assertTrue(actualFindTenantAdminsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findTenantAdmins(UUID, PageLink)"})
  public void testFindTenantAdmins_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindTenantAdminsResult =
        jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.TENANT_ADMIN),
            isA(Pageable.class));
    List<User> data = actualFindTenantAdminsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findTenantAdmins(UUID, PageLink)"})
  public void testFindTenantAdmins_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindTenantAdminsResult =
        jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            eq(Authority.TENANT_ADMIN),
            isA(Pageable.class));
    assertEquals(0L, actualFindTenantAdminsResult.getTotalElements());
    assertEquals(1, actualFindTenantAdminsResult.getTotalPages());
    assertFalse(actualFindTenantAdminsResult.hasNext());
    assertTrue(actualFindTenantAdminsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findCustomerUsers(UUID, UUID, PageLink)"})
  public void testFindCustomerUsers() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindCustomerUsersResult =
        jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.CUSTOMER_USER),
            isA(Pageable.class));
    List<User> data = actualFindCustomerUsersResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findCustomerUsers(UUID, UUID, PageLink)"})
  public void testFindCustomerUsers_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindCustomerUsersResult =
        jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.CUSTOMER_USER),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerUsersResult.getTotalElements());
    assertEquals(1, actualFindCustomerUsersResult.getTotalPages());
    assertFalse(actualFindCustomerUsersResult.hasNext());
    assertTrue(actualFindCustomerUsersResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findCustomerUsers(UUID, UUID, PageLink)"})
  public void testFindCustomerUsers_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
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
    PageData<User> actualFindCustomerUsersResult =
        jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(Authority.CUSTOMER_USER),
            isA(Pageable.class));
    List<User> data = actualFindCustomerUsersResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findCustomerUsers(UUID, UUID, PageLink)"})
  public void testFindCustomerUsers_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Authority>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindCustomerUsersResult =
        jpaUserDao.findCustomerUsers(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findUsersByAuthority(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            eq(Authority.CUSTOMER_USER),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerUsersResult.getTotalElements());
    assertEquals(1, actualFindCustomerUsersResult.getTotalPages());
    assertFalse(actualFindCustomerUsersResult.hasNext());
    assertTrue(actualFindCustomerUsersResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), eq("Text Search"), isA(Pageable.class));
    List<User> data = actualFindUsersByCustomerIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenNull_customer_id() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(
            ModelConstants.NULL_UUID, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenNull_customer_id2() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(
            ModelConstants.NULL_UUID, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenOne_thenCallsGetPage() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), eq("Text Search"), isA(Pageable.class));
    List<User> data = actualFindUsersByCustomerIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findUsersByCustomerIds(UUID, List, PageLink)"})
  public void testFindUsersByCustomerIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(
            Mockito.<UUID>any(),
            Mockito.<Collection<UUID>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        jpaUserDao.findUsersByCustomerIds(
            ModelConstants.NULL_UUID, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findTenantAndCustomerUsers(
            isA(UUID.class), isA(Collection.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAll(PageLink)"})
  public void testFindAll() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(pageLink);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    List<User> data = actualFindAllResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAll(PageLink)"})
  public void testFindAll_givenOne_whenPageLinkGetPageReturnOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(pageLink);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    assertEquals(0L, actualFindAllResult.getTotalElements());
    assertEquals(1, actualFindAllResult.getTotalPages());
    assertFalse(actualFindAllResult.hasNext());
    assertTrue(actualFindAllResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAll(PageLink)"})
  public void testFindAll_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(pageLink);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    List<User> data = actualFindAllResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAll(PageLink)"})
  public void testFindAll_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAll(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    assertEquals(0L, actualFindAllResult.getTotalElements());
    assertEquals(1, actualFindAllResult.getTotalPages());
    assertFalse(actualFindAllResult.hasNext());
    assertTrue(actualFindAllResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAllByAuthority(Authority, PageLink)"})
  public void testFindAllByAuthority() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllByAuthorityResult =
        jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    List<User> data = actualFindAllByAuthorityResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAllByAuthority(Authority, PageLink)"})
  public void testFindAllByAuthority_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllByAuthorityResult =
        jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    assertEquals(0L, actualFindAllByAuthorityResult.getTotalElements());
    assertEquals(1, actualFindAllByAuthorityResult.getTotalPages());
    assertFalse(actualFindAllByAuthorityResult.hasNext());
    assertTrue(actualFindAllByAuthorityResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAllByAuthority(Authority, PageLink)"})
  public void testFindAllByAuthority_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindAllByAuthorityResult =
        jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    List<User> data = actualFindAllByAuthorityResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findAllByAuthority(Authority, PageLink)"})
  public void testFindAllByAuthority_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindAllByAuthorityResult =
        jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    assertEquals(0L, actualFindAllByAuthorityResult.getTotalElements());
    assertEquals(1, actualFindAllByAuthorityResult.getTotalPages());
    assertFalse(actualFindAllByAuthorityResult.hasNext());
    assertTrue(actualFindAllByAuthorityResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<TenantId> tenantsIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantsIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds_givenOne_thenCallsGetPage() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<TenantId> tenantsIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds_givenSystem_tenant() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(
            Authority.SYS_ADMIN, tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds_givenSystem_tenant2() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(
            Authority.SYS_ADMIN, tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<TenantId> tenantsIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantsIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaUserDao.findByAuthorityAndTenantsIds(Authority, List, PageLink)"})
  public void testFindByAuthorityAndTenantsIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult =
        jpaUserDao.findByAuthorityAndTenantsIds(
            Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findByAuthorityAndTenantIdIn(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaUserDao.findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)"
  })
  public void testFindByAuthorityAndTenantProfilesIds() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult =
        jpaUserDao.findByAuthorityAndTenantProfilesIds(
            Authority.SYS_ADMIN, tenantProfilesIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantProfilesIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertFalse(getResult.isTenantAdmin());
    assertTrue(getResult.isSystemAdmin());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaUserDao.findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)"
  })
  public void testFindByAuthorityAndTenantProfilesIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult =
        jpaUserDao.findByAuthorityAndTenantProfilesIds(
            Authority.SYS_ADMIN, tenantProfilesIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantProfilesIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantProfilesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first SystemAdmin.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaUserDao.findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)"
  })
  public void testFindByAuthorityAndTenantProfilesIds_thenReturnNotDataFirstSystemAdmin() {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    UUID tenantId = UUID.randomUUID();
    userEntity.setTenantId(tenantId);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    when(userRepository.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult =
        jpaUserDao.findByAuthorityAndTenantProfilesIds(
            Authority.SYS_ADMIN, tenantProfilesIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(userRepository)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantProfilesIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
    assertFalse(getResult.isSystemAdmin());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(getResult.isTenantAdmin());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaUserDao.findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)"
  })
  public void testFindByAuthorityAndTenantProfilesIds_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult =
        jpaUserDao.findByAuthorityAndTenantProfilesIds(
            Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.SYS_ADMIN), isA(Collection.class), isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantProfilesIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantProfilesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaUserDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(userRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaUserDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(userRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaUserDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaUserDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(userRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaUserDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }
}
