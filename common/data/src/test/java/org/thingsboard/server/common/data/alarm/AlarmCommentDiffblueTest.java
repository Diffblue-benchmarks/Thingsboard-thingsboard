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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;

class AlarmCommentDiffblueTest {
  /**
   * Method under test: {@link AlarmComment#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AlarmComment()).getCreatedTime());
  }

  /**
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  void testGetName() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(MissingNode.getInstance());

    // Act and Assert
    assertEquals("", alarmComment.getName());
  }

  /**
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals("[]", alarmComment.getName());
  }

  /**
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  void testGetName3() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[null]", alarmComment.getName());
  }

  /**
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  void testGetName4() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.add(MissingNode.getInstance());
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[null,null]", alarmComment.getName());
  }

  /**
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  void testGetName5() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.addPOJO("Pojo");
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[\"Pojo\",null]", alarmComment.getName());
  }

  /**
   * Method under test: {@link AlarmComment#AlarmComment(AlarmComment)}
   */
  @Test
  void testNewAlarmComment() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertEquals(alarmComment, new AlarmComment(alarmComment));
  }
}
