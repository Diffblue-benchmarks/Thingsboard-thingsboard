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
package org.thingsboard.monitoring.service.transport.impl;

import static org.mockito.Mockito.atLeast;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.monitoring.config.transport.HttpTransportMonitoringConfig;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class HttpTransportHealthCheckerDiffblueTest {
  @InjectMocks private HttpTransportHealthChecker httpTransportHealthChecker;

  @Mock private HttpTransportMonitoringConfig httpTransportMonitoringConfig;

  /**
   * Test {@link HttpTransportHealthChecker#initClient()}.
   *
   * <ul>
   *   <li>Then calls {@link HttpTransportMonitoringConfig#getRequestTimeoutMs()}.
   * </ul>
   *
   * <p>Method under test: {@link HttpTransportHealthChecker#initClient()}
   */
  @Test
  @DisplayName("Test initClient(); then calls getRequestTimeoutMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpTransportHealthChecker.initClient()"})
  void testInitClient_thenCallsGetRequestTimeoutMs() throws Exception {
    // Arrange
    when(httpTransportMonitoringConfig.getRequestTimeoutMs()).thenReturn(10);

    // Act
    httpTransportHealthChecker.initClient();

    // Assert
    verify(httpTransportMonitoringConfig, atLeast(1)).getRequestTimeoutMs();
  }
}
