package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAbstractGetEntityDataNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code FIELDS}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'FIELDS'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAbstractGetEntityDataNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenFields_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            new TbGetCustomerAttributeNode()
                .checkDataToFetchSupportedOrElseThrow(DataToFetch.FIELDS));
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'null'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbAbstractGetEntityDataNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetCustomerAttributeNode().checkDataToFetchSupportedOrElseThrow(null));
  }
}
