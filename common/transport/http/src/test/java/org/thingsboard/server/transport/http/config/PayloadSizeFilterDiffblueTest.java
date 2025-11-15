/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
   * Method under test:
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternal() throws ServletException, IOException {
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
   * Method under test:
   * {@link PayloadSizeFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternal2() throws ServletException, IOException {
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
   * Method under test: {@link PayloadSizeFilter#shouldNotFilterAsyncDispatch()}
   */
  @Test
  void testShouldNotFilterAsyncDispatch() {
    // Arrange, Act and Assert
    assertFalse(payloadSizeFilter.shouldNotFilterAsyncDispatch());
  }

  /**
   * Method under test: {@link PayloadSizeFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(payloadSizeFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Method under test: {@link PayloadSizeFilter#PayloadSizeFilter(String)}
   */
  @Test
  void testNewPayloadSizeFilter() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("https://example.org/example"));
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("="));
    assertThrows(IllegalArgumentException.class, () -> new PayloadSizeFilter("=https://example.org/example"));
  }
}
