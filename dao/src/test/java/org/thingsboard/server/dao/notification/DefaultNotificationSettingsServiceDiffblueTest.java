package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.settings.NotificationSettings;
import org.thingsboard.server.common.data.notification.settings.UserNotificationSettings;
import org.thingsboard.server.common.data.notification.settings.UserNotificationSettings.NotificationPref;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.user.UserSettingsService;

@ContextConfiguration(classes = {DefaultNotificationSettingsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationSettingsServiceDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @Autowired
  private DefaultNotificationSettingsService defaultNotificationSettingsService;

  @MockBean
  private DefaultNotifications defaultNotifications;

  @MockBean
  private NotificationTargetService notificationTargetService;

  @MockBean
  private NotificationTemplateService notificationTemplateService;

  @MockBean
  private UserSettingsService userSettingsService;

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  public void testSaveNotificationSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    defaultNotificationSettingsService.saveNotificationSettings(ModelConstants.SYSTEM_TENANT, settings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  public void testSaveNotificationSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    defaultNotificationSettingsService.saveNotificationSettings(ModelConstants.SYSTEM_TENANT, settings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  public void testSaveNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new IllegalArgumentException("foo")).when(adminSettings).setJsonValue(Mockito.<JsonNode>any());
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.saveNotificationSettings(ModelConstants.SYSTEM_TENANT, settings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings_givenArrayNodeAsTokenReturnEndArray() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings_givenArrayNodeAsTokenReturnEndObject() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings_givenArrayNodeAsTokenReturnValueNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.VALUE_NULL);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Then return DeliveryMethodsConfigs is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings_thenReturnDeliveryMethodsConfigsIsNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult = defaultNotificationSettingsService
        .findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertNull(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  public void testFindNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.elements()).thenThrow(new IllegalArgumentException("foo"));
    when(arrayNode.asToken()).thenReturn(JsonToken.START_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT));
    verify(arrayNode, atLeast(1)).asToken();
    verify(arrayNode).elements();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}
   */
  @Test
  public void testDeleteNotificationSettings() {
    // Arrange
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    defaultNotificationSettingsService.deleteNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(adminSettingsService).deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}
   */
  @Test
  public void testDeleteNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("notifications"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.deleteNotificationSettings(ModelConstants.SYSTEM_TENANT));
    verify(adminSettingsService).deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}.
   * <ul>
   *   <li>Then return Prefs containsKey {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}
   */
  @Test
  public void testSaveUserNotificationSettings_thenReturnPrefsContainsKeyGeneral() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult = defaultNotificationSettingsService
        .saveUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null,
            new UserNotificationSettings(new HashMap<>()));

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualSaveUserNotificationSettingsResult
        .getPrefs();
    assertEquals(15, prefs.size());
    assertTrue(prefs.containsKey(NotificationType.GENERAL));
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}.
   * <ul>
   *   <li>Then return Prefs containsKey {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}
   */
  @Test
  public void testSaveUserNotificationSettings_thenReturnPrefsContainsKeyGeneral2()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult = defaultNotificationSettingsService
        .saveUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, null);

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualSaveUserNotificationSettingsResult
        .getPrefs();
    assertEquals(15, prefs.size());
    assertTrue(prefs.containsKey(NotificationType.GENERAL));
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code GENERAL} is
   * {@link NotificationPref} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}
   */
  @Test
  public void testSaveUserNotificationSettings_whenHashMapGeneralIsNotificationPref()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult = defaultNotificationSettingsService
        .saveUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, new UserNotificationSettings(prefs));

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs2 = actualSaveUserNotificationSettingsResult
        .getPrefs();
    assertEquals(15, prefs2.size());
    UserNotificationSettings.NotificationPref getResult = prefs2.get(NotificationType.ALARM);
    assertEquals(notificationPref, getResult);
    assertSame(notificationPref, prefs2.get(NotificationType.GENERAL));
    assertSame(getResult, prefs2.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs2.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs2.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs2.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} IfAbsent {@code GENERAL} is
   * {@link NotificationPref} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)}
   */
  @Test
  public void testSaveUserNotificationSettings_whenHashMapIfAbsentGeneralIsNotificationPref()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.putIfAbsent(NotificationType.GENERAL, notificationPref);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult = defaultNotificationSettingsService
        .saveUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, new UserNotificationSettings(prefs));

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs2 = actualSaveUserNotificationSettingsResult
        .getPrefs();
    assertEquals(15, prefs2.size());
    UserNotificationSettings.NotificationPref getResult = prefs2.get(NotificationType.ALARM);
    assertEquals(notificationPref, getResult);
    assertSame(notificationPref, prefs2.get(NotificationType.GENERAL));
    assertSame(getResult, prefs2.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs2.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs2.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs2.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("foo", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.fields()).thenReturn(entryList.iterator());
    when(jsonNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(jsonNode).fields();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings3() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("Failed to parse notification settings for user {}",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    entryList.add(new AbstractMap.SimpleEntry<>("foo", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.fields()).thenReturn(entryList.iterator());
    when(jsonNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(jsonNode).fields();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings4() throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.fields())
        .thenThrow(new IllegalArgumentException("Failed to parse notification settings for user {}"));
    when(jsonNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(jsonNode).fields();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link TreeNode#asToken()} return
   * {@code END_ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenJsonNodeAsTokenReturnEndArray() throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link TreeNode#asToken()} return
   * {@code END_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenJsonNodeAsTokenReturnEndObject()
      throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link TreeNode#asToken()} return
   * {@code null}.</li>
   *   <li>Then calls {@link TreeNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenJsonNodeAsTokenReturnNull_thenCallsAsToken()
      throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asToken()).thenReturn(null);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#isPojo()} return
   * {@code true}.</li>
   *   <li>Then calls {@link JsonNode#isPojo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenJsonNodeIsPojoReturnTrue_thenCallsIsPojo()
      throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isPojo()).thenReturn(true);
    when(jsonNode.asToken()).thenReturn(JsonToken.VALUE_EMBEDDED_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(jsonNode).isPojo();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenUserSettingsGetSettingsReturnInstance()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(MissingNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenUserSettingsGetSettingsReturnInstance2()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(NullNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_givenUserSettingsGetSettingsReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, UserNotificationSettings.NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    UserNotificationSettings.NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return Prefs Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  public void testGetUserNotificationSettings_whenFalse_thenReturnPrefsEmpty() throws UnsupportedEncodingException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.fields())
        .thenThrow(new IllegalArgumentException("Failed to parse notification settings for user {}"));
    when(jsonNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings = defaultNotificationSettingsService
        .getUserNotificationSettings(ModelConstants.SYSTEM_TENANT, null, false);

    // Assert
    verify(jsonNode, atLeast(1)).asToken();
    verify(jsonNode).fields();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    assertTrue(actualUserNotificationSettings.getPrefs().isEmpty());
    assertSame(actualUserNotificationSettings.DEFAULT, actualUserNotificationSettings);
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testCreateDefaultNotificationConfigs() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doNothing().when(defaultNotifications)
        .create(Mockito.<TenantId>any(), Mockito.<DefaultNotifications.DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    defaultNotificationSettingsService.createDefaultNotificationConfigs(tenantId);

    // Assert
    verify(defaultNotifications, atLeast(1)).create(isA(TenantId.class),
        Mockito.<DefaultNotifications.DefaultNotification>any(), isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testCreateDefaultNotificationConfigs_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doThrow(new IllegalArgumentException("All users")).when(defaultNotifications)
        .create(Mockito.<TenantId>any(), Mockito.<DefaultNotifications.DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.createDefaultNotificationConfigs(ModelConstants.SYSTEM_TENANT));
    verify(defaultNotifications).create(isA(TenantId.class), isA(DefaultNotifications.DefaultNotification.class),
        isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testCreateDefaultNotificationConfigs_whenTenantIdWithIdIsRandomUUID() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doNothing().when(defaultNotifications)
        .create(Mockito.<TenantId>any(), Mockito.<DefaultNotifications.DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act
    defaultNotificationSettingsService.createDefaultNotificationConfigs(new TenantId(UUID.randomUUID()));

    // Assert
    verify(defaultNotifications, atLeast(1)).create(isA(TenantId.class),
        Mockito.<DefaultNotifications.DefaultNotification>any(), isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testUpdateDefaultNotificationConfigs_givenArrayListAddNotificationTarget() {
    // Arrange
    ArrayList<NotificationTarget> notificationTargetList = new ArrayList<>();
    notificationTargetList.add(new NotificationTarget());
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(Mockito.<TenantId>any(),
        Mockito.<UsersFilterType>any())).thenReturn(notificationTargetList);
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTemplateService, atLeast(1)).countNotificationTemplatesByTenantIdAndNotificationTypes(
        isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>Given {@link DefaultNotifications}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testUpdateDefaultNotificationConfigs_givenDefaultNotifications() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(Mockito.<TenantId>any(),
        Mockito.<UsersFilterType>any())).thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
    verify(notificationTemplateService, atLeast(1)).countNotificationTemplatesByTenantIdAndNotificationTypes(
        isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testUpdateDefaultNotificationConfigs_thenCallsCreate() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(Mockito.<TenantId>any(),
        Mockito.<UsersFilterType>any())).thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(-1);
    doNothing().when(defaultNotifications)
        .create(Mockito.<TenantId>any(), Mockito.<DefaultNotifications.DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(defaultNotifications, atLeast(1)).create(isA(TenantId.class),
        Mockito.<DefaultNotifications.DefaultNotification>any(), isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
    verify(notificationTemplateService, atLeast(1)).countNotificationTemplatesByTenantIdAndNotificationTypes(
        isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }

  /**
   * Test
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  public void testUpdateDefaultNotificationConfigs_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(Mockito.<TenantId>any(),
        Mockito.<UsersFilterType>any())).thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenThrow(new IllegalArgumentException("System administrators"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.updateDefaultNotificationConfigs(ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1)).saveNotificationTarget(isA(TenantId.class),
        Mockito.<NotificationTarget>any());
    verify(notificationTemplateService).countNotificationTemplatesByTenantIdAndNotificationTypes(isA(TenantId.class),
        isA(List.class));
  }
}
