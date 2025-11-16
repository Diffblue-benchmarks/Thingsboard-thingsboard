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
package org.thingsboard.server.common.data.device.profile.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectAttributesDiffblueTest {
  /**
   * Test {@link ObjectAttributes#getVer()}.
   *
   * <ul>
   *   <li>Given {@link ObjectAttributes} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#getVer()}
   */
  @Test
  @DisplayName("Test getVer(); given ObjectAttributes (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.eclipse.leshan.core.LwM2m.Version ObjectAttributes.getVer()"})
  void testGetVer_givenObjectAttributes_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ObjectAttributes().getVer());
  }

  /**
   * Test {@link ObjectAttributes#getLwm2m()}.
   *
   * <ul>
   *   <li>Given {@link ObjectAttributes} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#getLwm2m()}
   */
  @Test
  @DisplayName("Test getLwm2m(); given ObjectAttributes (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.eclipse.leshan.core.LwM2m.LwM2mVersion ObjectAttributes.getLwm2m()"})
  void testGetLwm2m_givenObjectAttributes_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ObjectAttributes().getLwm2m());
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(3L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(null);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(3L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(null);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(3L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(null);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(null);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(0.5d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(null);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(0.5d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(3L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(null);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(3L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(null);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(2L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(null);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(null);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(0.5d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri(null);
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri(
        "org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes");
    objectAttributes.setVer("Ver");

    ObjectAttributes objectAttributes2 = new ObjectAttributes();
    objectAttributes2.setDim(1L);
    objectAttributes2.setEpmax(1L);
    objectAttributes2.setEpmin(1L);
    objectAttributes2.setGt(10.0d);
    objectAttributes2.setLt(10.0d);
    objectAttributes2.setLwm2m("Lwm2m");
    objectAttributes2.setPmax(1L);
    objectAttributes2.setPmin(1L);
    objectAttributes2.setSsid(1L);
    objectAttributes2.setSt(10.0d);
    objectAttributes2.setUri("Uri");
    objectAttributes2.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, objectAttributes2);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, null);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    // Act and Assert
    assertEquals(objectAttributes, objectAttributes);
  }

  /**
   * Test {@link ObjectAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectAttributes.equals(Object)", "int ObjectAttributes.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    // Act and Assert
    assertNotEquals(objectAttributes, "Different type to ObjectAttributes");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ObjectAttributes}
   *   <li>{@link ObjectAttributes#setDim(Long)}
   *   <li>{@link ObjectAttributes#setEpmax(Long)}
   *   <li>{@link ObjectAttributes#setEpmin(Long)}
   *   <li>{@link ObjectAttributes#setGt(Double)}
   *   <li>{@link ObjectAttributes#setLt(Double)}
   *   <li>{@link ObjectAttributes#setLwm2m(String)}
   *   <li>{@link ObjectAttributes#setPmax(Long)}
   *   <li>{@link ObjectAttributes#setPmin(Long)}
   *   <li>{@link ObjectAttributes#setSsid(Long)}
   *   <li>{@link ObjectAttributes#setSt(Double)}
   *   <li>{@link ObjectAttributes#setUri(String)}
   *   <li>{@link ObjectAttributes#setVer(String)}
   *   <li>{@link ObjectAttributes#getDim()}
   *   <li>{@link ObjectAttributes#getEpmax()}
   *   <li>{@link ObjectAttributes#getEpmin()}
   *   <li>{@link ObjectAttributes#getGt()}
   *   <li>{@link ObjectAttributes#getLt()}
   *   <li>{@link ObjectAttributes#getPmax()}
   *   <li>{@link ObjectAttributes#getPmin()}
   *   <li>{@link ObjectAttributes#getSsid()}
   *   <li>{@link ObjectAttributes#getSt()}
   *   <li>{@link ObjectAttributes#getUri()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ObjectAttributes.<init>()",
    "Long ObjectAttributes.getDim()",
    "Long ObjectAttributes.getEpmax()",
    "Long ObjectAttributes.getEpmin()",
    "Double ObjectAttributes.getGt()",
    "Double ObjectAttributes.getLt()",
    "Long ObjectAttributes.getPmax()",
    "Long ObjectAttributes.getPmin()",
    "Long ObjectAttributes.getSsid()",
    "Double ObjectAttributes.getSt()",
    "String ObjectAttributes.getUri()",
    "void ObjectAttributes.setDim(Long)",
    "void ObjectAttributes.setEpmax(Long)",
    "void ObjectAttributes.setEpmin(Long)",
    "void ObjectAttributes.setGt(Double)",
    "void ObjectAttributes.setLt(Double)",
    "void ObjectAttributes.setLwm2m(String)",
    "void ObjectAttributes.setPmax(Long)",
    "void ObjectAttributes.setPmin(Long)",
    "void ObjectAttributes.setSsid(Long)",
    "void ObjectAttributes.setSt(Double)",
    "void ObjectAttributes.setUri(String)",
    "void ObjectAttributes.setVer(String)",
    "String ObjectAttributes.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ObjectAttributes actualObjectAttributes = new ObjectAttributes();
    actualObjectAttributes.setDim(1L);
    actualObjectAttributes.setEpmax(1L);
    actualObjectAttributes.setEpmin(1L);
    actualObjectAttributes.setGt(10.0d);
    actualObjectAttributes.setLt(10.0d);
    actualObjectAttributes.setLwm2m("Lwm2m");
    actualObjectAttributes.setPmax(1L);
    actualObjectAttributes.setPmin(1L);
    actualObjectAttributes.setSsid(1L);
    actualObjectAttributes.setSt(10.0d);
    actualObjectAttributes.setUri("Uri");
    actualObjectAttributes.setVer("Ver");
    Long actualDim = actualObjectAttributes.getDim();
    Long actualEpmax = actualObjectAttributes.getEpmax();
    Long actualEpmin = actualObjectAttributes.getEpmin();
    Double actualGt = actualObjectAttributes.getGt();
    Double actualLt = actualObjectAttributes.getLt();
    Long actualPmax = actualObjectAttributes.getPmax();
    Long actualPmin = actualObjectAttributes.getPmin();
    Long actualSsid = actualObjectAttributes.getSsid();
    Double actualSt = actualObjectAttributes.getSt();

    // Assert
    assertEquals("Uri", actualObjectAttributes.getUri());
    assertEquals(10.0d, actualGt.doubleValue());
    assertEquals(10.0d, actualLt.doubleValue());
    assertEquals(10.0d, actualSt.doubleValue());
    assertEquals(1L, actualDim.longValue());
    assertEquals(1L, actualEpmax.longValue());
    assertEquals(1L, actualEpmin.longValue());
    assertEquals(1L, actualPmax.longValue());
    assertEquals(1L, actualPmin.longValue());
    assertEquals(1L, actualSsid.longValue());
  }
}
