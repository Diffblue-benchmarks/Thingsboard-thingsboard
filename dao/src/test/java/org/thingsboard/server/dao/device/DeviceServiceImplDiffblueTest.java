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
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceImplDiffblueTest {
  @Mock private DeviceCredentialsService deviceCredentialsService;

  @Mock private DeviceDao deviceDao;

  @Mock private DeviceDataValidator deviceDataValidator;

  @InjectMocks private DeviceServiceImpl deviceServiceImpl;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private TenantService tenantService;

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link DeviceId} {@link DeviceId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  public void testFindDeviceInfoById_givenNull_uuid_whenDeviceIdGetIdReturnNull_uuid() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  public void testFindDeviceInfoById_thenThrowDataValidationException() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfoById(ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@link DeviceInfo#DeviceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfoById(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceInfo DeviceServiceImpl.findDeviceInfoById(TenantId, DeviceId)"})
  public void testFindDeviceInfoById_whenDeviceIdWithIdIsNull_uuid_thenReturnDeviceInfo() {
    // Arrange
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceDao.findDeviceInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceInfo);

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult =
        deviceServiceImpl.findDeviceInfoById(
            ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findDeviceInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.findDeviceById(TenantId, DeviceId)"})
  public void testFindDeviceById_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync() {
    // Arrange
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceByIdAsync(
                ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID)));
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync2() {
    // Arrange
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDeviceByIdAsync(null, deviceId));
    verify(deviceId, atLeast(1)).getId();
    verify(deviceDao).findDeviceByTenantIdAndIdAsync(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findByIdAsync(TenantId, UUID)} return create.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDeviceDaoFindByIdAsyncReturnCreate() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_givenDeviceDaoFindDeviceByTenantIdAndIdAsyncReturnCreate() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenDeviceIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByIdAsyncResult =
        deviceServiceImpl.findDeviceByIdAsync(
            ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindDeviceByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByIdAsyncResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>When {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenTenantId() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findDeviceByTenantIdAndIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = mock(TenantId.class);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByIdAsync(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceByIdAsync(TenantId, DeviceId)"})
  public void testFindDeviceByIdAsync_whenTenantIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<Device> createResult = SettableFuture.create();
    when(deviceDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.findDeviceByTenantIdAndName(TenantId, String)"})
  public void testFindDeviceByTenantIdAndName_thenThrowDataValidationException() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindDeviceByTenantIdAndNameAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndNameAsyncResult =
        deviceServiceImpl.findDeviceByTenantIdAndNameAsync(tenantId, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindDeviceByTenantIdAndNameAsync_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDeviceByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindDeviceByTenantIdAndNameAsync_whenSystem_tenant_thenReturnSettableFuture() {
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
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  public void testSaveDeviceWithAccessToken() {
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
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithAccessToken(Device, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDeviceWithAccessToken(Device, String)"})
  public void testSaveDeviceWithAccessToken_thenCallsGetName() {
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
   * Test {@link DeviceServiceImpl#saveDevice(Device)} with {@code device}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  public void testSaveDeviceWithDevice() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate() {
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
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate2() {
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
   *   <li>Given {@link DeviceId#DeviceId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate_givenDeviceIdWithIdIsNull_uuid() {
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
    when(device.getId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device, false));
    verify(device).getId();
    verify(device).getTenantId();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate_thenCallsGetName() {
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
   * Test {@link DeviceServiceImpl#saveDevice(Device, boolean)} with {@code device}, {@code
   * doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(Device, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device, boolean)"})
  public void testSaveDeviceWithDeviceDoValidate_thenCallsGetTenantId() {
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
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.saveDevice(device, false));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(Device)"})
  public void testSaveDeviceWithDevice_thenCallsGetName() {
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
   * Test {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)} with {@code
   * provisionRequest}, {@code profile}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDevice(ProvisionRequest, DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  public void testSaveDeviceWithProvisionRequestProfile() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  public void testSaveDeviceWithProvisionRequestProfile2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.saveDevice(ProvisionRequest, DeviceProfile)"})
  public void testSaveDeviceWithProvisionRequestProfile_thenCallsGetName() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDataValidator.validate(
            Mockito.<Device>any(), Mockito.<Function<Device, TenantId>>any()))
        .thenReturn(device);
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
    verify(deviceDataValidator).validate(isA(Device.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceServiceImpl#saveDeviceWithCredentials(Device, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  public void testSaveDeviceWithCredentials() {
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
   *   <li>Then calls {@link Device#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#saveDeviceWithCredentials(Device,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Device DeviceServiceImpl.saveDeviceWithCredentials(Device, DeviceCredentials)"
  })
  public void testSaveDeviceWithCredentials_thenCallsGetName() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevice(TenantId, DeviceId)"})
  public void testDeleteDeviceWithTenantIdDeviceId_thenThrowDataValidationException() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId5() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDevicesByTenantId(TenantId, PageLink)"})
  public void testFindDevicesByTenantId_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult =
        deviceServiceImpl.findDevicesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, null));
    verify(filter).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter3() {
    // Arrange
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE));
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(tenantId).getId();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter6() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink));
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenBy_created_time_desc() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, pageLink);

    // Assert
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceInfosByFilter(
            Mockito.<DeviceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceInfoFilter filter = mock(DeviceInfoFilter.class);
    when(filter.getTenantId()).thenReturn(tenantId);

    // Act
    PageData<DeviceInfo> actualFindDeviceInfosByFilterResult =
        deviceServiceImpl.findDeviceInfosByFilter(filter, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(filter).getTenantId();
    verify(tenantId).getId();
    verify(deviceDao).findDeviceInfosByFilter(isA(DeviceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceInfosByFilterResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceInfosByFilter(DeviceInfoFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDeviceInfosByFilter(DeviceInfoFilter, PageLink)"
  })
  public void testFindDeviceInfosByFilter_whenFirst_page_thenThrowIncorrectParameterException() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenBy_created_time_desc() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenSortOrderGetPropertyReturnNull_thenCallsGetProperty() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceIdInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DeviceServiceImpl.findDeviceIdInfos(PageLink)"})
  public void testFindDeviceIdInfos_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult =
        deviceServiceImpl.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(deviceDao).findDeviceIdInfos(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType4() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
            new DeviceProfileId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
                new DeviceProfileId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage3() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage4() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage5() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage6() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage8() {
    // Arrange
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   * <ul>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId,
   * OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult =
        deviceServiceImpl.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT, deviceProfileId, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then calls {@link DeviceDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenDeviceDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link Device#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(device).getId();
    verify(id).getId();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenCallsDeleteDeviceCredentialsByDeviceId() {
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
   * Test {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);

    // Act
    long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult =
        deviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage2() {
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
                new DeviceProfileId(ModelConstants.NULL_UUID),
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
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage3() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_givenNull_uuid() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId,
   * DeviceProfileId, OtaPackageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DeviceServiceImpl.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(TenantId, DeviceProfileId, OtaPackageType)"
  })
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage_thenCallsGetId() {
    // Arrange
    when(deviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<OtaPackageType>any()))
        .thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, deviceIds));
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync2() {
    // Arrange
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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenCallsGetId() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndIdsAsync(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindDevicesByTenantIdAndIdsAsync_thenThrowIncorrectParameterException() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, deviceIds));
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.findDevicesByIds(deviceIds));
    verify(deviceDao).findDevicesByIds(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIds(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds_thenReturnEmpty() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DeviceServiceImpl.findDevicesByIds(List)"})
  public void testFindDevicesByIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(deviceDao.findDevicesByIds(Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> deviceServiceImpl.findDevicesByIds(deviceIds));
    verify(deviceId).getId();
    verify(deviceDao).findDevicesByIds(isA(List.class));
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByIdsAsync(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync() {
    // Arrange
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Device>> createResult = SettableFuture.create();
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any())).thenReturn(createResult);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDevicesByIdsAsync(List)"})
  public void testFindDevicesByIdsAsync_thenThrowIncorrectParameterException() {
    // Arrange
    when(deviceDao.findDevicesByIdsAsync(Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Then calls {@link DeviceCredentialsService#deleteDeviceCredentialsByDeviceId(TenantId,
   *       DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId_thenCallsDeleteDeviceCredentialsByDeviceId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(device);

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceServiceImpl.deleteDevicesByTenantId(tenantId));
    verify(device).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteDevicesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteDevicesByTenantId(TenantId)"})
  public void testDeleteDevicesByTenantId_thenCallsGetUuidId() {
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
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findDevicesByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Then calls {@link DeviceCredentialsService#deleteDeviceCredentialsByDeviceId(TenantId,
   *       DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsDeleteDeviceCredentialsByDeviceId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsGetId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<Device> deviceList = new ArrayList<>();
    deviceList.add(device);

    PageData<Device> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(deviceList);
    when(deviceDao.findDevicesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceServiceImpl.deleteByTenantId(tenantId));
    verify(device).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(deviceDao).findDevicesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsGetUuidId() {
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
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId3() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId5() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType6() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_whenFirst_page() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndCustomerIdAndType_whenPageLinkGetPageReturnZero() {
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
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync2() {
    // Arrange
    when(deviceDao.findDevicesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deviceIds));
    verify(deviceId).getId();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync3() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<DeviceId> deviceIds = new ArrayList<>();
    deviceIds.add(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deviceIds));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture DeviceServiceImpl.findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
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
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceServiceImpl#findDevicesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    deviceIds.add(new DeviceId(ModelConstants.NULL_UUID));

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
   * Test {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#unassignCustomerDevices(TenantId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceServiceImpl.unassignCustomerDevices(TenantId, CustomerId)"})
  public void testUnassignCustomerDevices_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    PageData<Device> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(deviceDao.findDevicesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId() {
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
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId2() {
    // Arrange
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(deviceDao.findTenantDeviceTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDeviceTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture DeviceServiceImpl.findDeviceTypesByTenantId(TenantId)"})
  public void testFindDeviceTypesByTenantId_whenSystem_tenant_thenReturnSettableFuture() {
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
   * Test {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link Device#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToTenant(TenantId, Device)"})
  public void testAssignDeviceToTenant_givenSystem_tenant_thenCallsGetTenantId() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Device device = mock(Device.class);
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.assignDeviceToTenant(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getTenantId();
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantService#findTenantById(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#assignDeviceToTenant(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToTenant(TenantId, Device)"})
  public void testAssignDeviceToTenant_thenCallsFindTenantById() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceServiceImpl.assignDeviceToTenant(ModelConstants.SYSTEM_TENANT, new Device()));
    verify(tenantService).findTenantById(isNull());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceServiceImpl.assignDeviceToTenant(TenantId, Device)"})
  public void testAssignDeviceToTenant_thenCallsGetId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId() {
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
                new EdgeId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(ModelConstants.NULL_UUID),
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
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType() {
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
                new EdgeId(ModelConstants.NULL_UUID),
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType2() {
    // Arrange
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType5() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   * Test {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType6() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
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
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_whenEdgeIdWithIdIsNull_uuid() {
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
            new EdgeId(ModelConstants.NULL_UUID),
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
   * <ul>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DeviceServiceImpl#findDevicesByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DeviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  public void testFindDevicesByTenantIdAndEdgeIdAndType_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceDao.findDevicesByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult =
        deviceServiceImpl.findDevicesByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(deviceDao)
        .findDevicesByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
