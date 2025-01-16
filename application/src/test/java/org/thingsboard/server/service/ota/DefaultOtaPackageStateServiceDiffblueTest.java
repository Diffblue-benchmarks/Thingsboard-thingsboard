package org.thingsboard.server.service.ota;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.RuleEngineTelemetryService;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.queue.provider.TbCoreQueueFactory;
import org.thingsboard.server.queue.provider.TbRuleEngineQueueFactory;

@ContextConfiguration(classes = {DefaultOtaPackageStateService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultOtaPackageStateServiceDiffblueTest {
  @Autowired
  private DefaultOtaPackageStateService defaultOtaPackageStateService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private DeviceService deviceService;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private RuleEngineTelemetryService ruleEngineTelemetryService;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbCoreQueueFactory tbCoreQueueFactory;

  @MockBean
  private TbRuleEngineQueueFactory tbRuleEngineQueueFactory;

  /**
   * Test {@link DefaultOtaPackageStateService#update(Device, Device)} with
   * {@code device}, {@code oldDevice}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceProfileService#findDeviceProfileById(TenantId, DeviceProfileId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultOtaPackageStateService#update(Device, Device)}
   */
  @Test
  @DisplayName("Test update(Device, Device) with 'device', 'oldDevice'; then calls findDeviceProfileById(TenantId, DeviceProfileId)")
  void testUpdateWithDeviceOldDevice_thenCallsFindDeviceProfileById() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new DeviceProfile());
    Device device = new Device();

    // Act
    defaultOtaPackageStateService.update(device, new Device());

    // Assert that nothing has changed
    verify(deviceProfileService, atLeast(1)).findDeviceProfileById(isNull(), isNull());
  }

  /**
   * Test {@link DefaultOtaPackageStateService#update(Device, Device)} with
   * {@code device}, {@code oldDevice}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls
   * {@link DeviceProfileService#findDeviceProfileById(TenantId, DeviceProfileId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultOtaPackageStateService#update(Device, Device)}
   */
  @Test
  @DisplayName("Test update(Device, Device) with 'device', 'oldDevice'; when 'null'; then calls findDeviceProfileById(TenantId, DeviceProfileId)")
  void testUpdateWithDeviceOldDevice_whenNull_thenCallsFindDeviceProfileById() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new DeviceProfile());

    // Act
    defaultOtaPackageStateService.update(new Device(), null);

    // Assert that nothing has changed
    verify(deviceProfileService, atLeast(1)).findDeviceProfileById(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code isFirmwareChanged},
   * {@code isSoftwareChanged}.
   * <p>
   * Method under test:
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   */
  @Test
  @DisplayName("Test update(DeviceProfile, boolean, boolean) with 'deviceProfile', 'isFirmwareChanged', 'isSoftwareChanged'")
  void testUpdateWithDeviceProfileIsFirmwareChangedIsSoftwareChanged() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    defaultOtaPackageStateService.update(new DeviceProfile(), true, true);

    // Assert
    verify(deviceService, atLeast(1)).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isNull(), isNull(),
        Mockito.<OtaPackageType>any(), isA(PageLink.class));
  }
}
