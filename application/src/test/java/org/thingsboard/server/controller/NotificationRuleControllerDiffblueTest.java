package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class NotificationRuleControllerDiffblueTest {
  @InjectMocks
  private NotificationRuleController notificationRuleController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}.
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotificationRule(UUID, SecurityUser); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleController.deleteNotificationRule(UUID, SecurityUser)"})
  void testDeleteNotificationRule_givenFromString784f394c42b6435a983cB7beff2784f9() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/notification/rule/{id}",
        "Uri Variables", "Uri Variables");
    MockHttpServletRequestBuilder requestBuilder = deleteResult.param("user", String.valueOf(new SecurityUser()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}.
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotificationRule(UUID, SecurityUser); when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleController.deleteNotificationRule(UUID, SecurityUser)"})
  void testDeleteNotificationRule_whenFromString784f394c42b6435a983cB7beff2784f9() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/notification/rule/{id}",
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    MockHttpServletRequestBuilder requestBuilder = deleteResult.param("user", String.valueOf(new SecurityUser()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
