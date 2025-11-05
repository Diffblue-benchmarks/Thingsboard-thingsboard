package org.thingsboard.server.dao.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DashboardServiceImplDiffblueTest {
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
  @DisplayName(
      "Test publishEvictEvent(DashboardTitleEvictEvent); given TbTransactionalCache evict(Serializable) does nothing; then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.publishEvictEvent(DashboardTitleEvictEvent)"})
  void testPublishEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
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
  @DisplayName(
      "Test publishEvictEvent(DashboardTitleEvictEvent); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.publishEvictEvent(DashboardTitleEvictEvent)"})
  void testPublishEvictEvent_thenThrowDataValidationException() {
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
  @DisplayName(
      "Test handleEvictEvent(DashboardTitleEvictEvent); given TbTransactionalCache evict(Serializable) does nothing; then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.handleEvictEvent(DashboardTitleEvictEvent)"})
  void testHandleEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
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
  @DisplayName(
      "Test handleEvictEvent(DashboardTitleEvictEvent); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.handleEvictEvent(DashboardTitleEvictEvent)"})
  void testHandleEvictEvent_thenThrowDataValidationException() {
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
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  @DisplayName("Test findDashboardById(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  void testFindDashboardById() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualFindDashboardByIdResult =
        dashboardServiceImpl.findDashboardById(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualFindDashboardByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  @DisplayName(
      "Test findDashboardById(TenantId, DashboardId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  void testFindDashboardById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Dashboard actualFindDashboardByIdResult =
        dashboardServiceImpl.findDashboardById(tenantId, dashboardId);

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
  @DisplayName("Test findDashboardById(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.findDashboardById(TenantId, DashboardId)"})
  void testFindDashboardById_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardById(tenantId, dashboardId));
    verify(dashboardId).getId();
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @DisplayName("Test findDashboardByIdAsync(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardByIdAsync() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Dashboard> actualFindDashboardByIdAsyncResult =
        dashboardServiceImpl.findDashboardByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(dashboardDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @DisplayName(
      "Test findDashboardByIdAsync(TenantId, DashboardId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardByIdAsync_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardByIdAsync(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardByIdAsync_thenThrowDataValidationException() {
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
   * Test {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  @DisplayName("Test findDashboardInfoById(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  void testFindDashboardInfoById() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardInfo);

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult =
        dashboardServiceImpl.findDashboardInfoById(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(dashboardInfoDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboardInfo, actualFindDashboardInfoByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  @DisplayName(
      "Test findDashboardInfoById(TenantId, DashboardId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  void testFindDashboardInfoById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardInfo);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult =
        dashboardServiceImpl.findDashboardInfoById(tenantId, dashboardId);

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
  @DisplayName(
      "Test findDashboardInfoById(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findDashboardInfoById(TenantId, DashboardId)"
  })
  void testFindDashboardInfoById_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardInfoById(tenantId, dashboardId));
    verify(dashboardId).getId();
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
  @DisplayName(
      "Test findDashboardTitleById(TenantId, DashboardId); then return 'And Put In Transaction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DashboardServiceImpl.findDashboardTitleById(TenantId, DashboardId)"})
  void testFindDashboardTitleById_thenReturnAndPutInTransaction() {
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
  @DisplayName(
      "Test findDashboardTitleById(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DashboardServiceImpl.findDashboardTitleById(TenantId, DashboardId)"})
  void testFindDashboardTitleById_thenThrowDataValidationException() {
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
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @DisplayName("Test findDashboardInfoByIdAsync(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardInfoByIdAsync() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<DashboardInfo> actualFindDashboardInfoByIdAsyncResult =
        dashboardServiceImpl.findDashboardInfoByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(dashboardInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardInfoByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId,
   * DashboardId)}
   */
  @Test
  @DisplayName(
      "Test findDashboardInfoByIdAsync(TenantId, DashboardId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardInfoByIdAsync_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardInfoByIdAsync(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findDashboardInfoByIdAsync(TenantId, DashboardId)"
  })
  void testFindDashboardInfoByIdAsync_thenThrowDataValidationException() {
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
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with {@code dashboard}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  @DisplayName("Test saveDashboard(Dashboard) with 'dashboard'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  void testSaveDashboardWithDashboard() {
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
  @DisplayName("Test saveDashboard(Dashboard) with 'dashboard'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  void testSaveDashboardWithDashboard2() {
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
  @DisplayName("Test saveDashboard(Dashboard, boolean) with 'dashboard', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  void testSaveDashboardWithDashboardDoValidate() {
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
  @DisplayName("Test saveDashboard(Dashboard, boolean) with 'dashboard', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  void testSaveDashboardWithDashboardDoValidate2() {
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
  @DisplayName(
      "Test saveDashboard(Dashboard, boolean) with 'dashboard', 'doValidate'; given DataValidator; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  void testSaveDashboardWithDashboardDoValidate_givenDataValidator_whenFalse() {
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
  @DisplayName(
      "Test saveDashboard(Dashboard, boolean) with 'dashboard', 'doValidate'; then return Dashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard, boolean)"})
  void testSaveDashboardWithDashboardDoValidate_thenReturnDashboard() {
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
  @DisplayName("Test saveDashboard(Dashboard) with 'dashboard'; then return Dashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardServiceImpl.saveDashboard(Dashboard)"})
  void testSaveDashboardWithDashboard_thenReturnDashboard() {
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
  @DisplayName("Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.toShortCustomerInfo())
        .thenThrow(new DataValidationException("An error occurred"));
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId, DashboardId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()} TenantId is {@link TenantId}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId); given Customer() TenantId is TenantId; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer_givenCustomerTenantIdIsTenantId_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Customer customer = new Customer();
    customer.setTenantId(tenantId);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
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
  @DisplayName(
      "Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId); given Customer toShortCustomerInfo() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer_givenCustomerToShortCustomerInfoReturnNull() {
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

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
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
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
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
   *   <li>Then calls {@link Dashboard#addAssignedCustomer(Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId); then calls addAssignedCustomer(Customer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer_thenCallsAddAssignedCustomer() {
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
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToCustomer(TenantId,
   * DashboardId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId); then return Dashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer_thenReturnDashboard() {
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

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
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
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
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
  @DisplayName(
      "Test assignDashboardToCustomer(TenantId, DashboardId, CustomerId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testAssignDashboardToCustomer_thenThrowRuntimeException() {
    // Arrange
    Customer customer = mock(Customer.class);
    ShortCustomerInfo shortCustomerInfo =
        new ShortCustomerInfo(BaseEntityService.NULL_CUSTOMER_ID, "Dr", true);
    when(customer.toShortCustomerInfo()).thenReturn(shortCustomerInfo);
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(customer).setTenantId(Mockito.<TenantId>any());
    customer.setTenantId(mock(TenantId.class));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.assignDashboardToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).getTenantId();
    verify(customer).setTenantId(isA(TenantId.class));
    verify(customer).toShortCustomerInfo();
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
  @DisplayName("Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer() {
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName(
      "Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId); given CustomerDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer_givenCustomerDaoFindByIdReturnNull() {
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName(
      "Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer_thenCallsGetTenantId() {
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName(
      "Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId); then calls toShortCustomerInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer_thenCallsToShortCustomerInfo() {
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName(
      "Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId); then return Dashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer_thenReturnDashboard() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Customer());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualUnassignDashboardFromCustomerResult =
        dashboardServiceImpl.unassignDashboardFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName(
      "Test unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)"
  })
  void testUnassignDashboardFromCustomer_thenThrowRuntimeException() {
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
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName("Test deleteDashboard(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  void testDeleteDashboard() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(dashboardDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteDashboard(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  @DisplayName("Test deleteDashboard(TenantId, DashboardId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  void testDeleteDashboard2() {
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
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
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
  @DisplayName(
      "Test deleteDashboard(TenantId, DashboardId); given CleanUpService handleEntityDeletionEvent(DeleteEntityEvent) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  void testDeleteDashboard_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    dashboardServiceImpl.deleteDashboard(
        ModelConstants.SYSTEM_TENANT,
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName(
      "Test deleteDashboard(TenantId, DashboardId); given DashboardServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboard(TenantId, DashboardId)"})
  void testDeleteDashboard_givenDashboardServiceImpl_thenCallsGetId() {
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
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(dashboardDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
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
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
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
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    DashboardId id = mock(DashboardId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    dashboardServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT,
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        true);

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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId() {
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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId2() {
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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId3() {
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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId4() {
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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId5() {
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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId_givenBy_created_time_desc() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test findDashboardsByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId_thenCallsGetProperty() {
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
  @DisplayName(
      "Test findDashboardsByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DashboardServiceImpl.findDashboardsByTenantId(TenantId, PageLink)"})
  void testFindDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId() {
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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId2() {
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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId3() {
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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId4() {
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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId5() {
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
  @DisplayName(
      "Test findMobileDashboardsByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId_givenBy_created_time_desc() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test findMobileDashboardsByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId_thenCallsGetProperty() {
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
  @DisplayName(
      "Test findMobileDashboardsByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantId(TenantId, PageLink)"
  })
  void testFindMobileDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteDashboardsByTenantId(TenantId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  void testDeleteDashboardsByTenantId_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test deleteDashboardsByTenantId(TenantId); then calls findIdsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  void testDeleteDashboardsByTenantId_thenCallsFindIdsByTenantId() {
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
  @DisplayName("Test deleteDashboardsByTenantId(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteDashboardsByTenantId(TenantId)"})
  void testDeleteDashboardsByTenantId_thenThrowDataValidationException() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    PageData<DashboardId> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test deleteByTenantId(TenantId); then calls findIdsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsFindIdsByTenantId() {
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
  @DisplayName("Test deleteByTenantId(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenThrowDataValidationException() {
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
  @DisplayName("Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId() {
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
  @DisplayName("Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId2() {
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
  @DisplayName("Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId3() {
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
  @DisplayName("Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId4() {
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
  @DisplayName(
      "Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId_givenBy_created_time_desc() {
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
  @DisplayName(
      "Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId_thenCallsGetProperty() {
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
  @DisplayName(
      "Test findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndCustomerId_whenFirst_page() {
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
  @DisplayName("Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId() {
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
  @DisplayName("Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId2() {
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
  @DisplayName("Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId3() {
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
  @DisplayName("Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId4() {
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
  @DisplayName(
      "Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId_givenBy_created_time_desc() {
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
  @DisplayName(
      "Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId_thenCallsGetProperty() {
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
  @DisplayName(
      "Test findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindMobileDashboardsByTenantIdAndCustomerId_whenFirst_page() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerDashboards(TenantId, CustomerId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  void testUnassignCustomerDashboards_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test unassignCustomerDashboards(TenantId, CustomerId); then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  void testUnassignCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @DisplayName(
      "Test unassignCustomerDashboards(TenantId, CustomerId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.unassignCustomerDashboards(TenantId, CustomerId)"})
  void testUnassignCustomerDashboards_thenThrowDataValidationException() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#updateCustomerDashboards(TenantId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test updateCustomerDashboards(TenantId, CustomerId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  void testUpdateCustomerDashboards_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test updateCustomerDashboards(TenantId, CustomerId); then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  void testUpdateCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @DisplayName(
      "Test updateCustomerDashboards(TenantId, CustomerId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardServiceImpl.updateCustomerDashboards(TenantId, CustomerId)"})
  void testUpdateCustomerDashboards_thenThrowDataValidationException() {
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
  @DisplayName("Test assignDashboardToEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  void testAssignDashboardToEdge() {
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
  @DisplayName("Test assignDashboardToEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  void testAssignDashboardToEdge2() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test assignDashboardToEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  void testAssignDashboardToEdge3() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then calls {@link EdgeDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToEdge(TenantId, DashboardId, EdgeId); given EdgeDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  void testAssignDashboardToEdge_givenEdgeDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
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
  @DisplayName("Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge() {
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
  @DisplayName("Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge2() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge3() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
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
  @DisplayName("Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge4() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge5() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId); given EdgeDao findById(TenantId, UUID) return 'null'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge_givenEdgeDaoFindByIdReturnNull_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test unassignDashboardFromEdge(TenantId, DashboardId, EdgeId); then return Dashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  void testUnassignDashboardFromEdge_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Dashboard actualUnassignDashboardFromEdgeResult =
        dashboardServiceImpl.unassignDashboardFromEdge(
            ModelConstants.SYSTEM_TENANT,
            dashboardId,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualUnassignDashboardFromEdgeResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult =
        dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName("Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId2() {
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
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @DisplayName("Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId3() {
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
  @DisplayName("Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId5() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given SortOrder getProperty() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDashboardsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test findFirstDashboardInfoByTenantIdAndName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndName() {
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
  @DisplayName("Test findFirstDashboardInfoByTenantIdAndName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndName2() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfo);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName("Test findFirstDashboardInfoByTenantIdAndName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndName3() {
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
   *   <li>Then return {@link DashboardInfo#DashboardInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findFirstDashboardInfoByTenantIdAndName(TenantId, String); then return DashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DashboardInfo DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndName_thenReturnDashboardInfo() {
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
  @DisplayName("Test findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndNameAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName("Test findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndNameAsync2() {
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
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DashboardServiceImpl.findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindFirstDashboardInfoByTenantIdAndNameAsync_thenReturnSettableFuture() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findTenantDashboardsByTitle(TenantId, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  void testFindTenantDashboardsByTitle_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findTenantDashboardsByTitle(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  void testFindTenantDashboardsByTitle_thenThrowDataValidationException() {
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
  @DisplayName(
      "Test findTenantDashboardsByTitle(TenantId, String); when SYSTEM_TENANT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DashboardServiceImpl.findTenantDashboardsByTitle(TenantId, String)"})
  void testFindTenantDashboardsByTitle_whenSystem_tenant_thenReturnEmpty() {
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
  @DisplayName(
      "Test existsById(TenantId, DashboardId); given DashboardDao existsById(TenantId, UUID) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  void testExistsById_givenDashboardDaoExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(false);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test existsById(TenantId, DashboardId); given DashboardDao existsById(TenantId, UUID) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  void testExistsById_givenDashboardDaoExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult =
        dashboardServiceImpl.existsById(
            ModelConstants.SYSTEM_TENANT,
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName(
      "Test existsById(TenantId, DashboardId); given DashboardDao existsById(TenantId, UUID) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  void testExistsById_givenDashboardDaoExistsByIdReturnTrue_thenReturnTrue2() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test existsById(TenantId, DashboardId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DashboardServiceImpl.existsById(TenantId, DashboardId)"})
  void testExistsById_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.existsById(
                ModelConstants.SYSTEM_TENANT,
                new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
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
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given DashboardDao findById(TenantId, UUID) return Dashboard(); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenDashboardDaoFindByIdReturnDashboard_thenReturnPresent() {
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findEntity(TenantId, EntityId); when NULL_CUSTOMER_ID; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DashboardServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_whenNull_customer_id_thenThrowDataValidationException() {
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
  @DisplayName(
      "Test countByTenantId(TenantId); given DashboardDao countByTenantId(TenantId) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DashboardServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_givenDashboardDaoCountByTenantIdReturnOne_thenReturnOne() {
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
  @DisplayName("Test countByTenantId(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DashboardServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_thenThrowDataValidationException() {
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
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DashboardServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, new DashboardServiceImpl().getEntityType());
  }
}
