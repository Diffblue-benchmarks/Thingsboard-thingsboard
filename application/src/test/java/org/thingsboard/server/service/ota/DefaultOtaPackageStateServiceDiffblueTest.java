package org.thingsboard.server.service.ota;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
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
  void testUpdateWithDeviceProfileIsFirmwareChangedIsSoftwareChanged2() {
    // Arrange
    ArrayList<Device> data = new ArrayList<>();
    data.add(new Device());
    PageData<Device> pageData = new PageData<>(data, 1, 1L, false);

    when(deviceService.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doNothing().when(ruleEngineTelemetryService)
        .deleteAndNotify(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any(), Mockito.<FutureCallback<Void>>any());

    // Act
    defaultOtaPackageStateService.update(new DeviceProfile(), true, true);

    // Assert
    verify(ruleEngineTelemetryService, atLeast(1)).deleteAndNotify((TenantId) isNull(), (EntityId) isNull(),
        eq(AttributeScope.SHARED_SCOPE), Mockito.<List<String>>any(), Mockito.<FutureCallback<Void>>any());
    verify(deviceService, atLeast(1)).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isNull(), isNull(),
        Mockito.<OtaPackageType>any(), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code isFirmwareChanged},
   * {@code isSoftwareChanged}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   */
  @Test
  @DisplayName("Test update(DeviceProfile, boolean, boolean) with 'deviceProfile', 'isFirmwareChanged', 'isSoftwareChanged'; when 'false'")
  void testUpdateWithDeviceProfileIsFirmwareChangedIsSoftwareChanged_whenFalse() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    defaultOtaPackageStateService.update(new DeviceProfile(), false, true);

    // Assert
    verify(deviceService).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isNull(), isNull(),
        eq(OtaPackageType.SOFTWARE), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   * with {@code deviceProfile}, {@code isFirmwareChanged},
   * {@code isSoftwareChanged}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultOtaPackageStateService#update(DeviceProfile, boolean, boolean)}
   */
  @Test
  @DisplayName("Test update(DeviceProfile, boolean, boolean) with 'deviceProfile', 'isFirmwareChanged', 'isSoftwareChanged'; when 'false'")
  void testUpdateWithDeviceProfileIsFirmwareChangedIsSoftwareChanged_whenFalse2() {
    // Arrange
    PageData<Device> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDevicesByTenantIdAndTypeAndEmptyOtaPackage(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    defaultOtaPackageStateService.update(new DeviceProfile(), true, false);

    // Assert
    verify(deviceService).findDevicesByTenantIdAndTypeAndEmptyOtaPackage(isNull(), isNull(),
        eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
  }
}
