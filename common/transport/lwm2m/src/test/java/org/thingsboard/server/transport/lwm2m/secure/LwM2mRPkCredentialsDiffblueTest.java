package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mRPkCredentialsDiffblueTest {
  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then return not ServerPrivateKey Destroyed.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then return not ServerPrivateKey Destroyed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenReturnNotServerPrivateKeyDestroyed() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, "Publ Y", "EC");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
    assertFalse(actualLwM2mRPkCredentials.getServerPrivateKey().isDestroyed());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "Publ Y", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code EC}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'EC'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEc_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("EC", "EC", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when empty string; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEmptyString_thenReturnServerPrivateKeyIsNull() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("", "", "");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when empty string; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEmptyString_thenReturnServerPrivateKeyIsNull2() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials("", "", null);

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ServerPrivateKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when empty string; then return ServerPrivateKey is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenEmptyString_thenReturnServerPrivateKeyIsNull3() {
    // Arrange and Act
    LwM2mRPkCredentials actualLwM2mRPkCredentials = new LwM2mRPkCredentials(null, "", "");

    // Assert
    assertNull(actualLwM2mRPkCredentials.getServerPrivateKey());
    assertNull(actualLwM2mRPkCredentials.getServerPublicKey());
    assertNull(actualLwM2mRPkCredentials.getCertificate());
    assertNull(actualLwM2mRPkCredentials.getTrustStore());
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials(null, "Publ Y", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new LwM2mRPkCredentials("Publ X", "Publ Y", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("Publ X", null, "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Publ X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'Publ X'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenPublX_thenThrowRuntimeException3() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LwM2mRPkCredentials("Publ X", "", "Priv S"));
  }

  /**
   * Test {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code secp256r1}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mRPkCredentials#LwM2mRPkCredentials(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mRPkCredentials(String, String, String); when 'secp256r1'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mRPkCredentials.<init>(String, String, String)"})
  void testNewLwM2mRPkCredentials_whenSecp256r1_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new LwM2mRPkCredentials("secp256r1", "Publ Y", "Priv S"));
  }
}
