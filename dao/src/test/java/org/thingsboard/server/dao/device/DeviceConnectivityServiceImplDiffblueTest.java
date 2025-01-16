package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.net.URISyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.settings.AdminSettingsService;

@ContextConfiguration(classes = {DeviceConnectivityServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class DeviceConnectivityServiceImplDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @Autowired
  private DeviceConnectivityServiceImpl deviceConnectivityServiceImpl;

  @MockBean
  private DeviceCredentialsService deviceCredentialsService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  /**
   * Test
   * {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#findDevicePublishTelemetryCommands(String, Device)}
   */
  @Test
  public void testFindDevicePublishTelemetryCommands_thenThrowRuntimeException() throws URISyntaxException {
    // Arrange
    Device device = mock(Device.class);
    when(device.getTenantId()).thenThrow(new RuntimeException("Executing findDevicePublishTelemetryCommands [{}]"));
    when(device.getId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> deviceConnectivityServiceImpl.findDevicePublishTelemetryCommands("https://example.org/example", device));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  public void testGetPemCertFile() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  public void testGetPemCertFile2() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  public void testGetPemCertFile_givenAdminSettingsGetJsonValueReturnInstance() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  public void testGetPemCertFile_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#getPemCertFile(String)}
   */
  @Test
  public void testGetPemCertFile_givenJsonNodeGetReturnInstance_thenCallsGet() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Resource actualPemCertFile = deviceConnectivityServiceImpl.getPemCertFile("Protocol");

    // Assert
    verify(jsonNode).get(eq("Protocol"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertNull(actualPemCertFile);
  }

  /**
   * Test
   * {@link DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceConnectivityServiceImpl#createGatewayDockerComposeFile(String, Device)}
   */
  @Test
  public void testCreateGatewayDockerComposeFile_thenThrowRuntimeException() throws URISyntaxException {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("mqtts"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> deviceConnectivityServiceImpl
        .createGatewayDockerComposeFile("https://example.org/example", new Device()));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   * <p>
   * Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  public void testIsEnabled() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@link AdminSettings#AdminSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenAdminSettingsServiceFindAdminSettingsByKeyReturnAdminSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }

  /**
   * Test {@link DeviceConnectivityServiceImpl#isEnabled(String)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceConnectivityServiceImpl#isEnabled(String)}
   */
  @Test
  public void testIsEnabled_givenJsonNodeGetReturnInstance_thenCallsGet() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    boolean actualIsEnabledResult = deviceConnectivityServiceImpl.isEnabled("Protocol");

    // Assert
    verify(jsonNode).get(eq("Protocol"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("connectivity"));
    assertFalse(actualIsEnabledResult);
  }
}
