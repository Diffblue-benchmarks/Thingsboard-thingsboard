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
package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.californium.elements.config.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TbProperty;

class LwM2MTransportServerConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LwM2MTransportServerConfig.getCleanPeriodInSec()",
      "Configuration LwM2MTransportServerConfig.getCoapConfig()",
      "int LwM2MTransportServerConfig.getDownlinkPoolSize()", "Integer LwM2MTransportServerConfig.getDtlsCidLength()",
      "int LwM2MTransportServerConfig.getDtlsRetransmissionTimeout()", "String LwM2MTransportServerConfig.getHost()",
      "Integer LwM2MTransportServerConfig.getId()", "List LwM2MTransportServerConfig.getNetworkConfig()",
      "int LwM2MTransportServerConfig.getOtaPoolSize()",
      "long LwM2MTransportServerConfig.getPagingTransmissionWindow()", "Integer LwM2MTransportServerConfig.getPort()",
      "long LwM2MTransportServerConfig.getPsmActivityTimer()", "String LwM2MTransportServerConfig.getSecureHost()",
      "Integer LwM2MTransportServerConfig.getSecurePort()", "long LwM2MTransportServerConfig.getSessionReportTimeout()",
      "Long LwM2MTransportServerConfig.getTimeout()", "int LwM2MTransportServerConfig.getUplinkPoolSize()",
      "boolean LwM2MTransportServerConfig.isRecommendedCiphers()",
      "boolean LwM2MTransportServerConfig.isRecommendedSupportedGroups()",
      "void LwM2MTransportServerConfig.setCoapConfig(Configuration)",
      "void LwM2MTransportServerConfig.setNetworkConfig(List)"})
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
