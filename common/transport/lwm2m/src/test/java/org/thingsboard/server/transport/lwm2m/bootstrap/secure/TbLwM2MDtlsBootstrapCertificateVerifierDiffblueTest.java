package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.LazyX509Certificate;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.cert.X509Certificate;
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
import org.eclipse.leshan.server.bootstrap.InMemoryBootstrapConfigStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbLwM2MDtlsBootstrapCertificateVerifierDiffblueTest {
  @Mock private LwM2MTransportServerConfig lwM2MTransportServerConfig;

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
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier =
        new TbLwM2MDtlsBootstrapCertificateVerifier(config, bsSecurityStore);

    // Act
    List<CertificateType> actualSupportedCertificateTypes =
        tbLwM2MDtlsBootstrapCertificateVerifier.getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsBootstrapCertificateVerifier.init()"})
  void testInit() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials())
        .thenReturn(new KeystoreSslCredentials());

    // Act
    tbLwM2MDtlsBootstrapCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsBootstrapCertificateVerifier.init()"})
  void testInit2() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenThrow(new LwM2MAuthException());

    // Act
    tbLwM2MDtlsBootstrapCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsBootstrapCertificateVerifier.init()"})
  void testInit3() throws UnsupportedEncodingException {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = mock(KeystoreSslCredentials.class);
    when(keystoreSslCredentials.getTrustedCertificates())
        .thenReturn(new X509Certificate[] {new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))});
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(keystoreSslCredentials);

    // Act
    tbLwM2MDtlsBootstrapCertificateVerifier.init();

    // Assert
    verify(keystoreSslCredentials).getTrustedCertificates();
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsBootstrapCertificateVerifier.init()"})
  void testInit4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = mock(KeystoreSslCredentials.class);
    when(keystoreSslCredentials.getTrustedCertificates()).thenThrow(new LwM2MAuthException());
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(keystoreSslCredentials);

    // Act
    tbLwM2MDtlsBootstrapCertificateVerifier.init();

    // Assert
    verify(keystoreSslCredentials).getTrustedCertificates();
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTransportServerConfig} {@link
   *       LwM2MTransportServerConfig#getTrustSslCredentials()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MDtlsBootstrapCertificateVerifier#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given LwM2MTransportServerConfig getTrustSslCredentials() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsBootstrapCertificateVerifier.init()"})
  void testInit_givenLwM2MTransportServerConfigGetTrustSslCredentialsReturnNull() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(null);

    // Act
    tbLwM2MDtlsBootstrapCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate() throws UnsupportedEncodingException {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier =
        new TbLwM2MDtlsBootstrapCertificateVerifier(config, bsSecurityStore);
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("localhost", 8080);

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
   *   <li>Then return CustomArgument is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2MDtlsBootstrapCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage); then return CustomArgument is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsBootstrapCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate_thenReturnCustomArgumentIsNull() throws UnsupportedEncodingException {
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier =
        new TbLwM2MDtlsBootstrapCertificateVerifier(config, bsSecurityStore);
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("localhost", 8080);

    CertificateMessage message = mock(CertificateMessage.class);
    when(message.getPublicKey()).thenReturn(null);
    when(message.getCertificateChain()).thenReturn(null);

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
    // Arrange
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    TbLwM2MDtlsBootstrapCertificateVerifier tbLwM2MDtlsBootstrapCertificateVerifier =
        new TbLwM2MDtlsBootstrapCertificateVerifier(config, bsSecurityStore);

    // Act and Assert
    assertTrue(tbLwM2MDtlsBootstrapCertificateVerifier.getAcceptedIssuers().isEmpty());
  }
}
