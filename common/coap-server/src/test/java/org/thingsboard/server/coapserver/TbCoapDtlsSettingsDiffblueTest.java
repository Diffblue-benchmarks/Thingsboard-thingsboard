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
package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;

class TbCoapDtlsSettingsDiffblueTest {
  /**
   * Method under test: {@link TbCoapDtlsSettings#coapDtlsCredentials()}
   */
  @Test
  void testCoapDtlsCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SslCredentialsConfig actualCoapDtlsCredentialsResult = (new TbCoapDtlsSettings()).coapDtlsCredentials();

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
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange
    TbCoapDtlsSettings tbCoapDtlsSettings = new TbCoapDtlsSettings();

    // Act
    Integer actualCIdLength = tbCoapDtlsSettings.getCIdLength();
    SslCredentialsConfig actualCoapDtlsCredentialsConfig = tbCoapDtlsSettings.getCoapDtlsCredentialsConfig();
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
