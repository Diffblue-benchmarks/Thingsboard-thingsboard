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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.SecurityMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MServerBootstrapDiffblueTest {
  /**
   * Test {@link LwM2MServerBootstrap#LwM2MServerBootstrap()}.
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#LwM2MServerBootstrap()}
   */
  @Test
  @DisplayName("Test new LwM2MServerBootstrap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MServerBootstrap.<init>()"})
  void testNewLwM2MServerBootstrap() {
    // Arrange and Act
    LwM2MServerBootstrap actualLwM2MServerBootstrap = new LwM2MServerBootstrap();

    // Assert
    assertEquals("", actualLwM2MServerBootstrap.getClientPublicKeyOrId());
    assertEquals("", actualLwM2MServerBootstrap.getClientSecretKey());
    assertEquals("", actualLwM2MServerBootstrap.getServerPublicKey());
    assertEquals("0.0.0.0", actualLwM2MServerBootstrap.getHost());
    assertEquals("0.0.0.0", actualLwM2MServerBootstrap.getSecurityHost());
    assertEquals(0, actualLwM2MServerBootstrap.getBootstrapServerAccountTimeout().intValue());
    assertEquals(0, actualLwM2MServerBootstrap.getPort().intValue());
    assertEquals(0, actualLwM2MServerBootstrap.getSecurityPort().intValue());
    assertEquals(1, actualLwM2MServerBootstrap.getClientHoldOffTime().intValue());
    assertEquals(123, actualLwM2MServerBootstrap.getServerId().intValue());
    assertEquals(SecurityMode.NO_SEC, actualLwM2MServerBootstrap.getSecurityMode());
    assertFalse(actualLwM2MServerBootstrap.isBootstrapServerIs());
  }

  /**
   * Test {@link LwM2MServerBootstrap#LwM2MServerBootstrap(LwM2MServerBootstrap,
   * LwM2MServerBootstrap)}.
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#LwM2MServerBootstrap(LwM2MServerBootstrap,
   * LwM2MServerBootstrap)}
   */
  @Test
  @DisplayName("Test new LwM2MServerBootstrap(LwM2MServerBootstrap, LwM2MServerBootstrap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MServerBootstrap.<init>(LwM2MServerBootstrap, LwM2MServerBootstrap)"
  })
  void testNewLwM2MServerBootstrap2() {
    // Arrange
    LwM2MServerBootstrap bootstrapFromCredential = new LwM2MServerBootstrap();
    LwM2MServerBootstrap bootstrapFromCredential2 = new LwM2MServerBootstrap();
    LwM2MServerBootstrap profileServerBootstrap =
        new LwM2MServerBootstrap(bootstrapFromCredential2, new LwM2MServerBootstrap());

    // Act
    LwM2MServerBootstrap actualLwM2MServerBootstrap =
        new LwM2MServerBootstrap(bootstrapFromCredential, profileServerBootstrap);

    // Assert
    assertEquals(profileServerBootstrap, actualLwM2MServerBootstrap);
  }

  /**
   * Test {@link LwM2MServerBootstrap#LwM2MServerBootstrap(LwM2MServerBootstrap,
   * LwM2MServerBootstrap)}.
   *
   * <ul>
   *   <li>Then return ClientPublicKeyOrId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#LwM2MServerBootstrap(LwM2MServerBootstrap,
   * LwM2MServerBootstrap)}
   */
  @Test
  @DisplayName(
      "Test new LwM2MServerBootstrap(LwM2MServerBootstrap, LwM2MServerBootstrap); then return ClientPublicKeyOrId is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MServerBootstrap.<init>(LwM2MServerBootstrap, LwM2MServerBootstrap)"
  })
  void testNewLwM2MServerBootstrap_thenReturnClientPublicKeyOrIdIsEmptyString() {
    // Arrange
    LwM2MServerBootstrap bootstrapFromCredential = new LwM2MServerBootstrap();

    // Act
    LwM2MServerBootstrap actualLwM2MServerBootstrap =
        new LwM2MServerBootstrap(bootstrapFromCredential, new LwM2MServerBootstrap());

    // Assert
    assertEquals("", actualLwM2MServerBootstrap.getClientPublicKeyOrId());
    assertEquals("", actualLwM2MServerBootstrap.getClientSecretKey());
    assertEquals("", actualLwM2MServerBootstrap.getServerPublicKey());
    assertEquals("localhost", actualLwM2MServerBootstrap.getHost());
    assertEquals("localhost", actualLwM2MServerBootstrap.getSecurityHost());
    assertEquals(0, actualLwM2MServerBootstrap.getBootstrapServerAccountTimeout().intValue());
    assertEquals(0, actualLwM2MServerBootstrap.getPort().intValue());
    assertEquals(0, actualLwM2MServerBootstrap.getSecurityPort().intValue());
    assertEquals(1, actualLwM2MServerBootstrap.getClientHoldOffTime().intValue());
    assertEquals(123, actualLwM2MServerBootstrap.getServerId().intValue());
    assertEquals(SecurityMode.NO_SEC, actualLwM2MServerBootstrap.getSecurityMode());
    assertFalse(actualLwM2MServerBootstrap.isBootstrapServerIs());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}, and {@link LwM2MServerBootstrap#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MServerBootstrap#equals(Object)}
   *   <li>{@link LwM2MServerBootstrap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    LwM2MServerBootstrap lwM2MServerBootstrap2 = new LwM2MServerBootstrap();

    // Act and Assert
    assertEquals(lwM2MServerBootstrap, lwM2MServerBootstrap2);
    assertEquals(lwM2MServerBootstrap.hashCode(), lwM2MServerBootstrap2.hashCode());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}, and {@link LwM2MServerBootstrap#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MServerBootstrap#equals(Object)}
   *   <li>{@link LwM2MServerBootstrap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();

    // Act and Assert
    assertEquals(lwM2MServerBootstrap, lwM2MServerBootstrap);
    int expectedHashCodeResult = lwM2MServerBootstrap.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MServerBootstrap.hashCode());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MServerBootstrap bootstrapFromCredential = new LwM2MServerBootstrap();
    LwM2MServerBootstrap lwM2MServerBootstrap =
        new LwM2MServerBootstrap(bootstrapFromCredential, new LwM2MServerBootstrap());

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setClientPublicKeyOrId("42");

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setServerPublicKey("0.0.0.0");

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setBootstrapServerAccountTimeout(3);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setPort(8080);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityHost("localhost");

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityPort(8080);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityMode(SecurityMode.PSK);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setServerId(1);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setBootstrapServerIs(true);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setClientPublicKeyOrId(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setClientSecretKey(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setServerPublicKey(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setBootstrapServerAccountTimeout(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setPort(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityHost(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityPort(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setSecurityMode(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();
    lwM2MServerBootstrap.setServerId(null);

    // Act and Assert
    assertNotEquals(lwM2MServerBootstrap, new LwM2MServerBootstrap());
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MServerBootstrap(), null);
  }

  /**
   * Test {@link LwM2MServerBootstrap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MServerBootstrap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MServerBootstrap.equals(Object)",
    "int LwM2MServerBootstrap.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MServerBootstrap(), "Different type to LwM2MServerBootstrap");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MServerBootstrap#setBootstrapServerAccountTimeout(Integer)}
   *   <li>{@link LwM2MServerBootstrap#setBootstrapServerIs(boolean)}
   *   <li>{@link LwM2MServerBootstrap#setClientHoldOffTime(Integer)}
   *   <li>{@link LwM2MServerBootstrap#setClientPublicKeyOrId(String)}
   *   <li>{@link LwM2MServerBootstrap#setClientSecretKey(String)}
   *   <li>{@link LwM2MServerBootstrap#setHost(String)}
   *   <li>{@link LwM2MServerBootstrap#setPort(Integer)}
   *   <li>{@link LwM2MServerBootstrap#setSecurityHost(String)}
   *   <li>{@link LwM2MServerBootstrap#setSecurityMode(SecurityMode)}
   *   <li>{@link LwM2MServerBootstrap#setSecurityPort(Integer)}
   *   <li>{@link LwM2MServerBootstrap#setServerId(Integer)}
   *   <li>{@link LwM2MServerBootstrap#setServerPublicKey(String)}
   *   <li>{@link LwM2MServerBootstrap#toString()}
   *   <li>{@link LwM2MServerBootstrap#getBootstrapServerAccountTimeout()}
   *   <li>{@link LwM2MServerBootstrap#getClientHoldOffTime()}
   *   <li>{@link LwM2MServerBootstrap#getClientPublicKeyOrId()}
   *   <li>{@link LwM2MServerBootstrap#getClientSecretKey()}
   *   <li>{@link LwM2MServerBootstrap#getHost()}
   *   <li>{@link LwM2MServerBootstrap#getPort()}
   *   <li>{@link LwM2MServerBootstrap#getSecurityHost()}
   *   <li>{@link LwM2MServerBootstrap#getSecurityMode()}
   *   <li>{@link LwM2MServerBootstrap#getSecurityPort()}
   *   <li>{@link LwM2MServerBootstrap#getServerId()}
   *   <li>{@link LwM2MServerBootstrap#getServerPublicKey()}
   *   <li>{@link LwM2MServerBootstrap#isBootstrapServerIs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer LwM2MServerBootstrap.getBootstrapServerAccountTimeout()",
    "Integer LwM2MServerBootstrap.getClientHoldOffTime()",
    "String LwM2MServerBootstrap.getClientPublicKeyOrId()",
    "String LwM2MServerBootstrap.getClientSecretKey()",
    "String LwM2MServerBootstrap.getHost()",
    "Integer LwM2MServerBootstrap.getPort()",
    "String LwM2MServerBootstrap.getSecurityHost()",
    "SecurityMode LwM2MServerBootstrap.getSecurityMode()",
    "Integer LwM2MServerBootstrap.getSecurityPort()",
    "Integer LwM2MServerBootstrap.getServerId()",
    "String LwM2MServerBootstrap.getServerPublicKey()",
    "boolean LwM2MServerBootstrap.isBootstrapServerIs()",
    "void LwM2MServerBootstrap.setBootstrapServerAccountTimeout(Integer)",
    "void LwM2MServerBootstrap.setBootstrapServerIs(boolean)",
    "void LwM2MServerBootstrap.setClientHoldOffTime(Integer)",
    "void LwM2MServerBootstrap.setClientPublicKeyOrId(String)",
    "void LwM2MServerBootstrap.setClientSecretKey(String)",
    "void LwM2MServerBootstrap.setHost(String)",
    "void LwM2MServerBootstrap.setPort(Integer)",
    "void LwM2MServerBootstrap.setSecurityHost(String)",
    "void LwM2MServerBootstrap.setSecurityMode(SecurityMode)",
    "void LwM2MServerBootstrap.setSecurityPort(Integer)",
    "void LwM2MServerBootstrap.setServerId(Integer)",
    "void LwM2MServerBootstrap.setServerPublicKey(String)",
    "String LwM2MServerBootstrap.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2MServerBootstrap lwM2MServerBootstrap = new LwM2MServerBootstrap();

    // Act
    lwM2MServerBootstrap.setBootstrapServerAccountTimeout(3);
    lwM2MServerBootstrap.setBootstrapServerIs(true);
    lwM2MServerBootstrap.setClientHoldOffTime(1);
    lwM2MServerBootstrap.setClientPublicKeyOrId("42");
    lwM2MServerBootstrap.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    lwM2MServerBootstrap.setHost("localhost");
    lwM2MServerBootstrap.setPort(8080);
    lwM2MServerBootstrap.setSecurityHost("localhost");
    lwM2MServerBootstrap.setSecurityMode(SecurityMode.PSK);
    lwM2MServerBootstrap.setSecurityPort(8080);
    lwM2MServerBootstrap.setServerId(1);
    lwM2MServerBootstrap.setServerPublicKey("Server Public Key");
    String actualToStringResult = lwM2MServerBootstrap.toString();
    Integer actualBootstrapServerAccountTimeout =
        lwM2MServerBootstrap.getBootstrapServerAccountTimeout();
    Integer actualClientHoldOffTime = lwM2MServerBootstrap.getClientHoldOffTime();
    String actualClientPublicKeyOrId = lwM2MServerBootstrap.getClientPublicKeyOrId();
    String actualClientSecretKey = lwM2MServerBootstrap.getClientSecretKey();
    String actualHost = lwM2MServerBootstrap.getHost();
    Integer actualPort = lwM2MServerBootstrap.getPort();
    String actualSecurityHost = lwM2MServerBootstrap.getSecurityHost();
    SecurityMode actualSecurityMode = lwM2MServerBootstrap.getSecurityMode();
    Integer actualSecurityPort = lwM2MServerBootstrap.getSecurityPort();
    Integer actualServerId = lwM2MServerBootstrap.getServerId();
    String actualServerPublicKey = lwM2MServerBootstrap.getServerPublicKey();
    boolean actualIsBootstrapServerIsResult = lwM2MServerBootstrap.isBootstrapServerIs();

    // Assert
    assertEquals("42", actualClientPublicKeyOrId);
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualClientSecretKey);
    assertEquals(
        "LwM2MServerBootstrap(clientPublicKeyOrId=42, clientSecretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY,"
            + " serverPublicKey=Server Public Key, clientHoldOffTime=1, bootstrapServerAccountTimeout=3, host=localhost,"
            + " port=8080, securityHost=localhost, securityPort=8080, securityMode=PSK, serverId=1, bootstrapServerIs"
            + "=true)",
        actualToStringResult);
    assertEquals("Server Public Key", actualServerPublicKey);
    assertEquals("localhost", actualHost);
    assertEquals("localhost", actualSecurityHost);
    assertEquals(1, actualClientHoldOffTime.intValue());
    assertEquals(1, actualServerId.intValue());
    assertEquals(3, actualBootstrapServerAccountTimeout.intValue());
    assertEquals(8080, actualPort.intValue());
    assertEquals(8080, actualSecurityPort.intValue());
    assertEquals(SecurityMode.PSK, actualSecurityMode);
    assertTrue(actualIsBootstrapServerIsResult);
  }
}
