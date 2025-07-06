package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OAuth2ConfigurationDiffblueTest {
  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and {@link OAuth2Configuration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration2);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration2.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and {@link OAuth2Configuration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration2);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration2.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and {@link OAuth2Configuration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration2);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration2.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}, and {@link OAuth2Configuration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Configuration#equals(Object)}
   *   <li>{@link OAuth2Configuration#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();

    // Act and Assert
    assertEquals(oAuth2Configuration, oAuth2Configuration);
    int expectedHashCodeResult = oAuth2Configuration.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Configuration.hashCode());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Configuration(), 1);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, new OAuth2Configuration());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    oAuth2Configuration.setGithubMapper(new HashMap<>());

    // Act and Assert
    assertNotEquals(oAuth2Configuration, new OAuth2Configuration());
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setLoginProcessingUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();

    OAuth2Configuration oAuth2Configuration2 = new OAuth2Configuration();
    oAuth2Configuration2.setGithubMapper(new HashMap<>());

    // Act and Assert
    assertNotEquals(oAuth2Configuration, oAuth2Configuration2);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Configuration(), null);
  }

  /**
   * Test {@link OAuth2Configuration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Configuration#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean OAuth2Configuration.equals(Object)",
    "int OAuth2Configuration.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Configuration(), "Different type to OAuth2Configuration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Configuration#setGithubMapper(Map)}
   *   <li>{@link OAuth2Configuration#setLoginProcessingUrl(String)}
   *   <li>{@link OAuth2Configuration#toString()}
   *   <li>{@link OAuth2Configuration#getGithubMapper()}
   *   <li>{@link OAuth2Configuration#getLoginProcessingUrl()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Map OAuth2Configuration.getGithubMapper()",
    "String OAuth2Configuration.getLoginProcessingUrl()",
    "void OAuth2Configuration.setGithubMapper(Map)",
    "void OAuth2Configuration.setLoginProcessingUrl(String)",
    "String OAuth2Configuration.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    HashMap<String, String> githubMapper = new HashMap<>();

    // Act
    oAuth2Configuration.setGithubMapper(githubMapper);
    oAuth2Configuration.setLoginProcessingUrl("https://example.org/example");
    String actualToStringResult = oAuth2Configuration.toString();
    Map<String, String> actualGithubMapper = oAuth2Configuration.getGithubMapper();

    // Assert
    assertEquals(
        "OAuth2Configuration(loginProcessingUrl=https://example.org/example, githubMapper={})",
        actualToStringResult);
    assertEquals("https://example.org/example", oAuth2Configuration.getLoginProcessingUrl());
    assertTrue(actualGithubMapper.isEmpty());
    assertSame(githubMapper, actualGithubMapper);
  }
}
