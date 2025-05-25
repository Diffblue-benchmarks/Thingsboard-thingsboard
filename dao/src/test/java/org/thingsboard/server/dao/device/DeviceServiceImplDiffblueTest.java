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
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceImplDiffblueTest {
  @Mock
  private DeviceDao deviceDao;

  @InjectMocks
  private DeviceServiceImpl deviceServiceImpl;

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_thenCallsFindDeviceByTenantIdAndIdAsync() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(tenantId,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(tenantId,
        deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link DeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenNull_thenCallsFindDeviceByTenantIdAndIdAsync() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(null,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isNull(), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link Dao#findByIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenSystem_tenant_thenCallsFindByIdAsync() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(
        ModelConstants.SYSTEM_TENANT, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link Dao#findByIdAsync(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid_thenCallsFindByIdAsync() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(tenantId,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult = deviceServiceImpl.findDeviceByIdAsync(tenantId,
        deviceId);

    // Assert
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}.
   * <p>
   * Method under test: {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"})
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any())).thenReturn(1L);

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = deviceServiceImpl
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceDao).countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(isA(UUID.class), isA(UUID.class),
        eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"})
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<OtaPackageType>any())).thenReturn(1L);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.</li>
   *   <li>Then calls {@link PageData#hasNext()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)} return emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenDeviceDaoFindDevicesByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    deviceServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.</li>
   *   <li>Then calls {@link PageData#hasNext()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    deviceServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link DeviceDao} {@link TenantEntityDao#countByTenantId(TenantId)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenDeviceDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(deviceDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = deviceServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(deviceDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DeviceServiceImpl.getEntityType()"})
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
