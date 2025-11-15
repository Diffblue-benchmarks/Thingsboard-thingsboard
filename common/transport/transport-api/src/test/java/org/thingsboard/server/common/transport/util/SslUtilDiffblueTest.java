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
package org.thingsboard.server.common.transport.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.LazyX509Certificate;
import java.io.UnsupportedEncodingException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.junit.jupiter.api.Test;

class SslUtilDiffblueTest {
  /**
   * Method under test: {@link SslUtil#getCertificateString(Certificate)}
   */
  @Test
  void testGetCertificateString() throws UnsupportedEncodingException, CertificateEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", SslUtil.getCertificateString(new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link SslUtil#getCertificateChainString(Certificate[])}
   */
  @Test
  void testGetCertificateChainString() throws UnsupportedEncodingException, CertificateEncodingException {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----QVhBWEFYQVg=-----END CERTIFICATE-----\n",
        SslUtil.getCertificateChainString(new Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))}));
    assertEquals("-----BEGIN CERTIFICATE-----AVhBWEFYQVg=-----END CERTIFICATE-----\n",
        SslUtil.getCertificateChainString(
            new Certificate[]{new LazyX509Certificate(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})}));
  }

  /**
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  void testReadCertFile() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(null));
    assertNull(SslUtil.readCertFile(" "));
    assertNull(SslUtil.readCertFile("-----BEGIN CERTIFICATE-----"));
    assertNull(SslUtil.readCertFile("\\s"));
    assertNull(SslUtil.readCertFile("File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost "));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("File ContentFile Content"));
    assertNull(SslUtil.readCertFile("File ContentX.509"));
    assertNull(SslUtil.readCertFile("File Content42"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" -----BEGIN CERTIFICATE-----"));
    assertNull(SslUtil.readCertFile("X.509File Content"));
    assertNull(SslUtil.readCertFile(" \\s"));
    assertNull(SslUtil.readCertFile(" X.509"));
    assertNull(SslUtil.readCertFile(" File Content"));
    assertNull(SslUtil.readCertFile("42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" 42"));
    assertNull(SslUtil.readCertFile("42File Content"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost42"));
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostNot all who wander are lostorg.thingsboard.server.common.transport.util"
            + ".SslUtil"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentX.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content42"));
    assertNull(SslUtil
        .readCertFile("Not all who wander are lostFile Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("\\sNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509File Content"));
    assertNull(SslUtil.readCertFile("\\s "));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509X.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.50942"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostX.509org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42File Content"));
    assertNull(SslUtil.readCertFile("\\sFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42X.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost4242"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost42org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilNot all who wander"
            + " are lost"));
    assertNull(SslUtil.readCertFile("X.509 "));
    assertNull(SslUtil
        .readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilX.509"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil42"));
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server"
            + ".common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lost42"));
    assertNull(SslUtil
        .readCertFile("File ContentNot all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File Content "));
    assertNull(SslUtil.readCertFile("File ContentFile ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("File ContentFile ContentFile Content"));
    assertNull(SslUtil.readCertFile("File ContentFile ContentX.509"));
    assertNull(SslUtil.readCertFile("File Content\\s"));
    assertNull(SslUtil.readCertFile("File ContentFile Content42"));
    assertNull(SslUtil.readCertFile("File ContentFile Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File ContentX.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("File ContentX.509File Content"));
    assertNull(SslUtil.readCertFile("File ContentX.509X.509"));
    assertNull(SslUtil.readCertFile("File ContentX.50942"));
    assertNull(SslUtil.readCertFile("42 "));
    assertNull(SslUtil.readCertFile("File ContentX.509org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File Content42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("File Content42File Content"));
    assertNull(SslUtil.readCertFile("File Content42X.509"));
    assertNull(SslUtil.readCertFile("File Content4242"));
    assertNull(SslUtil.readCertFile("File Content42org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil
        .readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilX.509"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil "));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtil42"));
    assertNull(SslUtil.readCertFile(
        "File Contentorg.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport"
            + ".util.SslUtil"));
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lost42"));
    assertNull(
        SslUtil.readCertFile("X.509Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("X.509File ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("X.509File ContentFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost "));
    assertNull(SslUtil.readCertFile("X.509File ContentX.509"));
    assertNull(SslUtil.readCertFile("X.509File Content42"));
    assertNull(SslUtil.readCertFile("X.509File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost\\s"));
    assertNull(SslUtil.readCertFile("X.509X.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("X.509X.509File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("X.50942Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost  "));
    assertNull(SslUtil.readCertFile("X.50942File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost \\s"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost X.509"));
    assertNull(
        SslUtil.readCertFile("X.509org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost File Content"));
    assertNull(SslUtil.readCertFile("X.509org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost 42"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("42Not all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("42Not all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("42Not all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("42Not all who wander are lost42"));
    assertNull(
        SslUtil.readCertFile("42Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("42File ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("42File ContentFile Content"));
    assertNull(SslUtil.readCertFile("42File ContentX.509"));
    assertNull(SslUtil.readCertFile("42File Content42"));
    assertNull(SslUtil.readCertFile("42File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("42X.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("42X.509File Content"));
    assertNull(SslUtil.readCertFile("4242Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("4242File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s "));
    assertNull(
        SslUtil.readCertFile("42org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s\\s"));
    assertNull(SslUtil.readCertFile("42org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sX.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s42"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost\\sorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostNot all who wander"
            + " are lost"));
    assertNull(SslUtil
        .readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509 "));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostX.509"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost42"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostorg.thingsboard.server"
            + ".common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509\\s"));
    assertNull(SslUtil
        .readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentFile Content"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentX.509"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile Content42"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilFile Contentorg.thingsboard.server.common.transport"
            + ".util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilX.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content "));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilX.509File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content\\s"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil42File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42 "));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util.SslUtilNot"
            + " all who wander are lost"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util.SslUtilFile"
            + " Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42\\s"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil "));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil\\s"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost\\s"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost42"));
    assertNull(
        SslUtil.readCertFile(" Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("  Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("  -----BEGIN CERTIFICATE-----"));
    assertNull(SslUtil.readCertFile("  \\s"));
    assertNull(SslUtil.readCertFile("  X.509"));
    assertNull(SslUtil.readCertFile("  File Content"));
    assertNull(SslUtil.readCertFile("  42"));
    assertNull(SslUtil.readCertFile("  org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" \\sNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" \\s "));
    assertNull(SslUtil.readCertFile(" \\s\\s"));
    assertNull(SslUtil.readCertFile(" \\sX.509"));
    assertNull(SslUtil.readCertFile(" \\sFile Content"));
    assertNull(SslUtil.readCertFile(" \\s42"));
    assertNull(SslUtil.readCertFile(" \\sorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" X.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" X.509 "));
    assertNull(SslUtil.readCertFile(" X.509\\s"));
    assertNull(SslUtil.readCertFile(" X.509X.509"));
    assertNull(SslUtil.readCertFile(" X.509File Content"));
    assertNull(SslUtil.readCertFile(" X.50942"));
    assertNull(SslUtil.readCertFile(" X.509org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" File ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" File Content "));
    assertNull(SslUtil.readCertFile(" File Content\\s"));
    assertNull(SslUtil.readCertFile(" File ContentX.509"));
    assertNull(SslUtil.readCertFile(" File ContentFile Content"));
    assertNull(SslUtil.readCertFile(" File Content42"));
    assertNull(SslUtil.readCertFile(" File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" 42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" 42 "));
    assertNull(SslUtil.readCertFile(" 42\\s"));
    assertNull(SslUtil.readCertFile(" 42X.509"));
    assertNull(SslUtil.readCertFile(" 42File Content"));
    assertNull(SslUtil.readCertFile(" 4242"));
    assertNull(SslUtil.readCertFile(" 42org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil "));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil\\s"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilX.509"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil42"));
    assertNull(SslUtil.readCertFile(
        " org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util"
            + ".SslUtil"));
  }

  /**
   * Method under test: {@link SslUtil#parseCommonName(X509Certificate)}
   */
  @Test
  void testParseCommonName() throws CertificateEncodingException {
    // Arrange
    X509CertificateObject certificate = mock(X509CertificateObject.class);
    when(certificate.getEncoded()).thenThrow(new CertificateEncodingException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> SslUtil.parseCommonName(certificate));
    verify(certificate).getEncoded();
  }
}
