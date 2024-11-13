package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

class SkipPathRequestMatcherDiffblueTest {
  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Then return matches
   * {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); then return matches MockHttpServletRequest()")
  void testNewSkipPathRequestMatcher_thenReturnMatchesMockHttpServletRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("127.0.0.1");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "/**");

    // Assert
    assertTrue(actualSkipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Then return not matcher {@code null} Match.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); then return not matcher 'null' Match")
  void testNewSkipPathRequestMatcher_thenReturnNotMatcherNullMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("/**");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "/**");
    boolean actualMatchesResult = actualSkipPathRequestMatcher.matches(new MockHttpServletRequest());

    // Assert
    RequestMatcher.MatchResult matcherResult = actualSkipPathRequestMatcher.matcher(null);
    assertFalse(matcherResult.isMatch());
    assertFalse(actualMatchesResult);
    assertTrue(matcherResult.getVariables().isEmpty());
  }

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Then return not matches
   * {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); then return not matches MockHttpServletRequest()")
  void testNewSkipPathRequestMatcher_thenReturnNotMatchesMockHttpServletRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("127.0.0.1");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");

    // Assert
    assertFalse(actualSkipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#matches(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#matches(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test matches(HttpServletRequest); given ArrayList() add 'foo'; when MockHttpServletRequest(); then return 'false'")
  void testMatches_givenArrayListAddFoo_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    SkipPathRequestMatcher skipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");

    // Act and Assert
    assertFalse(skipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#matches(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HttpServletRequestWrapper}
   * {@link HttpServletRequestWrapper#getPathInfo()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#matches(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test matches(HttpServletRequest); given 'foo'; when HttpServletRequestWrapper getPathInfo() return 'foo'")
  void testMatches_givenFoo_whenHttpServletRequestWrapperGetPathInfoReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    pathsToSkip.add("foo");
    SkipPathRequestMatcher skipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getPathInfo()).thenReturn("foo");
    when(request.getServletPath()).thenReturn("");

    // Act
    boolean actualMatchesResult = skipPathRequestMatcher.matches(request);

    // Assert
    verify(request).getPathInfo();
    verify(request).getServletPath();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link SkipPathRequestMatcher#matches(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#matches(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test matches(HttpServletRequest); given 'https://example.org/example'")
  void testMatches_givenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    pathsToSkip.add("foo");
    SkipPathRequestMatcher skipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getPathInfo()).thenReturn("https://example.org/example");
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    boolean actualMatchesResult = skipPathRequestMatcher.matches(request);

    // Assert
    verify(request, atLeast(1)).getPathInfo();
    verify(request, atLeast(1)).getServletPath();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link SkipPathRequestMatcher#matches(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#matches(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test matches(HttpServletRequest); then return 'true'")
  void testMatches_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    pathsToSkip.add("foo");
    SkipPathRequestMatcher skipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "/**");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getPathInfo()).thenReturn("https://example.org/example");
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    boolean actualMatchesResult = skipPathRequestMatcher.matches(request);

    // Assert
    verify(request, atLeast(1)).getPathInfo();
    verify(request, atLeast(1)).getServletPath();
    assertTrue(actualMatchesResult);
  }
}
