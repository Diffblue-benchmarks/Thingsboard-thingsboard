package org.thingsboard.server.transport.http.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {PayloadSizeFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class PayloadSizeFilterDiffblueTest {
  @Autowired
  private PayloadSizeFilter payloadSizeFilter;

  /**
   * Test {@link PayloadSizeFilter#PayloadSizeFilter(String)}.
   * <ul>
   *   <li>When {@code =}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PayloadSizeFilter#PayloadSizeFilter(String)}
   */
  @Test
  @DisplayName("Test new PayloadSizeFilter(String); when '='; then throw IllegalArgumentException")
  void testNewPayloadSizeFilter_whenEqualsSign_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("="));
  }

  /**
   * Test {@link PayloadSizeFilter#PayloadSizeFilter(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PayloadSizeFilter#PayloadSizeFilter(String)}
   */
  @Test
  @DisplayName("Test new PayloadSizeFilter(String); when 'https://example.org/example'")
  void testNewPayloadSizeFilter_whenHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("https://example.org/example"));
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("=https://example.org/example"));
  }

  /**
   * Test
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain); then throw IllegalArgumentException")
  void testDoFilterInternal_thenThrowIllegalArgumentException() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    FilterChain chain = mock(FilterChain.class);
    doThrow(new IllegalArgumentException("foo")).when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> payloadSizeFilter.doFilterInternal(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  void testDoFilterInternal_whenFilterChainDoFilterDoesNothing() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    payloadSizeFilter.doFilterInternal(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link PayloadSizeFilter#shouldNotFilterAsyncDispatch()}.
   * <p>
   * Method under test: {@link PayloadSizeFilter#shouldNotFilterAsyncDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterAsyncDispatch()")
  void testShouldNotFilterAsyncDispatch() {
    // Arrange, Act and Assert
    assertFalse(payloadSizeFilter.shouldNotFilterAsyncDispatch());
  }

  /**
   * Test {@link PayloadSizeFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test: {@link PayloadSizeFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @DisplayName("Test shouldNotFilterErrorDispatch()")
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(payloadSizeFilter.shouldNotFilterErrorDispatch());
  }
}
