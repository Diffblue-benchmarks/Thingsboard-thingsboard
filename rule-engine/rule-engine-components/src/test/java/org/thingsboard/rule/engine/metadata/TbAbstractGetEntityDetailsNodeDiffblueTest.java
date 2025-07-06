package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAbstractGetEntityDetailsNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName("Test checkIfDetailsListIsNotEmptyOrElseThrow(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_whenArrayList() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(new ArrayList<>()));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName(
      "Test checkIfDetailsListIsNotEmptyOrElseThrow(List); when 'null'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetCustomerDetailsNode().checkIfDetailsListIsNotEmptyOrElseThrow(null));
  }
}
