package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.info.DeviceActivityNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.DeviceActivityTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig.DeviceActivityNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig.DeviceEvent;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;

@ContextConfiguration(classes = {DeviceActivityTriggerProcessor.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DeviceActivityTriggerProcessorDiffblueTest {
  @Autowired
  private DeviceActivityTriggerProcessor deviceActivityTriggerProcessor;

  @MockBean
  private TbDeviceProfileCache tbDeviceProfileCache;

  /**
   * Test {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)} with {@code DeviceActivityTrigger}, {@code DeviceActivityNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig) with 'DeviceActivityTrigger', 'DeviceActivityNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceActivityTriggerProcessor.matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithDeviceActivityTriggerDeviceActivityNotificationRuleTriggerConfig() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.isActive()).thenReturn(true);
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig triggerConfig = devicesResult.notifyOn(new HashSet<>()).build();

    // Act
    boolean actualMatchesFilterResult = deviceActivityTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).isActive();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)} with {@code DeviceActivityTrigger}, {@code DeviceActivityNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig) with 'DeviceActivityTrigger', 'DeviceActivityNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceActivityTriggerProcessor.matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithDeviceActivityTriggerDeviceActivityNotificationRuleTriggerConfig2() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.isActive()).thenReturn(false);
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig triggerConfig = devicesResult.notifyOn(new HashSet<>()).build();

    // Act
    boolean actualMatchesFilterResult = deviceActivityTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).isActive();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)} with {@code DeviceActivityTrigger}, {@code DeviceActivityNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig) with 'DeviceActivityTrigger', 'DeviceActivityNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceActivityTriggerProcessor.matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithDeviceActivityTriggerDeviceActivityNotificationRuleTriggerConfig3() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.getDeviceId()).thenReturn(null);
    when(trigger.isActive()).thenReturn(true);

    HashSet<DeviceEvent> notifyOn = new HashSet<>();
    notifyOn.add(DeviceEvent.ACTIVE);
    DeviceActivityNotificationRuleTriggerConfigBuilder builderResult = DeviceActivityNotificationRuleTriggerConfig
        .builder();
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = builderResult
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfig triggerConfig = deviceProfilesResult.devices(new HashSet<>())
        .notifyOn(notifyOn)
        .build();

    // Act
    boolean actualMatchesFilterResult = deviceActivityTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getDeviceId();
    verify(trigger).isActive();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)} with {@code DeviceActivityTrigger}, {@code DeviceActivityNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig) with 'DeviceActivityTrigger', 'DeviceActivityNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceActivityTriggerProcessor.matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithDeviceActivityTriggerDeviceActivityNotificationRuleTriggerConfig4() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.getDeviceId()).thenReturn(null);
    when(trigger.isActive()).thenReturn(true);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder
        .deviceProfiles(new HashSet<>());
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(new HashSet<>());

    HashSet<DeviceEvent> notifyOn = new HashSet<>();
    notifyOn.add(DeviceEvent.ACTIVE);
    DeviceActivityNotificationRuleTriggerConfig triggerConfig = devicesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = deviceActivityTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getDeviceId();
    verify(trigger).isActive();
    verify(deviceActivityNotificationRuleTriggerConfigBuilder).deviceProfiles(isA(Set.class));
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)} with {@code DeviceActivityTrigger}, {@code DeviceActivityNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig) with 'DeviceActivityTrigger', 'DeviceActivityNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceActivityTriggerProcessor.matchesFilter(DeviceActivityTrigger, DeviceActivityNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithDeviceActivityTriggerDeviceActivityNotificationRuleTriggerConfig5() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.getDeviceId()).thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.isActive()).thenReturn(true);
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceActivityNotificationRuleTriggerConfigBuilder = mock(
        DeviceActivityNotificationRuleTriggerConfigBuilder.class);
    when(deviceActivityNotificationRuleTriggerConfigBuilder.deviceProfiles(Mockito.<Set<UUID>>any()))
        .thenReturn(DeviceActivityNotificationRuleTriggerConfig.builder());
    DeviceActivityNotificationRuleTriggerConfigBuilder deviceProfilesResult = deviceActivityNotificationRuleTriggerConfigBuilder
        .deviceProfiles(new HashSet<>());

    HashSet<UUID> devices = new HashSet<>();
    devices.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceActivityNotificationRuleTriggerConfigBuilder devicesResult = deviceProfilesResult.devices(devices);

    HashSet<DeviceEvent> notifyOn = new HashSet<>();
    notifyOn.add(DeviceEvent.ACTIVE);
    DeviceActivityNotificationRuleTriggerConfig triggerConfig = devicesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = deviceActivityTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getDeviceId();
    verify(trigger).isActive();
    verify(deviceActivityNotificationRuleTriggerConfigBuilder).deviceProfiles(isA(Set.class));
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#constructNotificationInfo(DeviceActivityTrigger)} with {@code DeviceActivityTrigger}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#constructNotificationInfo(DeviceActivityTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(DeviceActivityTrigger) with 'DeviceActivityTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo DeviceActivityTriggerProcessor.constructNotificationInfo(DeviceActivityTrigger)"})
  void testConstructNotificationInfoWithDeviceActivityTrigger() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.getDeviceLabel()).thenReturn("Device Label");
    when(trigger.getDeviceName()).thenReturn("Device Name");
    when(trigger.getDeviceType()).thenReturn("Device Type");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getCustomerId()).thenReturn(customerId);
    when(trigger.isActive()).thenReturn(true);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceId deviceId = new DeviceId(id);
    when(trigger.getDeviceId()).thenReturn(deviceId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = deviceActivityTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getDeviceId();
    verify(trigger).getDeviceLabel();
    verify(trigger).getDeviceName();
    verify(trigger).getDeviceType();
    verify(trigger).isActive();
    EntityId stateEntityId = actualConstructNotificationInfoResult.getStateEntityId();
    assertTrue(stateEntityId instanceof DeviceId);
    assertTrue(actualConstructNotificationInfoResult instanceof DeviceActivityNotificationInfo);
    assertEquals("Device Label",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceLabel());
    assertEquals("Device Name",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceName());
    assertEquals("Device Type",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceType());
    assertEquals("active", ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getEventType());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(5, templateData.size());
    assertTrue(templateData.containsKey("deviceId"));
    assertTrue(templateData.containsKey("deviceLabel"));
    assertTrue(templateData.containsKey("deviceName"));
    assertTrue(templateData.containsKey("deviceType"));
    assertTrue(templateData.containsKey("eventType"));
    assertEquals(deviceId, stateEntityId);
    assertEquals(templateData, actualTemplateData);
    assertSame(customerId,
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(id, ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceId());
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#constructNotificationInfo(DeviceActivityTrigger)} with {@code DeviceActivityTrigger}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#constructNotificationInfo(DeviceActivityTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(DeviceActivityTrigger) with 'DeviceActivityTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo DeviceActivityTriggerProcessor.constructNotificationInfo(DeviceActivityTrigger)"})
  void testConstructNotificationInfoWithDeviceActivityTrigger2() {
    // Arrange
    DeviceActivityTrigger trigger = mock(DeviceActivityTrigger.class);
    when(trigger.getDeviceLabel()).thenReturn("Device Label");
    when(trigger.getDeviceName()).thenReturn("Device Name");
    when(trigger.getDeviceType()).thenReturn("Device Type");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getCustomerId()).thenReturn(customerId);
    when(trigger.isActive()).thenReturn(false);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceId deviceId = new DeviceId(id);
    when(trigger.getDeviceId()).thenReturn(deviceId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = deviceActivityTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getDeviceId();
    verify(trigger).getDeviceLabel();
    verify(trigger).getDeviceName();
    verify(trigger).getDeviceType();
    verify(trigger).isActive();
    EntityId stateEntityId = actualConstructNotificationInfoResult.getStateEntityId();
    assertTrue(stateEntityId instanceof DeviceId);
    assertTrue(actualConstructNotificationInfoResult instanceof DeviceActivityNotificationInfo);
    assertEquals("Device Label",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceLabel());
    assertEquals("Device Name",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceName());
    assertEquals("Device Type",
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceType());
    assertEquals("inactive", ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getEventType());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(5, templateData.size());
    assertTrue(templateData.containsKey("deviceId"));
    assertTrue(templateData.containsKey("deviceLabel"));
    assertTrue(templateData.containsKey("deviceName"));
    assertTrue(templateData.containsKey("deviceType"));
    assertTrue(templateData.containsKey("eventType"));
    assertEquals(deviceId, stateEntityId);
    assertEquals(templateData, actualTemplateData);
    assertSame(customerId,
        ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(id, ((DeviceActivityNotificationInfo) actualConstructNotificationInfoResult).getDeviceId());
  }

  /**
   * Test {@link DeviceActivityTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link DeviceActivityTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType DeviceActivityTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.DEVICE_ACTIVITY,
        (new DeviceActivityTriggerProcessor(new DefaultTbDeviceProfileCache(deviceProfileService,
            new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService,
                tenantService, deviceValidator, countService, new JpaExecutorService()))))
            .getTriggerType());
  }
}
