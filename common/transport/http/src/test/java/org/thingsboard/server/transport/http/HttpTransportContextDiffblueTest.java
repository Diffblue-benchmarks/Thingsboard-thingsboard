package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.catalina.connector.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

@ExtendWith(MockitoExtension.class)
class HttpTransportContextDiffblueTest {
  @InjectMocks private HttpTransportContext httpTransportContext;

  /**
   * Test {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}.
   *
   * <p>Method under test: {@link HttpTransportContext#tomcatAsyncTimeoutConnectorCustomizer()}
   */
  @Test
  @DisplayName("Test tomcatAsyncTimeoutConnectorCustomizer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TomcatConnectorCustomizer HttpTransportContext.tomcatAsyncTimeoutConnectorCustomizer()"
  })
  void testTomcatAsyncTimeoutConnectorCustomizer() {
    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult =
        httpTransportContext.tomcatAsyncTimeoutConnectorCustomizer();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TomcatConnectorCustomizer HttpTransportContext.tomcatAsyncTimeoutConnectorCustomizer()"
  })
  void testTomcatAsyncTimeoutConnectorCustomizer_thenConnectorAsyncTimeoutIsZero() {
    // Arrange and Act
    TomcatConnectorCustomizer actualTomcatAsyncTimeoutConnectorCustomizerResult =
        httpTransportContext.tomcatAsyncTimeoutConnectorCustomizer();
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
  @Tag("MaintainedByDiffblue")
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
