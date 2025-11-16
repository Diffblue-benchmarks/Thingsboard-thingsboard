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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAbstractGetMappedDataNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}
   */
  @Test
  @DisplayName("Test checkIfMappingIsNotEmptyOrElseThrow(Map); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetMappedDataNode.checkIfMappingIsNotEmptyOrElseThrow(Map)"})
  void testCheckIfMappingIsNotEmptyOrElseThrow_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("At least one mapping entry should be specified!", "42");

    // Act and Assert
    assertDoesNotThrow(
        () -> tbGetCustomerAttributeNode.checkIfMappingIsNotEmptyOrElseThrow(dataMapping));
  }

  /**
   * Test {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}
   */
  @Test
  @DisplayName(
      "Test checkIfMappingIsNotEmptyOrElseThrow(Map); when HashMap(); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetMappedDataNode.checkIfMappingIsNotEmptyOrElseThrow(Map)"})
  void testCheckIfMappingIsNotEmptyOrElseThrow_whenHashMap_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerAttributeNode.checkIfMappingIsNotEmptyOrElseThrow(new HashMap<>()));
  }

  /**
   * Test {@link TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetMappedDataNode#checkIfMappingIsNotEmptyOrElseThrow(Map)}
   */
  @Test
  @DisplayName(
      "Test checkIfMappingIsNotEmptyOrElseThrow(Map); when 'null'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetMappedDataNode.checkIfMappingIsNotEmptyOrElseThrow(Map)"})
  void testCheckIfMappingIsNotEmptyOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetCustomerAttributeNode().checkIfMappingIsNotEmptyOrElseThrow(null));
  }
}
