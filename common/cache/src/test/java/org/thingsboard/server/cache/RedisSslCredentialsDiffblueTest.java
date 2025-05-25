package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedisSslCredentialsDiffblueTest {
  /**
   * Test {@link RedisSslCredentials#equals(Object)}, and {@link RedisSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}, and {@link RedisSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile(null);
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile(null);
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}, and {@link RedisSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile(null);
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile(null);
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}, and {@link RedisSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile(null);

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile(null);

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials2);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials2.hashCode());
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}, and {@link RedisSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#equals(Object)}
   *   <li>{@link RedisSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertEquals(redisSslCredentials, redisSslCredentials);
    int expectedHashCodeResult = redisSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, redisSslCredentials.hashCode());
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("User Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile(null);
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile(null);
    redisSslCredentials.setUserKeyFile("User Key File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("Cert File");

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile(null);

    RedisSslCredentials redisSslCredentials2 = new RedisSslCredentials();
    redisSslCredentials2.setCertFile("Cert File");
    redisSslCredentials2.setUserCertFile("User Cert File");
    redisSslCredentials2.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, redisSslCredentials2);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, null);
  }

  /**
   * Test {@link RedisSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RedisSslCredentials.equals(Object)", "int RedisSslCredentials.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act and Assert
    assertNotEquals(redisSslCredentials, "Different type to RedisSslCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RedisSslCredentials#setCertFile(String)}
   *   <li>{@link RedisSslCredentials#setUserCertFile(String)}
   *   <li>{@link RedisSslCredentials#setUserKeyFile(String)}
   *   <li>{@link RedisSslCredentials#toString()}
   *   <li>{@link RedisSslCredentials#getCertFile()}
   *   <li>{@link RedisSslCredentials#getUserCertFile()}
   *   <li>{@link RedisSslCredentials#getUserKeyFile()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RedisSslCredentials.getCertFile()", "String RedisSslCredentials.getUserCertFile()",
      "String RedisSslCredentials.getUserKeyFile()", "void RedisSslCredentials.setCertFile(String)",
      "void RedisSslCredentials.setUserCertFile(String)", "void RedisSslCredentials.setUserKeyFile(String)",
      "String RedisSslCredentials.toString()"})
  void testGettersAndSetters() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();

    // Act
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");
    String actualToStringResult = redisSslCredentials.toString();
    String actualCertFile = redisSslCredentials.getCertFile();
    String actualUserCertFile = redisSslCredentials.getUserCertFile();

    // Assert
    assertEquals("Cert File", actualCertFile);
    assertEquals("RedisSslCredentials(certFile=Cert File, userCertFile=User Cert File, userKeyFile=User Key File)",
        actualToStringResult);
    assertEquals("User Cert File", actualUserCertFile);
    assertEquals("User Key File", redisSslCredentials.getUserKeyFile());
  }
}
