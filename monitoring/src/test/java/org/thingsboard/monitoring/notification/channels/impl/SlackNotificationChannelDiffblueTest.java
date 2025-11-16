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
