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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MBootstrapClientCredential;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MBootstrapServerCredential;

class LwM2MBootstrapConfigDiffblueTest {
  /**
   * Method under test: {@link LwM2MBootstrapConfig#getLwM2MBootstrapConfig()}
   */
  @Test
  void testGetLwM2MBootstrapConfig() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();
    lwM2MBootstrapConfig.setServerConfiguration(new ArrayList<>());

    // Act
    BootstrapConfig actualLwM2MBootstrapConfig = lwM2MBootstrapConfig.getLwM2MBootstrapConfig();

    // Assert
    assertNull(actualLwM2MBootstrapConfig.contentFormat);
    assertTrue(actualLwM2MBootstrapConfig.toDelete.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.acls.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.oscore.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.security.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.servers.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.autoIdForSecurityObject);
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#getLwM2MBootstrapConfig()}
   */
  @Test
  void testGetLwM2MBootstrapConfig2() {
    // Arrange and Act
    BootstrapConfig actualLwM2MBootstrapConfig = (new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)))
        .getLwM2MBootstrapConfig();

    // Assert
    assertNull(actualLwM2MBootstrapConfig.contentFormat);
    assertTrue(actualLwM2MBootstrapConfig.toDelete.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.acls.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.oscore.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.security.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.servers.isEmpty());
    assertTrue(actualLwM2MBootstrapConfig.autoIdForSecurityObject);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapConfig#equals(Object)}
   *   <li>{@link LwM2MBootstrapConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();
    LwM2MBootstrapConfig lwM2MBootstrapConfig2 = new LwM2MBootstrapConfig();

    // Act and Assert
    assertEquals(lwM2MBootstrapConfig, lwM2MBootstrapConfig2);
    int expectedHashCodeResult = lwM2MBootstrapConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapConfig#equals(Object)}
   *   <li>{@link LwM2MBootstrapConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();

    // Act and Assert
    assertEquals(lwM2MBootstrapConfig, lwM2MBootstrapConfig);
    int expectedHashCodeResult = lwM2MBootstrapConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapConfig.hashCode());
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, new LwM2MBootstrapConfig());
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();
    lwM2MBootstrapConfig.setBootstrapServer(mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, new LwM2MBootstrapConfig());
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();
    lwM2MBootstrapConfig.setLwm2mServer(mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, new LwM2MBootstrapConfig());
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();

    LwM2MBootstrapConfig lwM2MBootstrapConfig2 = new LwM2MBootstrapConfig();
    lwM2MBootstrapConfig2.setBootstrapServer(mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, lwM2MBootstrapConfig2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MBootstrapConfig lwM2MBootstrapConfig = new LwM2MBootstrapConfig();

    LwM2MBootstrapConfig lwM2MBootstrapConfig2 = new LwM2MBootstrapConfig();
    lwM2MBootstrapConfig2.setLwm2mServer(mock(LwM2MBootstrapClientCredential.class));

    // Act and Assert
    assertNotEquals(lwM2MBootstrapConfig, lwM2MBootstrapConfig2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MBootstrapConfig(), null);
  }

  /**
   * Method under test: {@link LwM2MBootstrapConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MBootstrapConfig(), "Different type to LwM2MBootstrapConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapConfig#LwM2MBootstrapConfig()}
   *   <li>
   * {@link LwM2MBootstrapConfig#setBootstrapServer(LwM2MBootstrapClientCredential)}
   *   <li>
   * {@link LwM2MBootstrapConfig#setLwm2mServer(LwM2MBootstrapClientCredential)}
   *   <li>{@link LwM2MBootstrapConfig#setServerConfiguration(List)}
   *   <li>{@link LwM2MBootstrapConfig#toString()}
   *   <li>{@link LwM2MBootstrapConfig#getBootstrapServer()}
   *   <li>{@link LwM2MBootstrapConfig#getLwm2mServer()}
   *   <li>{@link LwM2MBootstrapConfig#getServerConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapConfig actualLwM2MBootstrapConfig = new LwM2MBootstrapConfig();
    LwM2MBootstrapClientCredential bootstrapServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapConfig.setBootstrapServer(bootstrapServer);
    LwM2MBootstrapClientCredential lwm2mServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapConfig.setLwm2mServer(lwm2mServer);
    ArrayList<LwM2MBootstrapServerCredential> serverConfiguration = new ArrayList<>();
    actualLwM2MBootstrapConfig.setServerConfiguration(serverConfiguration);
    actualLwM2MBootstrapConfig.toString();
    LwM2MBootstrapClientCredential actualBootstrapServer = actualLwM2MBootstrapConfig.getBootstrapServer();
    LwM2MBootstrapClientCredential actualLwm2mServer = actualLwM2MBootstrapConfig.getLwm2mServer();
    List<LwM2MBootstrapServerCredential> actualServerConfiguration = actualLwM2MBootstrapConfig
        .getServerConfiguration();

    // Assert that nothing has changed
    assertTrue(actualServerConfiguration.isEmpty());
    BootstrapConfig lwM2MBootstrapConfig = actualLwM2MBootstrapConfig.getLwM2MBootstrapConfig();
    assertTrue(lwM2MBootstrapConfig.toDelete.isEmpty());
    assertTrue(lwM2MBootstrapConfig.acls.isEmpty());
    assertTrue(lwM2MBootstrapConfig.oscore.isEmpty());
    assertTrue(lwM2MBootstrapConfig.security.isEmpty());
    assertTrue(lwM2MBootstrapConfig.servers.isEmpty());
    assertSame(serverConfiguration, actualServerConfiguration);
    assertSame(bootstrapServer, actualBootstrapServer);
    assertSame(lwm2mServer, actualLwm2mServer);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LwM2MBootstrapConfig#LwM2MBootstrapConfig(List, LwM2MBootstrapClientCredential, LwM2MBootstrapClientCredential)}
   *   <li>
   * {@link LwM2MBootstrapConfig#setBootstrapServer(LwM2MBootstrapClientCredential)}
   *   <li>
   * {@link LwM2MBootstrapConfig#setLwm2mServer(LwM2MBootstrapClientCredential)}
   *   <li>{@link LwM2MBootstrapConfig#setServerConfiguration(List)}
   *   <li>{@link LwM2MBootstrapConfig#toString()}
   *   <li>{@link LwM2MBootstrapConfig#getBootstrapServer()}
   *   <li>{@link LwM2MBootstrapConfig#getLwm2mServer()}
   *   <li>{@link LwM2MBootstrapConfig#getServerConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    LwM2MBootstrapConfig actualLwM2MBootstrapConfig = new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class));
    LwM2MBootstrapClientCredential bootstrapServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapConfig.setBootstrapServer(bootstrapServer);
    LwM2MBootstrapClientCredential lwm2mServer = mock(LwM2MBootstrapClientCredential.class);
    actualLwM2MBootstrapConfig.setLwm2mServer(lwm2mServer);
    ArrayList<LwM2MBootstrapServerCredential> serverConfiguration = new ArrayList<>();
    actualLwM2MBootstrapConfig.setServerConfiguration(serverConfiguration);
    actualLwM2MBootstrapConfig.toString();
    LwM2MBootstrapClientCredential actualBootstrapServer = actualLwM2MBootstrapConfig.getBootstrapServer();
    LwM2MBootstrapClientCredential actualLwm2mServer = actualLwM2MBootstrapConfig.getLwm2mServer();
    List<LwM2MBootstrapServerCredential> actualServerConfiguration = actualLwM2MBootstrapConfig
        .getServerConfiguration();

    // Assert that nothing has changed
    assertTrue(actualServerConfiguration.isEmpty());
    BootstrapConfig lwM2MBootstrapConfig = actualLwM2MBootstrapConfig.getLwM2MBootstrapConfig();
    assertTrue(lwM2MBootstrapConfig.toDelete.isEmpty());
    assertTrue(lwM2MBootstrapConfig.acls.isEmpty());
    assertTrue(lwM2MBootstrapConfig.oscore.isEmpty());
    assertTrue(lwM2MBootstrapConfig.security.isEmpty());
    assertTrue(lwM2MBootstrapConfig.servers.isEmpty());
    assertSame(serverConfiguration, actualServerConfiguration);
    assertSame(bootstrapServer, actualBootstrapServer);
    assertSame(lwm2mServer, actualLwm2mServer);
  }
}
