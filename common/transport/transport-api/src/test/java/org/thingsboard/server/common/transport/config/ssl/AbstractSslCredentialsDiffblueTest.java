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
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import org.junit.jupiter.api.Test;

class AbstractSslCredentialsDiffblueTest {
  /**
   * Method under test: {@link AbstractSslCredentials#getKeyStore()}
   */
  @Test
  void testGetKeyStore() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getKeyStore());
  }

  /**
   * Method under test: {@link AbstractSslCredentials#getPrivateKey()}
   */
  @Test
  void testGetPrivateKey() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getPrivateKey());
  }

  /**
   * Method under test: {@link AbstractSslCredentials#getPublicKey()}
   */
  @Test
  void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getPublicKey());
  }

  /**
   * Method under test: {@link AbstractSslCredentials#getCertificateChain()}
   */
  @Test
  void testGetCertificateChain() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getCertificateChain());
  }

  /**
   * Method under test: {@link AbstractSslCredentials#getTrustedCertificates()}
   */
  @Test
  void testGetTrustedCertificates() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getTrustedCertificates());
  }

  /**
   * Method under test: {@link AbstractSslCredentials#createTrustManagerFactory()}
   */
  @Test
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
   * Method under test: {@link AbstractSslCredentials#createKeyManagerFactory()}
   */
  @Test
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
   * Method under test:
   * {@link AbstractSslCredentials#getValueFromSubjectNameByKey(String, String)}
   */
  @Test
  void testGetValueFromSubjectNameByKey() {
    // Arrange, Act and Assert
    assertNull((new KeystoreSslCredentials()).getValueFromSubjectNameByKey("Hello from the Dreaming Spires", "Key"));
    assertNull((new KeystoreSslCredentials()).getValueFromSubjectNameByKey(",", "Key"));
  }
}
