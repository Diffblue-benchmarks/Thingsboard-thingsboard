package org.thingsboard.server.service.security.auth.jwt.extractor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
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
   * <ul>
   *   <li>Then calls {@link ServletRequestWrapper#getParameterMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtQueryTokenExtractor#extract(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test extract(HttpServletRequest); then calls getParameterMap()")
  void testExtract_thenCallsGetParameterMap() {
    // Arrange
    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("Authorization query parameter cannot be blank!",
        new String[]{"Authorization query parameter cannot be blank!"});
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameterMap()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(AuthenticationServiceException.class, () -> jwtQueryTokenExtractor.extract(request));
    verify(request, atLeast(1)).getParameterMap();
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
  void testExtract_whenMockHttpServletRequest_thenThrowAuthenticationServiceException() {
    // Arrange, Act and Assert
    assertThrows(AuthenticationServiceException.class,
        () -> jwtQueryTokenExtractor.extract(new MockHttpServletRequest()));
  }
}
