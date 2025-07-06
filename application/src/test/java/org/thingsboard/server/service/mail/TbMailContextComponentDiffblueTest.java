package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;

class TbMailContextComponentDiffblueTest {
  /**
   * Test {@link TbMailContextComponent#equals(Object)}, and {@link
   * TbMailContextComponent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMailContextComponent#equals(Object)}
   *   <li>{@link TbMailContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();
    TbMailContextComponent tbMailContextComponent2 = new TbMailContextComponent();

    // Act and Assert
    assertEquals(tbMailContextComponent, tbMailContextComponent2);
    int expectedHashCodeResult = tbMailContextComponent.hashCode();
    assertEquals(expectedHashCodeResult, tbMailContextComponent2.hashCode());
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}, and {@link
   * TbMailContextComponent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMailContextComponent#equals(Object)}
   *   <li>{@link TbMailContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();

    // Act and Assert
    assertEquals(tbMailContextComponent, tbMailContextComponent);
    int expectedHashCodeResult = tbMailContextComponent.hashCode();
    assertEquals(expectedHashCodeResult, tbMailContextComponent.hashCode());
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), 1);
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();
    tbMailContextComponent.setAdminSettingsService(new AdminSettingsServiceImpl());

    // Act and Assert
    assertNotEquals(tbMailContextComponent, new TbMailContextComponent());
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();

    TbMailContextComponent tbMailContextComponent2 = new TbMailContextComponent();
    tbMailContextComponent2.setAdminSettingsService(new AdminSettingsServiceImpl());

    // Act and Assert
    assertNotEquals(tbMailContextComponent, tbMailContextComponent2);
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), null);
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbMailContextComponent.equals(Object)",
    "int TbMailContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), "Different type to TbMailContextComponent");
  }
}
