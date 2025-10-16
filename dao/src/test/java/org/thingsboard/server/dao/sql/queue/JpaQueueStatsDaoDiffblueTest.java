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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
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
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueStatsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueStatsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaQueueStatsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaQueueStatsDao jpaQueueStatsDao;

  @MockBean private QueueStatsRepository queueStatsRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaQueueStatsDao#getEntityClass()}
   *   <li>{@link JpaQueueStatsDao#getEntityType()}
   *   <li>{@link JpaQueueStatsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaQueueStatsDao.getEntityClass()",
    "EntityType JpaQueueStatsDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaQueueStatsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaQueueStatsDao jpaQueueStatsDao = new JpaQueueStatsDao();

    // Act
    Class<QueueStatsEntity> actualEntityClass = jpaQueueStatsDao.getEntityClass();
    EntityType actualEntityType = jpaQueueStatsDao.getEntityType();

    // Assert
    assertNull(jpaQueueStatsDao.getRepository());
    assertEquals(EntityType.QUEUE_STATS, actualEntityType);
    Class<QueueStatsEntity> expectedEntityClass = QueueStatsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "QueueStats JpaQueueStatsDao.findByTenantIdQueueNameAndServiceId(TenantId, String, String)"
  })
  public void testFindByTenantIdQueueNameAndServiceId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueStatsRepository.findByTenantIdAndQueueNameAndServiceId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(queueStatsEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    QueueStats actualFindByTenantIdQueueNameAndServiceIdResult =
        jpaQueueStatsDao.findByTenantIdQueueNameAndServiceId(tenantId, "Queue Name", "42");

    // Assert
    verify(tenantId).getId();
    verify(queueStatsRepository)
        .findByTenantIdAndQueueNameAndServiceId(isA(UUID.class), eq("Queue Name"), eq("42"));
    UUID uuidId = actualFindByTenantIdQueueNameAndServiceIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualFindByTenantIdQueueNameAndServiceIdResult.getServiceId());
    assertEquals("Queue Name", actualFindByTenantIdQueueNameAndServiceIdResult.getQueueName());
    assertEquals(1L, actualFindByTenantIdQueueNameAndServiceIdResult.getCreatedTime());
    QueueStatsId id = actualFindByTenantIdQueueNameAndServiceIdResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    assertEquals(
        TenantId.SYS_TENANT_ID, actualFindByTenantIdQueueNameAndServiceIdResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "QueueStats JpaQueueStatsDao.findByTenantIdQueueNameAndServiceId(TenantId, String, String)"
  })
  public void testFindByTenantIdQueueNameAndServiceId_whenSystem_tenant() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueStatsRepository.findByTenantIdAndQueueNameAndServiceId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(queueStatsEntity);

    // Act
    QueueStats actualFindByTenantIdQueueNameAndServiceIdResult =
        jpaQueueStatsDao.findByTenantIdQueueNameAndServiceId(
            ModelConstants.SYSTEM_TENANT, "Queue Name", "42");

    // Assert
    verify(queueStatsRepository)
        .findByTenantIdAndQueueNameAndServiceId(isA(UUID.class), eq("Queue Name"), eq("42"));
    UUID uuidId = actualFindByTenantIdQueueNameAndServiceIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualFindByTenantIdQueueNameAndServiceIdResult.getServiceId());
    assertEquals("Queue Name", actualFindByTenantIdQueueNameAndServiceIdResult.getQueueName());
    assertEquals(1L, actualFindByTenantIdQueueNameAndServiceIdResult.getCreatedTime());
    QueueStatsId id = actualFindByTenantIdQueueNameAndServiceIdResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    assertEquals(
        TenantId.SYS_TENANT_ID, actualFindByTenantIdQueueNameAndServiceIdResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueStatsDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(queueStatsRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        jpaQueueStatsDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(queueStatsRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueStatsDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueStatsRepository.findByTenantId(
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
    PageData<QueueStats> actualFindByTenantIdResult =
        jpaQueueStatsDao.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(queueStatsRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link QueueStatsEntity#QueueStatsEntity()} CreatedTime is one.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueStatsDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenQueueStatsEntityCreatedTimeIsOne_thenReturnDataSizeIsOne() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> content = new ArrayList<>();
    content.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        jpaQueueStatsDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(queueStatsRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<QueueStats> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    QueueStats getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    QueueStatsId id = getResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    assertEquals(TenantId.SYS_TENANT_ID, getResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaQueueStatsDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueStatsRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        jpaQueueStatsDao.findByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueStatsRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaQueueStatsDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(queueStatsRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaQueueStatsDao.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(queueStatsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link QueueStatsRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaQueueStatsDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(queueStatsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaQueueStatsDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueStatsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<QueueStats> actualFindByIdsResult =
        jpaQueueStatsDao.findByIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenNull_whenArrayListAddNull_thenCallsGetId() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(null);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(tenantId, queueStatsIds);

    // Assert
    verify(tenantId).getId();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link QueueStatsEntity#QueueStatsEntity()} CreatedTime is one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenQueueStatsEntityCreatedTimeIsOne_thenReturnSizeIsOne() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> queueStatsEntityList = new ArrayList<>();
    queueStatsEntityList.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(queueStatsEntityList);

    // Act
    List<QueueStats> actualFindByIdsResult =
        jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    QueueStats getResult = actualFindByIdsResult.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals(1L, getResult.getCreatedTime());
    QueueStatsId id = getResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    assertEquals(TenantId.SYS_TENANT_ID, getResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link QueueStatsId} {@link QueueStatsId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link QueueStatsId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenQueueStatsIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    QueueStatsId queueStatsId = mock(QueueStatsId.class);
    when(queueStatsId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(queueStatsId);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(tenantId, queueStatsIds);

    // Assert
    verify(queueStatsId).getId();
    verify(tenantId).getId();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link QueueStatsId#QueueStatsId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenQueueStatsIdWithIdIsNull_uuid() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(new QueueStatsId(ModelConstants.NULL_UUID));

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(tenantId, queueStatsIds);

    // Assert
    verify(tenantId).getId();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<QueueStats> actualFindByIdsResult =
        jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }
}
