package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;

class MobileAppOauth2ClientDiffblueTest {
  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}, and
   * {@link MobileAppOauth2Client#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
    int expectedHashCodeResult = mobileAppOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2Client2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}, and
   * {@link MobileAppOauth2Client#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client);
    int expectedHashCodeResult = mobileAppOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2Client.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), 1);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client(mock(MobileAppId.class), null);

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client
        .setOAuth2ClientId(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setMobileAppId(new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2
        .setOAuth2ClientId(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), null);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), "Different type to MobileAppOauth2Client");
  }
}
