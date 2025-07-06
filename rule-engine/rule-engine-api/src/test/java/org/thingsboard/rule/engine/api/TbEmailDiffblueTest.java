package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
  @Tag("MaintainedByDiffblue")
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
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder4 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder4
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
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
  @Tag("MaintainedByDiffblue")
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
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("jane.doe@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc(null)
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("alice.liddell@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from(null)
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(false);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult =
        tbEmailBuilder
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
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
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder3
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("jane.doe@example.org")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder3
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult.images(new HashMap<>()).subject(null).to("alice.liddell@example.org").build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.bcc(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder3
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);

    HashMap<String, String> images = new HashMap<>();
    images.put("ada.lovelace@example.org", "ada.lovelace@example.org");
    TbEmail buildResult =
        htmlResult
            .images(images)
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder4 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder4
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbEmailBuilder builderResult = TbEmail.builder();
    builderResult.bcc("ada.lovelace@example.org");
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder4 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder4
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEmail.equals(Object)", "int TbEmail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbEmailBuilder builderResult = TbEmail.builder();
    builderResult.body("Not all who wander are lost");
    TbEmailBuilder tbEmailBuilder = mock(TbEmailBuilder.class);
    when(tbEmailBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    TbEmailBuilder tbEmailBuilder2 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder2.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder);
    TbEmailBuilder htmlResult =
        tbEmailBuilder2
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();
    TbEmailBuilder tbEmailBuilder3 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder3.body(Mockito.<String>any())).thenReturn(TbEmail.builder());
    TbEmailBuilder tbEmailBuilder4 = mock(TbEmailBuilder.class);
    when(tbEmailBuilder4.bcc(Mockito.<String>any())).thenReturn(tbEmailBuilder3);
    TbEmailBuilder htmlResult2 =
        tbEmailBuilder4
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    TbEmail buildResult2 =
        htmlResult2
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
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
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
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
    TbEmail buildResult =
        htmlResult
            .images(new HashMap<>())
            .subject("Hello from the Dreaming Spires")
            .to("alice.liddell@example.org")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbEmail");
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
    // Arrange
    TbEmailBuilder htmlResult =
        TbEmail.builder()
            .bcc("ada.lovelace@example.org")
            .body("Not all who wander are lost")
            .cc("ada.lovelace@example.org")
            .from("jane.doe@example.org")
            .html(true);
    HashMap<String, String> images = new HashMap<>();

    // Act
    TbEmail actualBuildResult =
        htmlResult
            .images(images)
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
