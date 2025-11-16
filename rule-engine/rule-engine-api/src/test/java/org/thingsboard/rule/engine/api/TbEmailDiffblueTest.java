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
package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.TbEmail.TbEmailBuilder;

@ContextConfiguration(classes = {TbEmailBuilder.class})
@ExtendWith(SpringExtension.class)
class TbEmailDiffblueTest {
  @Autowired private TbEmailBuilder tbEmailBuilder;

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertEquals(tbEmail, tbEmail2);
    assertEquals(tbEmail.hashCode(), tbEmail2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc(null)
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc(null)
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertEquals(tbEmail, tbEmail2);
    assertEquals(tbEmail.hashCode(), tbEmail2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body(null)
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body(null)
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertEquals(tbEmail, tbEmail2);
    assertEquals(tbEmail.hashCode(), tbEmail2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertEquals(tbEmail, tbEmail);
    int expectedHashCodeResult = tbEmail.hashCode();
    assertEquals(expectedHashCodeResult, tbEmail.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("mary.somerville@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc(null)
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("jane.doe@example.org")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body(null)
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("jane.doe@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc(null)
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("alice.liddell@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from(null)
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(false);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    HashMap<String, String> images = new HashMap<>();
    images.put("jane.doe@example.org", "42");
    TbEmail tbEmail =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true)
            .images(images)
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("jane.doe@example.org")
            .to("alice.liddell@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult.images(new HashMap<>()).subject(null).to("alice.liddell@example.org").build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("jane.doe@example.org")
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail tbEmail =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to(null)
            .build();

    TbEmailBuilder htmlResult2 =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        tbEmail,
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build(),
        null);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    // Act and Assert
    assertNotEquals(
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build(),
        "Different type to TbEmail");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmail#TbEmail(String, String, String, String, String, String, Map, boolean)}
   *   <li>{@link TbEmail#toString()}
   *   <li>{@link TbEmail#getBcc()}
   *   <li>{@link TbEmail#getBody()}
   *   <li>{@link TbEmail#getCc()}
   *   <li>{@link TbEmail#getFrom()}
   *   <li>{@link TbEmail#getImages()}
   *   <li>{@link TbEmail#getSubject()}
   *   <li>{@link TbEmail#getTo()}
   *   <li>{@link TbEmail#isHtml()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbEmail.<init>(String, String, String, String, String, String, Map, boolean)",
    "String TbEmail.getBcc()",
    "String TbEmail.getBody()",
    "String TbEmail.getCc()",
    "String TbEmail.getFrom()",
    "Map TbEmail.getImages()",
    "String TbEmail.getSubject()",
    "String TbEmail.getTo()",
    "boolean TbEmail.isHtml()",
    "String TbEmail.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, String> images = new HashMap<>();

    // Act
    TbEmail actualTbEmail =
        new TbEmail(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "ada.lovelace@example.org",
            "ada.lovelace@example.org",
            "Hello from the Dreaming Spires",
            "Not all who wander are lost",
            images,
            true);
    String actualToStringResult = actualTbEmail.toString();
    String actualBcc = actualTbEmail.getBcc();
    String actualBody = actualTbEmail.getBody();
    String actualCc = actualTbEmail.getCc();
    String actualFrom = actualTbEmail.getFrom();
    Map<String, String> actualImages = actualTbEmail.getImages();
    String actualSubject = actualTbEmail.getSubject();
    String actualTo = actualTbEmail.getTo();
    boolean actualIsHtmlResult = actualTbEmail.isHtml();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals(
        "TbEmail(from=jane.doe@example.org, to=alice.liddell@example.org, cc=ada.lovelace@example.org,"
            + " bcc=ada.lovelace@example.org, subject=Hello from the Dreaming Spires, body=Not all who wander are"
            + " lost, images={}, html=true)",
        actualToStringResult);
    assertEquals("ada.lovelace@example.org", actualBcc);
    assertEquals("ada.lovelace@example.org", actualCc);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
    assertTrue(actualImages.isEmpty());
    assertTrue(actualIsHtmlResult);
    assertSame(images, actualImages);
  }

  /**
   * Test TbEmailBuilder {@link TbEmailBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEmailBuilder#build()}
   *   <li>{@link TbEmailBuilder#bcc(String)}
   *   <li>{@link TbEmailBuilder#body(String)}
   *   <li>{@link TbEmailBuilder#cc(String)}
   *   <li>{@link TbEmailBuilder#from(String)}
   *   <li>{@link TbEmailBuilder#html(boolean)}
   *   <li>{@link TbEmailBuilder#images(Map)}
   *   <li>{@link TbEmailBuilder#subject(String)}
   *   <li>{@link TbEmailBuilder#to(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbEmailBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbEmailBuilder.<init>()",
    "TbEmailBuilder TbEmailBuilder.bcc(String)",
    "TbEmailBuilder TbEmailBuilder.body(String)",
    "TbEmail TbEmailBuilder.build()",
    "TbEmailBuilder TbEmailBuilder.cc(String)",
    "TbEmailBuilder TbEmailBuilder.from(String)",
    "TbEmailBuilder TbEmailBuilder.html(boolean)",
    "TbEmailBuilder TbEmailBuilder.images(Map)",
    "TbEmailBuilder TbEmailBuilder.subject(String)",
    "TbEmailBuilder TbEmailBuilder.to(String)",
    "String TbEmailBuilder.toString()"
  })
  void testTbEmailBuilderBuild() {
    // Arrange and Act
    TbEmailBuilder actualHtmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    HashMap<String, String> images = new HashMap<>();
    TbEmail actualTbEmail =
        actualHtmlResult
            .images(images)
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualTbEmail.getSubject());
    assertEquals("Not all who wander are lost", actualTbEmail.getBody());
    assertEquals("ada.lovelace@example.org", actualTbEmail.getBcc());
    assertEquals("ada.lovelace@example.org", actualTbEmail.getCc());
    assertEquals("alice.liddell@example.org", actualTbEmail.getTo());
    assertEquals("jane.doe@example.org", actualTbEmail.getFrom());
    Map<String, String> images2 = actualTbEmail.getImages();
    assertTrue(images2.isEmpty());
    assertTrue(actualTbEmail.isHtml());
    assertSame(images, images2);
  }
}
