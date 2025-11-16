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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleNodeEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleNodeDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRuleNodeDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaRuleNodeDao jpaRuleNodeDao;

  @MockBean private RuleNodeRepository ruleNodeRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaRuleNodeDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeDao#getEntityType()}
   *   <li>{@link JpaRuleNodeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaRuleNodeDao.getEntityClass()",
    "EntityType JpaRuleNodeDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaRuleNodeDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleNodeDao jpaRuleNodeDao = new JpaRuleNodeDao();

    // Act
    Class<RuleNodeEntity> actualEntityClass = jpaRuleNodeDao.getEntityClass();
    EntityType actualEntityType = jpaRuleNodeDao.getEntityType();

    // Assert
    assertNull(jpaRuleNodeDao.getRepository());
    assertEquals(EntityType.RULE_NODE, actualEntityType);
    Class<RuleNodeEntity> expectedEntityClass = RuleNodeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRuleNodeDao.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndType_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        jpaRuleNodeDao.findRuleNodesByTenantIdAndType(tenantId, "Type", "Configuration Search");

    // Assert
    verify(tenantId).getId();
    verify(ruleNodeRepository)
        .findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRuleNodeDao.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndType_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        jpaRuleNodeDao.findRuleNodesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", "Configuration Search");

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertEquals(1, actualFindRuleNodesByTenantIdAndTypeResult.size());
    RuleNode getResult = actualFindRuleNodesByTenantIdAndTypeResult.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertSame(additionalInfo, getResult.getConfiguration());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaRuleNodeDao.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndType_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        jpaRuleNodeDao.findRuleNodesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", "Configuration Search");

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleNodeDao.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByType(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        jpaRuleNodeDao.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodesByType(eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleNodeDao.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_thenReturnDataSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllRuleNodesByType(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        jpaRuleNodeDao.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodesByType(eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeResult.getData();
    assertEquals(1, data.size());
    RuleNode getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, actualFindAllRuleNodesByTypeResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertSame(additionalInfo, getResult.getConfiguration());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleNodeDao.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByType(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        jpaRuleNodeDao.findAllRuleNodesByType("Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodesByType(eq("Type"), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnDataSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodesByTypeAndVersionLessThan(
            eq("Type"), eq(1), eq("Text Search"), isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData();
    assertEquals(1, data.size());
    RuleNode getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertSame(additionalInfo, getResult.getConfiguration());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            "Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodesByTypeAndVersionLessThan(
            eq("Type"), eq(1), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    List<RuleNodeId> data = actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData();
    assertEquals(1, data.size());
    RuleNodeId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(EntityType.RULE_NODE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    List<RuleNodeId> data = actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    RuleNodeId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnEmpty_page_data() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new SliceImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            "Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            "Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String,
   * int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        jpaRuleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult =
        jpaRuleNodeDao.findAllRuleNodeByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult =
        jpaRuleNodeDao.findAllRuleNodeByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any()))
        .thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult =
        jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertEquals(1, actualFindAllRuleNodeByIdsResult.size());
    RuleNode getResult = actualFindAllRuleNodeByIdsResult.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_thenReturnSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(0);
    ruleNodeEntity2.setCreatedTime(0L);
    ruleNodeEntity2.setDebugMode(false);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setQueueName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(false);
    ruleNodeEntity2.setType("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity2);
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any()))
        .thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult =
        jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertEquals(2, actualFindAllRuleNodeByIdsResult.size());
    RuleNode getResult = actualFindAllRuleNodeByIdsResult.get(1);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    RuleNode getResult2 = actualFindAllRuleNodeByIdsResult.get(0);
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getQueueName());
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getType());
    assertEquals(0, getResult2.getConfigurationVersion());
    assertEquals(0L, getResult2.getCreatedTime());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(getResult2.isDebugMode());
    assertFalse(getResult2.isSingletonMode());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult2.getConfigurationBytes());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult =
        jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findByExternalIds(RuleChainId, List)"})
  public void testFindByExternalIds_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult =
        jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeRepository)
        .findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findByExternalIds(RuleChainId, List)"})
  public void testFindByExternalIds_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeId> externalIds = new ArrayList<>();
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindByExternalIdsResult =
        jpaRuleNodeDao.findByExternalIds(ruleChainId, externalIds);

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findByExternalIds(RuleChainId, List)"})
  public void testFindByExternalIds_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeId> externalIds = new ArrayList<>();
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindByExternalIdsResult =
        jpaRuleNodeDao.findByExternalIds(ruleChainId, externalIds);

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findByExternalIds(RuleChainId, List)"})
  public void testFindByExternalIds_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(ruleNodeEntityList);
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult =
        jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByExternalIdsResult.size());
    RuleNode getResult = actualFindByExternalIdsResult.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertEquals(ruleChainId, getResult.getRuleChainId());
    assertSame(additionalInfo, getResult.getConfiguration());
    assertArrayEquals("{\"isPublic\":true}".getBytes("UTF-8"), getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   *
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaRuleNodeDao.findByExternalIds(RuleChainId, List)"})
  public void testFindByExternalIds_whenRuleChainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult =
        jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleNodeRepository)
        .findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link RuleNodeRepository#deleteAllById(Iterable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn_whenArrayList_thenCallsDeleteAllById() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    // Act
    jpaRuleNodeDao.deleteByIdIn(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }
}
