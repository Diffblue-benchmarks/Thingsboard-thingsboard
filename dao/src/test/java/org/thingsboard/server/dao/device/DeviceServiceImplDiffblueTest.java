package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.DeviceInfoFilter;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.device.credentials.ProvisionDeviceCredentialsData;
import org.thingsboard.server.common.data.device.profile.ProvisionDeviceProfileCredentials;
import org.thingsboard.server.common.data.id.AlarmId;
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
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.device.provision.ProvisionRequest;
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

@ExtendWith(MockitoExtension.class)
class DeviceServiceImplDiffblueTest {
  @Mock private DeviceCredentialsService deviceCredentialsService;

  @Mock private DeviceDao deviceDao;

  @Mock private DeviceDataValidator deviceDataValidator;

  @InjectMocks private DeviceServiceImpl deviceServiceImpl;

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceInfoById(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  void testFindDeviceInfoById() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);
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
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceInfoById(TenantId, DeviceId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  void testFindDeviceInfoById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);
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
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceInfoById(TenantId, DeviceId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  void testFindDeviceInfoById_thenThrowDataValidationException() {
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfoById(ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceById(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceById(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceById(TenantId, DeviceId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.findDeviceById(TenantId, DeviceId)"})
  void testFindDeviceById_thenThrowDataValidationException() {
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceById(ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceByIdAsync(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
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
  @DisplayName("Test findDeviceByIdAsync(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync2() {
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceByIdAsync(ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceByIdAsync(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceByIdAsync(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test findDeviceByIdAsync(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync5() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
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
   *   <li>Then calls {@link JpaDeviceDao#findByIdAsync(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByIdAsync(TenantId, DeviceId); then calls findByIdAsync(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync_thenCallsFindByIdAsync() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
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
   *   <li>Then calls {@link DeviceDao#findByIdAsync(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByIdAsync(TenantId, DeviceId); then calls findByIdAsync(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync_thenCallsFindByIdAsync2() {
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
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link JpaDeviceDao#findByIdAsync(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByIdAsync(TenantId, DeviceId); when TenantId(UUID) with id is NULL_UUID; then calls findByIdAsync(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid_thenCallsFindByIdAsync() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
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
   * Test {@link DeviceServiceImpl#findDeviceByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByTenantIdAndName(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.findDeviceByTenantIdAndName(TenantId, String)"})
  void testFindDeviceByTenantIdAndName_thenThrowDataValidationException() {
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findDeviceByTenantIdAndNameAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindDeviceByTenantIdAndNameAsync() {
    // Arrange
    JpaExecutorService executor = mock(JpaExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(executor.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();

    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            new BaseEntityCountService(),
            executor);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndNameAsyncResult =
        deviceServiceImpl.findDeviceByTenantIdAndNameAsync(tenantId, "Name");

    // Assert
    verify(executor).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindDeviceByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByTenantIdAndNameAsync(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindDeviceByTenantIdAndNameAsync_thenThrowDataValidationException() {
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

    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            new BaseEntityCountService(),
            mock(JpaExecutorService.class));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findDeviceByTenantIdAndNameAsync(TenantId, String); when SYSTEM_TENANT; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindDeviceByTenantIdAndNameAsync_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    JpaExecutorService executor = mock(JpaExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(executor.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();

    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            new BaseEntityCountService(),
            executor);

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndNameAsyncResult =
        deviceServiceImpl.findDeviceByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(executor).submit(isA(Callable.class));
    assertTrue(actualFindDeviceByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @DisplayName("Test saveDeviceWithAccessToken(Device, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  void testSaveDeviceWithAccessToken() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithAccessToken(device, "ABC123"));
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @DisplayName("Test saveDeviceWithAccessToken(Device, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  void testSaveDeviceWithAccessToken2() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithAccessToken(new Device(), "ABC123"));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceWithAccessToken(Device, String); given SYSTEM_TENANT; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  void testSaveDeviceWithAccessToken_givenSystem_tenant_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithAccessToken(device, "ABC123"));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @DisplayName("Test saveDeviceWithAccessToken(Device, String); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  void testSaveDeviceWithAccessToken_thenCallsGetName() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));

    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
    when(deviceValidator.validate(Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
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

    Device device2 = new Device((DeviceId) null);
    device2.setDeviceProfileId(null);
    device2.setType("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithAccessToken(device2, ""));
    verify(device).getName();
    verify(deviceValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device)} with {@code device}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @DisplayName("Test saveDevice(Device) with 'device'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  void testSaveDeviceWithDevice() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device));
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device)} with {@code device}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @DisplayName("Test saveDevice(Device) with 'device'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  void testSaveDeviceWithDevice2() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(new Device()));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @DisplayName("Test saveDevice(Device, boolean) with 'device', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  void testSaveDeviceWithDeviceDoValidate() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device, true));
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @DisplayName("Test saveDevice(Device, boolean) with 'device', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  void testSaveDeviceWithDeviceDoValidate2() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.saveDevice(new Device(), true));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @DisplayName("Test saveDevice(Device, boolean) with 'device', 'doValidate'; given SYSTEM_TENANT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  void testSaveDeviceWithDeviceDoValidate_givenSystem_tenant() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device, true));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @DisplayName("Test saveDevice(Device, boolean) with 'device', 'doValidate'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  void testSaveDeviceWithDeviceDoValidate_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device, false));
    verify(device).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @DisplayName("Test saveDevice(Device, boolean) with 'device', 'doValidate'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  void testSaveDeviceWithDeviceDoValidate_thenCallsGetName() {
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
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @DisplayName("Test saveDevice(Device) with 'device'; given SYSTEM_TENANT; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  void testSaveDeviceWithDevice_givenSystem_tenant_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(Device)} with {@code device}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @DisplayName("Test saveDevice(Device) with 'device'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  void testSaveDeviceWithDevice_thenCallsGetName() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));

    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
    when(deviceValidator.validate(Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
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

    Device device2 = new Device((DeviceId) null);
    device2.setDeviceProfileId(null);
    device2.setType("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device2));
    verify(device).getName();
    verify(deviceValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)} with {@code
   * provisionRequest}, {@code profile}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test saveDevice(ProvisionRequest, DeviceProfile) with 'provisionRequest', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  void testSaveDeviceWithProvisionRequestProfile() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDevice(provisionRequest, new DeviceProfile()));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)} with {@code
   * provisionRequest}, {@code profile}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test saveDevice(ProvisionRequest, DeviceProfile) with 'provisionRequest', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  void testSaveDeviceWithProvisionRequestProfile2() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("", "", "", "", "");
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            false);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDevice(provisionRequest, new DeviceProfile()));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)} with {@code
   * provisionRequest}, {@code profile}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test saveDevice(ProvisionRequest, DeviceProfile) with 'provisionRequest', 'profile'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  void testSaveDeviceWithProvisionRequestProfile_thenCallsGetName() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));

    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
    when(deviceValidator.validate(Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
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
    ProvisionDeviceCredentialsData credentialsData =
        new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe", "iloveyou", "X509 Cert Hash");
    ProvisionRequest provisionRequest =
        new ProvisionRequest(
            "Device Name",
            DeviceCredentialsType.ACCESS_TOKEN,
            credentialsData,
            new ProvisionDeviceProfileCredentials(
                "Provision Device Key", "Provision Device Secret"),
            true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDevice(provisionRequest, new DeviceProfile()));
    verify(device).getName();
    verify(deviceValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test saveDeviceWithCredentials(Device, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  void testSaveDeviceWithCredentials() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithCredentials(device, new DeviceCredentials()));
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test saveDeviceWithCredentials(Device, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  void testSaveDeviceWithCredentials2() {
    // Arrange
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Device device = new Device();

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithCredentials(device, new DeviceCredentials()));
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test saveDeviceWithCredentials(Device, DeviceCredentials); given SYSTEM_TENANT; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  void testSaveDeviceWithCredentials_givenSystem_tenant_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
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

    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithCredentials(device, new DeviceCredentials()));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test saveDeviceWithCredentials(Device, DeviceCredentials); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  void testSaveDeviceWithCredentials_thenCallsGetName() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));

    DeviceDataValidator deviceValidator = mock(DeviceDataValidator.class);
    when(deviceValidator.validate(Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
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

    Device device2 = new Device((DeviceId) null);
    device2.setDeviceProfileId(null);
    device2.setType("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.saveDeviceWithCredentials(device2, new DeviceCredentials()));
    verify(device).getName();
    verify(deviceValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevice(TenantId, DeviceId)} with {@code tenantId}, {@code
   * deviceId}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevice(TenantId, DeviceId)}
   */
  @Test
  @DisplayName(
      "Test deleteDevice(TenantId, DeviceId) with 'tenantId', 'deviceId'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevice(TenantId, DeviceId)"})
  void testDeleteDeviceWithTenantIdDeviceId_thenThrowDataValidationException() {
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.deleteDevice(ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantId(TenantId, PageLink); then calls findDevicesByTenantId(UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId_thenCallsFindDevicesByTenantId() {
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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
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
  @DisplayName("Test findDevicesByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId_thenCallsGetProperty() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
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
  @DisplayName(
      "Test findDevicesByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  void testFindDevicesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter() {
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
    when(filter.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getTenantId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter5() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter6() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, mock(PageLink.class)));
    verify(filter).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); given SortOrder getProperty() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); given SortOrder getProperty() return 'null'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_givenSortOrderGetPropertyReturnNull_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
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
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); then calls getCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_thenCallsGetCustomerId() {
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    when(filter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(filter).getTenantId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
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
  @DisplayName(
      "Test findDeviceInfosByFilter(DeviceInfoFilter, PageLink); when 'null'; then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  void testFindDeviceInfosByFilter_whenNull_thenThrowIncorrectParameterException() {
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

    // Act and Assert
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
  @DisplayName("Test findDeviceIdInfos(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDeviceIdInfos(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceIdInfos(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceIdInfos(PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDeviceIdInfos(PageLink); given SortOrder getProperty() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDeviceIdInfos(PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceIdInfos(PageLink); then calls findDeviceIdInfos(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos_thenCallsFindDeviceIdInfos() {
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
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @DisplayName("Test findDeviceIdInfos(PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  void testFindDeviceIdInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
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

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndType(TenantId, String, PageLink); then calls findDevicesByTenantIdAndType(UUID, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType_thenCallsFindDevicesByTenantIdAndType() {
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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndType(TenantId, String, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage() {
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

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT,
                deviceProfileId,
                OtaPackageType.FIRMWARE,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceProfileId).getId();
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
        PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage5() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
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
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage6() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage7() {
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
        PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage8() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
        PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            tenantId, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
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
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link JpaDeviceDao} {@link JpaDeviceDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then calls {@link JpaDeviceDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given JpaDeviceDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenJpaDeviceDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
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

    // Act
    deviceServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentialsService#deleteDeviceCredentialsByDeviceId(TenantId,
   *       DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); then calls deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsDeleteDeviceCredentialsByDeviceId() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Device());
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));

    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);
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

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(device).getId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenThrowIncorrectParameterException() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);
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

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> deviceServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(device).getId();
    verify(id).getId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
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
  @DisplayName(
      "Test countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);
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
   * Test {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage2() {
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

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
                ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE));
    verify(deviceProfileId).getId();
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
  @DisplayName(
      "Test countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);
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
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage4() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            tenantId, deviceProfileId, OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(deviceDao)
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            isA(UUID.class), isA(UUID.class), eq(OtaPackageType.FIRMWARE));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindDevicesByTenantIdAndIdsAsync() {
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(tenantId, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindDevicesByTenantIdAndIdsAsync2() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, deviceIds));
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindDevicesByTenantIdAndIdsAsync3() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, deviceIds));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindDevicesByTenantIdAndIdsAsync4() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(tenantId, deviceIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
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
  @DisplayName("Test findDevicesByTenantIdAndIdsAsync(TenantId, List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindDevicesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
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
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @DisplayName("Test findDevicesByIds(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  void testFindDevicesByIds() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIds(deviceIds));
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIds(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @DisplayName("Test findDevicesByIds(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  void testFindDevicesByIds2() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
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

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIds(deviceIds));
    verify(deviceId).getId();
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
  @DisplayName("Test findDevicesByIds(List); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  void testFindDevicesByIds_thenReturnEmpty() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());
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

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    List<Device> actualFindDevicesByIdsResult = deviceServiceImpl.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceDao).findDevicesByIds(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @DisplayName("Test findDevicesByIdsAsync(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  void testFindDevicesByIdsAsync() {
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
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @DisplayName("Test findDevicesByIdsAsync(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  void testFindDevicesByIdsAsync2() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIdsAsync(deviceIds));
    verify(deviceId).getId();
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
  @DisplayName("Test findDevicesByIdsAsync(List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  void testFindDevicesByIdsAsync_thenReturnSettableFuture() {
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
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @DisplayName("Test findDevicesByIdsAsync(List); then throw IncorrectParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  void testFindDevicesByIdsAsync_thenThrowIncorrectParameterException() {
    // Arrange
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> deviceServiceImpl.findDevicesByIdsAsync(deviceIds));
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIdsAsync(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDevicesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  void testDeleteDevicesByTenantId() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDevicesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  void testDeleteDevicesByTenantId2() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.deleteDevicesByTenantId(tenantId));
    verify(tenantId).getId();
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
  @DisplayName(
      "Test deleteDevicesByTenantId(TenantId); given PageData hasNext() return 'false'; then calls hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  void testDeleteDevicesByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());

    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    deviceServiceImpl.deleteDevicesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentialsService#deleteDeviceCredentialsByDeviceId(TenantId,
   *       DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteDevicesByTenantId(TenantId); then calls deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  void testDeleteDevicesByTenantId_thenCallsDeleteDeviceCredentialsByDeviceId() {
    // Arrange
    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(new Device());

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.deleteDevicesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(isA(TenantId.class), isNull());
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDevicesByTenantId(TenantId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  void testDeleteDevicesByTenantId_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getUuidId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getId()).thenReturn(null);

    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(device);

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);

    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    DeviceCredentialsDao deviceCredentialsDao = mock(DeviceCredentialsDao.class);
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.deleteDevicesByTenantId(tenantId));
    verify(device, atLeast(1)).getId();
    verify(device).getUuidId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
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
  @DisplayName(
      "Test deleteByTenantId(TenantId); given DeviceDao findDevicesByTenantId(UUID, PageLink) return emptyPageData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenDeviceDaoFindDevicesByTenantIdReturnEmptyPageData() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
  @DisplayName(
      "Test deleteByTenantId(TenantId); given PageData hasNext() return 'false'; then calls hasNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());

    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    deviceServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentialsService#deleteDeviceCredentialsByDeviceId(TenantId,
   *       DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); then calls deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsDeleteDeviceCredentialsByDeviceId() {
    // Arrange
    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(new Device());

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(deviceCredentialsService)
        .deleteDeviceCredentialsByDeviceId(isA(TenantId.class), isNull());
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getUuidId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getId()).thenReturn(null);

    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(device);

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);

    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    DeviceCredentialsDao deviceCredentialsDao = mock(DeviceCredentialsDao.class);
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.deleteByTenantId(tenantId));
    verify(device, atLeast(1)).getId();
    verify(device).getUuidId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
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
  @DisplayName("Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId4() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType5() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetId2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            tenantId, customerId, "Type", pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndCustomerIdAndType_whenFirst_page() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindDevicesByTenantIdCustomerIdAndIdsAsync() {
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindDevicesByTenantIdCustomerIdAndIdsAsync2() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, deviceIds));
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindDevicesByTenantIdCustomerIdAndIdsAsync3() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, deviceIds));
    verify(deviceId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindDevicesByTenantIdCustomerIdAndIdsAsync4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, deviceIds));
    verify(deviceId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
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
  @DisplayName(
      "Test findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult =
        deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
            tenantId, customerId, deviceIds);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(deviceDao)
        .findDevicesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test unassignCustomerDevices(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.unassignCustomerDevices(TenantId, CustomerId)"})
  void testUnassignCustomerDevices() {
    // Arrange
    DeviceDao deviceDao = mock(DeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerDevices(TenantId, CustomerId); given PageData hasNext() return 'false'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.unassignCustomerDevices(TenantId, CustomerId)"})
  void testUnassignCustomerDevices_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());

    DeviceDao deviceDao = mock(DeviceDao.class);
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    deviceServiceImpl.unassignCustomerDevices(tenantId, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(deviceDao)
        .findDevicesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findDeviceTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  void testFindDeviceTypesByTenantId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDeviceTypesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceTypesByTenantId(TenantId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  void testFindDeviceTypesByTenantId_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindDeviceTypesByTenantIdResult =
        deviceServiceImpl.findDeviceTypesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(deviceDao).findTenantDeviceTypesAsync(isA(UUID.class));
    assertTrue(actualFindDeviceTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceTypesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceDao#findTenantDeviceTypesAsync(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findDeviceTypesByTenantId(TenantId); then calls findTenantDeviceTypesAsync(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  void testFindDeviceTypesByTenantId_thenCallsFindTenantDeviceTypesAsync() {
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
   * Test {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findDeviceTypesByTenantId(TenantId); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  void testFindDeviceTypesByTenantId_thenReturnSettableFuture() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);
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

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindDeviceTypesByTenantIdResult =
        deviceServiceImpl.findDeviceTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceDao).findTenantDeviceTypesAsync(isA(UUID.class));
    assertTrue(actualFindDeviceTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceTypesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}
   */
  @Test
  @DisplayName("Test assignDeviceToTenant(TenantId, Device); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToTenant(TenantId, Device)"})
  void testAssignDeviceToTenant_thenCallsGetId() {
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

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    Device device = new Device();
    device.setTenantId(tenantId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.assignDeviceToTenant(ModelConstants.SYSTEM_TENANT, device));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}
   */
  @Test
  @DisplayName("Test assignDeviceToTenant(TenantId, Device); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToTenant(TenantId, Device)"})
  void testAssignDeviceToTenant_thenCallsGetTenantId() {
    // Arrange
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
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

    Device device = mock(Device.class);
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setTenantId(mock(TenantId.class));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.assignDeviceToTenant(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getTenantId();
    verify(device).setTenantId(isA(TenantId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
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
  @DisplayName(
      "Test findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  void testFindDevicesIdsByDeviceProfileTransportType_thenReturnEmpty_page_data() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<UUID> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesIdsByDeviceProfileTransportType(
            Mockito.<DeviceTransportType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult =
        deviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(
            DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceDao)
        .findDevicesIdsByDeviceProfileTransportType(
            eq(DeviceTransportType.DEFAULT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesIdsByDeviceProfileTransportTypeResult);
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
  @DisplayName(
      "Test findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)"
  })
  void testFindDevicesIdsByDeviceProfileTransportType_thenThrowDataValidationException() {
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
   * Test {@link DeviceServiceImpl#assignDeviceToEdge(TenantId, DeviceId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#assignDeviceToEdge(TenantId, DeviceId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test assignDeviceToEdge(TenantId, DeviceId, EdgeId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToEdge(TenantId, DeviceId, EdgeId)"})
  void testAssignDeviceToEdge_thenThrowDataValidationException() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.assignDeviceToEdge(ModelConstants.SYSTEM_TENANT, deviceId, null));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#unassignDeviceFromEdge(TenantId, DeviceId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignDeviceFromEdge(TenantId, DeviceId,
   * EdgeId)}
   */
  @Test
  @DisplayName(
      "Test unassignDeviceFromEdge(TenantId, DeviceId, EdgeId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.unassignDeviceFromEdge(TenantId, DeviceId, EdgeId)"})
  void testUnassignDeviceFromEdge_thenThrowDataValidationException() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.unassignDeviceFromEdge(ModelConstants.SYSTEM_TENANT, deviceId, null));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId() {
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId4() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given SortOrder getProperty() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
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
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); then calls findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId_thenCallsFindDevicesByTenantIdAndEdgeId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); then calls findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId_thenCallsFindDevicesByTenantIdAndEdgeId2() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(tenantId, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType() {
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType2() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType3() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType4() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType5() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType6() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType7() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType_givenBy_created_time_desc() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType_thenCallsGetId() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(tenantId, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
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
  @DisplayName(
      "Test findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindDevicesByTenantIdAndEdgeIdAndType_thenCallsGetProperty() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
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

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
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
    verify(sortOrder).getProperty();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link JpaDeviceDao} {@link JpaDeviceDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test countByTenantId(TenantId); given JpaDeviceDao countByTenantId(TenantId) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_givenJpaDeviceDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    JpaDeviceDao deviceDao = mock(JpaDeviceDao.class);
    when(deviceDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);
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
  @DisplayName("Test countByTenantId(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DeviceServiceImpl.countByTenantId(TenantId)"})
  void testCountByTenantId_thenThrowDataValidationException() {
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
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DeviceServiceImpl.getEntityType()"})
  void testGetEntityType() {
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

    // Act and Assert
    assertEquals(EntityType.DEVICE, deviceServiceImpl.getEntityType());
  }
}
