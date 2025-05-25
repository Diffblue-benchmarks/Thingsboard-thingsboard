package org.thingsboard.server.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.catalina.filters.RemoteIpFilter.XForwardedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.missingProperty(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.google.common.hash.HashFunction MiscUtils.forName(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.constructBaseUrl(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.constructBaseUrl(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.constructBaseUrl(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.constructBaseUrl(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getScheme(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getScheme(HttpServletRequest)"})
  void testGetScheme_whenMockHttpServletRequest_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals("http", MiscUtils.getScheme(new MockHttpServletRequest()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainName(HttpServletRequest)"})
  void testGetDomainName_whenMockHttpServletRequest_thenReturnLocalhost() {
    // Arrange, Act and Assert
    assertEquals("localhost", MiscUtils.getDomainName(new MockHttpServletRequest()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
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
   *   <li>Given one.</li>
   *   <li>Then return {@code Server Name:1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); given one; then return 'Server Name:1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
  void testGetDomainNameAndPort_givenOne_thenReturnServerName12() {
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
   *   <li>Then return {@code localhost:443}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); then return 'localhost:443'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
  void testGetDomainNameAndPort_thenReturnLocalhost443() {
    // Arrange
    XForwardedRequest request = new XForwardedRequest(new MockHttpServletRequest());
    request.setServerPort(443);

    // Act and Assert
    assertEquals("localhost:443", MiscUtils.getDomainNameAndPort(request));
  }

  /**
   * Test {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code Server Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); then return 'Server Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
  void testGetDomainNameAndPort_thenReturnServerName() {
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
   *   <li>Then return {@code Server Name:8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getDomainNameAndPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getDomainNameAndPort(HttpServletRequest); then return 'Server Name:8080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MiscUtils.getDomainNameAndPort(HttpServletRequest)"})
  void testGetDomainNameAndPort_whenMockHttpServletRequest_thenReturnLocalhost() {
    // Arrange, Act and Assert
    assertEquals("localhost", MiscUtils.getDomainNameAndPort(new MockHttpServletRequest()));
  }

  /**
   * Test {@link MiscUtils#getPort(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with {@code x-forwarded-proto}.</li>
   *   <li>Then return {@code 8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MiscUtils#getPort(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getPort(HttpServletRequest); given NumberFormatException(String) with 'x-forwarded-proto'; then return '8080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MiscUtils.getPort(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MiscUtils.getPort(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MiscUtils.getPort(HttpServletRequest)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MiscUtils.getPort(HttpServletRequest)"})
  void testGetPort_whenMockHttpServletRequest_thenReturnEighty() {
    // Arrange, Act and Assert
    assertEquals(80, MiscUtils.getPort(new MockHttpServletRequest()));
  }
}
