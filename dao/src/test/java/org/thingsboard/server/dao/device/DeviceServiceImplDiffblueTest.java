package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.DeviceInfoFilter;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaAbstractDao;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

public class DeviceServiceImplDiffblueTest {
  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceInfoById_givenNull_uuid_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceInfo);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult = deviceServiceImpl.findDeviceInfoById(ModelConstants.SYSTEM_TENANT,
        deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link DeviceInfo#DeviceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceInfoById_whenDeviceIdWithIdIsNull_uuid_thenReturnDeviceInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceInfo);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult = deviceServiceImpl.findDeviceInfoById(ModelConstants.SYSTEM_TENANT,
        new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findDeviceInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceByIdAsync_givenNull_uuid_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(null, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isNull(), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceByIdAsync_givenNull_uuid_thenCallsGetId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl
        .findDeviceByIdAsync(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then calls
   * {@link JpaDeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceByIdAsync_thenCallsFindDeviceByTenantIdAndIdAsync() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(null,
        new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isNull(), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceByIdAsync_whenDeviceIdWithIdIsNull_uuid_thenCallsFindByIdAsync() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl
        .findDeviceByIdAsync(ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link JpaAbstractDao#findByIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid_thenCallsFindByIdAsync() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(tenantId,
        new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  public void testFindDeviceByTenantIdAndNameAsync_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaExecutorService executor = mock(JpaExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(executor.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndNameAsyncResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator,
        new BaseEntityCountService(), executor)).findDeviceByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(executor).submit(isA(Callable.class));
    assertTrue(actualFindDeviceByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with
   * {@code device}, {@code doValidate}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  public void testSaveDeviceWithDeviceDoValidate_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new RuntimeException("Executing saveDevice [{}]"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceServiceImpl.saveDevice(device, false));
    verify(device).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link JpaDeviceDao}
   * {@link JpaAbstractDao#findById(TenantId, UUID)} return {@code null}.</li>
   *   <li>Then calls {@link JpaAbstractDao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenJpaDeviceDaoFindByIdReturnNull_thenCallsFindById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService, tenantService,
        deviceValidator, countService, new JpaExecutorService()))
        .deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert that nothing has changed
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(device).getId();
    verify(id).getId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService,
            tenantService, deviceValidator, countService, new JpaExecutorService()))
            .deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(device).getId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = deviceServiceImpl
        .findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = deviceServiceImpl
        .findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findDevicesByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = (new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService()))
        .findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findDeviceInfosByFilter, filter [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult = deviceServiceImpl.findDeviceInfosByFilter(filter,
        pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getTenantId();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_givenSortOrderWithPropertyAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult = deviceServiceImpl.findDeviceInfosByFilter(filter,
        pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is {@code null} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_givenSortOrderWithPropertyIsNullAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of(null, SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult = deviceServiceImpl.findDeviceInfosByFilter(filter,
        pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then calls {@link DeviceInfoFilter#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_thenCallsGetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getCustomerId())
        .thenThrow(new RuntimeException("Executing findDeviceInfosByFilter, filter [{}], pageLink [{}]"));
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getCustomerId();
    verify(filter, atLeast(1)).getTenantId();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_thenCallsGetProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult = deviceServiceImpl.findDeviceInfosByFilter(filter,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(filter).getTenantId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}
   */
  @Test
  public void testFindDeviceInfosByFilter_whenNull_thenThrowIncorrectParameterException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService,
            tenantService, deviceValidator, countService, new JpaExecutorService()))
            .findDeviceInfosByFilter(null, BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_givenSortOrderWithPropertyAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.findDeviceIdInfos(pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException("Executing findTenantDeviceIdPairs, pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceServiceImpl.findDeviceIdInfos(pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = (new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService()))
        .findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator, countService,
        new JpaExecutorService()))
        .findDevicesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = deviceServiceImpl
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(ModelConstants.NULL_UUID), OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = deviceServiceImpl
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = deviceServiceImpl
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT,
            deviceProfileId, OtaPackageType.FIRMWARE, pageLink));
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = deviceServiceImpl
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(deviceDao).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findDevicesByTenantIdAndTypeAndEmptyOtaPackage, tenantId [{}], deviceProfileId [{}], type"
            + " [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT,
            deviceProfileId, OtaPackageType.FIRMWARE, pageLink));
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}
   */
  @Test
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any())).thenReturn(1L);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = deviceServiceImpl
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(deviceDao).countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}
   */
  @Test
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any())).thenReturn(1L);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = deviceServiceImpl
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(ModelConstants.NULL_UUID), OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceDao).countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  public void testFindDevicesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult = deviceServiceImpl
        .findDevicesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  public void testFindDevicesByIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    List<Device> actualFindDevicesByIdsResult = deviceServiceImpl.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIds(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  public void testFindDevicesByIdsAsync_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult = deviceServiceImpl
        .findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIdsAsync(isA(List.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteDevicesByTenantId_thenCallsFindDevicesByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService, tenantService,
        deviceValidator, countService, new JpaExecutorService())).deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindDevicesByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService, tenantService,
        deviceValidator, countService, new JpaExecutorService())).deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(
        deviceDao.findDevicesByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = deviceServiceImpl
        .findDevicesByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(
        deviceDao.findDevicesByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = deviceServiceImpl
        .findDevicesByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(
        deviceDao.findDevicesByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator, countService,
        new JpaExecutorService())).findDevicesByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator, countService,
        new JpaExecutorService())).findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findDevicesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
            + " pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<UUID>>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult = deviceServiceImpl
        .findDevicesByTenantIdCustomerIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByTenantIdCustomerIdAndIdsAsync(isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  public void testUnassignCustomerDevices_thenCallsFindDevicesByTenantIdAndCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(
        deviceDao.findDevicesByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService, eventService, tenantService,
        deviceValidator, countService, new JpaExecutorService()))
        .unassignCustomerDevices(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  public void testFindDeviceTypesByTenantId_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindDeviceTypesByTenantIdResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator, countService,
        new JpaExecutorService())).findDeviceTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findTenantDeviceTypesAsync(isA(UUID.class));
    assertTrue(actualFindDeviceTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceTypesByTenantIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  public void testFindDevicesIdsByDeviceProfileTransportType_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<UUID> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesIdsByDeviceProfileTransportType(Mockito.<DeviceTransportType>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult = (new DeviceServiceImpl(deviceDao,
        deviceCredentialsService, deviceProfileService, eventService, tenantService, deviceValidator, countService,
        new JpaExecutorService()))
        .findDevicesIdsByDeviceProfileTransportType(DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesIdsByDeviceProfileTransportType(eq(DeviceTransportType.DEFAULT), isA(PageLink.class));
    assertSame(actualFindDevicesIdsByDeviceProfileTransportTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesIdsByDeviceProfileTransportTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
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
        () -> deviceServiceImpl.findDevicesByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
        ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(deviceDao).findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(deviceDao).findDevicesByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findDevicesByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}] pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_whenEdgeIdWithIdIsNull_uuid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = deviceServiceImpl
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID),
            "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link JpaDeviceDao} {@link JpaDeviceDao#countByTenantId(TenantId)}
   * return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenJpaDeviceDaoCountByTenantIdReturnOne_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act
    long actualCountByTenantIdResult = (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService()))
        .countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertEquals(EntityType.DEVICE, (new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService())).getEntityType());
  }
}
