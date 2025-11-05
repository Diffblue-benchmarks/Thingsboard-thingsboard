package org.thingsboard.server.transport.lwm2m.secure;

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
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbLwM2MDtlsCertificateVerifierDiffblueTest {
  @Mock private LwM2MTransportServerConfig lwM2MTransportServerConfig;

  @InjectMocks private TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier;

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#getSupportedCertificateTypes()}
   */
  @Test
  @DisplayName("Test getSupportedCertificateTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbLwM2MDtlsCertificateVerifier.getSupportedCertificateTypes()"})
  void testGetSupportedCertificateTypes() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator validator =
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig());

    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore, validator);

    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier =
        new TbLwM2MDtlsCertificateVerifier(
            sessionStorage, config, securityInfoValidator, securityStore2);

    // Act
    List<CertificateType> actualSupportedCertificateTypes =
        tbLwM2MDtlsCertificateVerifier.getSupportedCertificateTypes();

    // Assert
    assertEquals(2, actualSupportedCertificateTypes.size());
    assertEquals(CertificateType.RAW_PUBLIC_KEY, actualSupportedCertificateTypes.get(1));
    assertEquals(CertificateType.X_509, actualSupportedCertificateTypes.get(0));
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsCertificateVerifier.init()"})
  void testInit() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials())
        .thenReturn(new KeystoreSslCredentials());

    // Act
    tbLwM2MDtlsCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsCertificateVerifier.init()"})
  void testInit2() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenThrow(new LwM2MAuthException());

    // Act
    tbLwM2MDtlsCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsCertificateVerifier.init()"})
  void testInit3() throws UnsupportedEncodingException {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = mock(KeystoreSslCredentials.class);
    when(keystoreSslCredentials.getTrustedCertificates())
        .thenReturn(new X509Certificate[] {new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))});
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(keystoreSslCredentials);

    // Act
    tbLwM2MDtlsCertificateVerifier.init();

    // Assert
    verify(keystoreSslCredentials).getTrustedCertificates();
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#init()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsCertificateVerifier.init()"})
  void testInit4() {
    // Arrange
    KeystoreSslCredentials keystoreSslCredentials = mock(KeystoreSslCredentials.class);
    when(keystoreSslCredentials.getTrustedCertificates()).thenThrow(new LwM2MAuthException());
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(keystoreSslCredentials);

    // Act
    tbLwM2MDtlsCertificateVerifier.init();

    // Assert
    verify(keystoreSslCredentials).getTrustedCertificates();
    verify(lwM2MTransportServerConfig, atLeast(1)).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#init()}.
   *
   * <ul>
   *   <li>Given {@link LwM2MTransportServerConfig} {@link
   *       LwM2MTransportServerConfig#getTrustSslCredentials()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#init()}
   */
  @Test
  @DisplayName(
      "Test init(); given LwM2MTransportServerConfig getTrustSslCredentials() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MDtlsCertificateVerifier.init()"})
  void testInit_givenLwM2MTransportServerConfigGetTrustSslCredentialsReturnNull() {
    // Arrange
    when(lwM2MTransportServerConfig.getTrustSslCredentials()).thenReturn(null);

    // Act
    tbLwM2MDtlsCertificateVerifier.init();

    // Assert
    verify(lwM2MTransportServerConfig).getTrustSslCredentials();
  }

  /**
   * Test {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate() throws UnsupportedEncodingException {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator validator =
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig());

    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore, validator);

    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier =
        new TbLwM2MDtlsCertificateVerifier(
            sessionStorage, config, securityInfoValidator, securityStore2);
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("localhost", 8080);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult =
        tbLwM2MDtlsCertificateVerifier.verifyCertificate(
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
   * Test {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId, ServerNames,
   * InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}.
   *
   * <ul>
   *   <li>Then return CustomArgument is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#verifyCertificate(ConnectionId,
   * ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)}
   */
  @Test
  @DisplayName(
      "Test verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage); then return CustomArgument is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CertificateVerificationResult TbLwM2MDtlsCertificateVerifier.verifyCertificate(ConnectionId, ServerNames, InetSocketAddress, boolean, boolean, boolean, CertificateMessage)"
  })
  void testVerifyCertificate_thenReturnCustomArgumentIsNull() throws UnsupportedEncodingException {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator validator =
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig());

    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore, validator);

    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier =
        new TbLwM2MDtlsCertificateVerifier(
            sessionStorage, config, securityInfoValidator, securityStore2);
    ConnectionId cid = new ConnectionId("AXAXAXAX".getBytes("UTF-8"));
    ServerNames serverName = ServerNames.newInstance();
    InetSocketAddress remotePeer = InetSocketAddress.createUnresolved("localhost", 8080);

    CertificateMessage message = mock(CertificateMessage.class);
    when(message.getPublicKey()).thenReturn(null);
    when(message.getCertificateChain()).thenReturn(null);

    // Act
    CertificateVerificationResult actualVerifyCertificateResult =
        tbLwM2MDtlsCertificateVerifier.verifyCertificate(
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
   * Test {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}.
   *
   * <p>Method under test: {@link TbLwM2MDtlsCertificateVerifier#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test getAcceptedIssuers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbLwM2MDtlsCertificateVerifier.getAcceptedIssuers()"})
  void testGetAcceptedIssuers() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator validator =
        new LwM2mCredentialsSecurityInfoValidator(context2, new LwM2MTransportServerConfig());

    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore, validator);

    TbLwM2MDtlsCertificateVerifier tbLwM2MDtlsCertificateVerifier =
        new TbLwM2MDtlsCertificateVerifier(
            sessionStorage, config, securityInfoValidator, securityStore2);

    // Act and Assert
    assertTrue(tbLwM2MDtlsCertificateVerifier.getAcceptedIssuers().isEmpty());
  }
}
