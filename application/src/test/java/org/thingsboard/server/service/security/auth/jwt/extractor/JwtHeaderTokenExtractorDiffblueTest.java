package org.thingsboard.server.service.security.auth.jwt.extractor;

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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtHeaderTokenExtractor.class})
@ExtendWith(SpringExtension.class)
class JwtHeaderTokenExtractorDiffblueTest {
  @Autowired
  private JwtHeaderTokenExtractor jwtHeaderTokenExtractor;

  /**
   * Test {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given empty string")
  void testExtract_givenEmptyString() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtHeaderTokenExtractor.extract(request));
    verify(request, atLeast(1)).getHeader(Mockito.<String>any());
  }

  /**
   * Test {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HttpServletRequestWrapper}
   * {@link HttpServletRequestWrapper#getHeader(String)} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given 'foo'; when HttpServletRequestWrapper getHeader(String) return 'foo'")
  void testExtract_givenFoo_whenHttpServletRequestWrapperGetHeaderReturnFoo() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("foo");

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtHeaderTokenExtractor.extract(request));
    verify(request).getHeader(eq("X-Authorization"));
  }

  /**
   * Test {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code /example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given 'https://example.org/example'; then return '/example.org/example'")
  void testExtract_givenHttpsExampleOrgExample_thenReturnExampleOrgExample() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualExtractResult = jwtHeaderTokenExtractor.extract(request);

    // Assert
    verify(request).getHeader(eq("X-Authorization"));
    assertEquals("/example.org/example", actualExtractResult);
  }

  /**
   * Test {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then throw {@link AuthenticationServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtHeaderTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); when MockHttpServletRequest(); then throw AuthenticationServiceException")
  void testExtract_whenMockHttpServletRequest_thenThrowAuthenticationServiceException() {
    // Arrange, Act and Assert
    assertThrows(AuthenticationServiceException.class,
        () -> jwtHeaderTokenExtractor.extract(new MockHttpServletRequest()));
  }
}
