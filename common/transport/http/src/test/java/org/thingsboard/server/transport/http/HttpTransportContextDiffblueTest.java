package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

class HttpTransportContextDiffblueTest {
  /**
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   * <p>
   * Method under test:
   * {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName("Test tomcatAsyncTimeoutConnectorCustomizer()")
  void testTomcatAsyncTimeoutConnectorCustomizer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult = (new HttpTransportContext())
        .tomcatAsyncTimeoutConnectorCustomizer();
    Connector connector = new Connector("Setting async max request timeout {}");
    actualTomcatAsyncTimeoutConnectorCustomizerResult.customize(connector);

    // Assert that nothing has changed
    assertEquals(30000L, connector.getAsyncTimeout());
  }

  /**
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   * <ul>
   *   <li>Then {@link Connector#Connector()} AsyncTimeout is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName("Test tomcatAsyncTimeoutConnectorCustomizer(); then Connector() AsyncTimeout is zero")
  void testTomcatAsyncTimeoutConnectorCustomizer_thenConnectorAsyncTimeoutIsZero() {
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
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   * <ul>
   *   <li>Then {@link Connector#Connector()} AsyncTimeout is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName("Test tomcatAsyncTimeoutConnectorCustomizer(); then Connector() AsyncTimeout is zero")
  void testTomcatAsyncTimeoutConnectorCustomizer_thenConnectorAsyncTimeoutIsZero2() {
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HttpTransportContext#getDefaultTimeout()}
   *   <li>{@link HttpTransportContext#getMaxRequestTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
