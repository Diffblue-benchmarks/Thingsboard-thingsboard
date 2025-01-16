package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OAuth2ClientLoginInfoDiffblueTest {
  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}, and
   * {@link OAuth2ClientLoginInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#equals(Object)}
   *   <li>{@link OAuth2ClientLoginInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon",
        "https://example.org/example");
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo2 = new OAuth2ClientLoginInfo("Name", "Icon",
        "https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2ClientLoginInfo, oAuth2ClientLoginInfo2);
    int expectedHashCodeResult = oAuth2ClientLoginInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientLoginInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}, and
   * {@link OAuth2ClientLoginInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#equals(Object)}
   *   <li>{@link OAuth2ClientLoginInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo(null, "Icon",
        "https://example.org/example");
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo2 = new OAuth2ClientLoginInfo(null, "Icon",
        "https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2ClientLoginInfo, oAuth2ClientLoginInfo2);
    int expectedHashCodeResult = oAuth2ClientLoginInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientLoginInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}, and
   * {@link OAuth2ClientLoginInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#equals(Object)}
   *   <li>{@link OAuth2ClientLoginInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", null,
        "https://example.org/example");
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo2 = new OAuth2ClientLoginInfo("Name", null,
        "https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2ClientLoginInfo, oAuth2ClientLoginInfo2);
    int expectedHashCodeResult = oAuth2ClientLoginInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientLoginInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}, and
   * {@link OAuth2ClientLoginInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#equals(Object)}
   *   <li>{@link OAuth2ClientLoginInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon", null);
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo2 = new OAuth2ClientLoginInfo("Name", "Icon", null);

    // Act and Assert
    assertEquals(oAuth2ClientLoginInfo, oAuth2ClientLoginInfo2);
    int expectedHashCodeResult = oAuth2ClientLoginInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientLoginInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}, and
   * {@link OAuth2ClientLoginInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#equals(Object)}
   *   <li>{@link OAuth2ClientLoginInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon",
        "https://example.org/example");

    // Act and Assert
    assertEquals(oAuth2ClientLoginInfo, oAuth2ClientLoginInfo);
    int expectedHashCodeResult = oAuth2ClientLoginInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientLoginInfo.hashCode());
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Icon", "Icon",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo(null, "Icon",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Name",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", null,
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon", "Name");

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientLoginInfo oAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon", null);

    // Act and Assert
    assertNotEquals(oAuth2ClientLoginInfo, new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"));
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"), null);
  }

  /**
   * Test {@link OAuth2ClientLoginInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientLoginInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientLoginInfo("Name", "Icon", "https://example.org/example"),
        "Different type to OAuth2ClientLoginInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientLoginInfo#OAuth2ClientLoginInfo()}
   *   <li>{@link OAuth2ClientLoginInfo#setIcon(String)}
   *   <li>{@link OAuth2ClientLoginInfo#setName(String)}
   *   <li>{@link OAuth2ClientLoginInfo#setUrl(String)}
   *   <li>{@link OAuth2ClientLoginInfo#toString()}
   *   <li>{@link OAuth2ClientLoginInfo#getIcon()}
   *   <li>{@link OAuth2ClientLoginInfo#getName()}
   *   <li>{@link OAuth2ClientLoginInfo#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientLoginInfo actualOAuth2ClientLoginInfo = new OAuth2ClientLoginInfo();
    actualOAuth2ClientLoginInfo.setIcon("Icon");
    actualOAuth2ClientLoginInfo.setName("Name");
    actualOAuth2ClientLoginInfo.setUrl("https://example.org/example");
    String actualToStringResult = actualOAuth2ClientLoginInfo.toString();
    String actualIcon = actualOAuth2ClientLoginInfo.getIcon();
    String actualName = actualOAuth2ClientLoginInfo.getName();

    // Assert that nothing has changed
    assertEquals("Icon", actualIcon);
    assertEquals("Name", actualName);
    assertEquals("OAuth2ClientLoginInfo(name=Name, icon=Icon, url=https://example.org/example)", actualToStringResult);
    assertEquals("https://example.org/example", actualOAuth2ClientLoginInfo.getUrl());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OAuth2ClientLoginInfo#OAuth2ClientLoginInfo(String, String, String)}
   *   <li>{@link OAuth2ClientLoginInfo#setIcon(String)}
   *   <li>{@link OAuth2ClientLoginInfo#setName(String)}
   *   <li>{@link OAuth2ClientLoginInfo#setUrl(String)}
   *   <li>{@link OAuth2ClientLoginInfo#toString()}
   *   <li>{@link OAuth2ClientLoginInfo#getIcon()}
   *   <li>{@link OAuth2ClientLoginInfo#getName()}
   *   <li>{@link OAuth2ClientLoginInfo#getUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    OAuth2ClientLoginInfo actualOAuth2ClientLoginInfo = new OAuth2ClientLoginInfo("Name", "Icon",
        "https://example.org/example");
    actualOAuth2ClientLoginInfo.setIcon("Icon");
    actualOAuth2ClientLoginInfo.setName("Name");
    actualOAuth2ClientLoginInfo.setUrl("https://example.org/example");
    String actualToStringResult = actualOAuth2ClientLoginInfo.toString();
    String actualIcon = actualOAuth2ClientLoginInfo.getIcon();
    String actualName = actualOAuth2ClientLoginInfo.getName();

    // Assert that nothing has changed
    assertEquals("Icon", actualIcon);
    assertEquals("Name", actualName);
    assertEquals("OAuth2ClientLoginInfo(name=Name, icon=Icon, url=https://example.org/example)", actualToStringResult);
    assertEquals("https://example.org/example", actualOAuth2ClientLoginInfo.getUrl());
  }
}
