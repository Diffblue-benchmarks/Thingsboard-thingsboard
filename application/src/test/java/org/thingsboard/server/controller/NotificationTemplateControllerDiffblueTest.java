package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class NotificationTemplateControllerDiffblueTest {
  @InjectMocks private NotificationTemplateController notificationTemplateController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationTemplateController#saveNotificationTemplate(NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * NotificationTemplateController#saveNotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test saveNotificationTemplate(NotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplate NotificationTemplateController.saveNotificationTemplate(NotificationTemplate)"
  })
  void testSaveNotificationTemplate() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/notification/template");
    postResult.characterEncoding("https://example.org/example");

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());
    notificationTemplate.setCreatedTime(1L);
    notificationTemplate.setExternalId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTemplate.setId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTemplate.setName("Name");
    notificationTemplate.setNotificationType(NotificationType.GENERAL);
    notificationTemplate.setTenantId(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = new ObjectMapper().writeValueAsString(notificationTemplate);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link NotificationTemplateController#getNotificationTemplateById(UUID)}.
   *
   * <p>Method under test: {@link NotificationTemplateController#getNotificationTemplateById(UUID)}
   */
  @Test
  @DisplayName("Test getNotificationTemplateById(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationTemplate NotificationTemplateController.getNotificationTemplateById(UUID)"
  })
  void testGetNotificationTemplateById() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/notification/template/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationTemplateController#deleteNotificationTemplateById(UUID)}.
   *
   * <p>Method under test: {@link
   * NotificationTemplateController#deleteNotificationTemplateById(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationTemplateById(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateController.deleteNotificationTemplateById(UUID)"})
  void testDeleteNotificationTemplateById() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/template/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTemplateController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
