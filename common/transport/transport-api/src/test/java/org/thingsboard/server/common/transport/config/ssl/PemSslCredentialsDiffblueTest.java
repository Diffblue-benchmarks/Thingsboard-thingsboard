package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PemSslCredentialsDiffblueTest {
  /**
   * Test {@link PemSslCredentials#canUse()}.
   * <ul>
   *   <li>Given {@link PemSslCredentials} (default constructor) CertFile is
   * {@code Cert File}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#canUse()}
   */
  @Test
  @DisplayName("Test canUse(); given PemSslCredentials (default constructor) CertFile is 'Cert File'; then return 'false'")
  void testCanUse_givenPemSslCredentialsCertFileIsCertFile_thenReturnFalse() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    // Act and Assert
    assertFalse(pemSslCredentials.canUse());
  }

  /**
   * Test {@link PemSslCredentials#canUse()}.
   * <ul>
   *   <li>Given {@link PemSslCredentials} (default constructor) CertFile is
   * {@code classpath:}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#canUse()}
   */
  @Test
  @DisplayName("Test canUse(); given PemSslCredentials (default constructor) CertFile is 'classpath:'; then return 'true'")
  void testCanUse_givenPemSslCredentialsCertFileIsClasspath_thenReturnTrue() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertTrue(pemSslCredentials.canUse());
  }

  /**
   * Test {@link PemSslCredentials#loadKeyStore(boolean, char[])}.
   * <ul>
   *   <li>Given {@link PemSslCredentials} (default constructor) KeyFile is
   * {@code BC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  @DisplayName("Test loadKeyStore(boolean, char[]); given PemSslCredentials (default constructor) KeyFile is 'BC'")
  void testLoadKeyStore_givenPemSslCredentialsKeyFileIsBc() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("BC");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Test {@link PemSslCredentials#loadKeyStore(boolean, char[])}.
   * <ul>
   *   <li>Given {@link PemSslCredentials} (default constructor) KeyFile is
   * {@code classpath:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  @DisplayName("Test loadKeyStore(boolean, char[]); given PemSslCredentials (default constructor) KeyFile is 'classpath:'")
  void testLoadKeyStore_givenPemSslCredentialsKeyFileIsClasspath() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("classpath:");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Test {@link PemSslCredentials#loadKeyStore(boolean, char[])}.
   * <ul>
   *   <li>Given {@link PemSslCredentials} (default constructor) KeyFile is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  @DisplayName("Test loadKeyStore(boolean, char[]); given PemSslCredentials (default constructor) KeyFile is empty string")
  void testLoadKeyStore_givenPemSslCredentialsKeyFileIsEmptyString() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("");
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Test {@link PemSslCredentials#loadKeyStore(boolean, char[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#loadKeyStore(boolean, char[])}
   */
  @Test
  @DisplayName("Test loadKeyStore(boolean, char[]); then throw IllegalArgumentException")
  void testLoadKeyStore_thenThrowIllegalArgumentException() throws IOException, GeneralSecurityException {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("classpath:");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pemSslCredentials.loadKeyStore(true, "AZAZ".toCharArray()));
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}, and
   * {@link PemSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}, and
   * {@link PemSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setCertFile("Cert File");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}, and
   * {@link PemSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("Key File");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyFile("Key File");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}, and
   * {@link PemSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyPassword("iloveyou");

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials2);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials2.hashCode());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}, and
   * {@link PemSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PemSslCredentials#equals(Object)}
   *   <li>{@link PemSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    // Act and Assert
    assertEquals(pemSslCredentials, pemSslCredentials);
    int expectedHashCodeResult = pemSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, pemSslCredentials.hashCode());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), 1);
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setCertFile("Cert File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyFile("Key File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();
    pemSslCredentials.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(pemSslCredentials, new PemSslCredentials());
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setCertFile("Cert File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyFile("Key File");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PemSslCredentials pemSslCredentials = new PemSslCredentials();

    PemSslCredentials pemSslCredentials2 = new PemSslCredentials();
    pemSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(pemSslCredentials, pemSslCredentials2);
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), null);
  }

  /**
   * Test {@link PemSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PemSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PemSslCredentials(), "Different type to PemSslCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PemSslCredentials}
   *   <li>{@link PemSslCredentials#setCertFile(String)}
   *   <li>{@link PemSslCredentials#setKeyFile(String)}
   *   <li>{@link PemSslCredentials#setKeyPassword(String)}
   *   <li>{@link PemSslCredentials#updateKeyAlias(String)}
   *   <li>{@link PemSslCredentials#toString()}
   *   <li>{@link PemSslCredentials#getCertFile()}
   *   <li>{@link PemSslCredentials#getKeyAlias()}
   *   <li>{@link PemSslCredentials#getKeyFile()}
   *   <li>{@link PemSslCredentials#getKeyPassword()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    PemSslCredentials actualPemSslCredentials = new PemSslCredentials();
    actualPemSslCredentials.setCertFile("Cert File");
    actualPemSslCredentials.setKeyFile("Key File");
    actualPemSslCredentials.setKeyPassword("iloveyou");
    actualPemSslCredentials.updateKeyAlias("Key Alias");
    String actualToStringResult = actualPemSslCredentials.toString();
    String actualCertFile = actualPemSslCredentials.getCertFile();
    String actualKeyAlias = actualPemSslCredentials.getKeyAlias();
    String actualKeyFile = actualPemSslCredentials.getKeyFile();

    // Assert that nothing has changed
    assertEquals("Cert File", actualCertFile);
    assertEquals("Key File", actualKeyFile);
    assertEquals("PemSslCredentials(certFile=Cert File, keyFile=Key File, keyPassword=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPemSslCredentials.getKeyPassword());
    assertEquals("server", actualKeyAlias);
  }
}
