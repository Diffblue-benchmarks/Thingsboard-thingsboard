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
package org.thingsboard.server.dao.sql.rule;

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
import java.util.Collection;
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
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleChainEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleChainDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRuleChainDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaRuleChainDao jpaRuleChainDao;

  @MockBean private RuleChainRepository ruleChainRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaRuleChainDao#getEntityClass()}
   *   <li>{@link JpaRuleChainDao#getEntityType()}
   *   <li>{@link JpaRuleChainDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaRuleChainDao.getEntityClass()",
    "EntityType JpaRuleChainDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaRuleChainDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleChainDao jpaRuleChainDao = new JpaRuleChainDao();

    // Act
    Class<RuleChainEntity> actualEntityClass = jpaRuleChainDao.getEntityClass();
    EntityType actualEntityType = jpaRuleChainDao.getEntityType();

    // Assert
    assertNull(jpaRuleChainDao.getRepository());
    assertEquals(EntityType.RULE_CHAIN, actualEntityType);
    Class<RuleChainEntity> expectedEntityClass = RuleChainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findRuleChainsByTenantId(UUID, PageLink)"})
  public void testFindRuleChainsByTenantId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult =
        jpaRuleChainDao.findRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findRuleChainsByTenantId(UUID, PageLink)"})
  public void testFindRuleChainsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult =
        jpaRuleChainDao.findRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findRuleChainsByTenantId(UUID, PageLink)"})
  public void testFindRuleChainsByTenantId_thenReturnNotDataFirstTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult =
        jpaRuleChainDao.findRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findRuleChainsByTenantId(UUID, PageLink)"})
  public void testFindRuleChainsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult =
        jpaRuleChainDao.findRuleChainsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndType() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(
        "Try to find rule chains by tenantId [{}], type [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<RuleChainType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<RuleChainType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndType_thenReturnNotDataFirstTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(
        "Try to find rule chains by tenantId [{}], type [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<RuleChainType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndType(
            Mockito.<UUID>any(),
            Mockito.<RuleChainType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID,
   * RuleChainType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain JpaRuleChainDao.findRootRuleChainByTenantIdAndType(UUID, RuleChainType)"
  })
  public void testFindRootRuleChainByTenantIdAndType() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindRootRuleChainByTenantIdAndTypeResult =
        jpaRuleChainDao.findRootRuleChainByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    TenantId tenantId = actualFindRootRuleChainByTenantIdAndTypeResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindRootRuleChainByTenantIdAndTypeResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID,
   * RuleChainType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain JpaRuleChainDao.findRootRuleChainByTenantIdAndType(UUID, RuleChainType)"
  })
  public void testFindRootRuleChainByTenantIdAndType_thenReturnNotTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindRootRuleChainByTenantIdAndTypeResult =
        jpaRuleChainDao.findRootRuleChainByTenantIdAndType(
            ModelConstants.NULL_UUID, RuleChainType.CORE);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    TenantId tenantId2 = actualFindRootRuleChainByTenantIdAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindRootRuleChainByTenantIdAndTypeResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(
        "Try to find rule chains by tenantId [{}], edgeId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_thenReturnNotDataFirstTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName(
        "Try to find rule chains by tenantId [{}], edgeId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantIdAndEdgeId(
            isA(UUID.class), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        jpaRuleChainDao.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find auto assign to edge rule chains by tenantId [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findAutoAssignByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        jpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    assertEquals(
        "Try to find auto assign to edge rule chains by tenantId [{}]", getResult.getName());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(RuleChainType.CORE, getResult.getType());
    TenantId tenantId = getResult.getTenantId();
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId2() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find auto assign to edge rule chains by tenantId [{}]");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findAutoAssignByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        jpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find auto assign to edge rule chains by tenantId [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(0L);
    ruleChainEntity2.setDebugMode(false);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(false);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.EDGE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(0L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity2);
    content.add(ruleChainEntity);
    when(ruleChainRepository.findAutoAssignByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        jpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(2, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData().size());
    assertEquals(2L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findAutoAssignByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        jpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository)
        .findAutoAssignByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(ruleChainRepository.findAutoAssignByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        jpaRuleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId,
   * RuleChainType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection JpaRuleChainDao.findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)"
  })
  public void testFindByTenantIdAndTypeAndName_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndTypeAndName(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult =
        jpaRuleChainDao.findByTenantIdAndTypeAndName(tenantId, RuleChainType.CORE, "Name");

    // Assert
    verify(tenantId).getId();
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertTrue(actualFindByTenantIdAndTypeAndNameResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   *
   * <ul>
   *   <li>Then return first Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId,
   * RuleChainType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection JpaRuleChainDao.findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)"
  })
  public void testFindByTenantIdAndTypeAndName_thenReturnFirstNameIsName()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> ruleChainEntityList = new ArrayList<>();
    ruleChainEntityList.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndTypeAndName(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(ruleChainEntityList);

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult =
        jpaRuleChainDao.findByTenantIdAndTypeAndName(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertEquals(1, actualFindByTenantIdAndTypeAndNameResult.size());
    RuleChain getResult = ((List<RuleChain>) actualFindByTenantIdAndTypeAndNameResult).get(0);
    assertEquals("Name", getResult.getName());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertSame(TenantId.SYS_TENANT_ID, getResult.getTenantId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId,
   * RuleChainType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection JpaRuleChainDao.findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)"
  })
  public void testFindByTenantIdAndTypeAndName_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndTypeAndName(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult =
        jpaRuleChainDao.findByTenantIdAndTypeAndName(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertTrue(actualFindByTenantIdAndTypeAndNameResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaRuleChainDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(ruleChainRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaRuleChainDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(ruleChainRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaRuleChainDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaRuleChainDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(ruleChainRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult =
        jpaRuleChainDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain JpaRuleChainDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindByTenantIdAndExternalIdResult =
        jpaRuleChainDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindByTenantIdAndExternalIdResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain JpaRuleChainDao.findByTenantIdAndExternalId(UUID, UUID)"})
  public void testFindByTenantIdAndExternalId_thenReturnNotTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindByTenantIdAndExternalIdResult =
        jpaRuleChainDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindByTenantIdAndExternalIdResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindByTenantIdResult =
        jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindByTenantIdResult =
        jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnNotDataFirstTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleChain> actualFindByTenantIdResult =
        jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleChainDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindByTenantIdResult =
        jpaRuleChainDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with {@code RuleChainId}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId JpaRuleChainDao.getExternalIdByInternal(RuleChainId)"})
  public void testGetExternalIdByInternalWithRuleChainId() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    RuleChainId internalId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainId actualExternalIdByInternal = jpaRuleChainDao.getExternalIdByInternal(internalId);

    // Assert
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with {@code RuleChainId}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId JpaRuleChainDao.getExternalIdByInternal(RuleChainId)"})
  public void testGetExternalIdByInternalWithRuleChainId2() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    RuleChainId internalId = mock(RuleChainId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChainId actualExternalIdByInternal = jpaRuleChainDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with {@code RuleChainId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId JpaRuleChainDao.getExternalIdByInternal(RuleChainId)"})
  public void testGetExternalIdByInternalWithRuleChainId_thenReturnNull() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    RuleChainId actualExternalIdByInternal =
        jpaRuleChainDao.getExternalIdByInternal(new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <p>Method under test: {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain JpaRuleChainDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId() throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindDefaultEntityByTenantIdResult =
        jpaRuleChainDao.findDefaultEntityByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    TenantId tenantId = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindDefaultEntityByTenantIdResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain JpaRuleChainDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId_thenReturnNotTenantIdNullUid()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity.setTenantId(tenantId);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindDefaultEntityByTenantIdResult =
        jpaRuleChainDao.findDefaultEntityByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainRepository)
        .findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    TenantId tenantId2 = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertArrayEquals(
        "{\"isPublic\":true}".getBytes("UTF-8"),
        actualFindDefaultEntityByTenantIdResult.getConfigurationBytes());
  }
}
