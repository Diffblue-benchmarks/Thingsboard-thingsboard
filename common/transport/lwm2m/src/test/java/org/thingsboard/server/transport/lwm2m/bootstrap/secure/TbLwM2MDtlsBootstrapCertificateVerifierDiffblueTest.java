package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

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
import org.eclipse.leshan.server.bootstrap.EditableBootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.InMemoryBootstrapConfigStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MInMemoryBootstrapConfigStore;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;

class TbLwM2MDtlsBootstrapCertificateVerifierDiffblueTest {
  /**
   * Test
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  void testGetSupportedCertificateTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    List<CertificateType> actualSupportedCertificateTypes = (new TbLwM2MDtlsBootstrapCertificateVerifier(config,
        new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()))))
        .getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  void testGetSupportedCertificateTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = mock(InMemoryBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    List<CertificateType> actualSupportedCertificateTypes = (new TbLwM2MDtlsBootstrapCertificateVerifier(config,
        new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()))))
        .getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  void testVerifyCertificate() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier = new TbLwM2MDtlsBootstrapCertificateVerifier(
        config, new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext())));
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult = tbLwM2MDtlsBootstrapCertificateVerifier
        .verifyCertificate(cid, serverName, remotePeer, true, true, true, new CertificateMessage());

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
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  void testVerifyCertificate2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier = new TbLwM2MDtlsBootstrapCertificateVerifier(
        null, new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext())));
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult = tbLwM2MDtlsBootstrapCertificateVerifier
        .verifyCertificate(cid, serverName, remotePeer, true, true, true, new CertificateMessage());

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
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName("Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  void testVerifyCertificate3() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    EditableBootstrapConfigStore bootstrapConfigStore = mock(EditableBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier = new TbLwM2MDtlsBootstrapCertificateVerifier(
        config, new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext())));
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult = tbLwM2MDtlsBootstrapCertificateVerifier
        .verifyCertificate(cid, serverName, remotePeer, true, true, true, new CertificateMessage());

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
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  void testGetAcceptedIssuers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertTrue((new TbLwM2MDtlsBootstrapCertificateVerifier(config,
        new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()))))
        .getAcceptedIssuers()
        .isEmpty());
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link TbLwM2MDtlsBootstrapCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  void testGetAcceptedIssuers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = mock(InMemoryBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertTrue((new TbLwM2MDtlsBootstrapCertificateVerifier(config,
        new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()))))
        .getAcceptedIssuers()
        .isEmpty());
  }
}
