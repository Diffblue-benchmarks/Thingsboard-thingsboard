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
package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.AlertMessage.AlertDescription;
import org.eclipse.californium.scandium.dtls.AlertMessage.AlertLevel;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.CertificateVerificationResult;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.ContentType;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.eclipse.californium.scandium.util.ServerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbLwM2MDtlsBootstrapCertificateVerifierDiffblueTest {
  @InjectMocks
  private TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier;

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}.
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbLwM2MDtlsBootstrapCertificateVerifier.getSupportedCertificateTypes()"})
  void testGetSupportedCertificateTypes() {
    // Arrange and Act
    List<CertificateType> actualSupportedCertificateTypes =
        tbLwM2MDtlsBootstrapCertificateVerifier.getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return CustomArgument is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage); given 'null'; then return CustomArgument is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate_givenNull_thenReturnCustomArgumentIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    CertificateMessage message = mock(CertificateMessage.class);
    when(message.getCertificateChain()).thenReturn(null);
    when(message.getPublicKey()).thenReturn(null);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult =
        tbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(
            cid, serverName, remotePeer, true, true, true, message);

    // Assert
    verify(message).getCertificateChain();
    verify(message).getPublicKey();
    assertNull(actualVerifyCertificateResult.getCustomArgument());
    assertNull(actualVerifyCertificateResult.getPublicKey());
    assertNull(actualVerifyCertificateResult.getCertificatePath());
    assertNull(actualVerifyCertificateResult.getException());
    assertSame(cid, actualVerifyCertificateResult.getConnectionId());
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <ul>
   *   <li>When {@link CertificateMessage#CertificateMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage); when CertificateMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate_whenCertificateMessage() throws UnsupportedEncodingException {
    // Arrange
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult =
        tbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(
            cid, serverName, remotePeer, true, true, true, new CertificateMessage());

    // Assert
    HandshakeException exception = actualVerifyCertificateResult.getException();
    assertEquals("x509 verification not enabled!", exception.getLocalizedMessage());
    assertEquals("x509 verification not enabled!", exception.getMessage());
    assertNull(exception.getCause());
    AlertMessage alert = exception.getAlert();
    assertNull(alert.getProtocolVersion());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(2, alert.size());
    assertEquals(AlertDescription.INTERNAL_ERROR, alert.getDescription());
    assertEquals(AlertLevel.FATAL, alert.getLevel());
    assertEquals(ContentType.ALERT, alert.getContentType());
    assertTrue(alert.isFatal());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualVerifyCertificateResult.getConnectionId().getBytes());
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <ul>
   *   <li>When {@link CertificateMessage#CertificateMessage(List)} with certificateChain is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage); when CertificateMessage(List) with certificateChain is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate_whenCertificateMessageWithCertificateChainIsArrayList()
      throws UnsupportedEncodingException {
    // Arrange
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult =
        tbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(
            cid,
            serverName,
            remotePeer,
            true,
            true,
            true,
            new CertificateMessage(new ArrayList<>()));

    // Assert
    HandshakeException exception = actualVerifyCertificateResult.getException();
    assertEquals("x509 verification not enabled!", exception.getLocalizedMessage());
    assertEquals("x509 verification not enabled!", exception.getMessage());
    assertNull(exception.getCause());
    AlertMessage alert = exception.getAlert();
    assertNull(alert.getProtocolVersion());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(2, alert.size());
    assertEquals(AlertDescription.INTERNAL_ERROR, alert.getDescription());
    assertEquals(AlertLevel.FATAL, alert.getLevel());
    assertEquals(ContentType.ALERT, alert.getContentType());
    assertTrue(alert.isFatal());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualVerifyCertificateResult.getConnectionId().getBytes());
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbLwM2MDtlsBootstrapCertificateVerifier.getAcceptedIssuers()"})
  void testGetAcceptedIssuers() {
    // Arrange, Act and Assert
    assertTrue(tbLwM2MDtlsBootstrapCertificateVerifier.getAcceptedIssuers().isEmpty());
  }
}
