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
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class NotificationTargetControllerDiffblueTest {
  @InjectMocks
  private NotificationTargetController notificationTargetController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}.
   * <p>
   * Method under test: {@link NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName("Test saveNotificationTarget(NotificationTarget, SecurityUser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"})
  void testSaveNotificationTarget() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/notification/target");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder paramResult = postResult.param("user", String.valueOf(new SecurityUser()));

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());
    notificationTarget.setCreatedTime(1L);
    notificationTarget.setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTarget.setId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTarget.setName("Name");
    notificationTarget.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = (new ObjectMapper()).writeValueAsString(notificationTarget);
    MockHttpServletRequestBuilder requestBuilder = paramResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}.
   * <ul>
   *   <li>Then status four hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"})
  void testGetRecipientsForNotificationTargetConfig_thenStatusFourHundred() throws Exception {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());
    notificationTarget.setCreatedTime(1L);
    notificationTarget.setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTarget.setId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationTarget.setName("Name");
    notificationTarget.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = (new ObjectMapper()).writeValueAsString(notificationTarget);
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/api/notification/target/recipients")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("pageSize", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult2.param("user", String.valueOf(new SecurityUser()))
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}.
   * <ul>
   *   <li>Then status four hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsByIds(UUID[], SecurityUser); then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List NotificationTargetController.getNotificationTargetsByIds(UUID[], SecurityUser)"})
  void testGetNotificationTargetsByIds_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/notification/targets");
    MockHttpServletRequestBuilder paramResult = getResult.param("ids",
        String.valueOf(new UUID[]{UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("user", String.valueOf(new SecurityUser()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
