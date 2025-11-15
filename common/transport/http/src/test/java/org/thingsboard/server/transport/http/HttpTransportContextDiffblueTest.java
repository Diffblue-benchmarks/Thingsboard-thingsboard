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
import static org.mockito.Mockito.mock;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

class HttpTransportContextDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HttpTransportContext#getDefaultTimeout()}
   *   <li>{@link HttpTransportContext#getMaxRequestTimeout()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HttpTransportContext httpTransportContext = new HttpTransportContext();

    // Act
    long actualDefaultTimeout = httpTransportContext.getDefaultTimeout();

    // Assert
    assertEquals(0L, actualDefaultTimeout);
    assertEquals(0L, httpTransportContext.getMaxRequestTimeout());
  }

  /**
   * Method under test:
   * {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  void testTomcatAsyncTimeoutConnectorCustomizer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult = (new HttpTransportContext())
        .tomcatAsyncTimeoutConnectorCustomizer();
    Connector connector = new Connector();
    actualTomcatAsyncTimeoutConnectorCustomizerResult.customize(connector);

    // Assert
    assertEquals(0L, connector.getAsyncTimeout());
  }

  /**
   * Method under test:
   * {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  void testTomcatAsyncTimeoutConnectorCustomizer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult = (new HttpTransportContext())
        .tomcatAsyncTimeoutConnectorCustomizer();
    Connector connector = new Connector();
    connector.addLifecycleListener(mock(LifecycleListener.class));
    actualTomcatAsyncTimeoutConnectorCustomizerResult.customize(connector);

    // Assert
    assertEquals(0L, connector.getAsyncTimeout());
  }
}
