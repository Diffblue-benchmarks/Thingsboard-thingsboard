package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlarmCommentDiffblueTest {
  /**
   * Test {@link AlarmComment#getCreatedTime()}.
   * <p>
   * Method under test: {@link AlarmComment#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AlarmComment()).getCreatedTime());
  }

  /**
   * Test {@link AlarmComment#AlarmComment(AlarmComment)}.
   * <p>
   * Method under test: {@link AlarmComment#AlarmComment(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmComment(AlarmComment)")
  void testNewAlarmComment() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertEquals(alarmComment, new AlarmComment(alarmComment));
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Given {@link AlarmComment#AlarmComment()} Comment is Instance.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); given AlarmComment() Comment is Instance; then return empty string")
  void testGetName_givenAlarmCommentCommentIsInstance_thenReturnEmptyString() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(MissingNode.getInstance());

    // Act and Assert
    assertEquals("", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[]'")
  void testGetName_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals("[]", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code [null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[null]'")
  void testGetName_thenReturnNull() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[null]", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code [null,null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[null,null]'")
  void testGetName_thenReturnNullNull() {
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
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code ["Pojo",null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[\"Pojo\",null]'")
  void testGetName_thenReturnPojoNull() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.addPOJO("Pojo");
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[\"Pojo\",null]", alarmComment.getName());
  }
}
