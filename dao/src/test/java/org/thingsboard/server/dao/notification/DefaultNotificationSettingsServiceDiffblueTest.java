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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
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
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsService;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {DefaultNotificationSettingsService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationSettingsServiceDiffblueTest {
  @MockBean private AdminSettingsService adminSettingsService;

  @Autowired private DefaultNotificationSettingsService defaultNotificationSettingsService;

  @MockBean private DefaultNotifications defaultNotifications;

  @MockBean private NotificationTargetService notificationTargetService;

  @MockBean private NotificationTemplateService notificationTemplateService;

  @MockBean private UserSettingsService userSettingsService;

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    defaultNotificationSettingsService.saveNotificationSettings(
        ModelConstants.SYSTEM_TENANT, settings);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveNotificationSettings(
                ModelConstants.SYSTEM_TENANT, settings));
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings3() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    defaultNotificationSettingsService.saveNotificationSettings(
        ModelConstants.SYSTEM_TENANT, settings);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link TenantId#isSysTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings_givenFalse_thenCallsIsSysTenantId() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new IllegalArgumentException())
        .when(adminSettings)
        .setJsonValue(Mockito.<JsonNode>any());
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.saveNotificationSettings(tenantId, settings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(tenantId).isSysTenantId();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings_thenCallsFindAdminSettingsByTenantIdAndKey() {
    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao2);
    JpaNotificationTemplateDao notificationTemplateDao2 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService templateService =
        new DefaultNotificationTemplateService(notificationTemplateDao2, notificationRequestDao3);
    JpaNotificationRuleDao notificationRuleDao2 =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService ruleService =
        new DefaultNotificationRuleService(notificationRuleDao2);

    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, ruleService);

    DefaultNotificationSettingsService defaultNotificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService,
            notificationTemplateService,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    // Act
    defaultNotificationSettingsService.saveNotificationSettings(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveNotificationSettings(TenantId,
   * NotificationSettings)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#setJsonValue(JsonNode)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveNotificationSettings(TenantId, NotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.saveNotificationSettings(TenantId, NotificationSettings)"
  })
  public void testSaveNotificationSettings_thenCallsSetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new IllegalArgumentException())
        .when(adminSettings)
        .setJsonValue(Mockito.<JsonNode>any());
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveNotificationSettings(
                ModelConstants.SYSTEM_TENANT, settings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    NotificationSettings actualFindNotificationSettingsResult =
        defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.findNotificationSettings(
                ModelConstants.SYSTEM_TENANT));
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings3() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    NotificationSettings actualFindNotificationSettingsResult =
        defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings4() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new IllegalArgumentException());
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.findNotificationSettings(
                ModelConstants.SYSTEM_TENANT));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings_givenArrayNodeAsTokenReturnEndArray() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);

    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult =
        defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings_givenArrayNodeAsTokenReturnEndObject() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);

    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult =
        defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertTrue(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs().isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings_givenArrayNodeAsTokenThrowIllegalArgumentException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenThrow(new IllegalArgumentException());

    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.findNotificationSettings(
                ModelConstants.SYSTEM_TENANT));
    verify(arrayNode).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#fields()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings_givenArrayNodeFieldsThrowIllegalArgumentException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.fields()).thenThrow(new IllegalArgumentException());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);

    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.findNotificationSettings(
                ModelConstants.SYSTEM_TENANT));
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#findNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Then return DeliveryMethodsConfigs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#findNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationSettings DefaultNotificationSettingsService.findNotificationSettings(TenantId)"
  })
  public void testFindNotificationSettings_thenReturnDeliveryMethodsConfigsIsNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);

    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    NotificationSettings actualFindNotificationSettingsResult =
        defaultNotificationSettingsService.findNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
    assertNull(actualFindNotificationSettingsResult.getDeliveryMethodsConfigs());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.deleteNotificationSettings(TenantId)"
  })
  public void testDeleteNotificationSettings() {
    // Arrange
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    defaultNotificationSettingsService.deleteNotificationSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsService)
        .deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#deleteNotificationSettings(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.deleteNotificationSettings(TenantId)"
  })
  public void testDeleteNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.deleteNotificationSettings(
                ModelConstants.SYSTEM_TENANT));
    verify(adminSettingsService)
        .deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("notifications"));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_givenNotificationPrefEnabledIsFalse() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IllegalArgumentException());

    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    NotificationPref notificationPref2 = new NotificationPref();
    notificationPref2.setEnabled(false);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.ALARM, notificationPref2);
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, new UserNotificationSettings(prefs)));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_givenNotificationPrefEnabledIsTrue() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IllegalArgumentException());

    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, new UserNotificationSettings(prefs)));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>Then return Prefs size is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_thenReturnPrefsSizeIsFifteen()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult =
        defaultNotificationSettingsService.saveUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, UserNotificationSettings.DEFAULT);

    // Assert
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, NotificationPref> prefs =
        actualSaveUserNotificationSettingsResult.getPrefs();
    assertEquals(15, prefs.size());
    assertTrue(prefs.containsKey(NotificationType.GENERAL));
    NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>Then return Prefs size is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_thenReturnPrefsSizeIsFifteen2()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult =
        defaultNotificationSettingsService.saveUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, null);

    // Assert
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
    Map<NotificationType, NotificationPref> prefs =
        actualSaveUserNotificationSettingsResult.getPrefs();
    assertEquals(15, prefs.size());
    assertTrue(prefs.containsKey(NotificationType.GENERAL));
    NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, null));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>When {@link UserNotificationSettings#DEFAULT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_whenDefault_thenThrowIllegalArgumentException() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, UserNotificationSettings.DEFAULT));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}.
   *
   * <ul>
   *   <li>When {@link UserNotificationSettings#UserNotificationSettings(Map)} with prefs is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#saveUserNotificationSettings(TenantId, UserId,
   * UserNotificationSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.saveUserNotificationSettings(TenantId, UserId, UserNotificationSettings)"
  })
  public void testSaveUserNotificationSettings_whenUserNotificationSettingsWithPrefsIsHashMap() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.saveUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, new UserNotificationSettings(new HashMap<>())));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings =
        defaultNotificationSettingsService.getUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods =
        getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) SettingsBytes is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings_givenUserSettingsSettingsBytesIsEmptyArrayOfByte() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings =
        defaultNotificationSettingsService.getUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods =
        getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) SettingsBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings_givenUserSettingsSettingsBytesIsNull() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(null);
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings =
        defaultNotificationSettingsService.getUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, true);

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    Map<NotificationType, NotificationPref> prefs = actualUserNotificationSettings.getPrefs();
    assertEquals(15, prefs.size());
    NotificationPref getResult = prefs.get(NotificationType.GENERAL);
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods =
        getResult.getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(getResult.isEnabled());
    assertSame(getResult, prefs.get(NotificationType.ALARM));
    assertSame(getResult, prefs.get(NotificationType.ALARM_COMMENT));
    assertSame(getResult, prefs.get(NotificationType.DEVICE_ACTIVITY));
    assertSame(getResult, prefs.get(NotificationType.ENTITY_ACTION));
    assertSame(getResult, prefs.get(NotificationType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return Prefs Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings_thenReturnPrefsEmpty()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings =
        defaultNotificationSettingsService.getUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, false);

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    assertTrue(actualUserNotificationSettings.getPrefs().isEmpty());
    assertSame(UserNotificationSettings.DEFAULT, actualUserNotificationSettings);
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return Prefs Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings_thenReturnPrefsEmpty2() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    UserNotificationSettings actualUserNotificationSettings =
        defaultNotificationSettingsService.getUserNotificationSettings(
            ModelConstants.SYSTEM_TENANT, null, false);

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
    assertTrue(actualUserNotificationSettings.getPrefs().isEmpty());
    assertSame(UserNotificationSettings.DEFAULT, actualUserNotificationSettings);
  }

  /**
   * Test {@link DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#getUserNotificationSettings(TenantId, UserId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings DefaultNotificationSettingsService.getUserNotificationSettings(TenantId, UserId, boolean)"
  })
  public void testGetUserNotificationSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.getUserNotificationSettings(
                ModelConstants.SYSTEM_TENANT, null, true));
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.NOTIFICATIONS));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.createDefaultNotificationConfigs(TenantId)"
  })
  public void testCreateDefaultNotificationConfigs() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.createDefaultNotificationConfigs(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetService)
        .saveNotificationTarget(isA(TenantId.class), isA(NotificationTarget.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.createDefaultNotificationConfigs(TenantId)"
  })
  public void testCreateDefaultNotificationConfigs2() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doThrow(new IllegalArgumentException())
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.createDefaultNotificationConfigs(
                ModelConstants.SYSTEM_TENANT));
    verify(defaultNotifications)
        .create(
            isA(TenantId.class), isA(DefaultNotification.class), isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link TenantId#isSysTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.createDefaultNotificationConfigs(TenantId)"
  })
  public void testCreateDefaultNotificationConfigs_givenFalse_thenCallsIsSysTenantId() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doNothing()
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    defaultNotificationSettingsService.createDefaultNotificationConfigs(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).isSysTenantId();
    verify(defaultNotifications, atLeast(1))
        .create(
            isA(TenantId.class),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultNotifications#create(TenantId, DefaultNotification,
   *       NotificationTargetId[])}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#createDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.createDefaultNotificationConfigs(TenantId)"
  })
  public void testCreateDefaultNotificationConfigs_thenCallsCreate() {
    // Arrange
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    doNothing()
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act
    defaultNotificationSettingsService.createDefaultNotificationConfigs(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(defaultNotifications, atLeast(1))
        .create(
            isA(TenantId.class),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.updateDefaultNotificationConfigs(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetService)
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), eq(UsersFilterType.SYSTEM_ADMINISTRATORS));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs2() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.updateDefaultNotificationConfigs(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
    verify(notificationTemplateService)
        .countNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs3() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(-1);
    doNothing()
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(defaultNotifications, atLeast(1))
        .create(
            isA(TenantId.class),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
    verify(notificationTemplateService, atLeast(1))
        .countNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs4() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(-1);
    doThrow(new IllegalArgumentException())
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationSettingsService.updateDefaultNotificationConfigs(
                ModelConstants.SYSTEM_TENANT));
    verify(defaultNotifications)
        .create(
            isA(TenantId.class), isA(DefaultNotification.class), isA(NotificationTargetId[].class));
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
    verify(notificationTemplateService)
        .countNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs5() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    doNothing()
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(tenantId);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(defaultNotifications, atLeast(1))
        .create(
            isA(TenantId.class),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    verify(notificationTargetService)
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), eq(UsersFilterType.TENANT_ADMINISTRATORS));
    verify(notificationTargetService)
        .saveNotificationTarget(isA(TenantId.class), isA(NotificationTarget.class));
    verify(notificationTemplateService)
        .findNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs_givenArrayListAddNotificationTarget() {
    // Arrange
    ArrayList<NotificationTarget> notificationTargetList = new ArrayList<>();
    notificationTargetList.add(new NotificationTarget());
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(notificationTargetList);
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTemplateService, atLeast(1))
        .countNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs_givenArrayListAddNotificationTarget2() {
    // Arrange
    ArrayList<NotificationTarget> notificationTargetList = new ArrayList<>();
    notificationTargetList.add(new NotificationTarget());
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(notificationTargetList);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    doNothing()
        .when(defaultNotifications)
        .create(
            Mockito.<TenantId>any(),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(tenantId);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(defaultNotifications, atLeast(1))
        .create(
            isA(TenantId.class),
            Mockito.<DefaultNotification>any(),
            isA(NotificationTargetId[].class));
    verify(notificationTargetService)
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), eq(UsersFilterType.TENANT_ADMINISTRATORS));
    verify(notificationTemplateService)
        .findNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetService}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs_givenNotificationTargetService() {
    // Arrange
    when(notificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.updateDefaultNotificationConfigs(tenantId));
    verify(tenantId).isSysTenantId();
    verify(notificationTemplateService)
        .findNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTarget#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs_thenCallsGetId() {
    // Arrange
    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getId()).thenThrow(new IllegalArgumentException());

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getId()).thenReturn(notificationTargetId);

    DefaultNotificationTargetService notificationTargetService =
        mock(DefaultNotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(notificationTarget);

    DefaultNotificationTemplateService notificationTemplateService =
        mock(DefaultNotificationTemplateService.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    NotificationTemplateService templateService = mock(NotificationTemplateService.class);
    when(templateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService ruleService =
        new DefaultNotificationRuleService(notificationRuleDao);

    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, ruleService);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultNotificationSettingsService defaultNotificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService,
            notificationTemplateService,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationSettingsService.updateDefaultNotificationConfigs(tenantId));
    verify(notificationTarget).getId();
    verify(tenantId).isSysTenantId();
    verify(notificationTargetId).getId();
    verify(notificationTargetService)
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), eq(UsersFilterType.TENANT_ADMINISTRATORS));
    verify(notificationTargetService)
        .saveNotificationTarget(isA(TenantId.class), isA(NotificationTarget.class));
    verify(notificationTemplateService)
        .findNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
    verify(templateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetService#saveNotificationTarget(TenantId,
   *       NotificationTarget)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationSettingsService#updateDefaultNotificationConfigs(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationSettingsService.updateDefaultNotificationConfigs(TenantId)"
  })
  public void testUpdateDefaultNotificationConfigs_thenCallsSaveNotificationTarget() {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());
    when(notificationTargetService.saveNotificationTarget(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());
    when(notificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    // Act
    defaultNotificationSettingsService.updateDefaultNotificationConfigs(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetsByTenantIdAndUsersFilterType(
            isA(TenantId.class), Mockito.<UsersFilterType>any());
    verify(notificationTargetService, atLeast(1))
        .saveNotificationTarget(isA(TenantId.class), Mockito.<NotificationTarget>any());
    verify(notificationTemplateService, atLeast(1))
        .countNotificationTemplatesByTenantIdAndNotificationTypes(
            isA(TenantId.class), Mockito.<List<NotificationType>>any());
  }
}
