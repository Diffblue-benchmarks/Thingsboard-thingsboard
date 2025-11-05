package org.thingsboard.monitoring.notification.channels.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class SlackNotificationChannelDiffblueTest {
  @Mock private RestTemplate restTemplate;

  @InjectMocks private SlackNotificationChannel slackNotificationChannel;

  /**
   * Test {@link SlackNotificationChannel#sendNotification(String)}.
   *
   * <p>Method under test: {@link SlackNotificationChannel#sendNotification(String)}
   */
  @Test
  @DisplayName("Test sendNotification(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlackNotificationChannel.sendNotification(String)"})
  void testSendNotification() throws RestClientException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(restTemplate.postForObject(
            Mockito.<String>any(), Mockito.<Object>any(), eq(String.class), isA(Object[].class)))
        .thenReturn("Post For Object");

    // Act
    slackNotificationChannel.sendNotification("Not all who wander are lost");

    // Assert
    verify(restTemplate)
        .postForObject((String) isNull(), isA(Object.class), isA(Class.class), isA(Object[].class));
  }
}
