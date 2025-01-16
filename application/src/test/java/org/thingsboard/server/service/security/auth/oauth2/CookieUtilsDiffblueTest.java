package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.partitions.model.Endpoint;
import com.amazonaws.partitions.model.Service;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.BiFunction;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpServletRequest;

class CookieUtilsDiffblueTest {
  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String)")
  void testGetCookie() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("42", "https://example.org/example")});

    // Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(request, "Name");

    // Assert
    verify(request).getCookies();
    assertFalse(actualCookie.isPresent());
  }

  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <ul>
   *   <li>Given {@link Cookie} {@link Cookie#getName()} return
   * {@code https://example.org/example}.</li>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String); given Cookie getName() return 'https://example.org/example'; then calls getName()")
  void testGetCookie_givenCookieGetNameReturnHttpsExampleOrgExample_thenCallsGetName() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(request, "Name");

    // Assert
    verify(cookie).getName();
    verify(request).getCookies();
    assertFalse(actualCookie.isPresent());
  }

  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <ul>
   *   <li>Given empty array of {@link Cookie}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String); given empty array of Cookie")
  void testGetCookie_givenEmptyArrayOfCookie() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{});

    // Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(request, "Name");

    // Assert
    verify(request).getCookies();
    assertFalse(actualCookie.isPresent());
  }

  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String); then return Present")
  void testGetCookie_thenReturnPresent() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    Cookie cookie = new Cookie("Name", "https://example.org/example");

    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(request, "Name");

    // Assert
    verify(request).getCookies();
    assertTrue(actualCookie.isPresent());
    assertSame(cookie, actualCookie.get());
  }

  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String); when MockHttpServletRequest(); then return not Present")
  void testGetCookie_whenMockHttpServletRequest_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(new MockHttpServletRequest(), "Name");

    // Assert
    assertFalse(actualCookie.isPresent());
  }

  /**
   * Test {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}.
   * <ul>
   *   <li>Then calls {@link HttpServletResponseWrapper#addCookie(Cookie)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}
   */
  @Test
  @DisplayName("Test addCookie(HttpServletResponse, String, String, int); then calls addCookie(Cookie)")
  void testAddCookie_thenCallsAddCookie() {
    // Arrange
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    CookieUtils.addCookie(response, "Name", "42", 3);

    // Assert
    verify(response).addCookie(isA(Cookie.class));
  }

  /**
   * Test
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test deleteCookie(HttpServletRequest, HttpServletResponse, String)")
  void testDeleteCookie() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("42", "https://example.org/example")});

    // Act
    CookieUtils.deleteCookie(request, new Response(), "Name");

    // Assert that nothing has changed
    verify(request).getCookies();
  }

  /**
   * Test
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@link Cookie} {@link Cookie#getName()} return
   * {@code https://example.org/example}.</li>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test deleteCookie(HttpServletRequest, HttpServletResponse, String); given Cookie getName() return 'https://example.org/example'; then calls getName()")
  void testDeleteCookie_givenCookieGetNameReturnHttpsExampleOrgExample_thenCallsGetName() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    CookieUtils.deleteCookie(request, new Response(), "Name");

    // Assert that nothing has changed
    verify(cookie).getName();
    verify(request).getCookies();
  }

  /**
   * Test
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@link Cookie} {@link Cookie#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Cookie#setMaxAge(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test deleteCookie(HttpServletRequest, HttpServletResponse, String); given Cookie getName() return 'Name'; then calls setMaxAge(int)")
  void testDeleteCookie_givenCookieGetNameReturnName_thenCallsSetMaxAge() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    doNothing().when(cookie).setMaxAge(anyInt());
    doNothing().when(cookie).setPath(Mockito.<String>any());
    doNothing().when(cookie).setValue(Mockito.<String>any());
    when(cookie.getName()).thenReturn("Name");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    CookieUtils.deleteCookie(request, response, "Name");

    // Assert that nothing has changed
    verify(cookie).getName();
    verify(cookie).setMaxAge(eq(0));
    verify(cookie).setPath(eq("/"));
    verify(cookie).setValue(eq(""));
    verify(request).getCookies();
    verify(response).addCookie(isA(Cookie.class));
  }

  /**
   * Test
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given empty array of {@link Cookie}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieUtils#deleteCookie(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test deleteCookie(HttpServletRequest, HttpServletResponse, String); given empty array of Cookie")
  void testDeleteCookie_givenEmptyArrayOfCookie() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{});

    // Act
    CookieUtils.deleteCookie(request, new Response(), "Name");

    // Assert that nothing has changed
    verify(request).getCookies();
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); given 'foo'; when HashMap() computeIfPresent 'foo' and BiFunction")
  void testSerialize_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Endpoint> endpoints = new HashMap<>();
    endpoints.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuU2VydmljZSIsImVuZHBvaW50cyI6eyJAY2xhc3MiOiJq"
            + "YXZhLnV0aWwuSGFzaE1hcCJ9LCJkZWZhdWx0cyI6bnVsbCwicGFydGl0aW9uV2lkZUVuZHBvaW50QXZhaWxhYmxlIjpmYWxzZSwi"
            + "cGFydGl0aW9uRW5kcG9pbnQiOm51bGwsImlzUmVnaW9uYWxpemVkIjpmYWxzZX0=",
        CookieUtils.serialize(new Service(endpoints)));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link Endpoint} (default constructor) Protocols is
   * {@link HashSet#HashSet()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); given HashSet(); when Endpoint (default constructor) Protocols is HashSet(); then return a string")
  void testSerialize_givenHashSet_whenEndpointProtocolsIsHashSet_thenReturnAString() {
    // Arrange
    Endpoint endpoint = new Endpoint();
    endpoint.setProtocols(new HashSet<>());

    // Act and Assert
    assertEquals("eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuRW5kcG9pbnQiLCJob3N0bmFtZSI6bnVsbCwiY3JlZGVu"
        + "dGlhbFNjb3BlIjpudWxsLCJwcm90b2NvbHMiOlsiamF2YS51dGlsLkhhc2hTZXQiLFtdXSwic2lnbmF0dXJlVmVyc2lvbnMiOm51"
        + "bGwsInNzbENvbW1vbk5hbWUiOm51bGx9", CookieUtils.serialize(endpoint));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Endpoint} (default constructor).</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Endpoint (default constructor); then return a string")
  void testSerialize_whenEndpoint_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuRW5kcG9pbnQiLCJob3N0bmFtZSI6bnVsbCwiY3JlZGV"
        + "udGlhbFNjb3BlIjpudWxsLCJwcm90b2NvbHMiOm51bGwsInNpZ25hdHVyZVZlcnNpb25zIjpudWxsLCJzc2xDb21tb25OYW1lIjpudWxsfQ"
        + "==", CookieUtils.serialize(new Endpoint()));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Ik9iamVjdCI=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when 'Object'; then return 'Ik9iamVjdCI='")
  void testSerialize_whenObject_thenReturnIk9iamVjdCI() {
    // Arrange, Act and Assert
    assertEquals("Ik9iamVjdCI=", CookieUtils.serialize("Object"));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MQ==}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when one; then return 'MQ=='")
  void testSerialize_whenOne_thenReturnMq() {
    // Arrange, Act and Assert
    assertEquals("MQ==", CookieUtils.serialize(1));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Service#Service(Map)} with endpoints is
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Service(Map) with endpoints is HashMap(); then return a string")
  void testSerialize_whenServiceWithEndpointsIsHashMap_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuU2VydmljZSIsImVuZHBvaW50cyI6eyJAY2xhc3MiOiJq"
            + "YXZhLnV0aWwuSGFzaE1hcCJ9LCJkZWZhdWx0cyI6bnVsbCwicGFydGl0aW9uV2lkZUVuZHBvaW50QXZhaWxhYmxlIjpmYWxzZSwi"
            + "cGFydGl0aW9uRW5kcG9pbnQiOm51bGwsImlzUmVnaW9uYWxpemVkIjpmYWxzZX0=",
        CookieUtils.serialize(new Service(new HashMap<>())));
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given empty string; when Cookie getValue() return empty string")
  void testDeserialize_givenEmptyString_whenCookieGetValueReturnEmptyString() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("");
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given empty string; when Cookie getValue() return empty string")
  void testDeserialize_givenEmptyString_whenCookieGetValueReturnEmptyString2() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("");
    Class<CookieUtils> cls = CookieUtils.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return {@code foo}.</li>
   *   <li>Then calls {@link Cookie#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given 'foo'; when Cookie getValue() return 'foo'; then calls getValue()")
  void testDeserialize_givenFoo_whenCookieGetValueReturnFoo_thenCallsGetValue() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("foo");
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>When {@link MockCookie#MockCookie(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); when MockCookie(String, String) with 'Name' and value is '42'")
  void testDeserialize_whenMockCookieWithNameAndValueIs42() {
    // Arrange
    MockCookie cookie = new MockCookie("Name", "42");

    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.service.security.auth.oauth2.CookieUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); when 'org.thingsboard.server.service.security.auth.oauth2.CookieUtils'")
  void testDeserialize_whenOrgThingsboardServerServiceSecurityAuthOauth2CookieUtils() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("foo");
    Class<CookieUtils> cls = CookieUtils.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }
}
