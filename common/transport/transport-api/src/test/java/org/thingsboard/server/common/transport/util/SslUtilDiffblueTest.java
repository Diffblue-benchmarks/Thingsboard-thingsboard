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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SslUtilDiffblueTest {
  /**
   * Test {@link SslUtil#getCertificateString(Certificate)}.
   * <ul>
   *   <li>Then return {@code QVhBWEFYQVg=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#getCertificateString(Certificate)}
   */
  @Test
  @DisplayName("Test getCertificateString(Certificate); then return 'QVhBWEFYQVg='")
  void testGetCertificateString_thenReturnQVhBWEFYQVg()
      throws UnsupportedEncodingException, CertificateEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", SslUtil.getCertificateString(new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link SslUtil#getCertificateChainString(Certificate[])}.
   * <p>
   * Method under test: {@link SslUtil#getCertificateChainString(Certificate[])}
   */
  @Test
  @DisplayName("Test getCertificateChainString(Certificate[])")
  void testGetCertificateChainString() throws UnsupportedEncodingException, CertificateEncodingException {
    // Arrange, Act and Assert
    assertEquals("-----BEGIN CERTIFICATE-----QVhBWEFYQVg=-----END CERTIFICATE-----\n",
        SslUtil.getCertificateChainString(new Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))}));
    assertEquals("-----BEGIN CERTIFICATE-----AVhBWEFYQVg=-----END CERTIFICATE-----\n",
        SslUtil.getCertificateChainString(
            new Certificate[]{new LazyX509Certificate(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})}));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String)")
  void testReadCertFile() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil
        .readCertFile("Not all who wander are lostFile Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostX.509org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost42org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil
        .readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilX.509"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil42"));
    assertNull(SslUtil
        .readCertFile("File ContentNot all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File ContentFile Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("File ContentX.509org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil
        .readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtilX.509"));
    assertNull(
        SslUtil.readCertFile("X.509Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("X.509File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("X.509org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("X.509org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("42Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile("42org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lost\\sorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil
        .readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostFile Content"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostX.509"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost42"));
    assertNull(SslUtil
        .readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentFile Content"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile ContentX.509"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilX.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilX.509File Content"));
    assertNull(
        SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil42Not all who wander are lost"));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil "));
    assertNull(
        SslUtil.readCertFile("Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil\\s"));
    assertNull(
        SslUtil.readCertFile(" Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(
        SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42'")
  void testReadCertFile_when42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" 42"));
    assertNull(SslUtil.readCertFile("42 "));
    assertNull(SslUtil.readCertFile("  42"));
    assertNull(SslUtil.readCertFile(" 42 "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File Content'")
  void testReadCertFile_when42FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File Content"));
    assertNull(SslUtil.readCertFile(" 42File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42File Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File Content42'")
  void testReadCertFile_when42FileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42File ContentFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File ContentFile Content'")
  void testReadCertFile_when42FileContentFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File ContentFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42File ContentNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File ContentNot all who wander are lost'")
  void testReadCertFile_when42FileContentNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File ContentNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42File ContentX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File ContentX.509'")
  void testReadCertFile_when42FileContentX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File ContentX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code 42File Contentorg.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42File Contentorg.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_when42FileContentorgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42Not all who wander are lost'")
  void testReadCertFile_when42NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" 42Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42Not all who wander are lost42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42Not all who wander are lost42'")
  void testReadCertFile_when42NotAllWhoWanderAreLost42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42Not all who wander are lost42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42Not all who wander are lostFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42Not all who wander are lostFile Content'")
  void testReadCertFile_when42NotAllWhoWanderAreLostFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42Not all who wander are lostFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code 42Not all who wander are lostNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42Not all who wander are lostNot all who wander are lost'")
  void testReadCertFile_when42NotAllWhoWanderAreLostNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42Not all who wander are lostNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42Not all who wander are lostX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42Not all who wander are lostX.509'")
  void testReadCertFile_when42NotAllWhoWanderAreLostX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42Not all who wander are lostX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42\\s'")
  void testReadCertFile_when42S() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" 42\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42org.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42org.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_when42orgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" 42org.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code 42org.thingsboard.server.common.transport.util.SslUtilFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42org.thingsboard.server.common.transport.util.SslUtilFile Content'")
  void testReadCertFile_when42orgThingsboardServerCommonTransportUtilSslUtilFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42org.thingsboard.server.common.transport.util.SslUtilFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42X.509'")
  void testReadCertFile_when42x509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" 42X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42X.509File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42X.509File Content'")
  void testReadCertFile_when42x509FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42X.509File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 42X.509Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '42X.509Not all who wander are lost'")
  void testReadCertFile_when42x509NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("42X.509Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '4242'")
  void testReadCertFile_when4242() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" 4242"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 4242File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '4242File Content'")
  void testReadCertFile_when4242FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("4242File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code 4242Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '4242Not all who wander are lost'")
  void testReadCertFile_when4242NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("4242Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when a string")
  void testReadCertFile_whenAString() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostNot all who wander are lostorg.thingsboard.server.common.transport.util"
            + ".SslUtil"));
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilNot all who wander"
            + " are lost"));
    assertNull(SslUtil.readCertFile(
        "Not all who wander are lostorg.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server"
            + ".common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "File Contentorg.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport"
            + ".util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostNot all who wander"
            + " are lost"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilNot all who wander are lostorg.thingsboard.server"
            + ".common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilFile Contentorg.thingsboard.server.common.transport"
            + ".util.SslUtil"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util.SslUtilNot"
            + " all who wander are lost"));
    assertNull(SslUtil.readCertFile(
        "org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util.SslUtilFile"
            + " Content"));
    assertNull(SslUtil.readCertFile(
        " org.thingsboard.server.common.transport.util.SslUtilorg.thingsboard.server.common.transport.util"
            + ".SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '-----BEGIN CERTIFICATE-----'")
  void testReadCertFile_whenBeginCertificate() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("-----BEGIN CERTIFICATE-----"));
    assertNull(SslUtil.readCertFile(" -----BEGIN CERTIFICATE-----"));
    assertNull(SslUtil.readCertFile("  -----BEGIN CERTIFICATE-----"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content'")
  void testReadCertFile_whenFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content"));
    assertNull(SslUtil.readCertFile(" File Content"));
    assertNull(SslUtil.readCertFile("File Content "));
    assertNull(SslUtil.readCertFile("  File Content"));
    assertNull(SslUtil.readCertFile(" File Content "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content42'")
  void testReadCertFile_whenFileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content42"));
    assertNull(SslUtil.readCertFile(" File Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content42File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content42File Content'")
  void testReadCertFile_whenFileContent42FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content42File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content42Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content42Not all who wander are lost'")
  void testReadCertFile_whenFileContent42NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content42Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content42X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content42X.509'")
  void testReadCertFile_whenFileContent42X509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content42X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code File Content42org.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content42org.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_whenFileContent42orgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content42org.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content4242'")
  void testReadCertFile_whenFileContent4242() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content4242"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentFile Content'")
  void testReadCertFile_whenFileContentFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentFile Content"));
    assertNull(SslUtil.readCertFile(" File ContentFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentFile Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentFile Content42'")
  void testReadCertFile_whenFileContentFileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentFile Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentFile ContentFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentFile ContentFile Content'")
  void testReadCertFile_whenFileContentFileContentFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentFile ContentFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentFile ContentNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentFile ContentNot all who wander are lost'")
  void testReadCertFile_whenFileContentFileContentNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentFile ContentNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentFile ContentX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentFile ContentX.509'")
  void testReadCertFile_whenFileContentFileContentX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentFile ContentX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentNot all who wander are lost'")
  void testReadCertFile_whenFileContentNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" File ContentNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentNot all who wander are lost42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentNot all who wander are lost42'")
  void testReadCertFile_whenFileContentNotAllWhoWanderAreLost42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lost42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentNot all who wander are lostFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentNot all who wander are lostFile Content'")
  void testReadCertFile_whenFileContentNotAllWhoWanderAreLostFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code File ContentNot all who wander are lostNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentNot all who wander are lostNot all who wander are lost'")
  void testReadCertFile_whenFileContentNotAllWhoWanderAreLostNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentNot all who wander are lostX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentNot all who wander are lostX.509'")
  void testReadCertFile_whenFileContentNotAllWhoWanderAreLostX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentNot all who wander are lostX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File Content\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Content\\s'")
  void testReadCertFile_whenFileContentS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Content\\s"));
    assertNull(SslUtil.readCertFile(" File Content\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentX.509'")
  void testReadCertFile_whenFileContentX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentX.509"));
    assertNull(SslUtil.readCertFile(" File ContentX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentX.509File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentX.509File Content'")
  void testReadCertFile_whenFileContentX509FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentX.509File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentX.509Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentX.509Not all who wander are lost'")
  void testReadCertFile_whenFileContentX509NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentX.509Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentX.509X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentX.509X.509'")
  void testReadCertFile_whenFileContentX509x509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentX.509X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code File ContentX.50942}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File ContentX.50942'")
  void testReadCertFile_whenFileContentX50942() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File ContentX.50942"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code File Contentorg.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Contentorg.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_whenFileContentorgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" File Contentorg.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code File Contentorg.thingsboard.server.common.transport.util.SslUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'File Contentorg.thingsboard.server.common.transport.util.SslUtil42'")
  void testReadCertFile_whenFileContentorgThingsboardServerCommonTransportUtilSslUtil42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("File Contentorg.thingsboard.server.common.transport.util.SslUtil42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost  "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost "));
    assertNull(SslUtil.readCertFile("  Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost42'")
  void testReadCertFile_whenNotAllWhoWanderAreLost42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost42"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost 42"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost42 "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost42File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost42File Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLost42FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost42File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lost42Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost42Not all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLost42NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost42Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost42\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost42\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLost42S() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost42\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost42X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost42X.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLost42X509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost42X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost4242'")
  void testReadCertFile_whenNotAllWhoWanderAreLost4242() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost4242"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost File Content"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostFile Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile Content42'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostFile ContentFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile ContentFile Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContentFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostFile ContentNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile ContentNot all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContentNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostFile Content\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile Content\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContentS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile Content\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostFile ContentX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostFile ContentX.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLostFileContentX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostFile ContentX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostNot all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLostNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost "));
    assertNull(SslUtil.readCertFile("Not all who wander are lost Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostNot all who wander are lost42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostNot all who wander are lost42'")
  void testReadCertFile_whenNotAllWhoWanderAreLostNotAllWhoWanderAreLost42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostNot all who wander are lostFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostNot all who wander are lostFile Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLostNotAllWhoWanderAreLostFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostNot all who wander are lost\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostNot all who wander are lost\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLostNotAllWhoWanderAreLostS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lost\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostNot all who wander are lostX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostNot all who wander are lostX.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLostNotAllWhoWanderAreLostX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostNot all who wander are lostX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLostS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost \\s"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lost\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\s42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\s42'")
  void testReadCertFile_whenNotAllWhoWanderAreLostS42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\sFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\sFile Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLostSFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lost\sNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\sNot all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLostSNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\s\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\s\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLostSS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\s\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\sX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lost\\sX.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLostSX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lost\\sX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lost X.509"));
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509 "));
    assertNull(SslUtil.readCertFile(" Not all who wander are lostX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostX.509File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.509File Content'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX509FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code Not all who wander are lostX.509Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.509Not all who wander are lost'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX509NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostX.509\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.509\\s'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX509S() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostX.509X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.509X.509'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX509x509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.509X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lostX.50942}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'Not all who wander are lostX.50942'")
  void testReadCertFile_whenNotAllWhoWanderAreLostX50942() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("Not all who wander are lostX.50942"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'null'")
  void testReadCertFile_whenNull() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(null));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil "));
    assertNull(SslUtil.readCertFile("  org.thingsboard.server.common.transport.util.SslUtil"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.transport.util.SslUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtil42'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtil42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.common.transport.util.SslUtil42File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtil42File Content'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtil42FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtil42File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.common.transport.util.SslUtilFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtilFile Content'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtilFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile Content"));
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.common.transport.util.SslUtilFile Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtilFile Content42'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtilFileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("org.thingsboard.server.common.transport.util.SslUtilFile Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code org.thingsboard.server.common.transport.util.SslUtil\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtil\\s'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtilS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtil\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code org.thingsboard.server.common.transport.util.SslUtilX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'org.thingsboard.server.common.transport.util.SslUtilX.509'")
  void testReadCertFile_whenOrgThingsboardServerCommonTransportUtilSslUtilX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" org.thingsboard.server.common.transport.util.SslUtilX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\s'")
  void testReadCertFile_whenS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("\\s"));
    assertNull(SslUtil.readCertFile(" \\s"));
    assertNull(SslUtil.readCertFile("\\s "));
    assertNull(SslUtil.readCertFile("  \\s"));
    assertNull(SslUtil.readCertFile(" \\s "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \s42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\s42'")
  void testReadCertFile_whenS42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" \\s42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \sFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\sFile Content'")
  void testReadCertFile_whenSFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("\\sFile Content"));
    assertNull(SslUtil.readCertFile(" \\sFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \sNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\sNot all who wander are lost'")
  void testReadCertFile_whenSNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("\\sNot all who wander are lost"));
    assertNull(SslUtil.readCertFile(" \\sNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \s\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\s\\s'")
  void testReadCertFile_whenSS() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" \\s\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \sX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\sX.509'")
  void testReadCertFile_whenSX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" \\sX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code \sorg.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when '\\sorg.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_whenSorgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" \\sorg.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when space")
  void testReadCertFile_whenSpace() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509'")
  void testReadCertFile_whenX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" X.509"));
    assertNull(SslUtil.readCertFile("X.509 "));
    assertNull(SslUtil.readCertFile("  X.509"));
    assertNull(SslUtil.readCertFile(" X.509 "));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509File Content'")
  void testReadCertFile_whenX509FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509File Content"));
    assertNull(SslUtil.readCertFile(" X.509File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509File Content42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509File Content42'")
  void testReadCertFile_whenX509FileContent42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509File Content42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509File ContentFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509File ContentFile Content'")
  void testReadCertFile_whenX509FileContentFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509File ContentFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509File ContentNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509File ContentNot all who wander are lost'")
  void testReadCertFile_whenX509FileContentNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509File ContentNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509File ContentX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509File ContentX.509'")
  void testReadCertFile_whenX509FileContentX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509File ContentX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509Not all who wander are lost'")
  void testReadCertFile_whenX509NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lost"));
    assertNull(SslUtil.readCertFile(" X.509Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509Not all who wander are lost42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509Not all who wander are lost42'")
  void testReadCertFile_whenX509NotAllWhoWanderAreLost42() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lost42"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509Not all who wander are lostFile Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509Not all who wander are lostFile Content'")
  void testReadCertFile_whenX509NotAllWhoWanderAreLostFileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostFile Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code X.509Not all who wander are lostNot all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509Not all who wander are lostNot all who wander are lost'")
  void testReadCertFile_whenX509NotAllWhoWanderAreLostNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostNot all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509Not all who wander are lostX.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509Not all who wander are lostX.509'")
  void testReadCertFile_whenX509NotAllWhoWanderAreLostX509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509Not all who wander are lostX.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509\s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509\\s'")
  void testReadCertFile_whenX509S() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" X.509\\s"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When
   * {@code X.509org.thingsboard.server.common.transport.util.SslUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509org.thingsboard.server.common.transport.util.SslUtil'")
  void testReadCertFile_whenX509orgThingsboardServerCommonTransportUtilSslUtil() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" X.509org.thingsboard.server.common.transport.util.SslUtil"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509X.509}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509X.509'")
  void testReadCertFile_whenX509x509() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" X.509X.509"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509X.509File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509X.509File Content'")
  void testReadCertFile_whenX509x509FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509X.509File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.509X.509Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.509X.509Not all who wander are lost'")
  void testReadCertFile_whenX509x509NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.509X.509Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.50942}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.50942'")
  void testReadCertFile_whenX50942() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile(" X.50942"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.50942File Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.50942File Content'")
  void testReadCertFile_whenX50942FileContent() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.50942File Content"));
  }

  /**
   * Test {@link SslUtil#readCertFile(String)}.
   * <ul>
   *   <li>When {@code X.50942Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#readCertFile(String)}
   */
  @Test
  @DisplayName("Test readCertFile(String); when 'X.50942Not all who wander are lost'")
  void testReadCertFile_whenX50942NotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertNull(SslUtil.readCertFile("X.50942Not all who wander are lost"));
  }

  /**
   * Test {@link SslUtil#parseCommonName(X509Certificate)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SslUtil#parseCommonName(X509Certificate)}
   */
  @Test
  @DisplayName("Test parseCommonName(X509Certificate); then throw RuntimeException")
  void testParseCommonName_thenThrowRuntimeException() throws CertificateEncodingException {
    // Arrange
    X509CertificateObject certificate = mock(X509CertificateObject.class);
    when(certificate.getEncoded()).thenThrow(new CertificateEncodingException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> SslUtil.parseCommonName(certificate));
    verify(certificate).getEncoded();
  }
}
