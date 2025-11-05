package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;

class TbCoapDtlsSettingsDiffblueTest {
  /**
   * Test {@link TbCoapDtlsSettings#coapDtlsCredentials()}.
   *
   * <p>Method under test: {@link TbCoapDtlsSettings#coapDtlsCredentials()}
   */
  @Test
  @DisplayName("Test coapDtlsCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslCredentialsConfig TbCoapDtlsSettings.coapDtlsCredentials()"})
  void testCoapDtlsCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualCoapDtlsCredentialsResult =
        new TbCoapDtlsSettings().coapDtlsCredentials();

    // Assert
    assertEquals("COAP DTLS Credentials", actualCoapDtlsCredentialsResult.getName());
    assertNull(actualCoapDtlsCredentialsResult.getKeystore());
    assertNull(actualCoapDtlsCredentialsResult.getPem());
    assertNull(actualCoapDtlsCredentialsResult.getCredentials());
    assertNull(actualCoapDtlsCredentialsResult.getType());
    assertFalse(actualCoapDtlsCredentialsResult.isTrustsOnly());
    assertTrue(actualCoapDtlsCredentialsResult.isEnabled());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapDtlsSettings#getCIdLength()}
   *   <li>{@link TbCoapDtlsSettings#getCoapDtlsCredentialsConfig()}
   *   <li>{@link TbCoapDtlsSettings#getDtlsRetransmissionTimeout()}
   *   <li>{@link TbCoapDtlsSettings#getDtlsSessionInactivityTimeout()}
   *   <li>{@link TbCoapDtlsSettings#getDtlsSessionReportTimeout()}
   *   <li>{@link TbCoapDtlsSettings#getHost()}
   *   <li>{@link TbCoapDtlsSettings#getPort()}
   *   <li>{@link TbCoapDtlsSettings#getServiceInfoProvider()}
   *   <li>{@link TbCoapDtlsSettings#getTransportService()}
   *   <li>{@link TbCoapDtlsSettings#isSkipValidityCheckForClientCert()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer TbCoapDtlsSettings.getCIdLength()",
    "SslCredentialsConfig TbCoapDtlsSettings.getCoapDtlsCredentialsConfig()",
    "int TbCoapDtlsSettings.getDtlsRetransmissionTimeout()",
    "long TbCoapDtlsSettings.getDtlsSessionInactivityTimeout()",
    "long TbCoapDtlsSettings.getDtlsSessionReportTimeout()",
    "String TbCoapDtlsSettings.getHost()",
    "Integer TbCoapDtlsSettings.getPort()",
    "TbServiceInfoProvider TbCoapDtlsSettings.getServiceInfoProvider()",
    "TransportService TbCoapDtlsSettings.getTransportService()",
    "boolean TbCoapDtlsSettings.isSkipValidityCheckForClientCert()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbCoapDtlsSettings tbCoapDtlsSettings = new TbCoapDtlsSettings();

    // Act
    Integer actualCIdLength = tbCoapDtlsSettings.getCIdLength();
    SslCredentialsConfig actualCoapDtlsCredentialsConfig =
        tbCoapDtlsSettings.getCoapDtlsCredentialsConfig();
    int actualDtlsRetransmissionTimeout = tbCoapDtlsSettings.getDtlsRetransmissionTimeout();
    long actualDtlsSessionInactivityTimeout = tbCoapDtlsSettings.getDtlsSessionInactivityTimeout();
    long actualDtlsSessionReportTimeout = tbCoapDtlsSettings.getDtlsSessionReportTimeout();
    String actualHost = tbCoapDtlsSettings.getHost();
    Integer actualPort = tbCoapDtlsSettings.getPort();
    TbServiceInfoProvider actualServiceInfoProvider = tbCoapDtlsSettings.getServiceInfoProvider();
    TransportService actualTransportService = tbCoapDtlsSettings.getTransportService();

    // Assert
    assertNull(actualCIdLength);
    assertNull(actualPort);
    assertNull(actualHost);
    assertNull(actualTransportService);
    assertNull(actualCoapDtlsCredentialsConfig);
    assertNull(actualServiceInfoProvider);
    assertEquals(0, actualDtlsRetransmissionTimeout);
    assertEquals(0L, actualDtlsSessionInactivityTimeout);
    assertEquals(0L, actualDtlsSessionReportTimeout);
    assertFalse(tbCoapDtlsSettings.isSkipValidityCheckForClientCert());
  }
}
