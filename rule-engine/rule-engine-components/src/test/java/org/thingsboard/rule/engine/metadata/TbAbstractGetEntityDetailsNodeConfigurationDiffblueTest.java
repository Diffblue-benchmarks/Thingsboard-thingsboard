package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbAbstractGetEntityDetailsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TbGetCustomerDetailsNodeConfiguration()).canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TbGetCustomerDetailsNodeConfiguration} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TbGetCustomerDetailsNodeConfiguration (default constructor); then return 'true'")
  void testCanEqual_whenTbGetCustomerDetailsNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertTrue(tbGetCustomerDetailsNodeConfiguration.canEqual(new TbGetCustomerDetailsNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 = new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
    int expectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(new ArrayList<>());
    tbGetCustomerDetailsNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 = mock(
        TbGetCustomerDetailsNodeConfiguration.class);
    when(tbGetCustomerDetailsNodeConfiguration2.getDetailsList()).thenReturn(new ArrayList<>());
    when(tbGetCustomerDetailsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetCustomerDetailsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
    int notExpectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}, and
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration);
    int expectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 = mock(
        TbGetCustomerDetailsNodeConfiguration.class);
    when(tbGetCustomerDetailsNodeConfiguration2.getDetailsList()).thenReturn(new ArrayList<>());
    when(tbGetCustomerDetailsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetCustomerDetailsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 = mock(
        TbGetCustomerDetailsNodeConfiguration.class);
    when(tbGetCustomerDetailsNodeConfiguration2.getDetailsList()).thenReturn(new ArrayList<>());
    when(tbGetCustomerDetailsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetCustomerDetailsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);
    tbGetCustomerDetailsNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 = mock(
        TbGetCustomerDetailsNodeConfiguration.class);
    when(tbGetCustomerDetailsNodeConfiguration2.getDetailsList()).thenReturn(new ArrayList<>());
    when(tbGetCustomerDetailsNodeConfiguration2.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetCustomerDetailsNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(),
        "Different type to TbAbstractGetEntityDetailsNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#getDetailsList()}.
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#getDetailsList()}
   */
  @Test
  @DisplayName("Test getDetailsList()")
  void testGetDetailsList() {
    // Arrange, Act and Assert
    assertNull((new TbGetCustomerDetailsNodeConfiguration()).getDetailsList());
  }

  /**
   * Test
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}
   */
  @Test
  @DisplayName("Test setDetailsList(List); given 'ID'; when ArrayList() add 'ID'")
  void testSetDetailsList_givenId_whenArrayListAddId() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    // Act
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);

    // Assert
    assertSame(detailsList, tbGetCustomerDetailsNodeConfiguration.getDetailsList());
  }

  /**
   * Test
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}.
   * <ul>
   *   <li>Given {@code TITLE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code TITLE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}
   */
  @Test
  @DisplayName("Test setDetailsList(List); given 'TITLE'; when ArrayList() add 'TITLE'")
  void testSetDetailsList_givenTitle_whenArrayListAddTitle() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.TITLE);
    detailsList.add(ContactBasedEntityDetails.ID);

    // Act
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);

    // Assert
    assertSame(detailsList, tbGetCustomerDetailsNodeConfiguration.getDetailsList());
  }

  /**
   * Test
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#setDetailsList(List)}
   */
  @Test
  @DisplayName("Test setDetailsList(List); when ArrayList()")
  void testSetDetailsList_whenArrayList() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration = new TbGetCustomerDetailsNodeConfiguration();
    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();

    // Act
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(detailsList);

    // Assert
    assertSame(detailsList, tbGetCustomerDetailsNodeConfiguration.getDetailsList());
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNodeConfiguration#toString()}.
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDetailsNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TbGetCustomerDetailsNodeConfiguration()", (new TbGetCustomerDetailsNodeConfiguration()).toString());
  }
}
