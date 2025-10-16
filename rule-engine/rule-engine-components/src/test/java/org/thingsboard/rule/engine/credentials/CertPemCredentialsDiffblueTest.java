/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.KeyStore;
import java.security.Provider;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.mqtt.azure.AzureIotHubSasCredentials;

class CertPemCredentialsDiffblueTest {
  /**
   * Test {@link CertPemCredentials#createAndInitTrustManagerFactory()}.
   *
   * <ul>
   *   <li>Then return Provider size is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#createAndInitTrustManagerFactory()}
   */
  @Test
  @DisplayName("Test createAndInitTrustManagerFactory(); then return Provider size is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrustManagerFactory CertPemCredentials.createAndInitTrustManagerFactory()"})
  void testCreateAndInitTrustManagerFactory_thenReturnProviderSizeIsTwentyFive() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCaCert("Ca Cert");

    // Act
    TrustManagerFactory actualCreateAndInitTrustManagerFactoryResult =
        certPemCredentials.createAndInitTrustManagerFactory();

    // Assert
    Provider provider = actualCreateAndInitTrustManagerFactoryResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", actualCreateAndInitTrustManagerFactoryResult.getAlgorithm());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals(
        "sun.security.ssl.KeyManagerFactoryImpl$X509",
        provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    assertEquals(1, actualCreateAndInitTrustManagerFactoryResult.getTrustManagers().length);
  }

  /**
   * Test {@link CertPemCredentials#loadKeyStore()}.
   *
   * <ul>
   *   <li>Given {@link CertPemCredentials} (default constructor) Password is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#loadKeyStore()}
   */
  @Test
  @DisplayName(
      "Test loadKeyStore(); given CertPemCredentials (default constructor) Password is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore CertPemCredentials.loadKeyStore()"})
  void testLoadKeyStore_givenCertPemCredentialsPasswordIsEmptyString() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPassword("");
    certPemCredentials.setPrivateKey("Private Key");
    certPemCredentials.setCert("Cert");

    // Act
    KeyStore actualLoadKeyStoreResult = certPemCredentials.loadKeyStore();

    // Assert
    Provider provider = actualLoadKeyStoreResult.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("pkcs12", actualLoadKeyStoreResult.getType());
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(0, actualLoadKeyStoreResult.size());
  }

  /**
   * Test {@link CertPemCredentials#loadKeyStore()}.
   *
   * <ul>
   *   <li>Given {@link CertPemCredentials} (default constructor) Password is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#loadKeyStore()}
   */
  @Test
  @DisplayName(
      "Test loadKeyStore(); given CertPemCredentials (default constructor) Password is 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore CertPemCredentials.loadKeyStore()"})
  void testLoadKeyStore_givenCertPemCredentialsPasswordIsIloveyou() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPassword("iloveyou");
    certPemCredentials.setPrivateKey("Private Key");
    certPemCredentials.setCert("Cert");

    // Act
    KeyStore actualLoadKeyStoreResult = certPemCredentials.loadKeyStore();

    // Assert
    Provider provider = actualLoadKeyStoreResult.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("pkcs12", actualLoadKeyStoreResult.getType());
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(0, actualLoadKeyStoreResult.size());
  }

  /**
   * Test {@link CertPemCredentials#loadKeyStore()}.
   *
   * <ul>
   *   <li>Given {@link CertPemCredentials} (default constructor) PrivateKey is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#loadKeyStore()}
   */
  @Test
  @DisplayName(
      "Test loadKeyStore(); given CertPemCredentials (default constructor) PrivateKey is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore CertPemCredentials.loadKeyStore()"})
  void testLoadKeyStore_givenCertPemCredentialsPrivateKeyIsEmptyString() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPrivateKey("");
    certPemCredentials.setCert("Cert");

    // Act
    KeyStore actualLoadKeyStoreResult = certPemCredentials.loadKeyStore();

    // Assert
    Provider provider = actualLoadKeyStoreResult.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("pkcs12", actualLoadKeyStoreResult.getType());
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(0, actualLoadKeyStoreResult.size());
  }

  /**
   * Test {@link CertPemCredentials#loadKeyStore()}.
   *
   * <ul>
   *   <li>Given {@link CertPemCredentials} (default constructor) PrivateKey is {@code Private Key}.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#loadKeyStore()}
   */
  @Test
  @DisplayName(
      "Test loadKeyStore(); given CertPemCredentials (default constructor) PrivateKey is 'Private Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore CertPemCredentials.loadKeyStore()"})
  void testLoadKeyStore_givenCertPemCredentialsPrivateKeyIsPrivateKey() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPrivateKey("Private Key");
    certPemCredentials.setCert("Cert");

    // Act
    KeyStore actualLoadKeyStoreResult = certPemCredentials.loadKeyStore();

    // Assert
    Provider provider = actualLoadKeyStoreResult.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("pkcs12", actualLoadKeyStoreResult.getType());
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(0, actualLoadKeyStoreResult.size());
  }

  /**
   * Test {@link CertPemCredentials#loadKeyStore()}.
   *
   * <ul>
   *   <li>Then return Provider size is one hundred ninety-four.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#loadKeyStore()}
   */
  @Test
  @DisplayName("Test loadKeyStore(); then return Provider size is one hundred ninety-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore CertPemCredentials.loadKeyStore()"})
  void testLoadKeyStore_thenReturnProviderSizeIsOneHundredNinetyFour() throws Exception {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCert("Cert");

    // Act
    KeyStore actualLoadKeyStoreResult = certPemCredentials.loadKeyStore();

    // Assert
    Provider provider = actualLoadKeyStoreResult.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("pkcs12", actualLoadKeyStoreResult.getType());
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(0, actualLoadKeyStoreResult.size());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    CertPemCredentials certPemCredentials2 = new CertPemCredentials();

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials2);
    assertEquals(certPemCredentials.hashCode(), certPemCredentials2.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCaCert("Ca Cert");

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setCaCert("Ca Cert");

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials2);
    assertEquals(certPemCredentials.hashCode(), certPemCredentials2.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCert("Cert");

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setCert("Cert");

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials2);
    assertEquals(certPemCredentials.hashCode(), certPemCredentials2.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPrivateKey("Private Key");

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setPrivateKey("Private Key");

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials2);
    assertEquals(certPemCredentials.hashCode(), certPemCredentials2.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPassword("iloveyou");

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials2);
    assertEquals(certPemCredentials.hashCode(), certPemCredentials2.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}, and {@link CertPemCredentials#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CertPemCredentials#equals(Object)}
   *   <li>{@link CertPemCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    // Act and Assert
    assertEquals(certPemCredentials, certPemCredentials);
    int expectedHashCodeResult = certPemCredentials.hashCode();
    assertEquals(expectedHashCodeResult, certPemCredentials.hashCode());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AzureIotHubSasCredentials azureIotHubSasCredentials = new AzureIotHubSasCredentials();

    // Act and Assert
    assertNotEquals(azureIotHubSasCredentials, new CertPemCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    // Act and Assert
    assertNotEquals(certPemCredentials, new AzureIotHubSasCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCaCert("Ca Cert");

    // Act and Assert
    assertNotEquals(certPemCredentials, new CertPemCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setCert("Cert");

    // Act and Assert
    assertNotEquals(certPemCredentials, new CertPemCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(certPemCredentials, new CertPemCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();
    certPemCredentials.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(certPemCredentials, new CertPemCredentials());
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setCaCert("Ca Cert");

    // Act and Assert
    assertNotEquals(certPemCredentials, certPemCredentials2);
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setCert("Cert");

    // Act and Assert
    assertNotEquals(certPemCredentials, certPemCredentials2);
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(certPemCredentials, certPemCredentials2);
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CertPemCredentials certPemCredentials = new CertPemCredentials();

    CertPemCredentials certPemCredentials2 = new CertPemCredentials();
    certPemCredentials2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(certPemCredentials, certPemCredentials2);
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CertPemCredentials(), null);
  }

  /**
   * Test {@link CertPemCredentials#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CertPemCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CertPemCredentials.equals(Object)",
    "int CertPemCredentials.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CertPemCredentials(), "Different type to CertPemCredentials");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CertPemCredentials}
   *   <li>{@link CertPemCredentials#setCaCert(String)}
   *   <li>{@link CertPemCredentials#setCert(String)}
   *   <li>{@link CertPemCredentials#setPassword(String)}
   *   <li>{@link CertPemCredentials#setPrivateKey(String)}
   *   <li>{@link CertPemCredentials#toString()}
   *   <li>{@link CertPemCredentials#getCaCert()}
   *   <li>{@link CertPemCredentials#getCert()}
   *   <li>{@link CertPemCredentials#getPassword()}
   *   <li>{@link CertPemCredentials#getPrivateKey()}
   *   <li>{@link CertPemCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CertPemCredentials.<init>()",
    "String CertPemCredentials.getCaCert()",
    "String CertPemCredentials.getCert()",
    "String CertPemCredentials.getPassword()",
    "String CertPemCredentials.getPrivateKey()",
    "CredentialsType CertPemCredentials.getType()",
    "void CertPemCredentials.setCaCert(String)",
    "void CertPemCredentials.setCert(String)",
    "void CertPemCredentials.setPassword(String)",
    "void CertPemCredentials.setPrivateKey(String)",
    "String CertPemCredentials.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CertPemCredentials actualCertPemCredentials = new CertPemCredentials();
    actualCertPemCredentials.setCaCert("Ca Cert");
    actualCertPemCredentials.setCert("Cert");
    actualCertPemCredentials.setPassword("iloveyou");
    actualCertPemCredentials.setPrivateKey("Private Key");
    String actualToStringResult = actualCertPemCredentials.toString();
    String actualCaCert = actualCertPemCredentials.getCaCert();
    String actualCert = actualCertPemCredentials.getCert();
    String actualPassword = actualCertPemCredentials.getPassword();
    String actualPrivateKey = actualCertPemCredentials.getPrivateKey();

    // Assert
    assertEquals("Ca Cert", actualCaCert);
    assertEquals("Cert", actualCert);
    assertEquals(
        "CertPemCredentials(caCert=Ca Cert, cert=Cert, privateKey=Private Key, password=iloveyou)",
        actualToStringResult);
    assertEquals("Private Key", actualPrivateKey);
    assertEquals("iloveyou", actualPassword);
    assertEquals(CredentialsType.CERT_PEM, actualCertPemCredentials.getType());
  }
}
