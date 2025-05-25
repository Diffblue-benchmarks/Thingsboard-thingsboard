package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.List;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.CertificateVerificationResult;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.eclipse.californium.scandium.util.ServerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbLwM2MDtlsCertificateVerifierDiffblueTest {
  @InjectMocks
  private TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier;

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}.
   * <p>
   * Method under test: {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbLwM2MDtlsCertificateVerifier.getSupportedCertificateTypes()"})
  void testGetSupportedCertificateTypes() {
    // Arrange and Act
    List<CertificateType> actualSupportedCertificateTypes = tbLwM2MDtlsCertificateVerifier
        .getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test: {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CertificateVerificationResult TbLwM2MDtlsCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"})
  void testVerifyCertificate() throws UnsupportedEncodingException {
    // Arrange
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult = tbLwM2MDtlsCertificateVerifier.verifyCertificate(cid,
        serverName, remotePeer, true, true, true, new CertificateMessage());

    // Assert
    HandshakeException exception = actualVerifyCertificateResult.getException();
    assertEquals("x509 verification not enabled!", exception.getLocalizedMessage());
    assertEquals("x509 verification not enabled!", exception.getMessage());
    assertNull(actualVerifyCertificateResult.getCustomArgument());
    assertNull(exception.getCause());
    assertNull(actualVerifyCertificateResult.getPublicKey());
    assertNull(actualVerifyCertificateResult.getCertificatePath());
    assertEquals(0, exception.getSuppressed().length);
    assertSame(cid, actualVerifyCertificateResult.getConnectionId());
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}.
   * <p>
   * Method under test: {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TbLwM2MDtlsCertificateVerifier.getAcceptedIssuers()"})
  void testGetAcceptedIssuers() {
    // Arrange, Act and Assert
    assertTrue(tbLwM2MDtlsCertificateVerifier.getAcceptedIssuers().isEmpty());
  }
}
