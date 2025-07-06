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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceImplDiffblueTest {
  @Mock private DeviceDao deviceDao;

  @Mock private DeviceDataValidator deviceDataValidator;

  @InjectMocks private DeviceServiceImpl deviceServiceImpl;

  @Mock private JpaExecutorService jpaExecutorService;

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  public void testFindDeviceInfoById() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult =
        deviceServiceImpl.findDeviceInfoById(
            ModelConstants.SYSTEM_TENANT,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findDeviceInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  public void testFindDeviceInfoById_thenCallsGetId() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult =
        deviceServiceImpl.findDeviceInfoById(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync2() {
    // Arrange
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceByIdAsync(
                ModelConstants.SYSTEM_TENANT,
                new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync3() {
    // Arrange
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceByIdAsync(tenantId, deviceId));
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findByIdAsync(TenantId, UUID)} return create.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDeviceDaoFindByIdAsyncReturnCreate() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}
   *       return create.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDeviceDaoFindDeviceByTenantIdAndIdAsyncReturnCreate() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(tenantId, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}
   *       return create.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDeviceDaoFindDeviceByTenantIdAndIdAsyncReturnCreate2() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(null, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isNull(), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(tenantId, deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindDeviceByTenantIdAndNameAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndNameAsyncResult =
        deviceServiceImpl.findDeviceByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDeviceByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  public void testSaveDeviceWithAccessToken_thenThrowDataValidationException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithAccessToken(new Device(), "ABC123"));
    verify(device).getName();
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate_thenThrowDataValidationException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.saveDevice(new Device(), true));
    verify(device).getName();
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device)} with {@code device}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  public void testSaveDeviceWithDevice_thenThrowDataValidationException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(new Device()));
    verify(device).getName();
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  public void testSaveDeviceWithCredentials_thenThrowDataValidationException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
    Device device2 = new Device();

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithCredentials(device2, new DeviceCredentials()));
    verify(device).getName();
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId() {
    // Arrange
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_thenCallsGetProperty() {
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
        () -> deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdResult.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter() {
    // Arrange
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, null));
    verify(filter).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter2() {
    // Arrange
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getTenantId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter3() {
    // Arrange
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter4() {
    // Arrange
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(
        actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(
        actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(
        actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceInfoFilter#getCustomerId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_thenCallsGetCustomerId() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getCustomerId();
    verify(filter, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_thenCallsGetProperty() {
    // Arrange
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(filter).getTenantId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(
        actualFindDeviceInfosByFilterResult.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(null, BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos() {
    // Arrange
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDeviceIdInfos(pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDeviceIdInfos(pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDeviceIdInfos(pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_thenCallsGetProperty() {
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
            deviceServiceImpl.findDevicesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            OtaPackageType.FIRMWARE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage2() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                OtaPackageType.FIRMWARE,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage3() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink));
    verify(deviceProfileId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage4() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage5() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage6() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink));
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage7() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenCallsGetProperty() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
            deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink));
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT,
            deviceProfileId,
            OtaPackageType.FIRMWARE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                OtaPackageType.FIRMWARE));
    verify(deviceDao)
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE));
  }

  /**
   * Test {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(deviceDao)
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenReturnOne() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceDao)
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, deviceIds);

    // Assert
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, deviceIds));
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds_thenCallsGetId() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds_thenReturnEmpty() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    List<Device> actualFindDevicesByIdsResult = deviceServiceImpl.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceDao).findDevicesByIds(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIds(deviceIds));
    verify(deviceDao).findDevicesByIds(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any())).thenReturn(createResult);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult =
        deviceServiceImpl.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIdsAsync(isA(List.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any())).thenReturn(createResult);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult =
        deviceServiceImpl.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(deviceDao).findDevicesByIdsAsync(isA(List.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIdsAsync(deviceIds));
    verify(deviceDao).findDevicesByIdsAsync(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenDeviceDaoFindDevicesByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    deviceServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId3() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_thenCallsGetProperty() {
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
            deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType3() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType5() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
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
            deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deviceIds);

    // Assert
    verify(deviceId).getId();
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deviceIds);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deviceIds));
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.unassignCustomerDevices(TenantId, CustomerId)"})
  public void testUnassignCustomerDevices() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceServiceImpl.unassignCustomerDevices(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.unassignCustomerDevices(TenantId, CustomerId)"})
  public void testUnassignCustomerDevices_givenPageDataHasNextReturnFalse_thenCallsGetData() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    deviceServiceImpl.unassignCustomerDevices(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindDeviceTypesByTenantIdResult =
        deviceServiceImpl.findDeviceTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findTenantDeviceTypesAsync(isA(UUID.class));
    assertTrue(actualFindDeviceTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceTypesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceDao).findTenantDeviceTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  public void testFindDevicesIdsByDeviceProfileTransportType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<UUID> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesIdsByDeviceProfileTransportType(
            Mockito.<DeviceTransportType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult =
        deviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(
            DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesIdsByDeviceProfileTransportType(
            eq(DeviceTransportType.DEFAULT), isA(PageLink.class));
    assertSame(
        actualFindDevicesIdsByDeviceProfileTransportTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesIdsByDeviceProfileTransportTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  public void testFindDevicesIdsByDeviceProfileTransportType_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.findDevicesIdsByDeviceProfileTransportType(
            Mockito.<DeviceTransportType>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(
                DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesIdsByDeviceProfileTransportType(
            eq(DeviceTransportType.DEFAULT), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId2() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_thenCallsGetProperty() {
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
            deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType2() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType4() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType5() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType6() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenCallsGetProperty() {
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
            deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenDeviceDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(deviceDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        deviceServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DeviceServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertEquals(
        EntityType.DEVICE,
        new DeviceServiceImpl(
                deviceDao,
                deviceCredentialsService,
                deviceProfileService,
                eventService,
                tenantService,
                deviceValidator,
                countService,
                new JpaExecutorService())
            .getEntityType());
  }
}
