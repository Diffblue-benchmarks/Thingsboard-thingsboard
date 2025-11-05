package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AbstractSslCredentialsDiffblueTest {
  @Mock private KeyStore keyStore;

  @InjectMocks private KeystoreSslCredentials keystoreSslCredentials;

  /**
   * Test {@link AbstractSslCredentials#getKeyStore()}.
   *
   * <p>Method under test: {@link AbstractSslCredentials#getKeyStore()}
   */
  @Test
  @DisplayName("Test getKeyStore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyStore AbstractSslCredentials.getKeyStore()"})
  void testGetKeyStore() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getKeyStore());
  }

  /**
   * Test {@link AbstractSslCredentials#getPrivateKey()}.
   *
   * <p>Method under test: {@link AbstractSslCredentials#getPrivateKey()}
   */
  @Test
  @DisplayName("Test getPrivateKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PrivateKey AbstractSslCredentials.getPrivateKey()"})
  void testGetPrivateKey() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getPrivateKey());
  }

  /**
   * Test {@link AbstractSslCredentials#getPublicKey()}.
   *
   * <p>Method under test: {@link AbstractSslCredentials#getPublicKey()}
   */
  @Test
  @DisplayName("Test getPublicKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.security.PublicKey AbstractSslCredentials.getPublicKey()"})
  void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getPublicKey());
  }

  /**
   * Test {@link AbstractSslCredentials#getCertificateChain()}.
   *
   * <p>Method under test: {@link AbstractSslCredentials#getCertificateChain()}
   */
  @Test
  @DisplayName("Test getCertificateChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.security.cert.X509Certificate[] AbstractSslCredentials.getCertificateChain()"
  })
  void testGetCertificateChain() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getCertificateChain());
  }

  /**
   * Test {@link AbstractSslCredentials#getTrustedCertificates()}.
   *
   * <p>Method under test: {@link AbstractSslCredentials#getTrustedCertificates()}
   */
  @Test
  @DisplayName("Test getTrustedCertificates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.security.cert.X509Certificate[] AbstractSslCredentials.getTrustedCertificates()"
  })
  void testGetTrustedCertificates() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getTrustedCertificates());
  }

  /**
   * Test {@link AbstractSslCredentials#createTrustManagerFactory()}.
   *
   * <ul>
   *   <li>Then return Provider size is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#createTrustManagerFactory()}
   */
  @Test
  @DisplayName("Test createTrustManagerFactory(); then return Provider size is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrustManagerFactory AbstractSslCredentials.createTrustManagerFactory()"})
  void testCreateTrustManagerFactory_thenReturnProviderSizeIsTwentyFive()
      throws KeyStoreException, NoSuchAlgorithmException {
    // Arrange and Act
    TrustManagerFactory actualCreateTrustManagerFactoryResult =
        new KeystoreSslCredentials().createTrustManagerFactory();

    // Assert
    Provider provider = actualCreateTrustManagerFactoryResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", actualCreateTrustManagerFactoryResult.getAlgorithm());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals(
        "sun.security.ssl.KeyManagerFactoryImpl$X509",
        provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    assertEquals(1, actualCreateTrustManagerFactoryResult.getTrustManagers().length);
  }

  /**
   * Test {@link AbstractSslCredentials#createTrustManagerFactory()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#createTrustManagerFactory()}
   */
  @Test
  @DisplayName("Test createTrustManagerFactory(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TrustManagerFactory AbstractSslCredentials.createTrustManagerFactory()"})
  void testCreateTrustManagerFactory_thenThrowIllegalArgumentException()
      throws KeyStoreException, NoSuchAlgorithmException {
    // Arrange
    when(keyStore.aliases()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> keystoreSslCredentials.createTrustManagerFactory());
    verify(keyStore).aliases();
  }

  /**
   * Test {@link AbstractSslCredentials#createKeyManagerFactory()}.
   *
   * <ul>
   *   <li>Then return Provider size is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#createKeyManagerFactory()}
   */
  @Test
  @DisplayName("Test createKeyManagerFactory(); then return Provider size is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyManagerFactory AbstractSslCredentials.createKeyManagerFactory()"})
  void testCreateKeyManagerFactory_thenReturnProviderSizeIsTwentyFive()
      throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
    // Arrange and Act
    KeyManagerFactory actualCreateKeyManagerFactoryResult =
        new KeystoreSslCredentials().createKeyManagerFactory();

    // Assert
    Provider provider = actualCreateKeyManagerFactoryResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("SunX509", actualCreateKeyManagerFactoryResult.getAlgorithm());
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals(
        "sun.security.ssl.KeyManagerFactoryImpl$X509",
        provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    assertEquals(1, actualCreateKeyManagerFactoryResult.getKeyManagers().length);
  }

  /**
   * Test {@link AbstractSslCredentials#createKeyManagerFactory()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#createKeyManagerFactory()}
   */
  @Test
  @DisplayName("Test createKeyManagerFactory(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyManagerFactory AbstractSslCredentials.createKeyManagerFactory()"})
  void testCreateKeyManagerFactory_thenThrowIllegalArgumentException()
      throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
    // Arrange
    when(keyStore.aliases()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> keystoreSslCredentials.createKeyManagerFactory());
    verify(keyStore).aliases();
  }

  /**
   * Test {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String,
   * String)}
   */
  @Test
  @DisplayName("Test getValueFromSubjectNameByKey(String, String); when ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractSslCredentials.getValueFromSubjectNameByKey(String, String)"})
  void testGetValueFromSubjectNameByKey_whenComma() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getValueFromSubjectNameByKey(",", "Key"));
  }

  /**
   * Test {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}.
   *
   * <ul>
   *   <li>When {@code foo,bar}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String,
   * String)}
   */
  @Test
  @DisplayName("Test getValueFromSubjectNameByKey(String, String); when 'foo,bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractSslCredentials.getValueFromSubjectNameByKey(String, String)"})
  void testGetValueFromSubjectNameByKey_whenFooBar() {
    // Arrange, Act and Assert
    assertNull(new KeystoreSslCredentials().getValueFromSubjectNameByKey("foo,bar", "Key"));
  }

  /**
   * Test {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}.
   *
   * <ul>
   *   <li>When {@code Hello from the Dreaming Spires}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromSubjectNameByKey(String, String); when 'Hello from the Dreaming Spires'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractSslCredentials.getValueFromSubjectNameByKey(String, String)"})
  void testGetValueFromSubjectNameByKey_whenHelloFromTheDreamingSpires() {
    // Arrange, Act and Assert
    assertNull(
        new KeystoreSslCredentials()
            .getValueFromSubjectNameByKey("Hello from the Dreaming Spires", "Key"));
  }
}
