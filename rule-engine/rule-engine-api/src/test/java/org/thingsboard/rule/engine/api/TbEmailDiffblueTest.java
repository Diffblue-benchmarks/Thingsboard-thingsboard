package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbEmail.TbEmailBuilder;

class TbEmailDiffblueTest {
  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbEmail.TbEmailBuilder htmlResult = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder4 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder4.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}, and {@link TbEmail#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEmail#equals(Object)}
   *   <li>{@link TbEmail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbEmail.TbEmailBuilder htmlResult = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("jane.doe@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc(null)
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("alice.liddell@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from(null)
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(false);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("jane.doe@example.org")
        .build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>()).subject("Hello from the Dreaming Spires").to(null).build();
    TbEmail.TbEmailBuilder htmlResult2 = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder3.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("jane.doe@example.org")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder3.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>()).subject(null).to("alice.liddell@example.org").build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder3.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);

    HashMap<String, String> images = new HashMap<>();
    images.put("ada.lovelace@example.org", "ada.lovelace@example.org");
    TbEmail buildResult = htmlResult.images(images)
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder4 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder4.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbEmail.TbEmailBuilder builderResult = TbEmail.builder();
    builderResult.bcc("ada.lovelace@example.org");
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder4 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder4.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbEmail.TbEmailBuilder builderResult = TbEmail.builder();
    builderResult.body("Not all who wander are lost");
    TbEmail.TbEmailBuilder tbEmailBuilder = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    TbEmail.TbEmailBuilder tbEmailBuilder2 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmail.TbEmailBuilder htmlResult = tbEmailBuilder2.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();
    TbEmail.TbEmailBuilder tbEmailBuilder3 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmail.TbEmailBuilder tbEmailBuilder4 = mock(TbEmail.TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmail.TbEmailBuilder htmlResult2 = tbEmailBuilder4.bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult2 = htmlResult2.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbEmail.TbEmailBuilder htmlResult = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TbEmail#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEmail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbEmail.TbEmailBuilder htmlResult = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    TbEmail buildResult = htmlResult.images(new HashMap<>())
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbEmail");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbEmail#TbEmail(String, String, String, String, String, String, Map, boolean)}
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
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, String> images = new HashMap<>();

    // Act
    TbEmail actualTbEmail = new TbEmail("jane.doe@example.org", "alice.liddell@example.org", "ada.lovelace@example.org",
        "ada.lovelace@example.org", "Hello from the Dreaming Spires", "Not all who wander are lost", images, true);
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
    assertEquals("TbEmail(from=jane.doe@example.org, to=alice.liddell@example.org, cc=ada.lovelace@example.org,"
        + " bcc=ada.lovelace@example.org, subject=Hello from the Dreaming Spires, body=Not all who wander are"
        + " lost, images={}, html=true)", actualToStringResult);
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEmail.TbEmailBuilder#build()}
   *   <li>{@link TbEmail.TbEmailBuilder#bcc(String)}
   *   <li>{@link TbEmail.TbEmailBuilder#body(String)}
   *   <li>{@link TbEmail.TbEmailBuilder#cc(String)}
   *   <li>{@link TbEmail.TbEmailBuilder#from(String)}
   *   <li>{@link TbEmail.TbEmailBuilder#html(boolean)}
   *   <li>{@link TbEmail.TbEmailBuilder#images(Map)}
   *   <li>{@link TbEmail.TbEmailBuilder#subject(String)}
   *   <li>{@link TbEmail.TbEmailBuilder#to(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TbEmailBuilder build()")
  void testTbEmailBuilderBuild() {
    // Arrange
    TbEmail.TbEmailBuilder htmlResult = TbEmail.builder()
        .bcc("ada.lovelace@example.org")
        .body("Not all who wander are lost")
        .cc("ada.lovelace@example.org")
        .from("jane.doe@example.org")
        .html(true);
    HashMap<String, String> images = new HashMap<>();

    // Act
    TbEmail actualBuildResult = htmlResult.images(images)
        .subject("Hello from the Dreaming Spires")
        .to("alice.liddell@example.org")
        .build();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualBuildResult.getSubject());
    assertEquals("Not all who wander are lost", actualBuildResult.getBody());
    assertEquals("ada.lovelace@example.org", actualBuildResult.getBcc());
    assertEquals("ada.lovelace@example.org", actualBuildResult.getCc());
    assertEquals("alice.liddell@example.org", actualBuildResult.getTo());
    assertEquals("jane.doe@example.org", actualBuildResult.getFrom());
    Map<String, String> images2 = actualBuildResult.getImages();
    assertTrue(images2.isEmpty());
    assertTrue(actualBuildResult.isHtml());
    assertSame(images, images2);
  }
}
