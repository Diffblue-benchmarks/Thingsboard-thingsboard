package org.thingsboard.server.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;

class MiscUtilsDiffblueTest {
  /**
   * Test {@link MiscUtils#missingProperty(String)}.
   * <p>
   * Method under test: {@link MiscUtils#missingProperty(String)}
   */
  @Test
  @DisplayName("Test missingProperty(String)")
  void testMissingProperty() {
    // Arrange, Act and Assert
    assertEquals("The Property Name property need to be set!", MiscUtils.missingProperty("Property Name"));
  }

  /**
   * Test {@link MiscUtils#forName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then throw IllegalArgumentException")
  void testForName_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MiscUtils.forName("Name"));
  }

  /**
   * Test {@link MiscUtils#constructBaseUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code https://example.org/example://Server Name:1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#constructBaseUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test constructBaseUrl(HttpServletRequest); given one; then return 'https://example.org/example://Server Name:1'")
  void testConstructBaseUrl_givenOne_thenReturnHttpsExampleOrgExampleServerName1() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(1);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualConstructBaseUrlResult = MiscUtils.constructBaseUrl(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("https://example.org/example://Server Name:1", actualConstructBaseUrlResult);
  }

  /**
   * Test {@link MiscUtils#constructBaseUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example://Server Name:8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#constructBaseUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test constructBaseUrl(HttpServletRequest); then return 'https://example.org/example://Server Name:8080'")
  void testConstructBaseUrl_thenReturnHttpsExampleOrgExampleServerName8080() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new NumberFormatException("%s://%s:%d"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualConstructBaseUrlResult = MiscUtils.constructBaseUrl(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("https://example.org/example://Server Name:8080", actualConstructBaseUrlResult);
  }

  /**
   * Test {@link MiscUtils#constructBaseUrl(HttpServletRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#constructBaseUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test constructBaseUrl(HttpServletRequest); then throw IllegalArgumentException")
  void testConstructBaseUrl_thenThrowIllegalArgumentException() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new IllegalArgumentException("%s://%s:%d"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MiscUtils.constructBaseUrl(request));
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
  }

  /**
   * Test {@link MiscUtils#constructBaseUrl(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code http://localhost:80}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#constructBaseUrl(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test constructBaseUrl(HttpServletRequest); when MockHttpServletRequest(); then return 'http://localhost:80'")
  void testConstructBaseUrl_whenMockHttpServletRequest_thenReturnHttpLocalhost80() {
    // Arrange, Act and Assert
    assertEquals("http://localhost:80", MiscUtils.constructBaseUrl(new MockHttpServletRequest()));
  }

  /**
   * Test {@link MiscUtils#getScheme(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Scheme}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getScheme(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getScheme(HttpServletRequest); given 'Scheme'; then return 'https://example.org/example'")
  void testGetScheme_givenScheme_thenReturnHttpsExampleOrgExample() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualScheme = MiscUtils.getScheme(request);

    // Assert
    verify(request).getScheme();
    verify(request).getHeader(eq("x-forwarded-proto"));
    assertEquals("https://example.org/example", actualScheme);
  }

  /**
   * Test {@link MiscUtils#getScheme(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code http}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getScheme(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getScheme(HttpServletRequest); when MockHttpServletRequest(); then return 'http'")
  void testGetScheme_whenMockHttpServletRequest_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals("http", MiscUtils.getScheme(new MockHttpServletRequest()));
  }

  /**
   * Test {@link MiscUtils#getDomainName(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Server Name}.</li>
   *   <li>Then return {@code Server Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainName(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainName(HttpServletRequest); given 'Server Name'; then return 'Server Name'")
  void testGetDomainName_givenServerName_thenReturnServerName() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getServerName()).thenReturn("Server Name");

    // Act
    String actualDomainName = MiscUtils.getDomainName(request);

    // Assert
    verify(request).getServerName();
    assertEquals("Server Name", actualDomainName);
  }

  /**
   * Test {@link MiscUtils#getDomainName(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code localhost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainName(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainName(HttpServletRequest); when MockHttpServletRequest(); then return 'localhost'")
  void testGetDomainName_whenMockHttpServletRequest_thenReturnLocalhost() {
    // Arrange, Act and Assert
    assertEquals("localhost", MiscUtils.getDomainName(new MockHttpServletRequest()));
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given four hundred forty-three.</li>
   *   <li>Then return {@code Server Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); given four hundred forty-three; then return 'Server Name'")
  void testGetDomainNameAndPort_givenFourHundredFortyThree_thenReturnServerName() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(443);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https");

    // Act
    String actualDomainNameAndPort = MiscUtils.getDomainNameAndPort(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("Server Name", actualDomainNameAndPort);
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code http}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); given 'http'")
  void testGetDomainNameAndPort_givenHttp() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(1);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("http");

    // Act
    String actualDomainNameAndPort = MiscUtils.getDomainNameAndPort(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("Server Name:1", actualDomainNameAndPort);
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); given 'https'")
  void testGetDomainNameAndPort_givenHttps() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(1);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https");

    // Act
    String actualDomainNameAndPort = MiscUtils.getDomainNameAndPort(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("Server Name:1", actualDomainNameAndPort);
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code Server Name:1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); given one; then return 'Server Name:1'")
  void testGetDomainNameAndPort_givenOne_thenReturnServerName1() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(1);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualDomainNameAndPort = MiscUtils.getDomainNameAndPort(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("Server Name:1", actualDomainNameAndPort);
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code Server Name:8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); then return 'Server Name:8080'")
  void testGetDomainNameAndPort_thenReturnServerName8080() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new NumberFormatException("x-forwarded-proto"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualDomainNameAndPort = MiscUtils.getDomainNameAndPort(request);

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals("Server Name:8080", actualDomainNameAndPort);
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); then throw IllegalArgumentException")
  void testGetDomainNameAndPort_thenThrowIllegalArgumentException() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new IllegalArgumentException("x-forwarded-proto"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MiscUtils.getDomainNameAndPort(request));
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code localhost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); when MockHttpServletRequest(); then return 'localhost'")
  void testGetDomainNameAndPort_whenMockHttpServletRequest_thenReturnLocalhost() {
    // Arrange, Act and Assert
    assertEquals("localhost", MiscUtils.getDomainNameAndPort(new MockHttpServletRequest()));
  }

  /**
   * Test {@link MiscUtils#getPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code x-forwarded-proto}.</li>
   *   <li>Then return {@code 8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getPort(HttpServletRequest); given NumberFormatException(String) with 'x-forwarded-proto'; then return '8080'")
  void testGetPort_givenNumberFormatExceptionWithXForwardedProto_thenReturn8080() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new NumberFormatException("x-forwarded-proto"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    int actualPort = MiscUtils.getPort(request);

    // Assert
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals(8080, actualPort);
  }

  /**
   * Test {@link MiscUtils#getPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getPort(HttpServletRequest); given one; then return one")
  void testGetPort_givenOne_thenReturnOne() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenReturn(1);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    int actualPort = MiscUtils.getPort(request);

    // Assert
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
    assertEquals(1, actualPort);
  }

  /**
   * Test {@link MiscUtils#getPort(HttpServletRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getPort(HttpServletRequest); then throw IllegalArgumentException")
  void testGetPort_thenThrowIllegalArgumentException() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getIntHeader(Mockito.<String>any())).thenThrow(new IllegalArgumentException("x-forwarded-proto"));
    when(request.getServerPort()).thenReturn(8080);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MiscUtils.getPort(request));
    verify(request).getServerPort();
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
    verify(request).getIntHeader(eq("x-forwarded-port"));
  }

  /**
   * Test {@link MiscUtils#getPort(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return eighty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getPort(HttpServletRequest); when MockHttpServletRequest(); then return eighty")
  void testGetPort_whenMockHttpServletRequest_thenReturnEighty() {
    // Arrange, Act and Assert
    assertEquals(80, MiscUtils.getPort(new MockHttpServletRequest()));
  }
}
