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
package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventUpdateMsgDiffblueTest {
  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}, and {@link EdgeEventUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    int expectedHashCodeResult = edgeEventUpdateMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null), 1);
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, new EdgeId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, null));
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeEventUpdateMsg.equals(Object)", "int EdgeEventUpdateMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, new EdgeId(UUID.randomUUID())));
  }
}
