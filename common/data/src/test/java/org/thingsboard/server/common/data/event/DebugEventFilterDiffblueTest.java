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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DebugEventFilterDiffblueTest {
  /**
   * Method under test: {@link DebugEventFilter#setIsError(boolean)}
   */
  @Test
  void testSetIsError() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setIsError(true);

    // Assert
    assertTrue(ruleChainDebugEventFilter.isError());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).canEqual("Other"));
  }

  /**
   * Method under test: {@link DebugEventFilter#getErrorStr()}
   */
  @Test
  void testGetErrorStr() {
    // Arrange, Act and Assert
    assertNull((new RuleChainDebugEventFilter()).getErrorStr());
  }

  /**
   * Method under test: {@link DebugEventFilter#getServer()}
   */
  @Test
  void testGetServer() {
    // Arrange, Act and Assert
    assertNull((new RuleChainDebugEventFilter()).getServer());
  }

  /**
   * Method under test: {@link DebugEventFilter#isError()}
   */
  @Test
  void testIsError() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).isError());
  }

  /**
   * Method under test: {@link DebugEventFilter#isError()}
   */
  @Test
  void testIsError2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isError());
  }

  /**
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setServer(null);
    ruleChainDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertFalse(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setServer(null);
    ruleChainDebugEventFilter.setErrorStr("foo");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setServer("foo");
    ruleChainDebugEventFilter.setErrorStr(null);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.canEqual(new RuleChainDebugEventFilter()));
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter.hashCode());
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleNodeDebugEventFilter);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(true);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(true);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("Server");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setServer("org.thingsboard.server.common.data.event.DebugEventFilter");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn("Server");
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("Error Str");
    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = mock(RuleChainDebugEventFilter.class);
    when(ruleChainDebugEventFilter2.isError()).thenReturn(false);
    when(ruleChainDebugEventFilter2.getErrorStr()).thenReturn("An error occurred");
    when(ruleChainDebugEventFilter2.getServer()).thenReturn(null);
    when(ruleChainDebugEventFilter2.getMessage()).thenReturn("Not all who wander are lost");
    when(ruleChainDebugEventFilter2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainDebugEventFilter(), null);
  }

  /**
   * Method under test: {@link DebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainDebugEventFilter(), "Different type to DebugEventFilter");
  }

  /**
   * Method under test: {@link DebugEventFilter#setErrorStr(String)}
   */
  @Test
  void testSetErrorStr() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setErrorStr("An error occurred");

    // Assert
    assertEquals("An error occurred", ruleChainDebugEventFilter.getErrorStr());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#setServer(String)}
   */
  @Test
  void testSetServer() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();

    // Act
    ruleChainDebugEventFilter.setServer("Server");

    // Assert
    assertEquals("Server", ruleChainDebugEventFilter.getServer());
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link DebugEventFilter#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("RuleChainDebugEventFilter(message=null)", (new RuleChainDebugEventFilter()).toString());
  }
}
