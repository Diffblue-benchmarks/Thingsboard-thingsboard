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
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.DeviceDao;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {DeviceProfileDataValidator.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceProfileDataValidatorDiffblueTest {
  @MockBean private DashboardService dashboardService;

  @MockBean private DeviceDao deviceDao;

  @MockBean private DeviceProfileDao deviceProfileDao;

  @Autowired private DeviceProfileDataValidator deviceProfileDataValidator;

  @MockBean private DeviceProfileService deviceProfileService;

  @MockBean private RuleChainService ruleChainService;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setName("Device profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDataValidator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_givenDeviceProfileDataValidator() {
    // Arrange
    DeviceProfileDataValidator deviceProfileDataValidator = new DeviceProfileDataValidator();

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("Device profile name\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_givenEmptyString() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_givenTenantService() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setName("Device profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_givenTenantService2() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setName("Device profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_givenTenantService3() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setName("Device profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_thenCallsGetId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(deviceProfile);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    DeviceProfile deviceProfile2 = new DeviceProfile();
    deviceProfile2.setDefault(true);
    deviceProfile2.setTenantId(ModelConstants.SYSTEM_TENANT);
    deviceProfile2.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfile2.setType(DeviceProfileType.DEFAULT);
    deviceProfile2.setName("Device profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceProfile2));
    verify(deviceProfile).getId();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceProfileDataValidator#validateDataImpl(TenantId, DeviceProfile)} with {@code
   * TenantId}, {@code DeviceProfile}.
   *
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileDataValidator#validateDataImpl(TenantId,
   * DeviceProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileDataValidator.validateDataImpl(TenantId, DeviceProfile)"})
  public void testValidateDataImplWithTenantIdDeviceProfile_whenDeviceProfile() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new DeviceProfile()));
  }
}
