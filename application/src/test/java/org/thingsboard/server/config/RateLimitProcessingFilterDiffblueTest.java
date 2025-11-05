package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.common.data.exception.TenantProfileNotFoundException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ContextConfiguration(classes = {RateLimitProcessingFilter.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class RateLimitProcessingFilterDiffblueTest {
  @Autowired private RateLimitProcessingFilter rateLimitProcessingFilter;

  @MockBean private RateLimitService rateLimitService;

  @MockBean private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RateLimitProcessingFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link TenantProfileNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitProcessingFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain); then throw TenantProfileNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitProcessingFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternal_thenThrowTenantProfileNotFoundException()
      throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    doThrow(new TenantProfileNotFoundException(tenantId))
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () -> rateLimitProcessingFilter.doFilterInternal(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link RateLimitProcessingFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitProcessingFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitProcessingFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternal_whenFilterChainDoFilterDoesNothing()
      throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    rateLimitProcessingFilter.doFilterInternal(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }
}
