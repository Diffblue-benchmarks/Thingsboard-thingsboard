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
package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.catalina.connector.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

class HttpTransportContextDiffblueTest {
  /**
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   *
   * <p>Method under test: {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName("Test tomcatAsyncTimeoutConnectorCustomizer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TomcatConnectorCustomizer HttpTransportContext.tomcatAsyncTimeoutConnectorCustomizer()"
  })
  void testTomcatAsyncTimeoutConnectorCustomizer() {
    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult =
        new HttpTransportContext().tomcatAsyncTimeoutConnectorCustomizer();
    Connector connector = new Connector("Setting async max request timeout {}");
    actualTomcatAsyncTimeoutConnectorCustomizerResult.customize(connector);

    // Assert that nothing has changed
    assertEquals(30000L, connector.getAsyncTimeout());
  }

  /**
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   *
   * <ul>
   *   <li>Then {@link Connector#Connector()} AsyncTimeout is zero.
   * </ul>
   *
   * <p>Method under test: {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName(
      "Test tomcatAsyncTimeoutConnectorCustomizer(); then Connector() AsyncTimeout is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TomcatConnectorCustomizer HttpTransportContext.tomcatAsyncTimeoutConnectorCustomizer()"
  })
  void testTomcatAsyncTimeoutConnectorCustomizer_thenConnectorAsyncTimeoutIsZero() {
    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult =
        new HttpTransportContext().tomcatAsyncTimeoutConnectorCustomizer();
    Connector connector = new Connector();
    actualTomcatAsyncTimeoutConnectorCustomizerResult.customize(connector);

    // Assert
    assertEquals(0L, connector.getAsyncTimeout());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HttpTransportContext#getDefaultTimeout()}
   *   <li>{@link HttpTransportContext#getMaxRequestTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long HttpTransportContext.getDefaultTimeout()",
    "long HttpTransportContext.getMaxRequestTimeout()"
  })
  void testGettersAndSetters() {
    // Arrange
    HttpTransportContext httpTransportContext = new HttpTransportContext();

    // Act
    long actualDefaultTimeout = httpTransportContext.getDefaultTimeout();

    // Assert
    assertEquals(0L, actualDefaultTimeout);
    assertEquals(0L, httpTransportContext.getMaxRequestTimeout());
  }
}
