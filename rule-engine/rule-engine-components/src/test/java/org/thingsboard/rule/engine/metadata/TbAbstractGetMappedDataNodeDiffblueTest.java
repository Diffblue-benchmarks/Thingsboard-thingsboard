package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAbstractGetMappedDataNodeDiffblueTest {
  /**
   * Test
   * {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}
   */
  @Test
  @DisplayName("Test checkIfMappingIsNotEmptyOrElseThrow(Map); when HashMap(); then throw TbNodeException")
  void testCheckIfMappingIsNotEmptyOrElseThrow_whenHashMap_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbGetCustomerAttributeNode.checkIfMappingIsNotEmptyOrElseThrow(new HashMap<>()));
  }

  /**
   * Test
   * {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}
   */
  @Test
  @DisplayName("Test checkIfMappingIsNotEmptyOrElseThrow(Map); when 'null'; then throw TbNodeException")
  void testCheckIfMappingIsNotEmptyOrElseThrow_whenNull_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class,
        () -> (new TbGetCustomerAttributeNode()).checkIfMappingIsNotEmptyOrElseThrow(null));
  }
}
