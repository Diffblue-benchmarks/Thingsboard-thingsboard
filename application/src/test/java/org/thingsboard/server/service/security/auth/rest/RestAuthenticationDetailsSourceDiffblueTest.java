package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua_parser.Client;
import ua_parser.OS;
import ua_parser.UserAgent;

@ContextConfiguration(classes = {RestAuthenticationDetailsSource.class})
@ExtendWith(SpringExtension.class)
class RestAuthenticationDetailsSourceDiffblueTest {
  @Autowired
  private RestAuthenticationDetailsSource restAuthenticationDetailsSource;

  /**
   * Test {@link RestAuthenticationDetailsSource#buildDetails(HttpServletRequest)}
   * with {@code HttpServletRequest}.
   * <p>
   * Method under test:
   * {@link RestAuthenticationDetailsSource#buildDetails(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test buildDetails(HttpServletRequest) with 'HttpServletRequest'")
  void testBuildDetailsWithHttpServletRequest() {
    // Arrange
    HttpServletRequestWrapper context = mock(HttpServletRequestWrapper.class);
    when(context.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    RestAuthenticationDetails actualBuildDetailsResult = restAuthenticationDetailsSource.buildDetails(context);

    // Assert
    verify(context, atLeast(1)).getHeader(Mockito.<String>any());
    Client userAgent = actualBuildDetailsResult.getUserAgent();
    assertEquals("Generic Feature Phone", userAgent.device.family);
    OS os = userAgent.os;
    assertEquals("Other", os.family);
    UserAgent userAgent2 = userAgent.userAgent;
    assertEquals("Other", userAgent2.family);
    assertEquals("https://example.org/example", actualBuildDetailsResult.getClientAddress());
    assertNull(os.major);
    assertNull(os.minor);
    assertNull(os.patch);
    assertNull(os.patchMinor);
    assertNull(userAgent2.major);
    assertNull(userAgent2.minor);
    assertNull(userAgent2.patch);
  }

  /**
   * Test {@link RestAuthenticationDetailsSource#buildDetails(HttpServletRequest)}
   * with {@code HttpServletRequest}.
   * <ul>
   *   <li>Then return UserAgent {@link Client#device} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestAuthenticationDetailsSource#buildDetails(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test buildDetails(HttpServletRequest) with 'HttpServletRequest'; then return UserAgent device is 'null'")
  void testBuildDetailsWithHttpServletRequest_thenReturnUserAgentDeviceIsNull() {
    // Arrange, Act and Assert
    Client userAgent = restAuthenticationDetailsSource.buildDetails(new MockHttpServletRequest()).getUserAgent();
    assertNull(userAgent.device);
    assertNull(userAgent.os);
    assertNull(userAgent.userAgent);
  }
}
