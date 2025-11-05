package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.californium.elements.config.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TbProperty;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;

class LwM2MTransportServerConfigDiffblueTest {
  /**
   * Test {@link LwM2MTransportServerConfig#lwm2mServerCredentials()}.
   *
   * <p>Method under test: {@link LwM2MTransportServerConfig#lwm2mServerCredentials()}
   */
  @Test
  @DisplayName("Test lwm2mServerCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslCredentialsConfig LwM2MTransportServerConfig.lwm2mServerCredentials()"})
  void testLwm2mServerCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualLwm2mServerCredentialsResult =
        new LwM2MTransportServerConfig().lwm2mServerCredentials();

    // Assert
    assertEquals("LWM2M Server DTLS Credentials", actualLwm2mServerCredentialsResult.getName());
    assertNull(actualLwm2mServerCredentialsResult.getKeystore());
    assertNull(actualLwm2mServerCredentialsResult.getPem());
    assertNull(actualLwm2mServerCredentialsResult.getCredentials());
    assertNull(actualLwm2mServerCredentialsResult.getType());
    assertFalse(actualLwm2mServerCredentialsResult.isTrustsOnly());
    assertTrue(actualLwm2mServerCredentialsResult.isEnabled());
  }

  /**
   * Test {@link LwM2MTransportServerConfig#lwm2mTrustCredentials()}.
   *
   * <p>Method under test: {@link LwM2MTransportServerConfig#lwm2mTrustCredentials()}
   */
  @Test
  @DisplayName("Test lwm2mTrustCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslCredentialsConfig LwM2MTransportServerConfig.lwm2mTrustCredentials()"})
  void testLwm2mTrustCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualLwm2mTrustCredentialsResult =
        new LwM2MTransportServerConfig().lwm2mTrustCredentials();

    // Assert
    assertEquals("LWM2M Trust Credentials", actualLwm2mTrustCredentialsResult.getName());
    assertNull(actualLwm2mTrustCredentialsResult.getKeystore());
    assertNull(actualLwm2mTrustCredentialsResult.getPem());
    assertNull(actualLwm2mTrustCredentialsResult.getCredentials());
    assertNull(actualLwm2mTrustCredentialsResult.getType());
    assertTrue(actualLwm2mTrustCredentialsResult.isEnabled());
    assertTrue(actualLwm2mTrustCredentialsResult.isTrustsOnly());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MTransportServerConfig#setCoapConfig(Configuration)}
   *   <li>{@link LwM2MTransportServerConfig#setNetworkConfig(List)}
   *   <li>{@link LwM2MTransportServerConfig#getCleanPeriodInSec()}
   *   <li>{@link LwM2MTransportServerConfig#getCoapConfig()}
   *   <li>{@link LwM2MTransportServerConfig#getDownlinkPoolSize()}
   *   <li>{@link LwM2MTransportServerConfig#getDtlsCidLength()}
   *   <li>{@link LwM2MTransportServerConfig#getDtlsRetransmissionTimeout()}
   *   <li>{@link LwM2MTransportServerConfig#getHost()}
   *   <li>{@link LwM2MTransportServerConfig#getId()}
   *   <li>{@link LwM2MTransportServerConfig#getNetworkConfig()}
   *   <li>{@link LwM2MTransportServerConfig#getOtaPoolSize()}
   *   <li>{@link LwM2MTransportServerConfig#getPagingTransmissionWindow()}
   *   <li>{@link LwM2MTransportServerConfig#getPort()}
   *   <li>{@link LwM2MTransportServerConfig#getPsmActivityTimer()}
   *   <li>{@link LwM2MTransportServerConfig#getSecureHost()}
   *   <li>{@link LwM2MTransportServerConfig#getSecurePort()}
   *   <li>{@link LwM2MTransportServerConfig#getSessionReportTimeout()}
   *   <li>{@link LwM2MTransportServerConfig#getTimeout()}
   *   <li>{@link LwM2MTransportServerConfig#getUplinkPoolSize()}
   *   <li>{@link LwM2MTransportServerConfig#isRecommendedCiphers()}
   *   <li>{@link LwM2MTransportServerConfig#isRecommendedSupportedGroups()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LwM2MTransportServerConfig.getCleanPeriodInSec()",
    "Configuration LwM2MTransportServerConfig.getCoapConfig()",
    "int LwM2MTransportServerConfig.getDownlinkPoolSize()",
    "Integer LwM2MTransportServerConfig.getDtlsCidLength()",
    "int LwM2MTransportServerConfig.getDtlsRetransmissionTimeout()",
    "String LwM2MTransportServerConfig.getHost()",
    "Integer LwM2MTransportServerConfig.getId()",
    "List LwM2MTransportServerConfig.getNetworkConfig()",
    "int LwM2MTransportServerConfig.getOtaPoolSize()",
    "long LwM2MTransportServerConfig.getPagingTransmissionWindow()",
    "Integer LwM2MTransportServerConfig.getPort()",
    "long LwM2MTransportServerConfig.getPsmActivityTimer()",
    "String LwM2MTransportServerConfig.getSecureHost()",
    "Integer LwM2MTransportServerConfig.getSecurePort()",
    "long LwM2MTransportServerConfig.getSessionReportTimeout()",
    "Long LwM2MTransportServerConfig.getTimeout()",
    "int LwM2MTransportServerConfig.getUplinkPoolSize()",
    "boolean LwM2MTransportServerConfig.isRecommendedCiphers()",
    "boolean LwM2MTransportServerConfig.isRecommendedSupportedGroups()",
    "void LwM2MTransportServerConfig.setCoapConfig(Configuration)",
    "void LwM2MTransportServerConfig.setNetworkConfig(List)"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2MTransportServerConfig lwM2MTransportServerConfig = new LwM2MTransportServerConfig();
    Configuration coapConfig = Configuration.createStandardWithoutFile();

    // Act
    lwM2MTransportServerConfig.setCoapConfig(coapConfig);
    ArrayList<TbProperty> networkConfig = new ArrayList<>();
    lwM2MTransportServerConfig.setNetworkConfig(networkConfig);
    int actualCleanPeriodInSec = lwM2MTransportServerConfig.getCleanPeriodInSec();
    Configuration actualCoapConfig = lwM2MTransportServerConfig.getCoapConfig();
    int actualDownlinkPoolSize = lwM2MTransportServerConfig.getDownlinkPoolSize();
    Integer actualDtlsCidLength = lwM2MTransportServerConfig.getDtlsCidLength();
    int actualDtlsRetransmissionTimeout = lwM2MTransportServerConfig.getDtlsRetransmissionTimeout();
    String actualHost = lwM2MTransportServerConfig.getHost();
    Integer actualId = lwM2MTransportServerConfig.getId();
    List<TbProperty> actualNetworkConfig = lwM2MTransportServerConfig.getNetworkConfig();
    int actualOtaPoolSize = lwM2MTransportServerConfig.getOtaPoolSize();
    long actualPagingTransmissionWindow = lwM2MTransportServerConfig.getPagingTransmissionWindow();
    Integer actualPort = lwM2MTransportServerConfig.getPort();
    long actualPsmActivityTimer = lwM2MTransportServerConfig.getPsmActivityTimer();
    String actualSecureHost = lwM2MTransportServerConfig.getSecureHost();
    Integer actualSecurePort = lwM2MTransportServerConfig.getSecurePort();
    long actualSessionReportTimeout = lwM2MTransportServerConfig.getSessionReportTimeout();
    Long actualTimeout = lwM2MTransportServerConfig.getTimeout();
    int actualUplinkPoolSize = lwM2MTransportServerConfig.getUplinkPoolSize();
    boolean actualIsRecommendedCiphersResult = lwM2MTransportServerConfig.isRecommendedCiphers();

    // Assert
    assertNull(actualDtlsCidLength);
    assertNull(actualId);
    assertNull(actualPort);
    assertNull(actualSecurePort);
    assertNull(actualTimeout);
    assertNull(actualHost);
    assertNull(actualSecureHost);
    assertEquals(0, actualCleanPeriodInSec);
    assertEquals(0, actualDownlinkPoolSize);
    assertEquals(0, actualDtlsRetransmissionTimeout);
    assertEquals(0, actualOtaPoolSize);
    assertEquals(0, actualUplinkPoolSize);
    assertEquals(0L, actualPagingTransmissionWindow);
    assertEquals(0L, actualPsmActivityTimer);
    assertEquals(0L, actualSessionReportTimeout);
    assertFalse(actualIsRecommendedCiphersResult);
    assertFalse(lwM2MTransportServerConfig.isRecommendedSupportedGroups());
    assertTrue(actualNetworkConfig.isEmpty());
    assertSame(networkConfig, actualNetworkConfig);
    assertSame(coapConfig, actualCoapConfig);
  }
}
