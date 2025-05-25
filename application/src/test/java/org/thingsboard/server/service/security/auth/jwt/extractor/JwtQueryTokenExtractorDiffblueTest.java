package org.thingsboard.server.service.security.auth.jwt.extractor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtQueryTokenExtractor.class})
@ExtendWith(SpringExtension.class)
class JwtQueryTokenExtractorDiffblueTest {
  @Autowired
  private JwtQueryTokenExtractor jwtQueryTokenExtractor;

  /**
   * Test {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}.
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JwtQueryTokenExtractor.extract(HttpServletRequest)"})
  void testExtract() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtQueryTokenExtractor.extract(request));
  }

  /**
   * Test {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JwtQueryTokenExtractor.extract(HttpServletRequest)"})
  void testExtract_given42_thenReturn42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("token", "42");
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals("42", jwtQueryTokenExtractor.extract(request));
  }

  /**
   * Test {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JwtQueryTokenExtractor.extract(HttpServletRequest)"})
  void testExtract_givenEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("token", "");
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtQueryTokenExtractor.extract(request));
  }

  /**
   * Test {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link JwtQueryTokenExtractor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); given JwtQueryTokenExtractor (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JwtQueryTokenExtractor.extract(HttpServletRequest)"})
  void testExtract_givenJwtQueryTokenExtractor() {
    // Arrange
    JwtQueryTokenExtractor jwtQueryTokenExtractor = new JwtQueryTokenExtractor();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("token", "42");
    request.addParameter("token", "https://example.org/example");

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtQueryTokenExtractor.extract(request));
  }

  /**
   * Test {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then throw {@link AuthenticationServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); when MockHttpServletRequest(); then throw AuthenticationServiceException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JwtQueryTokenExtractor.extract(HttpServletRequest)"})
  void testExtract_whenMockHttpServletRequest_thenThrowAuthenticationServiceException() {
    // Arrange, Act and Assert
    assertThrows(AuthenticationServiceException.class,
        () -> jwtQueryTokenExtractor.extract(new MockHttpServletRequest()));
  }
}
