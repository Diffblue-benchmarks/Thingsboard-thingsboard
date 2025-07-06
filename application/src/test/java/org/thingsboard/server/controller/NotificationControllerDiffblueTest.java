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
class NotificationControllerDiffblueTest {
  @InjectMocks private NotificationController notificationController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#markNotificationAsRead(UUID, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test markNotificationAsRead(UUID, SecurityUser); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationController.markNotificationAsRead(UUID, SecurityUser)"})
  void testMarkNotificationAsRead_givenFromString784f394c42b6435a983cB7beff2784f9()
      throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/api/notification/{id}/read", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotification(UUID, SecurityUser)")
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationController#deleteNotification(UUID, SecurityUser)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationController#deleteNotification(UUID, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test deleteNotification(UUID, SecurityUser); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationController.deleteNotification(UUID, SecurityUser)"})
  void testDeleteNotification_givenFromString784f394c42b6435a983cB7beff2784f9() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/notification/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationController#getNotificationRequestById(UUID)}.
   *
   * <p>Method under test: {@link NotificationController#getNotificationRequestById(UUID)}
   */
  @Test
  @DisplayName("Test getNotificationRequestById(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.notification.NotificationRequestInfo NotificationController.getNotificationRequestById(UUID)"
  })
  void testGetNotificationRequestById() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/notification/request/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link NotificationController#deleteNotificationRequest(UUID)}.
   *
   * <p>Method under test: {@link NotificationController#deleteNotificationRequest(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationRequest(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationController.deleteNotificationRequest(UUID)"})
  void testDeleteNotificationRequest() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/request/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
