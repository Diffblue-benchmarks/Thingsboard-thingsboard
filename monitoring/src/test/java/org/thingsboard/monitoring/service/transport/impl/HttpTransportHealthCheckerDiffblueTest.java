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
import org.thingsboard.monitoring.config.transport.HttpTransportMonitoringConfig;

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
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(httpTransportMonitoringConfig.getRequestTimeoutMs()).thenReturn(10);

    // Act
    httpTransportHealthChecker.initClient();

    // Assert
    verify(httpTransportMonitoringConfig, atLeast(1)).getRequestTimeoutMs();
  }
}
