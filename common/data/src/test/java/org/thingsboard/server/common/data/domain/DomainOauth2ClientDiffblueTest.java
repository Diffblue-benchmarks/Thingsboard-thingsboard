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
package org.thingsboard.server.common.data.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;

class DomainOauth2ClientDiffblueTest {
  /**
   * Test {@link DomainOauth2Client#equals(Object)}, and {@link DomainOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2Client#equals(Object)}
   *   <li>{@link DomainOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();

    // Act and Assert
    assertEquals(domainOauth2Client, domainOauth2Client2);
    assertEquals(domainOauth2Client.hashCode(), domainOauth2Client2.hashCode());
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}, and {@link DomainOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2Client#equals(Object)}
   *   <li>{@link DomainOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setDomainId(new DomainId(EntityId.NULL_UUID));

    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();
    domainOauth2Client2.setDomainId(new DomainId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(domainOauth2Client, domainOauth2Client2);
    assertEquals(domainOauth2Client.hashCode(), domainOauth2Client2.hashCode());
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}, and {@link DomainOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2Client#equals(Object)}
   *   <li>{@link DomainOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    // Act and Assert
    assertEquals(domainOauth2Client, domainOauth2Client);
    int expectedHashCodeResult = domainOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2Client.hashCode());
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), 1);
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setDomainId(new DomainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, new DomainOauth2Client());
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, new DomainOauth2Client());
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();
    domainOauth2Client2.setDomainId(new DomainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, domainOauth2Client2);
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();
    domainOauth2Client2.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, domainOauth2Client2);
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), null);
  }

  /**
   * Test {@link DomainOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2Client.equals(Object)",
    "int DomainOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), "Different type to DomainOauth2Client");
  }
}
