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
package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {DashboardServiceImpl.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DashboardServiceImplDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @MockBean private CustomerDao customerDao;

  @MockBean private DashboardDao dashboardDao;

  @MockBean private DashboardInfoDao dashboardInfoDao;

  @Autowired private DashboardServiceImpl dashboardServiceImpl;

  @MockBean private DataValidator<Dashboard> dataValidator;

  @MockBean private EdgeDao edgeDao;

  @MockBean private EntityCountService entityCountService;

  @MockBean private ImageService imageService;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private RelationService relationService;

  @MockBean private TbTransactionalCache<DashboardId, String> tbTransactionalCache;

  /**
   * Test {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Serializable)} does
   *       nothing.
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.publishEvictEvent(DashboardTitleEvictEvent)"})
  public void testPublishEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());

    // Act
    dashboardServiceImpl.publishEvictEvent(new DashboardTitleEvictEvent(null));

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.publishEvictEvent(DashboardTitleEvictEvent)"})
  public void testPublishEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<DashboardId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.publishEvictEvent(new DashboardTitleEvictEvent(null)));
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Serializable)} does
   *       nothing.
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.handleEvictEvent(DashboardTitleEvictEvent)"})
  public void testHandleEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());

    // Act
    dashboardServiceImpl.handleEvictEvent(new DashboardTitleEvictEvent(null));

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.handleEvictEvent(DashboardTitleEvictEvent)"})
  public void testHandleEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<DashboardId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.handleEvictEvent(new DashboardTitleEvictEvent(null)));
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link DashboardId} {@link DashboardId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  public void testFindDashboardById_givenNull_uuid_whenDashboardIdGetIdReturnNull_uuid() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualFindDashboardByIdResult =
        dashboardServiceImpl.findDashboardById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualFindDashboardByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  public void testFindDashboardById_thenThrowDataValidationException() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardById(ModelConstants.SYSTEM_TENANT, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  public void testFindDashboardById_whenDashboardIdWithIdIsNull_uuid_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualFindDashboardByIdResult =
        dashboardServiceImpl.findDashboardById(
            ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualFindDashboardByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link DashboardId} {@link DashboardId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardByIdAsync_givenNull_uuid_whenDashboardIdGetIdReturnNull_uuid() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Dashboard> actualFindDashboardByIdAsyncResult =
        dashboardServiceImpl.findDashboardByIdAsync(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardByIdAsync_thenThrowDataValidationException() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardByIdAsync(ModelConstants.SYSTEM_TENANT, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardByIdAsync_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Dashboard> actualFindDashboardByIdAsyncResult =
        dashboardServiceImpl.findDashboardByIdAsync(
            ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link DashboardId} {@link DashboardId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoById_givenNull_uuid_whenDashboardIdGetIdReturnNull_uuid() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardInfo);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult =
        dashboardServiceImpl.findDashboardInfoById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardInfoDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboardInfo, actualFindDashboardInfoByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoById_thenThrowDataValidationException() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardInfoById(ModelConstants.SYSTEM_TENANT, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoById_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardInfo);

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult =
        dashboardServiceImpl.findDashboardInfoById(
            ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardInfoDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboardInfo, actualFindDashboardInfoByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then return {@code And Put In Transaction}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardTitleById(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DashboardServiceImpl.findDashboardTitleById(TenantId, DashboardId)"})
  public void testFindDashboardTitleById_thenReturnAndPutInTransaction() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<DashboardId>any(), Mockito.<Supplier<String>>any(), anyBoolean()))
        .thenReturn("And Put In Transaction");

    // Act
    String actualFindDashboardTitleByIdResult =
        dashboardServiceImpl.findDashboardTitleById(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    assertEquals("And Put In Transaction", actualFindDashboardTitleByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardTitleById(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DashboardServiceImpl.findDashboardTitleById(TenantId, DashboardId)"})
  public void testFindDashboardTitleById_thenThrowDataValidationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<DashboardId>any(), Mockito.<Supplier<String>>any(), anyBoolean()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardTitleById(ModelConstants.SYSTEM_TENANT, null));
    verify(tbTransactionalCache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoByIdAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<DashboardInfo> actualFindDashboardInfoByIdAsyncResult =
        dashboardServiceImpl.findDashboardInfoByIdAsync(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardInfoByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoByIdAsync_thenThrowDataValidationException() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardInfoByIdAsync(
                ModelConstants.SYSTEM_TENANT, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  public void testFindDashboardInfoByIdAsync_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<DashboardInfo> actualFindDashboardInfoByIdAsyncResult =
        dashboardServiceImpl.findDashboardInfoByIdAsync(
            ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardInfoByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with {@code dashboard}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  public void testSaveDashboardWithDashboard() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> dashboardServiceImpl.saveDashboard(new Dashboard()));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with {@code dashboard}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  public void testSaveDashboardWithDashboard2() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> dashboardServiceImpl.saveDashboard(new Dashboard()));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with {@code dashboard},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  public void testSaveDashboardWithDashboardDoValidate() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.saveDashboard(new Dashboard(), true));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with {@code dashboard},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  public void testSaveDashboardWithDashboardDoValidate2() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.saveDashboard(new Dashboard(), true));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with {@code dashboard},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link DataValidator}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  public void testSaveDashboardWithDashboardDoValidate_givenDataValidator_whenFalse() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard);
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);

    // Act
    Dashboard actualSaveDashboardResult =
        dashboardServiceImpl.saveDashboard(new Dashboard(), false);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(dashboardDao).save(isNull(), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    assertSame(dashboard, actualSaveDashboardResult);
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with {@code dashboard},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  public void testSaveDashboardWithDashboardDoValidate_thenReturnDashboard() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);

    // Act
    Dashboard actualSaveDashboardResult = dashboardServiceImpl.saveDashboard(new Dashboard(), true);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(dashboardDao).save(isNull(), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
    assertSame(dashboard, actualSaveDashboardResult);
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with {@code dashboard}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  public void testSaveDashboardWithDashboard_thenReturnDashboard() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);

    // Act
    Dashboard actualSaveDashboardResult = dashboardServiceImpl.saveDashboard(new Dashboard());

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(dashboardDao).save(isNull(), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
    assertSame(dashboard, actualSaveDashboardResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(tenantId);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(tenantId2);
    Dashboard dashboard2 = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard2);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    Dashboard actualAssignDashboardToCustomerResult =
        dashboardServiceImpl.assignDashboardToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(tenantId).getId();
    verify(tenantId2).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).save(isA(TenantId.class), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
    assertSame(dashboard2, actualAssignDashboardToCustomerResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#toShortCustomerInfo()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_givenCustomerToShortCustomerInfoReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    when(customer.toShortCustomerInfo()).thenReturn(null);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(tenantId);
    Dashboard dashboard2 = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard2);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    Dashboard actualAssignDashboardToCustomerResult =
        dashboardServiceImpl.assignDashboardToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
    verify(tenantId).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).save(isA(TenantId.class), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
    assertSame(dashboard2, actualAssignDashboardToCustomerResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Dashboard} {@link Dashboard#addAssignedCustomer(Customer)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_givenDashboardAddAssignedCustomerReturnFalse() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenReturn(tenantId);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.addAssignedCustomer(Mockito.<Customer>any())).thenReturn(false);
    when(dashboard.getTenantId()).thenReturn(tenantId2);
    doNothing().when(dashboard).setTenantId(Mockito.<TenantId>any());
    dashboard.setTenantId(mock(TenantId.class));
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    dashboardServiceImpl.assignDashboardToCustomer(
        ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID),
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(dashboard).addAssignedCustomer(isA(Customer.class));
    verify(dashboard).getTenantId();
    verify(dashboard).setTenantId(isA(TenantId.class));
    verify(tenantId).getId();
    verify(tenantId2).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_givenTenantIdGetIdReturnRandomUUID() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenReturn(tenantId);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getTenantId()).thenReturn(tenantId2);
    doNothing().when(dashboard).setTenantId(Mockito.<TenantId>any());
    dashboard.setTenantId(mock(TenantId.class));
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(dashboard).getTenantId();
    verify(dashboard).setTenantId(isA(TenantId.class));
    verify(tenantId).getId();
    verify(tenantId2).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link Dashboard#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_thenCallsGetId() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());

    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(dashboard.addAssignedCustomer(Mockito.<Customer>any())).thenReturn(true);
    when(dashboard.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(dashboard).setTenantId(Mockito.<TenantId>any());
    dashboard.setTenantId(mock(TenantId.class));
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(new Dashboard());
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(dashboard).addAssignedCustomer(isA(Customer.class));
    verify(dashboard, atLeast(1)).getId();
    verify(dashboard, atLeast(1)).getTenantId();
    verify(dashboard).setTenantId(isA(TenantId.class));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).save(isA(TenantId.class), isA(Dashboard.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#toShortCustomerInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_thenCallsToShortCustomerInfo() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    Customer customer = mock(Customer.class);
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true);
    when(customer.toShortCustomerInfo()).thenReturn(shortCustomerInfo);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(tenantId);
    Dashboard dashboard2 = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any()))
        .thenReturn(dashboard2);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(dataValidator.validate(
            Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    Dashboard actualAssignDashboardToCustomerResult =
        dashboardServiceImpl.assignDashboardToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
    verify(tenantId).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).save(isA(TenantId.class), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
    assertSame(dashboard2, actualAssignDashboardToCustomerResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testAssignDashboardToCustomer_thenThrowRuntimeException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(tenantId);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(tenantId2);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
    verify(tenantId2).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(mock(Customer.class));

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(dashboard.removeAssignedCustomer(Mockito.<Customer>any())).thenReturn(true);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(dashboard).getId();
    verify(dashboard).removeAssignedCustomer(isA(Customer.class));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link Dashboard#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer_thenCallsGetTenantId() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(mock(Customer.class));

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(dashboard.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(dashboard.removeAssignedCustomer(Mockito.<Customer>any())).thenReturn(true);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(dashboard).getId();
    verify(dashboard).getTenantId();
    verify(dashboard).removeAssignedCustomer(isA(Customer.class));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#toShortCustomerInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer_thenCallsToShortCustomerInfo() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.toShortCustomerInfo())
        .thenThrow(new DataValidationException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).toShortCustomerInfo();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer_thenReturnDashboard() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Customer());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualUnassignDashboardFromCustomerResult =
        dashboardServiceImpl.unassignDashboardFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualUnassignDashboardFromCustomerResult);
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId,
   * CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  public void testUnassignDashboardFromCustomer_thenThrowRuntimeException() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(mock(Customer.class));

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.removeAssignedCustomer(Mockito.<Customer>any())).thenReturn(true);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(dashboard).removeAssignedCustomer(isA(Customer.class));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  public void testDeleteDashboard() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(dashboardDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteDashboard(
                ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID)));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  public void testDeleteDashboard2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteDashboard(
                ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link CleanUpService} {@link
   *       CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  public void testDeleteDashboard_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    dashboardServiceImpl.deleteDashboard(
        ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardServiceImpl} (default constructor).
   *   <li>Then calls {@link DashboardId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  public void testDeleteDashboard_givenDashboardServiceImpl_thenCallsGetId() {
    // Arrange
    DashboardServiceImpl dashboardServiceImpl = new DashboardServiceImpl();

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.deleteDashboard(ModelConstants.SYSTEM_TENANT, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(dashboardDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID), true));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID), true));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    DashboardId id = mock(DashboardId.class);
    when(id.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(id).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link DashboardId} {@link DashboardId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenNull_uuid_whenDashboardIdGetIdReturnNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    DashboardId id = mock(DashboardId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(id, atLeast(1)).getId();
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    dashboardServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId() {
    // Arrange
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardsByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        dashboardServiceImpl.findDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  public void testFindDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult =
        dashboardServiceImpl.findDashboardsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId() {
    // Arrange
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findMobileDashboardsByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  public void testDeleteDashboardsByTenantId_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.deleteDashboardsByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DashboardDao#findIdsByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  public void testDeleteDashboardsByTenantId_thenCallsFindIdsByTenantId() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.deleteDashboardsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  public void testDeleteDashboardsByTenantId_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.deleteDashboardsByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DashboardDao#findIdsByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindIdsByTenantId() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> dashboardServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId() {
    // Arrange
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndCustomerId_whenFirst_page() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId() {
    // Arrange
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
            tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindMobileDashboardsByTenantIdAndCustomerId_whenFirst_page() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult =
        dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao)
        .findMobileDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link CustomerId} {@link CustomerId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  public void testUnassignCustomerDashboards_givenNull_uuid_whenCustomerIdGetIdReturnNull_uuid() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.unassignCustomerDashboards(ModelConstants.SYSTEM_TENANT, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  public void testUnassignCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.unassignCustomerDashboards(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  public void testUnassignCustomerDashboards_thenThrowDataValidationException() {
    // Arrange
    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignCustomerDashboards(
                ModelConstants.SYSTEM_TENANT, customerId));
    verify(customerId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#updateCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link CustomerId} {@link CustomerId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#updateCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  public void testUpdateCustomerDashboards_givenNull_uuid_whenCustomerIdGetIdReturnNull_uuid() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.updateCustomerDashboards(ModelConstants.SYSTEM_TENANT, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#updateCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#updateCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  public void testUpdateCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.updateCustomerDashboards(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#updateCustomerDashboards(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#updateCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  public void testUpdateCustomerDashboards_thenThrowDataValidationException() {
    // Arrange
    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.updateCustomerDashboards(
                ModelConstants.SYSTEM_TENANT, customerId));
    verify(customerId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge2() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge3() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge4() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge5() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} TenantId is {@link TenantId#TenantId(UUID)} with id
   *       is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_givenDashboardTenantIdIsTenantIdWithIdIsNull_uuid() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualAssignDashboardToEdgeResult =
        dashboardServiceImpl.assignDashboardToEdge(
            ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualAssignDashboardToEdgeResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} TenantId is {@link TenantId}.
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_givenDashboardTenantIdIsTenantId_thenCallsGetId() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(mock(TenantId.class));
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, edgeId));
    verify(edge).getTenantId();
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_givenEdgeDaoFindByIdReturnNull() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualAssignDashboardToEdgeResult =
        dashboardServiceImpl.assignDashboardToEdge(
            ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualAssignDashboardToEdgeResult);
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_thenThrowRuntimeException() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, edgeId));
    verify(edge).getTenantId();
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge() {
    // Arrange
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge2() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge3() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge4() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge_givenEdgeDaoFindByIdReturnNull_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, edgeId));
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualUnassignDashboardFromEdgeResult =
        dashboardServiceImpl.unassignDashboardFromEdge(
            ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualUnassignDashboardFromEdgeResult);
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge_thenThrowRuntimeException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT, dashboardId, edgeId));
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId() {
    // Arrange
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId2() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(tenantId, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDashboardsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(dashboardInfoDao)
        .findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndName() {
    // Arrange
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(
                ModelConstants.SYSTEM_TENANT, "Name"));
    verify(dashboardInfoDao).findFirstByTenantIdAndName(isA(UUID.class), eq("Name"));
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndName2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndName_givenNull_uuid() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfo);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DashboardInfo actualFindFirstDashboardInfoByTenantIdAndNameResult =
        dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(dashboardInfoDao).findFirstByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(dashboardInfo, actualFindFirstDashboardInfoByTenantIdAndNameResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link DashboardInfo#DashboardInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndName_thenReturnDashboardInfo() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfo);

    // Act
    DashboardInfo actualFindFirstDashboardInfoByTenantIdAndNameResult =
        dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(
            ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(dashboardInfoDao).findFirstByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(dashboardInfo, actualFindFirstDashboardInfoByTenantIdAndNameResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId,
   * String)}.
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndNameAsync() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndNameAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<DashboardInfo> actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult =
        dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(tenantId, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindFirstDashboardInfoByTenantIdAndNameAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<DashboardInfo> actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult =
        dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(
            ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  public void testFindTenantDashboardsByTitle_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<Dashboard> actualFindTenantDashboardsByTitleResult =
        dashboardServiceImpl.findTenantDashboardsByTitle(tenantId, "Dr");

    // Assert
    verify(tenantId).getId();
    verify(dashboardDao).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertTrue(actualFindTenantDashboardsByTitleResult.isEmpty());
  }

  /**
   * Test {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  public void testFindTenantDashboardsByTitle_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findTenantDashboardsByTitle(ModelConstants.SYSTEM_TENANT, "Dr"));
    verify(dashboardDao).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
  }

  /**
   * Test {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  public void testFindTenantDashboardsByTitle_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Dashboard> actualFindTenantDashboardsByTitleResult =
        dashboardServiceImpl.findTenantDashboardsByTitle(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(dashboardDao).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertTrue(actualFindTenantDashboardsByTitleResult.isEmpty());
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardDao} {@link DashboardDao#existsById(TenantId, UUID)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  public void testExistsById_givenDashboardDaoExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(false);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByIdResult =
        dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId).getId();
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardDao} {@link DashboardDao#existsById(TenantId, UUID)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  public void testExistsById_givenDashboardDaoExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult =
        dashboardServiceImpl.existsById(
            ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardDao} {@link DashboardDao#existsById(TenantId, UUID)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  public void testExistsById_givenDashboardDaoExistsByIdReturnTrue_thenReturnTrue2() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByIdResult =
        dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId).getId();
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  public void testExistsById_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.existsById(
                ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID)));
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardDao} {@link DashboardDao#findById(TenantId, UUID)} return {@link
   *       Dashboard#Dashboard()}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenDashboardDaoFindByIdReturnDashboard_thenReturnPresent() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        dashboardServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(dashboard, actualFindEntityResult.get());
  }

  /**
   * Test {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DashboardDao} {@link DashboardDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DashboardServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenDashboardDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(dashboardDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        dashboardServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DashboardServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(dashboardDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DashboardServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, new DashboardServiceImpl().getEntityType());
  }
}
