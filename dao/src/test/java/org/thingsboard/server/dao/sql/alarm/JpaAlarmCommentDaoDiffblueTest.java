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
package org.thingsboard.server.dao.sql.alarm;

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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
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
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmCommentEntity;
import org.thingsboard.server.dao.model.sql.AlarmCommentInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaAlarmCommentDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAlarmCommentDaoDiffblueTest {
  @MockBean private AlarmCommentRepository alarmCommentRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAlarmCommentDao jpaAlarmCommentDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return TotalElements is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(null);
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertEquals(1L, actualFindAlarmCommentsResult.getTotalElements());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first AlarmId Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_thenReturnDataFirstAlarmIdIdIsNull() {
    // Arrange
    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(new AlarmCommentInfoEntity());
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    List<AlarmCommentInfo> data = actualFindAlarmCommentsResult.getData();
    assertEquals(1, data.size());
    AlarmCommentInfo getResult = data.get(0);
    AlarmId alarmId = getResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(getResult.getId().getId());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first is {@link AlarmCommentInfo#AlarmCommentInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_thenReturnDataFirstIsAlarmCommentInfo() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = mock(AlarmCommentInfoEntity.class);
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    when(alarmCommentInfoEntity.toData()).thenReturn(alarmCommentInfo);

    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(alarmCommentInfoEntity);
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(alarmCommentInfoEntity).toData();
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    List<AlarmCommentInfo> data = actualFindAlarmCommentsResult.getData();
    assertEquals(1, data.size());
    assertSame(alarmCommentInfo, data.get(0));
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_whenAlarmIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(
            ModelConstants.SYSTEM_TENANT,
            new AlarmId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_whenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(
            ModelConstants.SYSTEM_TENANT,
            new AlarmId(UUID.randomUUID()),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmCommentDao.findAlarmComments(TenantId, AlarmId, PageLink)"})
  public void testFindAlarmComments_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        jpaAlarmCommentDao.findAlarmComments(
            ModelConstants.SYSTEM_TENANT, id, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(id).getId();
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Comment return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment JpaAlarmCommentDao.findAlarmCommentById(TenantId, UUID)"})
  public void testFindAlarmCommentById_thenCommentReturnObjectNode() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmCommentEntity> ofResult = Optional.of(alarmCommentEntity);
    when(alarmCommentRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    AlarmComment actualFindAlarmCommentByIdResult =
        jpaAlarmCommentDao.findAlarmCommentById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmCommentRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdResult.getComment() instanceof ObjectNode);
    assertEquals("{\"isPublic\":true}", actualFindAlarmCommentByIdResult.getName());
    assertEquals(1L, actualFindAlarmCommentByIdResult.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualFindAlarmCommentByIdResult.getType());
    assertSame(key, actualFindAlarmCommentByIdResult.getUuidId());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment JpaAlarmCommentDao.findAlarmCommentById(TenantId, UUID)"})
  public void testFindAlarmCommentById_thenReturnNull() {
    // Arrange
    Optional<AlarmCommentEntity> emptyResult = Optional.empty();
    when(alarmCommentRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    AlarmComment actualFindAlarmCommentByIdResult =
        jpaAlarmCommentDao.findAlarmCommentById(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmCommentRepository).findById(isA(UUID.class));
    assertNull(actualFindAlarmCommentByIdResult);
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentByIdAsync(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#findAlarmCommentByIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAlarmCommentDao.findAlarmCommentByIdAsync(TenantId, UUID)"
  })
  public void testFindAlarmCommentByIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        jpaAlarmCommentDao.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test {@link JpaAlarmCommentDao#createPartition(AlarmCommentEntity)} with {@code
   * AlarmCommentEntity}.
   *
   * <p>Method under test: {@link JpaAlarmCommentDao#createPartition(AlarmCommentEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAlarmCommentDao.createPartition(AlarmCommentEntity)"})
  public void testCreatePartitionWithAlarmCommentEntity() {
    // Arrange
    doNothing()
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    AlarmCommentEntity entity = new AlarmCommentEntity();
    entity.setAlarmId(ModelConstants.NULL_UUID);
    entity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setCreatedTime(1L);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setType(AlarmCommentType.SYSTEM);
    entity.setUserId(ModelConstants.NULL_UUID);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaAlarmCommentDao.createPartition(entity);

    // Assert
    verify(sqlPartitioningRepository).createPartitionIfNotExists("alarm_comment", 1L, 604800000L);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAlarmCommentDao#getEntityClass()}
   *   <li>{@link JpaAlarmCommentDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAlarmCommentDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAlarmCommentDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmCommentDao jpaAlarmCommentDao =
        new JpaAlarmCommentDao(mock(SqlPartitioningRepository.class));

    // Act
    Class<AlarmCommentEntity> actualEntityClass = jpaAlarmCommentDao.getEntityClass();

    // Assert
    assertNull(jpaAlarmCommentDao.getRepository());
    Class<AlarmCommentEntity> expectedEntityClass = AlarmCommentEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
