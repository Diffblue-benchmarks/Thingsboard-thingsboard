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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RuleNodeDebugEventFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventFilter#equals(Object)}
   *   <li>{@link RuleNodeDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
    int expectedHashCodeResult = ruleNodeDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new RuleNodeDebugEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setServer("Server");
    ruleNodeDebugEventFilter.setMetadataSearch(null);
    ruleNodeDebugEventFilter.setRelationType(null);
    ruleNodeDebugEventFilter.setMsgType(null);
    ruleNodeDebugEventFilter.setMsgDirectionType(null);
    ruleNodeDebugEventFilter.setEntityType(null);
    ruleNodeDebugEventFilter.setMsgId(null);
    ruleNodeDebugEventFilter.setDataSearch(null);
    ruleNodeDebugEventFilter.setEntityId(null);

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setEntityId("42");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setEntityType("Entity Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty6() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgId("42");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty7() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgType("Msg Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty8() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setRelationType("Relation Type");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty9() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty10() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty11() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty12() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");

    // Act and Assert
    assertTrue(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty13() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setMsgDirectionType("");

    // Act and Assert
    assertFalse(ruleNodeDebugEventFilter.isNotEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventFilter#equals(Object)}
   *   <li>{@link RuleNodeDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    assertEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter);
    int expectedHashCodeResult = ruleNodeDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventFilter.hashCode());
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Server");
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

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch(null);
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

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("Server");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId(null);
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Server");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType(null);
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("Server");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Server");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch(null);
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Server");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType(null);
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("Server");
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId(null);
    ruleNodeDebugEventFilter.setMsgType("Msg Type");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType("Server");
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeDebugEventFilter ruleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter.setDataSearch("Data Search");
    ruleNodeDebugEventFilter.setEntityId("42");
    ruleNodeDebugEventFilter.setEntityType("Entity Type");
    ruleNodeDebugEventFilter.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter.setIsError(true);
    ruleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter.setMsgId("42");
    ruleNodeDebugEventFilter.setMsgType(null);
    ruleNodeDebugEventFilter.setRelationType("Relation Type");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
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
    ruleNodeDebugEventFilter.setRelationType("Server");
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
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
    ruleNodeDebugEventFilter.setRelationType(null);
    ruleNodeDebugEventFilter.setServer("Server");

    RuleNodeDebugEventFilter ruleNodeDebugEventFilter2 = new RuleNodeDebugEventFilter();
    ruleNodeDebugEventFilter2.setDataSearch("Data Search");
    ruleNodeDebugEventFilter2.setEntityId("42");
    ruleNodeDebugEventFilter2.setEntityType("Entity Type");
    ruleNodeDebugEventFilter2.setErrorStr("An error occurred");
    ruleNodeDebugEventFilter2.setIsError(true);
    ruleNodeDebugEventFilter2.setMetadataSearch("Metadata Search");
    ruleNodeDebugEventFilter2.setMsgDirectionType("Msg Direction Type");
    ruleNodeDebugEventFilter2.setMsgId("42");
    ruleNodeDebugEventFilter2.setMsgType("Msg Type");
    ruleNodeDebugEventFilter2.setRelationType("Relation Type");
    ruleNodeDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventFilter, ruleNodeDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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
    assertNotEquals(ruleNodeDebugEventFilter, null);
  }

  /**
   * Method under test: {@link RuleNodeDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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
    assertNotEquals(ruleNodeDebugEventFilter, "Different type to RuleNodeDebugEventFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleNodeDebugEventFilter}
   *   <li>{@link RuleNodeDebugEventFilter#setDataSearch(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setEntityId(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setEntityType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMetadataSearch(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgDirectionType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgId(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setMsgType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#setRelationType(String)}
   *   <li>{@link RuleNodeDebugEventFilter#toString()}
   *   <li>{@link RuleNodeDebugEventFilter#getDataSearch()}
   *   <li>{@link RuleNodeDebugEventFilter#getEntityId()}
   *   <li>{@link RuleNodeDebugEventFilter#getEntityType()}
   *   <li>{@link RuleNodeDebugEventFilter#getEventType()}
   *   <li>{@link RuleNodeDebugEventFilter#getMetadataSearch()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgDirectionType()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgId()}
   *   <li>{@link RuleNodeDebugEventFilter#getMsgType()}
   *   <li>{@link RuleNodeDebugEventFilter#getRelationType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeDebugEventFilter actualRuleNodeDebugEventFilter = new RuleNodeDebugEventFilter();
    actualRuleNodeDebugEventFilter.setDataSearch("Data Search");
    actualRuleNodeDebugEventFilter.setEntityId("42");
    actualRuleNodeDebugEventFilter.setEntityType("Entity Type");
    actualRuleNodeDebugEventFilter.setMetadataSearch("Metadata Search");
    actualRuleNodeDebugEventFilter.setMsgDirectionType("Msg Direction Type");
    actualRuleNodeDebugEventFilter.setMsgId("42");
    actualRuleNodeDebugEventFilter.setMsgType("Msg Type");
    actualRuleNodeDebugEventFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRuleNodeDebugEventFilter.toString();
    String actualDataSearch = actualRuleNodeDebugEventFilter.getDataSearch();
    String actualEntityId = actualRuleNodeDebugEventFilter.getEntityId();
    String actualEntityType = actualRuleNodeDebugEventFilter.getEntityType();
    EventType actualEventType = actualRuleNodeDebugEventFilter.getEventType();
    String actualMetadataSearch = actualRuleNodeDebugEventFilter.getMetadataSearch();
    String actualMsgDirectionType = actualRuleNodeDebugEventFilter.getMsgDirectionType();
    String actualMsgId = actualRuleNodeDebugEventFilter.getMsgId();
    String actualMsgType = actualRuleNodeDebugEventFilter.getMsgType();

    // Assert that nothing has changed
    assertEquals("42", actualEntityId);
    assertEquals("42", actualMsgId);
    assertEquals("Data Search", actualDataSearch);
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Metadata Search", actualMetadataSearch);
    assertEquals("Msg Direction Type", actualMsgDirectionType);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRuleNodeDebugEventFilter.getRelationType());
    assertEquals("RuleNodeDebugEventFilter(msgDirectionType=Msg Direction Type, entityId=42, entityType=Entity Type,"
        + " msgId=42, msgType=Msg Type, relationType=Relation Type, dataSearch=Data Search, metadataSearch=Metadata"
        + " Search)", actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_NODE, actualEventType);
    assertFalse(actualRuleNodeDebugEventFilter.isError());
  }
}
