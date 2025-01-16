package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class OAuth2ConfigurationDiffblueTest {
  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and
   * {@link OAuth2Configuration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration2);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration2.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and
   * {@link OAuth2Configuration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl(null);

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl(null);

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration2);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration2.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and
   * {@link OAuth2Configuration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, String> githubMapper = new HashMap<>();
    githubMapper.put("https://example.org/example", "https://example.org/example");

    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(githubMapper);
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> githubMapper = new HashMap<>();
    githubMapper.computeIfPresent("https://example.org/example", mock(BiFunction.class));
    githubMapper.put("https://example.org/example", "https://example.org/example");

    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(githubMapper);
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl("Login Processing Url");

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl(null);

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, null);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, "Different type to OAuth2Configuration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2Configuration#setGithubMapper(Map)}
   *   <li>{@link OAuth2Configuration#setLoginProcessingUrl(String)}
   *   <li>{@link OAuth2Configuration#toString()}
   *   <li>{@link OAuth2Configuration#getGithubMapper()}
   *   <li>{@link OAuth2Configuration#getLoginProcessingUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    HashMap<String, String> githubMapper = new HashMap<>();

    // Act
    oAuth2Configuration.setGithubMapper(githubMapper);
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");
    String actualToStringResult = oAuth2Configuration.toString();
    Map<String, String> actualGithubMapper = oAuth2Configuration.getGithubMapper();

    // Assert that nothing has changed
    assertEquals("OAuth2Configuration(loginProcessingUrl=https://example.org/example, githubMapper={})",
        actualToStringResult);
    assertEquals("https://example.org/example", oAuth2Configuration.getLoginProcessingUrl());
    assertTrue(actualGithubMapper.isEmpty());
    assertSame(githubMapper, actualGithubMapper);
  }
}
