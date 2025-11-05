package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.rule.engine.api.NotificationCenter;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
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
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.NotificationRequestService;
import org.thingsboard.server.dao.notification.NotificationService;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTemplateService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class NotificationControllerDiffblueTest {
  @Mock private NotificationCenter notificationCenter;

  @InjectMocks private NotificationController notificationController;

  @Mock private NotificationRequestService notificationRequestService;

  @Mock private NotificationService notificationService;

  @Mock private NotificationSettingsService notificationSettingsService;

  @Mock private NotificationTargetService notificationTargetService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationController#getNotifications(int, int, String, String, String, boolean,
   * NotificationDeliveryMethod, SecurityUser)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Media Types}.
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotifications(int, int, String, String,
   * String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); given array of String with 'Media Types'; then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)"
  })
  void testGetNotifications_givenArrayOfStringWithMediaTypes_thenStatusFourHundredSix()
      throws Exception {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any(),
            anyBoolean(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/notifications");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult
            .param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB))
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("unreadOnly", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#getNotifications(int, int, String, String, String, boolean,
   * NotificationDeliveryMethod, SecurityUser)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotifications(int, int, String, String,
   * String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); when 'foo'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)"
  })
  void testGetNotifications_whenFoo_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any(),
            anyBoolean(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notifications")
            .param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB))
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("unreadOnly", String.valueOf(true))
            .param("sortProperty", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationController#getNotifications(int, int, String, String, String, boolean,
   * NotificationDeliveryMethod, SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/notifications}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotifications(int, int, String, String,
   * String, boolean, NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser); when get(String, Object[]) '/api/notifications'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotifications(int, int, String, String, String, boolean, NotificationDeliveryMethod, SecurityUser)"
  })
  void testGetNotifications_whenGetApiNotifications_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationService.findNotificationsByRecipientIdAndReadStatus(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any(),
            anyBoolean(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notifications")
            .param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB))
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("unreadOnly", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer NotificationController.getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)"
  })
  void testGetUnreadNotificationsCount_thenStatusFourHundredSix() throws Exception {
    // Arrange
    when(notificationService.countUnreadNotificationsByRecipientId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any()))
        .thenReturn(1);

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notifications/unread/count");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer NotificationController.getUnreadNotificationsCount(NotificationDeliveryMethod, SecurityUser)"
  })
  void testGetUnreadNotificationsCount_thenStatusIsOk() throws Exception {
    // Arrange
    when(notificationService.countUnreadNotificationsByRecipientId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any()))
        .thenReturn(1);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notifications/unread/count")
            .param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("1"));
  }

  /**
   * Test {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test markNotificationAsRead(UUID, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.markNotificationAsRead(UUID, SecurityUser)"})
  void testMarkNotificationAsRead() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/api/notification/{id}/read", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test markNotificationAsRead(UUID, SecurityUser); when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.markNotificationAsRead(UUID, SecurityUser)"})
  void testMarkNotificationAsRead_whenFromString784f394c42b6435a983cB7beff2784f9()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put(
            "/api/notification/{id}/read", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When valueOf {@code WEB}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser); when valueOf 'WEB'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationController.markAllNotificationsAsRead(NotificationDeliveryMethod, SecurityUser)"
  })
  void testMarkAllNotificationsAsRead_whenValueOfWeb_thenStatusIsOk() throws Exception {
    // Arrange
    doNothing()
        .when(notificationCenter)
        .markAllNotificationsAsRead(
            Mockito.<TenantId>any(),
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UserId>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/api/notifications/read")
            .param("deliveryMethod", String.valueOf(NotificationDeliveryMethod.WEB));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.deleteNotification(UUID, SecurityUser)"})
  void testDeleteNotification() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/{id}", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.deleteNotification(UUID, SecurityUser)"})
  void testDeleteNotification2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/notification/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.deleteNotification(UUID, SecurityUser)"})
  void testDeleteNotification_givenTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/{id}", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    requestBuilder.secure(true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#createNotificationRequest(NotificationRequest,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#createNotificationRequest(NotificationRequest, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test createNotificationRequest(NotificationRequest, SecurityUser); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequest NotificationController.createNotificationRequest(NotificationRequest, SecurityUser)"
  })
  void testCreateNotificationRequest_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    NotificationRequest notificationRequest = new NotificationRequest(new NotificationRequest());
    notificationRequest.setId(
        new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            notificationController.createNotificationRequest(
                notificationRequest, new SecurityUser()));
  }

  /**
   * Test {@link NotificationController#createNotificationRequest(NotificationRequest,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#createNotificationRequest(NotificationRequest, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test createNotificationRequest(NotificationRequest, SecurityUser); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequest NotificationController.createNotificationRequest(NotificationRequest, SecurityUser)"
  })
  void testCreateNotificationRequest_thenThrowThingsboardException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));
    NotificationRequest notificationRequest = new NotificationRequest();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationController.createNotificationRequest(
                notificationRequest, new SecurityUser()));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request, atLeast(1)).getTemplateId();
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetById(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException());
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            notificationTargetService,
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(notificationTargetService)
        .findNotificationTargetById(isNull(), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview_givenIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    NotificationRequest request = mock(NotificationRequest.class);
    doThrow(new IllegalArgumentException())
        .when(request)
        .setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTemplateId#NotificationTemplateId(UUID)} with id is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); given NotificationTemplateId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview_givenNotificationTemplateIdWithIdIsNull()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(null));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request, atLeast(1)).getTemplateId();
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTarget#getConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); then calls getConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview_thenCallsGetConfiguration() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getName()).thenThrow(new IllegalArgumentException());
    when(notificationTarget.getConfiguration())
        .thenReturn(new MicrosoftTeamsNotificationTargetConfig());
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));
    when(notificationTargetService.findNotificationTargetById(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(notificationTarget);

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).getName();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(notificationTargetService)
        .findNotificationTargetById(isNull(), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then calls {@link MicrosoftTeamsNotificationTargetConfig#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview_thenCallsGetType() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MicrosoftTeamsNotificationTargetConfig configuration =
        mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(configuration.getType()).thenThrow(new IllegalArgumentException());

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.findNotificationTargetById(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(notificationTarget);
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            notificationTargetService,
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    doNothing().when(request).setOriginatorEntityId(Mockito.<EntityId>any());
    when(request.getTemplateId()).thenReturn(null);
    when(request.getTemplate()).thenReturn(new NotificationTemplate());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
    verify(request).getTargets();
    verify(request).getTemplate();
    verify(request).getTemplateId();
    verify(request).setOriginatorEntityId(isNull());
    verify(configuration).getType();
    verify(notificationTargetService, atLeast(1))
        .findNotificationTargetById(isNull(), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestPreview(NotificationRequest, int,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#getNotificationRequestPreview(NotificationRequest, int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestPreview(NotificationRequest, int, SecurityUser); when NotificationRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestPreview NotificationController.getNotificationRequestPreview(NotificationRequest, int, SecurityUser)"
  })
  void testGetNotificationRequestPreview_whenNotificationRequest() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationController notificationController =
        new NotificationController(
            mock(NotificationService.class),
            mock(NotificationRequestService.class),
            mock(NotificationTemplateService.class),
            mock(NotificationTargetService.class),
            mock(NotificationCenter.class),
            mock(NotificationSettingsService.class));
    NotificationRequest request = new NotificationRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> notificationController.getNotificationRequestPreview(request, 3, new SecurityUser()));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestById(UUID)}.
   *
   * <p>Method under test: {@link NotificationController#getNotificationRequestById(UUID)}
   */
  @Test
  @DisplayName("Test getNotificationRequestById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestInfo NotificationController.getNotificationRequestById(UUID)"
  })
  void testGetNotificationRequestById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/request/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#getNotificationRequests(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotificationRequests(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequests(int, int, String, String, String, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotificationRequests(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRequests_thenStatusFourHundredSix() throws Exception {
    // Arrange
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(
            Mockito.<TenantId>any(), Mockito.<EntityType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notification/requests");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", String.valueOf(1)).param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#getNotificationRequests(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotificationRequests(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequests(int, int, String, String, String, SecurityUser); when 'foo'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotificationRequests(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRequests_whenFoo_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(
            Mockito.<TenantId>any(), Mockito.<EntityType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/requests")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("sortProperty", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationController#getNotificationRequests(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/notification/requests}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getNotificationRequests(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequests(int, int, String, String, String, SecurityUser); when get(String, Object[]) '/api/notification/requests'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationController.getNotificationRequests(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRequests_whenGetApiNotificationRequests_thenStatusIsOk()
      throws Exception {
    // Arrange
    PageData<NotificationRequestInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRequestService.findNotificationRequestsInfosByTenantIdAndOriginatorType(
            Mockito.<TenantId>any(), Mockito.<EntityType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/requests")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationController#deleteNotificationRequest(UUID)}.
   *
   * <p>Method under test: {@link NotificationController#deleteNotificationRequest(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationRequest(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationController.deleteNotificationRequest(UUID)"})
  void testDeleteNotificationRequest() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/notification/request/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}
   */
  @Test
  @DisplayName("Test getAvailableDeliveryMethods(SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set NotificationController.getAvailableDeliveryMethods(SecurityUser)"
  })
  void testGetAvailableDeliveryMethods_thenStatusFourHundredSix() throws Exception {
    // Arrange
    when(notificationCenter.getAvailableDeliveryMethods(Mockito.<TenantId>any()))
        .thenReturn(new HashSet<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/deliveryMethods");
    requestBuilder.accept("Media Types");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getAvailableDeliveryMethods(SecurityUser)}
   */
  @Test
  @DisplayName("Test getAvailableDeliveryMethods(SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set NotificationController.getAvailableDeliveryMethods(SecurityUser)"
  })
  void testGetAvailableDeliveryMethods_thenStatusIsOk() throws Exception {
    // Arrange
    when(notificationCenter.getAvailableDeliveryMethods(Mockito.<TenantId>any()))
        .thenReturn(new HashSet<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/deliveryMethods");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveUserNotificationSettings(UserNotificationSettings, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings NotificationController.saveUserNotificationSettings(UserNotificationSettings, SecurityUser)"
  })
  void testSaveUserNotificationSettings_thenStatusFourHundredSix() throws Exception {
    // Arrange
    when(notificationSettingsService.saveUserNotificationSettings(
            Mockito.<TenantId>any(),
            Mockito.<UserId>any(),
            Mockito.<UserNotificationSettings>any()))
        .thenReturn(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/notification/settings/user");
    postResult.accept("Media Types");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    String content = jsonMapper.writeValueAsString(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#saveUserNotificationSettings(UserNotificationSettings,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationController#saveUserNotificationSettings(UserNotificationSettings, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveUserNotificationSettings(UserNotificationSettings, SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings NotificationController.saveUserNotificationSettings(UserNotificationSettings, SecurityUser)"
  })
  void testSaveUserNotificationSettings_thenStatusIsOk() throws Exception {
    // Arrange
    when(notificationSettingsService.saveUserNotificationSettings(
            Mockito.<TenantId>any(),
            Mockito.<UserId>any(),
            Mockito.<UserNotificationSettings>any()))
        .thenReturn(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/notification/settings/user")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    String content = jsonMapper.writeValueAsString(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"prefs\":{}}"));
  }

  /**
   * Test {@link NotificationController#getUserNotificationSettings(SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getUserNotificationSettings(SecurityUser)}
   */
  @Test
  @DisplayName("Test getUserNotificationSettings(SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings NotificationController.getUserNotificationSettings(SecurityUser)"
  })
  void testGetUserNotificationSettings_thenStatusFourHundredSix() throws Exception {
    // Arrange
    when(notificationSettingsService.getUserNotificationSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean()))
        .thenReturn(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/settings/user");
    requestBuilder.accept("Media Types");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationController#getUserNotificationSettings(SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#getUserNotificationSettings(SecurityUser)}
   */
  @Test
  @DisplayName("Test getUserNotificationSettings(SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserNotificationSettings NotificationController.getUserNotificationSettings(SecurityUser)"
  })
  void testGetUserNotificationSettings_thenStatusIsOk() throws Exception {
    // Arrange
    when(notificationSettingsService.getUserNotificationSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean()))
        .thenReturn(new UserNotificationSettings(new HashMap<>()));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/settings/user");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"prefs\":{}}"));
  }
}
