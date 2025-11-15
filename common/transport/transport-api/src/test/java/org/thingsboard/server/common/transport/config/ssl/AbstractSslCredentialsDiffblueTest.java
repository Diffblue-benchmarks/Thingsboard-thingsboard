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
package org.thingsboard.server.common.transport.config.ssl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractSslCredentialsDiffblueTest {
  /**
   * Test {@link AbstractSslCredentials#getKeyStore()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#getKeyStore()}
   */
  @Test
  @DisplayName("Test getKeyStore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.KeyStore AbstractSslCredentials.getKeyStore()"})
  void testGetKeyStore() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getKeyStore());
  }

  /**
   * Test {@link AbstractSslCredentials#getPrivateKey()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#getPrivateKey()}
   */
  @Test
  @DisplayName("Test getPrivateKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PrivateKey AbstractSslCredentials.getPrivateKey()"})
  void testGetPrivateKey() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getPrivateKey());
  }

  /**
   * Test {@link AbstractSslCredentials#getPublicKey()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#getPublicKey()}
   */
  @Test
  @DisplayName("Test getPublicKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.PublicKey AbstractSslCredentials.getPublicKey()"})
  void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getPublicKey());
  }

  /**
   * Test {@link AbstractSslCredentials#getCertificateChain()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#getCertificateChain()}
   */
  @Test
  @DisplayName("Test getCertificateChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.cert.X509Certificate[] AbstractSslCredentials.getCertificateChain()"})
  void testGetCertificateChain() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getCertificateChain());
  }

  /**
   * Test {@link AbstractSslCredentials#getTrustedCertificates()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#getTrustedCertificates()}
   */
  @Test
  @DisplayName("Test getTrustedCertificates()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.security.cert.X509Certificate[] AbstractSslCredentials.getTrustedCertificates()"})
  void testGetTrustedCertificates() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getTrustedCertificates());
  }

  /**
   * Test {@link AbstractSslCredentials#createTrustManagerFactory()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#createTrustManagerFactory()}
   */
  @Test
  @DisplayName("Test createTrustManagerFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TrustManagerFactory AbstractSslCredentials.createTrustManagerFactory()"})
  void testCreateTrustManagerFactory() throws KeyStoreException, NoSuchAlgorithmException {
    // Arrange and Act
    TrustManagerFactory actualCreateTrustManagerFactoryResult = (new KeystoreSslCredentials())
        .createTrustManagerFactory();

    // Assert
    Provider provider = actualCreateTrustManagerFactoryResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", actualCreateTrustManagerFactoryResult.getAlgorithm());
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    assertEquals(1, actualCreateTrustManagerFactoryResult.getTrustManagers().length);
  }

  /**
   * Test {@link AbstractSslCredentials#createKeyManagerFactory()}.
   * <p>
   * Method under test: {@link AbstractSslCredentials#createKeyManagerFactory()}
   */
  @Test
  @DisplayName("Test createKeyManagerFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyManagerFactory AbstractSslCredentials.createKeyManagerFactory()"})
  void testCreateKeyManagerFactory() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
    // Arrange and Act
    KeyManagerFactory actualCreateKeyManagerFactoryResult = (new KeystoreSslCredentials()).createKeyManagerFactory();

    // Assert
    Provider provider = actualCreateKeyManagerFactoryResult.getProvider();
    assertEquals(25, provider.size());
    assertEquals("17", provider.get("Provider.id version"));
    assertEquals("PKIX", provider.get("Alg.Alias.TrustManagerFactory.X.509"));
    assertEquals("SunX509", actualCreateKeyManagerFactoryResult.getAlgorithm());
    assertEquals("TLS", provider.get("Alg.Alias.SSLContext.SSL"));
    assertEquals("TLSv1", provider.get("Alg.Alias.SSLContext.SSLv3"));
    assertEquals("sun.security.ssl.KeyManagerFactoryImpl$X509", provider.get("KeyManagerFactory.NewSunX509"));
    assertEquals("sun.security.ssl.SSLContextImpl$DTLSContext", provider.get("SSLContext.DTLS"));
    assertEquals(1, actualCreateKeyManagerFactoryResult.getKeyManagers().length);
  }

  /**
   * Test {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}
   */
  @Test
  @DisplayName("Test getValueFromSubjectNameByKey(String, String); when ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractSslCredentials.getValueFromSubjectNameByKey(String, String)"})
  void testGetValueFromSubjectNameByKey_whenComma() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getValueFromSubjectNameByKey(",", "Key"));
  }

  /**
   * Test {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}.
   * <ul>
   *   <li>When {@code Hello from the Dreaming Spires}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}
   */
  @Test
  @DisplayName("Test getValueFromSubjectNameByKey(String, String); when 'Hello from the Dreaming Spires'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractSslCredentials.getValueFromSubjectNameByKey(String, String)"})
  void testGetValueFromSubjectNameByKey_whenHelloFromTheDreamingSpires() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getValueFromSubjectNameByKey("Hello from the Dreaming Spires", "Key"));
  }
}
