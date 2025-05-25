package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua_parser.Client;

@ContextConfiguration(classes = {RestAuthenticationDetails.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RestAuthenticationDetailsDiffblueTest {
  @MockBean
  private HttpServletRequest httpServletRequest;

  @Autowired
  private RestAuthenticationDetails restAuthenticationDetails;

  /**
   * Test {@link RestAuthenticationDetails#RestAuthenticationDetails(HttpServletRequest)}.
   * <ul>
   *   <li>Then return ClientAddress is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationDetails#RestAuthenticationDetails(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test new RestAuthenticationDetails(HttpServletRequest); then return ClientAddress is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestAuthenticationDetails.<init>(HttpServletRequest)"})
  void testNewRestAuthenticationDetails_thenReturnClientAddressIs42MainSt() {
    // Arrange
    when(httpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
    when(httpServletRequest.getHeader(Mockito.<String>any())).thenReturn(null);
    when(httpServletRequest.getRemoteAddr()).thenReturn("42 Main St");

    // Act
    RestAuthenticationDetails actualRestAuthenticationDetails = new RestAuthenticationDetails(httpServletRequest);

    // Assert
    verify(httpServletRequest, atLeast(1)).getRemoteAddr();
    verify(httpServletRequest, atLeast(1)).getHeader(Mockito.<String>any());
    assertEquals("42 Main St", actualRestAuthenticationDetails.getClientAddress());
    Client userAgent = actualRestAuthenticationDetails.getUserAgent();
    assertNull(userAgent.device);
    assertNull(userAgent.os);
    assertNull(userAgent.userAgent);
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}, and {@link RestAuthenticationDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestAuthenticationDetails#equals(Object)}
   *   <li>{@link RestAuthenticationDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(new MockHttpServletRequest());
    RestAuthenticationDetails restAuthenticationDetails2 = new RestAuthenticationDetails(new MockHttpServletRequest());

    // Act and Assert
    assertEquals(restAuthenticationDetails, restAuthenticationDetails2);
    int expectedHashCodeResult = restAuthenticationDetails.hashCode();
    assertEquals(expectedHashCodeResult, restAuthenticationDetails2.hashCode());
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}, and {@link RestAuthenticationDetails#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestAuthenticationDetails#equals(Object)}
   *   <li>{@link RestAuthenticationDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(new MockHttpServletRequest());

    // Act and Assert
    assertEquals(restAuthenticationDetails, restAuthenticationDetails);
    int expectedHashCodeResult = restAuthenticationDetails.hashCode();
    assertEquals(expectedHashCodeResult, restAuthenticationDetails.hashCode());
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getRemoteAddr()).thenReturn("42 Main St");
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(request);

    // Act and Assert
    assertNotEquals(restAuthenticationDetails, new RestAuthenticationDetails(new MockHttpServletRequest()));
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getRemoteAddr()).thenReturn("42 Main St");
    when(request.getHeader(Mockito.<String>any())).thenReturn("127.0.0.1");
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(request);

    // Act and Assert
    assertNotEquals(restAuthenticationDetails, new RestAuthenticationDetails(new MockHttpServletRequest()));
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RestAuthenticationDetails(new MockHttpServletRequest()), null);
  }

  /**
   * Test {@link RestAuthenticationDetails#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAuthenticationDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestAuthenticationDetails.equals(Object)", "int RestAuthenticationDetails.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RestAuthenticationDetails(new MockHttpServletRequest()),
        "Different type to RestAuthenticationDetails");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestAuthenticationDetails#toString()}
   *   <li>{@link RestAuthenticationDetails#getClientAddress()}
   *   <li>{@link RestAuthenticationDetails#getUserAgent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RestAuthenticationDetails.getClientAddress()",
      "Client RestAuthenticationDetails.getUserAgent()", "String RestAuthenticationDetails.toString()"})
  void testGettersAndSetters() {
    // Arrange
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(new MockHttpServletRequest());

    // Act
    restAuthenticationDetails.toString();
    restAuthenticationDetails.getClientAddress();
    Client actualUserAgent = restAuthenticationDetails.getUserAgent();

    // Assert
    assertNull(actualUserAgent.device);
    assertNull(actualUserAgent.os);
    assertNull(actualUserAgent.userAgent);
  }
}
