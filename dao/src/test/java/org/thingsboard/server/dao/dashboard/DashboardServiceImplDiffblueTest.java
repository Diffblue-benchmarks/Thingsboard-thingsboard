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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeDao;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {DashboardServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class DashboardServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private DashboardDao dashboardDao;

  @MockBean
  private DashboardInfoDao dashboardInfoDao;

  @Autowired
  private DashboardServiceImpl dashboardServiceImpl;

  @MockBean
  private DataValidator<Dashboard> dataValidator;

  @MockBean
  private EdgeDao edgeDao;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private ImageService imageService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<DashboardId, String> tbTransactionalCache;

  /**
   * Test
   * {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}
   * {@link TbTransactionalCache#evict(Serializable)} does nothing.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  public void testPublishEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());

    // Act
    dashboardServiceImpl.publishEvictEvent(new DashboardTitleEvictEvent(null));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test
   * {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#publishEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  public void testPublishEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<DashboardId>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.publishEvictEvent(new DashboardTitleEvictEvent(null)));
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}
   * {@link TbTransactionalCache#evict(Serializable)} does nothing.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  public void testHandleEvictEvent_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());

    // Act
    dashboardServiceImpl.handleEvictEvent(new DashboardTitleEvictEvent(null));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#handleEvictEvent(DashboardTitleEvictEvent)}
   */
  @Test
  public void testHandleEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<DashboardId>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.handleEvictEvent(new DashboardTitleEvictEvent(null)));
    verify(tbTransactionalCache).evict((DashboardId) isNull());
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualFindDashboardByIdResult = dashboardServiceImpl.findDashboardById(ModelConstants.SYSTEM_TENANT,
        dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualFindDashboardByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardById_whenDashboardIdWithIdIsNull_uuid_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualFindDashboardByIdResult = dashboardServiceImpl.findDashboardById(ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualFindDashboardByIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Dashboard> actualFindDashboardByIdAsyncResult = dashboardServiceImpl
        .findDashboardByIdAsync(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardByIdAsyncResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardByIdAsync(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardByIdAsync_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<Dashboard> createResult = SettableFuture.create();
    when(dashboardDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Dashboard> actualFindDashboardByIdAsyncResult = dashboardServiceImpl
        .findDashboardByIdAsync(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardByIdAsyncResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboardInfo);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult = dashboardServiceImpl
        .findDashboardInfoById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardInfoDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboardInfo, actualFindDashboardInfoByIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardInfoById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardInfoById_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboardInfo);

    // Act
    DashboardInfo actualFindDashboardInfoByIdResult = dashboardServiceImpl
        .findDashboardInfoById(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardInfoDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboardInfo, actualFindDashboardInfoByIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Then return {@code And Put In Transaction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardTitleById_thenReturnAndPutInTransaction() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<DashboardId>any(), Mockito.<Supplier<String>>any(),
        anyBoolean())).thenReturn("And Put In Transaction");

    // Act
    String actualFindDashboardTitleByIdResult = dashboardServiceImpl
        .findDashboardTitleById(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    assertEquals("And Put In Transaction", actualFindDashboardTitleByIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardTitleById(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardTitleById_thenThrowDataValidationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<DashboardId>any(), Mockito.<Supplier<String>>any(),
        anyBoolean())).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardTitleById(ModelConstants.SYSTEM_TENANT, null));
    verify(tbTransactionalCache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardInfoByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<DashboardInfo> actualFindDashboardInfoByIdAsyncResult = dashboardServiceImpl
        .findDashboardInfoByIdAsync(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardInfoByIdAsyncResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardInfoByIdAsync(TenantId, DashboardId)}
   */
  @Test
  public void testFindDashboardInfoByIdAsync_whenDashboardIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<DashboardInfo> createResult = SettableFuture.create();
    when(dashboardInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<DashboardInfo> actualFindDashboardInfoByIdAsyncResult = dashboardServiceImpl
        .findDashboardInfoByIdAsync(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDashboardInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDashboardInfoByIdAsyncResult);
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with
   * {@code dashboard}, {@code doValidate}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  public void testSaveDashboardWithDashboardDoValidate_thenReturnDashboard() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any())).thenReturn(dashboard);
    when(dataValidator.validate(Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
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
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with
   * {@code dashboard}, {@code doValidate}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  public void testSaveDashboardWithDashboardDoValidate_thenThrowDataValidationException() {
    // Arrange
    when(dataValidator.validate(Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl.saveDashboard(new Dashboard(), true));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)} with
   * {@code dashboard}, {@code doValidate}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#saveDashboard(Dashboard, boolean)}
   */
  @Test
  public void testSaveDashboardWithDashboardDoValidate_whenFalse_thenReturnDashboard() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any())).thenReturn(dashboard);
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);

    // Act
    Dashboard actualSaveDashboardResult = dashboardServiceImpl.saveDashboard(new Dashboard(), false);

    // Assert
    verify(tbTransactionalCache).evict((DashboardId) isNull());
    verify(dashboardDao).save(isNull(), isA(Dashboard.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.DASHBOARD));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    assertSame(dashboard, actualSaveDashboardResult);
  }

  /**
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with
   * {@code dashboard}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  public void testSaveDashboardWithDashboard_thenReturnDashboard() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.save(Mockito.<TenantId>any(), Mockito.<Dashboard>any())).thenReturn(dashboard);
    when(dataValidator.validate(Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
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
   * Test {@link DashboardServiceImpl#saveDashboard(Dashboard)} with
   * {@code dashboard}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#saveDashboard(Dashboard)}
   */
  @Test
  public void testSaveDashboardWithDashboard_thenThrowDataValidationException() {
    // Arrange
    when(dataValidator.validate(Mockito.<Dashboard>any(), Mockito.<Function<Dashboard, TenantId>>any()))
        .thenReturn(new Dashboard());
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl.saveDashboard(new Dashboard()));
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    verify(dataValidator).validate(isA(Dashboard.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}
   */
  @Test
  public void testUnassignDashboardFromCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.unassignDashboardFromCustomer(ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link Customer#toShortCustomerInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}
   */
  @Test
  public void testUnassignDashboardFromCustomer_thenCallsToShortCustomerInfo() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.toShortCustomerInfo()).thenThrow(new DataValidationException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.unassignDashboardFromCustomer(ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
    verify(customer).toShortCustomerInfo();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}
   */
  @Test
  public void testUnassignDashboardFromCustomer_thenReturnDashboard() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Customer());
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Dashboard actualUnassignDashboardFromCustomerResult = dashboardServiceImpl.unassignDashboardFromCustomer(
        ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(dashboard, actualUnassignDashboardFromCustomerResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromCustomer(TenantId, DashboardId, CustomerId)}
   */
  @Test
  public void testUnassignDashboardFromCustomer_thenThrowRuntimeException() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(mock(Customer.class));
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.removeAssignedCustomer(Mockito.<Customer>any())).thenReturn(true);
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dashboardServiceImpl.unassignDashboardFromCustomer(ModelConstants.SYSTEM_TENANT,
            new DashboardId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
    verify(dashboard).removeAssignedCustomer(isA(Customer.class));
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  public void testDeleteDashboard_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.deleteDashboard(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  public void testDeleteDashboard_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl.deleteDashboard(ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteDashboard(TenantId, DashboardId)}
   */
  @Test
  public void testDeleteDashboard_whenDashboardIdWithIdIsNull_uuid_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    dashboardServiceImpl.deleteDashboard(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    DashboardId id = mock(DashboardId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    dashboardServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(id, atLeast(1)).getId();
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID), true));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_whenDashboardIdWithIdIsNull_uuid_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    dashboardServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = dashboardServiceImpl
        .findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = dashboardServiceImpl
        .findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException("foo"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dashboardServiceImpl.findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdResult = dashboardServiceImpl
        .findDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindDashboardsByTenantIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException("foo"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> dashboardServiceImpl.findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findMobileDashboardsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdResult.EMPTY_PAGE_DATA, actualFindMobileDashboardsByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link DashboardDao#findIdsByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
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
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#deleteDashboardsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteDashboardsByTenantId_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<DashboardId> data = new ArrayList<>();
    data.add(new DashboardId(ModelConstants.NULL_UUID));
    PageData<DashboardId> pageData = new PageData<>(data, 100, 100L, true);

    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.deleteDashboardsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DashboardServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link DashboardDao#findIdsByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
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
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<DashboardId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<DashboardId> data = new ArrayList<>();
    data.add(new DashboardId(ModelConstants.NULL_UUID));
    PageData<DashboardId> pageData = new PageData<>(data, 100, 100L, true);

    doNothing().when(dashboardDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dashboardDao.findIdsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(DashboardId.class));
    verify(dashboardDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardDao).findIdsByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.DASHBOARD));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndCustomerId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findMobileDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findMobileDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findMobileDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindMobileDashboardsByTenantIdAndCustomerIdResult = dashboardServiceImpl
        .findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findMobileDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
    assertSame(actualFindMobileDashboardsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindMobileDashboardsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findMobileDashboardsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindMobileDashboardsByTenantIdAndCustomerId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findMobileDashboardsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignCustomerDashboards(TenantId, CustomerId)}
   */
  @Test
  public void testUnassignCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.unassignCustomerDashboards(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao).findDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#updateCustomerDashboards(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#updateCustomerDashboards(TenantId, CustomerId)}
   */
  @Test
  public void testUpdateCustomerDashboards_thenCallsFindById() {
    // Arrange
    Customer customer = new Customer(BaseEntityService.NULL_CUSTOMER_ID);
    customer.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    dashboardServiceImpl.updateCustomerDashboards(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dashboardInfoDao).findDashboardsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        isA(PageLink.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testAssignDashboardToEdge() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} TenantId is
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testAssignDashboardToEdge_givenDashboardTenantIdIsSystem_tenant() {
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
    Dashboard actualAssignDashboardToEdgeResult = dashboardServiceImpl
        .assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualAssignDashboardToEdgeResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} TenantId is
   * {@link TenantId#TenantId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
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
    Dashboard actualAssignDashboardToEdgeResult = dashboardServiceImpl
        .assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualAssignDashboardToEdgeResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Given {@link EdgeDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testAssignDashboardToEdge_givenEdgeDaoFindByIdReturnNull() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl
        .assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testAssignDashboardToEdge_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl
        .assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>When {@link EdgeId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testAssignDashboardToEdge_whenEdgeIdGetIdReturnNull_uuid() {
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
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualAssignDashboardToEdgeResult = dashboardServiceImpl
        .assignDashboardToEdge(ModelConstants.SYSTEM_TENANT, dashboardId, edgeId);

    // Assert
    verify(edge).getTenantId();
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualAssignDashboardToEdgeResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testUnassignDashboardFromEdge() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.unassignDashboardFromEdge(ModelConstants.SYSTEM_TENANT, dashboardId, null));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Given {@link EdgeDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testUnassignDashboardFromEdge_givenEdgeDaoFindByIdReturnNull() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dashboardServiceImpl
        .unassignDashboardFromEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testUnassignDashboardFromEdge_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualUnassignDashboardFromEdgeResult = dashboardServiceImpl
        .unassignDashboardFromEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualUnassignDashboardFromEdgeResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testUnassignDashboardFromEdge_thenThrowRuntimeException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dashboardServiceImpl
        .unassignDashboardFromEdge(ModelConstants.SYSTEM_TENANT, dashboardId, new EdgeId(ModelConstants.NULL_UUID)));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   * <ul>
   *   <li>When {@link EdgeId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}
   */
  @Test
  public void testUnassignDashboardFromEdge_whenEdgeIdGetIdReturnNull_uuid_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Dashboard actualUnassignDashboardFromEdgeResult = dashboardServiceImpl
        .unassignDashboardFromEdge(ModelConstants.SYSTEM_TENANT, dashboardId, edgeId);

    // Assert
    verify(edgeId).getId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(dashboard, actualUnassignDashboardFromEdgeResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId2() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(dashboardInfoDao).findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_thenThrowDataValidationException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findDashboardsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardInfoDao).findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findDashboardsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDashboardsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DashboardInfo> emptyPageDataResult = PageData.emptyPageData();
    when(dashboardInfoDao.findDashboardsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<DashboardInfo> actualFindDashboardsByTenantIdAndEdgeIdResult = dashboardServiceImpl
        .findDashboardsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(dashboardInfoDao).findDashboardsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDashboardsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDashboardsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link DashboardInfo#DashboardInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindFirstDashboardInfoByTenantIdAndName_thenReturnDashboardInfo() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardInfo);

    // Act
    DashboardInfo actualFindFirstDashboardInfoByTenantIdAndNameResult = dashboardServiceImpl
        .findFirstDashboardInfoByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(dashboardInfoDao).findFirstByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(dashboardInfo, actualFindFirstDashboardInfoByTenantIdAndNameResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindFirstDashboardInfoByTenantIdAndName_thenThrowDataValidationException() {
    // Arrange
    when(dashboardInfoDao.findFirstByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findFirstDashboardInfoByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name"));
    verify(dashboardInfoDao).findFirstByTenantIdAndName(isA(UUID.class), eq("Name"));
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findFirstDashboardInfoByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  public void testFindFirstDashboardInfoByTenantIdAndNameAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<DashboardInfo> actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult = dashboardServiceImpl
        .findFirstDashboardInfoByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindFirstDashboardInfoByTenantIdAndNameAsyncResult);
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}
   */
  @Test
  public void testFindTenantDashboardsByTitle_thenReturnEmpty() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Dashboard> actualFindTenantDashboardsByTitleResult = dashboardServiceImpl
        .findTenantDashboardsByTitle(ModelConstants.SYSTEM_TENANT, "Dr");

    // Assert
    verify(dashboardDao).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertTrue(actualFindTenantDashboardsByTitleResult.isEmpty());
  }

  /**
   * Test
   * {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findTenantDashboardsByTitle(TenantId, String)}
   */
  @Test
  public void testFindTenantDashboardsByTitle_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.findTenantDashboardsByTitle(ModelConstants.SYSTEM_TENANT, "Dr"));
    verify(dashboardDao).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link DashboardDao} {@link Dao#existsById(TenantId, UUID)} return
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  public void testExistsById_givenDashboardDaoExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByIdResult = dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link DashboardDao} {@link Dao#existsById(TenantId, UUID)} return
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  public void testExistsById_givenDashboardDaoExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult = dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT,
        new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link DashboardId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  public void testExistsById_givenNull_uuid_whenDashboardIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByIdResult = dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT, dashboardId);

    // Assert
    verify(dashboardId).getId();
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#existsById(TenantId, DashboardId)}
   */
  @Test
  public void testExistsById_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.existsById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.existsById(ModelConstants.SYSTEM_TENANT, new DashboardId(ModelConstants.NULL_UUID)));
    verify(dashboardDao).existsById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = dashboardServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(dashboard, actualFindEntityResult.get());
  }

  /**
   * Test {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(dashboard);

    // Act
    Optional<HasId<?>> actualFindEntityResult = dashboardServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(dashboard, actualFindEntityResult.get());
  }

  /**
   * Test {@link DashboardServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link DashboardDao}
   * {@link TenantEntityDao#countByTenantId(TenantId)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenDashboardDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(dashboardDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = dashboardServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link DashboardServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(dashboardDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DashboardServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, (new DashboardServiceImpl()).getEntityType());
  }
}
