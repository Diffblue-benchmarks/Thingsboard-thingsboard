package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KeystoreSslCredentialsDiffblueTest {
  /**
   * Test {@link KeystoreSslCredentials#canUse()}.
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StoreFile is
   * {@code classpath:}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#canUse()}
   */
  @Test
  @DisplayName("Test canUse(); given KeystoreSslCredentials (default constructor) StoreFile is 'classpath:'; then return 'true'")
  void testCanUse_givenKeystoreSslCredentialsStoreFileIsClasspath_thenReturnTrue() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("classpath:");

    // Act and Assert
    assertTrue(keystoreSslCredentials.canUse());
  }

  /**
   * Test {@link KeystoreSslCredentials#canUse()}.
   * <ul>
   *   <li>Given {@link KeystoreSslCredentials} (default constructor) StoreFile is
   * {@code Store File}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#canUse()}
   */
  @Test
  @DisplayName("Test canUse(); given KeystoreSslCredentials (default constructor) StoreFile is 'Store File'; then return 'false'")
  void testCanUse_givenKeystoreSslCredentialsStoreFileIsStoreFile_thenReturnFalse() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    // Act and Assert
    assertFalse(keystoreSslCredentials.canUse());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.updateKeyAlias("Key Alias");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.updateKeyAlias("Key Alias");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setType("Type");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setType("Type");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStoreFile("Store File");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStorePassword("iloveyou");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStorePassword("iloveyou");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setKeyPassword("iloveyou");

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials2);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials2.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}, and
   * {@link KeystoreSslCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeystoreSslCredentials#equals(Object)}
   *   <li>{@link KeystoreSslCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    // Act and Assert
    assertEquals(keystoreSslCredentials, keystoreSslCredentials);
    int expectedHashCodeResult = keystoreSslCredentials.hashCode();
    assertEquals(expectedHashCodeResult, keystoreSslCredentials.hashCode());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), 1);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.updateKeyAlias("Key Alias");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setType("Type");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStoreFile("Store File");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();
    keystoreSslCredentials.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, new KeystoreSslCredentials());
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.updateKeyAlias("Key Alias");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setType("Type");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStoreFile("Store File");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setStorePassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = new KeystoreSslCredentials();

    KeystoreSslCredentials keystoreSslCredentials2 = new KeystoreSslCredentials();
    keystoreSslCredentials2.setKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(keystoreSslCredentials, keystoreSslCredentials2);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), null);
  }

  /**
   * Test {@link KeystoreSslCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeystoreSslCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeystoreSslCredentials(), "Different type to KeystoreSslCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KeystoreSslCredentials}
   *   <li>{@link KeystoreSslCredentials#setKeyAlias(String)}
   *   <li>{@link KeystoreSslCredentials#setKeyPassword(String)}
   *   <li>{@link KeystoreSslCredentials#setStoreFile(String)}
   *   <li>{@link KeystoreSslCredentials#setStorePassword(String)}
   *   <li>{@link KeystoreSslCredentials#setType(String)}
   *   <li>{@link KeystoreSslCredentials#updateKeyAlias(String)}
   *   <li>{@link KeystoreSslCredentials#toString()}
   *   <li>{@link KeystoreSslCredentials#getKeyAlias()}
   *   <li>{@link KeystoreSslCredentials#getKeyPassword()}
   *   <li>{@link KeystoreSslCredentials#getStoreFile()}
   *   <li>{@link KeystoreSslCredentials#getStorePassword()}
   *   <li>{@link KeystoreSslCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    KeystoreSslCredentials actualKeystoreSslCredentials = new KeystoreSslCredentials();
    actualKeystoreSslCredentials.setKeyAlias("Key Alias");
    actualKeystoreSslCredentials.setKeyPassword("iloveyou");
    actualKeystoreSslCredentials.setStoreFile("Store File");
    actualKeystoreSslCredentials.setStorePassword("iloveyou");
    actualKeystoreSslCredentials.setType("Type");
    actualKeystoreSslCredentials.updateKeyAlias("Key Alias");
    String actualToStringResult = actualKeystoreSslCredentials.toString();
    String actualKeyAlias = actualKeystoreSslCredentials.getKeyAlias();
    String actualKeyPassword = actualKeystoreSslCredentials.getKeyPassword();
    String actualStoreFile = actualKeystoreSslCredentials.getStoreFile();
    String actualStorePassword = actualKeystoreSslCredentials.getStorePassword();

    // Assert that nothing has changed
    assertEquals("Key Alias", actualKeyAlias);
    assertEquals("KeystoreSslCredentials(type=Type, storeFile=Store File, storePassword=iloveyou, keyPassword=iloveyou,"
        + " keyAlias=Key Alias)", actualToStringResult);
    assertEquals("Store File", actualStoreFile);
    assertEquals("Type", actualKeystoreSslCredentials.getType());
    assertEquals("iloveyou", actualKeyPassword);
    assertEquals("iloveyou", actualStorePassword);
  }
}
