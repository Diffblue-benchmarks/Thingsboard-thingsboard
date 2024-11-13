package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;

class TbMailContextComponentDiffblueTest {
  /**
   * Test {@link TbMailContextComponent#equals(Object)}, and
   * {@link TbMailContextComponent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMailContextComponent#equals(Object)}
   *   <li>{@link TbMailContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TbMailContextComponent#equals(Object)}, and
   * {@link TbMailContextComponent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMailContextComponent#equals(Object)}
   *   <li>{@link TbMailContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), 1);
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();
    tbMailContextComponent.setAdminSettingsService(new AdminSettingsServiceImpl());

    // Act and Assert
    assertNotEquals(tbMailContextComponent, new TbMailContextComponent());
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();
    tbMailContextComponent.setAdminSettingsService(mock(AdminSettingsService.class));

    // Act and Assert
    assertNotEquals(tbMailContextComponent, new TbMailContextComponent());
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), null);
  }

  /**
   * Test {@link TbMailContextComponent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMailContextComponent(), "Different type to TbMailContextComponent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbMailContextComponent#setAdminSettingsService(AdminSettingsService)}
   *   <li>{@link TbMailContextComponent#toString()}
   *   <li>{@link TbMailContextComponent#getAdminSettingsService()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbMailContextComponent tbMailContextComponent = new TbMailContextComponent();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    // Act
    tbMailContextComponent.setAdminSettingsService(adminSettingsService);
    tbMailContextComponent.toString();
    AdminSettingsService actualAdminSettingsService = tbMailContextComponent.getAdminSettingsService();

    // Assert that nothing has changed
    assertTrue(actualAdminSettingsService instanceof AdminSettingsServiceImpl);
    assertSame(adminSettingsService, actualAdminSettingsService);
  }
}
