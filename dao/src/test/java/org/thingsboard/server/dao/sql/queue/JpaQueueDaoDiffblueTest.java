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
package org.thingsboard.server.dao.sql.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaQueueDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaQueueDao jpaQueueDao;

  @MockBean private QueueRepository queueRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaQueueDao#getEntityClass()}
   *   <li>{@link JpaQueueDao#getEntityType()}
   *   <li>{@link JpaQueueDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaQueueDao.getEntityClass()",
    "EntityType JpaQueueDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaQueueDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaQueueDao jpaQueueDao = new JpaQueueDao();

    // Act
    Class<QueueEntity> actualEntityClass = jpaQueueDao.getEntityClass();
    EntityType actualEntityType = jpaQueueDao.getEntityType();

    // Assert
    assertNull(jpaQueueDao.getRepository());
    assertEquals(EntityType.QUEUE, actualEntityType);
    Class<QueueEntity> expectedEntityClass = QueueEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaQueueDao#findAllByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findAllByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueDao.findAllByTenantId(TenantId)"})
  public void testFindAllByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<Queue> actualFindAllByTenantIdResult = jpaQueueDao.findAllByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(queueRepository).findByTenantId(isA(UUID.class));
    assertTrue(actualFindAllByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findAllByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findAllByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueDao.findAllByTenantId(TenantId)"})
  public void testFindAllByTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllByTenantIdResult =
        jpaQueueDao.findAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueRepository).findByTenantId(isA(UUID.class));
    assertTrue(actualFindAllByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findAllMainQueues()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findAllMainQueues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueDao.findAllMainQueues()"})
  public void testFindAllMainQueues_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findAllByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllMainQueuesResult = jpaQueueDao.findAllMainQueues();

    // Assert
    verify(queueRepository).findAllByName("Main");
    assertTrue(actualFindAllMainQueuesResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findAllQueues()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findAllQueues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueDao.findAllQueues()"})
  public void testFindAllQueues_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllQueuesResult = jpaQueueDao.findAllQueues();

    // Assert
    verify(queueRepository).findAll();
    assertTrue(actualFindAllQueuesResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueDao.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(queueRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        jpaQueueDao.findQueuesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindQueuesByTenantIdResult.getTotalPages());
    assertFalse(actualFindQueuesByTenantIdResult.hasNext());
    assertTrue(actualFindQueuesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueDao.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(queueRepository.findByTenantId(
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
    PageData<Queue> actualFindQueuesByTenantIdResult =
        jpaQueueDao.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindQueuesByTenantIdResult.getTotalPages());
    assertFalse(actualFindQueuesByTenantIdResult.hasNext());
    assertTrue(actualFindQueuesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueDao.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        jpaQueueDao.findQueuesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindQueuesByTenantIdResult.getTotalPages());
    assertFalse(actualFindQueuesByTenantIdResult.hasNext());
    assertTrue(actualFindQueuesByTenantIdResult.getData().isEmpty());
  }
}
