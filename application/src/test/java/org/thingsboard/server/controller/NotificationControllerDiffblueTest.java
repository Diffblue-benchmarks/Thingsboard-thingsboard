package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.NotificationCenter;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestInfo;
import org.thingsboard.server.common.data.notification.settings.UserNotificationSettings;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.NotificationRequestService;
import org.thingsboard.server.dao.notification.NotificationService;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTemplateService;
import org.thingsboard.server.service.security.model.SecurityUser;

class NotificationControllerDiffblueTest {
  /**
   * Test
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotifications_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), anyBoolean(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<Notification> actualNotifications = notificationController.getNotifications(3, 1, "Text Search", "U",
        "asc", true, NotificationDeliveryMethod.WEB, new SecurityUser());

    // Assert
    verify(notificationService).findNotificationsByRecipientIdAndReadStatus(isNull(),
        eq(NotificationDeliveryMethod.WEB), isNull(), eq(true), isA(PageLink.class));
    assertSame(actualNotifications.EMPTY_PAGE_DATA, actualNotifications);
  }

  /**
   * Test
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); then throw IllegalArgumentException")
  void testGetNotifications_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), anyBoolean(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("U"));
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationController.getNotifications(3, 1, "Text Search", "U",
        "asc", true, NotificationDeliveryMethod.WEB, new SecurityUser()));
    verify(notificationService).findNotificationsByRecipientIdAndReadStatus(isNull(),
        eq(NotificationDeliveryMethod.WEB), isNull(), eq(true), isA(PageLink.class));
  }

  /**
   * Test
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotifications_whenEmptyString_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), anyBoolean(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<Notification> actualNotifications = notificationController.getNotifications(3, 1, "Text Search", "", "asc",
        true, NotificationDeliveryMethod.WEB, new SecurityUser());

    // Assert
    verify(notificationService).findNotificationsByRecipientIdAndReadStatus(isNull(),
        eq(NotificationDeliveryMethod.WEB), isNull(), eq(true), isA(PageLink.class));
    assertSame(actualNotifications.EMPTY_PAGE_DATA, actualNotifications);
  }

  /**
   * Test
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotifications_whenEmptyString_thenReturnEmpty_page_data2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), anyBoolean(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<Notification> actualNotifications = notificationController.getNotifications(3, 1, "Text Search", "U", "",
        true, NotificationDeliveryMethod.WEB, new SecurityUser());

    // Assert
    verify(notificationService).findNotificationsByRecipientIdAndReadStatus(isNull(),
        eq(NotificationDeliveryMethod.WEB), isNull(), eq(true), isA(PageLink.class));
    assertSame(actualNotifications.EMPTY_PAGE_DATA, actualNotifications);
  }

  /**
   * Test
   * {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser); then return intValue is one")
  void testGetUnreadNotificationsCount_thenReturnIntValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    when(notificationService.countUnreadNotificationsByRecipientId(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any())).thenReturn(1);
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    Integer actualUnreadNotificationsCount = notificationController
        .getUnreadNotificationsCount(NotificationDeliveryMethod.WEB, new SecurityUser());

    // Assert
    verify(notificationService).countUnreadNotificationsByRecipientId(isNull(), eq(NotificationDeliveryMethod.WEB),
        isNull());
    assertEquals(1, actualUnreadNotificationsCount.intValue());
  }

  /**
   * Test
   * {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser); then throw IllegalArgumentException")
  void testGetUnreadNotificationsCount_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationService notificationService = mock(NotificationService.class);
    when(notificationService.countUnreadNotificationsByRecipientId(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NotificationController notificationController = new NotificationController(notificationService,
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getUnreadNotificationsCount(NotificationDeliveryMethod.WEB, new SecurityUser()));
    verify(notificationService).countUnreadNotificationsByRecipientId(isNull(), eq(NotificationDeliveryMethod.WEB),
        isNull());
  }

  /**
   * Test
   * {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#markNotificationAsRead(TenantId, UserId, NotificationId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test markNotificationAsRead(UUID, SecurityUser); then calls markNotificationAsRead(TenantId, UserId, NotificationId)")
  void testMarkNotificationAsRead_thenCallsMarkNotificationAsRead() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .markNotificationAsRead(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));
    UUID id = UUID.randomUUID();

    // Act
    notificationController.markNotificationAsRead(id, new SecurityUser());

    // Assert
    verify(notificationCenter).markNotificationAsRead(isNull(), isNull(), isA(NotificationId.class));
  }

  /**
   * Test
   * {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test markNotificationAsRead(UUID, SecurityUser); then throw IllegalArgumentException")
  void testMarkNotificationAsRead_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doThrow(new IllegalArgumentException("foo")).when(notificationCenter)
        .markNotificationAsRead(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.markNotificationAsRead(id, new SecurityUser()));
    verify(notificationCenter).markNotificationAsRead(isNull(), isNull(), isA(NotificationId.class));
  }

  /**
   * Test
   * {@link NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser); then calls markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)")
  void testMarkAllNotificationsAsRead_thenCallsMarkAllNotificationsAsRead() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .markAllNotificationsAsRead(Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));

    // Act
    notificationController.markAllNotificationsAsRead(NotificationDeliveryMethod.WEB, new SecurityUser());

    // Assert
    verify(notificationCenter).markAllNotificationsAsRead(isNull(), eq(NotificationDeliveryMethod.WEB), isNull());
  }

  /**
   * Test
   * {@link NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName("Test markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser); then throw IllegalArgumentException")
  void testMarkAllNotificationsAsRead_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doThrow(new IllegalArgumentException("foo")).when(notificationCenter)
        .markAllNotificationsAsRead(Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.markAllNotificationsAsRead(NotificationDeliveryMethod.WEB, new SecurityUser()));
    verify(notificationCenter).markAllNotificationsAsRead(isNull(), eq(NotificationDeliveryMethod.WEB), isNull());
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationCenter#deleteNotification(TenantId, UserId, NotificationId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser); then calls deleteNotification(TenantId, UserId, NotificationId)")
  void testDeleteNotification_thenCallsDeleteNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doNothing().when(notificationCenter)
        .deleteNotification(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));
    UUID id = UUID.randomUUID();

    // Act
    notificationController.deleteNotification(id, new SecurityUser());

    // Assert
    verify(notificationCenter).deleteNotification(isNull(), isNull(), isA(NotificationId.class));
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser); then throw IllegalArgumentException")
  void testDeleteNotification_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    doThrow(new IllegalArgumentException("foo")).when(notificationCenter)
        .deleteNotification(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<NotificationId>any());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.deleteNotification(id, new SecurityUser()));
    verify(notificationCenter).deleteNotification(isNull(), isNull(), isA(NotificationId.class));
  }

  /**
   * Test
   * {@link NotificationController#createNotificationRequest(NotificationRequest, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#createNotificationRequest(NotificationRequest, SecurityUser)}
   */
  @Test
  @DisplayName("Test createNotificationRequest(NotificationRequest, SecurityUser); then throw IllegalArgumentException")
  void testCreateNotificationRequest_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setId(new NotificationRequestId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.createNotificationRequest(notificationRequest, new SecurityUser()));
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}.
   * <ul>
   *   <li>Then calls {@link NotificationTarget#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); then calls getName()")
  void testGetNotificationRequestPreview_thenCallsGetName() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getName()).thenThrow(new IllegalArgumentException("foo"));
    when(notificationTarget.getConfiguration()).thenReturn(new MicrosoftTeamsNotificationTargetConfig());
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetById(Mockito.<TenantId>any(),
        Mockito.<NotificationTargetId>any())).thenReturn(notificationTarget);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class), notificationTargetService,
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).getName();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(notificationTargetService).findNotificationTargetById(isNull(), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}.
   * <ul>
   *   <li>Then calls
   * {@link MicrosoftTeamsNotificationTargetConfig#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); then calls getTitle()")
  void testGetNotificationRequestPreview_thenCallsGetTitle() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MicrosoftTeamsNotificationTargetConfig configuration = mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(configuration.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = mock(
        MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig.getTitle()).thenThrow(new IllegalArgumentException("foo"));
    when(microsoftTeamsNotificationTargetConfig.getType()).thenReturn(NotificationTargetType.MICROSOFT_TEAMS);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(microsoftTeamsNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(configuration);
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetById(Mockito.<TenantId>any(),
        Mockito.<NotificationTargetId>any())).thenReturn(notificationTarget);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class), notificationTargetService,
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(microsoftTeamsNotificationTargetConfig).getTitle();
    verify(microsoftTeamsNotificationTargetConfig).getType();
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(notificationTargetService).findNotificationTargetById(isNull(), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}.
   * <ul>
   *   <li>Then calls
   * {@link MicrosoftTeamsNotificationTargetConfig#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); then calls getTitle()")
  void testGetNotificationRequestPreview_thenCallsGetTitle2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MicrosoftTeamsNotificationTargetConfig configuration = mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(configuration.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);
    MicrosoftTeamsNotificationTargetConfig microsoftTeamsNotificationTargetConfig = mock(
        MicrosoftTeamsNotificationTargetConfig.class);
    when(microsoftTeamsNotificationTargetConfig.getTitle()).thenThrow(new IllegalArgumentException("foo"));
    when(microsoftTeamsNotificationTargetConfig.getType()).thenReturn(NotificationTargetType.MICROSOFT_TEAMS);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(microsoftTeamsNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(configuration);
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetById(Mockito.<TenantId>any(),
        Mockito.<NotificationTargetId>any())).thenReturn(notificationTarget);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class), notificationTargetService,
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(microsoftTeamsNotificationTargetConfig).getTitle();
    verify(microsoftTeamsNotificationTargetConfig, atLeast(1)).getType();
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(notificationTargetService, atLeast(1)).findNotificationTargetById(isNull(),
        Mockito.<NotificationTargetId>any());
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}.
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); when NotificationRequest()")
  void testGetNotificationRequestPreview_whenNotificationRequest() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), mock(NotificationSettingsService.class));
    NotificationRequest request = new NotificationRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequests(int, int, String, String, String, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationRequests_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestService notificationRequestService = mock(NotificationRequestService.class);
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        notificationRequestService, mock(NotificationTemplateService.class), mock(NotificationTargetService.class),
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<NotificationRequestInfo> actualNotificationRequests = notificationController.getNotificationRequests(3, 1,
        "Text Search", "U", "asc", new SecurityUser());

    // Assert
    verify(notificationRequestService).findNotificationRequestsInfosByTenantIdAndOriginatorType(isNull(),
        eq(EntityType.USER), isA(PageLink.class));
    assertSame(actualNotificationRequests.EMPTY_PAGE_DATA, actualNotificationRequests);
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequests(int, int, String, String, String, SecurityUser); then throw IllegalArgumentException")
  void testGetNotificationRequests_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestService notificationRequestService = mock(NotificationRequestService.class);
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("U"));
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        notificationRequestService, mock(NotificationTemplateService.class), mock(NotificationTargetService.class),
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getNotificationRequests(3, 1, "Text Search", "U", "asc", new SecurityUser()));
    verify(notificationRequestService).findNotificationRequestsInfosByTenantIdAndOriginatorType(isNull(),
        eq(EntityType.USER), isA(PageLink.class));
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequests(int, int, String, String, String, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotificationRequests_whenEmptyString_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestService notificationRequestService = mock(NotificationRequestService.class);
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        notificationRequestService, mock(NotificationTemplateService.class), mock(NotificationTargetService.class),
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<NotificationRequestInfo> actualNotificationRequests = notificationController.getNotificationRequests(3, 1,
        "Text Search", "", "asc", new SecurityUser());

    // Assert
    verify(notificationRequestService).findNotificationRequestsInfosByTenantIdAndOriginatorType(isNull(),
        eq(EntityType.USER), isA(PageLink.class));
    assertSame(actualNotificationRequests.EMPTY_PAGE_DATA, actualNotificationRequests);
  }

  /**
   * Test
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getNotificationRequests(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequests(int, int, String, String, String, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotificationRequests_whenEmptyString_thenReturnEmpty_page_data2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestService notificationRequestService = mock(NotificationRequestService.class);
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(Mockito.<TenantId>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        notificationRequestService, mock(NotificationTemplateService.class), mock(NotificationTargetService.class),
        mock(NotificationCenter.class), mock(NotificationSettingsService.class));

    // Act
    PageData<NotificationRequestInfo> actualNotificationRequests = notificationController.getNotificationRequests(3, 1,
        "Text Search", "U", "", new SecurityUser());

    // Assert
    verify(notificationRequestService).findNotificationRequestsInfosByTenantIdAndOriginatorType(isNull(),
        eq(EntityType.USER), isA(PageLink.class));
    assertSame(actualNotificationRequests.EMPTY_PAGE_DATA, actualNotificationRequests);
  }

  /**
   * Test
   * {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}
   */
  @Test
  @DisplayName("Test getAvailableDeliveryMethods(SecurityUser); then return Empty")
  void testGetAvailableDeliveryMethods_thenReturnEmpty() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    when(notificationCenter.getAvailableDeliveryMethods(Mockito.<TenantId>any())).thenReturn(new HashSet<>());
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));

    // Act
    Set<NotificationDeliveryMethod> actualAvailableDeliveryMethods = notificationController
        .getAvailableDeliveryMethods(new SecurityUser());

    // Assert
    verify(notificationCenter).getAvailableDeliveryMethods(isNull());
    assertTrue(actualAvailableDeliveryMethods.isEmpty());
  }

  /**
   * Test
   * {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}
   */
  @Test
  @DisplayName("Test getAvailableDeliveryMethods(SecurityUser); then throw IllegalArgumentException")
  void testGetAvailableDeliveryMethods_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationCenter notificationCenter = mock(NotificationCenter.class);
    when(notificationCenter.getAvailableDeliveryMethods(Mockito.<TenantId>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), notificationCenter, mock(NotificationSettingsService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getAvailableDeliveryMethods(new SecurityUser()));
    verify(notificationCenter).getAvailableDeliveryMethods(isNull());
  }

  /**
   * Test
   * {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}.
   * <ul>
   *   <li>Then return Prefs Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}
   */
  @Test
  @DisplayName("Test saveUserNotificationSettings(UserNotificationSettings, SecurityUser); then return Prefs Empty")
  void testSaveUserNotificationSettings_thenReturnPrefsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    UserNotificationSettings userNotificationSettings = new UserNotificationSettings(new HashMap<>());
    when(notificationSettingsService.saveUserNotificationSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserNotificationSettings>any())).thenReturn(userNotificationSettings);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), notificationSettingsService);
    UserNotificationSettings settings = new UserNotificationSettings(new HashMap<>());

    // Act
    UserNotificationSettings actualSaveUserNotificationSettingsResult = notificationController
        .saveUserNotificationSettings(settings, new SecurityUser());

    // Assert
    verify(notificationSettingsService).saveUserNotificationSettings(isNull(), isNull(),
        isA(UserNotificationSettings.class));
    assertTrue(actualSaveUserNotificationSettingsResult.getPrefs().isEmpty());
    assertSame(userNotificationSettings, actualSaveUserNotificationSettingsResult);
  }

  /**
   * Test
   * {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}
   */
  @Test
  @DisplayName("Test saveUserNotificationSettings(UserNotificationSettings, SecurityUser); then throw IllegalArgumentException")
  void testSaveUserNotificationSettings_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    when(notificationSettingsService.saveUserNotificationSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserNotificationSettings>any())).thenThrow(new IllegalArgumentException("foo"));
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), notificationSettingsService);
    UserNotificationSettings settings = new UserNotificationSettings(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.saveUserNotificationSettings(settings, new SecurityUser()));
    verify(notificationSettingsService).saveUserNotificationSettings(isNull(), isNull(),
        isA(UserNotificationSettings.class));
  }

  /**
   * Test
   * {@link NotificationController#getUserNotificationSettings(SecurityUser)}.
   * <ul>
   *   <li>Then return Prefs Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getUserNotificationSettings(SecurityUser)}
   */
  @Test
  @DisplayName("Test getUserNotificationSettings(SecurityUser); then return Prefs Empty")
  void testGetUserNotificationSettings_thenReturnPrefsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    UserNotificationSettings userNotificationSettings = new UserNotificationSettings(new HashMap<>());
    when(notificationSettingsService.getUserNotificationSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        anyBoolean())).thenReturn(userNotificationSettings);
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), notificationSettingsService);

    // Act
    UserNotificationSettings actualUserNotificationSettings = notificationController
        .getUserNotificationSettings(new SecurityUser());

    // Assert
    verify(notificationSettingsService).getUserNotificationSettings(isNull(), isNull(), eq(true));
    assertTrue(actualUserNotificationSettings.getPrefs().isEmpty());
    assertSame(userNotificationSettings, actualUserNotificationSettings);
  }

  /**
   * Test
   * {@link NotificationController#getUserNotificationSettings(SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationController#getUserNotificationSettings(SecurityUser)}
   */
  @Test
  @DisplayName("Test getUserNotificationSettings(SecurityUser); then throw IllegalArgumentException")
  void testGetUserNotificationSettings_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    when(notificationSettingsService.getUserNotificationSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        anyBoolean())).thenThrow(new IllegalArgumentException("foo"));
    NotificationController notificationController = new NotificationController(mock(NotificationService.class),
        mock(NotificationRequestService.class), mock(NotificationTemplateService.class),
        mock(NotificationTargetService.class), mock(NotificationCenter.class), notificationSettingsService);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationController.getUserNotificationSettings(new SecurityUser()));
    verify(notificationSettingsService).getUserNotificationSettings(isNull(), isNull(), eq(true));
  }
}
