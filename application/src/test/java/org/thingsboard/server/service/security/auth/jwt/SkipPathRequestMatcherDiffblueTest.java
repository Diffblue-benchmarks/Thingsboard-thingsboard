package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {String.class})
@ExtendWith(SpringExtension.class)
class SkipPathRequestMatcherDiffblueTest {
  @Autowired
  private List<String> list;

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SkipPathRequestMatcher.<init>(List, String)"})
  void testNewSkipPathRequestMatcher_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("42");
    pathsToSkip.add("foo");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");

    // Assert
    assertFalse(actualSkipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return matches {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); given 'foo'; then return matches MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SkipPathRequestMatcher.<init>(List, String)"})
  void testNewSkipPathRequestMatcher_givenFoo_thenReturnMatchesMockHttpServletRequest() {
    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "/**");

    // Assert
    assertTrue(actualSkipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Then return not matches {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); then return not matches MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SkipPathRequestMatcher.<init>(List, String)"})
  void testNewSkipPathRequestMatcher_thenReturnNotMatchesMockHttpServletRequest() {
    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");

    // Assert
    assertFalse(actualSkipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }

  /**
   * Test {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}.
   * <ul>
   *   <li>Then return not matches {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#SkipPathRequestMatcher(List, String)}
   */
  @Test
  @DisplayName("Test new SkipPathRequestMatcher(List, String); then return not matches MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SkipPathRequestMatcher.<init>(List, String)"})
  void testNewSkipPathRequestMatcher_thenReturnNotMatchesMockHttpServletRequest2() {
    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("/**");

    // Act
    SkipPathRequestMatcher actualSkipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "not blank");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SkipPathRequestMatcher.matches(HttpServletRequest)"})
  void testMatches_givenArrayListAddFoo_whenMockHttpServletRequest_thenReturnFalse() {
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
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkipPathRequestMatcher#matches(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test matches(HttpServletRequest); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SkipPathRequestMatcher.matches(HttpServletRequest)"})
  void testMatches_thenReturnTrue() {
    // Arrange
    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    SkipPathRequestMatcher skipPathRequestMatcher = new SkipPathRequestMatcher(pathsToSkip, "/**");

    // Act and Assert
    assertTrue(skipPathRequestMatcher.matches(new MockHttpServletRequest()));
  }
}
