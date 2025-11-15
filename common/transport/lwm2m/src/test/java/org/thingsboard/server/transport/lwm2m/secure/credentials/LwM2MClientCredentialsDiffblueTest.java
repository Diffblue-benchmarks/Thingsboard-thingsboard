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
package org.thingsboard.server.transport.lwm2m.secure.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MBootstrapClientCredential;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MClientCredential;
import org.thingsboard.server.common.data.device.credentials.lwm2m.NoSecClientCredential;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;

class LwM2MClientCredentialsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(null);
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(null);
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientCredentials#equals(Object)}
   *   <li>{@link LwM2MClientCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertEquals(lwM2MClientCredentials, lwM2MClientCredentials);
    int expectedHashCodeResult = lwM2MClientCredentials.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientCredentials.hashCode());
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(null);
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
    lwM2MClientCredentials.setClient(null);

    LwM2MClientCredentials lwM2MClientCredentials2 = new LwM2MClientCredentials();
    lwM2MClientCredentials2.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials2.setClient(null);

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, lwM2MClientCredentials2);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, null);
  }

  /**
   * Method under test: {@link LwM2MClientCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MClientCredentials lwM2MClientCredentials = new LwM2MClientCredentials();
    lwM2MClientCredentials.setBootstrap(new LwM2MBootstrapConfig());
    lwM2MClientCredentials.setClient(new NoSecClientCredential());

    // Act and Assert
    assertNotEquals(lwM2MClientCredentials, "Different type to LwM2MClientCredentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MClientCredentials}
   *   <li>{@link LwM2MClientCredentials#setBootstrap(LwM2MBootstrapConfig)}
   *   <li>{@link LwM2MClientCredentials#setClient(LwM2MClientCredential)}
   *   <li>{@link LwM2MClientCredentials#toString()}
   *   <li>{@link LwM2MClientCredentials#getBootstrap()}
   *   <li>{@link LwM2MClientCredentials#getClient()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MClientCredentials actualLwM2MClientCredentials = new LwM2MClientCredentials();
    LwM2MBootstrapConfig bootstrap = new LwM2MBootstrapConfig();
    actualLwM2MClientCredentials.setBootstrap(bootstrap);
    NoSecClientCredential client = new NoSecClientCredential();
    actualLwM2MClientCredentials.setClient(client);
    actualLwM2MClientCredentials.toString();
    LwM2MBootstrapConfig actualBootstrap = actualLwM2MClientCredentials.getBootstrap();

    // Assert that nothing has changed
    assertSame(client, actualLwM2MClientCredentials.getClient());
    assertSame(bootstrap, actualBootstrap);
  }
}
