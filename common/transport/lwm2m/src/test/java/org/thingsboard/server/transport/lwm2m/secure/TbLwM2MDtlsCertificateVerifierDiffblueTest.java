package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.List;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.CertificateVerificationResult;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.ContentType;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.eclipse.californium.scandium.util.ServerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;

class TbLwM2MDtlsCertificateVerifierDiffblueTest {
  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  void testGetSupportedCertificateTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    List<CertificateType> actualSupportedCertificateTypes = (new TbLwM2MDtlsCertificateVerifier(sessionStorage, config,
        securityInfoValidator,
        new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()))))
        .getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  void testGetSupportedCertificateTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = mock(TbL2M2MDtlsSessionInMemoryStore.class);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    List<CertificateType> actualSupportedCertificateTypes = (new TbLwM2MDtlsCertificateVerifier(sessionStorage, config,
        securityInfoValidator,
        new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()))))
        .getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test
   * {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  void testVerifyCertificate() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier = new TbLwM2MDtlsCertificateVerifier(sessionStorage,
        config, securityInfoValidator, new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig())));
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
    AlertMessage alert = exception.getAlert();
    assertNull(alert.getProtocolVersion());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(2, alert.size());
    assertEquals(AlertMessage.AlertDescription.INTERNAL_ERROR, alert.getDescription());
    assertEquals(AlertMessage.AlertLevel.FATAL, alert.getLevel());
    assertEquals(ContentType.ALERT, alert.getContentType());
    assertTrue(alert.isFatal());
    assertSame(cid, actualVerifyCertificateResult.getConnectionId());
  }

  /**
   * Test
   * {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  void testVerifyCertificate2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLwM2MDtlsSessionStore sessionStorage = mock(TbLwM2MDtlsSessionStore.class);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier = new TbLwM2MDtlsCertificateVerifier(sessionStorage,
        config, securityInfoValidator, new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig())));
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
    AlertMessage alert = exception.getAlert();
    assertNull(alert.getProtocolVersion());
    assertEquals(0, exception.getSuppressed().length);
    assertEquals(2, alert.size());
    assertEquals(AlertMessage.AlertDescription.INTERNAL_ERROR, alert.getDescription());
    assertEquals(AlertMessage.AlertLevel.FATAL, alert.getLevel());
    assertEquals(ContentType.ALERT, alert.getContentType());
    assertTrue(alert.isFatal());
    assertSame(cid, actualVerifyCertificateResult.getConnectionId());
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  void testGetAcceptedIssuers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertTrue((new TbLwM2MDtlsCertificateVerifier(sessionStorage, config, securityInfoValidator,
        new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()))))
        .getAcceptedIssuers()
        .isEmpty());
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  void testGetAcceptedIssuers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = mock(TbL2M2MDtlsSessionInMemoryStore.class);
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertTrue((new TbLwM2MDtlsCertificateVerifier(sessionStorage, config, securityInfoValidator,
        new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig()))))
        .getAcceptedIssuers()
        .isEmpty());
  }
}
